package com.vainolo.phd.opp.editor.action;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import com.vainolo.phd.opp.editor.part.OPMStateEditPart;

public class OPMToggleStateValueAction extends SelectionAction {

  public static final String TOGGLE_VALUE_STATE_ID = "ToggleValueState";
  public static final String TOGGLE_VALUE_STATE_REQUEST = "ToggleValueState";
  private Request request;

  public OPMToggleStateValueAction(IWorkbenchPart part) {
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
    if(!OPMStateEditPart.class.isInstance(selectedObject)) {
      return false;
    }

    return true;
  }

  public Request getRequest() {
    return request;
  }

  @Override
  public void run() {
    OPMStateEditPart editPart = OPMStateEditPart.class.cast(getSelectedObjects().get(0));
    Command command = editPart.getCommand(getRequest());
    execute(command);
  }

}
