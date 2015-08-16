/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.figure;

import org.eclipse.draw2d.*;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

public class OPMProcessFigure extends OPMThingFigure implements OPMNamedElementFigure {
  private final Ellipse ellipse;
  private final Ellipse shade1;
  private final Ellipse shade2;
  private final IFigure contentPane;
  private ConnectionAnchor connectionAnchor;
  private final SmartLabelFigure smartLabel;
  private boolean isMultiple = false;

  public OPMProcessFigure() {
    ellipse = createEllipseFigure();
    ellipse.setLayoutManager(new XYLayout());
    smartLabel = new SmartLabelFigure(OPMFigureConstants.TEXT_WIDTH_TO_HEIGHT_RATIO);
    smartLabel.setForegroundColor(OPMFigureConstants.LABEL_COLOR);
    smartLabel.setHorizontalAlignment(PositionConstants.CENTER);
    ellipse.add(smartLabel);

    contentPane = new Figure();
    contentPane.setLayoutManager(new XYLayout());
    ellipse.add(contentPane);

    shade2 = createEllipseFigure();
    add(shade2);
    shade1 = createEllipseFigure();
    add(shade1);
    add(ellipse);
  }

  private Ellipse createEllipseFigure() {
    Ellipse e = new Ellipse();
    e.setAntialias(SWT.ON);
    e.setForegroundColor(OPMFigureConstants.PROCESS_COLOR);
    e.setLineWidth(OPMFigureConstants.ENTITY_BORDER_WIDTH);
    return e;
  }

  @Override
  public IFigure getContentPane() {
    return contentPane;
  }

  private void paintSimpleProcess(Rectangle r) {
    setConstraint(ellipse, new Rectangle(0, 0, r.width(), r.height()));
    setConstraint(shade1, new Rectangle(0, 0, r.width(), r.height()));
    setConstraint(shade2, new Rectangle(0, 0, r.width(), r.height()));
    ellipse.setConstraint(smartLabel, calculateInnerRectangle(r.width(), r.height()));
    ellipse.setConstraint(contentPane, new Rectangle(0, 0, r.width(), r.height()));
  }

  private void paintMultipleProcess(Rectangle r) {
    setConstraint(ellipse, new Rectangle(0, 0, r.width() - 10, r.height() - 10));
    setConstraint(shade1, new Rectangle(5, 5, r.width() - 10, r.height() - 10));
    setConstraint(shade2, new Rectangle(10, 10, r.width() - 10, r.height() - 10));
    ellipse.setConstraint(smartLabel, calculateInnerRectangle(r.width() - 10, r.height() - 10));
    ellipse.setConstraint(contentPane, new Rectangle(0, 0, r.width() - 10, r.height() - 10));
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    super.paintFigure(graphics);
    Rectangle r = getBounds().getCopy();
    if(isMultiple)
      paintMultipleProcess(r);
    else
      paintSimpleProcess(r);
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
    dim.setWidth((int) (2 * labelDim.width() / Math.sqrt(2)) + 10);
    dim.setHeight((int) (2 * labelDim.height() / Math.sqrt(2)) + 10);
    return dim;
  }

  /**
   * Creates an {@link EllipseAnchor} on the figure.
   * 
   * @return an {@link EllipseAnchor} on the figure.
   */
  private ConnectionAnchor getConnectionAnchor() {
    if(connectionAnchor == null) {
      connectionAnchor = new EllipseAnchor(this);
    }
    return connectionAnchor;
  }

  @Override
  public ConnectionAnchor getSourceConnectionAnchor() {
    return getConnectionAnchor();
  }

  @Override
  public ConnectionAnchor getTargetConnectionAnchor() {
    return getConnectionAnchor();
  }

  public void setText(String text) {
    smartLabel.setText(text);
  }

  @Override
  public Dimension getPreferredSize(int wHint, int hHint) {
    Dimension smartLabelSize = smartLabel.calculateSize();
    return calculateEllipseDimensionBasedOnLabelSize(smartLabelSize);
  }

  @Override
  public SmartLabelFigure getNameFigure() {
    return smartLabel;
  }

  public void setMultiple(boolean multiple) {
    this.isMultiple = multiple;
  }

  @Override
  public boolean containsPoint(int x, int y) {
    Rectangle r = getBounds();
    long ux = x - r.x - r.width / 2;
    long uy = y - r.y - r.height / 2;
    return ((ux * ux) << 10) / (r.width * r.width) + ((uy * uy) << 10) / (r.height * r.height) <= 256;
  }

  @Override
  public void setBounds(Rectangle rect) {
    super.setBounds(rect);
  }

}
