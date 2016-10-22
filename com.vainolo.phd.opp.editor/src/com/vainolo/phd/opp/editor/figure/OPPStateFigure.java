/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.figure;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

/**
 * A figure representing an OPM State. A state is represented by a rountangle (rounded rectangle).
 * 
 * @author vainolo
 * 
 */
public class OPPStateFigure extends Figure implements OPPNodeFigure, OPPNamedElementFigure {
  private final RoundedRectangle rectangle;
  private final RoundedRectangle innerRectangle;
  private ConnectionAnchor connectionAnchor;
  private final SmartLabelFigure smartLabel;
  private boolean valueState = false;

  public OPPStateFigure() {
    super();
    setLayoutManager(new XYLayout());
    smartLabel = new SmartLabelFigure(OPPFigureConstants.TEXT_WIDTH_TO_HEIGHT_RATIO);
    smartLabel.setForegroundColor(OPPFigureConstants.LABEL_COLOR);
    add(smartLabel);
    rectangle = new RoundedRectangle();
    rectangle.setAntialias(SWT.ON);
    rectangle.setCornerDimensions(new Dimension(20, 20));
    rectangle.setFill(false);
    rectangle.setForegroundColor(OPPFigureConstants.STATE_COLOR);
    rectangle.setLineWidth(OPPFigureConstants.ENTITY_BORDER_WIDTH);
    innerRectangle = new RoundedRectangle();
    innerRectangle.setCornerDimensions(new Dimension(20, 20));
    innerRectangle.setFill(false);
    innerRectangle.setForegroundColor(OPPFigureConstants.STATE_COLOR);
    innerRectangle.setLineWidth(OPPFigureConstants.ENTITY_BORDER_WIDTH);
    add(rectangle);
    add(innerRectangle);

  }

  public void setValueState(boolean valueState) {
    this.valueState = valueState;
  }

  @Override
  public Dimension getPreferredSize(int wHint, int hHint) {
    return smartLabel.calculateSize().expand(25, 15);
    // return dim.expand(15, 10);
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    Rectangle r = getBounds().getCopy();
    if (valueState) {
      rectangle.setLineStyle(SWT.LINE_DASH);
    } else {
      rectangle.setLineStyle(SWT.LINE_SOLID);
    }
    setConstraint(rectangle, new Rectangle(0, 0, r.width, r.height));
    setConstraint(innerRectangle, new Rectangle(3, 3, r.width - 6, r.height - 6));
    if (valueState) {
      innerRectangle.setVisible(true);
    } else {
      innerRectangle.setVisible(false);
    }
    setConstraint(smartLabel, new Rectangle(8, 5, r.width - 16, r.height - 10));
  }

  @Override
  public SmartLabelFigure getNameFigure() {
    return smartLabel;
  }
}
