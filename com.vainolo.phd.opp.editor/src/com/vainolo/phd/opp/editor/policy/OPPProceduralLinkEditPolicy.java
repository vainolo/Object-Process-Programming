/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.policy;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;

import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.editor.action.OPPToggledProceduralLinkSubkindAction;
import com.vainolo.phd.opp.editor.command.OPPProceduralLinkAddSubkindCommand;
import com.vainolo.phd.opp.editor.command.OPPProceduralLinkRemoveSubkindCommand;
import com.vainolo.phd.opp.editor.part.OPPProceduralLinkEditPart;
import com.vainolo.phd.opp.validation.OPPProceduralLinkValidator;

/**
 * Edit policy to handle request specific to {@link OPPProceduralLinkEditPart}s.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPPProceduralLinkEditPolicy extends AbstractEditPolicy {

  public static final String PROCEDURAL_LINK_EDIT_ROLE = "ProceduralLinkEditRole";
  private OPPProceduralLinkValidator validator;

  public OPPProceduralLinkEditPolicy(OPPProceduralLinkValidator validator) {
    this.validator = validator;
  }

  @Override
  public Command getCommand(Request request) {
    Command command;
    if(request.getType().equals(OPPToggledProceduralLinkSubkindAction.TOGGLE_PROCEDURAL_LINK_SUBKIND_REQUEST)) {
      String subkind = (String) request.getExtendedData().get("subkind");
      OPPProceduralLink link = (OPPProceduralLink) getHost().getModel();

      if(link.getSubKinds().contains(subkind))
        command = new OPPProceduralLinkRemoveSubkindCommand(link, subkind, validator);
      else
        command = new OPPProceduralLinkAddSubkindCommand(link, subkind, validator);
    } else {
      command = super.getCommand(request);
    }

    return command;
  }
}
