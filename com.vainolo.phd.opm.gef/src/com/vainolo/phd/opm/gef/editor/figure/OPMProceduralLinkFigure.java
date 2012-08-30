/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

import com.vainolo.phd.opm.model.OPMProceduralLinkKind;

public class OPMProceduralLinkFigure extends PolylineConnection {
  private static final PolylineDecoration arrow = new PolylineDecoration();
  private static final PolylineDecoration invertedArrow = new PolylineDecoration();
  private static final PolylineDecoration instrument = new PolylineDecoration();

  private static final int MIN_DECORATION_INTERVAL = 30;
  // private static final int SCALE = 4;

  private OPMProceduralLinkKind kind;
  private PolylineDecoration decoration;

  static {
    // arrow.setScale(SCALE, SCALE);

    // invertedArrow.setScale(SCALE, SCALE);
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
    PointList points = getPoints();

    Point source = points.getFirstPoint();
    Point pointAfterSource = points.getPoint(1);
    Point target = points.getLastPoint();
    Point pointBeforeTarget = points.getPoint(points.size() - 2);

    switch(kind) {
      case CONSUMPTION:
      case CONSUMPTION_CONDITION:
      case CONSUMPTION_EVENT:
      case RESULT:
      case EFFECT:
      case EFFECT_CONDITION:
      case EFFECT_EVENT:
        arrow.setLocation(target);
        arrow.setReferencePoint(pointBeforeTarget);
        g.drawPolyline(arrow.getPoints());
        break;
      case INSTRUMENT:
      case INSTRUMENT_CONDITION:
      case INSTRUMENT_EVENT:
        g.drawOval(target.x() - 5, target.y() - 5, 10, 10);
        g.fillOval(target.x() - 4, target.y() - 4, 8, 8);
        break;
    }

    switch(kind) {
      case EFFECT:
      case EFFECT_CONDITION:
      case EFFECT_EVENT:
        arrow.setLocation(source);
        arrow.setReferencePoint(pointAfterSource);
        g.drawPolyline(arrow.getPoints());
        break;
    }

    switch(kind) {
      case INSTRUMENT_CONDITION:
      case CONSUMPTION_CONDITION:
      case EFFECT_CONDITION:
        if(pointBeforeTarget.x() < target.x())
          g.drawText("c", target.x() - 20, target.y() - 20);
        else
          g.drawText("c", target.x() + 20, target.y() - 20);
        break;
    }

    switch(kind) {
      case INSTRUMENT_EVENT:
      case CONSUMPTION_EVENT:
      case EFFECT_EVENT:
        if(pointBeforeTarget.x() < target.x())
          g.drawText("e", target.x() - 20, target.y() - 20);
        else
          g.drawText("e", target.x() + 20, target.y() - 20);
    }
    // g.pushState();
    // drawDecorations(g);
    // g.popState();
  }

  // private void drawDecorations(Graphics g) {
  // Point p1, p2;
  // for(int i = 0; i < getPoints().size() - 1; i++) {
  // p1 = getPoints().getPoint(i);
  // p2 = getPoints().getPoint(i + 1);
  //
  // // switch(kind) {
  // // case CONSUMPTION:
  // // case CONSUMPTION_CONDITION:
  // // case CONSUMPTION_EVENT:
  // // case RESULT:
  // // case INSTRUMENT:
  // // case INSTRUMENT_CONDITION:
  // // case INSTRUMENT_EVENT:
  // // drawDecorationsBetweenPoints(p1, p2, g);
  // // }
  // }
  //
  // }
  //
  // private void drawDecorationsBetweenPoints(Point p1, Point p2, Graphics g) {
  // if(p1.getDistance(p2) < MIN_DECORATION_INTERVAL)
  // return;
  //
  // Dimension difference = p2.getDifference(p1);
  // Point center = p1.getCopy().getTranslated(difference.width() / 2, difference.height() / 2);
  // decoration.setLocation(center);
  // decoration.setReferencePoint(p1);
  // // for an inverted line the reference point has to be changed: decoration.setReferencePoint(p2);
  // // the decoration should also be an inverted arrow.
  // // g.setForegroundColor(ColorConstants.red);
  // g.drawPolyline(decoration.getPoints());
  //
  // drawDecorationsBetweenPoints(p1, center, g);
  // drawDecorationsBetweenPoints(center, p2, g);
  // }

  @Override
  public Rectangle getBounds() {
    if(bounds == null) {
      bounds = super.getBounds();
      bounds.expand(30, 30);
    }
    return bounds;
  }
}
