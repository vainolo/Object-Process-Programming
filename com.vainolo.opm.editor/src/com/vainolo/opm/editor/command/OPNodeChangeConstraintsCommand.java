package com.vainolo.opm.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.opm.model.OPConstraints;
import com.vainolo.opm.model.OPNode;
import com.vainolo.opm.model.OPNodeView;

public class OPNodeChangeConstraintsCommand extends Command {

	private OPNode node;
	private OPConstraints constraints;
	private OPConstraints oldConstraints;

	public void setNode(OPNode node) {
		this.node = node;
	}

	public void setConstratins(OPConstraints constraints) {
		this.constraints = constraints;
	}
	
	@Override
	public void execute() {
		oldConstraints = node.getViewModel().getConstraints();
		node.getViewModel().setConstraints(constraints);
	}
	
	@Override
	public void undo() {
		node.getViewModel().setConstraints(oldConstraints);
	}
	
	

}
