package com.vainolo.phd.opm.interpreter.builtin;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;

public class OPMAddProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {
	@Override
	public void execute() {
		super.execute();
		int a = (int) getArgumentValue("a");
		int b = (int) getArgumentValue("b");
		int c = a + b;
		setArgumentValue("c", c);
	}

	@Override
	public String getName() {
		return "Add";
	}
}
