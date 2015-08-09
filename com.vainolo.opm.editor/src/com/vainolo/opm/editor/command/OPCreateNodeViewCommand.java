package com.vainolo.opm.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.opm.model.opm.OPNodeView;
import com.vainolo.opm.model.opm.OPObjectProcessDiagram;

public class OPCreateNodeViewCommand extends Command {
	private OPObjectProcessDiagram opd;
	private OPNodeView node;
	private int x, y, w, h;

	public void setObjectProcessDiagram(OPObjectProcessDiagram opd) {
		this.opd = opd;
	}
	
	public void setNode(OPNodeView node) {
		this.node = node;
	}
	
	public void setConstaints(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	@Override
	public void execute() {
		node.setX(x);
		node.setY(y);
		node.setWidth(w);
		node.setHeight(h);
		node.setOpd(opd);
		node.getModel().setSystem(opd.getSystem());
	}
	
	@Override
	public void undo() {
		node.setOpd(null);
		node.getModel().setSystem(null);
	}
}
