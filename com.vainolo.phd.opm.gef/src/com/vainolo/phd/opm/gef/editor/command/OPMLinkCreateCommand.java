/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;

/**
 * Command used to create a link between to {@link OPMNode OPMNode} instances.
 * 
 * @author vainolo
 * 
 */
public class OPMLinkCreateCommand extends Command {

  /** Source {@link OPMNode} of the link. */
  private OPMNode source;
  /** Target {@link OPMNode} of the link. */
  private OPMNode target;
  /** {@link OPMLink} that is being added by the {@link Command}. */
  private OPMLink link;
  /** Container {@link OPMObjectProcessDiagram}. */
  private OPMObjectProcessDiagram opd;

  /**
   * The command can be executed when all parameters have been set.
   */
  @Override
  public boolean canExecute() {
    return source != null && target != null && link != null && opd != null;
  }

  /**
   * Connect the {@link OPMLink} to the given source and target {@link OPMNode} instances and add it to the containing
   * {@link OPMObjectProcessDiagram}.
   */
  @Override
  public void execute() {
    link.setSource(source);
    link.setTarget(target);
    link.setOpd(opd);
  }

  /**
   * Detach the {@link OPMLink} from the source and target {@link OPMNode} instances and from the containing
   * {@link OPMObjectProcessDiagram}.
   */
  @Override
  public void undo() {
    link.getSource().getOutgoingLinks().remove(link);
    link.setSource(null);
    link.getTarget().getIncomingLinks().remove(link);
    link.setTarget(null);
    link.setOpd(null);
  }

  public void setTarget(OPMNode target) {
    this.target = target;
  }

  public void setSource(OPMNode source) {
    this.source = source;
  }

  public void setLink(OPMLink link) {
    this.link = link;
  }

  public void setOPD(OPMObjectProcessDiagram opd) {
    this.opd = opd;
  }
}