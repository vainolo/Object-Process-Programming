/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

public class OPMProcessFigure extends OPMThingFigure {
	private final Ellipse ellipse;
	private ConnectionAnchor connectionAnchor;

	public OPMProcessFigure() {
		super();
		ellipse = new Ellipse();
		ellipse.setLayoutManager(new XYLayout());
		ellipse.setFill(false);
		ellipse.setForegroundColor(OPMFigureConstants.opmProcessColor);
		ellipse.setLineWidth(OPMFigureConstants.entityBorderWidth);
		add(ellipse);
	}

	@Override
	public IFigure getContentPane() {
		return ellipse;
	}

	@Override
	protected void paintFigure(Graphics graphics) {
		Rectangle r = getBounds().getCopy();
		setConstraint(ellipse, new Rectangle(0, 0, r.width, r.height));
		setConstraint(getNameLabel(), new Rectangle(0, 0, r.width, r.height));
		ellipse.invalidate();
		getNameLabel().invalidate();
	}

	/**
	 * Creates an {@link EllipseAnchor} on the figure.
	 * 
	 * @return an {@link EllipseAnchor} on the figure.
	 */
	private ConnectionAnchor getConnectionAnchor() {
		if (connectionAnchor == null) {
			connectionAnchor = new EllipseAnchor(this);
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
