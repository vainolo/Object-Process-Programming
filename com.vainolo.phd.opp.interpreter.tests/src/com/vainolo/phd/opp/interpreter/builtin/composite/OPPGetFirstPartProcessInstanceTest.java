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

import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPGetFirstPartProcessInstanceTest {

  private BigDecimal numericValue = new BigDecimal(5);
  private String stringValue = "hello";
  private OPPObjectInstance compositeInstance1;
  private OPPObjectInstance numericInstance;
  private OPPObjectInstance stringInstance;
  private OPPGetFirstPartProcessInstance getFirstPartProcessInstance;

  @Test
  public void test_getFirstPart_oneElement() throws Exception {
    compositeInstance1.addFirstPart(numericInstance);
    getFirstPartProcessInstance.setArgument("object", compositeInstance1);
    getFirstPartProcessInstance.call();
    OPPObjectInstance first = getFirstPartProcessInstance.getArgument("part");
    assertEquals(numericValue, first.getNumericalValue());
  }

  @Test
  public void test_getFirstPart_twoElements() throws Exception {
    compositeInstance1.addFirstPart(numericInstance);
    compositeInstance1.addFirstPart(stringInstance);
    getFirstPartProcessInstance.setArgument("object", compositeInstance1);
    getFirstPartProcessInstance.call();
    OPPObjectInstance first = getFirstPartProcessInstance.getArgument("part");
    assertEquals(stringValue, first.getStringValue());

  }

  @Before
  public void setup() {
    compositeInstance1 = OPPObjectInstance.createCompositeInstance();
    numericInstance = OPPObjectInstance.createFromValue(numericValue);
    stringInstance = OPPObjectInstance.createFromValue(stringValue);
    getFirstPartProcessInstance = new OPPGetFirstPartProcessInstance();
  }

}
