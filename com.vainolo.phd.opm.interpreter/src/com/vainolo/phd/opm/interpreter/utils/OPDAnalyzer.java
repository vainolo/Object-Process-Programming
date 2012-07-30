/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.jgrapht.alg.DirectedNeighborIndex;
import org.jgrapht.event.GraphEdgeChangeEvent;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph.CycleFoundException;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import com.vainolo.phd.opm.interpreter.analysis.OPMAnalysis;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMEventLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMInvocationLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMProcessIncomingDataLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMProcessOutgoingDataLink;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;

/**
 * Various utilities used to execute an OPD.
 * 
 * @author vainolo
 * 
 */
public final class OPDAnalyzer {

  /**
   * <p>
   * Calculate all the processes that should be invoked when the given process ends.
   * 
   * @param process
   *          to analyze.
   * @return a set of processes to execute when the provided process finishes execution.
   */
  public static Set<OPMProcess> calculateInvocationProcesses(final OPMProcess process) {

    final Collection<OPMProceduralLink> outgoingProceduralLinks = OPMAnalysis.findOutgoingInvocationLinks(process);
    final Set<OPMProcess> invocationProcesses = Sets.newHashSet();
    for(OPMProceduralLink invocationLink : Collections2.filter(outgoingProceduralLinks, IsOPMInvocationLink.INSTANCE)) {
      invocationProcesses.add((OPMProcess) invocationLink.getTarget());
    }
    return invocationProcesses;
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
   * @return a set of processes that have to finish for the given process to execute.
   */
  public static Set<OPMProcess> calculateRequiredProcesses(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag,
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
   * Calculate the processes that are connected to this object using event procedural links.
   * </p>
   * 
   * @param object
   * @return
   */
  public static Set<OPMProcess> calculateConnectedEventProcesses(final OPMObject object) {
    final Set<OPMProcess> processes = Sets.newHashSet();

    Collection<OPMProceduralLink> incomingLinks = OPMAnalysis.findIncomingProceduralLinks(object);
    incomingLinks = Collections2.filter(incomingLinks, IsOPMEventLink.INSTANCE);
    Collection<OPMProceduralLink> outgoingLinks = OPMAnalysis.findOutgoingProceduralLinks(object);
    outgoingLinks = Collections2.filter(outgoingLinks, IsOPMEventLink.INSTANCE);

    // Note that these lists are disjoint since they are the "real" connections of the model, so we can run over both
    // collections freely.
    for(OPMProceduralLink link : incomingLinks) {
      processes.add((OPMProcess) link.getSource());
    }
    for(OPMProceduralLink link : outgoingLinks) {
      processes.add((OPMProcess) link.getTarget());
    }

    return processes;
  }

  /**
   * <p>
   * Calculate which processes can be executed when the provided process ends. The returned processes may execute if
   * they have no other predecessor processes. Otherwise they must wait for all other predecessor processes to end for
   * them to execute.
   * </p>
   * 
   * @param opdDag
   *          the DAG of the OPD where the process is located.
   * @param process
   *          the process that has finished.
   * @return list of processes that are dependent on the current process for execution.
   */
  public static List<OPMProcess> calculateFollowingProcesses(
      final DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag, final OPMProcess process) {
    Preconditions.checkArgument(opdDag != null);
    Preconditions.checkArgument(process != null);
    final List<OPMProcess> retVal = new ArrayList<OPMProcess>();

    for(final DefaultEdge edge : opdDag.outgoingEdgesOf(process)) {
      retVal.add(opdDag.getEdgeTarget(edge));
    }

    return retVal;
  }

  /**
   * Calculate the processes that should be executed when the OPD is invoked. These are the processes that have no
   * predecessors in the OPD DAG.
   * 
   * @param opdDag
   *          the OPD DAG that is analyzed.
   * @return the processes that should be executed when the OPD is invoked.
   */
  public static Set<OPMProcess> calculateInitialProcesses(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag) {
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
   * Create a DAG based on the process execution order of the OPD.
   * </p>
   * 
   * <p>
   * The execution order of an OPD is defined by the location of the processes inside the OPD. When a process
   * <code>P1</code> is above another process <code>P2</code> (the lowest point of <code>P1</code> is below the highest
   * point of <code>P2</code>), then <code>P2</code> is only executed after <code>P1</code> has finished execution.
   * </p>
   * 
   * <p>
   * Process execution is indifferent of whether the OPD is a system OPD or a compound OPD. Execution is the same in
   * both cases, with the difference than in a system OPD the processes are directly in the OPM and in a compound OPD
   * the processes are inside the zoomed-in (compound) process.
   * 
   * <p>
   * An OPD can also contain special <em>invocation</em> links that can change the execution order of the OPD. They are
   * not taken into account in this DAG because they are explicit in the diagram.
   * </p>
   * 
   * @param opd
   * @return
   */
  public static DirectedAcyclicGraph<OPMProcess, DefaultEdge> createOPDDAG(final OPMObjectProcessDiagram opd) {
    final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag =
        new DirectedAcyclicGraph<OPMProcess, DefaultEdge>(DefaultEdge.class);

    createNodes(dag, opd);
    createExecutionOrderEdges(dag, opd);
    removeDuplicateEdges(dag);

    return dag;
  }

  /**
   * <p>
   * Remove duplicate edges that start at process <code>vertex</code>. This is done as follows:
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
  private static void removeDuplicateEdges(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag,
      final OPMProcess source) {
    final DirectedNeighborIndex<OPMProcess, DefaultEdge> dni = new DirectedNeighborIndex<OPMProcess, DefaultEdge>(dag);
    final OPMProcess[] successors = dni.successorsOf(source).toArray(new OPMProcess[0]);

    for(final OPMProcess firstTarget : successors) {
      for(final OPMProcess secondTarget : successors) {
        removeDuplicateEdges(dag, source, dni, firstTarget, secondTarget);
      }
    }
  }

  private static void removeDuplicateEdges(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag,
      final OPMProcess source, final DirectedNeighborIndex<OPMProcess, DefaultEdge> dni, final OPMProcess firstTarget,
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
      final GraphEdgeChangeEvent<OPMProcess, DefaultEdge> event =
          new GraphEdgeChangeEvent<OPMProcess, DefaultEdge>(new Object(), GraphEdgeChangeEvent.EDGE_REMOVED,
              removedEdge);
      dni.edgeRemoved(event);
    }
  }

  /**
   * <p>
   * Remove duplicate edges in the DAG. The edge creation algorithm (see
   * {@link OPDAnalyzer#createExecutionOrderEdges(DirectedAcyclicGraph, OPMObjectProcessDiagram)}) creates one edge for
   * each process execution relation. But because process execution order is transitive, there are edges that are
   * redundant and can be removed.
   * </p>
   * 
   * <p>
   * For example: if <code>P1</code> executes before <code>P2</code> and <code>P2</code> executes before <code>P3</code>
   * the algorithm will create edges <code>(P1,P2)</code>, <code>(P1,P3)</code>, and <code>(P2,P3)</code>. But the edge
   * <code>(P1,P3)</code> is redundant since it the order is already prescribed by the other two edges. Therefore it can
   * be removed.
   * 
   * @param dag
   *          The DAG to analyze and remove edges.
   */
  private static void removeDuplicateEdges(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag) {
    for(final OPMProcess vertex : dag.vertexSet()) {
      removeDuplicateEdges(dag, vertex);
    }
  }

  /**
   * Create the edges that drive the execution order of the OPD. Process <code>P1</code> will execute before process
   * <code>P2</code> if <code>P1</code>'s lowest border is below <code>P2</code>'s upper border.
   * 
   * @param dag
   *          the DAG where the edges will be added.
   * @param opd
   *          the OPD from which the processes are read.
   */
  private static void createExecutionOrderEdges(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag,
      final OPMObjectProcessDiagram opd) {
    for(final OPMProcess process1 : OPMAnalysis.findExecutableProcesses(opd)) {
      for(final OPMProcess process2 : OPMAnalysis.findExecutableProcesses(opd)) {
        createEdgeIfRequired(dag, process1, process2);
      }
    }
  }

  private static void createEdgeIfRequired(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag,
      final OPMProcess process1, final OPMProcess process2) {
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
   * Create a node for each OPMProcess in the OPD.
   * 
   * @param dag
   *          the DAG where the nodes will be added.
   * @param opd
   *          the OPD from which the processes are read.
   */
  private static void createNodes(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag,
      final OPMObjectProcessDiagram opd) {
    for(final OPMProcess process : OPMAnalysis.findExecutableProcesses(opd)) {
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
  public static Set<Parameter> calculateAllParameters(final OPMProcess process) {
    final Set<Parameter> parameters = Sets.newHashSet();
    Collection<OPMProceduralLink> incomingLinks = OPMAnalysis.findIncomingDataLinks(process);
    incomingLinks = Collections2.filter(incomingLinks, IsOPMProcessIncomingDataLink.INSTANCE);
    Collection<OPMProceduralLink> outgoingLinks = OPMAnalysis.findOutgoingDataLinks(process);
    outgoingLinks = Collections2.filter(outgoingLinks, IsOPMProcessOutgoingDataLink.INSTANCE);

    // Note that these lists are disjoint since they are the "real" connections of the model, so we can run over both
    // collections freely.
    for(OPMProceduralLink link : incomingLinks) {
      parameters.add(new Parameter(link.getCenterDecoration(), (OPMObject) link.getSource(), link, process));
    }
    for(OPMProceduralLink link : outgoingLinks) {
      parameters.add(new Parameter(link.getCenterDecoration(), (OPMObject) link.getTarget(), link, process));
    }

    return parameters;
  }
}
