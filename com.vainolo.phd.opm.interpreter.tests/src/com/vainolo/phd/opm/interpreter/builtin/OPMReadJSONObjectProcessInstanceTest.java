/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vainolo.phd.opm.interpreter.OPMObjectInstance;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMReadJSONObjectProcessInstanceTest {

  private OPMObjectInstance readJson(String json) throws Exception {
    OPMReadJSONObjectProcessInstance instance = new OPMReadJSONObjectProcessInstance();
    instance.setArgument("json", OPMObjectInstance.createFromValue(json));
    instance.call();
    return instance.getArgument("object");
  }

  @Test
  public void test_execute_intElement() throws Exception {
    OPMObjectInstance instance = readJson("{\"a\":0}");
    assertEquals(0, instance.getCompositePart("a").getNumericalValue().intValue());
  }

  @Test
  public void test_execute_doubleElement() throws Exception {
    OPMObjectInstance instance = readJson("{\"a\":5.43}");
    assertEquals(5.43, instance.getCompositePart("a").getNumericalValue().doubleValue(), 0.0001);
  }

  @Test
  public void test_execute_stringElement() throws Exception {
    OPMObjectInstance instance = readJson("{\"a\":\"hello\"}");
    assertEquals("hello", instance.getCompositePart("a").getStringValue());
  }

  @Test
  public void test_execute_booleanElement() throws Exception {
    OPMObjectInstance instance = readJson("{\"a\":false}");
    assertEquals("false", instance.getCompositePart("a").getStringValue());
  }

  @Test
  public void text_execute_multipleElements() throws Exception {
    OPMObjectInstance instance = readJson("{\"a\":false,\"b\":2}");
    assertEquals("false", instance.getCompositePart("a").getStringValue());
    assertEquals(2, instance.getCompositePart("b").getNumericalValue().intValue());
  }

  @Test
  public void test_execute_complexInstance() throws Exception {
    OPMObjectInstance instance = readJson("{\"a\":{\"b\":true}}");
    assertEquals("true", instance.getCompositePart("a").getCompositePart("b").getStringValue());

    instance = readJson("{\"a\":{\"b\":true, \"c\":3,\"d\":\"hello\"}, \"b\":false}");
    assertEquals("true", instance.getCompositePart("a").getCompositePart("b").getStringValue());
    assertEquals("false", instance.getCompositePart("b").getStringValue());
    assertEquals("true", instance.getCompositePart("a").getCompositePart("b").getStringValue());
    assertEquals(3, instance.getCompositePart("a").getCompositePart("c").getNumericalValue().intValue());
    assertEquals("hello", instance.getCompositePart("a").getCompositePart("d").getStringValue());
  }
}