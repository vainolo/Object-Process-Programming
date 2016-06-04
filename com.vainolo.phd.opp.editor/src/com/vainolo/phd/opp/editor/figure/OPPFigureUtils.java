package com.vainolo.phd.opp.editor.figure;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.vainolo.phd.opp.model.*;

import static com.vainolo.phd.opp.editor.figure.OPPFigureUtils.*;

public class OPPFigureUtils {
  public static Point getCenter(OPPNode node) {
    int x = node.getX() + node.getWidth() / 2;
    int y = node.getY() + node.getHeight() / 2;
    return new Point(x, y);
  }

  public static Point getCenter(Rectangle rectangle) {
    int x = rectangle.x + rectangle.width / 2;
    int y = rectangle.y + rectangle.height / 2;
    return new Point(x, y);
  }

  public static boolean isNodeAboveNode(OPPNode node1, OPPNode node2) {
    return node1.getY() + node1.getHeight() + 10 < node2.getY();
  }

  public static boolean isNodeAboveNode(OPPNode node1, Rectangle newNodeConstraints) {
    return node1.getY() + node1.getHeight() + 10 < newNodeConstraints.y;
  }

  public static int bottom(OPPNode node) {
    return node.getY() + node.getHeight();
  }

  public static int top(OPPNode node) {
    return node.getY();
  }

  public static int top(Rectangle rect) {
    return rect.y;
  }

  public static int left(OPPNode node) {
    return node.getX();
  }

  public static int right(OPPNode node) {
    return node.getX() + node.getWidth();
  }

  public static OPPPoint oppPointFromPoint(Point point) {
    OPPPoint oppPoint = OPPFactory.eINSTANCE.createOPPPoint();
    oppPoint.setX(point.x);
    oppPoint.setY(point.y);
    return oppPoint;
  }

  public static Point pointFromOPPPoint(OPPPoint oppPoint) {
    Point point = new Point();
    point.setX(oppPoint.getX());
    point.setY(oppPoint.getY());
    return point;
  }

  public static Rectangle rectangleFromOPPNode(OPPNode node) {
    Rectangle r = new Rectangle();
    r.setX(node.getX());
    r.setY(node.getY());
    r.setWidth(node.getWidth());
    r.setHeight(node.getHeight());
    return r;
  }

  public static boolean isBetween(int point, int start, int end) {
    return start <= point && point <= end;
  }

  public static List<Point> createInitialBendpointsForStructuralLinkSegment(OPPNode source, Rectangle target) {
    List<Point> bendpoints = Lists.newArrayList();
    Point sourceCenter = getCenter(source), targetCenter = getCenter(target);
    bendpoints.add(new Point(sourceCenter.x, bottom(source)));
    if (isNodeAboveNode(source, target)) {
      bendpoints.add(new Point(sourceCenter.x, bottom(source) + (top(target) - bottom(source)) / 2));
      // bendpoints.add(new Point((sourceCenter.x + targetCenter.x) / 2, bottom(source) + (top(target) - bottom(source))
      // / 2));
      bendpoints.add(new Point(targetCenter.x, bottom(source) + (top(target) - bottom(source)) / 2));
    } else {
      bendpoints.add(new Point(sourceCenter.x, source.getY() + source.getHeight() + 10));
      bendpoints.add(new Point((sourceCenter.x + targetCenter.x) / 2, source.getY() + source.getHeight() + 10));
      bendpoints.add(new Point((sourceCenter.x + targetCenter.x) / 2, target.y - 10));
      bendpoints.add(new Point(targetCenter.x, target.y - 10));
    }
    bendpoints.add(new Point(targetCenter.x, top(target)));
    return Lists.reverse(bendpoints);
  }

  public static List<Point> createInitialBendpointsForStructuralLinkSegment(OPPNode source, OPPNode target) {
    Rectangle targetRect = new Rectangle(target.getX(), target.getY(), target.getWidth(), target.getHeight());
    return createInitialBendpointsForStructuralLinkSegment(source, targetRect);
  }
}
