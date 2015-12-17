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
import com.vainolo.phd.opp.interpreter.OPPRuntimeException;

public class OPPRemovePartProcessInstanceTest {

  private String stringValue = "hello";
  private BigDecimal numericalValue = new BigDecimal(5);
  private OPPObjectInstance compositeInstance1;
  private OPPObjectInstance numericInstance;
  private OPPObjectInstance stringInstance;
  private OPPRemovePartProcessInstance removePartProcessInstance;

  @Test
  public void test_removePart() throws Exception {
    compositeInstance1.addPart(numericInstance.getStringValue(), stringInstance);
    removePartProcessInstance.setArgument("object", compositeInstance1);
    removePartProcessInstance.setArgument("key", numericInstance);
    removePartProcessInstance.call();
    OPPObjectInstance part = removePartProcessInstance.getArgument("part");
    OPPObjectInstance newWhole = removePartProcessInstance.getArgument("new object");

    assertEquals(stringValue, part.getStringValue());
    assertEquals(0, newWhole.getAllParts().size());
  }

  @Test(expected = OPPRuntimeException.class)
  public void test_removePart_noParts() throws Exception {
    removePartProcessInstance.setArgument("whole", compositeInstance1);
    removePartProcessInstance.setArgument("key", numericInstance);
    removePartProcessInstance.call();
  }

  @Before
  public void setup() {
    compositeInstance1 = OPPObjectInstance.createCompositeInstance();
    numericInstance = OPPObjectInstance.createFromValue(numericalValue);
    stringInstance = OPPObjectInstance.createFromValue(stringValue);

    removePartProcessInstance = new OPPRemovePartProcessInstance();
  }

}
