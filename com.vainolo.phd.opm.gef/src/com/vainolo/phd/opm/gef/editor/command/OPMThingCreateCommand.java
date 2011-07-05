package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMThing;

public class OPMThingCreateCommand extends Command {
	
	private static final Dimension defaultDimension = new Dimension(50, 50);
	private static final String defaultName = "<...>";

	private OPMThing newThing;
	private Rectangle constraints;
	private OPMObjectProcessDiagram opd;
	
	@Override public void execute() {
		newThing.setName(defaultName);
		if(constraints != null) {
			newThing.setConstraints(constraints);
		}
		newThing.setOpd(opd);
	}
	
	@Override public void undo() {
		newThing.setOpd(null);
	}

	public void setLocation(Point location) {
		constraints = new Rectangle(location, defaultDimension);
	}
	
	public void setParent(OPMObjectProcessDiagram opd) {
		this.opd = opd;
	}
	
	public void setThing(OPMThing newThing) {
		this.newThing = newThing;
	}
}