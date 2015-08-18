package com.vainolo.phd.opp.editor.figure;

import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.PolylineConnection;

public class OPPStructuralLinkFigure extends PolylineConnection {

  public OPPStructuralLinkFigure() {
    setConnectionRouter(new ManhattanConnectionRouter());
    setLineWidth(OPPFigureConstants.CONNECTION_LINE_WIDTH);
  }

}
