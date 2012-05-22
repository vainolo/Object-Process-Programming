package com.vainolo.phd.opm.interpreter;

import java.util.ArrayList;
import java.util.List;

import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;

public enum Interpreter {
	INSTANCE;

	public void interpret(OPMObjectProcessDiagram diagram) {
		List<OPMNode> nodes = diagram.getNodes();
		List<OPMProcess> processes = getProcesses(nodes);

		// find processes which have no incoming links
		List<OPMProcess> startingProcesses = calculateStartingProcesses(processes);
		System.out.println("Starting processes: " + startingProcesses.size());

	}

	public List<OPMProcess> getProcesses(List<OPMNode> nodes) {
		List<OPMProcess> retVal = new ArrayList<OPMProcess>();
		for (OPMNode node : nodes) {
			if (node instanceof OPMProcess) {
				retVal.add((OPMProcess) node);
			}
		}
		return retVal;
	}

	private List<OPMProcess> calculateStartingProcesses(List<OPMProcess> processes) {
		List<OPMProcess> startingProcesses = new ArrayList<OPMProcess>();
		for (OPMProcess process : processes) {
			if (process.getIncomingProceduralLinks().size() == 0) {
				startingProcesses.add(process);
			}
		}
		return startingProcesses;
	}
}
