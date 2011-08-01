package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

public class OPMObjectFigure extends Figure implements NamedNodeFigure {
	private Label nameLabel;
	private RectangleFigure rectangle;
	private ConnectionAnchor connectionAnchor;
	
	public OPMObjectFigure() {
		setLayoutManager(new XYLayout());
		rectangle = new RectangleFigure();
		add(rectangle);
		nameLabel = new Label();
		add(nameLabel);
		setOpaque(false);
	}

	@Override protected void paintFigure(Graphics graphics) {
		Rectangle r = getBounds().getCopy();
		setConstraint(rectangle, new Rectangle(0, 0, r.width, r.height));
		setConstraint(nameLabel, new Rectangle(0, 0, r.width, r.height));
		nameLabel.invalidate();		
		rectangle.invalidate();
	}
	
	@Override public Label getNameLabel() {
		return nameLabel;
	}
	
	private ConnectionAnchor getConnectionAnchor() {
        if (connectionAnchor == null) {
            connectionAnchor = new ChopboxAnchor(this);
        }
        return connectionAnchor;
	}
	
	@Override public ConnectionAnchor getSourceConnectionAnchor() {
	    return getConnectionAnchor();
	}

    @Override public ConnectionAnchor getTargetConnectionAnchor() {
        return getConnectionAnchor();
    }
    
    @Override public void paint(Graphics graphics) {
        // TODO added for debug, remove later.
        super.paint(graphics);
    }
}
