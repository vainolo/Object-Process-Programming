package com.vainolo.phd.opm.gef.editor.command;

import com.vainolo.phd.opm.model.OPMNode;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

/**
 * Command used to changed the constraints of a node.
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
	    return node != null && oldConstraint != null && newConstraint != null;
	}
	
	/**
	 * Save the old constraints and set new new constraints for the {@link OPMNode}.
	 */
	@Override public void execute() {
	    oldConstraint = node.getConstraints();
		node.setConstraints(newConstraint);
	}

	/**
	 * Restore the saved constraints to the {@link OPMNode}.
	 */
	@Override public void undo() {
		node.setConstraints(oldConstraint);
	}
	
	//TODO changed multiple functions to one parameter function.
	public void setNode(final OPMNode node) {
		this.node = node;
	}
	
	public void setNewConstraint(Rectangle newConstraint) {
		this.newConstraint = newConstraint;
	}
}