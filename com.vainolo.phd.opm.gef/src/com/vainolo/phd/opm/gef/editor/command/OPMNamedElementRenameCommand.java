/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMNamedElement;

public class OPMNamedElementRenameCommand extends Command {

	private String oldName, newName;
	private OPMNamedElement model;

	@Override
	public void execute() {
		oldName = model.getName();
		model.setName(newName);
	}

	@Override
	public void undo() {
		model.setName(oldName);
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public void setModel(OPMNamedElement model) {
		this.model = model;
	}
}