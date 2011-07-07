package com.vainolo.phd.opm.gef.editor.policy;

import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMThing;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import com.vainolo.phd.opm.gef.editor.command.OPMThingCreateCommand;
import com.vainolo.phd.opm.gef.editor.command.OPMThingChangeConstraintCommand;

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
		OPMThingChangeConstraintCommand command = new OPMThingChangeConstraintCommand();
		command.setModel((OPMThing) child.getModel());
		command.setNewConstraint((Rectangle) constraint);
		return command;
	}

	/**
	 * Command created to add new things to the OPD.
	 */
	@Override protected Command getCreateCommand(CreateRequest request) {
		Command retVal = null;
		if(request.getNewObjectType().equals(OPMObject.class) || request.getNewObjectType().equals(OPMProcess.class)) {
			OPMThingCreateCommand command = new OPMThingCreateCommand();
			command.setLocation(request.getLocation());
			command.setParent((OPMObjectProcessDiagram)(getHost().getModel()));
			command.setThing((OPMThing)(request.getNewObject()));
			retVal = command;
		} 
		return retVal;
	}
}
