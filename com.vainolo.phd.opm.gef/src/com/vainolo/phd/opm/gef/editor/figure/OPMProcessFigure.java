package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

public class OPMProcessFigure extends Figure implements OPMThingFigure {
	private Label nameLabel;
	private Ellipse ellipse;
	private ConnectionAnchor connectionAnchor;	
	
	public OPMProcessFigure() {
		setLayoutManager(new XYLayout());
        nameLabel = new Label();
        add(nameLabel);
		ellipse = new Ellipse();
		ellipse.setLayoutManager(new XYLayout());
		ellipse.setFill(false);
		add(ellipse);
	}
	
	@Override
	public IFigure getContentPane() {
	    return ellipse;
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
	
	/**
	 * Creates an {@link EllipseAnchor} on the figure.
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
    
    @Override
    protected boolean useLocalCoordinates() {
        return true;
    }
}
