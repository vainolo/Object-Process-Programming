package com.vainolo.phd.opp.editor.action;

import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import com.vainolo.phd.opp.editor.part.OPMThingEditPart;

public class OPMThingInZoomAction extends SelectionAction {

  public static final String THING_IN_ZOOM_ID = "CreateInZoomedOPD";
  public static final String THING_IN_ZOOM_REQUEST = "CreateInZoomedOPD";
  private Request request;

  public OPMThingInZoomAction(IWorkbenchPart part) {
    super(part);
    setId(THING_IN_ZOOM_ID);
    setText("In-Zoom");
    request = new Request(THING_IN_ZOOM_REQUEST);
  }

  @Override
  protected boolean calculateEnabled() {
    @SuppressWarnings("rawtypes")
    List editParts = getSelectedObjects();
    if(editParts.size() != 1)
      return false;
    Object editPart = editParts.get(0);
    if(!OPMThingEditPart.class.isInstance(editPart))
      return false;

    return true;
  }

  @Override
  public void run() {
    OPMThingEditPart editPart = (OPMThingEditPart) getSelectedObjects().get(0);
    Command command = editPart.getCommand(request);
    execute(command);
  }

}
