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
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * A figure representing an OPM State. A state is represented by a rountangle (rounded rectangle).
 * 
 * @author vainolo
 * 
 */
public class OPMStateFigure extends Figure implements OPMNodeFigure, OPMNamedElementFigure {
  private final RoundedRectangle rectangle;
  private ConnectionAnchor connectionAnchor;
  private final Label nameLabel;

  public OPMStateFigure() {
    super();
    setLayoutManager(new XYLayout());
    nameLabel = new Label();
    nameLabel.setForegroundColor(OPMFigureConstants.opmLabelColor);
    add(nameLabel);
    rectangle = new RoundedRectangle();
    rectangle.setCornerDimensions(new Dimension(20, 20));
    rectangle.setFill(false);
    rectangle.setForegroundColor(OPMFigureConstants.opmStateColor);
    rectangle.setLineWidth(OPMFigureConstants.entityBorderWidth);
    add(rectangle);
  }

  /**
   * Get the label used to set the name of the state.
   * 
   * @return the label where the name of the state is shown.
   */
  @Override
  public Label getNameLabel() {
    return nameLabel;
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
    Dimension d = new Dimension();
    Rectangle textRectangle = nameLabel.getTextBounds().getCopy();
    d.width = textRectangle.width;
    d.height = textRectangle.height;
    setPreferredSize(d);
    return super.getPreferredSize(wHint, hHint);
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    Rectangle r = getBounds().getCopy();
    setConstraint(rectangle, new Rectangle(0 + OPMFigureConstants.opmNodeInsets, 0 + OPMFigureConstants.opmNodeInsets,
        r.width - OPMFigureConstants.opmNodeInsets, r.height - OPMFigureConstants.opmNodeInsets));
    setConstraint(getNameLabel(), new Rectangle(0 + OPMFigureConstants.opmNodeInsets,
        0 + OPMFigureConstants.opmNodeInsets, r.width - OPMFigureConstants.opmNodeInsets, r.height -
            OPMFigureConstants.opmNodeInsets));
    rectangle.invalidate();
    getNameLabel().invalidate();
  }
}
