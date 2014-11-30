package com.vainolo.phd.opm.interpreter;

import java.math.BigDecimal;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opm.interpreter.OPMObjectInstance.InstanceType;

import static org.junit.Assert.*;

public class OPMObjectInstanceTest {

  OPMObjectInstance instance1, instance2, instance3;;
  OPMObjectInstance composite1, composite2, composite3, collection1, collection2, collection3;
  BigDecimal number1, number2, number3;
  String string1, string2, string3;
  String state1, state2, state3;

  // Value instance tests
  @Test
  public void test_CreateNumericalInstance() {
    instance1 = OPMObjectInstance.createFromValue(number1);
    assertEquals(number1, instance1.getValue());
  }

  @Test
  public void test_CreateStringInstance() {
    instance1 = OPMObjectInstance.createFromValue(string1);
    assertEquals(string1, instance1.getValue());
  }

  @Test
  public void test_getValueFromNumericalInstance() {
    instance1 = OPMObjectInstance.createFromValue(number1);
    assertEquals(number1, instance1.getNumericalValue());
  }

  public void test_getValueFromNumbericalStringInstance() {
    instance1 = OPMObjectInstance.createFromValue(number1.toString());
    assertEquals(number1, instance1.getNumericalValue());
  }

  @Test
  public void test_getNumericalValueFromStringInstance() {
    instance1 = OPMObjectInstance.createFromValue(string1);
    assertEquals(string1, instance1.getStringValue());
  }

  @Test
  public void test_getStringValueFromNumericalInstance() {
    instance1 = OPMObjectInstance.createFromValue(number1);
    assertEquals(number1.toString(), instance1.toString());
  }

  // Compound instance tests
  @Test
  public void test_AddPartsToCompoundInstance() {
    instance1 = OPMObjectInstance.createFromValue(state1);
    instance2 = OPMObjectInstance.createFromValue(string1);
    composite1.addCompositePart("part1", instance1);
    composite1.addCompositePart("part2", instance2);

    assertEquals(InstanceType.COMPOSITE, composite1.type);
    assertEquals(composite1.getCompositeParts().size(), 2);
    assertEquals(composite1.getCompositePart("part1"), instance1);
    assertEquals(composite1.getCompositePart("part2"), instance2);
  }

  @Test(expected = IllegalStateException.class)
  public void test_GetValueFromCompountInstance_ExpectException() {
    composite1.getValue();
  }

  @Test(expected = IllegalStateException.class)
  public void test_GetPartsFromValueInstance_ExpectException() {
    instance1 = OPMObjectInstance.createFromValue(number1);
    instance1.getCompositeParts();
  }

  @Test(expected = IllegalStateException.class)
  public void test_AddPartToValueInstance_ExpectException() {
    instance1 = OPMObjectInstance.createFromValue(number1);
    instance2 = OPMObjectInstance.createFromValue(number1);
    instance1.addCompositePart("name", instance2);
  }

  @Test(expected = IllegalStateException.class)
  public void test_AddPartToStateInstance_ExpectException() {
    instance1 = OPMObjectInstance.createFromValue(state1);
    instance2 = OPMObjectInstance.createFromValue(number1);
    instance1.addCompositePart("name", instance2);
  }

  @Test
  public void test_CompoundInstanceToString() {
    instance1 = OPMObjectInstance.createFromValue(number1);
    composite1.addCompositePart("part1", instance1);
    assertEquals("{part1:" + instance1.toString() + "}", composite1.toString());

  }

  // Collection instance tests
  @Test
  public void test_CreateCollectionAddInstanceAndGetFirstElement() {
    instance1 = OPMObjectInstance.createCollectionInstace();
    instance2 = OPMObjectInstance.createFromValue(number1);
    instance1.appendCollectionElement(instance2);
    assertEquals(instance2.getValue(), instance1.getFirstCollectionElement().getValue());
  }

  public void test_CreateCollectionAddInstanceAndGetLastElement() {
    instance1 = OPMObjectInstance.createCollectionInstace();
    instance2 = OPMObjectInstance.createFromValue(number1);
    instance1.appendCollectionElement(instance2);
    assertEquals(instance2.getValue(), instance1.getLastCollectionElement().getValue());
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

    composite1 = OPMObjectInstance.createCompositeInstance();
    composite2 = OPMObjectInstance.createCompositeInstance();
    composite3 = OPMObjectInstance.createCompositeInstance();
  }
}
