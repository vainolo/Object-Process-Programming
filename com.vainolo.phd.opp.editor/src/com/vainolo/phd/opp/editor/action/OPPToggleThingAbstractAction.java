/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.action;

import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import com.vainolo.phd.opp.editor.part.OPPThingEditPart;

public class OPPToggleThingAbstractAction extends SelectionAction {

  public static final String TOGGLE_ABSTRACT_ID = "ToggleAbstract";

  public static final String TOGGLE_ABSTRACT_REQUEST = "ToggleAbstract";

  private final Request request;

  public OPPToggleThingAbstractAction(IWorkbenchPart part) {
    super(part);
    request = new Request(TOGGLE_ABSTRACT_REQUEST);
    setId(TOGGLE_ABSTRACT_ID);
    setText("Toggle Abstract");
  }

  public Request getRequest() {
    return request;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void run() {
    List<OPPThingEditPart> editParts = getSelectedObjects();
    CompoundCommand compoundCommand = new CompoundCommand();
    for (OPPThingEditPart thingEditPart : editParts) {
      compoundCommand.add(thingEditPart.getCommand(getRequest()));
    }
    execute(compoundCommand);
  }

  @Override
  protected boolean calculateEnabled() {
    if (getSelectedObjects().isEmpty()) {
      return false;
    }
    for (Object selectedObject : getSelectedObjects()) {
      if (!OPPThingEditPart.class.isInstance(selectedObject)) {
        return false;
      }
    }
    return true;
  }
}
