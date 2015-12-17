package com.vainolo.phd.opp.editor.figure;

import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.PolylineConnection;

public class OPPStructuralLinkFigure extends PolylineConnection {

  public OPPStructuralLinkFigure() {
    // setConnectionRouter(new ManhattanConnectionRouter());
    setConnectionRouter(new BendpointConnectionRouter());
    setLineWidth(OPPFigureConstants.CONNECTION_LINE_WIDTH);
  }

}
