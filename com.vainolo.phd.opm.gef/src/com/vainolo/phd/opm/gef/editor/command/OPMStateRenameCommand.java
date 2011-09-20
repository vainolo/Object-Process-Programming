package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMState;
import com.vainolo.phd.opm.model.OPMThing;

public class OPMStateRenameCommand extends Command {
	
	private String oldName, newName;
	private OPMState model;

	@Override public void execute() {
		oldName = model.getName();
		model.setName(newName);
	}

	@Override public void undo() {
		model.setName(oldName);
	}
	
	public void setNewName(String newName) {
		this.newName = newName;
	}
	
	public void setModel(OPMState model) {
		this.model = model;
	}
}