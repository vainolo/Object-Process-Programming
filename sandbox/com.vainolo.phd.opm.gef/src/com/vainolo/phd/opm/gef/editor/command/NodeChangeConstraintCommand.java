package com.vainolo.phd.opm.gef.editor.command;

import com.vainolo.phd.opm.model.Node;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

public class NodeChangeConstraintCommand extends Command {

	private Rectangle oldConstraint;
	private Rectangle constraint;
	private Node node;
	
	@Override public void execute() {
		oldConstraint = node.getConstraints();
		node.setConstraints(constraint);
	}

	@Override public void undo() {
		node.setConstraints(oldConstraint);
	}

	public void setModel(final Node node) {
		this.node = node;
	}
	
	public void setNewConstraint(final Rectangle constraint) {
		this.constraint = constraint;
	}
}
