/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.analysis;

import java.util.Collection;

import com.google.common.base.Preconditions;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;

import static com.google.common.base.Preconditions.checkNotNull;

public class OPMObjectProcessDiagramAnalysis {

  /**
   * Find the processes that should be executed when the OPD is executed. For a system diagram, these are all the
   * processes directly below the OPD. For compound processes, these are the processes inside the zoomed-in process
   * named as the OPD.
   * 
   * @param opd
   *          where the processes exist.
   * @return the executable processes in the OPD.
   */
  static Collection<OPMProcess> findExecutableProcesses(OPMObjectProcessDiagram opd) {
    checkNotNull(opd);
    Collection<OPMProcess> processes = null;
    switch(opd.getKind()) {
      case SYSTEM:
        processes = OPMAnalysis.findContainedProcesses(opd);
        break;
      case COMPOUND:
        final OPMProcess zoomedInProcess = findZoomedInProcess(opd);
        processes = OPMAnalysis.findContainedProcesses(zoomedInProcess);
        break;
      default:
        throw new RuntimeException("Method cannot handle opd of kind " + opd.getKind());
    }
    return processes;
  }

  /**
   * Find the in-zoomed process in an OPD. The function assumes that the opd contains only one process, which is the
   * in-zoomed process.
   * 
   * @param opd
   *          where the process is located
   * @return the (only) process that is directly on the OPD, which is the in-zoomed process.
   */
  static OPMProcess findZoomedInProcess(OPMObjectProcessDiagram opd) {
    Preconditions.checkNotNull(opd);
    final Collection<OPMProcess> processes = OPMAnalysis.findContainedProcesses(opd);
    if(processes.size() > 1)
      throw new RuntimeException("A compound OPD can have only one main process. Found " + processes.size() + ". ");
    if(processes.size() == 0)
      throw new RuntimeException("A compound OPD must have one main process. Found none.");

    return processes.iterator().next();
  }
}
