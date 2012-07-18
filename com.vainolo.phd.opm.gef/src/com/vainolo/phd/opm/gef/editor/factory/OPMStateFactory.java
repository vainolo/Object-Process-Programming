/*******************************************************************************
 * This is me!!!
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMState;

public class OPMStateFactory implements CreationFactory {

  @Override
  public Object getNewObject() {
    OPMState state = OPMFactory.eINSTANCE.createOPMState();
    state.setId(OPMIdManager.getNextId());
    return state;
  }

  @Override
  public Object getObjectType() {
    return OPMState.class;
  }

}
