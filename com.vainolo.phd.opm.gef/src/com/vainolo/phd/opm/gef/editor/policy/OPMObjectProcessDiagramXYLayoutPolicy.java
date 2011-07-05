package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import com.vainolo.phd.opm.gef.editor.command.OPMThingCreateCommand;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMThing;

public class OPMObjectProcessDiagramXYLayoutPolicy extends XYLayoutEditPolicy {

	@Override protected Command getCreateCommand(CreateRequest request) {
		Command retVal = null;
		if(request.getNewObject() instanceof OPMThing) {
			OPMThingCreateCommand command = new OPMThingCreateCommand();
			command.setLocation(request.getLocation());
			command.setParent((OPMObjectProcessDiagram)(getHost().getModel()));
			command.setThing((OPMThing)(request.getNewObject()));
			retVal = command;
		} 
		return retVal;
	}
}
