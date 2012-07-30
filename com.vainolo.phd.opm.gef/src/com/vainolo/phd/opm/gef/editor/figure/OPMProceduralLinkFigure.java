/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

import com.vainolo.phd.opm.model.OPMProceduralLinkKind;

public class OPMProceduralLinkFigure extends PolylineConnection {
  private static final PolylineDecoration arrow = new PolylineDecoration();
  private static final PolylineDecoration invertedArrow = new PolylineDecoration();
  private static final PolylineDecoration instrument = new PolylineDecoration();

  private static final int MIN_DECORATION_INTERVAL = 30;
  private static final int SCALE = 4;

  private OPMProceduralLinkKind kind;
  private PolylineDecoration decoration;

  static {
    arrow.setScale(SCALE, SCALE);

    invertedArrow.setScale(SCALE, SCALE);
    invertedArrow.setRotation(Math.PI);

    PointList instrumentPoints = new PointList();
    instrumentPoints.addPoint(-8, 4);
    instrumentPoints.addPoint(-3, -1);
    instrumentPoints.addPoint(-3, -4);
    instrumentPoints.addPoint(-2, -4);
    instrumentPoints.addPoint(-3, -4);
    instrumentPoints.addPoint(-3, -1);
    instrumentPoints.addPoint(0, -1);
    instrumentPoints.addPoint(0, -2);
    instrument.setTemplate(instrumentPoints);
    instrument.setScale(2, 2);
  }

  public OPMProceduralLinkFigure(OPMProceduralLinkKind kind) {
    this.kind = kind;

    switch(kind) {
      case CONSUMPTION:
      case CONSUMPTION_CONDITION:
      case CONSUMPTION_EVENT:
      case RESULT:
        decoration = arrow;
        break;
      case INSTRUMENT:
      case INSTRUMENT_CONDITION:
      case INSTRUMENT_EVENT:
        decoration = instrument;
        break;
    }
  }

  @Override
  protected void outlineShape(Graphics g) {
    g.drawPolyline(getPoints());
    g.pushState();
    drawDecorations(g);
    g.popState();
  }

  private void drawDecorations(Graphics g) {
    Point p1, p2;
    for(int i = 0; i < getPoints().size() - 1; i++) {
      p1 = getPoints().getPoint(i);
      p2 = getPoints().getPoint(i + 1);

      switch(kind) {
        case CONSUMPTION:
        case CONSUMPTION_CONDITION:
        case CONSUMPTION_EVENT:
        case RESULT:
        case INSTRUMENT:
        case INSTRUMENT_CONDITION:
        case INSTRUMENT_EVENT:
          drawDecorationsBetweenPoints(p1, p2, g);
      }
    }

  }

  private void drawDecorationsBetweenPoints(Point p1, Point p2, Graphics g) {
    if(p1.getDistance(p2) < MIN_DECORATION_INTERVAL)
      return;

    Dimension difference = p2.getDifference(p1);
    Point center = p1.getCopy().getTranslated(difference.width() / 2, difference.height() / 2);
    decoration.setLocation(center);
    decoration.setReferencePoint(p1);
    // for an inverted line the reference point has to be changed: decoration.setReferencePoint(p2);
    // the decoration should also be an inverted arrow.
    // g.setForegroundColor(ColorConstants.red);
    g.drawPolyline(decoration.getPoints());

    drawDecorationsBetweenPoints(p1, center, g);
    drawDecorationsBetweenPoints(center, p2, g);
  }

  @Override
  public Rectangle getBounds() {
    bounds = super.getBounds();
    bounds.expand(SCALE, SCALE);
    return bounds;
  }
}
