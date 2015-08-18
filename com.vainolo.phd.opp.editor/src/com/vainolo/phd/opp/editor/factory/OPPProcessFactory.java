/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
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
