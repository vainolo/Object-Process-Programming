package com.vainolo.opm.editor.command;

import org.eclipse.gef.commands.Command;
import com.vainolo.opm.model.view.OPElementViewContainer;
import com.vainolo.opm.model.view.OPNodeView;

public class OPMDeleteNodeCommand extends Command {

	private OPNodeView node;
	private OPElementViewContainer container;

	public void setNode(OPNodeView node) {
		this.node = node;
	}
	
	@Override
	public void execute() {
		container = node.getElementViewContainer();
		container.removeElementView(node);
	}
	
	@Override
	public void undo() {
		container.addElementView(node);
	}

}
