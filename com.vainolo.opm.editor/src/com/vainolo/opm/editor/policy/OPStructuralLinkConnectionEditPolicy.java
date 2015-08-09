package com.vainolo.opm.editor.policy;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import com.vainolo.opm.editor.command.OPCreateStructuralLinkViewCommand;
import com.vainolo.opm.model.opm.OPFactory;
import com.vainolo.opm.model.opm.OPNodeView;
import com.vainolo.opm.model.opm.OPStructuralLink;
import com.vainolo.opm.model.opm.OPStructuralLinkAggregatorView;

public class OPStructuralLinkConnectionEditPolicy extends GraphicalNodeEditPolicy {

	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		OPCreateStructuralLinkViewCommand command = new OPCreateStructuralLinkViewCommand();
		OPStructuralLinkAggregatorView aggregator = (OPStructuralLinkAggregatorView) request.getNewObject();
		OPStructuralLink structuralLink = OPFactory.eINSTANCE.createOPStructuralLink();
		aggregator.setWidth(25);
		aggregator.setHeight(25);
		command.setSource((OPNodeView)getHost().getModel());
		command.setAggregator(aggregator);
		command.setModel(structuralLink);
		request.setStartCommand(command);
		return command;
	}

	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		OPCreateStructuralLinkViewCommand command = (OPCreateStructuralLinkViewCommand) request.getStartCommand();
		command.setTarget((OPNodeView)getHost().getModel());
		command.setSourceLinkPart(OPFactory.eINSTANCE.createOPStructuralLinkPartView());
		command.setTargetLinkPart(OPFactory.eINSTANCE.createOPStructuralLinkPartView());
		return command;
	}

	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		return null;
	}

	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		return null;
	}

	@Override
	public Command getCommand(Request request) {
		if(REQ_CONNECTION_START.equals(request.getType()) || REQ_CONNECTION_END.equals(request.getType())) {
			CreateConnectionRequest createConnectionRequest = (CreateConnectionRequest) request;
			if(createConnectionRequest.getNewObject() instanceof OPStructuralLinkAggregatorView)
				return super.getCommand(request);
		} else if(REQ_RECONNECT_SOURCE.equals(request.getType()) || REQ_RECONNECT_TARGET.equals(request.getType())) {
			return null; 
		}
		return null;
	}	
}
