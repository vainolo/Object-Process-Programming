package com.vainolo.phd.opm.interpreter.inzoomedprocessinstance;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzerImpl;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

public class OPMInZoomedProcessArgumentLoader {
  private OPDAnalyzer analyzer = new OPDAnalyzerImpl();
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
    return loader;
  }

  public void loadInstanceArguments(OPMProcess process, OPMProcessInstance instance) {
    Map<String, OPMObject> namedArguments = Maps.newHashMap();
    List<OPMObject> anonymousArguments = Lists.newArrayList();

    for(OPMLink incomingDataLink : analyzer.findIncomingDataLinks(process)) {
      if(incomingDataLink.getCenterDecoration() == null || "".equals(incomingDataLink.getCenterDecoration())) {
        anonymousArguments.add(analyzer.getObject(incomingDataLink));
      } else {
        namedArguments.put(incomingDataLink.getCenterDecoration(), analyzer.getObject(incomingDataLink));
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

  private void loadNamedArguments(OPMProcessInstance instance, Map<String, OPMObject> namedArguments) {
    for(String parameterName : namedArguments.keySet()) {
      instance.setArgument(parameterName, heap.getVariable(namedArguments.get(parameterName)));
    }
  }

  private void loadAnonymousArguments(OPMProcessInstance instance, List<OPMObject> arguments,
      List<String> availableParameters) {

    Iterator<String> availableParametersIterator = availableParameters.iterator();
    while(availableParametersIterator.hasNext()) {
      String parameterName = availableParametersIterator.next();
      if(arguments.contains(parameterName)) {
        OPMObjectInstance argument = heap.getVariable(arguments.get(arguments.indexOf(parameterName)));
        instance.setArgument(parameterName, argument);
        arguments.remove(parameterName);
        availableParametersIterator.remove();
      }
    }

    // now remaining arguments using available parameter names
    availableParametersIterator = availableParameters.iterator();
    while(availableParametersIterator.hasNext()) {
      String parameterName = availableParametersIterator.next();
      instance.setArgument(parameterName, heap.getVariable(arguments.remove(0)));
      availableParametersIterator.remove();
    }

    // In case there are left arguments, pass them as parameters with default
    // names
    if(arguments.size() > 0) {
      int argNumber = 0;
      for(OPMObject argument : arguments) {
        instance.setArgument("arg" + argNumber, heap.getVariable(argument));
        argNumber++;
      }
    }
  }
}
