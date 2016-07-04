package com.vainolo.phd.opp.editor.figure;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import static com.vainolo.phd.opp.editor.figure.OPPFigureUtils.*;

public class OPPEllipseStructuralLinkAnchor extends AbstractConnectionAnchor {

  public OPPEllipseStructuralLinkAnchor(OPPProcessFigure figure) {
    super(figure);
  }

  @Override
  public Point getLocation(Point reference) {
    Rectangle rect = Rectangle.SINGLETON;
    rect.setBounds(getOwner().getBounds()).translate(-1, -1).resize(1, 1);
    getOwner().translateToAbsolute(rect);
    Point ref = rect.getCenter().negate().translate(reference);

    double a, b;
    if (isHorizontal(rect)) {
      a = rect.width / 2d;
      b = rect.height / 2d;
    } else {
      a = rect.height / 2d;
      b = rect.width / 2d;
    }
    double a2 = a * a, b2 = b * b, x2 = ref.x * ref.x, y2 = ref.y * ref.y;

    int possibleX = (int) Math.sqrt(a2 * (1 - y2 / b2));
    int possibleY = (int) Math.sqrt(b2 * (1 - x2 / a2));

    if (Math.abs(rect.x - reference.x) < 2)
      return new Point(rect.getCenter().x - possibleX, reference.y);
    else if (Math.abs(rect.x + rect.width - reference.x) < 2)
      return new Point(rect.getCenter().x + possibleX, reference.y);
    else if (Math.abs(rect.y - reference.y) < 2)
      return new Point(reference.x, rect.getCenter().y - possibleY);
    else
      return new Point(reference.x, rect.getCenter().y + possibleY);
  }

  private boolean isHorizontal(Rectangle r) {
    return r.width > r.height;
  }

}
