package com.vainolo.phd.opp.editor.policy;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;

import com.vainolo.phd.opp.editor.action.OPMThingInZoomAction;
import com.vainolo.phd.opp.editor.action.OPMToggleThingMultiplicityAction;
import com.vainolo.phd.opp.editor.command.OPMThingInZoomCommand;
import com.vainolo.phd.opp.editor.command.OPMToggleThingMultiplicityCommand;
import com.vainolo.phd.opp.editor.part.OPMThingEditPart;

public class OPMThingEditPolicy extends GraphicalEditPolicy {
  public static final String ID = "OPMThingEditPolicy";

  private Command thingInZoom() {
    OPMThingEditPart part = (OPMThingEditPart) getHost();
    OPMThingInZoomCommand command = new OPMThingInZoomCommand(part);
    return command;
  }

  private Command toggleMultiplicity() {
    OPMThingEditPart part = (OPMThingEditPart) getHost();
    OPMToggleThingMultiplicityCommand command = new OPMToggleThingMultiplicityCommand(part);
    return command;
  }

  @Override
  public Command getCommand(Request request) {
    if(request.getType().equals(OPMThingInZoomAction.THING_IN_ZOOM_REQUEST)) {
      return thingInZoom();
    } else if(request.getType().equals(OPMToggleThingMultiplicityAction.TOGGLE_MULTIPLICITY_REQUEST)) {
      return toggleMultiplicity();
    } else {
      return super.getCommand(request);
    }
  }

}
