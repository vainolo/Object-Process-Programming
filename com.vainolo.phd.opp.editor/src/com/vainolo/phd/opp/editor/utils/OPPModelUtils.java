/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.utils;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;

public enum OPPModelUtils {
  INSTANCE;

  private OPPFactory factory = OPPFactory.eINSTANCE;

  public OPPObjectProcessDiagram createModel() {
    OPPObjectProcessDiagram opd = factory.createOPPObjectProcessDiagram();
    OPPObject object1 = factory.createOPPObject();
    object1.setName("O1");
    opd.getNodes().add(object1);
    OPPObject object2 = factory.createOPPObject();
    object2.setName("O2");
    opd.getNodes().add(object2);
    OPPProcess process = factory.createOPPProcess();
    process.setName("P1");
    opd.getNodes().add(process);
    OPPLink link = factory.createOPPLink();
    link.setSource(object1);
    link.setTarget(process);
    opd.getLinks().add(link);
    return opd;
  }
}
