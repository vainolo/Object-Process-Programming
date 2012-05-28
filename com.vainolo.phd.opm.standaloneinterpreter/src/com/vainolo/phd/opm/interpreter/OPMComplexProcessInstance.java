package com.vainolo.phd.opm.interpreter;

import com.vainolo.phd.opm.model.OPMProcess;

public class OPMComplexProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {

	private final OPMProcess process;

	public OPMComplexProcessInstance(OPMProcess process) {
		this.process = process;
	}

	@Override
	public String getName() {
		return process.getName();
	}

	@Override
	public void execute() {
		super.execute();
	}

}
