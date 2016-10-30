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

import com.vainolo.phd.opp.interpreter.OPPObjectInstance;

public class OPPAddPartProcessInstanceTest {

  private String stringValue = "hello";
  private BigDecimal numericalValue = new BigDecimal(5);
  private OPPObjectInstance compositeInstance1, compositeInstance2;
  private OPPObjectInstance numericInstance;
  private OPPObjectInstance stringInstance;
  private OPPAddPartProcessInstance setPartProcessInstance;

  private OPPObjectInstance doTest(OPPObjectInstance composite, OPPObjectInstance key, OPPObjectInstance value) throws Exception {
    setPartProcessInstance.setArgument("object", composite);
    setPartProcessInstance.setArgument("key", key);
    setPartProcessInstance.setArgument("part", value);
    setPartProcessInstance.call();
    return setPartProcessInstance.getArgument("new object");
  }

  @Test
  public void test_addPart_byStringInstance() throws Exception {
    OPPObjectInstance result = doTest(compositeInstance1, stringInstance, numericInstance);
    assertEquals(numericInstance.getNumericalValue(), result.getPart(stringInstance.getStringValue()).getNumericalValue());
  }

  @Test
  public void test_addPart_byNumberInstance() throws Exception {
    OPPObjectInstance result = doTest(compositeInstance1, numericInstance, stringInstance);
    assertEquals(stringInstance.getStringValue(), result.getPart(numericInstance.getStringValue()).getStringValue());
  }

  @Test
  public void test_addPart_byInstance() throws Exception {
    OPPObjectInstance result = doTest(compositeInstance1, compositeInstance2, numericInstance);
    // assertEquals(numericInstance.getNumericalValue(),
    // result.getPart(compositeInstance2.getInternalId()).getNumericalValue());
  }

  @Before
  public void setup() {
    compositeInstance1 = OPPObjectInstance.createCompositeInstance();
    compositeInstance2 = OPPObjectInstance.createCompositeInstance();
    numericInstance = OPPObjectInstance.createFromValue(numericalValue);
    stringInstance = OPPObjectInstance.createFromValue(stringValue);

    setPartProcessInstance = new OPPAddPartProcessInstance();
  }

}
