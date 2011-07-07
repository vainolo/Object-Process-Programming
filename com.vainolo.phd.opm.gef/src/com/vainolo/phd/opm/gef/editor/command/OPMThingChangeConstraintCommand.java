package com.vainolo.phd.opm.gef.editor.command;

import com.vainolo.phd.opm.model.OPMThing;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

public class OPMThingChangeConstraintCommand extends Command {

	private Rectangle oldConstraint;
	private Rectangle newConstraint;
	private OPMThing model;
	
	@Override public void execute() {
		if(oldConstraint == null) {
			oldConstraint = model.getConstraints();
		}
		model.setConstraints(newConstraint);
	}

	@Override public void undo() {
		model.setConstraints(oldConstraint);
	}

	public void setModel(OPMThing model) {
		this.model = model;
	}
	
	public void setNewConstraint(Rectangle newConstraint) {
		this.newConstraint = newConstraint;
	}
}