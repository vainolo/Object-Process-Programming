package com.vainolo.phd.opp.interpreter.inzoomedprocessinstance;

import static com.vainolo.phd.opp.utilities.OPPLogger.logFine;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPRuntimeException;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.utilities.analysis.OPPOPDAnalyzer;

public class OPPInZoomedProcessArgumentHandler {
  private OPPOPDAnalyzer analyzer = new OPPOPDAnalyzer();
  private OPPInZoomedProcessInstanceHeap heap;

  public OPPInZoomedProcessArgumentHandler(OPPOPDAnalyzer analyzer, OPPInZoomedProcessInstanceHeap heap) {
    this.analyzer = analyzer;
    this.heap = heap;
  }

  public void loadInstanceArguments(OPPProcess process, OPPProcessInstance instance) {
    Map<String, OPPArgument> namedArguments = Maps.newHashMap();
    List<OPPArgument> anonymousArguments = Lists.newArrayList();

    for(OPPLink incomingDataLink : analyzer.findIncomingDataLinks(process)) {
      OPPArgument argument = new OPPArgument(analyzer.getObject(incomingDataLink));
      if(incomingDataLink.getCenterDecoration() == null || "".equals(incomingDataLink.getCenterDecoration())) {
        anonymousArguments.add(argument);
      } else if(incomingDataLink.getCenterDecoration().contains(",")) {
        throw new OPPRuntimeException("Argument modifiers are not supported.");
      } else {
        namedArguments.put(incomingDataLink.getCenterDecoration(), argument);
      }
    }

    logFine("Found {0} anonymous arguments and {1} named arguments.", anonymousArguments.size(), namedArguments.size());

    List<String> availableParametersNames = instance.getIncomingParameters().stream().map(param -> param.getName())
        .collect(Collectors.toList());
    loadNamedArguments(instance, namedArguments);
    availableParametersNames.removeAll(namedArguments.keySet());

    loadAnonymousArguments(instance, anonymousArguments, availableParametersNames);
  }

  private void loadNamedArguments(OPPProcessInstance instance, Map<String, OPPArgument> namedArguments) {
    for(String parameterName : namedArguments.keySet()) {
      instance.setArgument(parameterName, getValue(namedArguments.get(parameterName)));
    }
  }

  private void loadAnonymousArguments(OPPProcessInstance instance, List<OPPArgument> arguments,
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
      for(OPPArgument argument : arguments) {
        instance.setArgument("arg" + argNumber, getValue(argument));
        argNumber++;
      }
    }
  }

  public void extractResultsToVariables(OPPProcess process, OPPProcessInstance instance) {
    Map<String, OPPArgument> namedResults = Maps.newHashMap();
    List<OPPArgument> anonymousResult = Lists.newArrayList();

    for(OPPLink resultLink : analyzer.findOutgoingDataLinks(process)) {
      OPPArgument argument = new OPPArgument(analyzer.getObject(resultLink));
      if(resultLink.getCenterDecoration() == null || "".equals(resultLink.getCenterDecoration())) {
        anonymousResult.add(argument);
      } else if(resultLink.getCenterDecoration().contains(",")) {
        throw new OPPRuntimeException("Argument modifiers are not supported.");
      } else {
        namedResults.put(resultLink.getCenterDecoration(), argument);
      }
    }

    logFine("Found {0} anonymous results and {1} named results.", anonymousResult.size(), namedResults.size());

    // First extract named results
    List<String> outgoingParametersNames = instance.getOutgoingParameters().stream().map(p -> p.getName())
        .collect(Collectors.toList());
    for(String namedResult : namedResults.keySet()) {
      setValue(namedResults.get(namedResult), instance.getArgument(namedResult));
      outgoingParametersNames.remove(namedResult);
    }

    // Then extract results where the variable in the instance matches the
    // result object
    Iterator<OPPArgument> anonymousResultsIterator = anonymousResult.iterator();
    while(anonymousResultsIterator.hasNext()) {
      OPPArgument argument = anonymousResultsIterator.next();
      if(instance.getOutgoingParameters().contains(argument.object.getName())) {
        if(instance.getArgument(argument.object.getName()) != null) {
          setValue(argument, instance.getArgument(argument.object.getName()));
          anonymousResultsIterator.remove();
        }
      }
    }

    // Finally, extract all remaining outgoing parameters to the remaining
    // anonymous result objects.
    for(int i = 0; i < anonymousResult.size(); i++) {
      setValue(anonymousResult.get(i), instance.getArgument(outgoingParametersNames.get(i)));
    }
  }

  private void setValue(OPPArgument argument, OPPObjectInstance objectInstance) {
    if(argument.hasModifier) {
      throw new OPPRuntimeException("Argument modifiers are not supported.");
    } else {
      heap.setVariable(argument.object, objectInstance);
    }
  }

  private OPPObjectInstance getValue(OPPArgument argument) {
    if(!argument.hasModifier) {
      return heap.getVariable(argument.object);
    } else {
      throw new OPPRuntimeException("Argument modifiers are not supported.");
    }
  }

  /**
   * Representation of an argument that is passed to a
   * {@link OPPProcessInstance}. If the argument is passed to the instance using
   * a modifier, this modifier is stored here and is applied only when the value
   * of the argument is retrieved.
   */
  class OPPArgument {
    private OPPObject object;
    public BigDecimal collectionElementIndex;
    public boolean hasModifier = false;
    public String modifier;

    public OPPArgument(OPPObject object) {
      this.object = object;
    }
  }
}
