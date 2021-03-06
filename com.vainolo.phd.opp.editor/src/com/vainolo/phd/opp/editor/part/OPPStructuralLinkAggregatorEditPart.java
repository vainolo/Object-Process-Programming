/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.part;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;

import com.vainolo.phd.opp.model.OPPStructuralLinkAggregator;
import com.vainolo.phd.opp.editor.figure.OPPStructuralLinkAggregatorFigure;

public class OPPStructuralLinkAggregatorEditPart extends OPPNodeEditPart {

  private IFigure figure;

  @Override
  protected IFigure createFigure() {
    OPPStructuralLinkAggregator model = (OPPStructuralLinkAggregator) getModel();
    figure = new OPPStructuralLinkAggregatorFigure(model.getKind());
    return figure;
  }

  @Override
  protected void refreshVisuals() {
    OPPStructuralLinkAggregator model = (OPPStructuralLinkAggregator) getModel();
    ((GraphicalEditPart) getParent()).setLayoutConstraint(this, figure, new Rectangle(model.getX(), model.getY(), model.getWidth(), model.getHeight()));
  }

  @Override
  protected ConnectionAnchor getSourceConnectionAnchor() {
    return new AbstractConnectionAnchor(getFigure()) {
      @Override
      public Point getLocation(Point reference) {
        Point p = new Point();
        Rectangle ownerBounds = getOwner().getBounds().getCopy();
        p.x = ownerBounds.x + ownerBounds.width / 2;
        p.y = ownerBounds.y + ownerBounds.height;
        getFigure().translateToAbsolute(p);
        return p;
      }
    };
  }

  @Override
  protected ConnectionAnchor getTargetConnectionAnchor() {
    return new AbstractConnectionAnchor(getFigure()) {
      @Override
      public Point getLocation(Point reference) {
        Point p = new Point();
        Rectangle ownerBounds = getOwner().getBounds().getCopy();
        p.x = ownerBounds.x + ownerBounds.width / 2;
        p.y = ownerBounds.y;
        getFigure().translateToAbsolute(p);
        return p;
      }
    };
  }
}
