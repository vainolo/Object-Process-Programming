/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstanceTest;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMProcess;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMAddProcessInstanceTest extends OPMAbstractProcessInstanceTest {

  @Test
  public void testAdd() {
    final OPMProcess process = OPMFactory.eINSTANCE.createOPMProcess();
    final OPMAddProcessInstance instance = new OPMAddProcessInstance();

    instance.setArgument("a", 1);
    instance.setArgument("b", 2);

    // instance.execute();

    final int value = (Integer) instance.getArgument("c");
    assertEquals(3, value);

  }
}