/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
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
