/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.validation.OPPProceduralLinkValidator;

public class OPPProceduralLinkRemoveSubkindCommand extends Command {

  private OPPProceduralLink link;
  private String subkind;
  private OPPProceduralLinkValidator validator;

  public OPPProceduralLinkRemoveSubkindCommand(OPPProceduralLink link, String subkind,
      OPPProceduralLinkValidator validator) {
    this.link = link;
    this.subkind = subkind;
    this.validator = validator;
  }

  @Override
  public void execute() {
    link.getSubKinds().remove(subkind);
  }

  @Override
  public void undo() {
    link.getSubKinds().add(subkind);
  }

  @Override
  public boolean canExecute() {
    return validator.canSubkindBeRemoved(link, subkind);
  }
}
