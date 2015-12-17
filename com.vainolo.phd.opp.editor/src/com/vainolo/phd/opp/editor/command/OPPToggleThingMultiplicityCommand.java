/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.editor.part.OPPThingEditPart;
import com.vainolo.phd.opp.model.OPPThing;

public class OPPToggleThingMultiplicityCommand extends Command {

  private OPPThingEditPart part;

  public OPPToggleThingMultiplicityCommand(OPPThingEditPart part) {
    this.part = part;
  }

  @Override
  public void execute() {
    OPPThing model = (OPPThing) part.getModel();
    model.setCollection(!model.isCollection());
  }

  @Override
  public void undo() {
    execute();
  }

}
