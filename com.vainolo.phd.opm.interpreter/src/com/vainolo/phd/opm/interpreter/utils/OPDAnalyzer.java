/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.alg.DirectedNeighborIndex;
import org.jgrapht.event.GraphEdgeChangeEvent;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph.CycleFoundException;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;
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
    Set<OPMProceduralLink> outgoingProceduralLinks = ImmutableSet.copyOf(process.getOutgoingProceduralLinks());
    Set<OPMProcess> invocationProcesses = Sets.newHashSet();
    for(OPMProceduralLink invocationLink : Sets.filter(outgoingProceduralLinks, IsOPMInvocationLink.INSTANCE)) {
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
    Set<OPMProcess> processes = Sets.newHashSet();

    Collection<OPMProceduralLink> incomingLinks = object.getIncomingProceduralLinks();
    incomingLinks = Collections2.filter(incomingLinks, IsOPMEventLink.INSTANCE);
    Collection<OPMProceduralLink> outgoingLinks = object.getOutgoingProceduralLinks();
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
   * An OPD can also contain special <em>invocation</em> links that can change the execution order of the OPD. They are
   * not taken into account in this DAG because they are explicit in the diagram.
   * </p>
   * 
   * @param opd
   * @return
   */
  public static DirectedAcyclicGraph<OPMProcess, DefaultEdge> createOPDDAG(final OPMObjectProcessDiagram opd) {
    final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag = new DirectedAcyclicGraph<OPMProcess, DefaultEdge>(
        DefaultEdge.class);

    createNodes(dag, opd);
    createExecutionOrderEdges(dag, opd);
    removeDuplicateEdges(dag);

    return dag;
  }

  /**
   * <p>
   * Calculate all incoming parameters of a process.
   * </p>
   * <ul>
   * <li> {@link OPMProceduralLinkKind#INSTRUMENT}</li>
   * <li> {@link OPMProceduralLinkKind#INSTRUMENT_CONDITION}</li>
   * <li> {@link OPMProceduralLinkKind#INSTRUMENT_EVENT}</li>
   * <li> {@link OPMProceduralLinkKind#CONSUMPTION}</li>
   * <li> {@link OPMProceduralLinkKind#CONSUMPTION_CONDITION}</li>
   * <li> {@link OPMProceduralLinkKind#CONSUMPTION_EVENT}</li>
   * <li> {@link OPMProceduralLinkKind#EFFECT}</li>
   * <li> {@link OPMProceduralLinkKind#EFFECT_CONDITION}</li>
   * <li> {@link OPMProceduralLinkKind#EFFECT_EVENT}</li>
   * </ul>
   * 
   * @param process
   *          the process to analyze.
   * @return all incoming parameters of the process.
   */
  public static Set<Parameter> calculateIncomingParameters(final OPMProcess process) {
    return getConnectedObjectsByLinkFilter(process, OPMProceduralLinkFilter.incomingFilter);
  }

  /**
   * <p>
   * Calculate all outgoing parameters of a process. A Parameters is outgoing if it is connected to the process with one
   * of the following link kinds:
   * </p>
   * <ul>
   * <li> {@link OPMProceduralLinkKind#EFFECT}</li>
   * <li> {@link OPMProceduralLinkKind#EFFECT_CONDITION}</li>
   * <li> {@link OPMProceduralLinkKind#EFFECT_EVENT}</li>
   * <li> {@link OPMProceduralLinkKind#RESULT}</li>
   * </ul>
   * 
   * @param process
   *          to analyze.
   * @return all outgoing parameters of the process.
   */
  public static Set<Parameter> calculateOutgoingParameters(final OPMProcess process) {
    return getConnectedObjectsByLinkFilter(process, OPMProceduralLinkFilter.outgoingFilter);
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
   * @param vertex
   *          the OPMProcess that is analyzed.
   */
  private static void removeDuplicateEdges(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag,
      final OPMProcess vertex) {
    final DirectedNeighborIndex<OPMProcess, DefaultEdge> dni = new DirectedNeighborIndex<OPMProcess, DefaultEdge>(dag);
    final OPMProcess[] successors = dni.successorsOf(vertex).toArray(new OPMProcess[0]);

    for(final OPMProcess firstTargetVertex : successors) {
      for(final OPMProcess secondTargetVertex : successors) {
        if(firstTargetVertex.equals(secondTargetVertex)) {
          continue;
        }

        DefaultEdge removedEdge;
        if(dni.successorsOf(firstTargetVertex).contains(secondTargetVertex)) {
          removedEdge = dag.removeEdge(vertex, secondTargetVertex);
          if(removedEdge == null) {
            continue;
          }
          GraphEdgeChangeEvent<OPMProcess, DefaultEdge> event;
          event = new GraphEdgeChangeEvent<OPMProcess, DefaultEdge>(new Object(), GraphEdgeChangeEvent.EDGE_REMOVED,
              removedEdge);
          dni.edgeRemoved(event);
        }
      }
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
    for(final OPMProcess process : opd.getProcesses()) {
      for(final OPMProcess otherProcess : opd.getProcesses()) {
        if(process.equals(otherProcess)) {
          continue;
        }

        if(process.getConstraints().getBottom().y() < otherProcess.getConstraints().getTop().y()) {
          try {
            dag.addDagEdge(process, otherProcess);
          } catch(final CycleFoundException e) {
            throw new RuntimeException("Creation of the OPD DAG resulted in a cycle. This should never happen.");
          }
        }
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
    for(final OPMProcess process : opd.getProcesses()) {
      dag.addVertex(process);
    }
  }

  /**
   * Filter the objects connected to a process using the given link filter
   * 
   * @param process
   *          to analyze.
   * @param filter
   *          the filter used to filter links.
   * @return a set of parameters where each parameter contains the connected object, the kind of link it has to the
   *         process and the parameter name.
   */
  private static Set<Parameter> getConnectedObjectsByLinkFilter(final OPMProcess process,
      final OPMProceduralLinkFilter filter) {

    Set<Parameter> parameters = new HashSet<Parameter>();
    for(OPMProceduralLink link : process.getIncomingProceduralLinks()) {
      if(filter.filter(link.getKind())) {
        if(link.getSource() instanceof OPMObject) {
          parameters.add(new Parameter(link.getCenterDecoration(), (OPMObject) link.getSource(), link, process));
        } else {
          parameters.add(new Parameter(link.getCenterDecoration(), (OPMObject) link.getTarget(), link, process));
        }
      }
    }
    return parameters;
  }

  /**
   * Calculate all the parameters that are connected to a process.
   * 
   * @param process
   *          to analyze.
   * @return A set containing all the parameters.
   */
  public static Set<Parameter> calculateAllParameters(final OPMProcess process) {
    Set<Parameter> parameters = Sets.newHashSet();
    Collection<OPMProceduralLink> incomingLinks = process.getIncomingProceduralLinks();
    incomingLinks = Collections2.filter(incomingLinks, IsOPMIncomingProceduralLink.INSTANCE);
    Collection<OPMProceduralLink> outgoingLinks = process.getOutgoingProceduralLinks();
    outgoingLinks = Collections2.filter(outgoingLinks, IsOPMOutgoingProceduralLink.INSTANCE);

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

  /**
   * <p>
   * Calculate a set of all the procedural links that are connected to an OPM node. The returned set is
   * <b>immutable</b>.
   * </p>
   * 
   * 
   * @param node
   *          to analyze
   * @return and <b>immutable</b> set containing all procedural links that start or end at the provided node.
   */
  private static Set<OPMProceduralLink> calculateAllProceduralLinks(final OPMNode node) {
    ImmutableSet<OPMProceduralLink> incLinks = ImmutableSet.copyOf(node.getIncomingProceduralLinks());
    ImmutableSet<OPMProceduralLink> outLinks = ImmutableSet.copyOf(node.getOutgoingProceduralLinks());
    return Sets.union(incLinks, outLinks);
  }
}
