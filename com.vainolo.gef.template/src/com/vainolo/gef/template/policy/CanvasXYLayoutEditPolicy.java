package com.vainolo.gef.template.policy;

import java.util.logging.Logger;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import com.vainolo.gef.template.command.CreateNodeCommand;
import com.vainolo.gef.template.model.Canvas;
import com.vainolo.gef.template.model.Node;

public class CanvasXYLayoutEditPolicy extends XYLayoutEditPolicy {

	Logger logger = Logger.getLogger(CanvasXYLayoutEditPolicy.class.getName());

	@Override
	protected Command getCreateCommand(CreateRequest request) {
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
