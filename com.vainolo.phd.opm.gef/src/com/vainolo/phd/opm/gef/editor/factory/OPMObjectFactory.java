/*******************************************************************************
 * This is me!!!
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObject;

public class OPMObjectFactory implements CreationFactory {

  @Override
  public Object getNewObject() {
    OPMObject object = OPMFactory.eINSTANCE.createOPMObject();
    object.setId(OPMIdManager.getNextId());
    return object;
  }

  @Override
  public Object getObjectType() {
    return OPMObject.class;
  }

}
