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
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import com.vainolo.draw2d.extras.SmartLabelFigure;
import com.vainolo.jdraw2d.HorizontalAlignment;
import com.vainolo.phd.opm.model.OPMObjectKind;

public class OPMObjectFigure extends OPMThingFigure implements OPMNamedElementFigure {
  private final RectangleFigure topRectangle;
  private final RectangleFigure shade1;
  private final RectangleFigure shade2;

  private final Figure contentPane;
  private ConnectionAnchor connectionAnchor;
  private OPMObjectKind kind;
  private final SmartLabelFigure smartLabel;
  private TooltipFigure tooltipFigure;

  private RectangleFigure createObjectRectangleFigure() {
    RectangleFigure figure = new RectangleFigure();
    figure.setForegroundColor(OPMFigureConstants.OBJECT_COLOR);
    figure.setLineWidth(OPMFigureConstants.ENTITY_BORDER_WIDTH);
    return figure;
  }

  public OPMObjectFigure(OPMObjectKind kind) {
    setLayoutManager(new XYLayout());
    tooltipFigure = new TooltipFigure();

    this.kind = kind;

    topRectangle = createObjectRectangleFigure();
    topRectangle.setLayoutManager(new XYLayout());

    smartLabel = new SmartLabelFigure(OPMFigureConstants.TEXT_WIDTH_TO_HEIGHT_RATIO);
    smartLabel.setForegroundColor(OPMFigureConstants.LABEL_COLOR);
    smartLabel.setHorizontalAlignment(HorizontalAlignment.CENTER);
    topRectangle.add(smartLabel);

    contentPane = new Figure();
    contentPane.setLayoutManager(new XYLayout());
    topRectangle.add(contentPane);

    shade2 = createObjectRectangleFigure();
    shade2.setLayoutManager(new XYLayout());
    add(shade2);

    shade1 = createObjectRectangleFigure();
    shade1.setLayoutManager(new XYLayout());
    add(shade1);

    add(topRectangle);
  }

  public void setObjectKind(OPMObjectKind newKind) {
    if(kind.equals(OPMObjectKind.COLLECTION) && newKind.equals(OPMObjectKind.SIMPLE)) {
      shade1.setVisible(false);
      shade2.setVisible(false);
    } else if(kind.equals(OPMObjectKind.SIMPLE) && newKind.equals(OPMObjectKind.COLLECTION)) {
      shade1.setVisible(true);
      shade2.setVisible(true);
    }
    this.kind = newKind;
  }

  @Override
  public IFigure getContentPane() {
    return contentPane;
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    super.paintFigure(graphics);
    Rectangle r = getBounds().getCopy();
    if(kind.equals(OPMObjectKind.SIMPLE)) {

      setConstraint(topRectangle, new Rectangle(0, 0, r.width(), r.height()));
      setConstraint(shade1, new Rectangle(0, 0, r.width(), r.height()));
      setConstraint(shade2, new Rectangle(0, 0, r.width(), r.height()));
      // topRectangle.setConstraint(flowPage, new Rectangle(0, 0, r.width(), r.height()));
      topRectangle.setConstraint(smartLabel, new Rectangle(0, 0, r.width(), r.height()));
      topRectangle.setConstraint(contentPane, new Rectangle(0, 0, r.width(), r.height()));

    } else if(kind.equals(OPMObjectKind.COLLECTION)) {

      setConstraint(topRectangle, new Rectangle(0, 0, r.width() - 10, r.height() - 10));
      setConstraint(shade1, new Rectangle(5, 5, r.width() - 10, r.height() - 10));
      setConstraint(shade2, new Rectangle(10, 10, r.width() - 10, r.height() - 10));
      // topRectangle.setConstraint(flowPage, new Rectangle(0, 0, r.width() - 10, r.height() - 10));
      topRectangle.setConstraint(smartLabel, new Rectangle(0, 0, r.width() - 10, r.height() - 10));
      topRectangle.setConstraint(contentPane, new Rectangle(0, 0, r.width() - 10, r.height() - 10));

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
  public Dimension getPreferredSize(int wHint, int hHint) {
    Dimension smartLabelSize = smartLabel.calculateSize();
    if(kind.equals(OPMObjectKind.SIMPLE))
      return smartLabelSize;
    else
      return smartLabelSize.expand(10, 10);
  }

  @Override
  public SmartLabelFigure getNameFigure() {
    return smartLabel;
  }
}