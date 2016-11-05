/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin.composite;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opp.interpreter.OPPRuntimeException;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPGetLastPartProcessInstanceTest {

  private BigDecimal numericalValue = new BigDecimal(5);
  private String stringValue = "hello";
  private OPPObjectInstance compositeInstance1;
  private OPPObjectInstance numericInstance;
  private OPPObjectInstance stringInstance;
  private OPPGetLastPartProcessInstance getLastPartProcessInstance;

  @Test
  public void test_getLastPart_oneElement() throws Exception {
    compositeInstance1.addFirstPart(numericInstance);
    getLastPartProcessInstance.setArgument("object", compositeInstance1);
    getLastPartProcessInstance.call();
    OPPObjectInstance last = getLastPartProcessInstance.getArgument("part");
    assertEquals(numericInstance.getNumericalValue(), last.getNumericalValue());
    assertEquals(1, compositeInstance1.getAllParts().size());
  }

  @Test
  public void test_getLastPart_twoElements() throws Exception {
    compositeInstance1.addLastPart(numericInstance);
    compositeInstance1.addLastPart(stringInstance);
    getLastPartProcessInstance.setArgument("object", compositeInstance1);
    getLastPartProcessInstance.call();
    OPPObjectInstance last = getLastPartProcessInstance.getArgument("part");
    assertEquals(stringInstance.getStringValue(), last.getStringValue());
    assertEquals(2, compositeInstance1.getAllParts().size());
  }

  @Test(expected = OPPRuntimeException.class)
  public void test_getLastPart_noParts() throws Exception {
    getLastPartProcessInstance.setArgument("whole", compositeInstance1);
    getLastPartProcessInstance.call();
  }

  @Before
  public void setup() {
    compositeInstance1 = OPPObjectInstance.createCompositeInstance();
    numericInstance = OPPObjectInstance.createFromValue(numericalValue);
    stringInstance = OPPObjectInstance.createFromValue(stringValue);

    getLastPartProcessInstance = new OPPGetLastPartProcessInstance();
  }

}
