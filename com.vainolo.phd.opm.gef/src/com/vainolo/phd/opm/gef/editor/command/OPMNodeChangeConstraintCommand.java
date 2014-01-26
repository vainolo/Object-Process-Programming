/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMNode;

/**
 * Command used to changed the constraints of a node.
 * 
 * @author vainolo
 * 
 */
public class OPMNodeChangeConstraintCommand extends Command {

  private Rectangle oldConstraint;
  private Rectangle newConstraint;
  private OPMNode node;

  /**
   * The command can be executed when all parameters have been set.
   */
  @Override
  public boolean canExecute() {
    if(node == null || newConstraint == null)
      return false;
    if(newConstraint != null) {
      if(newConstraint.x < 0 || newConstraint.y < 0 || newConstraint.width < 0 || newConstraint.height < 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Ther command can be undone if the node and old constraints are set.
   */
  @Override
  public boolean canUndo() {
    return node != null && oldConstraint != null;
  }

  /**
   * Save the old constraints and set new new constraints for the
   * {@link OPMNode}.
   */
  @Override
  public void execute() {
    oldConstraint = node.getConstraints();
    node.setConstraints(newConstraint);
  }

  /**
   * Restore the saved constraints to the {@link OPMNode}.
   */
  @Override
  public void undo() {
    node.setConstraints(oldConstraint);
  }

  public void setNode(final OPMNode node) {
    this.node = node;
  }

  public void setNewConstraint(Rectangle newConstraint) {
    this.newConstraint = newConstraint;
  }
}