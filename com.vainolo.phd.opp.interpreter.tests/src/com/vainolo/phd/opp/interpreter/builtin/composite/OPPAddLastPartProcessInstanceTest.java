package com.vainolo.phd.opp.interpreter.builtin.composite;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opp.interpreter.OPPObjectInstance;

public class OPPAddLastPartProcessInstanceTest {

  private BigDecimal numericalValue = new BigDecimal(5);
  private OPPObjectInstance compositeInstance1;
  private OPPObjectInstance numericInstance;
  private OPPAddLastPartProcessInstance addLastPartProcessInstance;

  @Test
  public void test_addLastPart() throws Exception {
    addLastPartProcessInstance.setArgument("object", compositeInstance1);
    addLastPartProcessInstance.setArgument("part", numericInstance);
    addLastPartProcessInstance.call();
    OPPObjectInstance result = addLastPartProcessInstance.getArgument("new object");
    assertEquals(numericInstance.getNumericalValue(), result.getLastPart().getNumericalValue());
  }

  @Before
  public void setup() {
    compositeInstance1 = OPPObjectInstance.createCompositeInstance();
    numericInstance = OPPObjectInstance.createFromValue(numericalValue);

    addLastPartProcessInstance = new OPPAddLastPartProcessInstance();
  }

}
