package com.vainolo.opm.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.opm.model.OPConstraints;
import com.vainolo.opm.model.OPContainer;
import com.vainolo.opm.model.OPNode;
import com.vainolo.opm.model.OPNodeView;

public class OPNodeCreateCommand extends Command{
	private OPContainer container;
	private OPNode node;
	private OPConstraints constraints;

	public void setContainer(OPContainer container) {
		this.container = container;
	}
	
	public void setNode(OPNode node) {
		this.node = node;
	}
	
	public void setConstaints(OPConstraints constraints) {
		this.constraints = constraints;
	}
	
	@Override
	public void execute() {
		node.setContainer(container);
		OPNodeView view = node.getViewModel();
		view.setConstraints(constraints);
		node.setViewModel(view);
	}
	
	@Override
	public void undo() {
		node.setContainer(null);
	}
}
