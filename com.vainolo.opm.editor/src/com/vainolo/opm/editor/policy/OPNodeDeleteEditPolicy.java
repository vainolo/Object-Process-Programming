package com.vainolo.opm.editor.policy;

import org.eclipse.gef.commands.Command;

import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import com.vainolo.opm.editor.command.OPMDeleteNodeCommand;
import com.vainolo.opm.model.OPNodeView;

public class OPNodeDeleteEditPolicy extends ComponentEditPolicy {
	@Override
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		OPMDeleteNodeCommand command = new OPMDeleteNodeCommand();
		command.setNode((OPNodeView)getHost().getModel());
		return command;
	}
}
