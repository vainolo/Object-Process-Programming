package com.vainolo.phd.opp.interpreter.inzoomedprocessinstance;

import static com.vainolo.phd.opp.utilities.OPPLogger.logFine;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstanceValueAnalyzer;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.utilities.analysis.OPPOPDAnalyzer;

public class OPPInZoomedProcessArgumentHandler {
  private OPPOPDAnalyzer analyzer = new OPPOPDAnalyzer();
  private OPPObjectInstanceValueAnalyzer valueAnalyzer;
  private OPPInZoomedProcessInstanceHeap heap;

  public OPPInZoomedProcessArgumentHandler(OPPOPDAnalyzer analyzer, OPPInZoomedProcessInstanceHeap heap) {
    this.analyzer = analyzer;
    this.heap = heap;
    this.valueAnalyzer = new OPPObjectInstanceValueAnalyzer();
  }

  public void loadInstanceArguments(OPPProcess process, OPPProcessInstance instance) {
    Map<String, OPMArgument> namedArguments = Maps.newHashMap();
    List<OPMArgument> anonymousArguments = Lists.newArrayList();

    for(OPPLink incomingDataLink : analyzer.findIncomingDataLinks(process)) {
      OPMArgument argument = new OPMArgument(analyzer.getObject(incomingDataLink));
      if(incomingDataLink.getCenterDecoration() == null || "".equals(incomingDataLink.getCenterDecoration())) {
        anonymousArguments.add(argument);
      } else if(incomingDataLink.getCenterDecoration().contains(",")) {
        argument.isCollectionElement = true;
        String argName = incomingDataLink.getCenterDecoration().split(",")[0];
        String collectionReference = incomingDataLink.getCenterDecoration().split(",")[1];
        if(valueAnalyzer.isNumericalLiteral(collectionReference)) {
          argument.collectionElementIndex = valueAnalyzer.parseNumericalLiteral(collectionReference);
        } else {
          argument.collectionElementName = collectionReference;
        }
        if("".equals(argName)) {
          anonymousArguments.add(argument);
        } else {
          namedArguments.put(argName, argument);
        }
      } else {
        namedArguments.put(incomingDataLink.getCenterDecoration(), argument);
      }
    }

    logFine("Found {0} anonymous arguments and {1} named arguments.", anonymousArguments.size(), namedArguments.size());

    List<String> availableParametersNames = Lists.transform(instance.getIncomingParameterNames(),
        new Function<OPPParameter, String>() {
          @Override
          public String apply(OPPParameter input) {
            return input.getName();
          }
        });
    loadNamedArguments(instance, namedArguments);
    availableParametersNames.removeAll(namedArguments.keySet());

    loadAnonymousArguments(instance, anonymousArguments, availableParametersNames);
  }

  private void loadNamedArguments(OPPProcessInstance instance, Map<String, OPMArgument> namedArguments) {
    for(String parameterName : namedArguments.keySet()) {
      instance.setArgument(parameterName, getValue(namedArguments.get(parameterName)));
    }
  }

  private void loadAnonymousArguments(OPPProcessInstance instance, List<OPMArgument> arguments,
      List<String> availableParameters) {

    // First arguments who's variable names matches the parameter name
    Iterator<String> availableParametersIterator = availableParameters.iterator();
    while(availableParametersIterator.hasNext()) {
      String parameterName = availableParametersIterator.next();
      if(arguments.contains(parameterName)) {
        OPPObjectInstance argument = getValue(arguments.get(arguments.indexOf(parameterName)));
        instance.setArgument(parameterName, argument);
        arguments.remove(parameterName);
        availableParametersIterator.remove();
      }
    }

    // now remaining arguments using available parameter names
    availableParametersIterator = availableParameters.iterator();
    while(availableParametersIterator.hasNext()) {
      String parameterName = availableParametersIterator.next();
      instance.setArgument(parameterName, getValue(arguments.remove(0)));
      availableParametersIterator.remove();
    }

    // In case there are left arguments, pass them as parameters with default
    // names
    if(arguments.size() > 0) {
      int argNumber = 0;
      for(OPMArgument argument : arguments) {
        instance.setArgument("arg" + argNumber, getValue(argument));
        argNumber++;
      }
    }
  }

  public void extractResultsToVariables(OPPProcess process, OPPProcessInstance instance) {
    Map<String, OPMArgument> namedResults = Maps.newHashMap();
    List<OPMArgument> anonymousResult = Lists.newArrayList();

    for(OPPLink resultLink : analyzer.findOutgoingDataLinks(process)) {
      OPMArgument argument = new OPMArgument(analyzer.getObject(resultLink));
      if(resultLink.getCenterDecoration() == null || "".equals(resultLink.getCenterDecoration())) {
        anonymousResult.add(argument);
      } else if(resultLink.getCenterDecoration().contains(",")) {
        argument.isCollectionElement = true;
        String argName = resultLink.getCenterDecoration().split(",")[0];
        String collectionReference = resultLink.getCenterDecoration().split(",")[1];
        if(valueAnalyzer.isNumericalLiteral(collectionReference)) {
          argument.collectionElementIndex = valueAnalyzer.parseNumericalLiteral(collectionReference);
        } else {
          argument.collectionElementName = collectionReference;
        }
        if("".equals(argName)) {
          anonymousResult.add(argument);
        } else {
          namedResults.put(argName, argument);
        }
      } else {
        namedResults.put(resultLink.getCenterDecoration(), argument);
      }
    }

    logFine("Found {0} anonymous results and {1} named results.", anonymousResult.size(), namedResults.size());

    // First extract named results
    List<String> outgoingParametersNames = Lists.transform(instance.getOutgoingParameterNames(),
        new Function<OPPParameter, String>() {
          @Override
          public String apply(OPPParameter input) {
            return input.getName();
          }
        });
    for(String namedResult : namedResults.keySet()) {
      OPMArgument argument = namedResults.get(namedResult);
      if(argument.object.isCollection()) {
        setCollectionElementValue(argument, instance.getArgument(namedResult));
      } else {
        heap.setVariable(argument.object, instance.getArgument(namedResult));
      }
      outgoingParametersNames.remove(namedResult);
    }

    // Now extract where the variable in the instance matched the result object
    Iterator<OPMArgument> anonymousResultsIterator = anonymousResult.iterator();
    while(anonymousResultsIterator.hasNext()) {
      OPMArgument argument = anonymousResultsIterator.next();
      if(instance.getOutgoingParameterNames().contains(argument.object.getName())) {
        if(instance.getArgument(argument.object.getName()) != null) {
          if(argument.object.isCollection()) {
            setCollectionElementValue(argument, instance.getArgument(argument.object.getName()));
          } else {
            heap.setVariable(argument.object, instance.getArgument(argument.object.getName()));
          }
          anonymousResultsIterator.remove();
        }
      }
    }

    // Now extract all remaining outgoing parameters to the remaining anonymous
    // result objects
    int remainingResults = (outgoingParametersNames.size() < anonymousResult.size()) ? outgoingParametersNames.size()
        : anonymousResult.size();
    for(int i = 0; i < remainingResults; i++) {
      OPMArgument argument = anonymousResult.get(i);
      if(argument.object.isCollection()) {
        setCollectionElementValue(argument, instance.getArgument(outgoingParametersNames.get(i)));
      } else {
        heap.setVariable(argument.object, instance.getArgument(outgoingParametersNames.get(i)));
      }
    }
  }

  public void setCollectionElementValue(OPMArgument argument, OPPObjectInstance value) {
    OPPObjectInstance currentValue = heap.getVariable(argument.object);
    if(currentValue == null) {
      currentValue = OPPObjectInstance.createCollectionInstace();
    }
    if(argument.isCollectionElement) {
      if(argument.collectionElementName != null) {
        currentValue.putCollectionElement(argument.collectionElementName, value);
      } else if(argument.collectionElementIndex != null) {
        currentValue.putCollectionElementAtIndex(argument.collectionElementIndex.intValue(), value);
      }
    } else {
      currentValue.appendCollectionElement(value);
    }
    heap.setVariable(argument.object, currentValue);
  }

  private OPPObjectInstance getValue(OPMArgument argument) {
    if(!argument.isCollectionElement) {
      return heap.getVariable(argument.object);
    } else {
      OPPObjectInstance instance = heap.getVariable(argument.object);
      if(argument.collectionElementName != null) {
        return instance.getCollectionElement(argument.collectionElementName);
      } else if(argument.collectionElementIndex != null) {
        return instance.getCollectionElementAtIndex(argument.collectionElementIndex.intValue());
      } else {
        throw new IllegalStateException("Referenced collection element with no index or name.");
      }
    }
  }

  class OPMArgument {
    public BigDecimal collectionElementIndex;
    public String collectionElementName;
    private OPPObject object;
    private boolean isCollectionElement = false;

    public OPMArgument(OPPObject object) {
      this.object = object;
    }
  }
}
