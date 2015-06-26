package com.vainolo.opm.editor.policy;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import com.vainolo.opm.editor.command.OPNodeChangeConstraintsCommand;
import com.vainolo.opm.editor.command.OPNodeCreateCommand;
import com.vainolo.opm.model.OPConstraints;
import com.vainolo.opm.model.OPContainer;
import com.vainolo.opm.model.OPNode;
import com.vainolo.opm.model.OPPoint;

public class OPContainerXYLayoutPolicy extends XYLayoutEditPolicy {

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		OPContainer model = (OPContainer) getHost().getModel();
		OPNode node = (OPNode) request.getNewObject();
		OPNodeCreateCommand command = new OPNodeCreateCommand();
		
		Rectangle requestConstraints = (Rectangle) getConstraintFor(request);
		OPConstraints constraints = null;
		if(requestConstraints.getSize().isEmpty()) {
			constraints = new OPConstraints(new OPPoint(requestConstraints.x, requestConstraints.y), 50, 50);
		} else {
			constraints = new OPConstraints(new OPPoint(requestConstraints.x, requestConstraints.y), requestConstraints.width, requestConstraints.height);
		}
		command.setConstaints(constraints);
		command.setContainer(model);
		command.setNode(node);
		return command;
	}
	
	@Override
	protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
		OPNodeChangeConstraintsCommand command = new OPNodeChangeConstraintsCommand();
		OPNode node = (OPNode) child.getModel();
		command.setNode(node);
		Rectangle r = (Rectangle) constraint;
		OPConstraints constraints = new OPConstraints(new OPPoint(r.x, r.y), r.width, r.height);
		command.setConstratins(constraints);
		return command;
	}

}
