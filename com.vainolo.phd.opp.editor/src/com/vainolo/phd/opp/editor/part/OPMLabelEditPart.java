/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;

import com.vainolo.phd.opp.editor.figure.OPMLabelFigure;
import com.vainolo.phd.opp.editor.figure.OPMNamedElementFigure;
import com.vainolo.phd.opp.editor.part.delegates.DirectEditDelegate;
import com.vainolo.phd.opp.editor.policy.OPMNamedEntityDirectEditPolicy;

/**
 * Label to be added anywhere in the diagram
 * 
 * @author vainolo
 * 
 */
public class OPMLabelEditPart extends OPMNodeEditPart {

  public OPMLabelEditPart() {
    super();
  }

  @Override
  protected IFigure createFigure() {
    return new OPMLabelFigure();
  }

  @Override
  protected void createEditPolicies() {
    super.createEditPolicies();
    installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new OPMNamedEntityDirectEditPolicy());
  }

  @Override
  protected void refreshVisuals() {
    com.vainolo.phd.opm.model.Label model = (com.vainolo.phd.opm.model.Label) getModel();
    GraphicalEditPart parent = (GraphicalEditPart) getParent();
    ((OPMNamedElementFigure) getFigure()).getNameFigure().setText(model.getName());
    parent.setLayoutConstraint(this, getFigure(), model.getConstraints());
  }

  @Override
  public void performRequest(Request req) {
    if(req.getType() == RequestConstants.REQ_DIRECT_EDIT) {
      DirectEditDelegate.performDirectEditing(this, ((OPMNamedElementFigure) getFigure()).getNameFigure());
    }
  }
}
