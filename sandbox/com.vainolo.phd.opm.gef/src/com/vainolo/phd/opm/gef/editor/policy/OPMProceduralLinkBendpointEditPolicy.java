package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.BendpointEditPolicy;
import org.eclipse.gef.requests.BendpointRequest;

import com.vainolo.phd.opm.gef.editor.command.OPMProceduralLinkCreateBendpointCommand;
import com.vainolo.phd.opm.gef.editor.command.OPMProceduralLinkDeleteBendpointCommand;
import com.vainolo.phd.opm.gef.editor.command.OPMProceduralLinkMoveBendpointCommand;
import com.vainolo.phd.opm.model.OPMProceduralLink;

public class OPMProceduralLinkBendpointEditPolicy extends BendpointEditPolicy {

	@Override protected Command getCreateBendpointCommand(BendpointRequest request) {
		OPMProceduralLinkCreateBendpointCommand command = new OPMProceduralLinkCreateBendpointCommand();
		
		Point p = request.getLocation();
		
		command.setOPMProceduralLink((OPMProceduralLink) request.getSource().getModel());
		command.setLocation(p);
		command.setIndex(request.getIndex());
		
		return command;
	}

	@Override protected Command getMoveBendpointCommand(BendpointRequest request) {
		OPMProceduralLinkMoveBendpointCommand command = new OPMProceduralLinkMoveBendpointCommand();
		
		Point p = request.getLocation();
		
		command.setOPMProceduralLink((OPMProceduralLink) request.getSource().getModel());
		command.setLocation(p);
		command.setIndex(request.getIndex());
		
		return command;
	}

	@Override protected Command getDeleteBendpointCommand(BendpointRequest request) {
		OPMProceduralLinkDeleteBendpointCommand command = new OPMProceduralLinkDeleteBendpointCommand();
		
		command.setOPMProceduralLink((OPMProceduralLink)request.getSource().getModel());
		command.setIndex(request.getIndex());
		return command;
	}
}
