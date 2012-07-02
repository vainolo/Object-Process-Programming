/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import com.vainolo.phd.opm.interpreter.builtin.OPMAddProcessInstance;
import com.vainolo.phd.opm.interpreter.builtin.OPMInputProcessInstance;
import com.vainolo.phd.opm.interpreter.builtin.OPMOutputProcessInstance;
import com.vainolo.phd.opm.model.OPMProcessKind;

public enum OPMProcessInstanceFactoryImpl implements OPMProcessInstanceFactory {
	INSTANCE;

	@Override
	public OPMProcessInstance createProcessInstance(final String processName, final OPMProcessKind kind) {
		// Create process instance.
		OPMProcessInstance processInstance;
		switch(kind) {
		case BUILT_IN:
			processInstance = createBuildInProcess(processName);
			break;
		case COMPOUND:
			processInstance = new OPMCompoundProcessInstance(processName);
		case CONCEPTUAL:
			throw new UnsupportedOperationException("Conceptual processes are not supported yet.");
		case JAVA:
			throw new UnsupportedOperationException("Java processes are not supported yet.");
		default:
			throw new IllegalStateException("Received unexpected OPMProcessKind " + kind.getName());
		}

		return processInstance;
	}

	private OPMProcessInstance createBuildInProcess(final String processName) {
		OPMProcessInstance processInstance;

		if(processName.equals("Input"))
			processInstance = new OPMInputProcessInstance();
		else if(processName.equals("Output"))
			processInstance = new OPMOutputProcessInstance();
		else if(processName.equals("Add"))
			processInstance = new OPMAddProcessInstance();
		else
			throw new IllegalStateException("Tried to create unexistent build-in process " + processName);

		return processInstance;

	}
}
