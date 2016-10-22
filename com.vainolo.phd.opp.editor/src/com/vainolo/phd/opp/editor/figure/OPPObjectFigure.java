/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.figure;

import static java.lang.Math.max;

import java.util.List;

import org.eclipse.draw2d.*;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

import com.google.common.collect.Lists;

public class OPPObjectFigure extends OPPThingFigure implements OPPNamedElementFigure {
  private final RectangleFigure rectangle;
  private final RectangleFigure shade1;

  private final ContentPane contentPane;
  private ConnectionAnchor connectionAnchor;
  private boolean hasShadow = false;
  private final SmartLabelFigure nameLabel;

  public OPPObjectFigure() {
    rectangle = createRectangleFigure();
    rectangle.setLayoutManager(new XYLayout());
    nameLabel = new SmartLabelFigure(OPPFigureConstants.TEXT_WIDTH_TO_HEIGHT_RATIO);
    nameLabel.setForegroundColor(OPPFigureConstants.LABEL_COLOR);
    rectangle.add(nameLabel);

    contentPane = new ContentPane();
    contentPane.setLayoutManager(new XYLayout());
    rectangle.add(contentPane);

    shade1 = createRectangleFigure();
    shade1.setBackgroundColor(ColorConstants.gray);
    shade1.setFill(true);
    add(shade1);
    add(rectangle);
  }

  private RectangleFigure createRectangleFigure() {
    RectangleFigure figure = new RectangleFigure();
    figure.setAntialias(SWT.ON);
    figure.setForegroundColor(OPPFigureConstants.OBJECT_COLOR);
    figure.setLineWidth(OPPFigureConstants.ENTITY_BORDER_WIDTH);
    return figure;
  }

  @Override
  public IFigure getContentPane() {
    return contentPane;
  }

  private void paintObject(Rectangle r) {
    shade1.setVisible(false);
    setConstraint(rectangle, new Rectangle(0, 0, r.width(), r.height()));
    setConstraint(shade1, new Rectangle(0, 0, r.width(), r.height()));
    Dimension nameDimensions = nameLabel.getPreferredSize();
    if (nameDimensions.width > r.width) {
      nameDimensions = nameLabel.getPreferredSize(r.width, -1);
    }
    rectangle.setConstraint(nameLabel, new Rectangle(0, 5, r.width, nameDimensions.height));
    rectangle.setConstraint(contentPane, new Rectangle(0, 0, r.width, r.height));
  }

  private void paintObjectWithShadow(Rectangle r) {
    shade1.setVisible(true);
    setConstraint(rectangle, new Rectangle(0, 0, r.width() - 5, r.height() - 5));
    setConstraint(shade1, new Rectangle(5, 5, r.width() - 5, r.height() - 5));
    Dimension nameDimensions = nameLabel.getPreferredSize();
    if (nameDimensions.width > r.width - 5) {
      nameDimensions = nameLabel.getPreferredSize(r.width - 5, -1);
    }
    rectangle.setConstraint(nameLabel, new Rectangle(0, 5, r.width - 5, nameDimensions.height));
    rectangle.setConstraint(contentPane, new Rectangle(0, 0, r.width - 5, r.height));
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    super.paintFigure(graphics);
    Rectangle r = getBounds().getCopy();
    if (hasShadow)
      paintObjectWithShadow(r);
    else
      paintObject(r);
  }

  @Override
  public Dimension getPreferredSize(int wHint, int hHint) {
    Dimension smartLabelSize = nameLabel.calculateSize();
    Dimension contentPaneSize = contentPane.getPreferredSize();

    // If contentPane size is wider than smart label size, we must re-calculate
    // the height of the smart label using the width of the content pane.
    if (smartLabelSize.width() < contentPaneSize.width()) {
      nameLabel.invalidate();
      smartLabelSize = nameLabel.getPreferredSize(contentPaneSize.width(), -1);
    }

    Dimension prefSize = new Dimension();
    prefSize.width = max(smartLabelSize.width(), contentPaneSize.width());
    prefSize.height = max(smartLabelSize.height(), contentPaneSize.height());

    if (hasShadow)
      return prefSize.expand(25, 15);
    else
      return prefSize.expand(20, 10);

  }

  @Override
  public SmartLabelFigure getNameFigure() {
    return nameLabel;
  }

  public void setDashedBorder(boolean dashed) {
    if (dashed) {
      rectangle.setLineStyle(SWT.LINE_CUSTOM);
      rectangle.setLineDash(OPPFigureConstants.GLOBAL_OBJECT_DASH);
    } else {
      rectangle.setLineStyle(SWT.LINE_SOLID);
    }

  }

  public void setHasShadow(boolean hasShadow) {
    this.hasShadow = hasShadow;
  }

  class ContentPane extends Figure {
    public ContentPane() {
      setLayoutManager(new XYLayout());
    }

    @Override
    protected void paintFigure(Graphics graphics) {
      super.paintFigure(graphics);
      @SuppressWarnings("unchecked")
      List<Figure> stateFigures = Lists.newArrayList(getChildren());
      for (Figure child : stateFigures) {
        setConstraint(child, new Rectangle(child.getBounds().x, child.getBounds().y, child.getBounds().width, child.getBounds().height));
      }
    }

    @Override
    public Dimension getPreferredSize(int wHint, int hHint) {
      @SuppressWarnings("unchecked")
      List<OPPStateFigure> stateFigures = Lists.newArrayList(getChildren());
      int width = 0;
      int height = 0;
      for (OPPStateFigure stateFigure : stateFigures) {
        Rectangle stateBounds = stateFigure.getBounds();
        width = (width > stateBounds.x + stateBounds.width) ? width : stateBounds.x + stateBounds.width;
        height = (height > stateBounds.y + stateBounds.height) ? height : stateBounds.y + stateBounds.height;
      }

      return new Dimension(width, height);
    }
  }
}