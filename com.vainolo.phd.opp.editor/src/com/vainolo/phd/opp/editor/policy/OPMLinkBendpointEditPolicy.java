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

import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opp.editor.command.OPMLinkCreateBendpointCommand;
import com.vainolo.phd.opp.editor.command.OPMLinkDeleteBendpointCommand;
import com.vainolo.phd.opp.editor.command.OPMLinkMoveBendpointCommand;

/**
 * Policy used by the {@link OPMLink} to manage link bendpoints.
 * 
 * @author vainolo
 * 
 */
public class OPMLinkBendpointEditPolicy extends BendpointEditPolicy {

  /**
   * {@inheritDoc}
   */
  @Override
  protected Command getCreateBendpointCommand(final BendpointRequest request) {
    OPMLinkCreateBendpointCommand command = new OPMLinkCreateBendpointCommand();

    Point p = request.getLocation();

    command.setOPMLink(OPMProceduralLink.class.cast(request.getSource().getModel()));
    command.setLocation(p);
    command.setIndex(request.getIndex());

    return command;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Command getMoveBendpointCommand(final BendpointRequest request) {
    OPMLinkMoveBendpointCommand command = new OPMLinkMoveBendpointCommand();

    Point p = request.getLocation();

    command.setOPMLink(OPMProceduralLink.class.cast(request.getSource().getModel()));
    command.setLocation(p);
    command.setIndex(request.getIndex());

    return command;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Command getDeleteBendpointCommand(final BendpointRequest request) {
    OPMLinkDeleteBendpointCommand command = new OPMLinkDeleteBendpointCommand();

    command.setOPMLink(OPMProceduralLink.class.cast(request.getSource().getModel()));
    command.setIndex(request.getIndex());
    return command;
  }
}
