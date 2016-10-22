/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.eclipsesource.json.JsonObject;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.builtin.io.OPPWriteOPMObjectInstanceToJSON;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPPWriteOPMObjectInstanceToJSONProcessInstanceTest {

  private OPPObjectInstance writeJson(OPPObjectInstance opmObject) throws Exception {
    OPPWriteOPMObjectInstanceToJSON instance = new OPPWriteOPMObjectInstanceToJSON();
    instance.setArgument("object", opmObject);
    instance.call();
    return instance.getArgument("json");
  }

  @Test
  public void test_execute_intElement() throws Exception {
    OPPObjectInstance opmObject = OPPObjectInstance.createCompositeInstance();
    opmObject.addPart("int", OPPObjectInstance.createFromValue(new BigDecimal(3)));
    OPPObjectInstance result = writeJson(opmObject);
    JsonObject jsonObject = JsonObject.readFrom(result.getStringValue());
    assertEquals(3, jsonObject.get("int").asInt());
  }

  @Test
  public void test_execute_doubleElement() throws Exception {
    OPPObjectInstance opmObject = OPPObjectInstance.createCompositeInstance();
    opmObject.addPart("double", OPPObjectInstance.createFromValue(new BigDecimal(5.47)));
    OPPObjectInstance result = writeJson(opmObject);
    JsonObject jsonObject = JsonObject.readFrom(result.getStringValue());
    assertEquals(5.47, jsonObject.get("double").asDouble(), 0.00001);
  }

  @Test
  public void test_execute_stringElement() throws Exception {
    OPPObjectInstance opmObject = OPPObjectInstance.createCompositeInstance();
    opmObject.addPart("name", OPPObjectInstance.createFromValue("hello"));
    OPPObjectInstance result = writeJson(opmObject);
    JsonObject jsonObject = JsonObject.readFrom(result.getStringValue());
    assertEquals("hello", jsonObject.get("name").asString());
  }

  @Test
  public void test_execute_stateElement() throws Exception {
    OPPObjectInstance opmObject = OPPObjectInstance.createCompositeInstance();
    opmObject.addPart("bool", OPPObjectInstance.createFromValue("true"));
    OPPObjectInstance result = writeJson(opmObject);
    JsonObject jsonObject = JsonObject.readFrom(result.getStringValue());
    assertEquals("true", jsonObject.get("bool").asString());
  }

  @Test
  public void text_execute_multipleElements() throws Exception {
    OPPObjectInstance opmObject = OPPObjectInstance.createCompositeInstance();
    opmObject.addPart("a", OPPObjectInstance.createFromValue(new BigDecimal(5)));
    OPPObjectInstance part = OPPObjectInstance.createCompositeInstance();
    part.addPart("b1", OPPObjectInstance.createFromValue("hello"));
    part.addPart("b2", OPPObjectInstance.createFromValue(new BigDecimal(5.43)));
    opmObject.addPart("b", part);
    opmObject.addPart("c", OPPObjectInstance.createFromValue("one"));
    OPPObjectInstance result = writeJson(opmObject);
    JsonObject json = JsonObject.readFrom(result.getStringValue());
    assertEquals(5, json.get("a").asInt());
    assertEquals("hello", json.get("b").asObject().get("b1").asString());
    assertEquals(5.43, json.get("b").asObject().get("b2").asDouble(), 0.0001);
    assertEquals("one", json.get("c").asString());
  }
}