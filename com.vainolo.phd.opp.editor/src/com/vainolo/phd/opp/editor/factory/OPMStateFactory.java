/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMState;

public class OPMStateFactory implements CreationFactory {

  private OPMIdManager idManager;

  public OPMStateFactory(OPMIdManager idManager) {
    this.idManager = idManager;
  }

  @Override
  public Object getNewObject() {
    OPMState state = OPMFactory.eINSTANCE.createOPMState();
    state.setId(idManager.getNextId());
    return state;
  }

  @Override
  public Object getObjectType() {
    return OPMState.class;
  }

}
