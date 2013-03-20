/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class OPMObjectProcessDiagramFigure extends Figure {
  private final IFigure contentPane;

  public OPMObjectProcessDiagramFigure() {
    setLayoutManager(new BorderLayout());
    setBorder(new LineBorder(1));

    contentPane = new Figure();
    contentPane.setLayoutManager(new XYLayout());
    add(contentPane, BorderLayout.CENTER);

    Label label = new Label("Here should go the name of the OPD");
    label.setTextAlignment(PositionConstants.TOP);
    add(label, BorderLayout.TOP);
    label = new Label("Parameters");
    add(label, BorderLayout.LEFT);
    label = new Label("Results");
    label.setTextAlignment(PositionConstants.RIGHT);
    add(label, BorderLayout.RIGHT);

  }

  @Override
  public Rectangle getBounds() {
    Dimension d = getPreferredSize();
    return new Rectangle(0, 0, d.width, d.height);
  }

  public IFigure getContentPane() {
    return contentPane;
  }

  @Override
  public boolean isCoordinateSystem() {
    return true;
  }
}
