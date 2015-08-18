/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;

/**
 * Command used to delete a link.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 */
public class OPPLinkDeleteCommand extends Command {
  /** Link to be deleted. */
  private OPPLink link;
  /** OPD that owns the link. */
  private OPPObjectProcessDiagram opd;
  /** Source of the link. */
  private OPPNode source;
  /** Target of the link. */
  private OPPNode target;

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean canExecute() {
    return link != null;
  }

  /**
   * Disconnect link from source and target things and remove from owner OPD.
   */
  @Override
  public void execute() {
    opd = link.getOpd();
    source = link.getSource();
    target = link.getTarget();

    link.setSource(null);
    link.setTarget(null);
    link.setOpd(null);
  }

  /**
   * Reconnect the link to the source and target and add it to the owner OPD.
   */
  @Override
  public void undo() {
    link.setSource(source);
    link.setTarget(target);
    link.setOpd(opd);
  }

  /**
   * Set the link that will be delete from the diagram.
   * 
   * @param linkParam
   *          the link to delete from the diagram.
   */
  public void setLink(final OPPLink linkParam) {
    link = linkParam;
  }
}