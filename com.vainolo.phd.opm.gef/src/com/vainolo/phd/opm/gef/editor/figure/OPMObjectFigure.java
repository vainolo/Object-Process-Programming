/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

public class OPMObjectFigure extends OPMThingFigure {
	private final RectangleFigure rectangle;
	private ConnectionAnchor connectionAnchor;

	public OPMObjectFigure() {
		super();
		rectangle = new RectangleFigure();
		rectangle.setFill(false);
		rectangle.setLayoutManager(new XYLayout());
		rectangle.setForegroundColor(OPMFigureConstants.opmObjectColor);
		rectangle.setLineWidth(OPMFigureConstants.entityBorderWidth);
		add(rectangle);
	}

	@Override
	public IFigure getContentPane() {
		return rectangle;
	}

	@Override
	protected void paintFigure(Graphics graphics) {
		Rectangle r = getBounds().getCopy();
		setConstraint(rectangle, new Rectangle(0, 0, r.width, r.height));
		setConstraint(getNameLabel(), new Rectangle(0, 0, r.width, r.height));
		rectangle.invalidate();
		getNameLabel().invalidate();
	}

	public ConnectionAnchor getConnectionAnchor() {
		if (connectionAnchor == null) {
			connectionAnchor = new ChopboxAnchor(this);
		}
		return connectionAnchor;
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor() {
		return getConnectionAnchor();
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor() {
		return getConnectionAnchor();
	}
}