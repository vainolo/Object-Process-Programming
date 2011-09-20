package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import com.vainolo.phd.opm.gef.editor.command.OPMStateRenameCommand;
import com.vainolo.phd.opm.gef.editor.command.OPMThingRenameCommand;
import com.vainolo.phd.opm.gef.editor.figure.OPMStateFigure;
import com.vainolo.phd.opm.gef.editor.figure.OPMThingFigure;
import com.vainolo.phd.opm.model.OPMState;
import com.vainolo.phd.opm.model.OPMThing;

public class OPMStateDirectEditPolicy extends DirectEditPolicy {

	@Override protected Command getDirectEditCommand(DirectEditRequest request) {
		OPMStateRenameCommand command = new OPMStateRenameCommand();
		command.setModel((OPMState) getHost().getModel());
		command.setNewName((String) request.getCellEditor().getValue());
		return command;
	}

	@Override protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		((OPMStateFigure)getHostFigure()).getNameLabel().setText(value);		
	}
}
