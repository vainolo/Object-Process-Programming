/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import com.google.common.base.Preconditions;

public abstract class OPMAbstractProcessInstance implements OPMProcessInstance {
	private VariableManager varManager = new VariableManager();

	private String name;

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void execute() {
		System.out.println("Executing process " + getName());
	}

	@Override
	public Object getArgumentValue(final String name) {
		Preconditions.checkArgument(name != null);
		return getVarManager().getVariable(name).getValue();
	}

	@Override
	public void setArgumentValue(final String name, final Object value) {
		Preconditions.checkArgument(name != null);
		Preconditions.checkArgument(value != null);
		getVarManager().createVariable(name).setValue(value);
	}

	protected VariableManager getVarManager() {
		if(varManager == null)
			varManager = new VariableManager();
		return varManager;
	}
}
