package com.vainolo.phd.opm.gef.editor.policy;

import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import com.vainolo.phd.opm.gef.editor.command.OPMNodeCreateCommand;
import com.vainolo.phd.opm.gef.editor.command.OPMNodeChangeConstraintCommand;

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
}
