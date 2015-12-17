/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPPoint;

public final class OPPLinkDeleteBendpointCommand extends Command {

  private OPPLink link;
  private int index;
  private OPPPoint location;

  @Override
  public boolean canExecute() {
    return (link != null) && (link.getBendpoints().size() > index);
  }

  @Override
  public void execute() {
    location = link.getBendpoints().get(index);
    link.getBendpoints().remove(index);
  }

  @Override
  public void undo() {
    link.getBendpoints().add(index, location);
  }

  public void setIndex(final int index) {
    this.index = index;
  }

  public void setLink(final OPPLink link) {
    this.link = link;
  }
}
