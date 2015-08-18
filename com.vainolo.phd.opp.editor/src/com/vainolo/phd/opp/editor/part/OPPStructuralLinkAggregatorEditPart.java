/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.part;

import org.eclipse.draw2d.IFigure;
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
    ((GraphicalEditPart) getParent()).setLayoutConstraint(this, figure,
        new Rectangle(model.getX(), model.getY(), model.getWidth(), model.getHeight()));
  }
}
