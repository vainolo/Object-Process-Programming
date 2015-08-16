/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.model.OPPNamedElement;
import com.vainolo.phd.opp.validation.OPMNamedElementValidator;

public class OPMNamedElementRenameCommand extends Command {

  private String oldName, newName;
  private OPPNamedElement model;
  private OPMNamedElementValidator validator = new OPMNamedElementValidator();

  @Override
  public boolean canExecute() {
    return validator.validateRename(model, newName);
  }

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

  public void setModel(OPPNamedElement model) {
    this.model = model;
  }
}