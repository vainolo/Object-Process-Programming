/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.vainolo.phd.opm.model.Label;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMState;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregator;

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
      // It is important for OPMProceduralLink to be before OPMLink because they have an is-a relation and we would get
      // the wrong EditPart if the order is changed.
      part = new OPMProceduralLinkEditPart();
    } else if(model instanceof OPMLink) {
      part = new OPMLinkEditPart();
    } else if(model instanceof OPMStructuralLinkAggregator) {
      part = new OPMStructuralLinkAggregatorEditPart();
    } else if(model instanceof OPMState) {
      part = new OPMStateEditPart();
    } else if(model instanceof Label) {
      part = new LabelEditPart();
    } else {
      throw new IllegalArgumentException("Model class " + model.getClass() + " not supported yet.");
    }

    if(part != null) {
      part.setModel(model);
    }

    return part;
  }
}
