/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

import com.vainolo.draw2d.extras.SmartLabelFigure;
import com.vainolo.jdraw2d.HorizontalAlignment;

public class OPMProcessFigure extends OPMThingFigure implements OPMNamedElementFigure {
  private final Ellipse ellipse;
  private final IFigure contentPane;
  private ConnectionAnchor connectionAnchor;
  private final SmartLabelFigure smartLabel;

  public OPMProcessFigure() {
    ellipse = new Ellipse();
    ellipse.setAntialias(SWT.ON);
    ellipse.setLayoutManager(new XYLayout());
    ellipse.setForegroundColor(OPMFigureConstants.PROCESS_COLOR);
    ellipse.setLineWidth(OPMFigureConstants.ENTITY_BORDER_WIDTH);
    smartLabel = new SmartLabelFigure(OPMFigureConstants.TEXT_WIDTH_TO_HEIGHT_RATIO);
    smartLabel.setForegroundColor(OPMFigureConstants.LABEL_COLOR);
    smartLabel.setHorizontalAlignment(HorizontalAlignment.CENTER);
    ellipse.add(smartLabel);

    contentPane = new Figure();
    contentPane.setLayoutManager(new XYLayout());
    ellipse.add(contentPane);

    add(ellipse);
  }

  @Override
  public IFigure getContentPane() {
    return contentPane;
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    super.paintFigure(graphics);
    Rectangle r = getBounds().getCopy();
    setConstraint(ellipse, new Rectangle(0, 0, r.width(), r.height()));
    ellipse.setConstraint(smartLabel, calculateInnerRectangle(r.width(), r.height()));
    ellipse.setConstraint(contentPane, new Rectangle(0, 0, r.width(), r.height()));
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
    dim.setWidth((int) (2 * labelDim.width() / Math.sqrt(2)));
    dim.setHeight((int) (2 * labelDim.height() / Math.sqrt(2)));
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

  public Dimension getPreferredSize(int wHint, int hHint) {
    Dimension smartLabelSize = smartLabel.calculateSize();
    return calculateEllipseDimensionBasedOnLabelSize(smartLabelSize);
  }

  @Override
  public SmartLabelFigure getNameFigure() {
    return smartLabel;
  }
}
