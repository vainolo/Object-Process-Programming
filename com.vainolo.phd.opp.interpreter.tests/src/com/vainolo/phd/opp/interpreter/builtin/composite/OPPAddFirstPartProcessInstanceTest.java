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

public class OPPAddFirstPartProcessInstanceTest {

  private BigDecimal numericalValue = new BigDecimal(5);
  private OPPObjectInstance compositeInstance1;
  private OPPObjectInstance numericInstance;
  private OPPAddFirstPartProcessInstance addFirstPartProcessInstance;

  @Test
  public void test_addFirstPart() throws Exception {
    addFirstPartProcessInstance.setArgument("object", compositeInstance1);
    addFirstPartProcessInstance.setArgument("part", numericInstance);
    addFirstPartProcessInstance.call();
    OPPObjectInstance result = addFirstPartProcessInstance.getArgument("new object");
    assertEquals(numericInstance.getNumericalValue(), result.getFirstPart().getNumericalValue());
  }

  @Before
  public void setup() {
    compositeInstance1 = OPPObjectInstance.createCompositeInstance();
    numericInstance = OPPObjectInstance.createFromValue(numericalValue);

    addFirstPartProcessInstance = new OPPAddFirstPartProcessInstance();
  }

}
