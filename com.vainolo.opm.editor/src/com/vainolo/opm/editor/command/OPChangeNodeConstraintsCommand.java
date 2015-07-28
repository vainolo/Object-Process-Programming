package com.vainolo.opm.editor.command;

import org.eclipse.gef.commands.Command;
import com.vainolo.opm.model.view.OPNodeView;

public class OPChangeNodeConstraintsCommand extends Command {

	private OPNodeView node;
	private int[] constraints;
	private int[] oldConstraints;

	public void setNode(OPNodeView node) {
		this.node = node;
	}

	public void setConstratins(int[] constraints) {
		this.constraints = constraints;
	}
	
	@Override
	public void execute() {
		oldConstraints = node.getConstraints();
		node.setConstraints(constraints);
	}
	
	@Override
	public void undo() {
		node.setConstraints(oldConstraints);
	}
	
	

}
