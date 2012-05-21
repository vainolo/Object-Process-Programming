package com.vainolo.phd.opm.interpreter.builtin;

import com.vainolo.phd.opm.interpreter.AbstractProcess;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.interpreter.model.InterpreterFactory;
import com.vainolo.phd.opm.interpreter.model.Variable;

public class Add extends AbstractProcess implements OPMProcessInstance {
	@Override
	public void execute() {
		int a = (int) getArgument("a").getValue();
		int b = (int) getArgument("b").getValue();
		int c = a + b;
		Variable v = InterpreterFactory.eINSTANCE.createVariable();
		v.setValue(c);
		setArgument("c", v);
	}
}
