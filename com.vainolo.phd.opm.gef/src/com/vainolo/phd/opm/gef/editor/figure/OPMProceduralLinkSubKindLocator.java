package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

public class OPMProceduralLinkSubKindLocator extends ConnectionLocator {
  private final int xOffset;
  private final int yOffset;

  public OPMProceduralLinkSubKindLocator(Connection connection, int xOffset, int yOffset) {
    super(connection, ConnectionLocator.TARGET);
    this.xOffset = xOffset;
    this.yOffset = yOffset;
  }

  @Override
  protected Point getLocation(PointList points) {
    Point targetLocation = super.getLocation(points);
    Point referencePoint = points.getPoint(points.size() - 2);

    Point newLocation = new Point();
    newLocation.x = (targetLocation.x >= referencePoint.x ? targetLocation.x - xOffset : targetLocation.x + xOffset);
    newLocation.y = (targetLocation.y >= referencePoint.y ? targetLocation.y - yOffset : targetLocation.y + yOffset);

    return newLocation;
  }
}
