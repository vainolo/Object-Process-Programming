/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.policy;

import org.eclipse.draw2d.IFigure;
import static com.vainolo.phd.opp.editor.figure.OPPFigureUtils.*;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.BendpointEditPolicy;
import org.eclipse.gef.requests.BendpointRequest;

import com.google.common.base.Preconditions;
import com.vainolo.phd.opp.editor.command.OPPLinkCreateBendpointCommand;
import com.vainolo.phd.opp.editor.command.OPPLinkDeleteBendpointCommand;
import com.vainolo.phd.opp.editor.command.OPPLinkMoveBendpointCommand;
import com.vainolo.phd.opp.editor.figure.OPPFigureUtils;
import com.vainolo.phd.opp.editor.figure.OPPStructuralLinkPartFigure;
import com.vainolo.phd.opp.model.*;
import com.vainolo.phd.opp.utilities.OPPLogger;

public class OPPStructuralLinkBendpointEditPolicy extends BendpointEditPolicy {

  @Override
  protected Command getCreateBendpointCommand(BendpointRequest request) {
    return UnexecutableCommand.INSTANCE;
    // CompoundCommand cc = new CompoundCommand();
    // OPPLinkCreateBendpointCommand command = new OPPLinkCreateBendpointCommand();
    // Point p = request.getLocation();
    // command.setLink((OPPLink) request.getSource().getModel());
    // command.setLocation(p);
    // command.setIndex(request.getIndex());
    // cc.add(command);
    // return cc;
  }

  @Override
  protected Command getDeleteBendpointCommand(BendpointRequest request) {
    return UnexecutableCommand.INSTANCE;
  }

  @Override
  protected Command getMoveBendpointCommand(BendpointRequest request) {
    OPPStructuralLinkPart link = (OPPStructuralLinkPart) request.getSource().getModel();
    OPPNode source = link.getSource(), target = link.getTarget();
    Point newPoint = request.getLocation();
    int index = request.getIndex();
    Point currPoint = pointFromOPPPoint(link.getBendpoints().get(index));
    CompoundCommand cc = new CompoundCommand();

    if (index == 0 || index == link.getBendpoints().size() - 1)
      return UnexecutableCommand.INSTANCE;

    if (index == link.getBendpoints().size() - 2) {
      Point pbp = pointFromOPPPoint(link.getBendpoints().get(index - 1));
      Point endpoint = getStructuralLinkEndpoint(target, newPoint);

      if (isBetween(newPoint.x, target.getX(), target.getX() + target.getWidth()) && isBetween(newPoint.y, target.getY(), target.getY() + target.getHeight()))
        return null;

      if (isBetween(currPoint.x, target.getX(), target.getX() + target.getWidth())) {
        // above or below
        if (endpoint.y == target.getY() || endpoint.y == target.getY() + target.getHeight()) {
          // still above or below
          cc.add(newMoveBendpointCommand(link, index, newPoint.setX(endpoint.x)));
          cc.add(newMoveBendpointCommand(link, index + 1, endpoint));
          cc.add(newMoveBendpointCommand(link, index - 1, pbp.setY(newPoint.y)));
        } else {
          // Moving to the sides
          cc.add(newMoveBendpointCommand(link, index, newPoint));
          cc.add(newMoveBendpointCommand(link, index + 1, endpoint));
          cc.add(newCreateBendpointCommand(link, index, (new Point()).setX(newPoint.x).setY(pbp.y)));
        }
      } else {
        // on the sides
        if (endpoint.x == target.getX() || endpoint.x == target.getX() + target.getWidth()) {
          // still on the sides
          cc.add(newMoveBendpointCommand(link, index, newPoint.setY(endpoint.y)));
          cc.add(newMoveBendpointCommand(link, index + 1, endpoint));
          cc.add(newMoveBendpointCommand(link, index - 1, pbp.setX(newPoint.x)));
        } else {
          // Moving above or below
          cc.add(newMoveBendpointCommand(link, index, newPoint));
          cc.add(newMoveBendpointCommand(link, index + 1, endpoint));
          cc.add(newCreateBendpointCommand(link, index, pbp.setY(newPoint.y)));
        }
      }
    }
    return cc;
  }
}
