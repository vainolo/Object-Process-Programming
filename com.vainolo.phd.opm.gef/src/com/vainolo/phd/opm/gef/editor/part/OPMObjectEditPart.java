/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;

import com.vainolo.phd.opm.gef.editor.figure.OPMObjectFigure;
import com.vainolo.phd.opm.gef.editor.figure.OPMThingFigure;
import com.vainolo.phd.opm.model.OPMObject;

public class OPMObjectEditPart extends OPMThingEditPart {

  @Override
  protected IFigure createFigure() {
    OPMObject model = (OPMObject) getModel();
    return new OPMObjectFigure(model.isCollection());
  }

  @Override
  protected void refreshVisuals() {
    OPMObjectFigure figure = (OPMObjectFigure) getFigure();
    OPMObject model = (OPMObject) getModel();
    GraphicalEditPart parent = (GraphicalEditPart) getParent();

    figure.setObjectKind(model.isCollection());
    figure.getNameFigure().setText(model.getName());
    figure.setTooltipText(model.getDescription());

    Rectangle constraints = model.getConstraints().getCopy();
    parent.setLayoutConstraint(this, figure, constraints);
  }

  @Override
  public IFigure getContentPane() {
    return ((OPMThingFigure) getFigure()).getContentPane();
  }
}
