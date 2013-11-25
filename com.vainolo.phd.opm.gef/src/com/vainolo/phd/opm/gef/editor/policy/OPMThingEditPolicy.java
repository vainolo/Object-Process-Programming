package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;

import com.vainolo.phd.opm.gef.editor.action.ThingInZoomAction;
import com.vainolo.phd.opm.gef.editor.command.ThingInZoomCommand;
import com.vainolo.phd.opm.gef.editor.part.OPMThingEditPart;

public class OPMThingEditPolicy extends GraphicalEditPolicy {
  public static final String ID = "OPMThingEditPolicy";

  private Command thingInZoom() {
    OPMThingEditPart part = (OPMThingEditPart) getHost();
    ThingInZoomCommand command = new ThingInZoomCommand(part);
    return command;
  }

  @Override
  public Command getCommand(Request request) {
    if(request.getType().equals(ThingInZoomAction.THING_IN_ZOOM_REQUEST)) {
      return thingInZoom();
    } else {
      return super.getCommand(request);
    }
  }

}
