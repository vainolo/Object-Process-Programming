/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.*;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;

import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opp.editor.figure.CircleDecoration;
import com.vainolo.phd.opp.editor.figure.OPMNamedElementFigure;
import com.vainolo.phd.opp.editor.figure.OPMProceduralLinkFigure;
import com.vainolo.phd.opp.editor.part.delegates.DirectEditDelegate;
import com.vainolo.phd.opp.editor.policy.OPMLinkBendpointEditPolicy;
import com.vainolo.phd.opp.editor.policy.OPMLinkConnectionEditPolicy;
import com.vainolo.phd.opp.editor.policy.OPMNamedEntityDirectEditPolicy;
import com.vainolo.phd.opp.editor.policy.OPMProceduralLinkEditPolicy;
import com.vainolo.phd.opp.validation.OPMProceduralLinkValidator;

/**
 * An extension of a {@link OPMLinkEditPart} used for {@link OPMProceduralLink}
 * instances. It add endpoint decorations to the regular link figure.
 * 
 * @author vainolo
 * 
 */
public class OPMProceduralLinkEditPart extends OPMLinkEditPart {

  // private Label centerDecorationLabel;

  public OPMProceduralLinkEditPart() {
    super();
  }

  /**
   * Extend the connection created by {@link OPMLinkEditPart#createFigure()} by
   * adding decorations depending on the link kind. An agent link is decorated
   * at the target with black filled {@link CircleDecoration}. An instrument
   * link is decorated at the target with a white filled
   * {@link CircleDecoration}. A consumption or result link is decorated at the
   * target with a {@link PolylineDecoration} (which is an arrow). An effect
   * link link is decorated at the source and target with a
   * {@link PolylineDecoration}.
   * 
   * @return a decorated {@link PolylineConnection} figure.
   */
  @Override
  protected PolylineConnection createFigure() {
    OPMProceduralLink model = (OPMProceduralLink) getModel();
    PolylineConnection connection = new OPMProceduralLinkFigure(model.getKind());
    return connection;
  }

  @Override
  public OPMProceduralLinkFigure getFigure() {
    return OPMProceduralLinkFigure.class.cast(super.getFigure());
  }

  @Override
  public OPMProceduralLink getModel() {
    // TODO Auto-generated method stub
    return OPMProceduralLink.class.cast(super.getModel());
  }

  @Override
  protected void refreshVisuals() {
    super.refreshVisuals();
    OPMProceduralLink model = (OPMProceduralLink) getModel();
    getFigure().getCenterDecorationLabel().setText(model.getCenterDecoration());
    if(model.getSubKinds().size() != 0) {
      String subKindLabel = model.getSubKinds().toString();
      subKindLabel = subKindLabel.substring(1, subKindLabel.length() - 1);
      subKindLabel = subKindLabel.replace(" ", "");
      getFigure().setSubKindLabelText(subKindLabel);
      // getFigure().getSubkindLabel().setText(subKindLabel);
    } else {
      getFigure().setSubKindLabelText("");
    }

    Connection connection = getConnectionFigure();
    List<Point> modelConstraint = getModel().getBendpoints();
    List<AbsoluteBendpoint> figureConstraint = new ArrayList<AbsoluteBendpoint>();
    for(Point p : modelConstraint) {
      figureConstraint.add(new AbsoluteBendpoint(p));
    }
    connection.setRoutingConstraint(figureConstraint);

  }

  @Override
  protected void createEditPolicies() {
    super.createEditPolicies();
    installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new OPMLinkBendpointEditPolicy());
    installEditPolicy(EditPolicy.CONNECTION_ROLE, new OPMLinkConnectionEditPolicy());
    installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new OPMNamedEntityDirectEditPolicy());
    installEditPolicy(OPMProceduralLinkEditPolicy.PROCEDURAL_LINK_EDIT_ROLE, new OPMProceduralLinkEditPolicy(
        new OPMProceduralLinkValidator()));
  }

  @Override
  public void performRequest(final Request req) {
    if(req.getType() == RequestConstants.REQ_OPEN)
      DirectEditDelegate.performDirectEditing(this, ((OPMNamedElementFigure) getFigure()).getNameFigure());
  }

}
