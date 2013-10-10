/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMSystemOPDExecutableInstanceTest {

  private OPMExecutableInstance executableInstance;
  private OPMObjectProcessDiagram opd;

  @Test
  public void singleProcessTest() {
    executableInstance = OPMExecutableInstanceFactory.createExecutableInstance(opd);
  }

  @Before
  public void setUp() {
    opd = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();
    opd.setName("Hello");
    opd.setKind(OPMObjectProcessDiagramKind.SYSTEM);
  }
}