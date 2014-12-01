package com.vainolo.phd.opm.interpreter;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class OPMObjectInstanceValueAnalyzerImplTests {

  private OPMObjectInstanceValueAnalyzerImpl valueAnalyzer;
  private OPMObjectInstance instance;
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
    assertEquals(5, instance.getCollectionAllElements().size());
    for(int i = 1; i <= 5; i++) {
      assertEquals(i, instance.getCollectionAllElements().get(i - 1).getNumericalValue().intValue());
    }

    array = "[25..76]";
    instance = valueAnalyzer.calculateOPMObjectValue(array);
    assertEquals(52, instance.getCollectionAllElements().size());
    for(int i = 25; i <= 76; i++) {
      assertEquals(i, instance.getCollectionAllElements().get(i - 25).getNumericalValue().intValue());
    }

    array = "[15..10]";
    instance = valueAnalyzer.calculateOPMObjectValue(array);
    assertEquals(6, instance.getCollectionAllElements().size());
    for(int i = 15; i >= 10; i--) {
      assertEquals(i, instance.getCollectionAllElements().get(15 - i).getNumericalValue().intValue());
    }
  }

  @Before
  public void setup() {
    Random r = new Random();
    valueAnalyzer = new OPMObjectInstanceValueAnalyzerImpl();
  }
}
