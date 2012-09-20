/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;

/**
 * Command used to create a new {@link OPMNode} in the diagram.
 * 
 * @author vainolo
 * 
 */
public class OPMNodeCreateCommand extends Command {

  private OPMNode node;
  private Rectangle constraints;
  private OPMContainer container;

  /**
   * The command can be executed if all parameters have been set.
   */
  @Override
  public boolean canExecute() {
    return node != null && constraints != null && container != null;
  }

  /**
   * Set the constraints for the {@link OPMNode} and add it to the container {@link OPMObjectProcessDiagram}.
   */
  @Override
  public void execute() {
    node.setConstraints(constraints);
    node.setContainer(container);
  }

  /**
   * Remove the {@link OPMNode} from the container {@link OPMObjectProcessDiagram}.
   */
  @Override
  public void undo() {
    node.setContainer(null);
  }

  public void setConstraints(final Rectangle constraints) {
    this.constraints = constraints;
  }

  public void setContainer(final OPMContainer opd) {
    this.container = opd;
  }

  public void setNode(final OPMNode node) {
    this.node = node;
  }
}