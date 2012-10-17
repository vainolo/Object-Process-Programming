/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.IFigure;

import com.vainolo.phd.opm.gef.editor.figure.OPMObjectFigure;
import com.vainolo.phd.opm.model.OPMObject;

public class OPMObjectEditPart extends OPMThingEditPart {

  @Override
  protected IFigure createFigure() {
    OPMObject model = (OPMObject) getModel();
    return new OPMObjectFigure(model.getKind());
  }

  @Override
  protected void refreshVisuals() {
    ((OPMObjectFigure) getFigure()).setObjectKind(((OPMObject) getModel()).getKind());
    super.refreshVisuals();
  }
}
