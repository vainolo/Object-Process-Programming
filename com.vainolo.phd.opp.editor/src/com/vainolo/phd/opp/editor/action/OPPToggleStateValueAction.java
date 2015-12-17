/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.action;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import com.vainolo.phd.opp.editor.part.OPPStateEditPart;

public class OPPToggleStateValueAction extends SelectionAction {

  public static final String TOGGLE_VALUE_STATE_ID = "ToggleValueState";
  public static final String TOGGLE_VALUE_STATE_REQUEST = "ToggleValueState";
  private Request request;

  public OPPToggleStateValueAction(IWorkbenchPart part) {
    super(part);
    request = new Request(TOGGLE_VALUE_STATE_REQUEST);
    setId(TOGGLE_VALUE_STATE_ID);
    setText("Toggle State Value");
  }

  @Override
  protected boolean calculateEnabled() {
    if(getSelectedObjects().size() != 1) {
      return false;
    }
    Object selectedObject = getSelectedObjects().get(0);
    if(!OPPStateEditPart.class.isInstance(selectedObject)) {
      return false;
    }

    return true;
  }

  public Request getRequest() {
    return request;
  }

  @Override
  public void run() {
    OPPStateEditPart editPart = OPPStateEditPart.class.cast(getSelectedObjects().get(0));
    Command command = editPart.getCommand(getRequest());
    execute(command);
  }

}
