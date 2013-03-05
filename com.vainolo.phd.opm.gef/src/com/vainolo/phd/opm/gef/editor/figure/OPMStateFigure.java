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
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import com.vainolo.draw2d.extras.SmartLabelFigure;

/**
 * A figure representing an OPM State. A state is represented by a rountangle (rounded rectangle).
 * 
 * @author vainolo
 * 
 */
public class OPMStateFigure extends Figure implements OPMNodeFigure, OPMNamedElementFigure {
  private final RoundedRectangle rectangle;
  private ConnectionAnchor connectionAnchor;
  private final SmartLabelFigure smartLabel;

  public OPMStateFigure() {
    super();
    setLayoutManager(new XYLayout());
    smartLabel = new SmartLabelFigure(OPMFigureConstants.TEXT_WIDTH_TO_HEIGHT_RATIO);
    smartLabel.setForegroundColor(OPMFigureConstants.LABEL_COLOR);
    add(smartLabel);
    rectangle = new RoundedRectangle();
    rectangle.setCornerDimensions(new Dimension(20, 20));
    rectangle.setFill(false);
    rectangle.setForegroundColor(OPMFigureConstants.STATE_COLOR);
    rectangle.setLineWidth(OPMFigureConstants.ENTITY_BORDER_WIDTH);
    add(rectangle);
  }

  /**
   * All connections to the figure use the same anchor: a {@link ChopboxAnchor}.
   * 
   * @return a {@link ChopboxAnchor} for the state.
   */
  private ConnectionAnchor getConnectionAnchor() {
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
    return smartLabel.calculateSize();
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    Rectangle r = getBounds().getCopy();
    setConstraint(rectangle, new Rectangle(0 + OPMFigureConstants.NODE_INSETS, 0 + OPMFigureConstants.NODE_INSETS,
        r.width - OPMFigureConstants.NODE_INSETS, r.height - OPMFigureConstants.NODE_INSETS));
    setConstraint(smartLabel, new Rectangle(0 + OPMFigureConstants.NODE_INSETS, 0 + OPMFigureConstants.NODE_INSETS,
        r.width - OPMFigureConstants.NODE_INSETS, r.height - OPMFigureConstants.NODE_INSETS));
  }

  @Override
  public SmartLabelFigure getNameFigure() {
    return smartLabel;
  }
}
