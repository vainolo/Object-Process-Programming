/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.part;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.vainolo.phd.opp.model.*;

public class OPPEditPartFactory implements EditPartFactory {

  @Override
  public EditPart createEditPart(EditPart context, Object model) {
    EditPart part;

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
