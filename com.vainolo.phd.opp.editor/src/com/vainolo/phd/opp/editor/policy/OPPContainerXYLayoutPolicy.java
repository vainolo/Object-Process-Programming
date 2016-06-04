/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.policy;

import java.util.Collection;
import static com.vainolo.phd.opp.editor.figure.OPPFigureUtils.*;
import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.editor.command.OPPLinkCreateBendpointCommand;
import com.vainolo.phd.opp.editor.command.OPPLinkDeleteBendpointCommand;
import com.vainolo.phd.opp.editor.command.OPPNodeChangeConstraintCommand;
import com.vainolo.phd.opp.editor.command.OPPNodeCreateCommand;
import com.vainolo.phd.opp.editor.part.OPPStructuralLinkAggregatorEditPart;
import com.vainolo.phd.opp.editor.utils.OPPModelUtils;
import com.vainolo.phd.opp.model.*;
import com.vainolo.phd.opp.utilities.OPPLogger;
import com.vainolo.phd.opp.utilities.analysis.OPPLinkExtensions;
import com.vainolo.phd.opp.utilities.analysis.OPPNodeExtensions;
import com.vainolo.phd.opp.utilities.analysis.OPPProceduralLinkExtensions;

import static com.vainolo.phd.opp.editor.figure.OPPFigureUtils.bottom;
import static com.vainolo.phd.opp.editor.figure.OPPFigureUtils.getCenter;
import static com.vainolo.phd.opp.editor.figure.OPPFigureUtils.isNodeAboveNode;
import static com.vainolo.phd.opp.editor.figure.OPPFigureUtils.top;

/**
 * This class describes the commands that can be used to change the layout and create new nodes inside the
 * {@link OPMContainer}. This policy should only be installed in edit parts whose model is an {@link OPPContainer}
 * instance.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPPContainerXYLayoutPolicy extends XYLayoutEditPolicy {

  private static final Dimension DEFAULT_THING_DIMENSION = new Dimension(50, 50);

  /**
   * Command created to change the constraints of a {@link OPPNode} instance.
   */
  @Override
  protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
    CompoundCommand cc = new CompoundCommand();
    OPPNodeChangeConstraintCommand command = new OPPNodeChangeConstraintCommand();
    OPPNode node = (OPPNode) child.getModel();
    Rectangle c = (Rectangle) constraint;

    if (node.getWidth() != c.width || node.getHeight() != c.height)
      node.setManualSize(true);

    command.setNode(node);
    command.setNewConstraint(c.x, c.y, c.width, c.height);

    cc.add(command);
    return cc;
  }

  private void moveStructuralLinkBendpoint(OPPStructuralLinkPart link, Rectangle newNodeConstraints, CompoundCommand cc) {
    List<OPPPoint> bendpoints = link.getBendpoints();
    for (int i = 0; i < bendpoints.size(); i++) {
      OPPLinkDeleteBendpointCommand dbc = new OPPLinkDeleteBendpointCommand();
      dbc.setLink(link);
      dbc.setIndex(0);
      cc.add(dbc);
    }

    for (Point p : createInitialBendpointsForStructuralLinkSegment(link.getSource(), newNodeConstraints)) {
      OPPLinkCreateBendpointCommand bpc = new OPPLinkCreateBendpointCommand();
      bpc.setLink(link);
      bpc.setLocation(p);
      cc.add(bpc);
    }

  }

  /**
   * Command created to add new nodes to a container.
   */
  @Override
  protected Command getCreateCommand(CreateRequest request) {
    OPPContainer model = (OPPContainer) getHost().getModel();
    OPPNode node = (OPPNode) request.getNewObject();
    OPPNodeCreateCommand command = new OPPNodeCreateCommand();
    Rectangle constraints = (Rectangle) getConstraintFor(request);
    if (constraints.getSize().isEmpty()) {
      constraints.setSize(DEFAULT_THING_DIMENSION);
    }

    // command.setConstraints(constraints);
    node.setConstraints(constraints.x, constraints.y, constraints.width, constraints.height);
    command.setContainer(model);
    command.setNode(node);
    return command;
  }

  /**
   * Override for testing purposes
   */
  @Override
  protected Object getConstraintFor(CreateRequest request) {
    return super.getConstraintFor(request);
  }

  /**
   * The superclass implementation calls {@link OPPContainerXYLayoutPolicy#getResizeChildrenCommand(ChangeBoundsRequest)
   * getResizeChildrenCommand()} by default. This is not good in our case since we want to disallow resizing of
   * {@link OPPStructuralLinkAggregatorEditPart} while allowing to move them. Therefore we had to override the
   * implementation. It creates a {@link Command} that can be used to move a children of the policy's owner.
   * 
   * @return a {@link Command} used to move children of the host {@link EditPart}.
   */
  @Override
  protected Command getMoveChildrenCommand(Request request) {
    return getChangeConstraintCommand((ChangeBoundsRequest) request);
  }

  /**
   * Creates a {@link Command} to resize children of the host {@link EditPart} . The functions checks that the children
   * don't contain any {@link OPPStructuralLinkAggregatorEditPart} instances which cannot be resized.
   * 
   * @return a {@link Commnad} to resize children of the {@link EditPart}.
   */
  @Override
  protected Command getResizeChildrenCommand(ChangeBoundsRequest request) {
    for (Object editPart : request.getEditParts()) {
      if (editPart instanceof OPPStructuralLinkAggregatorEditPart) {
        return UnexecutableCommand.INSTANCE;
      }
    }
    return getChangeConstraintCommand(request);
  }
}
