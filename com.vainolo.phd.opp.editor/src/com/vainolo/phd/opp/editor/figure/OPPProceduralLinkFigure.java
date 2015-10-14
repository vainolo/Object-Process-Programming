/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.figure;

import org.eclipse.draw2d.*;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

import com.vainolo.phd.opp.model.OPPProceduralLinkKind;

public class OPPProceduralLinkFigure extends PolylineConnection implements OPPNamedElementFigure {
  private static final PolylineDecoration arrow = new PolylineDecoration();
  private final OPPProceduralLinkKind kind;
  private final SmartLabelFigure centerDecorationLabel;
  private final Label subKinds;

  // private final OPMProceduralLinkDecorator decorator;

  public OPPProceduralLinkFigure(OPPProceduralLinkKind kind) {
    this.kind = kind;
    arrow.setScale(10, 5);

    setAntialias(SWT.ON);
    setLineWidth(OPPFigureConstants.CONNECTION_LINE_WIDTH);
    centerDecorationLabel = new SmartLabelFigure(-1);
    centerDecorationLabel.setBackgroundColor(ColorConstants.white);
    centerDecorationLabel.setOpaque(true);
    ConnectionLocator locator = new ConnectionLocator(this, ConnectionLocator.MIDDLE);
    add(centerDecorationLabel, locator);

    setConnectionRouter(new BendpointConnectionRouter());

    subKinds = new Label("");
    subKinds.setBackgroundColor(ColorConstants.white);
    subKinds.setOpaque(true);
    add(subKinds, new OPPProceduralLinkSubKindLocator(this, 15, 15));

    // decorator = new OPMProceduralLinkDecorator();
    // decorator.setText("a");
    // add(decorator, new OPMProceduralLinkSubKindLocator(this, 10, 10));
  }

  public SmartLabelFigure getCenterDecorationLabel() {
    return centerDecorationLabel;
  }

  public void setSubKindLabelText(String text) {
    subKinds.setText(text);
    // if (text == null || "".equals(text)) {
    // decorator.setVisible(false);
    // } else {
    // decorator.setVisible(true);
    // decorator.setText(text);
    // }
  }

  @Override
  protected void outlineShape(Graphics g) {
    g.drawPolyline(getPoints());
    PointList points = getPoints();

    Point target = points.getLastPoint();
    Point pointBeforeTarget = points.getPoint(points.size() - 2);

    switch (kind) {
    case CONS_RES:
      arrow.setLocation(target);
      arrow.setReferencePoint(pointBeforeTarget);
      g.drawPolyline(arrow.getPoints());
      break;
    case AGENT:
    case INSTRUMENT:
      int radius = OPPFigureConstants.AGENT_CIRCLE_RATIO;
      g.pushState();
      g.setBackgroundColor(ColorConstants.black);
      g.fillOval(target.x() - radius, target.y() - radius, radius * 2, radius * 2);
      if (kind == OPPProceduralLinkKind.INSTRUMENT) {
        g.setBackgroundColor(ColorConstants.white);
        g.fillOval(target.x() - (radius - 2), target.y() - (radius - 2), (radius - 2) * 2, (radius - 2) * 2);
      }
      g.popState();
      break;
    }
  }

  @Override
  public Rectangle getBounds() {
    if (bounds == null) {
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

  public class OPMProceduralLinkDecorator extends Figure {
    Label subKind;

    public OPMProceduralLinkDecorator() {
      super();
      setLayoutManager(new StackLayout());
      setAntialias(SWT.ON);

      Ellipse e = new Ellipse();
      e.setSize(15, 15);
      add(e);
      subKind = new Label();
      add(subKind);
    }

    public void setText(String text) {
      subKind.setText(text);
    }
  }
}
