/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.*;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;

import com.vainolo.phd.opm.gef.editor.figure.CircleDecoration;
import com.vainolo.phd.opm.gef.editor.figure.OPMNamedElementFigure;
import com.vainolo.phd.opm.gef.editor.figure.OPMProceduralLinkFigure;
import com.vainolo.phd.opm.gef.editor.part.delegates.DirectEditDelegate;
import com.vainolo.phd.opm.gef.editor.policy.OPMNamedEntityDirectEditPolicy;
import com.vainolo.phd.opm.gef.editor.policy.OPMProceduralLinkEditPolicy;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.validation.OPMProceduralLinkValidator;

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
  protected void refreshVisuals() {
    OPMProceduralLink model = (OPMProceduralLink) getModel();
    getFigure().getCenterDecorationLabel().setText(model.getCenterDecoration());
    if(model.getSubKinds().size() != 0) {
      String subKindLabel = model.getSubKinds().toString();
      subKindLabel = subKindLabel.substring(1, subKindLabel.length() - 1);
      subKindLabel = subKindLabel.replace(" ", "");
      getFigure().getSubkindLabel().setText(subKindLabel);
    } else
      getFigure().getSubkindLabel().setText("");
    super.refreshVisuals();
  }

  @Override
  protected void createEditPolicies() {
    super.createEditPolicies();
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
