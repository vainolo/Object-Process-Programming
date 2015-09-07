package com.vainolo.phd.opp.interpreter.builtin.composite;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opp.interpreter.OPPObjectInstance;

public class OPPAddFirstPartProcessInstanceTest {

  private BigDecimal numericalValue = new BigDecimal(5);
  private OPPObjectInstance compositeInstance1;
  private OPPObjectInstance numericInstance;
  private OPPAddFirstPartProcessInstance addFirstPartProcessInstance;

  @Test
  public void test_addFirstPart() throws Exception {
    addFirstPartProcessInstance.setArgument("whole", compositeInstance1);
    addFirstPartProcessInstance.setArgument("part", numericInstance);
    addFirstPartProcessInstance.call();
    OPPObjectInstance result = addFirstPartProcessInstance.getArgument("new whole");
    assertEquals(numericInstance.getNumericalValue(), result.getFirstPart().getNumericalValue());
  }

  @Before
  public void setup() {
    compositeInstance1 = OPPObjectInstance.createCompositeInstance();
    numericInstance = OPPObjectInstance.createFromValue(numericalValue);

    addFirstPartProcessInstance = new OPPAddFirstPartProcessInstance();
  }

}
