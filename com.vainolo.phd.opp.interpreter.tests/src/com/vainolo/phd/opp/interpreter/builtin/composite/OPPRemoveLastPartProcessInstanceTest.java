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

public class OPPRemoveLastPartProcessInstanceTest {

  private String stringValue = "hello";
  private BigDecimal numericalValue = new BigDecimal(5);
  private OPPObjectInstance compositeInstance1;
  private OPPObjectInstance numericInstance;
  private OPPObjectInstance stringInstance;
  private OPPRemoveLastPartProcessInstance removeLastPartProcessInstance;

  @Test
  public void test_removeLastPart() throws Exception {
    compositeInstance1.addFirstPart(numericInstance);
    removeLastPartProcessInstance.setArgument("object", compositeInstance1);
    removeLastPartProcessInstance.call();
    OPPObjectInstance last = removeLastPartProcessInstance.getArgument("part");
    assertEquals(numericInstance.getNumericalValue(), last.getNumericalValue());
    OPPObjectInstance newWhole = removeLastPartProcessInstance.getArgument("new object");
    assertEquals(0, newWhole.getAllParts().size());
  }

  @Test
  public void test_removeFirstPartTwice() throws Exception {
    compositeInstance1.addFirstPart(stringInstance);
    compositeInstance1.addFirstPart(numericInstance);
    removeLastPartProcessInstance.setArgument("object", compositeInstance1);
    removeLastPartProcessInstance.call();
    OPPObjectInstance last = removeLastPartProcessInstance.getArgument("part");
    assertEquals(stringInstance.getStringValue(), last.getStringValue());
    OPPObjectInstance newWhole = removeLastPartProcessInstance.getArgument("new object");
    removeLastPartProcessInstance.setArgument("object", newWhole);
    removeLastPartProcessInstance.call();
    last = removeLastPartProcessInstance.getArgument("part");
    assertEquals(numericInstance.getNumericalValue(), last.getNumericalValue());
    newWhole = removeLastPartProcessInstance.getArgument("new object");
    assertEquals(0, newWhole.getAllParts().size());
  }

  @Before
  public void setup() {
    compositeInstance1 = OPPObjectInstance.createCompositeInstance();
    numericInstance = OPPObjectInstance.createFromValue(numericalValue);
    stringInstance = OPPObjectInstance.createFromValue(stringValue);

    removeLastPartProcessInstance = new OPPRemoveLastPartProcessInstance();
  }

}
