/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.analysis;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;

import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalysis;

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
        final OPMProcess zoomedInProcess = OPDAnalysis.findInZoomedProcess(opd);
        processes = OPMAnalysis.findContainedProcesses(zoomedInProcess);
        break;
      default:
        throw new RuntimeException("Method cannot handle opd of kind " + opd.getKind());
    }
    return processes;
  }

}
