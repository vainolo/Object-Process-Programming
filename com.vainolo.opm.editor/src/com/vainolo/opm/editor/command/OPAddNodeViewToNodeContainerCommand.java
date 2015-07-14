package com.vainolo.opm.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.opm.model.OPNodeView;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.OPRectangle;
import com.vainolo.opm.model.OPViewContainer;

public class OPAddNodeViewToNodeContainerCommand extends Command{
	private OPViewContainer container;
	private OPNodeView node;
	private OPRectangle constraints;

	public void setObjectProcessDiagram(OPObjectProcessDiagram opd) {
		this.container = opd;
	}
	
	public void setNode(OPNodeView node) {
		this.node = node;
	}
	
	public void setConstaints(OPRectangle constraints) {
		this.constraints = constraints;
	}
	
	@Override
	public void execute() {
		node.setConstraints(constraints);
		node.setContainer(container);
		container.addNode(node);
	}
	
	@Override
	public void undo() {
		node.setContainer(null);
		container.removeNode(node);
	}
}
