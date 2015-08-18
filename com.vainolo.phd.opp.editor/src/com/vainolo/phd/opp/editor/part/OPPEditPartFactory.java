/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.part;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.vainolo.phd.opp.model.*;

public class OPPEditPartFactory implements EditPartFactory {

  @Override
  public EditPart createEditPart(EditPart context, Object model) {
    EditPart part = null;

    if(model instanceof OPPObjectProcessDiagram) {
      part = new OPPObjectProcessDiagramEditPart();
    } else if(model instanceof OPPObject) {
      part = new OPPObjectEditPart();
    } else if(model instanceof OPPProcess) {
      part = new OPPProcessEditPart();
    } else if(model instanceof OPPProceduralLink) {
      part = new OPPProceduralLinkEditPart();
    } else if(model instanceof OPPStructuralLinkPart) {
      part = new OPPStructuralLinkEditPart();
    } else if(model instanceof OPPStructuralLinkAggregator) {
      part = new OPPStructuralLinkAggregatorEditPart();
    } else if(model instanceof OPPState) {
      part = new OPPStateEditPart();
    } else if(model instanceof OPPLabel) {
      part = new OPPLabelEditPart();
    } else {
      throw new IllegalArgumentException("Model class " + model.getClass() + " not supported yet.");
    }

    if(part != null) {
      part.setModel(model);
    }

    return part;
  }
}
