package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

public class OPMStructuralLinkAggregatorFigure extends Figure implements NodeFigure {
	private Triangle triangle;
	private ConnectionAnchor topAnchor, bottomAnchor;

	public OPMStructuralLinkAggregatorFigure() {
		setLayoutManager(new XYLayout());
		triangle = new Triangle();
		triangle.setBackgroundColor(ColorConstants.black);
		triangle.setFill(true);
		add(triangle);
	}
	
	@Override public void paintFigure(Graphics graphics) {
		Rectangle r = getBounds().getCopy();
		setConstraint(triangle, new Rectangle(0,0,r.width,r.height));
		triangle.invalidate();
	}
	
    @Override public ConnectionAnchor getSourceConnectionAnchor() {
        if(bottomAnchor == null) {
            bottomAnchor = new AbstractConnectionAnchor(this) {
                @Override public Point getLocation(Point reference) {
                    Point p = new Point();
                    Rectangle ownerBounds = getOwner().getBounds().getCopy();
                    p.x = ownerBounds.x+ownerBounds.width/2;
                    p.y = ownerBounds.y+ownerBounds.height;
                    return p;
                }
            };
        }
        return bottomAnchor;
    }

    @Override public ConnectionAnchor getTargetConnectionAnchor() {
        if(topAnchor == null) {
            topAnchor = new AbstractConnectionAnchor(this) {
                @Override public Point getLocation(Point reference) {
                    Point p = new Point();
                    Rectangle ownerBounds = getOwner().getBounds().getCopy();
                    p.x = ownerBounds.x+ownerBounds.width/2;
                    p.y = ownerBounds.y;
                    return p;
                }
            };
        }
        return topAnchor;
    }
	
	/**
	 * A triangle that uses all of its bounds to draw an isosceles triangle
	 * in the figure's bounds, like this:
	 * 
	 *		______
	 *     |  /\  |
	 *     | /  \ | (bounds shown as surrounding rectangle). 
	 *     |/____\|
	 * 
	 * The implementation is based on the {@link org.eclipse.draw2d.Triangle} implementation.
	 * 
	 * @author vainolo
	 *
	 */	
	private final class Triangle extends Shape {
		/** The points of the triangle. */
		protected PointList triangle = new PointList(3);
		
		
		/**
		 * {@inheritDoc}
		 */
		public void primTranslate(int dx, int dy) {
			super.primTranslate(dx, dy);
			triangle.translate(dx, dy);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override protected void outlineShape(Graphics graphics) {
			graphics.drawPolygon(triangle);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override protected void fillShape(Graphics graphics) {
			graphics.fillPolygon(triangle);
		}

		/**
		 * Validates the figure, drawing a vertical isosceles triangle filling the 
		 * figure's bounds.
		 */
		@Override public void validate() {
			super.validate();
			bounds = getBounds().getCopy();
			Point top = new Point(bounds.x+bounds.width/2, bounds.y);
			Point left = new Point(bounds.x, bounds.y+bounds.height);
			Point right = new Point(bounds.x+bounds.width, bounds.y+bounds.height);
			triangle.removeAllPoints();
			triangle.addPoint(top);
			triangle.addPoint(left);
			triangle.addPoint(right);
		}
	}
}
