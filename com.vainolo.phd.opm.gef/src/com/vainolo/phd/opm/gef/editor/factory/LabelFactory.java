package com.vainolo.phd.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.Label;
import com.vainolo.phd.opm.model.OPMFactory;

public class LabelFactory implements CreationFactory {

  @Override
  public Object getNewObject() {
    Label label = OPMFactory.eINSTANCE.createLabel();
    label.setId(OPMIdManager.getNextId());
    return label;
  }

  @Override
  public Object getObjectType() {
    return Label.class;
  }

}
