package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMThing;

public class OPMThingDeleteCommand extends Command {

	private OPMThing thing;
	private OPMObjectProcessDiagram opd;

	@Override
	public void execute() {
		thing.setOpd(null);
	}

	@Override
	public void undo() {
		thing.setOpd(opd);
	}

	public void setThing(OPMThing thing) {
		this.thing = thing;
		this.opd = thing.getOpd();
	}
}
