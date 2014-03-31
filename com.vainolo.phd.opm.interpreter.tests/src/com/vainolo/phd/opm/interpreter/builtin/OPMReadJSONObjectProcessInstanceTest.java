/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;

import org.junit.Test;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstanceTest;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMReadJSONObjectProcessInstanceTest {

	private OPMObjectInstance readJson(String json) {
		OPMReadJSONObjectProcessInstance instance = new OPMReadJSONObjectProcessInstance();
		instance.setArgument("json", OPMObjectInstance.createFromValue(json));
		instance.execute();
		return instance.getArgument("result");
	}
	
  @Test
  public void test_execute_intElement() {
	  OPMObjectInstance instance = readJson("{\"a\":0}");
	  assertEquals(0, instance.getPart("a").getNumericalValue().intValue());
  }  
  
  @Test
  public void test_execute_doubleElement() {
	  OPMObjectInstance instance = readJson("{\"a\":5.43}");
	  assertEquals(5.43, instance.getPart("a").getNumericalValue().doubleValue(), 0.0001);
  }  

  @Test
  public void test_execute_stringElement() {
	  OPMObjectInstance instance = readJson("{\"a\":\"hello\"}");
	  assertEquals("hello", instance.getPart("a").getStringValue());
  }  
  
  @Test
  public void test_execute_booleanElement() {
	  OPMObjectInstance instance = readJson("{\"a\":false}");
	  assertEquals("false", instance.getPart("a").getState());
  }  
  
  @Test
  public void text_execute_multipleElements() {
	  OPMObjectInstance instance = readJson("{\"a\":false,\"b\":2}");
	  assertEquals("false", instance.getPart("a").getState());
	  assertEquals(2, instance.getPart("b").getNumericalValue().intValue());
	
  }
  
  @Test
  public void test_execute_complexInstance() {
	  OPMObjectInstance instance = readJson("{\"a\":{\"b\":true}}");
	  assertEquals("true", instance.getPart("a").getPart("b").getState());
	  
	  instance = readJson("{\"a\":{\"b\":true, \"c\":3,\"d\":\"hello\"}, \"b\":false}");
	  assertEquals("true", instance.getPart("a").getPart("b").getState());
	  assertEquals("false", instance.getPart("b").getState());
	  assertEquals("true", instance.getPart("a").getPart("b").getState());
	  assertEquals(3, instance.getPart("a").getPart("c").getNumericalValue().intValue());
	  assertEquals("hello", instance.getPart("a").getPart("d").getStringValue());
	  
  }
  
}