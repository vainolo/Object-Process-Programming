/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;

import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;

public enum Interpreter {
	INSTANCE;

	private final Map<OPMProcess, OPMProcessInstance> processInstances = new HashMap<OPMProcess, OPMProcessInstance>();

	private IContainer containter;

	public IContainer getContainer() {
		return containter;
	}

	public void interpret(OPMObjectProcessDiagram diagram, IContainer container) {
		this.containter = container;
		VariableManager variableManager = new VariableManager();
		processInstances.clear();

		List<OPMNode> nodes = diagram.getNodes();
		List<OPMProcess> processes = getProcesses(nodes);

		for (OPMProcess opmProcess : processes) {
			OPMProcessInstance processInstance = ProcessInstanceFactory.INSTANCE.getProcessInstanceFromOPMProcess(	opmProcess,
																													variableManager);
			processInstance.setActive(true);
			processInstances.put(opmProcess, processInstance);
		}
		List<OPMProcess> startingProcesses = calculateStartingProcesses(processes);
		for (OPMProcess startingProcess : startingProcesses) {
			OPMProcessInstance startingProcessInstance = processInstances.get(startingProcess);
			startingProcessInstance.execute();
		}
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
