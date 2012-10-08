/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

import com.vainolo.phd.opm.model.OPMObjectKind;

public class OPMObjectFigure extends OPMThingFigure {
  private final RectangleFigure rectangle;
  private final RectangleFigure rectangle2;
  private ConnectionAnchor connectionAnchor;
  private OPMObjectKind kind;

  public OPMObjectFigure(OPMObjectKind kind) {
    super();
    // super.addFiguresAtEnd();

    this.kind = kind;

    rectangle = new RectangleFigure();
    // rectangle.setFill(false);
    rectangle.setLayoutManager(new XYLayout());
    rectangle.setForegroundColor(OPMFigureConstants.opmObjectColor);
    rectangle.setLineWidth(OPMFigureConstants.entityBorderWidth);

    rectangle2 = new RectangleFigure();
    rectangle2.setLayoutManager(new XYLayout());
    rectangle2.setForegroundColor(OPMFigureConstants.opmObjectColor);
    rectangle2.setLineWidth(OPMFigureConstants.entityBorderWidth);
    if(kind.equals(OPMObjectKind.COLLECTION)) {
      add(rectangle2);
    }
    add(rectangle);
    rectangle.add(getNameLabel());

  }

  public void setObjectKind(OPMObjectKind newKind) {
    if(kind.equals(OPMObjectKind.COLLECTION) && newKind.equals(OPMObjectKind.SIMPLE)) {
      remove(rectangle2);
    } else if(kind.equals(OPMObjectKind.SIMPLE) && newKind.equals(OPMObjectKind.COLLECTION)) {
      add(rectangle2, 0);
    }
    this.kind = newKind;
  }

  @Override
  public IFigure getContentPane() {
    return rectangle;
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    super.paintFigure(graphics);
    Rectangle r = getBounds().getCopy();
    if(kind.equals(OPMObjectKind.SIMPLE)) {
      setConstraint(rectangle, new Rectangle(0, 0, r.width(), r.height()));
      rectangle.invalidate();
    } else if(kind.equals(OPMObjectKind.COLLECTION)) {
      setConstraint(rectangle, new Rectangle(0, 0, r.width() - 5, r.height() - 5));
      rectangle.invalidate();
      setConstraint(rectangle2, new Rectangle(5, 5, r.width() - 5, r.height() - 5));
      rectangle2.invalidate();
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
}