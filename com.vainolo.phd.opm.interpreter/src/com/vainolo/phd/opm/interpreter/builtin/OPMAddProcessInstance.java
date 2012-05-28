package com.vainolo.phd.opm.interpreter.builtin;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;

public class OPMAddProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {
	@Override
	public void execute() {
		super.execute();
		int a = 0, b = 0, c = 0;
		Object o = getArgumentValue("a");
		if (o instanceof String) {
			a = Integer.parseInt((String) o);
		} else if (o instanceof Integer) {
			a = (int) o;
		}
		o = getArgumentValue("b");
		if (o instanceof String) {
			b = Integer.parseInt((String) o);
		} else if (o instanceof Integer) {
			b = (int) o;
		}
		c = a + b;
		setArgumentValue("c", c);
	}

	@Override
	public String getName() {
		return "Add";
	}
}
