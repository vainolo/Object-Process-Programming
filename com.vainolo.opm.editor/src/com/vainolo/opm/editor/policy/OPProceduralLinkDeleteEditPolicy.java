package com.vainolo.opm.editor.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import com.vainolo.opm.editor.command.OPLinkViewDeleteCommand;
import com.vainolo.opm.model.opm.OPLinkView;

public class OPProceduralLinkDeleteEditPolicy extends ConnectionEditPolicy {

	@Override
	protected Command getDeleteCommand(GroupRequest request) {
		OPLinkViewDeleteCommand command = new OPLinkViewDeleteCommand();
		command.setLink((OPLinkView)getHost().getModel());
		return command;
	}

	

}
