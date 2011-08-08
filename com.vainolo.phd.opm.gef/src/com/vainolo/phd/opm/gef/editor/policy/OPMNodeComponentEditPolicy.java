package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import com.vainolo.phd.opm.gef.editor.command.OPMNodeDeleteCommand;
import com.vainolo.phd.opm.model.OPMNode;

public class OPMNodeComponentEditPolicy extends ComponentEditPolicy {

	@Override protected Command createDeleteCommand(GroupRequest deleteRequest) {
		OPMNodeDeleteCommand nodeDeleteCommand = new OPMNodeDeleteCommand();
		nodeDeleteCommand.setNode((OPMNode) getHost().getModel());
		return nodeDeleteCommand;
	}
}
