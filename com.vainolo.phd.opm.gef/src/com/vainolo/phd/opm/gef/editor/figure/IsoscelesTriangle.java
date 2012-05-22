/*******************************************************************************
 * This is me!!!
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Orientable;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * A triangle that uses all of its bounds to draw an isosceles triangle in the
 * figure's bounds, like this:
 * 
 * <pre>
 *      ______
 *     |  /\  |
 *     | /  \ | (bounds shown as surrounding rectangle). 
 *     |/____\|
 * </pre>
 * 
 * The implementation is based on the {@link org.eclipse.draw2d.Triangle}
 * implementation.
 * 
 * @author vainolo
 * 
 */
public final class IsoscelesTriangle extends Shape implements Orientable {
	/** The points of the triangle. */
	protected PointList triangle = new PointList(3);
	/**
	 * The direction this triangle will face. Possible values are
	 * {@link PositionConstants#NORTH}, {@link PositionConstants#SOUTH},
	 * {@link PositionConstants#EAST} and {@link PositionConstants#WEST}.
	 */
	protected int direction = NORTH;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void primTranslate(int dx, int dy) {
		super.primTranslate(dx, dy);
		triangle.translate(dx, dy);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void outlineShape(Graphics graphics) {
		graphics.drawPolygon(triangle);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void fillShape(Graphics graphics) {
		graphics.fillPolygon(triangle);
	}

	/**
	 * Validates the figure, drawing a vertical isosceles triangle filling the
	 * figure's bounds.
	 */
	@Override
	public void validate() {
		super.validate();
		Rectangle r = getBounds().getCopy();
		r.shrink(getInsets());
		r.resize(-1, -1);
		Point p1 = null, p2 = null, p3 = null;
		switch (direction) {
		case NORTH:
			p1 = new Point(r.x + r.width / 2, r.y);
			p2 = new Point(r.x, r.y + r.height);
			p3 = new Point(r.x + r.width, r.y + r.height);
			break;
		case SOUTH:
			p1 = new Point(r.x + r.width / 2, r.y + r.height);
			p2 = new Point(r.x, r.y);
			p3 = new Point(r.x + r.width, r.y);
			break;
		case EAST:
			p1 = new Point(r.x, r.y);
			p2 = new Point(r.x + r.width, r.y + r.height / 2);
			p3 = new Point(r.x, r.y + r.height);
			break;
		case WEST:
			p1 = new Point(r.x + r.width, r.y);
			p2 = new Point(r.x + r.width, r.y + r.height);
			p3 = new Point(r.x, r.y + r.height / 2);
		}
		triangle.removeAllPoints();
		triangle.addPoint(p1);
		triangle.addPoint(p2);
		triangle.addPoint(p3);
	}

	/**
	 * This functions is ignored. Use
	 * {@link IsoscelesTriangle#setDirection(int)} instead.
	 */
	@Override
	@Deprecated
	public void setOrientation(final int orientation) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDirection(final int direction) {
		if (direction != NORTH && direction != SOUTH && direction != EAST
				&& direction != WEST) {
			throw new IllegalArgumentException("Invalid direction " + direction);
		}
		this.direction = direction;
		revalidate();
		repaint();
	}
}
