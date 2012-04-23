/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.core.runtime.Status;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import com.vainolo.phd.opm.gef.Activator;
import com.vainolo.phd.opm.gef.editor.command.OPMNamedElementRenameCommand;
import com.vainolo.phd.opm.gef.editor.figure.OPMNamedElementFigure;
import com.vainolo.phd.opm.model.OPMNamedElement;

public class OPMNamedEntityDirectEditPolicy extends DirectEditPolicy {

	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {
		Object model = getHost().getModel();
		if (!(model instanceof OPMNamedElement)) {
			Activator.getDefault().getLog().log(new Status(Status.WARNING,
					Activator.PLUGIN_ID,
					"DirectEditPolicy not supported for model " + model));
			return null;
		}
		OPMNamedElementRenameCommand command = new OPMNamedElementRenameCommand();
		command.setModel((OPMNamedElement) getHost().getModel());
		command.setNewName((String) request.getCellEditor().getValue());
		return command;
	}

	@Override
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		((OPMNamedElementFigure) getHostFigure()).getNameLabel().setText(value);
	}
}
