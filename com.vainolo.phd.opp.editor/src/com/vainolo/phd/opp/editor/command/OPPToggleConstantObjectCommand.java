/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.model.OPPObject;

public class OPPToggleConstantObjectCommand extends Command {

  private OPPObject object;

  public void setObject(OPPObject object) {
    this.object = object;
  }

  @Override
  public void execute() {
    object.setConstant(!object.isConstant());
  }

  @Override
  public void undo() {
    execute();
  }

}
