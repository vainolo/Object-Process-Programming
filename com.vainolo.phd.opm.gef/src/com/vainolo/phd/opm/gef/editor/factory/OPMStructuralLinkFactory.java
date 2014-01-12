/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMStructuralLink;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMStructuralLinkFactory implements CreationFactory {

  private OPMIdManager idManager;

  public OPMStructuralLinkFactory(OPMIdManager idManager) {
    this.idManager = idManager;
  }

  @Override
  public OPMStructuralLink getNewObject() {
    OPMStructuralLink link = OPMFactory.eINSTANCE.createOPMStructuralLink();
    link.setId(idManager.getNextId());
    return link;
  }

  @Override
  public Object getObjectType() {
    return OPMStructuralLink.class;
  }

}
