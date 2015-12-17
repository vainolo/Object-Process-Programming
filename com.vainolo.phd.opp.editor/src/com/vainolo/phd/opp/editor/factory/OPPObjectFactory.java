/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
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
