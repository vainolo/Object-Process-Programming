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

public class OPPLinkCreateBendpointCommand extends Command {

  private int index;
  private OPPPoint point;
  private OPPLink link;

  @Override
  public void execute() {
    link.getBendpoints().add(index, point);
  }

  @Override
  public void undo() {
    link.getBendpoints().remove(index);
  }

  public void setIndex(final int index) {
    this.index = index;
  }

  public void setLocation(final Point location) {
    OPPPoint point = OPPFactory.eINSTANCE.createOPPPoint();
    point.setX(location.x);
    point.setY(location.y);
    this.point = point;
  }

  public void setLink(final OPPLink link) {
    this.link = link;
  }
}
