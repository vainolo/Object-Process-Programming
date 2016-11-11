/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter;

import java.math.BigDecimal;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance.InstanceKind;

import static org.junit.Assert.*;

public class OPPObjectInstanceTest {

  OPPObjectInstance instance1, instance2, instance3;;
  OPPObjectInstance composite1, composite2, composite3, collection1, collection2, collection3;
  BigDecimal number1, number2, number3;
  String string1, string2, string3;
  String state1, state2, state3;

  // Value instance tests
  @Test
  public void test_CreateNumericalInstance() {
    instance1 = OPPObjectInstance.createFromValue(number1);
    assertEquals(number1, instance1.getValue());
  }

  @Test
  public void test_CreateStringInstance() {
    instance1 = OPPObjectInstance.createFromValue(string1);
    assertEquals(string1, instance1.getValue());
  }

  @Test
  public void test_getValueFromNumericalInstance() {
    instance1 = OPPObjectInstance.createFromValue(number1);
    assertEquals(number1, instance1.getNumericalValue());
  }

  public void test_getValueFromNumbericalStringInstance() {
    instance1 = OPPObjectInstance.createFromValue(number1.toString());
    assertEquals(number1, instance1.getNumericalValue());
  }

  @Test
  public void test_getNumericalValueFromStringInstance() {
    instance1 = OPPObjectInstance.createFromValue(string1);
    assertEquals(string1, instance1.getStringValue());
  }

  @Test
  public void test_getStringValueFromNumericalInstance() {
    instance1 = OPPObjectInstance.createFromValue(number1);
    assertEquals(number1.toString(), instance1.getStringValue());
  }

  @Before
  public void setUp() {
    Random r = new Random();
    number1 = new BigDecimal(r.nextInt());
    number2 = new BigDecimal(r.nextInt());
    number3 = new BigDecimal(r.nextInt());
    string1 = (new BigDecimal(r.nextInt())).toString();
    string2 = (new BigDecimal(r.nextInt())).toString();
    string3 = (new BigDecimal(r.nextInt())).toString();
    state1 = (new BigDecimal(r.nextInt())).toString();
    state2 = (new BigDecimal(r.nextInt())).toString();
    state3 = (new BigDecimal(r.nextInt())).toString();

    composite1 = OPPObjectInstance.createCompositeInstance();
    composite2 = OPPObjectInstance.createCompositeInstance();
    composite3 = OPPObjectInstance.createCompositeInstance();
  }
}
