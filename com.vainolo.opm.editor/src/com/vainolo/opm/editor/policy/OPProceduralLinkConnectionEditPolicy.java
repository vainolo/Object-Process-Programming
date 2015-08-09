package com.vainolo.opm.editor.policy;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import com.vainolo.opm.editor.command.OPCreateProceduralLinkViewCommand;
import com.vainolo.opm.editor.command.OPLinkViewDeleteCommand;
import com.vainolo.opm.model.opm.OPLinkView;
import com.vainolo.opm.model.opm.OPNodeView;
import com.vainolo.opm.model.opm.OPProceduralLinkView;

public class OPProceduralLinkConnectionEditPolicy extends GraphicalNodeEditPolicy {

	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		OPCreateProceduralLinkViewCommand command = new OPCreateProceduralLinkViewCommand();
		command.setSource((OPNodeView) getHost().getModel());
		command.setLink((OPProceduralLinkView) request.getNewObject());
		request.setStartCommand(command);
		return command;
	}

	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		OPCreateProceduralLinkViewCommand command = (OPCreateProceduralLinkViewCommand) request.getStartCommand();
		command.setTarget((OPNodeView) getHost().getModel());
		return command;
	}


	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		CompoundCommand command = new CompoundCommand();
		OPLinkViewDeleteCommand deleteCommand = new OPLinkViewDeleteCommand();
		deleteCommand.setLink((OPLinkView) request.getConnectionEditPart().getModel());
		command.add(deleteCommand);
		OPCreateProceduralLinkViewCommand createCommand = new OPCreateProceduralLinkViewCommand();
		createCommand.setLink((OPProceduralLinkView) request.getConnectionEditPart().getModel());
		createCommand.setSource(((OPProceduralLinkView)request.getConnectionEditPart().getModel()).getSource());
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
		OPCreateProceduralLinkViewCommand createCommand = new OPCreateProceduralLinkViewCommand();
		createCommand.setLink((OPProceduralLinkView) request.getConnectionEditPart().getModel());
		createCommand.setSource((OPNodeView) request.getTarget().getModel());
		createCommand.setTarget(((OPLinkView)request.getConnectionEditPart().getModel()).getTarget());
		command.add(createCommand);
		return command;
	}
	
	@Override
	public Command getCommand(Request request) {
		if(REQ_CONNECTION_START.equals(request.getType()) || REQ_CONNECTION_END.equals(request.getType())) {
			CreateConnectionRequest createConnectionRequest = (CreateConnectionRequest) request;
			if(createConnectionRequest.getNewObject() instanceof OPProceduralLinkView)
				return super.getCommand(request);
		} else if(REQ_RECONNECT_SOURCE.equals(request.getType()) || REQ_RECONNECT_TARGET.equals(request.getType())) {
			ReconnectRequest reconnectRequest = (ReconnectRequest) request;
			if(reconnectRequest.getConnectionEditPart().getModel() instanceof OPProceduralLinkView)
				return super.getCommand(request);
		}
		return null;
	}

}
