/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.action;

import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import com.vainolo.phd.opp.editor.part.OPPThingEditPart;

public class OPPThingInZoomAction extends SelectionAction {

  public static final String THING_IN_ZOOM_ID = "InZoomOPD";
  public static final String THING_IN_ZOOM_REQUEST = "InZoomOPD";
  private Request request;

  public OPPThingInZoomAction(IWorkbenchPart part) {
    super(part);
    setId(THING_IN_ZOOM_ID);
    setText("In-Zoom");
    request = new Request(THING_IN_ZOOM_REQUEST);
  }

  @Override
  protected boolean calculateEnabled() {
    @SuppressWarnings("rawtypes")
    List editParts = getSelectedObjects();
    if (editParts.size() != 1)
      return false;
    Object editPart = editParts.get(0);
    if (!OPPThingEditPart.class.isInstance(editPart))
      return false;

    return true;
  }

  @Override
  public void run() {
    OPPThingEditPart editPart = (OPPThingEditPart) getSelectedObjects().get(0);
    Command command = editPart.getCommand(request);
    command.execute();
  }

}
