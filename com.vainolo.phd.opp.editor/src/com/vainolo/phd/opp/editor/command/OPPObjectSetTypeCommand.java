/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.model.OPPObject;

public class OPPObjectSetTypeCommand extends Command {

  private String oldType, newType;
  private OPPObject model;

  @Override
  public boolean canExecute() {
    return model != null;
  }

  @Override
  public void execute() {
    oldType = model.getType();
    model.setType(newType);
  }

  @Override
  public void undo() {
    model.setType(oldType);
  }

  public void setNewType(String newType) {
    this.newType = newType;
  }

  public void setModel(OPPObject model) {
    this.model = model;
  }
}