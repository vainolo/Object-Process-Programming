/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.model.OPPNode;

/**
 * Command used to changed the constraints of a node.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPPNodeChangeConstraintCommand extends Command {

  private int oldX, oldY, oldW, oldH;
  private int newX, newY, newW, newH;
  private OPPNode node;

  /**
   * The command can be executed when all parameters have been set.
   */
  @Override
  public boolean canExecute() {
    if (node == null)
      return false;
    if (newX < 0 || newY < 0 || newW < 0 || newH < 0) {
      return false;
    }
    return true;
  }

  /**
   * The command can be undone.
   */
  @Override
  public boolean canUndo() {
    return true;
  }

  /**
   * Save the old constraints and set new new constraints for the {@link OPPNode}.
   */
  @Override
  public void execute() {
    oldX = node.getX();
    oldY = node.getY();
    oldW = node.getWidth();
    oldH = node.getHeight();
    node.setConstraints(newX, newY, newW, newH);
  }

  /**
   * Restore the saved constraints to the {@link OPPNode}.
   */
  @Override
  public void undo() {
    node.setConstraints(oldX, oldY, oldW, oldH);
  }

  public void setNode(OPPNode node) {
    this.node = node;
  }

  public void setNewConstraint(int newX, int newY, int newW, int newH) {
    this.newX = newX;
    this.newY = newY;
    this.newW = newW;
    this.newH = newH;
  }
}