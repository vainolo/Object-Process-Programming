/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMProcessKind;

public class OPMProcessFactory implements CreationFactory {

  private OPMIdManager idManager;

  public OPMProcessFactory(OPMIdManager idManager) {
    this.idManager = idManager;
  }

  @Override
  public Object getNewObject() {
    OPMProcess process = OPMFactory.eINSTANCE.createOPMProcess();
    process.setKind(OPMProcessKind.BUILT_IN);
    process.setId(idManager.getNextId());
    return process;
  }

  @Override
  public Object getObjectType() {
    return OPMProcess.class;
  }

}
