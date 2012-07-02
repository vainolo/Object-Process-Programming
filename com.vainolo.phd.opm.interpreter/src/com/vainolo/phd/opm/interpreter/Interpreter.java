/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import org.eclipse.core.resources.IContainer;

import com.vainolo.phd.opm.model.OPMProcessKind;

public enum Interpreter {
	INSTANCE;

	private IContainer containter;
	private OPMProcessInstanceFactory factory;

	public void setOPMProcessInstanceFactory(final OPMProcessInstanceFactory factory) {
		this.factory = factory;
	}

	public IContainer getContainer() {
		return containter;
	}

	public void interpret(final String processName, final IContainer container) {
		this.containter = container;
		final OPMProcessInstance instance = factory.createProcessInstance(processName, OPMProcessKind.COMPOUND);
		instance.execute();
	}
}
