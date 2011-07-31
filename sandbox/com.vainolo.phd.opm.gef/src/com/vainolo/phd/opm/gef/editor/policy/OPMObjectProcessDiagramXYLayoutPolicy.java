package com.vainolo.phd.opm.gef.editor.policy;

import com.vainolo.phd.opm.model.Node;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import com.vainolo.phd.opm.gef.editor.command.NodeCreateCommand;
import com.vainolo.phd.opm.gef.editor.command.NodeChangeConstraintCommand;
import com.vainolo.phd.opm.gef.editor.part.OPMStructuralLinkAggregatorEditPart;

/**
 * This class describes the commands that can be used to change the layout inside the
 * ObjectProcessDiagram, Create new entities inside the ObjectProcessDiagram
 * 
 * @author vainolo
 *
 */
public class OPMObjectProcessDiagramXYLayoutPolicy extends XYLayoutEditPolicy {

	/**
	 * Command created the user requests to change the constraint (size, location) of an object that is
	 * part of an OPD.
	 */
	@Override protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
	    NodeChangeConstraintCommand command = new NodeChangeConstraintCommand();
	    command.setModel((Node) child.getModel());
	    command.setNewConstraint((Rectangle) constraint);
	    return command;
	}

	/**
	 * Command created to add new things to the OPD.
	 */
	@Override protected Command getCreateCommand(CreateRequest request) {
	    NodeCreateCommand command = new NodeCreateCommand();
	    command.setLocation(request.getLocation());
	    command.setParent((OPMObjectProcessDiagram)(getHost().getModel()));
	    command.setNode((Node) request.getNewObject());
        return command;
	}
	
	@Override protected Command getResizeChildrenCommand(ChangeBoundsRequest request) {
	    for(Object part: request.getEditParts()) {
	        if(part instanceof OPMStructuralLinkAggregatorEditPart) {
	            return UnexecutableCommand.INSTANCE;
	        }
	    }
	    return getChangeConstraintCommand(request);
	}
	
	@Override protected Command getMoveChildrenCommand(Request request) {
	    return getChangeConstraintCommand((ChangeBoundsRequest) request);
	}
}
