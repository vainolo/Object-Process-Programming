/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.command;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPPoint;

public class OPPLinkMoveBendpointCommand extends Command {

  private OPPPoint oldLocation;
  private OPPPoint newLocation;
  private int index;
  private OPPLink link;

  @Override
  public void execute() {
    if (oldLocation == null) {
      oldLocation = link.getBendpoints().get(index);
    }
    link.getBendpoints().set(index, newLocation);
  }

  @Override
  public void undo() {
    link.getBendpoints().set(index, oldLocation);
  }

  public void setIndex(final int index) {
    this.index = index;
  }

  public void setLink(final OPPLink link) {
    this.link = link;
  }

  public void setLocation(final Point newLocation) {
    OPPPoint point = OPPFactory.eINSTANCE.createOPPPoint();
    point.setX(newLocation.x);
    point.setY(newLocation.y);
    this.newLocation = point;
  }
}
