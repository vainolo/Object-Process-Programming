package com.vainolo.phd.opm.interpreter;

import com.vainolo.phd.opm.interpreter.model.Variable;

public interface OPMProcessInstance {
	public void execute();

	public void setArgument(String name, Variable variable);

	public Variable getArgument(String name);
}
