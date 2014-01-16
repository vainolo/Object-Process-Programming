/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstanceTest;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMAddProcessInstanceTest extends OPMAbstractProcessInstanceTest {

  @Test
  public void test_execute() {
    final OPMAddProcessInstance instance = new OPMAddProcessInstance();

    instance.setArgument("a", OPMObjectInstance.create(1));
    instance.setArgument("b", OPMObjectInstance.create(2));

//    instance.execute();

//    final int value = (Integer) instance.getArgument("c");
//    assertEquals(3, value);

  }
}