package com.vainolo.phd.opm.interpreter;

import com.vainolo.phd.opm.interpreter.model.Variable;

public interface OPMProcessInstance {
	public void execute();

	public void setArgumentValue(String name, Object variable);

	public Object getArgumentValue(String name);

	public void addInstrument(String name, Variable variable);

	public void addAgent(String name);

	public void addConsumption(String name, Variable variable);

	public void addEffect(String name, Variable variable);

	public void addResult(String name, Variable variable);

	public String getName();

	public boolean isReady();
}
