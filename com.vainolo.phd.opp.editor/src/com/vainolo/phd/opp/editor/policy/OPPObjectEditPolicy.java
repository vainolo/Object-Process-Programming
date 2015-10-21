package com.vainolo.phd.opp.editor.policy;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;

import com.vainolo.phd.opp.editor.action.OPPToggleGlobalObjectAction;
import com.vainolo.phd.opp.editor.command.OPPToggleGlobalObjectCommand;
import com.vainolo.phd.opp.editor.part.OPPObjectEditPart;
import com.vainolo.phd.opp.model.OPPObject;

public class OPPObjectEditPolicy extends GraphicalEditPolicy {
  public static final String ID = "OPMObjectEditPolicy";

  @Override
  public Command getCommand(Request request) {
    if (request.getType().equals(OPPToggleGlobalObjectAction.TOGGLE_GLOBAL_OBJECT_REQUEST)) {
      return toggleGlobalObject();
    } else {
      return super.getCommand(request);
    }
  }

  private Command toggleGlobalObject() {
    OPPObjectEditPart part = (OPPObjectEditPart) getHost();
    OPPToggleGlobalObjectCommand command = new OPPToggleGlobalObjectCommand();
    command.setObject((OPPObject) part.getModel());
    return command;
  }
}
