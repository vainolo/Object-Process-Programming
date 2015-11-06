package com.vainolo.phd.opp.interpreter.builtin.composite;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opp.interpreter.OPPObjectInstance;

public class OPPGetPartProcessInstanceTest {

  private String stringValue = "hello";
  private BigDecimal numericalValue = new BigDecimal(5);
  private OPPObjectInstance compositeInstance;
  private OPPObjectInstance numericPart;
  private OPPObjectInstance stringPart;
  private OPPObjectInstance compositeKey;
  private OPPGetNamedPartProcessInstance getPartProcessInstance;

  private OPPObjectInstance doTest(OPPObjectInstance composite, OPPObjectInstance key) throws Exception {
    getPartProcessInstance.setArgument("whole", composite);
    getPartProcessInstance.setArgument("key", key);
    getPartProcessInstance.call();
    return getPartProcessInstance.getArgument("part");
  }

  @Test
  public void test_getPart_byStringInstance() throws Exception {
    compositeInstance.addPart(stringPart.getStringValue(), numericPart);
    OPPObjectInstance part = doTest(compositeInstance, stringPart);
    assertEquals(numericalValue, part.getNumericalValue());
  }

  @Test
  public void test_getPart_byNumberInstance() throws Exception {
    compositeInstance.addPart(numericPart.getStringValue(), stringPart);
    OPPObjectInstance part = doTest(compositeInstance, numericPart);
    assertEquals(stringValue, part.getStringValue());
  }

  @Test
  public void test_getPart_byInstance() throws Exception {
    compositeInstance.addPart(compositeKey.getId(), numericPart);
    OPPObjectInstance part = doTest(compositeInstance, compositeKey);
    assertEquals(numericalValue, part.getNumericalValue());
  }

  @Before
  public void setup() {
    compositeInstance = OPPObjectInstance.createCompositeInstance();
    numericPart = OPPObjectInstance.createFromValue(numericalValue);
    stringPart = OPPObjectInstance.createFromValue(stringValue);
    compositeKey = OPPObjectInstance.createCompositeInstance();

    getPartProcessInstance = new OPPGetNamedPartProcessInstance();
  }

}
