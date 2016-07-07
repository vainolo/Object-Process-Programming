/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.policy;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.BendpointEditPolicy;
import org.eclipse.gef.requests.BendpointRequest;

import com.vainolo.phd.opp.model.*;

public class OPPStructuralLinkBendpointEditPolicy extends BendpointEditPolicy {

  private OPPBendpointUtils bpu = new OPPBendpointUtils();

  @Override
  protected Command getCreateBendpointCommand(BendpointRequest request) {
    OPPStructuralLinkPart link = (OPPStructuralLinkPart) request.getSource().getModel();
    int index = request.getIndex();
    Point newPoint = request.getLocation();

    return bpu.getCommandToCreateBendpoint(link, index, newPoint);
  }

  @Override
  protected Command getDeleteBendpointCommand(BendpointRequest request) {
    OPPStructuralLinkPart link = (OPPStructuralLinkPart) request.getSource().getModel();
    int index = request.getIndex();
    if (index == 0 || index == link.getBendpoints().size() - 1)
      return UnexecutableCommand.INSTANCE;

    return bpu.getCommandToDeleteBendpoint(link, index);
  }

  @Override
  protected Command getMoveBendpointCommand(BendpointRequest request) {
    OPPStructuralLinkPart link = (OPPStructuralLinkPart) request.getSource().getModel();
    OPPNode source = link.getSource(), target = link.getTarget();
    Point newPoint = request.getLocation();
    int index = request.getIndex();
    CompoundCommand cc = new CompoundCommand();

    if ((index == 0 || index == link.getBendpoints().size() - 1) || (link.getBendpoints().size() == 2))
      return UnexecutableCommand.INSTANCE;

    if (bpu.isFirstBendpoint(index) && (source instanceof OPPStructuralLinkAggregator)) {
      return bpu.getCommandToMoveFirstBendpointAfterAggregator(link, newPoint);
    } else if (bpu.isLastBendpoint(index, link.getBendpoints()) && (target instanceof OPPStructuralLinkAggregator)) {
      return bpu.getCommanToMoveLastBendpointBeforeAggregator(link, index, newPoint);
    } else if (bpu.isFirstBendpoint(index) && (source instanceof OPPNode)) {
      return bpu.getCommandToMoveFirstBendpointAfterThing(link, newPoint); // HERE
    } else if (bpu.isLastBendpoint(index, link.getBendpoints()) && (target instanceof OPPNode)) {
      return bpu.getCommantToMoveLastBendpointBeforeTarget(link, newPoint);
    } else {
      return bpu.getCommandToMoveInternalBendpoint(link, index, newPoint);
    }
  }
}
