/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.figure;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import com.vainolo.phd.opp.model.OPPStructuralLinkAggregatorKind;

/**
 * Draws the figure for a {@link OPMStructuralLinkAggregator}. This figure consists of one or two
 * {@link OPPIsoscelesTriangle}, filled or not filled, depending on the type of aggregator that is drawn (a parameter to
 * the figure).
 * 
 * @author vainolo
 * 
 */
public class OPPStructuralLinkAggregatorFigure extends Figure implements OPPNodeFigure {
  /** The triangle used as figure. */
  private final OPPIsoscelesTriangle triangle;
  /** Anchor created at the center-top of the figure, used for target anchors. */
  private ConnectionAnchor topAnchor;
  /**
   * Anchor created at the center-bottom of the figure, used for source anchors.
   */
  private ConnectionAnchor bottomAnchor;
  /** The kind of aggregator this figure represents. */
  OPPStructuralLinkAggregatorKind kind;

  /**
   * Create a new aggregator figure depending on the aggregator kind.
   * 
   * @param kind
   *          the {@link OPMStructuralLinkAggregatorKind} of the figure.
   */
  public OPPStructuralLinkAggregatorFigure(final OPPStructuralLinkAggregatorKind kind) {
    this.kind = kind;
    setLayoutManager(new XYLayout());
    triangle = new OPPIsoscelesTriangle();
    triangle.setBackgroundColor(ColorConstants.black);
    switch (kind) {
    case AGGREGATION:
      triangle.setFill(true);
      break;
    case GENERALIZATION:
      triangle.setFill(false);
      break;
    default:
      throw new IllegalArgumentException("Invalid aggregator kind: " + kind);
    }
    add(triangle);
  }

  @Override
  protected void paintFigure(Graphics graphics) {
    Rectangle bounds = getBounds().getCopy();
    setConstraint(triangle, new Rectangle(0, 0, bounds.width, bounds.height));
    triangle.invalidate();
  }

  /**
   * Create a {@link ConnectionAnchor} that is located at the center-top of the figure.
   * 
   * @return a {@link ConnectionAnchor} at the center-top of the figure.
   */
  private ConnectionAnchor getTopAnchor() {
    if (topAnchor == null) {
      topAnchor = new AbstractConnectionAnchor(this) {
        @Override
        public Point getLocation(Point reference) {
          Point p = new Point();
          Rectangle ownerBounds = getOwner().getBounds().getCopy();
          p.x = ownerBounds.x + ownerBounds.width / 2;
          p.y = ownerBounds.y;
          translateToAbsolute(p);
          return p;
        }
      };
    }
    return topAnchor;

  }

  /**
   * Create a {@link ConnectionAnchor} that is located at the center-bottom of the figure.
   * 
   * @return a {@link ConnectionAnchor} at the center-bottom of the figure.
   */
  private ConnectionAnchor getBottomAnchor() {
    if (bottomAnchor == null) {
      bottomAnchor = new AbstractConnectionAnchor(this) {
        @Override
        public Point getLocation(Point reference) {
          Point p = new Point();
          Rectangle ownerBounds = getOwner().getBounds().getCopy();
          p.x = ownerBounds.x + ownerBounds.width / 2;
          p.y = ownerBounds.y + ownerBounds.height;
          translateToAbsolute(p);
          return p;
        }
      };
    }
    return bottomAnchor;
  }

  @Override
  public ConnectionAnchor getSourceConnectionAnchor() {
    return getBottomAnchor();
  }

  @Override
  public ConnectionAnchor getTargetConnectionAnchor() {
    return getTopAnchor();
  }

}
