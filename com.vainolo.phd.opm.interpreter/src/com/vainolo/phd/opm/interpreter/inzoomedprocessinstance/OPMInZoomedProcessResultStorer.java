package com.vainolo.phd.opm.interpreter.inzoomedprocessinstance;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

public class OPMInZoomedProcessResultStorer {

  private OPDAnalyzer analyzer;
  private OPMInZoomedProcessInstanceHeap heap;
  private OPMInZoomedProcessExecutionState executionState;

  public static OPMInZoomedProcessResultStorer createResultStorer(OPDAnalyzer analyzer,
      OPMInZoomedProcessExecutionState executionState, OPMInZoomedProcessInstanceHeap heap) {
    OPMInZoomedProcessResultStorer storer = new OPMInZoomedProcessResultStorer();
    storer.analyzer = analyzer;
    storer.executionState = executionState;
    storer.heap = heap;
    return storer;
  }

  public void extractResultsToVariables(OPMProcessInstance instance) {
    Map<String, OPMObject> namedResults = Maps.newHashMap();
    List<OPMObject> anonymousResultObjects = Lists.newArrayList();

    for(OPMLink resultLink : analyzer.findOutgoingDataLinks(executionState.getProcess(instance))) {
      if(resultLink.getCenterDecoration() == null || "".equals(resultLink.getCenterDecoration())) {
        anonymousResultObjects.add(analyzer.getObject(resultLink));
      } else {
        namedResults.put(resultLink.getCenterDecoration(), analyzer.getObject(resultLink));
      }
    }

    // First extract named results
    List<String> outgoingParameters = instance.getOutgoingParameterNames();
    for(String namedResult : namedResults.keySet()) {
      heap.setVariable(namedResults.get(namedResult), instance.getArgument(namedResult));
      outgoingParameters.remove(namedResult);
    }

    // Now extract where the variable in the instance matched the result object
    Iterator<OPMObject> anonymousResultsIterator = anonymousResultObjects.iterator();
    while(anonymousResultsIterator.hasNext()) {
      OPMObject resultObject = anonymousResultsIterator.next();
      if(instance.getArgument(resultObject.getName()) != null) {
        heap.setVariable(resultObject, instance.getArgument(resultObject.getName()));
        anonymousResultsIterator.remove();
      }
    }

    // Now extract all remaining outgoing parameters to the remaining anonymous
    // result objects
    int remainingResults = (outgoingParameters.size() < anonymousResultObjects.size()) ? outgoingParameters.size()
        : anonymousResultObjects.size();
    for(int i = 0; i < remainingResults; i++) {
      heap.setVariable(anonymousResultObjects.get(i), instance.getArgument(outgoingParameters.get(i)));
    }
  }
}