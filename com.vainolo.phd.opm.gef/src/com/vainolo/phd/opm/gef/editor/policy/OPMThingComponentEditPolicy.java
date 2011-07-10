package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import com.vainolo.phd.opm.gef.editor.command.OPMThingDeleteCommand;
import com.vainolo.phd.opm.model.OPMThing;

public class OPMThingComponentEditPolicy extends ComponentEditPolicy {

	@Override protected Command createDeleteCommand(GroupRequest deleteRequest) {
		OPMThingDeleteCommand thingDeleteCommand = new OPMThingDeleteCommand();
		thingDeleteCommand.setThing((OPMThing) getHost().getModel());
		return thingDeleteCommand;
	}
}
