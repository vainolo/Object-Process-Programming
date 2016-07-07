package com.vainolo.phd.opp.editor.policy;

import java.util.List;

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
import com.vainolo.phd.opp.model.*;

import static com.vainolo.phd.opp.editor.figure.OPPFigureUtils.*;

public class OPPBendpointUtils {

  public List<Point> createInitialBendpointsForStructuralLinkSegment(OPPNode source, Rectangle target) {
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

  public List<Point> createInitialBendpointsForStructuralLinkSegment(OPPNode source, OPPNode target) {
    Rectangle targetRect = new Rectangle(target.getX(), target.getY(), target.getWidth(), target.getHeight());
    return createInitialBendpointsForStructuralLinkSegment(source, targetRect);
  }

  public Point getStructuralLinkEndpoint(OPPNode node, Point ref) {
    return getStructuralLinkEndpoint(rectangleFromOPPNode(node), ref);
  }

  public Point getStructuralLinkEndpoint(Rectangle rect, Point ref) {
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

  public OPPLinkMoveBendpointCommand newMoveBendpointCommand(OPPLink link, int index, Point p) {
    OPPLinkMoveBendpointCommand mbc = new OPPLinkMoveBendpointCommand();
    mbc.setLink(link);
    mbc.setIndex(index);
    mbc.setLocation(p);
    return mbc;
  }

  public OPPLinkCreateBendpointCommand newCreateBendpointCommand(OPPLink link, int index, Point p) {
    OPPLinkCreateBendpointCommand cbc = new OPPLinkCreateBendpointCommand();
    cbc.setLink(link);
    cbc.setIndex(index);
    cbc.setLocation(p);
    return cbc;
  }

  public OPPLinkDeleteBendpointCommand newDeleteBendpointCcommand(OPPLink link, int index) {
    OPPLinkDeleteBendpointCommand dbc = new OPPLinkDeleteBendpointCommand();
    dbc.setLink(link);
    dbc.setIndex(index);
    return dbc;
  }

  public Command getCommandToDeleteBendpoint(OPPStructuralLinkPart link, int index) {
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

  public Command getCommandToMoveInternalBendpoint(OPPStructuralLinkPart link, int index, Point newPoint) {
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

  public Command getCommanToMoveLastBendpointBeforeAggregator(OPPStructuralLinkPart link, int index, Point newPoint) {
    CompoundCommand cc = new CompoundCommand();
    List<OPPPoint> bendpoints = link.getBendpoints();
    Point targetPoint = pointFromOPPPoint(bendpoints.get(index + 1));

    if (newPoint.y > targetPoint.y - 5)
      return UnexecutableCommand.INSTANCE;

    if (Math.abs(newPoint.x - targetPoint.x) > 10)
      return UnexecutableCommand.INSTANCE;

    cc.add(newMoveBendpointCommand(link, index, newPoint.setX(targetPoint.x)));
    if (bendpoints.size() == 3) {
      if (isBetween(newPoint.y, top(link.getSource()), bottom(link.getSource()))) {
        cc.add(newMoveBendpointCommand(link, index - 1, pointFromOPPPoint(bendpoints.get(index - 1)).setY(newPoint.y)));
      } else {
        Point newEndPoint = getStructuralLinkEndpoint(link.getSource(), newPoint);
        cc.add(newMoveBendpointCommand(link, index - 1, newEndPoint));
        cc.add(newCreateBendpointCommand(link, index, new Point(middle(newPoint.x, newEndPoint.x), newEndPoint.y)));
        cc.add(newCreateBendpointCommand(link, index + 1, new Point(middle(newPoint.x, newEndPoint.x), newPoint.y)));
      }
    } else {
      cc.add(newMoveBendpointCommand(link, index - 1, pointFromOPPPoint(bendpoints.get(index - 1)).setY(newPoint.y)));
    }
    return cc;
  }

  public Command getCommandToMoveFirstBendpointAfterAggregator(OPPStructuralLinkPart link, Point newPoint) {
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

  public Command getCommandToMoveFirstBendpointAfterThing(OPPStructuralLinkPart link, Point newPoint) {
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

  public Command getCommantToMoveLastBendpointBeforeTarget(OPPStructuralLinkPart link, Point newPoint) {
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

  public Command getCommandToCreateBendpoint(OPPStructuralLinkPart link, int index, Point newPoint) {
    CompoundCommand cc = new CompoundCommand();
    Point prevPoint = pointFromOPPPoint(link.getBendpoints().get(index - 1));
    Point nextPoint = pointFromOPPPoint(link.getBendpoints().get(index));
    if (prevPoint.x == nextPoint.x) { // vertical line
      cc.add(newCreateBendpointCommand(link, index, (new Point()).setX(prevPoint.x).setY(middle(prevPoint.y, newPoint.y))));
      cc.add(newCreateBendpointCommand(link, index + 1, (new Point()).setX(newPoint.x).setY(middle(prevPoint.y, newPoint.y))));
      cc.add(newCreateBendpointCommand(link, index + 2, (new Point()).setX(newPoint.x).setY(middle(newPoint.y, nextPoint.y))));
      cc.add(newCreateBendpointCommand(link, index + 3, (new Point()).setX(nextPoint.x).setY(middle(newPoint.y, nextPoint.y))));
    } else { // horizontal line
      cc.add(newCreateBendpointCommand(link, index, (new Point()).setX(middle(prevPoint.x, newPoint.x)).setY(prevPoint.y)));
      cc.add(newCreateBendpointCommand(link, index + 1, (new Point()).setX(middle(prevPoint.x, newPoint.x)).setY(newPoint.y)));
      cc.add(newCreateBendpointCommand(link, index + 2, (new Point()).setX(middle(newPoint.x, nextPoint.x)).setY(newPoint.y)));
      cc.add(newCreateBendpointCommand(link, index + 3, (new Point()).setX(middle(newPoint.x, nextPoint.x)).setY(nextPoint.y)));
    }
    return cc;
  }

  public Command getCommandToMoveBendpointsAfterTargetHasMoved(OPPStructuralLinkPart link, Rectangle rect) {
    if (link.getTarget() instanceof OPPStructuralLinkAggregator)
      return getCommandToMoveBendpointsAfterTargetAggregatorHasMoved(link, rect);
    else
      return getCommandToMoveBendpointsAfterTargetThingHasMoved(link, rect);
  }

  private Command getCommandToMoveBendpointsAfterTargetThingHasMoved(OPPStructuralLinkPart link, Rectangle rect) {
    CompoundCommand cc = new CompoundCommand();
    List<OPPPoint> bendpoints = link.getBendpoints();
    Rectangle target = rectangleFromOPPNode(link.getTarget());
    Point currLastPoint = pointFromOPPPoint(bendpoints.get(bendpoints.size() - 2));
    Point newEndPoint = getStructuralLinkEndpoint(rect, currLastPoint);

    cc.add(newMoveBendpointCommand(link, bendpoints.size() - 1, newEndPoint));
    if (bendpoints.size() == 2) {
      if (!isBetween(currLastPoint.x, left(rect), right(rect))) {
        cc.add(newCreateBendpointCommand(link, bendpoints.size() - 1, new Point(currLastPoint.x, newEndPoint.y)));
      }
    } else {
      if (isAboveOrBelow(target, currLastPoint) && isAboveOrBelow(rect, currLastPoint)) {
        if (!isBetween(currLastPoint.x, left(rect), right(rect))) {
          cc.add(newMoveBendpointCommand(link, bendpoints.size() - 2, pointFromOPPPoint(bendpoints.get(bendpoints.size() - 2)).setX(newEndPoint.x)));
        }
      } else if (isLeftOrRight(target, currLastPoint) && isLeftOrRight(rect, currLastPoint)) {
        if (!isBetween(currLastPoint.y, top(rect), bottom(rect))) {
          cc.add(newMoveBendpointCommand(link, bendpoints.size() - 2, pointFromOPPPoint(bendpoints.get(bendpoints.size() - 2)).setY(newEndPoint.y)));
        }
      } else {
        cc.add(newDeleteBendpointCcommand(link, bendpoints.size() - 2));
      }
    }

    return cc;
  }

  private Command getCommandToMoveBendpointsAfterTargetAggregatorHasMoved(OPPStructuralLinkPart link, Rectangle rect) {
    CompoundCommand cc = new CompoundCommand();
    Point prevPoint = pointFromOPPPoint(link.getBendpoints().get(link.getBendpoints().size() - 2));
    cc.add(newMoveBendpointCommand(link, link.getBendpoints().size() - 1, new Point(rect.x + rect.width / 2, rect.y)));
    cc.add(newMoveBendpointCommand(link, link.getBendpoints().size() - 2, prevPoint.setX(rect.x + rect.width / 2)));
    if (link.getBendpoints().size() == 2) {
      if (!isBetween(middle(rect.x, rect.x + rect.width), left(link.getSource()), right(link.getSource()))) {
        cc.add(newCreateBendpointCommand(link, 0, getStructuralLinkEndpoint(link.getSource(), prevPoint)));
      }
    }
    return cc;
  }

  public Command getCommandToMoveBendpointsAfterSourceHasMoved(OPPStructuralLinkPart link, Rectangle rect) {
    if (link.getSource() instanceof OPPStructuralLinkAggregator)
      return getCommandToMoveBendpointsAfterSourceAggregatorHasMoved(link, rect);
    else
      return getCommandToMoveBendpointsAfterSourceThingHasMoved(link, rect);
  }

  private Command getCommandToMoveBendpointsAfterSourceThingHasMoved(OPPStructuralLinkPart link, Rectangle rect) {
    CompoundCommand cc = new CompoundCommand();
    List<OPPPoint> bendpoints = link.getBendpoints();
    Rectangle source = rectangleFromOPPNode(link.getSource());
    Point currFirstPoint = pointFromOPPPoint(bendpoints.get(1));
    Point newEndPoint = getStructuralLinkEndpoint(rect, currFirstPoint);

    cc.add(newMoveBendpointCommand(link, 0, newEndPoint));
    if (bendpoints.size() == 2) {
      if (!isBetween(currFirstPoint.x, left(rect), right(rect))) {
        cc.add(newCreateBendpointCommand(link, 1, new Point(currFirstPoint.x, newEndPoint.y)));
      }
    } else {
      if (isAboveOrBelow(source, currFirstPoint) && isAboveOrBelow(rect, currFirstPoint)) {
        if (!isBetween(currFirstPoint.x, left(rect), right(rect))) {
          cc.add(newMoveBendpointCommand(link, 1, pointFromOPPPoint(bendpoints.get(1)).setX(newEndPoint.x)));
        }
      } else if (isLeftOrRight(source, currFirstPoint) && isLeftOrRight(rect, currFirstPoint)) {
        if (!isBetween(currFirstPoint.y, top(rect), bottom(rect))) {
          cc.add(newMoveBendpointCommand(link, 1, pointFromOPPPoint(bendpoints.get(1)).setY(newEndPoint.y)));
        }
      } else {
        cc.add(newDeleteBendpointCcommand(link, 1));
      }
    }

    return cc;
  }

  private Command getCommandToMoveBendpointsAfterSourceAggregatorHasMoved(OPPStructuralLinkPart link, Rectangle rect) {
    CompoundCommand cc = new CompoundCommand();
    Point nextPoint = pointFromOPPPoint(link.getBendpoints().get(1));
    cc.add(newMoveBendpointCommand(link, 0, new Point(rect.x + rect.width / 2, rect.y + rect.height)));
    cc.add(newMoveBendpointCommand(link, 1, nextPoint.setX(rect.x + rect.width / 2)));
    if (link.getBendpoints().size() == 2) {
      if (!isBetween(middle(rect.x, rect.x + rect.height), left(link.getTarget()), right(link.getTarget()))) {
        cc.add(newCreateBendpointCommand(link, 2, getStructuralLinkEndpoint(link.getTarget(), nextPoint)));
      }
    }
    return cc;
  }

  public boolean isFirstBendpoint(int index) {
    return index == 1;
  }

  public boolean isLastBendpoint(int index, List<OPPPoint> bendpoints) {
    return index == bendpoints.size() - 2;
  }

}
