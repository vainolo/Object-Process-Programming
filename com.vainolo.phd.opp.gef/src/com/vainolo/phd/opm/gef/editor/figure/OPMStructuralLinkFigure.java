package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.PolylineConnection;

public class OPMStructuralLinkFigure extends PolylineConnection {

  public OPMStructuralLinkFigure() {
    setConnectionRouter(new ManhattanConnectionRouter());
    setLineWidth(OPMFigureConstants.CONNECTION_LINE_WIDTH);
  }

}
