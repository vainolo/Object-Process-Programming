/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.model.OPPNamedElement;
import com.vainolo.phd.opp.validation.OPPNamedElementValidator;

public class OPPNamedElementRenameCommand extends Command {

  private String oldName, newName;
  private OPPNamedElement model;
  private OPPNamedElementValidator validator = new OPPNamedElementValidator();

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