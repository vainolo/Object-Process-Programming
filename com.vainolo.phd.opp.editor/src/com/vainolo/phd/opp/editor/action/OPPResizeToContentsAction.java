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

import com.vainolo.phd.opp.editor.part.OPPNodeEditPart;

public class OPPResizeToContentsAction extends SelectionAction {

  public static final String RESIZE_TO_CONTENTS_ID = "ResizeToContents";
  public static final String RESIZE_TO_CONTENTS_REQUEST = "ResizeToContents";

  private final Request request;

  public OPPResizeToContentsAction(IWorkbenchPart part) {
    super(part);
    setId(RESIZE_TO_CONTENTS_ID);
    setText("Resize to Contents");
    request = new Request(RESIZE_TO_CONTENTS_REQUEST);
  }

  @Override
  public void run() {
    // selected objects must be nodes because the action is enabled.
    @SuppressWarnings("unchecked")
    List<OPPNodeEditPart> editParts = getSelectedObjects();
    CompoundCommand compoundCommand = new CompoundCommand();
    for(OPPNodeEditPart nodeEditPart : editParts) {
      compoundCommand.add(nodeEditPart.getCommand(request));
    }
    execute(compoundCommand);
  }

  /**
   * {@inheritDoc}
   * <p>
   * The action is enabled if all the selected entities on the editor are
   * {@link OPPNodeEditPart} instances
   * </p>
   */
  @Override
  protected boolean calculateEnabled() {
    if(getSelectedObjects().isEmpty()) {
      return false;
    }
    for(Object selectedObject : getSelectedObjects()) {
      if(!(selectedObject instanceof OPPNodeEditPart)) {
        return false;
      }
    }
    return true;
  }
}
