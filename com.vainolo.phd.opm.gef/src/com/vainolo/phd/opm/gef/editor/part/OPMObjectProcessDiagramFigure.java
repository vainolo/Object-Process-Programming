/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
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
    setBackgroundColor(ColorConstants.gray);
    setOpaque(true);

    contentPane = new Figure();
    contentPane.setLayoutManager(new XYLayout());
    add(contentPane, BorderLayout.CENTER);

    Label label = new Label("This is an OPD");
    label.setTextAlignment(PositionConstants.TOP);
    add(label, BorderLayout.TOP);
    label = new Label("These are the parameters");
    label.setTextAlignment(PositionConstants.LEFT);
    add(label, BorderLayout.LEFT);
    label = new Label("These are the results");
    label.setTextAlignment(PositionConstants.RIGHT);
    add(label, BorderLayout.RIGHT);

  }

  @Override
  public Dimension getPreferredSize(int wHint, int hHint) {
    return new Dimension(400, 400);
  }

  @Override
  public Rectangle getBounds() {
    return new Rectangle(0, 0, 800, 800);
  }

  public IFigure getContentPane() {
    return contentPane;
  }

  @Override
  public boolean isCoordinateSystem() {
    return true;
  }
}
