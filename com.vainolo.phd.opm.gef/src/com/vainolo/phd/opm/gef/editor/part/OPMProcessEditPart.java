/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalEditPart;

import com.vainolo.phd.opm.gef.editor.figure.OPMProcessFigure;
import com.vainolo.phd.opm.gef.editor.figure.OPMThingFigure;
import com.vainolo.phd.opm.model.OPMThing;

public class OPMProcessEditPart extends OPMThingEditPart {

  @Override
  protected IFigure createFigure() {
    return new OPMProcessFigure();
  }

  @Override
  protected void refreshVisuals() {
    final OPMThingFigure figure = (OPMThingFigure) getFigure();
    final OPMThing model = (OPMThing) getModel();
    final GraphicalEditPart parent = (GraphicalEditPart) getParent();
    figure.getNameFigure().setText(model.getName());
    figure.setTooltipText(model.getDescription());
    parent.setLayoutConstraint(this, figure, model.getConstraints());
  }

  @Override
  public IFigure getContentPane() {
    return ((OPMThingFigure) getFigure()).getContentPane();
  }
}
