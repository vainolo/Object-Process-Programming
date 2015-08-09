package com.vainolo.opm.editor.figure;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.Triangle;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

import com.vainolo.opm.model.opm.OPStructuralLinkKind;

public class OPStructuralLinkAggregatorFigure extends OPMNodeFigure {
  private StructuralTriangle triangle;

  private ConnectionAnchor topAnchor;
  private ConnectionAnchor bottomAnchor;

   public OPStructuralLinkAggregatorFigure(OPStructuralLinkKind kind) {
    setLayoutManager(new XYLayout());
    triangle = new StructuralTriangle();
    triangle.setBackgroundColor(ColorConstants.black);
    switch(kind) {
    case AGGREGATION:
      triangle.setFill(true);
      break;
    case EXHIBITION:
      triangle.setFill(false);
      break;
    default:
      throw new IllegalArgumentException("Invalid aggregator kind: " + kind);
    }
    add(triangle);
  }

  @Override
  protected void paintFigure(Graphics graphics) {
	  super.paintFigure(graphics);
	  Rectangle bounds = getBounds().getCopy();
	  setConstraint(triangle, new Rectangle(0, 0, bounds.width, bounds.height));
  }

  /**
   * Create a {@link ConnectionAnchor} that is located at the center-top of the
   * figure.
   * 
   * @return a {@link ConnectionAnchor} at the center-top of the figure.
   */
  private ConnectionAnchor getTopAnchor() {
    if(topAnchor == null) {
      topAnchor = new AbstractConnectionAnchor(this) {
        @Override
        public Point getLocation(Point reference) {
          Point p = new Point();
          Rectangle ownerBounds = getOwner().getBounds().getCopy();
          p.x = ownerBounds.x + ownerBounds.width / 2;
          p.y = ownerBounds.y;
          translateToAbsolute(p);
          return p;
        }
      };
    }
    return topAnchor;

  }

  /**
   * Create a {@link ConnectionAnchor} that is located at the center-bottom of
   * the figure.
   * 
   * @return a {@link ConnectionAnchor} at the center-bottom of the figure.
   */
  private ConnectionAnchor getBottomAnchor() {
    if(bottomAnchor == null) {
      bottomAnchor = new AbstractConnectionAnchor(this) {
        @Override
        public Point getLocation(Point reference) {
          Point p = new Point();
          Rectangle ownerBounds = getOwner().getBounds().getCopy();
          p.x = ownerBounds.x + ownerBounds.width / 2;
          p.y = ownerBounds.y + ownerBounds.height;
          translateToAbsolute(p);
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
  
  public class StructuralTriangle extends Shape {
	protected PointList triangle = new PointList(3);	  
	
	@Override
	protected void fillShape(Graphics g) {
		g.fillPolygon(triangle);
	}
	
	@Override
	protected void outlineShape(Graphics g) {
		g.drawPolygon(triangle);
	}
	
	@Override
	public void validate() {
		super.validate();
		Rectangle r = getBounds().getCopy();
		triangle.removeAllPoints();
		triangle.addPoint(r.x+r.width/2, r.y);
		triangle.addPoint(r.x, r.y+r.height);
		triangle.addPoint(r.x+r.width, r.y+r.height);
	}
  }

}
