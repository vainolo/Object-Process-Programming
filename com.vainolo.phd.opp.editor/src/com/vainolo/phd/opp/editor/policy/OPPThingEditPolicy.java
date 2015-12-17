/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.policy;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;

import com.vainolo.phd.opp.editor.action.OPPThingInZoomAction;
import com.vainolo.phd.opp.editor.action.OPPToggleThingMultiplicityAction;
import com.vainolo.phd.opp.editor.action.OPPThingUnfoldAction;
import com.vainolo.phd.opp.editor.command.OPPThingInZoomCommand;
import com.vainolo.phd.opp.editor.command.OPPThingUnfoldCommand;
import com.vainolo.phd.opp.editor.command.OPPToggleThingMultiplicityCommand;
import com.vainolo.phd.opp.editor.part.OPPThingEditPart;

public class OPPThingEditPolicy extends GraphicalEditPolicy {
  public static final String ID = "OPMThingEditPolicy";

  private Command thingInZoom() {
    OPPThingEditPart part = (OPPThingEditPart) getHost();
    OPPThingInZoomCommand command = new OPPThingInZoomCommand(part);
    return command;
  }

  private Command thingUnfold() {
    OPPThingEditPart part = (OPPThingEditPart) getHost();
    OPPThingUnfoldCommand command = new OPPThingUnfoldCommand(part);
    return command;
  }

  private Command toggleMultiplicity() {
    OPPThingEditPart part = (OPPThingEditPart) getHost();
    OPPToggleThingMultiplicityCommand command = new OPPToggleThingMultiplicityCommand(part);
    return command;
  }

  @Override
  public Command getCommand(Request request) {
    if (request.getType().equals(OPPThingInZoomAction.THING_IN_ZOOM_REQUEST)) {
      return thingInZoom();
    } else if (request.getType().equals(OPPThingUnfoldAction.THING_UNFOLD_REQUEST)) {
      return thingUnfold();
    } else if (request.getType().equals(OPPToggleThingMultiplicityAction.TOGGLE_MULTIPLICITY_REQUEST)) {
      return toggleMultiplicity();
    } else {
      return super.getCommand(request);
    }
  }

}
