package com.vainolo.opm.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.opm.model.opm.OPLinkView;
import com.vainolo.opm.model.opm.OPNodeView;
import com.vainolo.opm.model.opm.OPObjectProcessDiagram;

public class OPLinkViewDeleteCommand extends Command{

	private OPLinkView link;
	private OPNodeView source;
	private OPNodeView target;
	private OPObjectProcessDiagram opd;

	public void setLink(OPLinkView link) {
		this.link = link;
	}
	
	@Override
	public void execute() {
		source = link.getSource();
		target = link.getTarget();
		opd = link.getOpd();
		link.setSource(null);
		link.setTarget(null);
		link.setOpd(null);
	}
	
	@Override
	public void undo() {
		link.setSource(source);
		link.setTarget(target);
		link.setOpd(opd);
	}
}
