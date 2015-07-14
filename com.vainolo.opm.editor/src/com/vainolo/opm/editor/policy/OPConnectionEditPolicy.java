package com.vainolo.opm.editor.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import com.vainolo.opm.editor.command.OPCreateProceduralLinkCommand;
import com.vainolo.opm.editor.command.OPLinkViewDeleteCommand;
import com.vainolo.opm.model.OPLinkView;
import com.vainolo.opm.model.OPNode;
import com.vainolo.opm.model.OPLink;
import com.vainolo.opm.model.OPNodeView;

public class OPConnectionEditPolicy extends GraphicalNodeEditPolicy {

	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		OPCreateProceduralLinkCommand command = new OPCreateProceduralLinkCommand();
		command.setSource((OPNodeView) getHost().getModel());
		command.setLink((OPLinkView) request.getNewObject());
		request.setStartCommand(command);
		return command;
	}

	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		OPCreateProceduralLinkCommand command = (OPCreateProceduralLinkCommand) request.getStartCommand();
		command.setTarget((OPNodeView) getHost().getModel());
		return command;
	}


	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		CompoundCommand command = new CompoundCommand();
		OPLinkViewDeleteCommand deleteCommand = new OPLinkViewDeleteCommand();
		deleteCommand.setLink((OPLinkView) request.getConnectionEditPart().getModel());
		command.add(deleteCommand);
		OPCreateProceduralLinkCommand createCommand = new OPCreateProceduralLinkCommand();
		createCommand.setLink((OPLinkView) request.getConnectionEditPart().getModel());
		createCommand.setSource(((OPLinkView)request.getConnectionEditPart().getModel()).getSource());
		createCommand.setTarget((OPNodeView) request.getTarget().getModel());
		command.add(createCommand);
		return command;
	}

	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		CompoundCommand command = new CompoundCommand();
		OPLinkViewDeleteCommand deleteCommand = new OPLinkViewDeleteCommand();
		deleteCommand.setLink((OPLinkView) request.getConnectionEditPart().getModel());
		command.add(deleteCommand);
		OPCreateProceduralLinkCommand createCommand = new OPCreateProceduralLinkCommand();
		createCommand.setLink((OPLinkView) request.getConnectionEditPart().getModel());
		createCommand.setSource((OPNodeView) request.getTarget().getModel());
		createCommand.setTarget(((OPLinkView)request.getConnectionEditPart().getModel()).getTarget());
		command.add(createCommand);
		return command;
	}

}
