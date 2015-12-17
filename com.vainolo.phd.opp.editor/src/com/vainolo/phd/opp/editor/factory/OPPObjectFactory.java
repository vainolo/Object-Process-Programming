/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPObject;

public class OPPObjectFactory implements CreationFactory {

  private OPPIdManager idManager;

  public OPPObjectFactory(OPPIdManager idManager) {
    this.idManager = idManager;
  }

  @Override
  public Object getNewObject() {
    OPPObject object = OPPFactory.eINSTANCE.createOPPObject();
    object.setConstraints(0, 0, 20, 20);
    object.setId(idManager.getNextId());
    return object;
  }

  @Override
  public Object getObjectType() {
    return OPPObject.class;
  }

}
