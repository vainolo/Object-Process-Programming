package com.vainolo.opm.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.opm.model.OPNodeView;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.OPViewContainer;

public class OPMDeleteNodeCommand extends Command {

	private OPNodeView node;
	private OPViewContainer container;

	public void setNode(OPNodeView node) {
		this.node = node;
	}
	
	@Override
	public void execute() {
		container = node.getContainer();
		container.removeNode(node);
	}
	
	@Override
	public void undo() {
		container.addNode(node);
	}

}
