package com.vainolo.phd.opp.interpreter.builtin.composite;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPRuntimeException;

public class OPPRemoveFirstPartProcessInstanceTest {

  private String stringValue = "hello";
  private BigDecimal numericalValue = new BigDecimal(5);
  private OPPObjectInstance compositeInstance1, compositeInstance2;
  private OPPObjectInstance numericInstance;
  private OPPObjectInstance stringInstance;
  private OPPRemoveFirstPartProcessInstance removeFirstPartProcessInstance;

  @Test
  public void test_removeFirstPart() throws Exception {
    compositeInstance1.addFirstPart(numericInstance);
    removeFirstPartProcessInstance.setArgument("whole", compositeInstance1);
    removeFirstPartProcessInstance.call();
    OPPObjectInstance first = removeFirstPartProcessInstance.getArgument("first");
    assertEquals(numericInstance.getNumericalValue(), first.getNumericalValue());
    OPPObjectInstance newWhole = removeFirstPartProcessInstance.getArgument("new whole");
    assertEquals(0, newWhole.getAllParts().size());
  }

  @Test
  public void test_removeFirstPartTwice() throws Exception {
    compositeInstance1.addFirstPart(numericInstance);
    compositeInstance1.addFirstPart(stringInstance);
    removeFirstPartProcessInstance.setArgument("whole", compositeInstance1);
    removeFirstPartProcessInstance.call();
    OPPObjectInstance first = removeFirstPartProcessInstance.getArgument("first");
    assertEquals(stringInstance.getStringValue(), first.getStringValue());
    OPPObjectInstance newWhole = removeFirstPartProcessInstance.getArgument("new whole");
    removeFirstPartProcessInstance.setArgument("whole", newWhole);
    removeFirstPartProcessInstance.call();
    first = removeFirstPartProcessInstance.getArgument("first");
    assertEquals(numericInstance.getNumericalValue(), first.getNumericalValue());
    newWhole = removeFirstPartProcessInstance.getArgument("new whole");
    assertEquals(0, newWhole.getAllParts().size());
  }

  @Test
  public void test_removeFirstPart_noParts() throws Exception {
    removeFirstPartProcessInstance.setArgument("whole", compositeInstance1);
    removeFirstPartProcessInstance.call();
    OPPObjectInstance first = removeFirstPartProcessInstance.getArgument("first");
    assertNull(first);
  }

  @Before
  public void setup() {
    compositeInstance1 = OPPObjectInstance.createCompositeInstance();
    compositeInstance2 = OPPObjectInstance.createCompositeInstance();
    numericInstance = OPPObjectInstance.createFromValue(numericalValue);
    stringInstance = OPPObjectInstance.createFromValue(stringValue);

    removeFirstPartProcessInstance = new OPPRemoveFirstPartProcessInstance();
  }

}
