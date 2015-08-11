/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMLink;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMLinkFactory implements CreationFactory {

  private OPMIdManager idManager;

  public OPMLinkFactory(OPMIdManager idManager) {
    this.idManager = idManager;
  }

  @Override
  public OPMLink getNewObject() {
    OPMLink link = OPMFactory.eINSTANCE.createOPMLink();
    link.setId(idManager.getNextId());
    return link;
  }

  @Override
  public Object getObjectType() {
    return OPMLink.class;
  }

}
