/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
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
public class OPPLinkReconnectCommand extends Command {

  private OPPNode source;
  private OPPNode oldSource;
  private OPPNode target;
  private OPPNode oldTarget;
  private OPPLink link;

  /**
   * The command can be executed when all parameters have been set.
   */
  @Override
  public boolean canExecute() {
    return source != null && target != null && link != null;
  }

  /**
   * Connect the {@link OPPLink} to the given source and target {@link OPPNode} instances and add it to the containing
   * {@link OPPObjectProcessDiagram}.
   */
  @Override
  public void execute() {
    oldSource = link.getSource();
    oldTarget = link.getTarget();
    link.setSource(source);
    link.setTarget(target);
  }

  /**
   * Detach the {@link OPPLink} from the source and target {@link OPPNode} instances and from the containing
   * {@link OPPObjectProcessDiagram}.
   */
  @Override
  public void undo() {
    link.setSource(oldSource);
    link.setTarget(oldTarget);
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
}