package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

public class OPMObjectFigure extends Figure implements OPMThingFigure {
	private Label nameLabel;
	private RectangleFigure rectangle;
	private ConnectionAnchor connectionAnchor;
	
	public OPMObjectFigure() {
        setLayoutManager(new XYLayout());
        rectangle = new RectangleFigure();
        rectangle.setLayoutManager(new XYLayout());
        add(rectangle);
        nameLabel = new Label();
        add(nameLabel);
	}
	
	@Override
	public IFigure getContentPane() {
	    return rectangle;
	}
	
	/**
	 * The internal model figures of this figure are added to this
	 * figure's {@code contentPane}, therefore to enable child selection
	 * we have to override the {@link IFigure#findFigureAt(int, int, TreeSearch)} so
	 * that it searches the {@code contentPane}.
	 * @return the topmost figure below the given point, null if none found.
	 */
	@Override
	public IFigure findFigureAt(int x, int y, TreeSearch search) {
	    return getContentPane().findFigureAt(x, y, search);
	}
	
	@Override protected void paintFigure(Graphics graphics) {
		Rectangle r = getBounds().getCopy();
		setConstraint(rectangle, new Rectangle(0, 0, r.width, r.height));
		setConstraint(nameLabel, new Rectangle(0, 0, r.width, r.height));
		nameLabel.invalidate();		
		rectangle.invalidate();
	}
	
	public Label getNameLabel() {
		return nameLabel;
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