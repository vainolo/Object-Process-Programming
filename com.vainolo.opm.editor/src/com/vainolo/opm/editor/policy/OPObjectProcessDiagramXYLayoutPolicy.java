package com.vainolo.opm.editor.policy;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import com.vainolo.opm.editor.command.OPChangeNodeConstraintsCommand;
import com.vainolo.opm.editor.command.OPCreateNodeViewCommand;
import com.vainolo.opm.model.opm.OPNodeView;
import com.vainolo.opm.model.opm.OPObjectProcessDiagram;

public class OPObjectProcessDiagramXYLayoutPolicy extends XYLayoutEditPolicy {

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		OPObjectProcessDiagram opd = (OPObjectProcessDiagram)getHost().getModel();
		OPNodeView node = (OPNodeView) request.getNewObject();
		OPCreateNodeViewCommand command = new OPCreateNodeViewCommand();
		
		Rectangle rc = (Rectangle) getConstraintFor(request);
		if(rc.getSize().isEmpty()) {
			command.setConstaints(rc.x, rc.y, 50, 50);
		} else {
			command.setConstaints(rc.x, rc.y, rc.width, rc.height);
		}
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
		command.setConstratins(r.x, r.y, r.width, r.height);
		return command;
	}

}
