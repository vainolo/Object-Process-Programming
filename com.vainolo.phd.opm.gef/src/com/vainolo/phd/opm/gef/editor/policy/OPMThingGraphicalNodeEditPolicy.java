package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import com.vainolo.phd.opm.gef.editor.command.OPMLinkCreateCommand;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMThing;

public class OPMThingGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

	@Override protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		OPMLinkCreateCommand result = (OPMLinkCreateCommand) request.getStartCommand();
		result.setTarget((OPMThing)getHost().getModel());
		return result;
	}

	@Override protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		OPMLinkCreateCommand result = new OPMLinkCreateCommand();
		result.setSource((OPMThing)getHost().getModel());
		result.setLink((OPMLink) request.getNewObject());
		result.setOPD(((OPMThing)getHost().getModel()).getOpd());
		request.setStartCommand(result);
		return result;
	}

	@Override protected Command getReconnectTargetCommand(ReconnectRequest request) {
		return null;
	}

	@Override protected Command getReconnectSourceCommand(ReconnectRequest request) {
		return null;
	}
}