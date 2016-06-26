/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.policy;

import static com.vainolo.phd.opp.editor.policy.OPPBendpointUtils.*;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import com.google.common.base.Preconditions;
import com.vainolo.phd.opp.editor.command.OPPCreateLinkCommand;
import com.vainolo.phd.opp.editor.command.OPPLinkCreateBendpointCommand;
import com.vainolo.phd.opp.editor.command.OPPLinkReconnectCommand;
import com.vainolo.phd.opp.editor.command.OPPNodeCreateCommand;
import com.vainolo.phd.opp.editor.factory.OPPIdManager;
import com.vainolo.phd.opp.editor.factory.OPPStructuralLinkPartFactory;
import com.vainolo.phd.opp.editor.figure.OPPFigureConstants;
import com.vainolo.phd.opp.editor.part.OPPStructuralLinkAggregatorEditPart;
import com.vainolo.phd.opp.model.*;
import com.vainolo.phd.opp.utilities.analysis.OPPNodeExtensions;
import com.vainolo.phd.opp.validation.OPPLinkValidator;

/**
 * Policy used to connect two nodes in the diagram. Currently connections can only be created between two
 * {@link OPPThing} instances.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 */
public class OPPLinkConnectionEditPolicy extends GraphicalNodeEditPolicy {

  OPPLinkValidator validator;
  OPPStructuralLinkPartFactory linkFactory;

  public OPPLinkConnectionEditPolicy(OPPLinkValidator validator, OPPIdManager idManager) {
    Preconditions.checkNotNull(validator);
    this.validator = validator;
    this.linkFactory = new OPPStructuralLinkPartFactory(idManager);
  }

  /**
   * Create a command used to begin connecting to nodes. {@link OPPStructuralLinkAggregatorEditPart} nodes cannot be
   * source nodes, therefore in this case a {@link UnexecutableCommand} is returned.
   * 
   * @return a {@link Command} that contains the initial information neede to create a connection between two nodes.
   */
  @Override
  protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
    // We must return null and not the usual UnexecutableCommand because if we
    // return a non-null value the framework thinks that the link can be created
    // from this host, something that we don't want to happen.
    if (getHost() instanceof OPPStructuralLinkAggregatorEditPart) {
      return null;
    }

    if (request.getNewObject() instanceof OPPStructuralLinkAggregator) {
      request.setStartCommand(new Command() {
      });
      return request.getStartCommand();
    }

    if (!validator.validateAddSource((OPPNode) getHost().getModel(), (OPPLink) request.getNewObject())) {
      return null;
    }

    OPPCreateLinkCommand result = new OPPCreateLinkCommand();
    result.setSource((OPPNode) getHost().getModel());
    result.setLink((OPPLink) request.getNewObject());
    result.setOPD(OPPNodeExtensions.findOPD((OPPNode) (OPPNode) getHost().getModel()));
    request.setStartCommand(result);
    return result;
  }

  /**
   * Retrieves the command created by
   * {@link OPPLinkConnectionEditPolicy#getConnectionCreateCommand(CreateConnectionRequest) getConnectionCreateCommand},
   * and adds it information so that the command can be executed. {@link OPPStructuralLinkAggregatorEditPart} nodes
   * cannot be source nodes, therefore in this case a {@link UnexecutableCommand} is returned.
   * 
   * @return a {@link Command} that can be executed to create a connection between two nodes.
   */
  @Override
  protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
    // A null command must be returned (and not the usual UnexecutableCommand),
    // otherwise GEF shows a symbol that the connection can be completed but
    // when the used clicks it is not created.
    if (request.getStartCommand() == null || request.getTargetEditPart() instanceof OPPStructuralLinkAggregatorEditPart) {
      return null;
    }

    Command command = null;

    if (request.getNewObject() instanceof OPPStructuralLinkAggregator) {
      command = handleOPMStructuralLinkRequest(request);
    } else {
      if (!validator.validateAddTarget((OPPLink) request.getNewObject(), (OPPNode) getHost().getModel())) {
        return null;
      }

      OPPCreateLinkCommand linkCreateCommand = (OPPCreateLinkCommand) request.getStartCommand();
      linkCreateCommand.setTarget((OPPNode) getHost().getModel());
      command = linkCreateCommand;
    }

    return command;
  }

  /**
   * <p>
   * When the user requests the creation of a structural link, the following is done:
   * </p>
   * <ol>
   * <li>If this is the first structural link of its kind between the source and target nodes, we create a new
   * aggregator and connect it to the source and target.</li>
   * <li>If there already is an aggregator of its kind between the nodes, we only add a new link from the aggregator to
   * the new target.</li>
   * </ol>
   * 
   * @param request
   *          the user request to create a new strucutral link between the nodes.
   * @return a command that creates the links as stated above.
   */
  private Command handleOPMStructuralLinkRequest(CreateConnectionRequest request) {
    OPPBendpointUtils bendpointUtils = new OPPBendpointUtils();
    Command command = null;

    OPPNode sNode = (OPPNode) request.getSourceEditPart().getModel();
    OPPNode tNode = (OPPNode) request.getTargetEditPart().getModel();
    OPPStructuralLinkAggregator agrNode = (OPPStructuralLinkAggregator) request.getNewObject();

    // Search for an outgoing structural link aggregator matching the
    // requested kind.
    boolean aggregatorFound = false;
    for (OPPLink structuralLink : OPPNodeExtensions.getOutgoingStructuralLinks(sNode)) {
      OPPStructuralLinkAggregator existingAggregator = (OPPStructuralLinkAggregator) structuralLink.getTarget();
      if (existingAggregator.getKind() == agrNode.getKind()) {
        aggregatorFound = true;
        agrNode = existingAggregator;
      }
    }

    if (aggregatorFound) {
      CompoundCommand cCommand = new CompoundCommand();
      OPPCreateLinkCommand linkCreateCommand = createCreateOPMLlinkCreateCommand(agrNode, tNode, OPPNodeExtensions.findOPD(agrNode));
      cCommand.add(linkCreateCommand);

      for (Point p : bendpointUtils.createInitialBendpointsForStructuralLinkSegment(agrNode, tNode)) {
        OPPLinkCreateBendpointCommand bpc = new OPPLinkCreateBendpointCommand();
        bpc.setLink(linkCreateCommand.getLink());
        bpc.setLocation(p);
        cCommand.add(bpc);
      }
      command = cCommand;
    } else {
      CompoundCommand cCommand = new CompoundCommand();
      OPPNodeCreateCommand c1 = createCreateAggregatorNodeCommand(sNode, tNode, agrNode);
      cCommand.add(c1);
      OPPCreateLinkCommand c2 = createCreateOPMLlinkCreateCommand(sNode, agrNode, OPPNodeExtensions.findOPD(sNode));
      cCommand.add(c2);
      OPPCreateLinkCommand c3 = createCreateOPMLlinkCreateCommand(agrNode, tNode, OPPNodeExtensions.findOPD(sNode));
      cCommand.add(c3);

      for (Point p : bendpointUtils.createInitialBendpointsForStructuralLinkSegment(sNode, agrNode)) {
        OPPLinkCreateBendpointCommand bpc = new OPPLinkCreateBendpointCommand();
        bpc.setLink(c2.getLink());
        bpc.setLocation(p);
        cCommand.add(bpc);
      }

      for (Point p : bendpointUtils.createInitialBendpointsForStructuralLinkSegment(agrNode, tNode)) {
        OPPLinkCreateBendpointCommand bpc = new OPPLinkCreateBendpointCommand();
        bpc.setLink(c3.getLink());
        bpc.setLocation(p);
        cCommand.add(bpc);
      }

      command = cCommand;
    }

    return command;
  }

  /**
   * Helper function to create a command that connects two nodes with a factory generated link.
   * 
   * @param source
   *          the source of the link.
   * @param target
   *          the target of the link.
   * @return
   */
  private OPPCreateLinkCommand createCreateOPMLlinkCreateCommand(OPPNode source, OPPNode target, OPPObjectProcessDiagram opd) {
    OPPCreateLinkCommand command = new OPPCreateLinkCommand();
    command.setSource(source);
    command.setTarget(target);
    command.setOPD(opd);
    OPPStructuralLinkPart link = linkFactory.getNewObject();
    command.setLink(link);
    return command;
  }

  /**
   * Create a command that adds the provided {@link OPPStructuralLinkAggregator} to the diagram located between the
   * source and the target {@link OPPNode}.
   * 
   * @param source
   *          the source for the structural link.
   * @param target
   *          the target of the structural link.
   * @param aggregator
   *          the aggregator that should be added to the diagram.
   * @return A {@link OPMNodeCreateCommand} whose execution add the aggregator to the diagram.
   */
  public OPPNodeCreateCommand createCreateAggregatorNodeCommand(OPPNode source, OPPNode target, OPPNode aggregator) {
    OPPNodeCreateCommand command = new OPPNodeCreateCommand();
    command.setNode(aggregator);
    command.setContainer(source.getContainer());

    // Calculate location of aggregator, between the source and targetnodes.
    Point sCenter = new Point(source.getX() + source.getWidth() / 2, source.getY() + source.getHeight() / 2);
    Point tCenter = new Point(target.getX() + target.getWidth() / 2, target.getY() + target.getHeight() / 2);
    Point aggrgLeftTopCorner = new Point();
    Dimension d = new Dimension(OPPFigureConstants.STRUCTURAL_AGGREGATOR_SIZE, OPPFigureConstants.STRUCTURAL_AGGREGATOR_SIZE);
    aggrgLeftTopCorner.x = sCenter.x + (tCenter.x - sCenter.x) / 2 - d.width / 2;
    aggrgLeftTopCorner.y = sCenter.y + (tCenter.y - sCenter.y) / 2 - d.height / 2;
    if (aggrgLeftTopCorner.x < 0) {
      aggrgLeftTopCorner.x = 0;
    }
    if (aggrgLeftTopCorner.y < 0) {
      aggrgLeftTopCorner.y = 0;
    }
    // command.setConstraints(new Rectangle(aggrgLeftTopCorner, d));
    aggregator.setConstraints(aggrgLeftTopCorner.x, aggrgLeftTopCorner.y, d.width, d.height);

    return command;
  }

  @Override
  protected Command getReconnectTargetCommand(ReconnectRequest request) {
    OPPLink link = (OPPLink) request.getConnectionEditPart().getModel();
    OPPNode target = (OPPNode) request.getTarget().getModel();
    if (!validator.validateAddTarget(link, target)) {
      return null;
    } else {
      OPPLinkReconnectCommand command = new OPPLinkReconnectCommand();
      command.setLink(link);
      command.setSource(link.getSource());
      command.setTarget(target);
      return command;
    }
  }

  @Override
  protected Command getReconnectSourceCommand(ReconnectRequest request) {
    OPPLink link = (OPPLink) request.getConnectionEditPart().getModel();
    OPPNode source = (OPPNode) request.getTarget().getModel();
    if (!validator.validateAddTarget(link, source)) {
      return null;
    } else {
      OPPLinkReconnectCommand command = new OPPLinkReconnectCommand();
      command.setLink(link);
      command.setSource(source);
      command.setTarget(link.getTarget());
      return command;
    }
  }
}