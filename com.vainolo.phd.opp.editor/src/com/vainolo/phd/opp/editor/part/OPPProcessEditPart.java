/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;

import com.vainolo.phd.opp.editor.figure.OPPProcessFigure;
import com.vainolo.phd.opp.editor.figure.OPPThingFigure;
import com.vainolo.phd.opp.model.OPPProcess;

public class OPPProcessEditPart extends OPPThingEditPart {

  @Override
  protected IFigure createFigure() {
    return new OPPProcessFigure();
  }

  @Override
  protected void refreshVisuals() {
    final OPPProcessFigure figure = getFigure();
    final OPPProcess model = getModel();
    final GraphicalEditPart parent = (GraphicalEditPart) getParent();

    figure.setMultiple(model.isCollection());
    if (!model.isMain())
      figure.getNameFigure().setText(model.getName());
    figure.setTooltipText(model.getDescription());
    figure.invalidateTree();

    parent.setLayoutConstraint(this, figure, new Rectangle(model.getX(), model.getY(), model.getWidth(), model.getHeight()));

  }

  @Override
  public IFigure getContentPane() {
    return ((OPPThingFigure) getFigure()).getContentPane();
  }

  @Override
  public OPPProcessFigure getFigure() {
    return OPPProcessFigure.class.cast(super.getFigure());
  }

  @Override
  public OPPProcess getModel() {
    return OPPProcess.class.cast(super.getModel());
  }
}
