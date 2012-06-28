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

	public static List<OPMProcess> getNextProcessesToExecute(DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag,
			OPMProcess process) {
		Preconditions.checkArgument(opdDag != null);
		Preconditions.checkArgument(process != null);
		List<OPMProcess> retVal = new ArrayList<OPMProcess>();

		for(DefaultEdge edge : opdDag.outgoingEdgesOf(process))
			retVal.add(opdDag.getEdgeTarget(edge));

		return retVal;
	}

	public static List<OPMProcess> getInitialProcesses(DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag) {

		return null;
	}

	public static DirectedAcyclicGraph<OPMProcess, DefaultEdge> createOPDDAG(final OPMObjectProcessDiagram opd) {
		final DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag = new DirectedAcyclicGraph<OPMProcess, DefaultEdge>(
				DefaultEdge.class);

		createNodes(dag, opd);
		addEdges(dag, opd);
		removeDuplicateEdges(dag);

		return dag;
	}

	private static void removeDuplicateEdges(DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag) {
		for(OPMProcess vertex : dag.vertexSet())
			removeDuplicateEdges(dag, vertex);
	}

	private static void removeDuplicateEdges(DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag, OPMProcess vertex) {
		DirectedNeighborIndex<OPMProcess, DefaultEdge> dni = new DirectedNeighborIndex<OPMProcess, DefaultEdge>(dag);
		OPMProcess[] successors = dni.successorsOf(vertex).toArray(new OPMProcess[0]);

		for(OPMProcess firstTargetVertex : successors)
			for(OPMProcess secondTargetVertex : successors) {
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

	private static void addEdges(DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag, OPMObjectProcessDiagram opd) {
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

	private static void createNodes(DirectedAcyclicGraph<OPMProcess, DefaultEdge> dag, OPMObjectProcessDiagram opd) {
		for(final OPMProcess process : opd.getProcesses())
			dag.addVertex(process);
	}

}
