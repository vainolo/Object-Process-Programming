/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.eclipsesource.json.JsonObject;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMWriteOPMObjectInstanceToJSONProcessInstanceTest {

  private OPMObjectInstance writeJson(OPMObjectInstance opmObject) throws Exception {
    OPMWriteOPMObjectInstanceToJSON instance = new OPMWriteOPMObjectInstanceToJSON();
    instance.setArgument("object", opmObject);
    instance.call();
    return instance.getArgument("json");
  }

  @Test
  public void test_execute_intElement() throws Exception {
    OPMObjectInstance opmObject = OPMObjectInstance.createCompositeInstance();
    opmObject.addPart("int", OPMObjectInstance.createFromValue(new BigDecimal(3)));
    OPMObjectInstance result = writeJson(opmObject);
    JsonObject jsonObject = JsonObject.readFrom(result.getStringValue());
    assertEquals(3, jsonObject.get("int").asInt());
  }

  @Test
  public void test_execute_doubleElement() throws Exception {
    OPMObjectInstance opmObject = OPMObjectInstance.createCompositeInstance();
    opmObject.addPart("double", OPMObjectInstance.createFromValue(new BigDecimal(5.47)));
    OPMObjectInstance result = writeJson(opmObject);
    JsonObject jsonObject = JsonObject.readFrom(result.getStringValue());
    assertEquals(5.47, jsonObject.get("double").asDouble(), 0.00001);
  }

  @Test
  public void test_execute_stringElement() throws Exception {
    OPMObjectInstance opmObject = OPMObjectInstance.createCompositeInstance();
    opmObject.addPart("name", OPMObjectInstance.createFromValue("hello"));
    OPMObjectInstance result = writeJson(opmObject);
    JsonObject jsonObject = JsonObject.readFrom(result.getStringValue());
    assertEquals("hello", jsonObject.get("name").asString());
  }

  @Test
  public void test_execute_stateElement() throws Exception {
    OPMObjectInstance opmObject = OPMObjectInstance.createCompositeInstance();
    opmObject.addPart("bool", OPMObjectInstance.createFromValue("true"));
    OPMObjectInstance result = writeJson(opmObject);
    JsonObject jsonObject = JsonObject.readFrom(result.getStringValue());
    assertEquals("true", jsonObject.get("bool").asString());
  }

  @Test
  public void text_execute_multipleElements() throws Exception {
    OPMObjectInstance opmObject = OPMObjectInstance.createCompositeInstance();
    opmObject.addPart("a", OPMObjectInstance.createFromValue(new BigDecimal(5)));
    OPMObjectInstance part = OPMObjectInstance.createCompositeInstance();
    part.addPart("b1", OPMObjectInstance.createFromValue("hello"));
    part.addPart("b2", OPMObjectInstance.createFromValue(new BigDecimal(5.43)));
    opmObject.addPart("b", part);
    opmObject.addPart("c", OPMObjectInstance.createFromValue("one"));
    OPMObjectInstance result = writeJson(opmObject);
    JsonObject json = JsonObject.readFrom(result.getStringValue());
    assertEquals(5, json.get("a").asInt());
    assertEquals("hello", json.get("b").asObject().get("b1").asString());
    assertEquals(5.43, json.get("b").asObject().get("b2").asDouble(), 0.0001);
    assertEquals("one", json.get("c").asString());
  }
}