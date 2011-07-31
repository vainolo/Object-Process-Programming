package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.Node;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;

public class NodeCreateCommand extends Command {
	
	private static final Dimension DEFAULT_DIMENSION = new Dimension(50, 50);

	private Node newNode;
	private Rectangle constraints;
	private OPMObjectProcessDiagram opd;

	@Override public boolean canExecute() {
	    return newNode != null && constraints != null && opd != null;
	}
	
	@Override public void execute() {
	    newNode.setConstraints(constraints);
		newNode.setParent(opd);
	}
	
	@Override public void undo() {
		newNode.setParent(null);
	}

	public void setLocation(final Point location) {
		constraints = new Rectangle(location, DEFAULT_DIMENSION);
	}
	
	public void setParent(final OPMObjectProcessDiagram opd) {
		this.opd = opd;
	}
	
	public void setNode(final Node newNode) {
		this.newNode = newNode;
	}
}
