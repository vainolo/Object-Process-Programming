/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.figure;

import static java.lang.Math.max;

import java.util.Comparator;
import java.util.List;

import org.eclipse.draw2d.*;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

import com.google.common.collect.Lists;

public class OPPObjectFigure extends OPPThingFigure implements OPPNamedElementFigure {
  private final RectangleFigure borderFigure;
  private final RectangleFigure shade1Figure;
  private final RectangleFigure shade2Figure;

  private final ContentPane contentPane;
  private ConnectionAnchor connectionAnchor;
  private boolean collection;
  private final SmartLabelFigure nameLabel;

  private RectangleFigure createRectangleFigure() {
    RectangleFigure figure = new RectangleFigure();
    figure.setAntialias(SWT.ON);
    figure.setForegroundColor(OPPFigureConstants.OBJECT_COLOR);
    figure.setLineWidth(OPPFigureConstants.ENTITY_BORDER_WIDTH);
    return figure;
  }

  public OPPObjectFigure(boolean collection) {
    setLayoutManager(new XYLayout());

    this.collection = collection;

    borderFigure = createRectangleFigure();
    borderFigure.setLayoutManager(new XYLayout());

    nameLabel = new SmartLabelFigure(OPPFigureConstants.TEXT_WIDTH_TO_HEIGHT_RATIO);
    nameLabel.setForegroundColor(OPPFigureConstants.LABEL_COLOR);
    borderFigure.add(nameLabel);

    contentPane = new ContentPane();
    borderFigure.add(contentPane);

    shade2Figure = createRectangleFigure();
    shade2Figure.setLayoutManager(new XYLayout());
    add(shade2Figure);

    shade1Figure = createRectangleFigure();
    shade1Figure.setLayoutManager(new XYLayout());
    add(shade1Figure);

    add(borderFigure);
  }

  public void setObjectKind(boolean newCollection) {
    if (collection && !newCollection) {
      shade1Figure.setVisible(false);
      shade2Figure.setVisible(false);
    } else if (!collection && newCollection) {
      shade1Figure.setVisible(true);
      shade2Figure.setVisible(true);
    }
    this.collection = newCollection;
  }

  @Override
  public IFigure getContentPane() {
    return contentPane;
  }

  private void paintBorders(Rectangle r, int offset) {
    setConstraint(borderFigure, new Rectangle(0, 0, r.width() - 2 * offset, r.height() - 2 * offset));
    setConstraint(shade1Figure, new Rectangle(offset, offset, r.width() - 2 * offset, r.height() - 2 * offset));
    setConstraint(shade2Figure, new Rectangle(2 * offset, 2 * offset, r.width() - 2 * offset, r.height() - 2 * offset));
  }

  private void paintNameAndContainer(Rectangle r, int offset) {
    Dimension nameDimensions = nameLabel.getPreferredSize();
    if (nameDimensions.width > r.width - 2 * offset) {
      nameDimensions = nameLabel.getPreferredSize(r.width - 2 * offset, -1);
    }
    if (!collection)
      borderFigure.setConstraint(nameLabel, new Rectangle(0, 5, r.width, nameDimensions.height));
    else
      borderFigure.setConstraint(nameLabel, new Rectangle(0, 5, r.width - 2 * offset, nameDimensions.height));

    borderFigure.setConstraint(contentPane, new Rectangle(0, 0, r.width - 2 * offset, r.height - 2 * offset));
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    super.paintFigure(graphics);
    Rectangle r = getBounds().getCopy();
    if (!collection) {
      paintBorders(r, 0);
      paintNameAndContainer(r, 0);
    } else {
      paintBorders(r, 5);
      paintNameAndContainer(r, 5);
    }
  }

  public ConnectionAnchor getConnectionAnchor() {
    if (connectionAnchor == null) {
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

    return prefSize.expand(10, 10);

  }

  @Override
  public SmartLabelFigure getNameFigure() {
    return nameLabel;
  }

  public void setDashedBorder(boolean dashed) {
    if (dashed) {
      borderFigure.setLineStyle(SWT.LINE_CUSTOM);
      borderFigure.setLineDash(OPPFigureConstants.GLOBAL_OBJECT_DASH);
    } else {
      borderFigure.setLineStyle(SWT.LINE_SOLID);
    }

  }

  class ContentPane extends Figure {
    public ContentPane() {
      setLayoutManager(new XYLayout());
    }

    @Override
    protected void paintFigure(Graphics graphics) {
      super.paintFigure(graphics);
      @SuppressWarnings("unchecked")
      List<OPPStateFigure> stateFigures = Lists.newArrayList(getChildren());
      for (OPPStateFigure child : stateFigures) {
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