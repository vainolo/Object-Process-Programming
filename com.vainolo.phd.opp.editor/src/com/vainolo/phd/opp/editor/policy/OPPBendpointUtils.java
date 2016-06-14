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

  public static Command getCommantToMoveLastBendpointBeforeTarget(OPPStructuralLinkPart link, Rectangle target, int index, Point currPoint, Point newPoint) {
    Point prevPoint = pointFromOPPPoint(link.getBendpoints().get(index - 1));
    Point endPoint = getStructuralLinkEndpoint(target, newPoint);

    CompoundCommand cc = new CompoundCommand();

    if (isBetween(newPoint.x, target.x, target.x + target.width) && isBetween(newPoint.y, target.y, target.y + target.height))
      return null;

    if (isBetween(currPoint.x, target.x, target.x + target.width)) {
      // above or below
      if (endPoint.y == target.y || endPoint.y == target.y + target.height) {
        // still above or below
        cc.add(newMoveBendpointCommand(link, index, newPoint.setX(endPoint.x)));
        cc.add(newMoveBendpointCommand(link, index + 1, endPoint));
        cc.add(newMoveBendpointCommand(link, index - 1, prevPoint.setY(newPoint.y)));
      } else {
        // Moving to the sides
        cc.add(newMoveBendpointCommand(link, index, newPoint));
        cc.add(newMoveBendpointCommand(link, index + 1, endPoint));
        cc.add(newCreateBendpointCommand(link, index, (new Point()).setX(newPoint.x).setY(prevPoint.y)));
      }
    } else {
      // on the sides
      if (endPoint.x == target.x || endPoint.x == target.x + target.width) {
        // still on the sides
        if (link.getBendpoints().size() == 3) { // special case for _| part from aggregator to target
          cc.add(newMoveBendpointCommand(link, index, currPoint.setY(endPoint.y)));
          cc.add(newMoveBendpointCommand(link, index + 1, endPoint));
        } else {
          cc.add(newMoveBendpointCommand(link, index, newPoint.setY(endPoint.y)));
          cc.add(newMoveBendpointCommand(link, index + 1, endPoint));
          cc.add(newMoveBendpointCommand(link, index - 1, prevPoint.setX(newPoint.x)));
        }
      } else {
        // Moving above or below
        cc.add(newMoveBendpointCommand(link, index, newPoint));
        cc.add(newMoveBendpointCommand(link, index + 1, endPoint));
        cc.add(newCreateBendpointCommand(link, index, prevPoint.setY(newPoint.y)));
      }
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
    int index = 1;
    List<OPPPoint> bendpoints = link.getBendpoints();
    Point sourcePoint = pointFromOPPPoint(bendpoints.get(0));

    if (newPoint.y < sourcePoint.y + 5)
      return UnexecutableCommand.INSTANCE;

    if (Math.abs(newPoint.x - sourcePoint.x) > 5)
      return UnexecutableCommand.INSTANCE;

    Command c = newMoveBendpointCommand(link, index, newPoint.setX(sourcePoint.x));
    c = c.chain(newMoveBendpointCommand(link, index + 1, pointFromOPPPoint(bendpoints.get(index + 1)).setY(newPoint.y)));
    return c;
  }

  public static Command getCommandToMoveFirstBendpointAfterThing(OPPStructuralLinkPart link, Point newPoint) {
    int index = 1;

    return null;
  }

}
