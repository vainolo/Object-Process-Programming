/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPTransformJSONStringToObjectProcessInstance;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPPReadJSONObjectProcessInstanceTest {

  private OPPObjectInstance readJson(String json) throws Exception {
    OPPTransformJSONStringToObjectProcessInstance instance = new OPPTransformJSONStringToObjectProcessInstance();
    instance.setArgument("json", OPPObjectInstance.createFromValue(json));
    instance.call();
    return instance.getArgument("object");
  }

  @Test
  public void test_execute_intElement() throws Exception {
    OPPObjectInstance instance = readJson("{\"a\":0}");
    assertEquals(0, instance.getPart("a").getNumericalValue().intValue());
  }

  @Test
  public void test_execute_doubleElement() throws Exception {
    OPPObjectInstance instance = readJson("{\"a\":5.43}");
    assertEquals(5.43, instance.getPart("a").getNumericalValue().doubleValue(), 0.0001);
  }

  @Test
  public void test_execute_stringElement() throws Exception {
    OPPObjectInstance instance = readJson("{\"a\":\"hello\"}");
    assertEquals("hello", instance.getPart("a").getStringValue());
  }

  @Test
  public void test_execute_booleanElement() throws Exception {
    OPPObjectInstance instance = readJson("{\"a\":false}");
    assertEquals("false", instance.getPart("a").getStringValue());
  }

  @Test
  public void text_execute_multipleElements() throws Exception {
    OPPObjectInstance instance = readJson("{\"a\":false,\"b\":2}");
    assertEquals("false", instance.getPart("a").getStringValue());
    assertEquals(2, instance.getPart("b").getNumericalValue().intValue());
  }

  @Test
  public void test_execute_complexInstance() throws Exception {
    OPPObjectInstance instance = readJson("{\"a\":{\"b\":true}}");
    assertEquals("true", instance.getPart("a").getPart("b").getStringValue());

    instance = readJson("{\"a\":{\"b\":true, \"c\":3,\"d\":\"hello\"}, \"b\":false}");
    assertEquals("true", instance.getPart("a").getPart("b").getStringValue());
    assertEquals("false", instance.getPart("b").getStringValue());
    assertEquals("true", instance.getPart("a").getPart("b").getStringValue());
    assertEquals(3, instance.getPart("a").getPart("c").getNumericalValue().intValue());
    assertEquals("hello", instance.getPart("a").getPart("d").getStringValue());
  }
}