/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPStructuralLinkPart;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPPStructuralLinkPartFactory implements CreationFactory {

  private OPPIdManager idManager;

  public OPPStructuralLinkPartFactory(OPPIdManager idManager) {
    this.idManager = idManager;
  }

  @Override
  public OPPStructuralLinkPart getNewObject() {
    OPPStructuralLinkPart link = OPPFactory.eINSTANCE.createOPPStructuralLinkPart();
    link.setId(idManager.getNextId());
    return link;
  }

  @Override
  public Object getObjectType() {
    return OPPStructuralLinkPart.class;
  }

}
