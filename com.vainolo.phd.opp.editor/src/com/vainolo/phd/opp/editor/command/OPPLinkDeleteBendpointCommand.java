/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
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
