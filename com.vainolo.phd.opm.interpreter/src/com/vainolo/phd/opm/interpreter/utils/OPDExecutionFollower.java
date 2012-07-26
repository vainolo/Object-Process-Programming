/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.utils;

import java.util.List;
import java.util.Set;

import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.collect.Sets;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;

/**
 * Follows the execution of an OPD and helps find the next executable process depending on the state of the execution.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 10 Jul 2012
 * 
 */
public class OPDExecutionFollower {

  private final OPMObjectProcessDiagram opd;
  private final DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag;

  private final Set<OPMProcess> skippedProcesses = Sets.newHashSet();
  private final Set<OPMProcess> executedProcesses = Sets.newHashSet();

  public OPDExecutionFollower(final OPMObjectProcessDiagram opd) {
    this.opd = opd;
    opdDag = OPDAnalyzer.createOPDDAG(opd);
  }

  public void addSkippedProcess(final OPMProcess process) {
    skippedProcesses.add(process);
  }

  public void addExecutedProcess(final OPMProcess process) {
    executedProcesses.add(process);
  }

  /**
   * <p>
   * Find all processes that should follow when the given process finishes, taking into account all processes that
   * already finished execution.
   * </p>
   * 
   * @param process
   *          that finished executing.
   * @return all the processes that should be executed, as defined by OPM executable semantics, considering all other
   *         processes that have already finished.
   */
  public Set<OPMProcess> findNextProcessesToExecute(final OPMProcess process) {
    final List<OPMProcess> followingProcesses = OPDAnalyzer.calculateFollowingProcesses(opdDag, process);
    final Set<OPMProcess> retVal = Sets.newHashSet();
    for(OPMProcess followingProcess : followingProcesses) {
      Set<OPMProcess> requiredProcesses = OPDAnalyzer.calculateRequiredProcesses(opdDag, followingProcess);
      if(!(Sets.difference(requiredProcesses, Sets.union(skippedProcesses, executedProcesses)).size() > 0)) {
        retVal.add(followingProcess);
      }
    }

    return retVal;
  }
}
