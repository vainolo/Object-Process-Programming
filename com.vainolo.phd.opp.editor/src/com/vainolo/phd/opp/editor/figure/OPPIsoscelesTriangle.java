/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Orientable;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * A triangle that uses all of its bounds to draw an isosceles triangle in the figure's bounds, like this:
 * 
 * <pre>
 *      ______
 *     |  /\  |
 *     | /  \ | (bounds shown as surrounding rectangle). 
 *     |/____\|
 * 
 * </pre>
 * 
 * The implementation is based on the {@link org.eclipse.draw2d.Triangle} implementation.
 * 
 * @author vainolo
 * 
 */
public final class OPPIsoscelesTriangle extends Shape implements Orientable {
  protected PointList triangle = new PointList(3);
  protected int direction = NORTH;

  @Override
  public void primTranslate(int dx, int dy) {
    super.primTranslate(dx, dy);
    triangle.translate(dx, dy);
  }

  @Override
  protected void outlineShape(Graphics graphics) {
    graphics.pushState();
    graphics.setLineWidth(2);
    graphics.drawPolygon(triangle);
    graphics.popState();
  }

  @Override
  protected void fillShape(Graphics graphics) {
    graphics.fillPolygon(triangle);
  }

  @Override
  public void validate() {
    super.validate();
    Rectangle r = getBounds().getCopy();
    r.shrink(getInsets());
    r.resize(-1, -1);
    Point p1 = null, p2 = null, p3 = null;
    switch (direction) {
    case NORTH:
      p1 = new Point(r.x + r.width / 2, r.y);
      p2 = new Point(r.x, r.y + r.height);
      p3 = new Point(r.x + r.width, r.y + r.height);
      break;
    case SOUTH:
      p1 = new Point(r.x + r.width / 2, r.y + r.height);
      p2 = new Point(r.x, r.y);
      p3 = new Point(r.x + r.width, r.y);
      break;
    case EAST:
      p1 = new Point(r.x, r.y);
      p2 = new Point(r.x + r.width, r.y + r.height / 2);
      p3 = new Point(r.x, r.y + r.height);
      break;
    case WEST:
      p1 = new Point(r.x + r.width, r.y);
      p2 = new Point(r.x + r.width, r.y + r.height);
      p3 = new Point(r.x, r.y + r.height / 2);
    }
    triangle.removeAllPoints();
    triangle.addPoint(p1);
    triangle.addPoint(p2);
    triangle.addPoint(p3);
  }

  /**
   * This functions is ignored. Use {@link OPPIsoscelesTriangle#setDirection(int)} instead.
   */
  @Override
  @Deprecated
  public void setOrientation(final int orientation) {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setDirection(final int direction) {
    if (direction != NORTH && direction != SOUTH && direction != EAST && direction != WEST) {
      throw new IllegalArgumentException("Invalid direction " + direction);
    }
    this.direction = direction;
    revalidate();
    repaint();
  }
}
