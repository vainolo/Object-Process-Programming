/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMProceduralLink;

public class AngulateBendpoints extends Command {

	private Point calculateMiddlePoint(Point source, Point target) {
		Point p = Point.SINGLETON;
		p.x = source.x + target.x / 2;
		p.y = source.y + target.y / 2;
		return p;
	}

	private OPMLinkCreateBendpointCommand createAddBendpointCommand(OPMProceduralLink link, Point location, int index) {
		OPMLinkCreateBendpointCommand command = new OPMLinkCreateBendpointCommand();
		command.setOPMLink(link);
		command.setLocation(location);
		command.setIndex(index);
		return command;
	}

	private OPMLinkDeleteBendpointCommand createDeleteBendpointCommand(OPMProceduralLink link, int index) {
		OPMLinkDeleteBendpointCommand command = new OPMLinkDeleteBendpointCommand();
		command.setOPMLink(link);
		command.setIndex(index);
		return command;
	}

	private OPMLinkMoveBendpointCommand createMoveBendpointCommand(OPMProceduralLink link, Point location, int index) {
		OPMLinkMoveBendpointCommand command = new OPMLinkMoveBendpointCommand();
		command.setOPMLink(link);
		command.setLocation(location);
		command.setIndex(index);
		return command;
	}
}
