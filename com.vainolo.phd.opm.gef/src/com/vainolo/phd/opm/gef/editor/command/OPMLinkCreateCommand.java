package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMThing;

public class OPMLinkCreateCommand extends Command {
	
	private OPMThing source;
	private OPMThing target;
	private OPMLink link;
	private OPMObjectProcessDiagram opd;

	@Override 
	public boolean canExecute() {
		return source != null && target != null && link != null;
	}
	
	@Override public void execute() {
		link.setSource(source);
		link.setTarget(target);
		link.setOpd(opd);
	}

	@Override public void undo() {
		link.getSource().getOutgoingLinks().remove(link);
		link.setSource(null);
		link.getTarget().getIncomingLinks().remove(link);
		link.setTarget(null);
		link.setOpd(null);
	}

	public void setTarget(OPMThing target) {
		this.target = target;
	}
	
	public void setSource(OPMThing source) {
		this.source = source;
	}
	
	public void setLink(OPMLink link) {
		this.link = link;
	}
	
	public void setOPD(OPMObjectProcessDiagram opd) {
		this.opd = opd;
	}
}