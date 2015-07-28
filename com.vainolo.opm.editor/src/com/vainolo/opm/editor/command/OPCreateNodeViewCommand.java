package com.vainolo.opm.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.view.OPElementViewContainer;
import com.vainolo.opm.model.view.OPNodeView;

public class OPCreateNodeViewCommand extends Command{
	private OPElementViewContainer container;
	private OPNodeView node;
	private int[] constraints;

	public void setObjectProcessDiagram(OPObjectProcessDiagram opd) {
		this.container = opd;
	}
	
	public void setNode(OPNodeView node) {
		this.node = node;
	}
	
	public void setConstaints(int[] constraints) {
		this.constraints = constraints;
	}
	
	@Override
	public void execute() {
		node.setConstraints(constraints);
		node.setViewElementContainer(container);
		container.addElementView(node);
	}
	
	@Override
	public void undo() {
		node.setViewElementContainer(null);
		container.removeElementView(node);
	}
}
