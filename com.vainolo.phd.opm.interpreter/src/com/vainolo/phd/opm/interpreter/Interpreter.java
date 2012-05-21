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

		// find processes which have:
		// 1) only agent incoming links
		//
		System.out.println("Number of nodes: " + diagram.getNodes().size());

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
}
