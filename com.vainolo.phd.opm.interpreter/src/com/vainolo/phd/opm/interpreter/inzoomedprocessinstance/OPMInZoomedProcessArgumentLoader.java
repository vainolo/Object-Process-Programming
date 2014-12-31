package com.vainolo.phd.opm.interpreter.inzoomedprocessinstance;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;
import com.vainolo.phd.opm.interpreter.OPMObjectInstanceValueAnalyzer;
import com.vainolo.phd.opm.interpreter.OPMObjectInstanceValueAnalyzerImpl;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzerImpl;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

public class OPMInZoomedProcessArgumentLoader {
  private OPDAnalyzer analyzer = new OPDAnalyzerImpl();
  private OPMObjectInstanceValueAnalyzer valueAnalyzer;
  private OPMInZoomedProcessExecutionState executionState;
  private OPMInZoomedProcessInstanceHeap heap;

  private OPMInZoomedProcessArgumentLoader() {
  };

  public static OPMInZoomedProcessArgumentLoader createArgumentLoader(OPDAnalyzer analyzer,
      OPMInZoomedProcessExecutionState executionState, OPMInZoomedProcessInstanceHeap heap) {
    OPMInZoomedProcessArgumentLoader loader = new OPMInZoomedProcessArgumentLoader();
    loader.analyzer = analyzer;
    loader.executionState = executionState;
    loader.heap = heap;
    loader.valueAnalyzer = new OPMObjectInstanceValueAnalyzerImpl();
    return loader;
  }

  public void loadInstanceArguments(OPMProcess process, OPMProcessInstance instance) {
    Map<String, OPMArgument> namedArguments = Maps.newHashMap();
    List<OPMArgument> anonymousArguments = Lists.newArrayList();

    for(OPMLink incomingDataLink : analyzer.findIncomingDataLinks(process)) {
      OPMArgument argument = new OPMArgument(analyzer.getObject(incomingDataLink));
      if(incomingDataLink.getCenterDecoration() == null || "".equals(incomingDataLink.getCenterDecoration())) {
        anonymousArguments.add(argument);
      } else if(incomingDataLink.getCenterDecoration().contains(",")) {
        argument.isCollectionElement = true;
        String argName = incomingDataLink.getCenterDecoration().split(",")[0];
        String collectionReference = incomingDataLink.getCenterDecoration().split(",")[1];
        if(valueAnalyzer.isStringLiteral(collectionReference)) {
          argument.collectionElementName = valueAnalyzer.parseStringLiteral(collectionReference);
        } else if(valueAnalyzer.isNumericalLiteral(collectionReference)) {
          argument.collectionElementIndex = valueAnalyzer.parseNumericalLiteral(collectionReference);
        } else {
          throw new IllegalStateException("Collection reference must be either a string or a number. Found "
              + collectionReference + ".");
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

    List<String> availableParameters = Lists.newArrayList(instance.getIncomingParameterNames());
    loadNamedArguments(instance, namedArguments);
    availableParameters.removeAll(namedArguments.keySet());

    loadAnonymousArguments(instance, anonymousArguments, availableParameters);
  }

  public void loadInstanceArguments(OPMProcessInstance instance) {
    loadInstanceArguments(executionState.getProcess(instance), instance);
  }

  private void loadNamedArguments(OPMProcessInstance instance, Map<String, OPMArgument> namedArguments) {
    for(String parameterName : namedArguments.keySet()) {
      instance.setArgument(parameterName, getValue(namedArguments.get(parameterName)));
    }
  }

  private void loadAnonymousArguments(OPMProcessInstance instance, List<OPMArgument> arguments,
      List<String> availableParameters) {

    Iterator<String> availableParametersIterator = availableParameters.iterator();
    while(availableParametersIterator.hasNext()) {
      String parameterName = availableParametersIterator.next();
      if(arguments.contains(parameterName)) {
        OPMObjectInstance argument = getValue(arguments.get(arguments.indexOf(parameterName)));
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

  private OPMObjectInstance getValue(OPMArgument argument) {
    if(!argument.isCollectionElement) {
      return heap.getVariable(argument.object);
    } else {
      OPMObjectInstance instance = heap.getVariable(argument.object);
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
    private OPMObject object;
    private boolean isCollectionElement = false;

    public OPMArgument(OPMObject object) {
      this.object = object;
    }

  }
}
