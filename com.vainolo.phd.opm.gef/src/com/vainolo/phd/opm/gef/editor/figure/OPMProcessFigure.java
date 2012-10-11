/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class OPMProcessFigure extends OPMThingFigure {
  private final Ellipse ellipse;
  private ConnectionAnchor connectionAnchor;

  public OPMProcessFigure() {
    super();
    ellipse = new Ellipse();
    ellipse.setLayoutManager(new XYLayout());
    ellipse.setForegroundColor(OPMFigureConstants.opmProcessColor);
    ellipse.setLineWidth(OPMFigureConstants.entityBorderWidth);
    ellipse.add(getTextFigure());
    add(ellipse);
  }

  @Override
  public IFigure getContentPane() {
    return ellipse;
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    super.paintFigure(graphics);
    Rectangle r = getBounds().getCopy();
    setConstraint(ellipse, new Rectangle(0, 0, r.width(), r.height()));
    ellipse.setConstraint(getTextFigure(), calculateInnerRectangle(r.width(), r.height()));

    System.out.println(ellipse.getSize());
    System.out.println(getTextFigure().getSize());
    System.out.println(getTextFlow().getSize());
  }

  private Rectangle calculateInnerRectangle(int width, int heigth) {
    Rectangle rect = new Rectangle();
    rect.setWidth((int) (Math.sqrt(2) * width / 2));
    rect.setHeight((int) (Math.sqrt(2) * heigth / 2));
    rect.setX(width / 2 - rect.width() / 2);
    rect.setY(heigth / 2 - rect.height() / 2);
    rect.shrink(2, 2);
    return rect;
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

  @Override
  public Label getNameLabel() {
    // TODO Auto-generated method stub
    return null;
  }

  public Dimension getPreferredSize(int wHint, int hHint) {
    prefSize = getTextFlow().getSize().getCopy();
    prefSize.expand(2, 2);
    prefSize.setWidth((int) (prefSize.width() * Math.sqrt(2)));
    prefSize.setHeight((int) (prefSize.height * Math.sqrt(2)));
    return prefSize;
  }
}
