/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opp.model.OPPLabel;
import com.vainolo.phd.opp.model.OPPFactory;

public class OPPLabelFactory implements CreationFactory {

  private OPPIdManager idManager;

  public OPPLabelFactory(OPPIdManager idManager) {
    this.idManager = idManager;
  }

  @Override
  public Object getNewObject() {
    OPPLabel label = OPPFactory.eINSTANCE.createOPPLabel();
    label.setId(idManager.getNextId());
    return label;
  }

  @Override
  public Object getObjectType() {
    return OPPLabel.class;
  }

}
