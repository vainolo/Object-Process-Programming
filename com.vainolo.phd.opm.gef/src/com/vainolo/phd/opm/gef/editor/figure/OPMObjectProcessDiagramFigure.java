/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class OPMObjectProcessDiagramFigure extends Figure {

  public OPMObjectProcessDiagramFigure() {
	  setLayoutManager(new XYLayout());
  }

  @Override
  public Rectangle getBounds() {
    Dimension d = getPreferredSize();
    return new Rectangle(0, 0, d.width, d.height);
  }

  public IFigure getContentPane() {
	  return this;
  }

  @Override
  public boolean isCoordinateSystem() {
    return true;
  }
}
