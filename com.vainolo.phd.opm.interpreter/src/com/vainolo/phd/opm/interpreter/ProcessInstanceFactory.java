/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.ArrayList;
import java.util.List;

import com.vainolo.phd.opm.interpreter.builtin.OPMAddProcessInstance;
import com.vainolo.phd.opm.interpreter.builtin.OPMInputProcessInstance;
import com.vainolo.phd.opm.interpreter.builtin.OPMOutputProcessInstance;
import com.vainolo.phd.opm.interpreter.model.Variable;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;

public enum ProcessInstanceFactory {
	INSTANCE;

	public OPMProcessInstance getProcessInstanceFromOPMProcess(final OPMProcess process,
			final VariableManager variableManager) {
		// Create process instance.
		OPMProcessInstance processInstance;
		if(process.getName().equals("Input"))
			processInstance = new OPMInputProcessInstance();
		else if(process.getName().equals("Output"))
			processInstance = new OPMOutputProcessInstance();
		else if(process.getName().equals("Add"))
			processInstance = new OPMAddProcessInstance();
		else
			processInstance = new OPMComplexProcessInstance(process);

		// Fetch (or create) the variables used by the process.
		final List<OPMLink> links = new ArrayList<OPMLink>();
		links.addAll(process.getIncomingProceduralLinks());
		links.addAll(process.getOutgoingProceduralLinks());
		for(final OPMLink link : links) {
			final OPMProceduralLink pLink = (OPMProceduralLink) link;
			OPMObject object = null;
			if(pLink.getSource() instanceof OPMObject)
				object = (OPMObject) pLink.getSource();
			else if(pLink.getTarget() instanceof OPMObject)
				object = (OPMObject) pLink.getTarget();
			final Variable var = variableManager.getVariable(object.getName());
			processInstance.addArgument(pLink.getCenterDecoration(), pLink.getKind(), var);
		}

		return processInstance;
	}
}
