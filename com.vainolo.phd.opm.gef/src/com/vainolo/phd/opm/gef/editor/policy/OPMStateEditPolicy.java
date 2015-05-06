package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;

import com.google.common.base.Preconditions;
import com.vainolo.phd.opm.gef.editor.action.OPMToggleStateValueAction;
import com.vainolo.phd.opm.gef.editor.command.OPMToggleStateValueCommand;
import com.vainolo.phd.opm.gef.editor.part.OPMStateEditPart;

public class OPMStateEditPolicy extends GraphicalEditPolicy {
  public static final String STATE_EDIT_ROLE = "StateEditRole";

  @Override
  public Command getCommand(Request request) {
    Preconditions.checkState(OPMStateEditPart.class.isInstance(getHost()));
    OPMStateEditPart editPart = OPMStateEditPart.class.cast(getHost());
    if(request.getType().equals(OPMToggleStateValueAction.TOGGLE_VALUE_STATE_REQUEST)) {
      return new OPMToggleStateValueCommand(editPart);
    } else {
      return super.getCommand(request);
    }
  }
}
