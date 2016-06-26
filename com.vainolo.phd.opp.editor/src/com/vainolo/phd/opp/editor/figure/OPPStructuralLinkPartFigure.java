/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.figure;

import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.PolylineConnection;

public class OPPStructuralLinkPartFigure extends PolylineConnection {

  public OPPStructuralLinkPartFigure() {
    // setConnectionRouter(new ManhattanConnectionRouter());
    setConnectionRouter(new BendpointConnectionRouter());
    setLineWidth(OPPFigureConstants.CONNECTION_LINE_WIDTH);

    setTolerance(10);
  }

}
