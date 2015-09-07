package com.vainolo.phd.opp.interpreter;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstanceValueAnalyzer;

public class OPPObjectInstanceValueAnalyzerTests {

  private OPPObjectInstanceValueAnalyzer valueAnalyzer;
  private OPPObjectInstance instance;
  private double DELTA = 0.000000001;

  @Test
  public void test_calculateStringLiteralValue() {
    String str;

    str = "\"hello\"";
    instance = valueAnalyzer.calculateOPMObjectValue(str);
    assertEquals("hello", instance.getStringValue());

    str = "\"3.5\"";
    instance = valueAnalyzer.calculateOPMObjectValue(str);
    assertEquals("3.5", instance.getStringValue());
  }

  @Test
  public void test_calculateNumericalLiteralValue() {
    Random r = new Random();
    BigDecimal num;

    num = new BigDecimal(r.nextDouble());
    instance = valueAnalyzer.calculateOPMObjectValue(num.toPlainString());
    assertEquals(num.doubleValue(), instance.getNumericalValue().doubleValue(), DELTA);
  }

  @Test
  public void test_calculateArrayLiteralValue() {
    String array;

    array = "[1..5]";
    instance = valueAnalyzer.calculateOPMObjectValue(array);
    assertEquals(5, instance.getAllParts().size());
    List<OPPObjectInstance> collectionElements = Lists.newArrayList(instance.getAllParts());
    for(int i = 1; i <= 5; i++) {
      assertEquals(i, collectionElements.get(i - 1).getNumericalValue().intValue());
    }

    array = "[25..76]";
    instance = valueAnalyzer.calculateOPMObjectValue(array);
    assertEquals(52, instance.getAllParts().size());
    collectionElements = Lists.newArrayList(instance.getAllParts());
    for(int i = 25; i <= 76; i++) {
      assertEquals(i, collectionElements.get(i - 25).getNumericalValue().intValue());
    }

    array = "[15..10]";
    instance = valueAnalyzer.calculateOPMObjectValue(array);
    assertEquals(6, instance.getAllParts().size());
    collectionElements = Lists.newArrayList(instance.getAllParts());
    for(int i = 15; i >= 10; i--) {
      assertEquals(i, collectionElements.get(15 - i).getNumericalValue().intValue());
    }
  }

  @Before
  public void setup() {
    valueAnalyzer = new OPPObjectInstanceValueAnalyzer();
  }
}
