/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.swt.graphics.Image;

import com.vainolo.phd.opm.gef.editor.figure.CircleDecoration;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;

/**
 * An extension of a {@link OPMLinkEditPart} used for {@link OPMProceduralLink} instances. It add endpoint decorations
 * to the regular link figure.
 * 
 * @author vainolo
 * 
 */
public class OPMProceduralLinkEditPart extends OPMLinkEditPart {

  private Figure targetDecoration;
  private Label centerDecorationLabel;

  /**
   * Extend the connection created by {@link OPMLinkEditPart#createFigure()} by adding decorations depending on the
   * link kind. An agent link is decorated at the target with black filled {@link CircleDecoration}. An instrument
   * link is decorated at the target with a white filled {@link CircleDecoration}. A consumption or result link is
   * decorated at the target with a {@link PolylineDecoration} (which is an arrow). An effect link link is decorated
   * at the source and target with a {@link PolylineDecoration}.
   * 
   * @return a decorated {@link PolylineConnection} figure.
   */
  @Override
  protected PolylineConnection createFigure() {
    PolylineConnection connection = super.createFigure();
    OPMProceduralLink model = (OPMProceduralLink) getModel();
    decorateConnection(connection, model.getKind());
    centerDecorationLabel = new Label();
    // targetDecorationLabel = new Label();
    ConnectionLocator locator = new ConnectionLocator(connection, ConnectionLocator.SOURCE);
    locator = new ConnectionLocator(connection, ConnectionLocator.MIDDLE);
    connection.add(centerDecorationLabel, locator);

    return connection;
  }

  @Override
  protected void refreshVisuals() {
    OPMProceduralLink model = (OPMProceduralLink) getModel();
    centerDecorationLabel.setText(model.getCenterDecoration());
    if(targetDecoration != null) {
      targetDecoration.revalidate();
    }
    super.refreshVisuals();
  }

  /**
   * Decorate a connection depending on its kind.
   * 
   * @param connection
   *          the {@link PolylineConnection} to decorate.
   * @param kind
   *          the {@link OPMProceduralLinkKind} of the model entity.
   */
  private void decorateConnection(PolylineConnection connection, OPMProceduralLinkKind kind) {
    switch(kind) {
      case AGENT:
        CircleDecoration agentDecoration = new CircleDecoration();
        agentDecoration.setBackgroundColor(ColorConstants.black);
        agentDecoration.setFill(true);
        connection.setTargetDecoration(agentDecoration);
        break;
      case INSTRUMENT:
      case INSTRUMENT_CONDITION:
      case INSTRUMENT_EVENT:
        CircleDecoration instrumentDecoration = new CircleDecoration();
        instrumentDecoration.setBackgroundColor(ColorConstants.white);
        instrumentDecoration.setFill(true);
        connection.setTargetDecoration(instrumentDecoration);
        break;
      case CONSUMPTION:
      case CONSUMPTION_CONDITION:
      case CONSUMPTION_EVENT:
      case RESULT:
      case INVOCATION:
        connection.setTargetDecoration(new PolylineDecoration());
        break;
      case EFFECT:
        connection.setSourceDecoration(new PolylineDecoration());
        connection.setTargetDecoration(new PolylineDecoration());
        break;
      default:
        throw new IllegalArgumentException("No case for kind " + kind);
    }

    if(isEvent(kind) || isCondition(kind)) {
      ConnectionLocator locator = new ConnectionLocator(connection, ConnectionLocator.TARGET);
      locator.setRelativePosition(PositionConstants.WEST);
      locator.setGap(10);
      if(isEvent(kind)) {
        targetDecoration =
            new ImageFigure(new Image(null, this.getClass().getResourceAsStream("../icons/lightning.png")));
      } else if(isCondition(kind)) {
        targetDecoration =
            new ImageFigure(new Image(null, this.getClass().getResourceAsStream("../icons/question.png")));
      }

      connection.add(targetDecoration, locator);
    }

    // PolylineShape shape = new PolylineShape();
    // shape.addPoint(new Point(0, 0));
    // shape.addPoint(new Point(10, 10));
    // shape.setBounds(new Rectangle(0, 0, 10, 10));
    // connection.add(shape, new ConnectionPointLocator(connection, 0.3));
  }

  private boolean isEvent(OPMProceduralLinkKind kind) {
    return kind == OPMProceduralLinkKind.CONSUMPTION_EVENT || kind == OPMProceduralLinkKind.INSTRUMENT_EVENT ||
        kind == OPMProceduralLinkKind.INVOCATION;
  }

  private boolean isCondition(OPMProceduralLinkKind kind) {
    return kind == OPMProceduralLinkKind.CONSUMPTION_CONDITION || kind == OPMProceduralLinkKind.INSTRUMENT_CONDITION;
  }

  // public class ConnectionPointLocator extends ConnectionLocator {
  //
  // private double section;
  //
  // public ConnectionPointLocator(Connection connection, double section) {
  // super(connection);
  // this.section = section;
  // }
  //
  // @Override
  // protected Point getReferencePoint() {
  // PointList points = getConnection().getPoints();
  // double totalLenght = 0;
  // for(int i = 0; i < points.size() - 1; i++) {
  // totalLenght += points.getPoint(i).getDistance(points.getPoint(i + 1));
  // }
  //
  // Point fp = getConnection().getPoints().getFirstPoint();
  // Point lp = getConnection().getPoints().getLastPoint();
  // Point p = new Point(((fp.x + lp.x) / 2), ((fp.y + lp.y) / 2));
  // getConnection().translateToAbsolute(p);
  // return p;
  // }
  // }
}
