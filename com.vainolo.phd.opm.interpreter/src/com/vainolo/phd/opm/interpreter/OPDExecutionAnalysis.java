/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jgrapht.alg.DirectedNeighborIndex;
import org.jgrapht.event.GraphEdgeChangeEvent;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph.CycleFoundException;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.vainolo.phd.opm.interpreter.utils.Parameter;
import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMPackage;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMState;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalysis;

/**
 * Various utilities used to execute an OPD.
 * 
 * @author vainolo
 * 
 */
public enum OPDExecutionAnalysis {
  INSTANCE;

  /**
   * <p>
   * Calculate which processes need to finish for the given process to execute.
   * </p>
   * 
   * @param opdDag
   *          the DAG of the OPD where the process is located.
   * @param process
   *          the process that wants to execute.
   * @return a set of processes that have to finish for the given process to
   *         execute.
   */
  public Set<OPMProcess> calculateRequiredProcesses(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag,
      final OPMProcess process) {
    Preconditions.checkArgument(opdDag != null);
    Preconditions.checkArgument(process != null);

    final Set<OPMProcess> retVal = Sets.newHashSet();
    for(DefaultEdge edge : opdDag.incomingEdgesOf(process)) {
      retVal.add(opdDag.getEdgeSource(edge));
    }

    return retVal;
  }

  /**
   * <p>
   * Calculate which processes can be executed when the provided process ends.
   * The returned processes may execute if they have no other predecessor
   * processes. Otherwise they must wait for all other predecessor processes to
   * end for them to execute.
   * </p>
   * 
   * @param opdDag
   *          the DAG of the OPD where the process is located.
   * @param process
   *          the process that has finished.
   * @return list of processes that are dependent on the current process for
   *         execution.
   */
  public Set<OPMProcess> calculateFollowingProcesses(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag,
      final OPMProcess process) {
    Preconditions.checkArgument(opdDag != null);
    Preconditions.checkArgument(process != null);
    final Set<OPMProcess> retVal = Sets.newHashSet();

    for(final DefaultEdge edge : opdDag.outgoingEdgesOf(process)) {
      retVal.add(opdDag.getEdgeTarget(edge));
    }

    return retVal;
  }

  /**
   * Calculate the processes that should be executed when the OPD is invoked.
   * These are the processes that have no predecessors in the OPD DAG.
   * 
   * @param opdDag
   *          the OPD DAG that is analyzed.
   * @return the processes that should be executed when the OPD is invoked.
   */
  public Set<OPMProcess> calculateInitialProcesses(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag) {
    Preconditions.checkArgument(opdDag != null, "OPD DAG cannot be null.");

    final Set<OPMProcess> retVal = Sets.newHashSet();

    for(final OPMProcess process : opdDag.vertexSet()) {
      if(opdDag.inDegreeOf(process) == 0) {
        retVal.add(process);
      }
    }

    return retVal;
  }

  /**
   * <p>
   * Create a DAG based on the process execution order of an
   * {@link OPMContainer}.
   * </p>
   * 
   * <p>
   * The execution order of an {@link OPMContainer} is defined by the location
   * of the processes inside the {@link OPMContainer}. When a process
   * <code>P1</code> is above another process <code>P2</code> (the lowest point
   * of <code>P1</code> is below the highest point of <code>P2</code>), then
   * <code>P2</code> is only executed after <code>P1</code> has finished
   * execution.
   * </p>
   * 
   * <p>
   * An {@link OPMContainer} can also contain special <em>invocation</em> links
   * that can change the execution order of the {@link OPMContainer}. They are
   * not taken into account in this DAG because they are explicit in the
   * diagram.
   * </p>
   * 
   * @param container
   *          to analyze
   * @return a Directed Acyclic Graph (DAG) that represents the execution order
   *         of the container.
   */
  public DirectedAcyclicGraph<OPMProcess, DefaultEdge> createContainerExecutionDAG(final OPMContainer opd) {
    final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag = new DirectedAcyclicGraph<OPMProcess, DefaultEdge>(
        DefaultEdge.class);

    createNodes(dag, opd);
    createExecutionOrderEdges(dag, opd);
    removeDuplicateEdges(dag);

    return dag;
  }

  /**
   * <p>
   * Remove duplicate edges that start at process <code>vertex</code>. This is
   * done as follows:
   * </p>
   * 
   * <pre>
   * for each successor v1 of vertex
   *   for each successor v2 of v1
   *     if there is an edge (vertex,v2), it can be removed.
   * </pre>
   * 
   * @param dag
   *          the DAG from which the edges are removed.
   * @param source
   *          the OPMProcess that is analyzed.
   */
  private void removeDuplicateEdges(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag, final OPMProcess source) {
    final DirectedNeighborIndex<OPMProcess, DefaultEdge> dni = new DirectedNeighborIndex<OPMProcess, DefaultEdge>(dag);
    final OPMProcess[] successors = dni.successorsOf(source).toArray(new OPMProcess[0]);

    for(final OPMProcess firstTarget : successors) {
      for(final OPMProcess secondTarget : successors) {
        removeDuplicateEdges(dag, source, dni, firstTarget, secondTarget);
      }
    }
  }

  private void removeDuplicateEdges(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag, final OPMProcess source,
      final DirectedNeighborIndex<OPMProcess, DefaultEdge> dni, final OPMProcess firstTarget,
      final OPMProcess secondTarget) {
    if(firstTarget.equals(secondTarget)) {
      return;
    }

    final DefaultEdge removedEdge;
    if(dni.successorsOf(firstTarget).contains(secondTarget)) {
      removedEdge = dag.removeEdge(source, secondTarget);
      if(removedEdge == null) {
        return;
      }
      final GraphEdgeChangeEvent<OPMProcess, DefaultEdge> event = new GraphEdgeChangeEvent<OPMProcess, DefaultEdge>(
          new Object(), GraphEdgeChangeEvent.EDGE_REMOVED, removedEdge);
      dni.edgeRemoved(event);
    }
  }

  /**
   * <p>
   * Remove duplicate edges in the DAG. The edge creation algorithm (see
   * {@link OPDExecutionAnalysis#createExecutionOrderEdges(DirectedAcyclicGraph, OPMObjectProcessDiagram)}
   * ) creates one edge for each process execution relation. But because process
   * execution order is transitive, there are edges that are redundant and can
   * be removed.
   * </p>
   * 
   * <p>
   * For example: if <code>P1</code> executes before <code>P2</code> and
   * <code>P2</code> executes before <code>P3</code> the algorithm will create
   * edges <code>(P1,P2)</code>, <code>(P1,P3)</code>, and <code>(P2,P3)</code>.
   * But the edge <code>(P1,P3)</code> is redundant since it the order is
   * already prescribed by the other two edges. Therefore it can be removed.
   * 
   * @param dag
   *          The DAG to analyze and remove edges.
   */
  private void removeDuplicateEdges(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag) {
    for(final OPMProcess vertex : dag.vertexSet()) {
      removeDuplicateEdges(dag, vertex);
    }
  }

  /**
   * Create the edges that drive the execution order of the {@link OPMContainer}
   * . Process <code>P1</code> will execute before process <code>P2</code> if
   * <code>P1</code>'s lowest border is below <code>P2</code>'s upper border.
   * 
   * @param dag
   *          the DAG where the edges will be added.
   * @param container
   *          the container where the processes are located.
   */
  private void createExecutionOrderEdges(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag,
      final OPMContainer container) {
    for(final OPMProcess process1 : OPDAnalysis.INSTANCE.findFirstLevelContainedProcesses(container)) {
      for(final OPMProcess process2 : OPDAnalysis.INSTANCE.findFirstLevelContainedProcesses(container)) {
        createEdgeIfRequired(dag, process1, process2);
      }
    }
  }

  /**
   * Create the initial edges between the processes. Two processes are connected
   * if one is below the other (bottom->top).
   * 
   * @param dag
   * @param process1
   * @param process2
   */
  private void createEdgeIfRequired(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag, final OPMProcess process1,
      final OPMProcess process2) {
    if(process1.equals(process2)) {
      return;
    }

    if(process1.getConstraints().getBottom().y() < process2.getConstraints().getTop().y()) {
      try {
        dag.addDagEdge(process1, process2);
      } catch(final CycleFoundException e) {
        throw new RuntimeException("Creation of the OPD DAG resulted in a cycle. This should never happen.");
      }
    }
  }

  /**
   * Create a node for each OPMProcess in the OPMContainer.
   * 
   * @param dag
   *          the DAG where the nodes will be added.
   * @param opd
   *          the OPD from which the processes are read.
   */
  private void createNodes(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag, final OPMContainer opd) {
    for(final OPMProcess process : OPDAnalysis.INSTANCE.findFirstLevelContainedProcesses(opd)) {
      dag.addVertex(process);
    }
  }

  /**
   * Calculate all the parameters that are connected to a process.
   * 
   * @param process
   *          to analyze.
   * @return A set containing all the parameters.
   */
  public Set<Parameter> calculateAllParameters(final OPMProcess process) {
    final Set<Parameter> parameters = Sets.newHashSet();

    for(OPMProceduralLink link : OPDAnalysis.INSTANCE.findIncomingDataLinks(process)) {
      if(OPMPackage.eINSTANCE.getOPMState().isInstance(link.getSource())) {
        parameters.add(new Parameter(link.getCenterDecoration(), (OPMObject) link.getSource().getContainer(), link,
            (OPMState) link.getSource()));
      } else {
        parameters.add(new Parameter(link.getCenterDecoration(), (OPMObject) link.getSource(), link));
      }
    }
    for(OPMProceduralLink link : OPDAnalysis.INSTANCE.findOutgoingDataLinks(process)) {
      if(OPMPackage.eINSTANCE.getOPMState().isInstance(link.getTarget())) {
        parameters.add(new Parameter(link.getCenterDecoration(), (OPMObject) link.getTarget().getContainer(), link,
            (OPMState) link.getTarget()));
      } else {
        parameters.add(new Parameter(link.getCenterDecoration(), (OPMObject) link.getTarget(), link));
      }
    }
    return parameters;
  }
}
