/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.utils;

import java.util.Set;

import org.jgrapht.alg.DirectedNeighborIndex;
import org.jgrapht.event.GraphEdgeChangeEvent;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph.CycleFoundException;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.vainolo.phd.opp.model.OPPContainer;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.utilities.analysis.OPDAnalyzer;

/**
 * Various utilities used to execute an OPD.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPDExecutionAnalyzer {

  private OPDAnalyzer analyzer = new OPDAnalyzer();

  /**
   * Find the processes that should be executed when the OPD is invoked. These
   * are the processes that have no predecessors in the OPD DAG.
   * 
   * @param opdDag
   *          the OPD DAG that is analyzed.
   * @return the processes that should be executed when the OPD is invoked.
   */
  public Set<OPPProcess> findInitialProcesses(final DirectedAcyclicGraph<OPPProcess, DefaultEdge> opdDag) {
    Preconditions.checkArgument(opdDag != null, "OPD DAG cannot be null.");

    final Set<OPPProcess> retVal = Sets.newHashSet();

    for(final OPPProcess process : opdDag.vertexSet()) {
      if(opdDag.inDegreeOf(process) == 0) {
        retVal.add(process);
      }
    }

    return retVal;
  }

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
  public Set<OPPProcess> findRequiredProcesses(final DirectedAcyclicGraph<OPPProcess, DefaultEdge> opdDag,
      final OPPProcess process) {
    Preconditions.checkArgument(opdDag != null);
    Preconditions.checkArgument(process != null);

    final Set<OPPProcess> retVal = Sets.newHashSet();
    for(DefaultEdge edge : opdDag.incomingEdgesOf(process)) {
      retVal.add(opdDag.getEdgeSource(edge));
    }

    return retVal;
  }

  /**
   * <p>
   * Calculate the successors process of a process as defined in the OPD DAG.
   * The returned processes may execute if they have no other predecessor
   * processes, must wait for all other predecessor processes to end for them to
   * execute, or may be skipped, depending on the current state of the executed
   * OPD.
   * </p>
   * 
   * @param opdDag
   *          the DAG of the OPD where the process is located.
   * @param process
   *          the process that has finished.
   * @return list of processes that are dependent on the current process for
   *         execution.
   */
  public Set<OPPProcess> findFollowingProcesses(final DirectedAcyclicGraph<OPPProcess, DefaultEdge> opdDag,
      final OPPProcess process) {
    Preconditions.checkArgument(opdDag != null);
    Preconditions.checkArgument(process != null);
    final Set<OPPProcess> retVal = Sets.newHashSet();

    for(final DefaultEdge edge : opdDag.outgoingEdgesOf(process)) {
      retVal.add(opdDag.getEdgeTarget(edge));
    }

    return retVal;
  }

  /**
   * <p>
   * Create a DAG based on the process execution order of an
   * {@link OPPContainer}.
   * </p>
   * 
   * <p>
   * The execution order of an {@link OPPContainer} is defined by the location
   * of the processes inside the {@link OPPContainer}. When a process
   * <code>P1</code> is above another process <code>P2</code> (the lowest point
   * of <code>P1</code> is below the highest point of <code>P2</code>), then
   * <code>P2</code> is only executed after <code>P1</code> has finished
   * execution.
   * </p>
   * 
   * <p>
   * An {@link OPPContainer} can also contain special <em>invocation</em> links
   * that can change the execution order of the {@link OPPContainer}. They are
   * not taken into account in this DAG because they are explicit in the
   * diagram.
   * </p>
   * 
   * @param container
   *          to analyze
   * @return a Directed Acyclic Graph (DAG) that represents the execution order
   *         of the container.
   */
  public DirectedAcyclicGraph<OPPProcess, DefaultEdge> createExecutionDAG(final OPPContainer opd) {
    final DirectedAcyclicGraph<OPPProcess, DefaultEdge> dag = new DirectedAcyclicGraph<OPPProcess, DefaultEdge>(
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
   *          the OPPProcess that is analyzed.
   */
  private void removeDuplicateEdges(final DirectedAcyclicGraph<OPPProcess, DefaultEdge> dag, final OPPProcess source) {
    final DirectedNeighborIndex<OPPProcess, DefaultEdge> dni = new DirectedNeighborIndex<OPPProcess, DefaultEdge>(dag);
    final OPPProcess[] successors = dni.successorsOf(source).toArray(new OPPProcess[0]);

    for(final OPPProcess firstTarget : successors) {
      for(final OPPProcess secondTarget : successors) {
        removeDuplicateEdges(dag, source, dni, firstTarget, secondTarget);
      }
    }
  }

  private void removeDuplicateEdges(final DirectedAcyclicGraph<OPPProcess, DefaultEdge> dag, final OPPProcess source,
      final DirectedNeighborIndex<OPPProcess, DefaultEdge> dni, final OPPProcess firstTarget,
      final OPPProcess secondTarget) {
    if(firstTarget.equals(secondTarget)) {
      return;
    }

    final DefaultEdge removedEdge;
    if(dni.successorsOf(firstTarget).contains(secondTarget)) {
      removedEdge = dag.removeEdge(source, secondTarget);
      if(removedEdge == null) {
        return;
      }
      final GraphEdgeChangeEvent<OPPProcess, DefaultEdge> event = new GraphEdgeChangeEvent<OPPProcess, DefaultEdge>(
          new Object(), GraphEdgeChangeEvent.EDGE_REMOVED, removedEdge);
      dni.edgeRemoved(event);
    }
  }

  /**
   * <p>
   * Remove duplicate edges in the DAG. The edge creation algorithm (see
   * {@link OPDExecutionAnalyzer#createExecutionOrderEdges(DirectedAcyclicGraph, OPPObjectProcessDiagram)}
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
  private void removeDuplicateEdges(final DirectedAcyclicGraph<OPPProcess, DefaultEdge> dag) {
    for(final OPPProcess vertex : dag.vertexSet()) {
      removeDuplicateEdges(dag, vertex);
    }
  }

  /**
   * Create the edges that drive the execution order of the {@link OPPContainer}
   * . Process <code>P1</code> will execute before process <code>P2</code> if
   * <code>P1</code>'s lowest border is below <code>P2</code>'s upper border.
   * 
   * @param dag
   *          the DAG where the edges will be added.
   * @param container
   *          the container where the processes are located.
   */
  private void createExecutionOrderEdges(final DirectedAcyclicGraph<OPPProcess, DefaultEdge> dag,
      final OPPContainer container) {
    for(final OPPProcess process1 : analyzer.findFirstLevelContainedProcesses(container)) {
      for(final OPPProcess process2 : analyzer.findFirstLevelContainedProcesses(container)) {
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
  private void createEdgeIfRequired(final DirectedAcyclicGraph<OPPProcess, DefaultEdge> dag, final OPPProcess process1,
      final OPPProcess process2) {
    if(process1.equals(process2)) {
      return;
    }

    if((process1.getY() + process1.getHeight()) < process2.getY()) {
      try {
        dag.addDagEdge(process1, process2);
      } catch(final CycleFoundException e) {
        throw new RuntimeException("Creation of the OPD DAG resulted in a cycle. This should never happen.");
      }
    }
  }

  /**
   * Create a node for each OPPProcess in the OPPContainer.
   * 
   * @param dag
   *          the DAG where the nodes will be added.
   * @param opd
   *          the OPD from which the processes are read.
   */
  private void createNodes(final DirectedAcyclicGraph<OPPProcess, DefaultEdge> dag, final OPPContainer opd) {
    for(final OPPProcess process : analyzer.findFirstLevelContainedProcesses(opd)) {
      dag.addVertex(process);
    }
  }
}
