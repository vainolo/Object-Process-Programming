/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;

import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.editor.figure.OPPObjectFigure;
import com.vainolo.phd.opp.editor.figure.OPPThingFigure;

public class OPPObjectEditPart extends OPPThingEditPart {

  @Override
  protected IFigure createFigure() {
    OPPObject model = (OPPObject) getModel();
    return new OPPObjectFigure(model.isCollection());
  }

  @Override
  protected void refreshVisuals() {
    OPPObjectFigure figure = (OPPObjectFigure) getFigure();
    OPPObject model = (OPPObject) getModel();
    GraphicalEditPart parent = (GraphicalEditPart) getParent();

    figure.setObjectKind(model.isCollection());
    figure.getNameFigure().setText(model.getName());
    figure.setTooltipText(model.getDescription());

    figure.setDashedBorder(model.isGlobal());

    parent.setLayoutConstraint(this, figure, new Rectangle(model.getX(), model.getY(), model.getWidth(), model.getHeight()));
  }

  @Override
  public IFigure getContentPane() {
    return ((OPPThingFigure) getFigure()).getContentPane();
  }
}
