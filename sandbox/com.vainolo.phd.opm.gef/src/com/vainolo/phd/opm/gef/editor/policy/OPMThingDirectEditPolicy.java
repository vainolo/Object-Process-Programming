package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import com.vainolo.phd.opm.gef.editor.command.OPMThingRenameCommand;
import com.vainolo.phd.opm.gef.editor.figure.NamedNodeFigure;
import com.vainolo.phd.opm.model.OPMThing;

public class OPMThingDirectEditPolicy extends DirectEditPolicy {

	@Override protected Command getDirectEditCommand(DirectEditRequest request) {
		OPMThingRenameCommand command = new OPMThingRenameCommand();
		command.setModel((OPMThing) getHost().getModel());
		command.setNewName((String) request.getCellEditor().getValue());
		return command;
	}

	@Override protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		((NamedNodeFigure)getHostFigure()).getNameLabel().setText(value);		
	}

}
