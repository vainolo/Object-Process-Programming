package com.vainolo.opm.editor.figure;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;

public abstract class OPMNodeFigure extends Figure {
	
	protected ConnectionAnchor anchor;

	public OPMNodeFigure() {
		setConnectionAnchor(new ChopboxAnchor(this));
	}
	
	@Override
	protected boolean useLocalCoordinates() {
		return true;
	}

	public ConnectionAnchor getConnectionAnchor() {
		return anchor;
	}
	
	protected void setConnectionAnchor(ConnectionAnchor anchor) {
		this.anchor = anchor;
	}
}
