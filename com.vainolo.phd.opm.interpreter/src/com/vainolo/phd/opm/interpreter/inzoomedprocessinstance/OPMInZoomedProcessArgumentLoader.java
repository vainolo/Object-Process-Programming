package com.vainolo.phd.opm.interpreter.inzoomedprocessinstance;

import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

public class OPMInZoomedProcessArgumentLoader {
  private OPDAnalyzer analyzer = new OPDAnalyzer();

  public void loadInstanceArguments(OPMProcessInstance instance, OPMInZoomedProcessExecutionState executionState,
      OPMInZoomedProcessInstanceHeap heap) {
    for(OPMLink incomingDataLink : analyzer.findIncomingDataLinks(executionState.getProcess(instance))) {
      OPMObject argument = analyzer.getObject(incomingDataLink);
      if(incomingDataLink.getCenterDecoration() == null || "".equals(incomingDataLink.getCenterDecoration())) {
        instance.setArgument(argument.getName(), heap.getVariable(argument));
      } else {
        instance.setArgument(incomingDataLink.getCenterDecoration(), heap.getVariable(argument));
      }
    }
  }
}
