/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.policy;

import static com.vainolo.phd.opp.editor.figure.OPPFigureUtils.*;
import static com.vainolo.phd.opp.editor.policy.OPPBendpointUtils.*;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.BendpointEditPolicy;
import org.eclipse.gef.requests.BendpointRequest;

import com.vainolo.phd.opp.model.*;

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
    OPPStructuralLinkPart link = (OPPStructuralLinkPart) request.getSource().getModel();
    int index = request.getIndex();
    if (index <= 1 || index >= link.getBendpoints().size() - 2)
      return UnexecutableCommand.INSTANCE;

    return getCommandToDeleteBendpoint(link, index);
  }

  @Override
  protected Command getMoveBendpointCommand(BendpointRequest request) {
    OPPStructuralLinkPart link = (OPPStructuralLinkPart) request.getSource().getModel();
    OPPNode source = link.getSource(), target = link.getTarget();
    Point newPoint = request.getLocation();
    int index = request.getIndex();
    Point currPoint = pointFromOPPPoint(link.getBendpoints().get(index));
    CompoundCommand cc = new CompoundCommand();

    if ((index == 0 || index == link.getBendpoints().size() - 1) || (link.getBendpoints().size() == 2))
      return UnexecutableCommand.INSTANCE;

    if (index == link.getBendpoints().size() - 2) { // "last" bendpoint
      if (target instanceof OPPStructuralLinkAggregator) { // "first" part
        return getCommanToMoveLastBendpointBeforeAggregator(link, index, newPoint);
      } else if (target instanceof OPPThing) { // "second" part
        return getCommantToMoveLastBendpointBeforeTarget(link, rectangleFromOPPNode(target), index, currPoint, newPoint);
      } else {
        throw new IllegalStateException();
      }
    }

    if (index == 1) { // "first" bendpoint
      if (source instanceof OPPThing) { // "first" part
        return getCommandToMoveFirstBendpointAfterThing(link, newPoint);
      } else if (source instanceof OPPStructuralLinkAggregator) { // "second" part
        return getCommandToMoveFirstBendpointAfterAggregator(link, newPoint);
      } else {
        throw new IllegalStateException();
      }
    }

    if (index > 1 && index < link.getBendpoints().size() - 2)
      return getCommandToMoveInternalBendpoint(link, index, newPoint);

    return cc;
  }
}
