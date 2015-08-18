/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.policy;

import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.editor.command.OPPLinkDeleteCommand;

/**
 * Edit policy used by the OPMLink class to server delete requests.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPPLinkConnectionEditPolicy extends ConnectionEditPolicy {

  /**
   * Create a {@link OPPLinkDeleteCommand} and fill its details.
   * 
   * @param request
   *          the request that requires treatment.
   * @return a {@link OPPLinkDeleteCommand} that deletes a link from the model.
   */
  @Override
  protected OPPLinkDeleteCommand getDeleteCommand(GroupRequest request) {
    OPPLinkDeleteCommand command = new OPPLinkDeleteCommand();
    command.setLink((OPPLink) getHost().getModel());
    return command;
  }
}
