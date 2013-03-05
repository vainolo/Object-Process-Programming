/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;

import com.vainolo.phd.opm.gef.editor.figure.OPMObjectFigure;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMThing;

public class OPMObjectEditPart extends OPMThingEditPart {

  @Override
  protected IFigure createFigure() {
    OPMObject model = (OPMObject) getModel();
    return new OPMObjectFigure(model.getKind());
  }

  @Override
  protected void refreshVisuals() {
    ((OPMObjectFigure) getFigure()).setObjectKind(((OPMObject) getModel()).getKind());
    OPMObjectFigure figure = (OPMObjectFigure) getFigure();
    OPMThing model = (OPMThing) getModel();
    GraphicalEditPart parent = (GraphicalEditPart) getParent();
    figure.setText(model.getName());
    figure.setTooltipText(model.getDescription());

    Rectangle constraints = model.getConstraints().getCopy();
    Dimension size = figure.getPreferredSize();
    constraints.setSize(size);
    parent.setLayoutConstraint(this, figure, constraints);
  }
}
