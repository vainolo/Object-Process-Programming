/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.action;

import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import com.vainolo.phd.opm.gef.editor.part.OPMNodeEditPart;

public class ResizeToContentsAction extends SelectionAction {

  public static final String RESIZE_TO_CONTENTS_ID = "ResizeToContents";
  public static final String RESIZE_TO_CONTENTS_REQUEST = "ResizeToContents";

  private final Request request;

  public ResizeToContentsAction(IWorkbenchPart part) {
    super(part);
    setId(RESIZE_TO_CONTENTS_ID);
    setText("Resize to Contents");
    request = new Request(RESIZE_TO_CONTENTS_REQUEST);
  }

  @Override
  public void run() {
    // selected objects must be nodes because the action is enabled.
    List<OPMNodeEditPart> editParts = getSelectedObjects();
    CompoundCommand compoundCommand = new CompoundCommand();
    for(OPMNodeEditPart nodeEditPart : editParts) {
      compoundCommand.add(nodeEditPart.getCommand(request));
    }
    execute(compoundCommand);
  }

  /**
   * {@inheritDoc}
   * <p>
   * The action is enabled if all the selected entities on the editor are {@link OPMNodeEditPart} instances
   * </p>
   */
  @Override
  protected boolean calculateEnabled() {
    if(getSelectedObjects().isEmpty()) {
      return false;
    }
    for(Object selectedObject : getSelectedObjects()) {
      if(!(selectedObject instanceof OPMNodeEditPart)) {
        return false;
      }
    }
    return true;
  }
}
