/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstanceTest;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;
import com.vainolo.phd.opm.interpreter.OPMRuntimeException;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMAddProcessInstanceTest extends OPMAbstractProcessInstanceTest {

  @Test
  public void test_execute_lowerCaseArguments() throws Exception {
    final OPMAddProcessInstance instance = new OPMAddProcessInstance();

    instance.setArgument("a", OPMObjectInstance.createFromValue(new BigDecimal(1)));
    instance.setArgument("b", OPMObjectInstance.createFromValue(new BigDecimal(2)));

    instance.call();

    BigDecimal value = instance.getArgument("c").getNumericalValue();
    assertEquals(3, value.intValue());
  }

  @Test
  public void test_execute_upercaseCaseArguments() throws Exception {
    final OPMAddProcessInstance instance = new OPMAddProcessInstance();

    instance.setArgument("A", OPMObjectInstance.createFromValue(new BigDecimal(1)));
    instance.setArgument("B", OPMObjectInstance.createFromValue(new BigDecimal(2)));

    instance.call();

    BigDecimal value = instance.getArgument("C").getNumericalValue();
    assertEquals(3, value.intValue());
  }

  @Test
  public void test_execute_mixedCaseArguments() throws Exception {
    final OPMAddProcessInstance instance = new OPMAddProcessInstance();

    instance.setArgument("A", OPMObjectInstance.createFromValue(new BigDecimal(1)));
    instance.setArgument("b", OPMObjectInstance.createFromValue(new BigDecimal(2)));

    instance.call();

    BigDecimal value = instance.getArgument("C").getNumericalValue();
    assertEquals(3, value.intValue());
  }

  @Test(expected = OPMRuntimeException.class)
  public void test_execute_illegalArguments() throws Exception {
    final OPMAddProcessInstance instance = new OPMAddProcessInstance();

    instance.setArgument("X", OPMObjectInstance.createFromValue(new BigDecimal(1)));
    instance.setArgument("Y", OPMObjectInstance.createFromValue(new BigDecimal(2)));

    instance.call();
  }

}