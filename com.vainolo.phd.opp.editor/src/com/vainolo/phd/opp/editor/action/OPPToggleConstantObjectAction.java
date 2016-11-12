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

import com.vainolo.phd.opp.editor.part.OPPObjectEditPart;
import com.vainolo.phd.opp.editor.part.OPPThingEditPart;

public class OPPToggleConstantObjectAction extends SelectionAction {

  public static final String TOGGLE_CONSTANTOBJECT_ID = "ToggleConstantObject";

  public static final String TOGGLE_CONSTANT_OBJECT_REQUEST = "ToggleConstantObject";

  private final Request request;

  public OPPToggleConstantObjectAction(IWorkbenchPart part) {
    super(part);
    request = new Request(TOGGLE_CONSTANT_OBJECT_REQUEST);
    setId(TOGGLE_CONSTANTOBJECT_ID);
    setText("Toggle Constant");
  }

  public Request getRequest() {
    return request;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void run() {
    List<OPPObjectEditPart> editParts = getSelectedObjects();
    CompoundCommand compoundCommand = new CompoundCommand();
    for (OPPObjectEditPart thingEditPart : editParts) {
      compoundCommand.add(thingEditPart.getCommand(getRequest()));
    }
    execute(compoundCommand);
  }

  /**
   * {@inheritDoc}
   * <p>
   * The action is enabled if all the selected entities on the editor are {@link OPPThingEditPart} instances
   * </p>
   */
  @Override
  protected boolean calculateEnabled() {
    if (getSelectedObjects().isEmpty()) {
      return false;
    }
    for (Object selectedObject : getSelectedObjects()) {
      if (!(selectedObject instanceof OPPObjectEditPart)) {
        return false;
      }
    }
    return true;
  }
}
