/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.figure;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

public class OPPProceduralLinkSubKindLocator extends ConnectionLocator {
  private final int xOffset;
  private final int yOffset;

  /**
   * Create a new {@link OPPProceduralLinkSubKindLocator} for the given
   * connection, located at <code>xOffset, yOffset</code> from the target of the
   * link.
   * 
   * @param connection
   *          the connection in which the decorator is based.
   * @param xOffset
   *          offset of the located figure in the x axis.
   * @param yOffset
   *          offset of the located figure in the y axis.
   */
  public OPPProceduralLinkSubKindLocator(Connection connection, int xOffset, int yOffset) {
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
