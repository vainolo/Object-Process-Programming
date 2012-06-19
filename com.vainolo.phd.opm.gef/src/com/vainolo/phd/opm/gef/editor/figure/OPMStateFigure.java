/*******************************************************************************
 * This is me!!!
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * A figure representing an OPM State. A state is represented by a rountangle (rounded rectangle).
 * 
 * @author vainolo
 * 
 */
public class OPMStateFigure extends Figure implements OPMNodeFigure, OPMNamedElementFigure {
	private final RoundedRectangle rectangle;
	private ConnectionAnchor connectionAnchor;
	private final Label nameLabel;

	public OPMStateFigure() {
		super();
		setLayoutManager(new XYLayout());
		nameLabel = new Label();
		add(nameLabel);
		rectangle = new RoundedRectangle();
		rectangle.setFill(false);
		rectangle.setForegroundColor(OPMFigureConstants.opmStateColor);
		rectangle.setLineWidth(OPMFigureConstants.entityBorderWidth);
		add(rectangle);
	}

	/**
	 * Get the label used to set the name of the state.
	 * 
	 * @return the label where the name of the state is shown.
	 */
	@Override
	public Label getNameLabel() {
		return nameLabel;
	}

	/**
	 * All connections to the figure use the same anchor: a {@link ChopboxAnchor}.
	 * 
	 * @return a {@link ChopboxAnchor} for the state.
	 */
	private ConnectionAnchor getConnectionAnchor() {
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

	@Override
	public Dimension getPreferredSize(int wHint, int hHint) {
		Dimension d = new Dimension();
		Rectangle textRectangle = getNameLabel().getTextBounds().getCopy();
		d.width = textRectangle.width;
		d.height = textRectangle.height;
		return d;
	}

	@Override
	protected void paintFigure(Graphics graphics) {
		Rectangle r = getBounds().getCopy();
		setConstraint(rectangle, new Rectangle(0, 0, r.width, r.height));
		setConstraint(getNameLabel(), new Rectangle(0, 0, r.width, r.height));
		rectangle.invalidate();
		getNameLabel().invalidate();
	}
}
