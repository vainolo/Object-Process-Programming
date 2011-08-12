package com.vainolo.phd.opm.gef.editor.policy;


import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import com.vainolo.phd.opm.gef.editor.command.OPMNodeCreateCommand;
import com.vainolo.phd.opm.gef.editor.command.OPMNodeChangeConstraintCommand;
import com.vainolo.phd.opm.gef.editor.part.OPMStructuralLinkAggregatorEditPart;

/**
 * This class describes the commands that can be used to change the layout 
 * and create new nodes inside the {@link OPMObjectProcessDiagram}.
 * 
 * @author vainolo
 *
 */
public class OPMObjectProcessDiagramXYLayoutPolicy extends XYLayoutEditPolicy {
    
    private static final Dimension DEFAULT_THING_DIMENSION = new Dimension(50, 50);

	/**
	 * Command created top change the constraints of a {@link OPMNode} instance.
	 */
	@Override protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
		OPMNodeChangeConstraintCommand command = new OPMNodeChangeConstraintCommand();
		command.setNode((OPMNode) child.getModel());
		command.setNewConstraint((Rectangle) constraint);
		return command;
	}

	/**
	 * Command created to add new nodes to the OPD.
	 */
	@Override protected Command getCreateCommand(CreateRequest request) {
		Command retVal = null;
		if(request.getNewObjectType().equals(OPMObject.class) || request.getNewObjectType().equals(OPMProcess.class)) {
			OPMNodeCreateCommand command = new OPMNodeCreateCommand();
			command.setConstraints(new Rectangle(request.getLocation(), DEFAULT_THING_DIMENSION));
			command.setParent((OPMObjectProcessDiagram)(getHost().getModel()));
			command.setNode((OPMNode)(request.getNewObject()));
			retVal = command;
		} 
		return retVal;
	}
	
	/**
	 * The superclass implementation calls 
	 * {@link OPMObjectProcessDiagramXYLayoutPolicy#getResizeChildrenCommand(ChangeBoundsRequest) getResizeChildrenCommand()}
	 *  by default. This is not good in our case since we want to disallow resizing of 
	 *  {@link OPMStructuralLinkAggregatorEditPart} while allowing to move them. Therefore
	 *  we had to override the implementation.
	 *  It creates a {@link Command} that can be used to move a children of the policy's owner.
	 *  @return a {@link Command} used to move children of the host {@link EditPart}. 
	 */
	@Override
	protected Command getMoveChildrenCommand(Request request) {
	    return getChangeConstraintCommand((ChangeBoundsRequest) request);
	}
	
	/**
	 * Creates a {@link Command} to resize children of the host {@link EditPart}.
	 * The functions checks that the children don't contain any {@link OPMStructuralLinkAggregatorEditPart}
	 * instances which cannot be resized.
	 * @return a {@link Commnad} to resize children of the {@link EditPart}.
	 */
	@Override
	protected Command getResizeChildrenCommand(ChangeBoundsRequest request) {
	    for(Object editPart : request.getEditParts()) {
	        if(editPart instanceof OPMStructuralLinkAggregatorEditPart) {
	            return UnexecutableCommand.INSTANCE;
	        }
	    }
	    return getChangeConstraintCommand(request);
	}
}
