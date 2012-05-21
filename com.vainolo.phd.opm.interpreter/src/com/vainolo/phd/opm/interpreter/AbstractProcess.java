package com.vainolo.phd.opm.interpreter;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;

import com.vainolo.phd.opm.interpreter.model.Variable;

public abstract class AbstractProcess implements OPMProcessInstance {
	private final EMap<String, Variable> arguments = new BasicEMap<>();

	@Override
	public void setArgument(String name, Variable value) {
		arguments.put(name, value);
	}

	@Override
	public Variable getArgument(String name) {
		return arguments.get(name);
	}

}
