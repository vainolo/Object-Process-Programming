package com.vainolo.opm.editor.figure;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.XYLayout;

public class OPObjectProcessDiagramFigure extends Figure {

	public OPObjectProcessDiagramFigure() {
		setLayoutManager(new XYLayout());
	}
	
	@Override
	public boolean isCoordinateSystem() {
		return true;
	}
	
	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
	}
}
