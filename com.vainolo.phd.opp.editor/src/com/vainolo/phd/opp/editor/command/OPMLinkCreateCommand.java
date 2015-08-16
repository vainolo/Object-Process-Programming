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
 * Command used to create a link between to {@link OPPNode} instances.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPMLinkCreateCommand extends Command {

  private OPPNode source;
  private OPPNode target;
  private OPPLink link;
  private OPPObjectProcessDiagram opd;

  /**
   * The command can be executed when all parameters have been set.
   */
  @Override
  public boolean canExecute() {
    return source != null && target != null && link != null && opd != null;
  }

  /**
   * Connect the {@link OPPLink} to the given source and target {@link OPPNode}
   * instances and add it to the containing {@link OPPObjectProcessDiagram}.
   */
  @Override
  public void execute() {
    link.setSource(source);
    link.setTarget(target);
    link.setOpd(opd);
  }

  /**
   * Detach the {@link OPPLink} from the source and target {@link OPPNode}
   * instances and from the containing {@link OPPObjectProcessDiagram}.
   */
  @Override
  public void undo() {
    link.getSource().getOutgoingLinks().remove(link);
    link.setSource(null);
    link.getTarget().getIncomingLinks().remove(link);
    link.setTarget(null);
    link.setOpd(null);
  }

  public void setTarget(OPPNode target) {
    this.target = target;
  }

  public OPPNode getTarget() {
    return target;
  }

  public void setSource(OPPNode source) {
    this.source = source;
  }

  public OPPNode getSource() {
    return source;
  }

  public void setLink(OPPLink link) {
    this.link = link;
  }

  public OPPLink getLink() {
    return link;
  }

  public void setOPD(OPPObjectProcessDiagram opd) {
    this.opd = opd;
  }
}