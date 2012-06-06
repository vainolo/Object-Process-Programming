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

import com.vainolo.phd.opm.interpreter.builtin.OPMAddProcessInstance;
import com.vainolo.phd.opm.interpreter.builtin.OPMInputProcessInstance;
import com.vainolo.phd.opm.interpreter.builtin.OPMOutputProcessInstance;
import com.vainolo.phd.opm.interpreter.model.Variable;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;

public enum Interpreter {
	INSTANCE;

	private final Map<OPMProcess, OPMProcessInstance> processInstances = new HashMap<OPMProcess, OPMProcessInstance>();

	private VariableManager variableManager;

	public void interpret(OPMObjectProcessDiagram diagram) {
		variableManager = new VariableManager();
		processInstances.clear();

		List<OPMNode> nodes = diagram.getNodes();
		List<OPMProcess> processes = getProcesses(nodes);

		// find processes which have no incoming links
		for (OPMProcess opmProcess : processes) {
			OPMProcessInstance processInstance = getProcessInstanceFromOPMProcess(opmProcess);
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

	private OPMProcessInstance getProcessInstanceFromOPMProcess(OPMProcess process) {
		// Create process instance.
		OPMProcessInstance processInstance;
		if (process.getName().equals("Input")) {
			processInstance = new OPMInputProcessInstance();
		} else if (process.getName().equals("Output")) {
			processInstance = new OPMOutputProcessInstance();
		} else if (process.getName().equals("Add")) {
			processInstance = new OPMAddProcessInstance();
		} else {
			processInstance = new OPMComplexProcessInstance(process);
		}

		// Fetch (or create) the variables used by the process.
		List<OPMLink> links = new ArrayList<OPMLink>();
		links.addAll(process.getIncomingProceduralLinks());
		links.addAll(process.getOutgoingProceduralLinks());
		for (OPMLink link : links) {
			OPMProceduralLink pLink = (OPMProceduralLink) link;
			OPMObject object = null;
			if (pLink.getSource() instanceof OPMObject) {
				object = (OPMObject) pLink.getSource();
			} else if (pLink.getTarget() instanceof OPMObject) {
				object = (OPMObject) pLink.getTarget();
			}
			Variable var = variableManager.getVariable(object);
			addVariableToProcessIntance(var, processInstance, pLink);
		}

		return processInstance;
	}

	private void addVariableToProcessIntance(Variable var, OPMProcessInstance processInstance, OPMProceduralLink link) {
		processInstance.addArgument(link.getCenterDecoration(), link.getKind(), var);
	}
}
