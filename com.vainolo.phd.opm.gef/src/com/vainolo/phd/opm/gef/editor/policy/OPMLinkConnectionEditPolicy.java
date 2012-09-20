/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import com.vainolo.phd.opm.gef.editor.command.OPMLinkDeleteCommand;
import com.vainolo.phd.opm.model.OPMLink;

/**
 * Edit policy used by the OPMLink class to server delete requests.
 * 
 * @author vainolo
 * 
 */
public class OPMLinkConnectionEditPolicy extends ConnectionEditPolicy {

	/**
	 * Create a {@link OPMLinkDeleteCommand} and fill its details.
	 * 
	 * @param request
	 *            the request that requires treatment.
	 * @return a {@link OPMLinkDeleteCommand} that deletes a link from the
	 *         model.
	 */
	@Override
	protected OPMLinkDeleteCommand getDeleteCommand(GroupRequest request) {
		OPMLinkDeleteCommand command = new OPMLinkDeleteCommand();
		command.setLink((OPMLink) getHost().getModel());
		return command;
	}
}
