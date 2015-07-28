package com.vainolo.opm.editor.policy;

import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import com.vainolo.opm.editor.command.OPChangeNodeConstraintsCommand;
import com.vainolo.opm.editor.command.OPCreateNodeViewCommand;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.view.OPNodeView;

public class OPObjectProcessDiagramXYLayoutPolicy extends XYLayoutEditPolicy {

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		OPObjectProcessDiagram opd = (OPObjectProcessDiagram)getHost().getModel();
		OPNodeView node = (OPNodeView) request.getNewObject();
		OPCreateNodeViewCommand command = new OPCreateNodeViewCommand();
		
		Rectangle requestConstraints = (Rectangle) getConstraintFor(request);
		int[] constraints = new int[4];
		if(requestConstraints.getSize().isEmpty()) {
			constraints[0] = requestConstraints.x;
			constraints[1] = requestConstraints.y;
			constraints[2] = 50;
			constraints[3] = 50;
		} else {
			constraints[0] = requestConstraints.x;
			constraints[1] = requestConstraints.y;
			constraints[2] = requestConstraints.width;
			constraints[3] = requestConstraints.height;
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
		int[] constraints = new int[4];
		constraints[0] = r.x;
		constraints[1] = r.y;
		constraints[2] = r.width;
		constraints[3] = r.height;
		command.setConstratins(constraints);
		return command;
	}

}
