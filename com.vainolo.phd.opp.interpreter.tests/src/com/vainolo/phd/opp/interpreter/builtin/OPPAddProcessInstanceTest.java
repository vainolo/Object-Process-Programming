/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstanceTest;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPRuntimeException;
import com.vainolo.phd.opp.interpreter.builtin.OPPAddProcessInstance;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPPAddProcessInstanceTest extends OPPAbstractProcessInstanceTest {

  @Test
  public void test_execute_lowerCaseArguments() throws Exception {
    final OPPAddProcessInstance instance = new OPPAddProcessInstance();

    instance.setArgument("a", OPPObjectInstance.createFromValue(new BigDecimal(1)));
    instance.setArgument("b", OPPObjectInstance.createFromValue(new BigDecimal(2)));

    instance.call();

    BigDecimal value = instance.getArgument("c").getNumericalValue();
    assertEquals(3, value.intValue());
  }

  @Test
  public void test_execute_upercaseCaseArguments() throws Exception {
    final OPPAddProcessInstance instance = new OPPAddProcessInstance();

    instance.setArgument("A", OPPObjectInstance.createFromValue(new BigDecimal(1)));
    instance.setArgument("B", OPPObjectInstance.createFromValue(new BigDecimal(2)));

    instance.call();

    BigDecimal value = instance.getArgument("C").getNumericalValue();
    assertEquals(3, value.intValue());
  }

  @Test
  public void test_execute_mixedCaseArguments() throws Exception {
    final OPPAddProcessInstance instance = new OPPAddProcessInstance();

    instance.setArgument("A", OPPObjectInstance.createFromValue(new BigDecimal(1)));
    instance.setArgument("b", OPPObjectInstance.createFromValue(new BigDecimal(2)));

    instance.call();

    BigDecimal value = instance.getArgument("C").getNumericalValue();
    assertEquals(3, value.intValue());
  }

  @Test(expected = OPPRuntimeException.class)
  public void test_execute_illegalArguments() throws Exception {
    final OPPAddProcessInstance instance = new OPPAddProcessInstance();

    instance.setArgument("X", OPPObjectInstance.createFromValue(new BigDecimal(1)));
    instance.setArgument("Y", OPPObjectInstance.createFromValue(new BigDecimal(2)));

    instance.call();
  }

}