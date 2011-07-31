package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import com.vainolo.phd.opm.gef.editor.command.LinkDeleteCommand;
import com.vainolo.phd.opm.model.OPMProceduralLink;

public class OPMProceduralLinkConnectionEditPolicy extends ConnectionEditPolicy {

	@Override protected Command getDeleteCommand(GroupRequest request) {
		LinkDeleteCommand command = new LinkDeleteCommand();
		command.setLink((OPMProceduralLink) getHost().getModel());
		return command;
	}

}
