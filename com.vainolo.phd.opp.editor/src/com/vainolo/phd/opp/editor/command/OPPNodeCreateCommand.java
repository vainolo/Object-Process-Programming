/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.command;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.model.OPPContainer;
import com.vainolo.phd.opp.model.OPPNode;

/**
 * Command used to create a new {@link OPPNode} in the diagram.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPPNodeCreateCommand extends Command {

  private OPPNode node;
  // private Rectangle constraints;
  private OPPContainer container;

  /**
   * The command can be executed if all parameters have been set.
   */
  @Override
  public boolean canExecute() {
    return node != null && container != null; // && constraints != null ;
  }

  /**
   * Set the constraints for the {@link OPPNode} and add it to the container {@link OPPObjectProcessDiagram}.
   */
  @Override
  public void execute() {
    // node.setConstraints(constraints.x, constraints.y, constraints.width, constraints.height);
    node.setContainer(container);
  }

  /**
   * Remove the {@link OPPNode} from the container {@link OPPObjectProcessDiagram}.
   */
  @Override
  public void undo() {
    node.setContainer(null);
  }

  // public void setConstraints(final Rectangle constraints) {
  // this.constraints = constraints;
  // }

  public void setContainer(final OPPContainer opd) {
    this.container = opd;
  }

  public OPPContainer getContainer() {
    return container;
  }

  public void setNode(final OPPNode node) {
    this.node = node;
  }

  public OPPNode getNode() {
    return node;
  }

}