package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.Link;
import com.vainolo.phd.opm.model.Node;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;

public class LinkCreateCommand extends Command {
	
	private Node source;
	private Node target;
	private Link link;
	private OPMObjectProcessDiagram opd;

	@Override 
	public boolean canExecute() {
		return source != null && target != null && link != null && opd != null;
	}
	
	@Override public void execute() {
		link.setSource(source);
		link.setTarget(target);
		link.setOpd(opd);
	}

	@Override public void undo() {
		link.setSource(null);
		link.setTarget(null);
		link.setOpd(null);
	}

	public void setTarget(Node target) {
		this.target = target;
	}
	
	public void setSource(Node source) {
		this.source = source;
	}
	
	public void setLink(Link link) {
		this.link = link;
	}
	
	public void setOPD(OPMObjectProcessDiagram opd) {
		this.opd = opd;
	}
}
