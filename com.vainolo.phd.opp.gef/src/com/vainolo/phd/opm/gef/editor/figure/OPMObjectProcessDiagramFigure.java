/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.*;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class OPMObjectProcessDiagramFigure extends Figure {

  private Label opdNameLabel;

  public OPMObjectProcessDiagramFigure() {
    setLayoutManager(new XYLayout());
    opdNameLabel = new Label();
    add(opdNameLabel);
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    super.paintFigure(graphics);
    Rectangle r = getParent().getBounds();
    setConstraint(opdNameLabel, new Rectangle(0, 0, r.width, 30));
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

  public void setOPDName(String name) {
    opdNameLabel.setText(name);
  }
}
