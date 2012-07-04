/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.alg.DirectedNeighborIndex;
import org.jgrapht.event.GraphEdgeChangeEvent;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph.CycleFoundException;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.base.Preconditions;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;

/**
 * 
 * @author vainolo
 * 
 */
public final class OPDAnalyzer {

	public static List<OPMProcess> getNextProcessesToExecute(
			final DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag, final OPMProcess process) {
		Preconditions.checkArgument(opdDag != null);
		Preconditions.checkArgument(process != null);
		final List<OPMProcess> retVal = new ArrayList<OPMProcess>();

		for(final DefaultEdge edge : opdDag.outgoingEdgesOf(process))
			retVal.add(opdDag.getEdgeTarget(edge));

		return retVal;
	}

	public static List<OPMProcess> getInitialProcesses(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag) {
		Preconditions.checkArgument(opdDag != null, "OPD DAG cannot be null.");

		final List<OPMProcess> retVal = new ArrayList<OPMProcess>();

		for(final OPMProcess process : opdDag.vertexSet())
			if(opdDag.inDegreeOf(process) == 0)
				retVal.add(process);

		return retVal;
	}

	public static DirectedAcyclicGraph<OPMProcess, DefaultEdge> createOPDDAG(final OPMObjectProcessDiagram opd) {
		final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag = new DirectedAcyclicGraph<OPMProcess, DefaultEdge>(
				DefaultEdge.class);

		createNodes(dag, opd);
		addEdges(dag, opd);
		removeDuplicateEdges(dag);

		return dag;
	}

	private static void removeDuplicateEdges(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag) {
		for(final OPMProcess vertex : dag.vertexSet())
			removeDuplicateEdges(dag, vertex);
	}

	private static void removeDuplicateEdges(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag,
			final OPMProcess vertex) {
		final DirectedNeighborIndex<OPMProcess, DefaultEdge> dni = new DirectedNeighborIndex<OPMProcess, DefaultEdge>(
				dag);
		final OPMProcess[] successors = dni.successorsOf(vertex).toArray(new OPMProcess[0]);

		for(final OPMProcess firstTargetVertex : successors)
			for(final OPMProcess secondTargetVertex : successors) {
				if(firstTargetVertex.equals(secondTargetVertex))
					continue;

				DefaultEdge removedEdge;
				if(dni.successorsOf(firstTargetVertex).contains(secondTargetVertex)) {
					removedEdge = dag.removeEdge(vertex, secondTargetVertex);
					if(removedEdge == null)
						continue;
					GraphEdgeChangeEvent<OPMProcess, DefaultEdge> event;
					event = new GraphEdgeChangeEvent<OPMProcess, DefaultEdge>(new Object(),
							GraphEdgeChangeEvent.EDGE_REMOVED, removedEdge);
					dni.edgeRemoved(event);
				}
			}
	}

	private static void addEdges(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag,
			final OPMObjectProcessDiagram opd) {
		for(final OPMProcess process : opd.getProcesses())
			for(final OPMProcess otherProcess : opd.getProcesses()) {
				if(process.equals(otherProcess))
					continue;

				if(process.getConstraints().getBottom().y() < otherProcess.getConstraints().getTop().y())
					try {
						dag.addDagEdge(process, otherProcess);
					} catch(final CycleFoundException e) {
						throw new RuntimeException(
								"Creation of the OPD DAG resulted in a cycle. This should never happen.");
					}
			}
	}

	private static void createNodes(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag,
			final OPMObjectProcessDiagram opd) {
		for(final OPMProcess process : opd.getProcesses())
			dag.addVertex(process);
	}

}
