/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMLink;

/**
 * Command used to create a new bendpoint in a {@linkplain OPMLink}. This class
 * is declared final since it has a very specific functionality.
 * 
 * @author vainolo
 * 
 */
public final class OPMLinkCreateBendpointCommand extends Command {

  /** Index on which the new bendpoint is added. */
  private int index;
  /** Location of new bendpoint. */
  private Point location;
  /** Link to which the bendpoint is added. */
  private OPMLink link;

  @Override
  public void execute() {
    link.getBendpoints().add(index, location);
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
    this.location = location;
  }

  /**
   * Set the link on which the new bendpoint is added.
   * 
   * @param link
   *          link on which the bendpoint is added.
   */
  public void setOPMLink(final OPMLink link) {
    this.link = link;
  }
}
