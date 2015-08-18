/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.command;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPPoint;
import com.vainolo.phd.opp.model.OPPProceduralLink;

/**
 * Command used to create a new bendpoint in a {@linkplain OPMLink}. This class
 * is declared final since it has a very specific functionality.
 * 
 * @author vainolo
 * 
 */
public final class OPPLinkCreateBendpointCommand extends Command {

  /** Index on which the new bendpoint is added. */
  private int index;
  /** Location of new bendpoint. */
  private OPPPoint point;
  /** Link to which the bendpoint is added. */
  private OPPProceduralLink link;

  @Override
  public void execute() {
    link.getBendpoints().add(index, point);
  }

  @Override
  public void undo() {
    link.getBendpoints().remove(index);
  }

  /**
   * Set the index on which the bendpoint is added.
   * 
   * @param index
   *          Index on which the bendpoint should be added.
   */
  public void setIndex(final int index) {
    this.index = index;
  }

  /**
   * Set the location where the new bendpoint is added.
   * 
   * @param location
   *          point in the diagram where the new bendpoint is added.
   */
  public void setLocation(final Point location) {
    OPPPoint point = OPPFactory.eINSTANCE.createOPPPoint();
    point.setX(location.x);
    point.setY(location.y);
    this.point = point;
  }

  /**
   * Set the link on which the new bendpoint is added.
   * 
   * @param link
   *          link on which the bendpoint is added.
   */
  public void setOPMLink(final OPPProceduralLink link) {
    this.link = link;
  }
}
