package com.vainolo.opm.editor.command;

import org.eclipse.gef.commands.Command;
import com.vainolo.opm.model.OPNodeView;
import com.vainolo.opm.model.OPRectangle;

public class OPChangeNodeConstraintsCommand extends Command {

	private OPNodeView node;
	private OPRectangle constraints;
	private OPRectangle oldConstraints;

	public void setNode(OPNodeView node) {
		this.node = node;
	}

	public void setConstratins(OPRectangle constraints) {
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
