/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.part;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.vainolo.phd.opm.model.*;

public class OPMEditPartFactory implements EditPartFactory {

  @Override
  public EditPart createEditPart(EditPart context, Object model) {
    EditPart part = null;

    if(model instanceof OPMObjectProcessDiagram) {
      part = new OPMObjectProcessDiagramEditPart();
    } else if(model instanceof OPMObject) {
      part = new OPMObjectEditPart();
    } else if(model instanceof OPMProcess) {
      part = new OPMProcessEditPart();
    } else if(model instanceof OPMProceduralLink) {
      part = new OPMProceduralLinkEditPart();
    } else if(model instanceof OPMStructuralLink) {
      part = new OPMStructuralLinkEditPart();
    } else if(model instanceof OPMStructuralLinkAggregator) {
      part = new OPMStructuralLinkAggregatorEditPart();
    } else if(model instanceof OPMState) {
      part = new OPMStateEditPart();
    } else if(model instanceof Label) {
      part = new OPMLabelEditPart();
    } else {
      throw new IllegalArgumentException("Model class " + model.getClass() + " not supported yet.");
    }

    if(part != null) {
      part.setModel(model);
    }

    return part;
  }
}
