package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMProceduralLink;

public class OPMProceduralLinkMoveBendpointCommand extends Command {
	
	private Point oldLocation;
	private int index;
	private OPMProceduralLink link;
	private Point location;
	
	public void execute() {
		if(oldLocation == null) {
			oldLocation = link.getBendpoints().get(index);
		}
		link.getBendpoints().set(index, location);
	}
	
	@Override public void undo() {
		link.getBendpoints().set(index, oldLocation);
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public void setOPMProceduralLink(OPMProceduralLink link) {
		this.link = link;
	}
	
	public void setLocation(Point location) {
		this.location = location;
	}
}
