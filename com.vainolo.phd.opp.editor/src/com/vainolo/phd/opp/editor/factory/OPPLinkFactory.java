/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPLink;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPPLinkFactory implements CreationFactory {

  private OPPIdManager idManager;

  public OPPLinkFactory(OPPIdManager idManager) {
    this.idManager = idManager;
  }

  @Override
  public OPPLink getNewObject() {
    OPPLink link = OPPFactory.eINSTANCE.createOPPLink();
    link.setId(idManager.getNextId());
    return link;
  }

  @Override
  public Object getObjectType() {
    return OPPLink.class;
  }

}
