package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMProceduralLink;

public class OPMProceduralLinkDeleteBendpointCommand extends Command {

	private OPMProceduralLink link;
	private Point oldLocation;
	private int index;
	
	@Override public void execute() {
		oldLocation = link.getBendpoints().get(index);
		link.getBendpoints().remove(index);
	}

	@Override public void undo() {
		link.getBendpoints().add(index, oldLocation);
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public void setOPMProceduralLink(OPMProceduralLink link) {
		this.link = link;
	}	
}
