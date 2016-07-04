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
import org.eclipse.swt.SWT;

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
  private final OPPIsoscelesTriangle triangle;
  private ConnectionAnchor topAnchor;
  private ConnectionAnchor bottomAnchor;
  OPPStructuralLinkAggregatorKind kind;

  public OPPStructuralLinkAggregatorFigure(final OPPStructuralLinkAggregatorKind kind) {
    this.kind = kind;
    setLayoutManager(new XYLayout());
    triangle = new OPPIsoscelesTriangle();
    triangle.setBackgroundColor(ColorConstants.black);
    triangle.setAntialias(SWT.ON);
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
}
