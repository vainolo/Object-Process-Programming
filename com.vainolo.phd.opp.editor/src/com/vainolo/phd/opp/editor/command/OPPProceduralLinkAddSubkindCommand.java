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

public class OPPProceduralLinkAddSubkindCommand extends Command {

  private OPPProceduralLink link;
  private String subkind;
  private OPPProceduralLinkValidator validator;

  public OPPProceduralLinkAddSubkindCommand(OPPProceduralLink link, String subkind, OPPProceduralLinkValidator validator) {
    this.link = link;
    this.subkind = subkind;
    this.validator = validator;
  }

  @Override
  public void execute() {
    link.getSubKinds().add(subkind);
  }

  @Override
  public void undo() {
    link.getSubKinds().remove(subkind);
  }

  @Override
  public boolean canExecute() {
    return validator.canSubkindBeAdded(link, subkind);
  }
}
