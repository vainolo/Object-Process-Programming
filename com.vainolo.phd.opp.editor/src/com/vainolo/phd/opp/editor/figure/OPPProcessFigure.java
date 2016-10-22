/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.figure;

import org.eclipse.draw2d.*;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

public class OPPProcessFigure extends OPPThingFigure implements OPPNamedElementFigure {
  private final Ellipse ellipse;
  private final Ellipse shade1;
  private final IFigure contentPane;
  private ConnectionAnchor connectionAnchor;
  private final SmartLabelFigure nameLabel;
  private boolean hasShadow = false;

  public OPPProcessFigure() {
    ellipse = createEllipseFigure();
    ellipse.setLayoutManager(new XYLayout());
    nameLabel = new SmartLabelFigure(OPPFigureConstants.TEXT_WIDTH_TO_HEIGHT_RATIO);
    nameLabel.setForegroundColor(OPPFigureConstants.LABEL_COLOR);
    ellipse.add(nameLabel);

    contentPane = new Figure();
    contentPane.setLayoutManager(new XYLayout());
    ellipse.add(contentPane);

    shade1 = createEllipseFigure();
    shade1.setBackgroundColor(ColorConstants.gray);
    shade1.setFill(true);
    add(shade1);
    add(ellipse);
  }

  private Ellipse createEllipseFigure() {
    Ellipse e = new Ellipse();
    e.setAntialias(SWT.ON);
    e.setForegroundColor(OPPFigureConstants.PROCESS_COLOR);
    e.setLineWidth(OPPFigureConstants.ENTITY_BORDER_WIDTH);
    return e;
  }

  @Override
  public IFigure getContentPane() {
    return contentPane;
  }

  public void setBorderWidth(int width) {
    ellipse.setLineWidth(width);
  }

  private void paintProcess(Rectangle r) {
    shade1.setVisible(false);
    setConstraint(ellipse, new Rectangle(0, 0, r.width(), r.height()));
    setConstraint(shade1, new Rectangle(0, 0, r.width(), r.height()));
    Dimension labelSize = nameLabel.getSize();
    int w = (r.width() - labelSize.width) / 2;
    int h = (r.height() - labelSize.height) / 2;
    // ellipse.setConstraint(nameLabel, new Rectangle(w, h, labelSize.width, labelSize.height));
    ellipse.setConstraint(nameLabel, calculateInnerRectangle(r.width(), r.height()));
    ellipse.setConstraint(contentPane, new Rectangle(0, 0, r.width(), r.height()));
  }

  private void paintProcessWithShadow(Rectangle r) {
    shade1.setVisible(true);
    setConstraint(ellipse, new Rectangle(0, 0, r.width() - 5, r.height() - 5));
    setConstraint(shade1, new Rectangle(5, 5, r.width() - 5, r.height() - 5));
    ellipse.setConstraint(nameLabel, calculateInnerRectangle(r.width() - 5, r.height() - 10));
    ellipse.setConstraint(contentPane, new Rectangle(0, 0, r.width() - 5, r.height() - 10));
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    super.paintFigure(graphics);
    Rectangle r = getBounds().getCopy();
    if (hasShadow)
      paintProcessWithShadow(r);
    else
      paintProcess(r);
  }

  private Rectangle calculateInnerRectangle(int width, int heigth) {
    Rectangle rect = new Rectangle();
    rect.setWidth((int) (Math.sqrt(2) * width / 2));
    rect.setHeight((int) (Math.sqrt(2) * heigth / 2));
    rect.setX(width / 2 - rect.width() / 2);
    rect.setY(heigth / 2 - rect.height() / 2);
    return rect;
  }

  private Dimension calculateEllipseDimensionBasedOnLabelSize(Dimension labelDim) {
    Dimension dim = new Dimension();
    dim.setWidth((int) (2 * labelDim.width() / Math.sqrt(2)) + 5);
    dim.setHeight((int) (2 * labelDim.height() / Math.sqrt(2)) + 10);
    return dim;
  }

  private ConnectionAnchor getConnectionAnchor() {
    if (connectionAnchor == null) {
      connectionAnchor = new OPPEllipseStructuralLinkAnchor(this);
    }
    return connectionAnchor;
  }

  @Override
  public Dimension getPreferredSize(int wHint, int hHint) {
    Dimension smartLabelSize = nameLabel.calculateSize();
    return calculateEllipseDimensionBasedOnLabelSize(smartLabelSize).expand(10, 5);
  }

  @Override
  public SmartLabelFigure getNameFigure() {
    return nameLabel;
  }

  public void setHasShadow(boolean hasShadow) {
    this.hasShadow = hasShadow;
  }

  @Override
  public boolean containsPoint(int x, int y) {
    if (!super.containsPoint(x, y)) {
      return false;
    } else {
      Rectangle r = getBounds();
      long ux = x - r.x - r.width / 2;
      long uy = y - r.y - r.height / 2;
      return ((ux * ux) << 10) / (r.width * r.width) + ((uy * uy) << 10) / (r.height * r.height) <= 256;
    }
  }

  @Override
  public void setBounds(Rectangle rect) {
    super.setBounds(rect);
  }

  public void setDashedBorder(boolean dashed) {
    if (dashed) {
      ellipse.setLineStyle(SWT.LINE_CUSTOM);
      ellipse.setLineDash(OPPFigureConstants.GLOBAL_OBJECT_DASH);
    } else {
      ellipse.setLineStyle(SWT.LINE_SOLID);
    }
  }
}
