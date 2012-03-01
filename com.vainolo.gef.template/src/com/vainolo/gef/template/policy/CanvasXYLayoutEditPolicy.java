/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.gef.template.policy;

import java.util.logging.Logger;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import com.vainolo.gef.template.command.CreateNodeCommand;
import com.vainolo.gef.template.model.Canvas;
import com.vainolo.gef.template.model.Node;
import com.vainolo.gef.template.part.CanvasEditPart;

/**
 * An edit policy to handle layout changes in the diagram. Currently only
 * handles creation command.
 * 
 * @author vainolo
 * 
 */
public class CanvasXYLayoutEditPolicy extends XYLayoutEditPolicy {

	Logger logger = Logger.getLogger(CanvasXYLayoutEditPolicy.class.getName());

	/**
	 * {@inheritDoc}
	 * 
	 * In the current implementation, the only edit part that can install this
	 * policy is a {@link CanvasEditPart} and the only entity that can be
	 * created is a {@link Node}. This method validates these assumptions and if
	 * all is OK, builds a command to handle the creation.
	 */
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		// This policy can only be installed in a CanvasEditPart.
		Assert.isTrue(getHost().getClass().equals(CanvasEditPart.class));
		if (request.getNewObject() == null) {
			logger.warning("Received a request with no new object");
			return UnexecutableCommand.INSTANCE;
		}
		if (!request.getNewObject().getClass().equals(Node.class)) {
			logger.warning("Received a request with a new object that is not of class Node");
			logger.warning("Class of received object is: " + request.getNewObject().getClass());
			logger.warning("New object is: " + request.getNewObject());
			return UnexecutableCommand.INSTANCE;
		}
		Node node = (Node) request.getNewObject();
		node.setX(request.getLocation().x);
		node.setY(request.getLocation().y);
		if (request.getSize() != null) {
			node.setWidth(request.getSize().width);
			node.setHeight(request.getSize().height);
		} else {
			node.setWidth(10);
			node.setHeight(10);
		}
		Canvas canvas = (Canvas) getHost().getModel();
		CreateNodeCommand command = new CreateNodeCommand(canvas, node);
		return command;
	}
}
