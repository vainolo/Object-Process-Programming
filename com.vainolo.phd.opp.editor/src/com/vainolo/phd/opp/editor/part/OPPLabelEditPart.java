/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;

import com.vainolo.phd.opp.editor.figure.OPPLabelFigure;
import com.vainolo.phd.opp.editor.figure.OPPNamedElementFigure;
import com.vainolo.phd.opp.editor.part.delegates.OPPDirectEditDelegate;
import com.vainolo.phd.opp.editor.policy.OPPNamedEntityDirectEditPolicy;
import com.vainolo.phd.opp.model.OPPLabel;

/**
 * Label to be added anywhere in the diagram
 * 
 * @author vainolo
 * 
 */
public class OPPLabelEditPart extends OPPNodeEditPart {

  public OPPLabelEditPart() {
    super();
  }

  @Override
  protected IFigure createFigure() {
    return new OPPLabelFigure();
  }

  @Override
  protected void createEditPolicies() {
    super.createEditPolicies();
    installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new OPPNamedEntityDirectEditPolicy());
  }

  @Override
  protected void refreshVisuals() {
    OPPLabel model = (OPPLabel) getModel();
    GraphicalEditPart parent = (GraphicalEditPart) getParent();
    ((OPPNamedElementFigure) getFigure()).getNameFigure().setText(model.getName());
    parent.setLayoutConstraint(this, getFigure(),
        new Rectangle(model.getX(), model.getY(), model.getWidth(), model.getHeight()));
  }

  @Override
  public void performRequest(Request req) {
    if(req.getType() == RequestConstants.REQ_DIRECT_EDIT) {
      OPPDirectEditDelegate.performDirectEditing(this, ((OPPNamedElementFigure) getFigure()).getNameFigure());
    }
  }
}
