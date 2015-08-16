/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.factory;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObject;

public class OPMObjectFactory implements CreationFactory {

  private OPMIdManager idManager;

  public OPMObjectFactory(OPMIdManager idManager) {
    this.idManager = idManager;
  }

  @Override
  public Object getNewObject() {
    OPMObject object = OPMFactory.eINSTANCE.createOPMObject();
    object.setConstraints(new Rectangle(0, 0, 20, 20));
    object.setId(idManager.getNextId());
    return object;
  }

  @Override
  public Object getObjectType() {
    return OPMObject.class;
  }

}
