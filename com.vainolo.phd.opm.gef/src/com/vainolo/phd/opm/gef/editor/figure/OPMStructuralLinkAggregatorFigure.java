package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import com.vainolo.phd.opm.model.OPMStructuralLinkAggregator;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregatorKind;

/**
 * Draws the figure for a {@link OPMStructuralLinkAggregator}. This figure
 * consists of one or two {@link IsoscelesTriangle}, filled or not filled,
 * depending on the type of aggregator that is drawn (a parameter to the figure).  
 * @author vainolo
 *
 */
public class OPMStructuralLinkAggregatorFigure extends Figure implements OPMNodeFigure {
    /** The triangle used as figure. */
    IsoscelesTriangle triangle;
    /** Anchor created at the center-top of the figure, used for target anchors. */
    private ConnectionAnchor topAnchor;
    /** Anchor created at the center-bottom of the figure, used for source anchors. */
    private ConnectionAnchor bottomAnchor;
    
    /**
     * Create a new aggregator figure depending on the aggregator kind. 
     * @param kind the {@link OPMStructuralLinkAggregatorKind} of the figure.
     */
    public OPMStructuralLinkAggregatorFigure(OPMStructuralLinkAggregatorKind kind) {
        setLayoutManager(new XYLayout());
        triangle = new IsoscelesTriangle();
        triangle.setFill(false);
        switch(kind) {
        case AGGREGATION:
            triangle.setFill(true);
            break;
        case GENERALIZATION:
        case EXHIBITION:
            triangle.setFill(false);
            break;
        }
        add(triangle);
    }
    
    @Override
    protected void paintFigure(Graphics graphics) {
        Rectangle bounds = getBounds().getCopy();
        setConstraint(triangle, new Rectangle(0,0,bounds.width,bounds.height));
        triangle.invalidate();
    }
    
    /**
     * Create a {@link ConnectionAnchor} that is located at the center-top of the figure.
     * @return a {@link ConnectionAnchor} at the center-top of the figure.
     */
    private ConnectionAnchor getTopAnchor() {
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
     * Create a {@link ConnectionAnchor} that is located at the center-bottom of the figure.
     * @return a {@link ConnectionAnchor} at the center-bottom of the figure.
     */
    private ConnectionAnchor getBottomAnchor() {
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
    
    @Override
    public ConnectionAnchor getSourceConnectionAnchor() {
        return getBottomAnchor();
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor() {
        return getTopAnchor();
    }

}
