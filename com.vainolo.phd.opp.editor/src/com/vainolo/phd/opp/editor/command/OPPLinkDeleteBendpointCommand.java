/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.command;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.model.OPPPoint;
import com.vainolo.phd.opp.model.OPPProceduralLink;

/**
 * Command used to delete a bendpoint from a {@link OPMLink} This class is
 * declared final since it has a very specific functionality.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 */
public final class OPPLinkDeleteBendpointCommand extends Command {

  /** Link that contains the bendpoint. */
  private OPPProceduralLink link;
  /** Index where the bendpoint is located in the link's bendpoin list. */
  private int index;
  /** Point in the diagram where the bendpoint is located. */
  private OPPPoint location;

  /**
   * Only execute is link is not null and index is valid.
   */
  @Override
  public boolean canExecute() {
    return (link != null) && (link.getBendpoints().size() > index);
  }

  /**
   * Remove the bendpoint from the link.
   */
  @Override
  public void execute() {
    location = link.getBendpoints().get(index);
    link.getBendpoints().remove(index);
  }

  /**
   * Reinsert the bendpoint in the link.
   */
  @Override
  public void undo() {
    link.getBendpoints().add(index, location);
  }

  /**
   * Set the index of the bendpoint that should be removed.
   * 
   * @param index
   *          the index of the bendpoint to remove.
   */
  public void setIndex(final int index) {
    this.index = index;
  }

  /**
   * Set the link from which the bendpoint is removed.
   * 
   * @param link
   *          the link from which the bendpoint is removed.
   */
  public void setOPMLink(final OPPProceduralLink link) {
    this.link = link;
  }
}
