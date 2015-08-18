package com.vainolo.phd.opp.editor.part;

import org.eclipse.draw2d.PolylineConnection;

import com.vainolo.phd.opp.editor.figure.OPPStructuralLinkFigure;

public class OPPStructuralLinkEditPart extends OPPLinkEditPart {

  public OPPStructuralLinkEditPart() {
    super();
  }

  @Override
  protected PolylineConnection createFigure() {
    OPPStructuralLinkFigure figure = new OPPStructuralLinkFigure();
    return figure;
  }

  @Override
  public OPPStructuralLinkFigure getFigure() {
    return OPPStructuralLinkFigure.class.cast(super.getFigure());
  }

  @Override
  protected void refreshVisuals() {
    super.refreshVisuals();
  }

}
