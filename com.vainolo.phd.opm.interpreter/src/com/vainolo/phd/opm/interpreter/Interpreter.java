package com.vainolo.phd.opm.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vainolo.phd.opm.interpreter.builtin.OPMAddProcessInstance;
import com.vainolo.phd.opm.interpreter.builtin.OPMInputProcessInstance;
import com.vainolo.phd.opm.interpreter.builtin.OPMOutputProcessInstance;
import com.vainolo.phd.opm.interpreter.model.InterpreterFactory;
import com.vainolo.phd.opm.interpreter.model.Variable;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;
import com.vainolo.phd.opm.model.OPMProcess;

public enum Interpreter {
	INSTANCE;

	Map<String, Variable> variables = new HashMap<String, Variable>();
	Map<OPMProcess, OPMProcessInstance> processInstances = new HashMap<OPMProcess, OPMProcessInstance>();

	public void interpret(OPMObjectProcessDiagram diagram) {
		variables.clear();
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
			Variable var = createOrFetchObjectVariable(object);
			addVariableToProcessIntance(var, processInstance, pLink);
		}

		return processInstance;
	}

	private void addVariableToProcessIntance(Variable var, OPMProcessInstance processInstance, OPMProceduralLink link) {
		OPMProceduralLinkKind kind = link.getKind();
		String name = link.getCenterDecoration();
		switch (kind) {
		case AGENT:
			processInstance.addAgent(name);
			break;
		case CONSUMPTION:
			processInstance.addConsumption(name, var);
			break;
		case EFFECT:
			processInstance.addEffect(name, var);
			break;
		case INSTRUMENT:
			processInstance.addInstrument(name, var);
			break;
		case INVOCATION:
			break;
		case RESULT:
			processInstance.addResult(name, var);
			break;
		}

	}

	private Variable createOrFetchObjectVariable(OPMObject object) {
		Variable var = variables.get(object.getName());
		if (var == null) {
			var = InterpreterFactory.eINSTANCE.createVariable();
			var.setName(object.getName());
			variables.put(object.getName(), var);
		}
		return var;
	}

	public static void main(String args[]) {
		System.out.println("Hello");
	}
}
