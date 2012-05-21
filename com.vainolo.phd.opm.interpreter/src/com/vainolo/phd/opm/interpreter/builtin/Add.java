package com.vainolo.phd.opm.interpreter.builtin;

import com.vainolo.phd.opm.interpreter.AbstractProcess;

public class Add extends AbstractProcess {
	@Override
	public void execute() {
		int a = (int) getArgument("a");
		int b = (int) getArgument("b");
		int c = a + b;
		setArgument("c", c);
	}
}
