/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.vainolo.phd.opm.interpreter.model.InterpreterFactory;
import com.vainolo.phd.opm.interpreter.model.Variable;

public class VariableManager {
	private final Map<String, Variable> variables = new HashMap<String, Variable>();

	/**
	 * Fetch the variable with the specified name. Assumes that the variable exists and Throws an
	 * {@link IllegalStateException} if it doesn't.
	 * 
	 * @param name
	 *            name of the variable.
	 * @return the variable.
	 */
	public Variable getVariable(final String name) {
		Preconditions.checkArgument(name != null, "Variable name cannot be null");
		final Variable var = variables.get(name);
		if(var == null)
			throw new IllegalStateException("Tried to fetch variable " + name + " but variable doesn't exist.");
		return var;
	}

	public Variable createVariable(final String name) {
		Preconditions.checkArgument(name != null, "Variable name cannot be null");
		Preconditions.checkState(!variables.containsKey(name));
		final Variable var = InterpreterFactory.eINSTANCE.createVariable();
		var.setName(name);
		variables.put(name, var);
		return var;
	}
}
