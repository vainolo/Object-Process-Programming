package com.vainolo.phd.opm.interpreter.inzoomedprocessinstance;

import java.util.Set;

import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.collect.Sets;
import com.vainolo.phd.opm.model.OPMProcess;

public class OPMInZoomedProcessExecutionHelper {

  public OPMInZoomedProcessExecutionHelper() {
  }

  /**
   * Calculate the set of processes that can be made waiting or ready. This is
   * done by fetching all processes that follow the given one, and then checking
   * that none of their dependent processes are waiting or ready (and may be
   * executing)
   * 
   * @param process
   *          that finished executing. d * @return processes that can be added
   *          to the waiting or ready queue.
   * @param opdDag
   * @param executionState
   */
  public Set<OPMProcess> calculateFollowingProcesses(OPMProcess process,
      DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag, OPMInZoomedProcessExecutionState executionState) {
    Set<OPMProcess> newWaitingProcesses = Sets.newHashSet();
    Set<DefaultEdge> outgoingEdges = opdDag.outgoingEdgesOf(process);
    for(DefaultEdge outgoingEdge : outgoingEdges) {
      OPMProcess candidate = opdDag.getEdgeTarget(outgoingEdge);
      Set<DefaultEdge> incomingEdges = opdDag.incomingEdgesOf(candidate);
      boolean hasDependencies = false;
      for(DefaultEdge incomingEdge : incomingEdges) {
        if(executionState.getWaitingProcesses().contains(opdDag.getEdgeSource(incomingEdge))
            || executionState.getReadyProcesses().contains(opdDag.getEdgeSource(incomingEdge))) {
          hasDependencies = true;
          break;
        }
      }
      if(!hasDependencies)
        newWaitingProcesses.add(candidate);
    }
    return newWaitingProcesses;
  }
}
