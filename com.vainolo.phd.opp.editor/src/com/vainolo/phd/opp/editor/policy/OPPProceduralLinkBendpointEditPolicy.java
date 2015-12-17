/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.policy;

import org.eclipse.draw2d.geometry.Point;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.BendpointEditPolicy;
import org.eclipse.gef.requests.BendpointRequest;

import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.editor.command.OPPLinkCreateBendpointCommand;
import com.vainolo.phd.opp.editor.command.OPPLinkDeleteBendpointCommand;
import com.vainolo.phd.opp.editor.command.OPPLinkMoveBendpointCommand;

/**
 * Policy used by the {@link OPMLink} to manage link bendpoints.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPPProceduralLinkBendpointEditPolicy extends BendpointEditPolicy {

  /**
   * {@inheritDoc}
   */
  @Override
  protected Command getCreateBendpointCommand(final BendpointRequest request) {
    OPPLinkCreateBendpointCommand command = new OPPLinkCreateBendpointCommand();
    Point p = request.getLocation();
    command.setLink((OPPLink) request.getSource().getModel());
    command.setLocation(p);
    command.setIndex(request.getIndex());
    return command;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Command getMoveBendpointCommand(final BendpointRequest request) {
    OPPLinkMoveBendpointCommand command = new OPPLinkMoveBendpointCommand();
    Point p = request.getLocation();
    command.setLink((OPPLink) request.getSource().getModel());
    command.setLocation(p);
    command.setIndex(request.getIndex());
    return command;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Command getDeleteBendpointCommand(final BendpointRequest request) {
    OPPLinkDeleteBendpointCommand command = new OPPLinkDeleteBendpointCommand();
    command.setLink((OPPLink) request.getSource().getModel());
    command.setIndex(request.getIndex());
    return command;
  }
}
