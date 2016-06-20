package com.vainolo.phd.opp.editor.policy;

import java.util.List;

import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.vainolo.phd.opp.editor.command.OPPLinkCreateBendpointCommand;
import com.vainolo.phd.opp.editor.command.OPPLinkDeleteBendpointCommand;
import com.vainolo.phd.opp.editor.command.OPPLinkMoveBendpointCommand;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPPoint;
import com.vainolo.phd.opp.model.OPPStructuralLinkPart;

import static com.vainolo.phd.opp.editor.figure.OPPFigureUtils.*;

public class OPPBendpointUtils {

  public static List<Point> createInitialBendpointsForStructuralLinkSegment(OPPNode source, Rectangle target) {
    List<Point> bendpoints = Lists.newArrayList();
    Point sourceCenter = getCenter(source), targetCenter = getCenter(target);
    bendpoints.add(new Point(sourceCenter.x, bottom(source)));
    if (isNodeAboveNode(source, target)) {
      bendpoints.add(new Point(sourceCenter.x, bottom(source) + (top(target) - bottom(source)) / 2));
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

  public static Point getStructuralLinkEndpoint(OPPNode node, Point ref) {
    return getStructuralLinkEndpoint(rectangleFromOPPNode(node), ref);
  }

  public static Point getStructuralLinkEndpoint(Rectangle rect, Point ref) {
    Point p = new Point();

    if (ref.x < left(rect))
      p.x = rect.x;
    else if (ref.x > right(rect))
      p.x = rect.x + rect.width;
    else
      p.x = ref.x;

    if (ref.y < top(rect))
      p.y = rect.y;
    else if (ref.y > bottom(rect))
      p.y = rect.y + rect.height;
    else
      p.y = ref.y;

    return p;
  }

  public static OPPLinkMoveBendpointCommand newMoveBendpointCommand(OPPLink link, int index, Point p) {
    OPPLinkMoveBendpointCommand mbc = new OPPLinkMoveBendpointCommand();
    mbc.setLink(link);
    mbc.setIndex(index);
    mbc.setLocation(p);
    return mbc;
  }

  public static OPPLinkCreateBendpointCommand newCreateBendpointCommand(OPPLink link, int index, Point p) {
    OPPLinkCreateBendpointCommand cbc = new OPPLinkCreateBendpointCommand();
    cbc.setLink(link);
    cbc.setIndex(index);
    cbc.setLocation(p);
    return cbc;
  }

  public static OPPLinkDeleteBendpointCommand newDeleteBendpointCcommand(OPPLink link, int index) {
    OPPLinkDeleteBendpointCommand dbc = new OPPLinkDeleteBendpointCommand();
    dbc.setLink(link);
    dbc.setIndex(index);
    return dbc;
  }

  public static Command getCommandToDeleteBendpoint(OPPStructuralLinkPart link, int index) {
    Preconditions.checkArgument(index > 1 && index < link.getBendpoints().size() - 2);

    CompoundCommand cc = new CompoundCommand();
    OPPPoint prevBendpoint = link.getBendpoints().get(index - 1);
    OPPPoint currBendpoint = link.getBendpoints().get(index);
    OPPPoint nextBendpoint = link.getBendpoints().get(index + 1);

    if (prevBendpoint.getX() == currBendpoint.getX()) {
      cc.add(newMoveBendpointCommand(link, index - 1, pointFromOPPPoint(prevBendpoint).setX(nextBendpoint.getX())));
      cc.add(newDeleteBendpointCcommand(link, index));
      cc.add(newDeleteBendpointCcommand(link, index));
    }
    if (prevBendpoint.getY() == currBendpoint.getY()) {
      cc.add(newMoveBendpointCommand(link, index - 1, pointFromOPPPoint(prevBendpoint).setY(nextBendpoint.getY())));
      cc.add(newDeleteBendpointCcommand(link, index));
      cc.add(newDeleteBendpointCcommand(link, index));
    }

    return cc;
  }

  public static Command getCommandToMoveInternalBendpoint(OPPStructuralLinkPart link, int index, Point newPoint) {
    Preconditions.checkArgument(index > 1 && index < link.getBendpoints().size() - 2);
    CompoundCommand cc = new CompoundCommand();
    cc.add(newMoveBendpointCommand(link, index, newPoint));
    OPPPoint prevBendpoint = link.getBendpoints().get(index - 1);
    OPPPoint currBendpoint = link.getBendpoints().get(index);
    OPPPoint nextBendpoint = link.getBendpoints().get(index + 1);

    if (prevBendpoint.getX() == currBendpoint.getX()) {
      cc.add(newMoveBendpointCommand(link, index - 1, pointFromOPPPoint(prevBendpoint).setX(newPoint.x)));
    } else {
      cc.add(newMoveBendpointCommand(link, index + 1, pointFromOPPPoint(nextBendpoint).setX(newPoint.x)));
    }

    if (prevBendpoint.getY() == currBendpoint.getY()) {
      cc.add(newMoveBendpointCommand(link, index - 1, pointFromOPPPoint(prevBendpoint).setY(newPoint.y)));
    } else {
      cc.add(newMoveBendpointCommand(link, index + 1, pointFromOPPPoint(nextBendpoint).setY(newPoint.y)));
    }

    return cc;
  }

  public static Command getCommanToMoveLastBendpointBeforeAggregator(OPPStructuralLinkPart link, int index, Point newPoint) {
    Preconditions.checkArgument(index == link.getBendpoints().size() - 2);
    List<OPPPoint> bendpoints = link.getBendpoints();
    Point targetPoint = pointFromOPPPoint(bendpoints.get(index + 1));

    if (newPoint.y > targetPoint.y - 5)
      return UnexecutableCommand.INSTANCE;

    if (Math.abs(newPoint.x - targetPoint.x) > 5)
      return UnexecutableCommand.INSTANCE;

    Command c = newMoveBendpointCommand(link, index, newPoint.setX(targetPoint.x));
    c = c.chain(newMoveBendpointCommand(link, index - 1, pointFromOPPPoint(bendpoints.get(index - 1)).setY(newPoint.y)));
    return c;
  }

  public static Command getCommandToMoveFirstBendpointAfterAggregator(OPPStructuralLinkPart link, Point newPoint) {
    List<OPPPoint> bendpoints = link.getBendpoints();
    Point sourcePoint = pointFromOPPPoint(bendpoints.get(0));
    Point nextPoint = pointFromOPPPoint(bendpoints.get(2));

    if (newPoint.y < sourcePoint.y + 5)
      return UnexecutableCommand.INSTANCE;

    CompoundCommand cc = new CompoundCommand();
    cc.add(newMoveBendpointCommand(link, 1, newPoint.setX(sourcePoint.x)));
    if (bendpoints.size() != 3) {
      cc.add(newMoveBendpointCommand(link, 2, nextPoint.setY(newPoint.y)));
    } else { // size == 3
      Point newTarget = getStructuralLinkEndpoint(link.getTarget(), newPoint);
      cc.add(newMoveBendpointCommand(link, 2, newTarget));
      if (!isBetween(newPoint.y, top(link.getTarget()), bottom(link.getTarget()))) {
        cc.add(newCreateBendpointCommand(link, 2, (new Point()).setX(middle(sourcePoint.x, newTarget.x)).setY(newPoint.y)));
        cc.add(newCreateBendpointCommand(link, 3, (new Point()).setX(middle(sourcePoint.x, newTarget.x)).setY(newTarget.y)));
      }
    }
    return cc;
  }

  public static Command getCommandToMoveFirstBendpointAfterThing(OPPStructuralLinkPart link, Point newPoint) {
    CompoundCommand cc = new CompoundCommand();

    List<OPPPoint> bendpoints = link.getBendpoints();
    Point currPoint = pointFromOPPPoint(bendpoints.get(1));
    Point nextPoint = pointFromOPPPoint(bendpoints.get(2));
    Point newTarget = getStructuralLinkEndpoint(link.getSource(), newPoint);
    Rectangle rect = rectangleFromOPPNode(link.getSource());

    cc.add(newMoveBendpointCommand(link, 0, newTarget));
    if (isAboveOrBelow(rect, currPoint) && isAboveOrBelow(rect, newPoint)) {
      cc.add(newMoveBendpointCommand(link, 1, newPoint));
      cc.add(newMoveBendpointCommand(link, 2, nextPoint.setY(newPoint.y)));
      if (!(isBetween(newPoint.x, rect.x, rect.x + rect.width))) {
        cc.add(newCreateBendpointCommand(link, 1, (new Point()).setX(newPoint.x).setY(middle(newPoint.y, newTarget.y))));
        cc.add(newCreateBendpointCommand(link, 1, (new Point()).setX(newTarget.x).setY(middle(newPoint.y, newTarget.y))));
      }
    } else if (isLeftOrRight(rect, currPoint) && isLeftOrRight(rect, newPoint)) {
      cc.add(newMoveBendpointCommand(link, 1, newPoint));
      cc.add(newMoveBendpointCommand(link, 2, nextPoint.setX(newPoint.x)));
      if (!(isBetween(newPoint.y, rect.y, rect.y + rect.height))) {
        cc.add(newCreateBendpointCommand(link, 1, (new Point()).setX(middle(newPoint.x, newTarget.x)).setY(newPoint.y)));
        cc.add(newCreateBendpointCommand(link, 1, (new Point()).setX(middle(newPoint.x, newTarget.x)).setY(newTarget.y)));
      }
    } else { // move from vertical to horizontal or from horizontal to vertical
      if (bendpoints.size() % 2 == 0) { // currently vertical
        cc.add(newMoveBendpointCommand(link, 2, nextPoint.setY(newPoint.y)));
        cc.add(newDeleteBendpointCcommand(link, 1));
      } else { // currently horizontal
        if (bendpoints.size() == 3) {
          cc.add(newMoveBendpointCommand(link, 1, currPoint.setY(newPoint.y)));
          cc.add(newCreateBendpointCommand(link, 1, (new Point()).setX(newTarget.x).setY(newPoint.y)));
        } else {
          cc.add(newMoveBendpointCommand(link, 2, nextPoint.setX(newPoint.x)));
          cc.add(newDeleteBendpointCcommand(link, 1));
        }
      }
    }
    return cc;
  }

  public static Command getCommantToMoveLastBendpointBeforeTarget(OPPStructuralLinkPart link, Point newPoint) {
    CompoundCommand cc = new CompoundCommand();

    List<OPPPoint> bendpoints = link.getBendpoints();
    int lastIndex = bendpoints.size() - 1;
    Point currPoint = pointFromOPPPoint(bendpoints.get(lastIndex - 1));
    Point prevPoint = pointFromOPPPoint(bendpoints.get(lastIndex - 2));
    Point newTarget = getStructuralLinkEndpoint(link.getTarget(), newPoint);
    Rectangle rect = rectangleFromOPPNode(link.getTarget());

    cc.add(newMoveBendpointCommand(link, lastIndex, newTarget));
    if (isAboveOrBelow(rect, currPoint) && isAboveOrBelow(rect, newPoint)) {
      cc.add(newMoveBendpointCommand(link, lastIndex - 1, newPoint));
      cc.add(newMoveBendpointCommand(link, lastIndex - 2, prevPoint.setY(newPoint.y)));
      if (!isBetween(newPoint.x, rect.x, rect.x + rect.width)) {
        cc.add(newCreateBendpointCommand(link, lastIndex, (new Point()).setX(newTarget.x).setY(middle(newPoint.y, newTarget.y))));
        cc.add(newCreateBendpointCommand(link, lastIndex, (new Point()).setX(newPoint.x).setY(middle(newPoint.y, newTarget.y))));
      }
    } else if (isLeftOrRight(rect, currPoint) && isLeftOrRight(rect, newPoint)) {
      cc.add(newMoveBendpointCommand(link, lastIndex - 1, newPoint));
      cc.add(newMoveBendpointCommand(link, lastIndex - 2, prevPoint.setX(newPoint.x)));
      if (!isBetween(newPoint.y, rect.y, rect.y + rect.height)) {
        cc.add(newCreateBendpointCommand(link, lastIndex, (new Point()).setX(middle(newPoint.x, newTarget.x)).setY(newTarget.y)));
        cc.add(newCreateBendpointCommand(link, lastIndex, (new Point()).setX(middle(newPoint.x, newTarget.x)).setY(newPoint.y)));
      }
    } else {
      if (bendpoints.size() % 2 == 0) { // currently vertical
        cc.add(newMoveBendpointCommand(link, lastIndex - 2, prevPoint.setY(newPoint.y)));
        cc.add(newDeleteBendpointCcommand(link, lastIndex - 1));
      } else { // currently horizontal
        cc.add(newMoveBendpointCommand(link, lastIndex - 2, prevPoint.setX(newPoint.x)));
        cc.add(newDeleteBendpointCcommand(link, lastIndex - 1));
      }
    }

    return cc;

  }
}
