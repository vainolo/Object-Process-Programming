/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import static java.lang.Math.max;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

import com.google.common.collect.Lists;
import com.vainolo.draw2d.extras.SmartLabelFigure;
import com.vainolo.jdraw2d.HorizontalAlignment;
import com.vainolo.phd.opm.model.OPMObjectKind;

public class OPMObjectFigure extends OPMThingFigure implements OPMNamedElementFigure {
  private final RectangleFigure topRectangle;
  private final RectangleFigure shade1;
  private final RectangleFigure shade2;

  private final ContentPane contentPane;
  private ConnectionAnchor connectionAnchor;
  private boolean collection;
  private final SmartLabelFigure smartLabel;

  private RectangleFigure createRectangleFigure() {
    RectangleFigure figure = new RectangleFigure();
    figure.setAntialias(SWT.ON);
    figure.setForegroundColor(OPMFigureConstants.OBJECT_COLOR);
    figure.setLineWidth(OPMFigureConstants.ENTITY_BORDER_WIDTH);
    return figure;
  }

  public OPMObjectFigure(boolean collection) {
    setLayoutManager(new XYLayout());

    this.collection = collection;

    topRectangle = createRectangleFigure();
    topRectangle.setLayoutManager(new XYLayout());

    smartLabel = new SmartLabelFigure(OPMFigureConstants.TEXT_WIDTH_TO_HEIGHT_RATIO);
    smartLabel.setForegroundColor(OPMFigureConstants.LABEL_COLOR);
    smartLabel.setHorizontalAlignment(HorizontalAlignment.CENTER);
    topRectangle.add(smartLabel);

    contentPane = new ContentPane();
    topRectangle.add(contentPane);

    shade2 = createRectangleFigure();
    shade2.setLayoutManager(new XYLayout());
    add(shade2);

    shade1 = createRectangleFigure();
    shade1.setLayoutManager(new XYLayout());
    add(shade1);

    add(topRectangle);
  }

  public void setObjectKind(boolean newCollection) {
    if(collection && !newCollection) {
      shade1.setVisible(false);
      shade2.setVisible(false);
    } else if(!collection && newCollection) {
      shade1.setVisible(true);
      shade2.setVisible(true);
    }
    this.collection = newCollection;
  }

  @Override
  public IFigure getContentPane() {
    return contentPane;
  }

  private void paintSimpleObject(Rectangle r) {
    setConstraint(topRectangle, new Rectangle(0, 0, r.width(), r.height()));
    setConstraint(shade1, new Rectangle(0, 0, r.width(), r.height()));
    setConstraint(shade2, new Rectangle(0, 0, r.width(), r.height()));

    Dimension contentPaneDimensions = contentPane.getPreferredSize();
    topRectangle.setConstraint(smartLabel,
        new Rectangle(5, 5, r.width() - 10, r.height() - contentPaneDimensions.height()));
    topRectangle.setConstraint(contentPane, new Rectangle(0, r.height() - contentPaneDimensions.height() - 5,
        r.width(), contentPaneDimensions.height()));
  }

  private void paintCollectionObject(Rectangle r) {
    setConstraint(topRectangle, new Rectangle(0, 0, r.width() - 10, r.height() - 10));
    setConstraint(shade1, new Rectangle(5, 5, r.width() - 10, r.height() - 10));
    setConstraint(shade2, new Rectangle(10, 10, r.width() - 10, r.height() - 10));
    Dimension contentPaneDimensions = contentPane.getPreferredSize();
    topRectangle.setConstraint(smartLabel,
        new Rectangle(5, 5, r.width() - 20, r.height() - contentPaneDimensions.height() - 10));
    topRectangle.setConstraint(contentPane,
        new Rectangle(0, r.height() - contentPaneDimensions.height() - 15, r.width(), contentPaneDimensions.height()));
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    super.paintFigure(graphics);
    Rectangle r = getBounds().getCopy();
    if(!collection) {
      paintSimpleObject(r);
    } else {
      paintCollectionObject(r);
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
    Dimension contentPaneSize = contentPane.getPreferredSize();

    // If contentPane size is wider than smart label size, we must re-calculate
    // the height of the smart label using the width of the content pane.
    if(smartLabelSize.width() < contentPaneSize.width()) {
      smartLabel.invalidate();
      smartLabelSize = smartLabel.getPreferredSize(contentPaneSize.width(), -1);
    }

    Dimension prefSize = new Dimension();
    prefSize.width = max(smartLabelSize.width(), contentPaneSize.width());
    prefSize.height = smartLabelSize.height() + contentPaneSize.height();

    if(!collection)
      return prefSize.expand(10, 10);
    else
      return prefSize.expand(20, 20);
  }

  @Override
  public SmartLabelFigure getNameFigure() {
    return smartLabel;
  }

  static final Comparator<OPMStateFigure> stateComparator = new Comparator<OPMStateFigure>() {
    @Override
    public int compare(OPMStateFigure o1, OPMStateFigure o2) {
      return o1.getNameFigure().getText().compareTo(o2.getNameFigure().getText());
    }
  };

  class ContentPane extends Figure {
    public ContentPane() {
      setLayoutManager(new XYLayout());
    }

    @Override
    protected void paintFigure(Graphics graphics) {
      super.paintFigure(graphics);
      @SuppressWarnings("unchecked")
      List<OPMStateFigure> stateFigures = Lists.newArrayList(getChildren());
      Collections.sort(stateFigures, stateComparator);
      Rectangle r = getBounds();
      Dimension d = getPreferredSize();
      int currentX = 5;
      if(r.width() > d.width()) {
        currentX += (r.width() - d.width()) / 2;
      }
      for(OPMStateFigure child : stateFigures) {
        Dimension prefSize = child.getPreferredSize();
        setConstraint(child, new Rectangle(currentX, 5, prefSize.width(), prefSize.height()));
        currentX += prefSize.width() + 5;
      }
    }

    @Override
    public Dimension getPreferredSize(int wHint, int hHint) {
      @SuppressWarnings("unchecked")
      List<OPMStateFigure> stateFigures = Lists.newArrayList(getChildren());
      if(stateFigures.size() == 0)
        return new Dimension();

      int totalWidth = 5; // left margin
      int maxHeight = 0;
      for(OPMStateFigure stateFigure : stateFigures) {
        Dimension prefSize = stateFigure.getPreferredSize();
        totalWidth += prefSize.width() + 5; // right margin included here
        maxHeight = (maxHeight > prefSize.height() ? maxHeight : prefSize.height);
      }
      maxHeight += 10; // top and bottom margin

      return new Dimension(totalWidth, maxHeight);
    }
  }
}