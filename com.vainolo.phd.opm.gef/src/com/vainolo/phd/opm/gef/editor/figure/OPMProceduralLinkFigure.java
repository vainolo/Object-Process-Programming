/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.*;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

import com.vainolo.draw2d.extras.SmartLabelFigure;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;

public class OPMProceduralLinkFigure extends PolylineConnection implements OPMNamedElementFigure {
  private static final PolylineDecoration arrow = new PolylineDecoration();
  private OPMProceduralLinkKind kind;
  private final SmartLabelFigure centerDecorationLabel;
  private final Label subKinds;

  public OPMProceduralLinkFigure(OPMProceduralLinkKind kind) {
    this.kind = kind;

    setLineWidth(OPMFigureConstants.CONNECTION_LINE_WIDTH);
    centerDecorationLabel = new SmartLabelFigure(-1);
    ConnectionLocator locator = new ConnectionLocator(this, ConnectionLocator.MIDDLE);
    add(centerDecorationLabel, locator);
    setConnectionRouter(new BendpointConnectionRouter());
    subKinds = new Label("");
    add(subKinds, new OPMProceduralLinkSubKindLocator(this, 15, 15));
  }

  public SmartLabelFigure getCenterDecorationLabel() {
    return centerDecorationLabel;
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
    case RESULT:
    case EFFECT:
    case INVOCATION:
      arrow.setLocation(target);
      arrow.setReferencePoint(pointBeforeTarget);
      g.drawPolyline(arrow.getPoints());
      break;
    case INSTRUMENT:
    case AGENT:
      int radius = OPMFigureConstants.AGENT_CIRCLE_RATIO;
      g.pushState();
      g.setBackgroundColor(ColorConstants.black);
      g.fillOval(target.x() - radius, target.y() - radius, radius * 2, radius * 2);
      if(kind == OPMProceduralLinkKind.INSTRUMENT) {
        g.setBackgroundColor(ColorConstants.white);
        g.fillOval(target.x() - (radius - 2), target.y() - (radius - 2), (radius - 2) * 2, (radius - 2) * 2);
      }
      g.popState();
      break;
    }

    switch(kind) {
    case EFFECT:
      arrow.setLocation(source);
      arrow.setReferencePoint(pointAfterSource);
      g.drawPolyline(arrow.getPoints());
      break;
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

  @Override
  public SmartLabelFigure getNameFigure() {
    return centerDecorationLabel;
  }

  public Label getSubkindLabel() {
    return subKinds;
  }
}
