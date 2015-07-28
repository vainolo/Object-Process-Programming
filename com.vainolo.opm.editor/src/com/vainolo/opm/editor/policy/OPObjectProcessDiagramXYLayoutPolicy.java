package com.vainolo.opm.editor.policy;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import com.vainolo.opm.editor.command.OPChangeNodeConstraintsCommand;
import com.vainolo.opm.editor.command.OPAddNodeViewToNodeContainerCommand;
import com.vainolo.opm.model.OPModelFactory;
import com.vainolo.opm.model.OPNodeView;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.OPRectangle;

public class OPObjectProcessDiagramXYLayoutPolicy extends XYLayoutEditPolicy {

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		OPObjectProcessDiagram opd = (OPObjectProcessDiagram)getHost().getModel();
		OPNodeView node = (OPNodeView) request.getNewObject();
		OPAddNodeViewToNodeContainerCommand command = new OPAddNodeViewToNodeContainerCommand();
		
		Rectangle requestConstraints = (Rectangle) getConstraintFor(request);
		OPRectangle constraints = OPModelFactory.createOPRectangle();
		if(requestConstraints.getSize().isEmpty()) {
			constraints.getPoint().setX(requestConstraints.x);
			constraints.getPoint().setY(requestConstraints.y);
			constraints.setWidth(50);
			constraints.setHeight(50);
		} else {
			constraints.getPoint().setX(requestConstraints.x);
			constraints.getPoint().setY(requestConstraints.y);
			constraints.setWidth(requestConstraints.width);
			constraints.setHeight(requestConstraints.height);
		}
		command.setConstaints(constraints);
		command.setObjectProcessDiagram(opd);
		command.setNode(node);
		return command;
	}
	
	@Override
	protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
		OPChangeNodeConstraintsCommand command = new OPChangeNodeConstraintsCommand();
		OPNodeView node = (OPNodeView) child.getModel();
		command.setNode(node);
		Rectangle r = (Rectangle) constraint;
		OPRectangle constraints = OPModelFactory.createOPRectangle();
		constraints.getPoint().setX(r.x);
		constraints.getPoint().setY(r.y);
		constraints.setWidth(r.width);
		constraints.setHeight(r.height);
		command.setConstratins(constraints);
		return command;
	}

}
