/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opp.model.OPPLabel;
import com.vainolo.phd.opp.model.OPPFactory;

public class OPPLabelFactory implements CreationFactory {

  private OPPIdManager idManager;

  public OPPLabelFactory(OPPIdManager idManager) {
    this.idManager = idManager;
  }

  @Override
  public Object getNewObject() {
    OPPLabel label = OPPFactory.eINSTANCE.createOPPLabel();
    label.setId(idManager.getNextId());
    return label;
  }

  @Override
  public Object getObjectType() {
    return OPPLabel.class;
  }

}
