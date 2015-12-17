/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
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
