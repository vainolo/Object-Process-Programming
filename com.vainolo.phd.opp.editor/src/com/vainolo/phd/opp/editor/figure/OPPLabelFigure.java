/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.figure;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

public class OPPLabelFigure extends Figure implements OPPNamedElementFigure {

  private final SmartLabelFigure smartLabel;

  public OPPLabelFigure() {
    setLayoutManager(new XYLayout());
    smartLabel = new SmartLabelFigure(OPPFigureConstants.TEXT_WIDTH_TO_HEIGHT_RATIO);
    smartLabel.setForegroundColor(OPPFigureConstants.LABEL_COLOR);
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
