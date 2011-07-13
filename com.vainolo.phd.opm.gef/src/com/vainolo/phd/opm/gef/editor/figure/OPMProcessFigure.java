package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

public class OPMProcessFigure extends Figure implements OPMThingFigure {
	private Label nameLabel;
	private Ellipse ellipse;
	private ConnectionAnchor connectionAnchor;	
	
	public OPMProcessFigure() {
		setLayoutManager(new XYLayout());
		ellipse = new Ellipse();
		add(ellipse);
		nameLabel = new Label();
		add(nameLabel);
	}

	@Override protected void paintFigure(Graphics graphics) {
		Rectangle r = getBounds().getCopy();
		setConstraint(ellipse, new Rectangle(0, 0, r.width, r.height));
		setConstraint(nameLabel, new Rectangle(0, 0, r.width, r.height));
		ellipse.invalidate();
		nameLabel.invalidate();
	}
	
	public Label getNameLabel() {
		return nameLabel;
	}
	
	public ConnectionAnchor getConnectionAnchor() {
		if (connectionAnchor == null) {
			connectionAnchor = new EllipseAnchor(this);
		}
		return connectionAnchor;
	}		
}
