/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPProcessKind;

public class OPPProcessFactory implements CreationFactory {

  private OPPIdManager idManager;

  public OPPProcessFactory(OPPIdManager idManager) {
    this.idManager = idManager;
  }

  @Override
  public Object getNewObject() {
    OPPProcess process = OPPFactory.eINSTANCE.createOPPProcess();
    process.setKind(OPPProcessKind.BUILT_IN);
    process.setId(idManager.getNextId());
    return process;
  }

  @Override
  public Object getObjectType() {
    return OPPProcess.class;
  }

}
