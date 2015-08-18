/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPState;

public class OPPStateFactory implements CreationFactory {

  private OPPIdManager idManager;

  public OPPStateFactory(OPPIdManager idManager) {
    this.idManager = idManager;
  }

  @Override
  public Object getNewObject() {
    OPPState state = OPPFactory.eINSTANCE.createOPPState();
    state.setId(idManager.getNextId());
    return state;
  }

  @Override
  public Object getObjectType() {
    return OPPState.class;
  }

}
