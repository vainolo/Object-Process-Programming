package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

/**
 * A triangle that uses all of its bounds to draw an isosceles triangle
 * in the figure's bounds, like this:
 * 
 *      ______
 *     |  /\  |
 *     | /  \ | (bounds shown as surrounding rectangle). 
 *     |/____\|
 * 
 * The implementation is based on the {@link org.eclipse.draw2d.Triangle} implementation.
 * 
 * @author vainolo
 *
 */ 
public final class IsoscelesTriangle extends Shape {
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
