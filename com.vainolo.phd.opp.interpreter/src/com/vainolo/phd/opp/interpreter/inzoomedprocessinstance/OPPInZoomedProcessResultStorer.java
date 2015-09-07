package com.vainolo.phd.opp.interpreter.inzoomedprocessinstance;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.utilities.analysis.OPPOPDAnalyzer;

public class OPPInZoomedProcessResultStorer {

  private OPPOPDAnalyzer analyzer;
  private OPPInZoomedProcessInstanceHeap heap;

  public static OPPInZoomedProcessResultStorer createResultStorer(OPPOPDAnalyzer analyzer,
      OPPInZoomedProcessInstanceHeap heap) {
    OPPInZoomedProcessResultStorer storer = new OPPInZoomedProcessResultStorer();
    storer.analyzer = analyzer;
    storer.heap = heap;
    return storer;
  }

  public void extractResultsToVariables(OPPProcess process, OPPProcessInstance instance) {
    Map<String, OPPObject> namedResults = Maps.newHashMap();
    List<OPPObject> anonymousResultObjects = Lists.newArrayList();

    for(OPPLink resultLink : analyzer.findOutgoingDataLinks(process)) {
      if(resultLink.getCenterDecoration() == null || "".equals(resultLink.getCenterDecoration())) {
        anonymousResultObjects.add(analyzer.getObject(resultLink));
      } else {
        namedResults.put(resultLink.getCenterDecoration(), analyzer.getObject(resultLink));
      }
    }

    logFine("Found {0} anonymous results and {1} named results.", anonymousResultObjects.size(), namedResults.size());

    // First extract named results
    List<String> outgoingParameters = Lists.transform(instance.getOutgoingParameters(),
        new Function<OPPParameter, String>() {
          @Override
          public String apply(OPPParameter input) {
            return input.getName();
          }
        });
    for(String namedResult : namedResults.keySet()) {
      heap.setVariable(namedResults.get(namedResult), instance.getArgument(namedResult));
      outgoingParameters.remove(namedResult);
    }

    // Now extract where the variable in the instance matched the result object
    Iterator<OPPObject> anonymousResultsIterator = anonymousResultObjects.iterator();
    while(anonymousResultsIterator.hasNext()) {
      OPPObject resultObject = anonymousResultsIterator.next();
      if(instance.getOutgoingParameters().contains(resultObject.getName())) {
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
