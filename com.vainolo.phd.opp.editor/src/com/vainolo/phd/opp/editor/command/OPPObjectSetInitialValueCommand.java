/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.model.OPPObject;

public class OPPObjectSetInitialValueCommand extends Command {

  private String oldInitialValue, newInitialValue;
  private OPPObject model;

  @Override
  public boolean canExecute() {
    return model != null && newInitialValue != null;
  }

  @Override
  public void execute() {
    oldInitialValue = model.getInitialValue();
    model.setInitialValue(newInitialValue);
  }

  @Override
  public void undo() {
    model.setInitialValue(oldInitialValue);
  }

  public void setNewInitialValue(String newInitialValue) {
    this.newInitialValue = newInitialValue;
  }

  public void setModel(OPPObject model) {
    this.model = model;
  }
}