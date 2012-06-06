package com.vainolo.phd.opm.interpreter;

import java.util.HashMap;
import java.util.Map;

import com.vainolo.phd.opm.interpreter.model.InterpreterFactory;
import com.vainolo.phd.opm.interpreter.model.Variable;
import com.vainolo.phd.opm.model.OPMObject;

public class VariableManager {
	Map<String, Variable> variables = new HashMap<String, Variable>();

	public Variable getVariable(OPMObject object) {
		Variable var = variables.get(object.getName());
		if (var == null) {
			var = InterpreterFactory.eINSTANCE.createVariable();
			var.setName(object.getName());
			variables.put(object.getName(), var);
		}
		return var;
	}
}
