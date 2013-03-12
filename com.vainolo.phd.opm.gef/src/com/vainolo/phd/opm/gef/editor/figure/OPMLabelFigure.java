/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

import com.vainolo.draw2d.extras.SmartLabelFigure;

public class OPMLabelFigure extends Figure implements OPMNamedElementFigure {

  private final SmartLabelFigure smartLabel;

  public OPMLabelFigure() {
    setLayoutManager(new XYLayout());
    smartLabel = new SmartLabelFigure(OPMFigureConstants.TEXT_WIDTH_TO_HEIGHT_RATIO);
    smartLabel.setForegroundColor(OPMFigureConstants.LABEL_COLOR);
    add(smartLabel);
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    super.paintFigure(graphics);
    Rectangle r = getBounds().getCopy();
    r.setX(0);
    r.setY(0);
    setConstraint(smartLabel, r);
  }

  @Override
  public SmartLabelFigure getNameFigure() {
    return smartLabel;
  }
}
