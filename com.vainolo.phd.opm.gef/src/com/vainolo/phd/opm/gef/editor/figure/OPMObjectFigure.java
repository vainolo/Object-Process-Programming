/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import com.vainolo.phd.opm.model.OPMObjectKind;

public class OPMObjectFigure extends OPMThingFigure {
  private final RectangleFigure rectangle;
  private final RectangleFigure rectangle2;
  private final Figure rectangle3;
  private ConnectionAnchor connectionAnchor;
  private OPMObjectKind kind;

  public OPMObjectFigure(OPMObjectKind kind) {
    super();

    this.kind = kind;

    rectangle = new RectangleFigure();
    rectangle.setLayoutManager(new XYLayout());
    rectangle.setForegroundColor(OPMFigureConstants.opmObjectColor);
    rectangle.setLineWidth(OPMFigureConstants.entityBorderWidth);
    rectangle.add(getTextFigure());

    rectangle3 = new Figure();
    rectangle3.setLayoutManager(new XYLayout());
    rectangle.add(rectangle3);

    rectangle2 = new RectangleFigure();
    rectangle2.setLayoutManager(new XYLayout());
    rectangle2.setForegroundColor(OPMFigureConstants.opmObjectColor);
    rectangle2.setLineWidth(OPMFigureConstants.entityBorderWidth);
    add(rectangle2);
    add(rectangle);
  }

  public void setObjectKind(OPMObjectKind newKind) {
    if(kind.equals(OPMObjectKind.COLLECTION) && newKind.equals(OPMObjectKind.SIMPLE)) {
      rectangle2.setVisible(false);
    } else if(kind.equals(OPMObjectKind.SIMPLE) && newKind.equals(OPMObjectKind.COLLECTION)) {
      rectangle2.setVisible(true);
    }
    this.kind = newKind;
  }

  @Override
  public IFigure getContentPane() {
    return rectangle3;
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    super.paintFigure(graphics);
    Rectangle r = getBounds().getCopy();
    if(kind.equals(OPMObjectKind.SIMPLE)) {
      setConstraint(rectangle, new Rectangle(0, 0, r.width(), r.height()));
      rectangle.setConstraint(getTextFigure(), new Rectangle(5, 5, r.width() - 5, r.height() - 5));
      rectangle.setConstraint(rectangle3, new Rectangle(5, 5, r.width() - 5, r.height() - 5));
    } else if(kind.equals(OPMObjectKind.COLLECTION)) {
      setConstraint(rectangle, new Rectangle(0, 0, r.width() - 5, r.height() - 5));
      rectangle.setConstraint(getTextFigure(), new Rectangle(5, 5, r.width() - 15, r.height() - 15));
      setConstraint(rectangle2, new Rectangle(5, 5, r.width() - 5, r.height() - 5));
      rectangle.setConstraint(rectangle3, new Rectangle(5, 5, r.width() - 5, r.height() - 5));
    }
  }

  public ConnectionAnchor getConnectionAnchor() {
    if(connectionAnchor == null) {
      connectionAnchor = new ChopboxAnchor(this);
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

  @Override
  public Dimension getPreferredSize(int wHint, int hHint) {
    prefSize = getTextFlow().getSize().getCopy();
    if(kind.equals(OPMObjectKind.SIMPLE))
      prefSize.expand(5, 5);
    else
      prefSize.expand(10, 10);
    return prefSize;
  }
}