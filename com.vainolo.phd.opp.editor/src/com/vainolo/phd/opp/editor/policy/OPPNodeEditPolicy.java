/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.policy;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import com.vainolo.phd.opp.editor.action.OPPResizeToContentsAction;
import com.vainolo.phd.opp.editor.command.OPPNodeChangeConstraintCommand;
import com.vainolo.phd.opp.editor.command.OPPDeleteNodeCommand;
import com.vainolo.phd.opp.editor.figure.OPPNodeFigure;
import com.vainolo.phd.opp.editor.part.OPPNodeEditPart;
import com.vainolo.phd.opp.model.OPPContainer;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPStructuralLinkAggregator;
import com.vainolo.phd.opp.utilities.analysis.OPPOPDAnalyzer;

/**
 * {@link EditPolicy} used for delete requests.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 */
public class OPPNodeEditPolicy extends ComponentEditPolicy {

  private OPPOPDAnalyzer analyzer;

  public OPPNodeEditPolicy(OPPOPDAnalyzer analyzer) {
    super();
    this.analyzer = analyzer;

  }

  /**
   * Create a command to delete a node. When a node is deleted all incoming and outgoing links are also deleted
   * (functionality provided by the command). When a {@link OPPThing} node is deleted, there is special treatment for
   * structural links that start and end at this node. If this node is source for a structural link, the
   * {@link OPPStructuralLinkAggregator} of this link must be deleted. Also if this node is the target of the only
   * outgoing link of a {@link OPPStructuralLinkAggregator}, the aggregator must be deleted.
   * 
   * @return a command that deletes a node and all other required diagram entities.
   */
  @Override
  protected Command createDeleteCommand(GroupRequest deleteRequest) {
    OPPNode nodeToDelete = (OPPNode) getHost().getModel();
    return createRecursiveDeleteNodeCommand(nodeToDelete);
  }

  @Override
  public Command getCommand(Request request) {
    if (request.getType().equals(OPPResizeToContentsAction.RESIZE_TO_CONTENTS_REQUEST)) {
      OPPNodeEditPart host = (OPPNodeEditPart) getHost();
      OPPNode node = (OPPNode) host.getModel();
      OPPNodeFigure figure = (OPPNodeFigure) host.getFigure();
      Dimension preferredSize = figure.getPreferredSize();
      OPPNodeChangeConstraintCommand command = new OPPNodeChangeConstraintCommand();
      node.setManualSize(false);
      command.setNode(node);
      command.setNewConstraint(node.getX(), node.getY(), preferredSize.width, preferredSize.height);
      return command;
    }
    return super.getCommand(request);
  }

  /**
   * This function creates a command that consists of all the commands required to delete the given node and all of the
   * nodes contained inside it. This function is called recursively when a node is a container and has internal nodes.
   * 
   * @param nodeToDelete
   *          the node that will be deleted.
   * @return a {@link CompoundCommand} command that deletes the node, the contained nodes and all links that must be
   *         deleted.
   */
  private Command createRecursiveDeleteNodeCommand(OPPNode nodeToDelete) {
    CompoundCommand compoundCommand = new CompoundCommand();

    if (nodeToDelete instanceof OPPStructuralLinkAggregator) {
      OPPDeleteNodeCommand command = new OPPDeleteNodeCommand();
      command.setNode(nodeToDelete);
      return command;
    }

    // For every outgoing structural link, create a command to delete the
    // aggregator node at the end of the link.
    for (OPPLink outgoingStructuralLink : analyzer.findOutgoingStructuralLinks(nodeToDelete)) {
      OPPNode aggregatorNode = outgoingStructuralLink.getTarget();
      OPPDeleteNodeCommand aggregatorNodeDeleteCommand = new OPPDeleteNodeCommand();
      aggregatorNodeDeleteCommand.setNode(aggregatorNode);
      compoundCommand.add(aggregatorNodeDeleteCommand);
    }

    // For every incoming structural link whose aggregator has only one outgoing
    // link, create a command to delete the
    // aggregator.
    for (OPPLink incomingStructuralLink : analyzer.findIncomingStructuralLinks(nodeToDelete)) {
      OPPNode aggregatorNode = incomingStructuralLink.getSource();
      if (aggregatorNode.getOutgoingLinks().size() == 1) {
        OPPDeleteNodeCommand aggregatorNodeDeleteCommand = new OPPDeleteNodeCommand();
        aggregatorNodeDeleteCommand.setNode(aggregatorNode);
        compoundCommand.add(aggregatorNodeDeleteCommand);
      }
    }

    if (nodeToDelete instanceof OPPContainer) {
      OPPContainer container = (OPPContainer) nodeToDelete;
      for (OPPNode node : container.getNodes()) {
        Command containedNodeDelete = createRecursiveDeleteNodeCommand(node);
        compoundCommand.add(containedNodeDelete);
      }
    }

    // Create a command to delete the node.
    OPPDeleteNodeCommand nodeDeleteCommand = new OPPDeleteNodeCommand();
    nodeDeleteCommand.setNode(nodeToDelete);
    compoundCommand.add(nodeDeleteCommand);

    return compoundCommand;
  }
}
