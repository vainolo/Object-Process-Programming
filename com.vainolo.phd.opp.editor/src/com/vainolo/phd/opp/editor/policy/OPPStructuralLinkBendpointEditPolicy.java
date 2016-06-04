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
    // CompoundCommand cc = new CompoundCommand();
    // OPPLinkDeleteBendpointCommand command = new OPPLinkDeleteBendpointCommand();
    // command.setLink((OPPLink) request.getSource().getModel());
    // command.setIndex(request.getIndex());
    // cc.add(command);
    // return cc;
  }

  @Override
  protected Command getMoveBendpointCommand(BendpointRequest request) {
    OPPStructuralLinkPart link = (OPPStructuralLinkPart) request.getSource().getModel();
    OPPNode source = link.getSource(), target = link.getTarget();
    Point newPoint = request.getLocation();
    int index = request.getIndex();
    Point currentPoint = pointFromOPPPoint(link.getBendpoints().get(index));
    CompoundCommand cc = new CompoundCommand();

    if (index == 0 || index == link.getBendpoints().size() - 1)
      return UnexecutableCommand.INSTANCE;

    if (index == link.getBendpoints().size() - 2) {
      Point pbp = pointFromOPPPoint(link.getBendpoints().get(index - 1));

      if (isBetween(currentPoint.x, left(target), right(target)) && isBetween(newPoint.x, left(target), right(target))) {
        // inside vertical range
        cc.add(newMoveBendpointCommand(link, index, newPoint));
        cc.add(newMoveBendpointCommand(link, index + 1, getStructuralLinkEndpointForObjectOrState(target, newPoint)));
        cc.add(newMoveBendpointCommand(link, index - 1, pbp.setY(newPoint.y)));
      } else if (isBetween(currentPoint.x, left(target), right(target)) && isBetween(newPoint.y, top(target), bottom(target))) {
        // move from vertical to horizontal
        if ((pbp.x < left(target) && newPoint.x < left(target)) || (pbp.x > right(target) && newPoint.x > right(target))) {
          cc.add(newDeleteBendpointCcommand(link, index));
          cc.add(newMoveBendpointCommand(link, index, getStructuralLinkEndpointForObjectOrState(target, newPoint)));
          cc.add(newMoveBendpointCommand(link, index - 1, pbp.setY(newPoint.y)));
        } else {
          cc.add(newMoveBendpointCommand(link, index, newPoint));
          cc.add(newMoveBendpointCommand(link, index + 1, getStructuralLinkEndpointForObjectOrState(target, newPoint)));
          cc.add(newCreateBendpointCommand(link, index, (new Point()).setX(newPoint.x).setY(pbp.y)));
        }
      } else if (isBetween(currentPoint.y, top(target), bottom(target)) && isBetween(newPoint.y, top(target), bottom(target))) {
        // inside horizontal range
        cc.add(newMoveBendpointCommand(link, index, newPoint));
        cc.add(newMoveBendpointCommand(link, index + 1, getStructuralLinkEndpointForObjectOrState(target, newPoint)));
        cc.add(newMoveBendpointCommand(link, index - 1, pbp.setX(newPoint.x)));
      } else if (isBetween(currentPoint.y, top(target), bottom(target)) && isBetween(newPoint.x, left(target), right(target))) {
        // Move from horizontal to vertical
        cc.add(newMoveBendpointCommand(link, index, newPoint));
        cc.add(newMoveBendpointCommand(link, index + 1, getStructuralLinkEndpointForObjectOrState(target, newPoint)));
        cc.add(newCreateBendpointCommand(link, index, pbp.setY(newPoint.y)));
      }

    }

    return cc;
  }

  private Command getMoveLastBendpointBeforeThingCommand(OPPStructuralLinkPart link, int index, Point newPoint) {
    OPPNode source = link.getSource(), target = link.getTarget();
    CompoundCommand cc = new CompoundCommand();

    if (newPoint.y > bottom(target)) {
      OPPLogger.logInfo("Cannot move bendpoint below target node.");
      return null;
    }

    Point targetPoint = getStructuralLinkEndpointForObjectOrState(target, newPoint);
    if (target != null) {

    } else {
      if (newPoint.y > bottom(target)) {
        OPPLogger.logInfo("Cannot create bendpoint below target node.");
        return null;
      }

      if (newPoint.y < target.getY()) {
        cc.add(newMoveBendpointCommand(link, index, new Point(newPoint.x, newPoint.y)));
        cc.add(newMoveBendpointCommand(link, index + 1, new Point(newPoint.x, getCenter(target).y)));
        cc.add(newCreateBendpointCommand(link, index + 2, getStructuralLinkEndpointForObjectOrState(target, new Point(newPoint.x, getCenter(target).y))));
      } else {

      }

    }

    OPPLinkMoveBendpointCommand mbc = new OPPLinkMoveBendpointCommand();
    mbc.setLink(link);
    mbc.setIndex(4);
    mbc.setLocation(newPoint);
    cc.add(mbc);

    mbc = new OPPLinkMoveBendpointCommand();
    mbc.setLink(link);
    mbc.setIndex(5);
    mbc.setLocation(targetPoint);
    cc.add(mbc);

    if (newPoint.y != link.getBendpoints().get(3).getY()) {
      mbc = new OPPLinkMoveBendpointCommand();
      mbc.setLink(link);
      mbc.setIndex(3);
      mbc.setLocation(new Point(link.getBendpoints().get(3).getX(), newPoint.y));
      cc.add(mbc);
    }
    return cc;
  }

  private OPPLinkMoveBendpointCommand newMoveBendpointCommand(OPPLink link, int index, Point p) {
    OPPLinkMoveBendpointCommand mbc = new OPPLinkMoveBendpointCommand();
    mbc.setLink(link);
    mbc.setIndex(index);
    mbc.setLocation(p);
    return mbc;
  }

  private OPPLinkCreateBendpointCommand newCreateBendpointCommand(OPPLink link, int index, Point p) {
    OPPLinkCreateBendpointCommand cbc = new OPPLinkCreateBendpointCommand();
    cbc.setLink(link);
    cbc.setIndex(index);
    cbc.setLocation(p);
    return cbc;
  }

  private OPPLinkDeleteBendpointCommand newDeleteBendpointCcommand(OPPLink link, int index) {
    OPPLinkDeleteBendpointCommand dbc = new OPPLinkDeleteBendpointCommand();
    dbc.setLink(link);
    dbc.setIndex(index);
    return dbc;
  }

  private Point getStructuralLinkEndpointForObjectOrState(OPPNode node, Point ref) {
    Preconditions.checkArgument(node instanceof OPPObject || node instanceof OPPProcess);
    Rectangle rect = rectangleFromOPPNode(node);
    if (isBetween(ref.x, rect.x, rect.x + rect.width)) {
      if (ref.y < rect.y)
        return new Point(ref.x, rect.y);
      else
        return new Point(ref.x, rect.y + rect.height);
    } else if (isBetween(ref.y, rect.y, rect.y + rect.height)) {
      if (ref.x < rect.x)
        return new Point(rect.x, ref.y);
      else
        return new Point(rect.x + rect.width, ref.y);
    } else {
      return null;
    }
  }

}
