package com.vainolo.phd.opm.interpreter.inzoomedprocessinstance;

import static com.vainolo.phd.opm.utilities.OPMLogger.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vainolo.phd.opm.interpreter.OPMParameter;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

public class OPMInZoomedProcessResultStorer {

  private OPDAnalyzer analyzer;
  private OPMInZoomedProcessInstanceHeap heap;

  public static OPMInZoomedProcessResultStorer createResultStorer(OPDAnalyzer analyzer,
      OPMInZoomedProcessInstanceHeap heap) {
    OPMInZoomedProcessResultStorer storer = new OPMInZoomedProcessResultStorer();
    storer.analyzer = analyzer;
    storer.heap = heap;
    return storer;
  }

  public void extractResultsToVariables(OPMProcess process, OPMProcessInstance instance) {
    Map<String, OPMObject> namedResults = Maps.newHashMap();
    List<OPMObject> anonymousResultObjects = Lists.newArrayList();

    for(OPMLink resultLink : analyzer.findOutgoingDataLinks(process)) {
      if(resultLink.getCenterDecoration() == null || "".equals(resultLink.getCenterDecoration())) {
        anonymousResultObjects.add(analyzer.getObject(resultLink));
      } else {
        namedResults.put(resultLink.getCenterDecoration(), analyzer.getObject(resultLink));
      }
    }

    logFine("Found {0} anonymous results and {1} named results.", anonymousResultObjects.size(), namedResults.size());

    // First extract named results
    List<String> outgoingParameters = Lists.transform(instance.getOutgoingParameterNames(),
        new Function<OPMParameter, String>() {
          @Override
          public String apply(OPMParameter input) {
            return input.getName();
          }
        });
    for(String namedResult : namedResults.keySet()) {
      heap.setVariable(namedResults.get(namedResult), instance.getArgument(namedResult));
      outgoingParameters.remove(namedResult);
    }

    // Now extract where the variable in the instance matched the result object
    Iterator<OPMObject> anonymousResultsIterator = anonymousResultObjects.iterator();
    while(anonymousResultsIterator.hasNext()) {
      OPMObject resultObject = anonymousResultsIterator.next();
      if(instance.getOutgoingParameterNames().contains(resultObject.getName())) {
        if(instance.getArgument(resultObject.getName()) != null) {
          heap.setVariable(resultObject, instance.getArgument(resultObject.getName()));
          anonymousResultsIterator.remove();
        }
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
