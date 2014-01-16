package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.PolylineConnection;
import com.vainolo.phd.opm.gef.editor.figure.OPMStructuralLinkFigure;

public class OPMStructuralLinkEditPart extends OPMLinkEditPart {

  public OPMStructuralLinkEditPart() {
    super();
  }

  @Override
  protected PolylineConnection createFigure() {
    OPMStructuralLinkFigure figure = new OPMStructuralLinkFigure();
    return figure;
  }

  @Override
  public OPMStructuralLinkFigure getFigure() {
    return OPMStructuralLinkFigure.class.cast(super.getFigure());
  }

  @Override
  protected void refreshVisuals() {
    super.refreshVisuals();
  }

}
