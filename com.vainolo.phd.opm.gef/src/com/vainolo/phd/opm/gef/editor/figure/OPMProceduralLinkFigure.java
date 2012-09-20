/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

import com.vainolo.phd.opm.model.OPMProceduralLinkKind;

public class OPMProceduralLinkFigure extends PolylineConnection {
  private static final PolylineDecoration arrow = new PolylineDecoration();
  private OPMProceduralLinkKind kind;

  public OPMProceduralLinkFigure(OPMProceduralLinkKind kind) {
    this.kind = kind;
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
      case INVOCATION:
        arrow.setLocation(target);
        arrow.setReferencePoint(pointBeforeTarget);
        g.drawPolyline(arrow.getPoints());
        break;
      case INSTRUMENT:
      case INSTRUMENT_CONDITION:
      case INSTRUMENT_EVENT:
        int radius = OPMFigureConstants.agentCircleRadius;
        g.pushState();
        g.setBackgroundColor(ColorConstants.black);
        g.fillOval(target.x() - radius, target.y() - radius, radius * 2, radius * 2);
        g.setBackgroundColor(ColorConstants.white);
        g.fillOval(target.x() - (radius - 2), target.y() - (radius - 2), (radius - 2) * 2, (radius - 2) * 2);
        g.popState();
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
  }

  @Override
  public Rectangle getBounds() {
    if(bounds == null) {
      bounds = super.getBounds();
      bounds.expand(30, 30);
    }
    return bounds;
  }
}
