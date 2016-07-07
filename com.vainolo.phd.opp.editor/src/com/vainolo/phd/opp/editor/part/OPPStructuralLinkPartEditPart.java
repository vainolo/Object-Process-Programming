/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.EditPolicy;

import com.vainolo.phd.opp.editor.figure.OPPStructuralLinkPartFigure;
import com.vainolo.phd.opp.editor.policy.OPPStructuralLinkBendpointEditPolicy;
import com.vainolo.phd.opp.model.OPPPoint;
import com.vainolo.phd.opp.model.OPPStructuralLinkPart;

public class OPPStructuralLinkPartEditPart extends OPPLinkEditPart {

  public OPPStructuralLinkPartEditPart() {
    super();
  }

  @Override
  public void activate() {
    // TODO Auto-generated method stub
    super.activate();
  }

  @Override
  protected PolylineConnection createFigure() {
    OPPStructuralLinkPartFigure figure = new OPPStructuralLinkPartFigure();
    return figure;
  }

  @Override
  public OPPStructuralLinkPartFigure getFigure() {
    return (OPPStructuralLinkPartFigure) super.getFigure();
  }

  @Override
  public OPPStructuralLinkPart getModel() {
    return (OPPStructuralLinkPart) super.getModel();
  }

  @Override
  protected void refreshVisuals() {
    super.refreshVisuals();
    Connection connection = getConnectionFigure();
    List<OPPPoint> modelConstraint = getModel().getBendpoints();
    List<AbsoluteBendpoint> figureConstraint = new ArrayList<AbsoluteBendpoint>();
    for (OPPPoint p : modelConstraint) {
      figureConstraint.add(new AbsoluteBendpoint(p.getX(), p.getY()));
    }
    connection.setRoutingConstraint(figureConstraint);
  }

  @Override
  protected void createEditPolicies() {
    super.createEditPolicies();
    installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new OPPStructuralLinkBendpointEditPolicy());
  }
}
