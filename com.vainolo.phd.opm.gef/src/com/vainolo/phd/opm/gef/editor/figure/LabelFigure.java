/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.TextFlow;

public class LabelFigure extends Figure implements OPMNamedElementFigure {

  private final TextFlow textFlow;
  private final IFigure textFigure;

  public LabelFigure() {
    setLayoutManager(new XYLayout());
    textFlow = new TextFlow();
    textFlow.setForegroundColor(OPMFigureConstants.opmLabelColor);
    FlowPage flowPage = new FlowPage();
    flowPage.setHorizontalAligment(PositionConstants.CENTER);
    flowPage.add(textFlow);
    textFigure = flowPage;
    add(flowPage);
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    super.paintFigure(graphics);
    Rectangle r = getBounds().getCopy();
    r.setX(0);
    r.setY(0);
    setConstraint(textFigure, r);
  }

  @Override
  public Label getNameLabel() {
    return null;
  }

  public TextFlow getTextFlow() {
    return textFlow;
  }

  public IFigure getTextFigure() {
    return textFigure;
  }
}
