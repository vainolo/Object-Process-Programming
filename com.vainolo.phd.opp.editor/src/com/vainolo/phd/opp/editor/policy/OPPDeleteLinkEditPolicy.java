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

public class OPPDeleteLinkEditPolicy extends ConnectionEditPolicy {

  @Override
  protected OPPLinkDeleteCommand getDeleteCommand(GroupRequest request) {
    OPPLinkDeleteCommand command = new OPPLinkDeleteCommand();
    command.setLink((OPPLink) getHost().getModel());
    return command;
  }
}
