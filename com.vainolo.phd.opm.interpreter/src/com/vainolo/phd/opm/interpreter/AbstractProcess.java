package com.vainolo.phd.opm.interpreter;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;

public abstract class AbstractProcess implements Process {
	private final EMap<String, Object> arguments = new BasicEMap<>();

	@Override
	public void setArgument(String name, Object value) {
		arguments.put(name, value);
	}

	@Override
	public Object getArgument(String name) {
		return arguments.get(name);
	}

}
