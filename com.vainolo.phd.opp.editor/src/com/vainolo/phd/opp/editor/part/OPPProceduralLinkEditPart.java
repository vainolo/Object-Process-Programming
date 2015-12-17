/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.*;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;

import com.vainolo.phd.opp.model.OPPPoint;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.editor.figure.OPPCircleDecoration;
import com.vainolo.phd.opp.editor.figure.OPPNamedElementFigure;
import com.vainolo.phd.opp.editor.figure.OPPProceduralLinkFigure;
import com.vainolo.phd.opp.editor.part.delegates.OPPDirectEditDelegate;
import com.vainolo.phd.opp.editor.policy.OPPProceduralLinkBendpointEditPolicy;
import com.vainolo.phd.opp.editor.policy.OPPDeleteLinkEditPolicy;
import com.vainolo.phd.opp.editor.policy.OPPNamedEntityDirectEditPolicy;
import com.vainolo.phd.opp.editor.policy.OPPProceduralLinkEditPolicy;
import com.vainolo.phd.opp.validation.OPPProceduralLinkValidator;

/**
 * An extension of a {@link OPPLinkEditPart} used for {@link OPMProceduralLink} instances. It add endpoint decorations
 * to the regular link figure.
 * 
 * @author vainolo
 * 
 */
public class OPPProceduralLinkEditPart extends OPPLinkEditPart {

  // private Label centerDecorationLabel;

  public OPPProceduralLinkEditPart() {
    super();
  }

  /**
   * Extend the connection created by {@link OPPLinkEditPart#createFigure()} by adding decorations depending on the link
   * kind. An agent link is decorated at the target with black filled {@link OPPCircleDecoration}. An instrument link is
   * decorated at the target with a white filled {@link OPPCircleDecoration}. A consumption or result link is decorated
   * at the target with a {@link PolylineDecoration} (which is an arrow). An effect link link is decorated at the source
   * and target with a {@link PolylineDecoration}.
   * 
   * @return a decorated {@link PolylineConnection} figure.
   */
  @Override
  protected PolylineConnection createFigure() {
    OPPProceduralLink model = (OPPProceduralLink) getModel();
    PolylineConnection connection = new OPPProceduralLinkFigure(model.getKind());
    return connection;
  }

  @Override
  public OPPProceduralLinkFigure getFigure() {
    return OPPProceduralLinkFigure.class.cast(super.getFigure());
  }

  @Override
  public OPPProceduralLink getModel() {
    return OPPProceduralLink.class.cast(super.getModel());
  }

  @Override
  protected void refreshVisuals() {
    super.refreshVisuals();
    OPPProceduralLink model = (OPPProceduralLink) getModel();
    getFigure().getCenterDecorationLabel().setText(model.getCenterDecoration());
    if (model.getSubKinds().size() != 0) {
      String subKindLabel = model.getSubKinds().toString();
      subKindLabel = subKindLabel.substring(1, subKindLabel.length() - 1);
      subKindLabel = subKindLabel.replace(" ", "");
      getFigure().setSubKindLabelText(subKindLabel);
    } else {
      getFigure().setSubKindLabelText("");
    }

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
    installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new OPPProceduralLinkBendpointEditPolicy());
    installEditPolicy(EditPolicy.CONNECTION_ROLE, new OPPDeleteLinkEditPolicy());
    installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new OPPNamedEntityDirectEditPolicy());
    installEditPolicy(OPPProceduralLinkEditPolicy.PROCEDURAL_LINK_EDIT_ROLE, new OPPProceduralLinkEditPolicy(new OPPProceduralLinkValidator()));
  }

  @Override
  public void performRequest(final Request req) {
    if (req.getType() == RequestConstants.REQ_OPEN)
      OPPDirectEditDelegate.performDirectEditing(this, ((OPPNamedElementFigure) getFigure()).getNameFigure());
  }

}
