package com.vainolo.opm.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.opm.model.opm.OPNodeView;

public class OPChangeNodeConstraintsCommand extends Command {

	private OPNodeView node;
	private int[] constraints = new int[4];
	private int[] oldConstraints = new int[4];

	public void setNode(OPNodeView node) {
		this.node = node;
	}

	public void setConstratins(int x, int y, int width, int height) {
		constraints[0] = x;
		constraints[1] = y;
		constraints[2] = width;
		constraints[3] = height;
	}
	
	@Override
	public void execute() {
		oldConstraints[0] = node.getX();
		oldConstraints[1] = node.getY();
		oldConstraints[2] = node.getWidth();
		oldConstraints[3] = node.getHeight();
		node.setX(constraints[0]);
		node.setY(constraints[1]);
		node.setWidth(constraints[2]);
		node.setHeight(constraints[3]);
	}
	
	@Override
	public void undo() {
		node.setX(oldConstraints[0]);
		node.setY(oldConstraints[1]);
		node.setWidth(oldConstraints[2]);
		node.setHeight(oldConstraints[3]);
	}
	
	

}
