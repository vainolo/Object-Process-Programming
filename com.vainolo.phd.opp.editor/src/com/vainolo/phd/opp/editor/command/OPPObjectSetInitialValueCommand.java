/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
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