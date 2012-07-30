/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMProcess;

import static org.junit.Assert.*;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 15 Jul 2012
 * 
 */
public class OPMJavaProcessInstanceTest extends OPMAbstractProcessInstanceTest {

  private OPMProcess process;
  private OPMJavaProcessInstance instance;

  @Test(expected = RuntimeException.class)
  public void testExecuting_NonexistentClass_Exception() {
    process.setName("Test1");
    process.setDescription("Mist.size()");

    instance = new OPMJavaProcessInstance(process);

    instance.execute();
  }

  @Test
  public void testExecuting_InstanceMethodTwoParametersNoReturnValue() {
    process.setName("Test2");
    process.setDescription("java.util.ArrayList.add(int,    java.lang.Object)");

    final List<String> list = new ArrayList<String>();
    instance = new OPMJavaProcessInstance(process);
    instance.setArgumentValue("this", list);
    instance.setArgumentValue("arg0", 0);
    instance.setArgumentValue("arg1", "Hello");

    instance.execute();

    assertTrue(list.size() == 1);
    assertEquals("Hello", list.get(0));

  }

  public void testExecuting_InstanceMethodNoParametersWithReturnValue() {
    process.setName("Test3");
    process.setDescription("java.util.List.size()");
    final List<Float> list = new ArrayList<Float>();
    list.add(5f);

    instance.setArgumentValue("this", list);
    instance.execute();

    final Object result = instance.getArgumentValue("result");

    assertEquals(1, result);
  }

  @Test
  public void testExecuting_StaticMethodNoParametersWithReturnValue() {
    process.setName("Test4");
    process.setDescription("java.lang.System.lineSeparator()");

    instance = new OPMJavaProcessInstance(process);
    instance.execute();

    final Object result = instance.getArgumentValue("result");
    assertEquals(System.lineSeparator(), result);

  }

  @Test
  public void testExecuting_StaticMethodWithParametersNoReturnValue() {
    process.setName("Test5");
    process.setDescription("java.util.Collections.copy(java.util.List,java.util.List)");

    final ArrayList<Integer> l1 = new ArrayList<Integer>();
    l1.add(1);
    final ArrayList<Integer> l2 = new ArrayList<Integer>();
    l2.add(2);

    java.util.Collections.copy(l2, l1);

    instance = new OPMJavaProcessInstance(process);
    instance.setArgumentValue("arg0", l2);
    instance.setArgumentValue("arg1", l1);
    instance.execute();

    @SuppressWarnings("unchecked")
    final List<Integer> l3 = (List<Integer>) instance.getArgumentValue("arg1");
    assertArrayEquals(l1.toArray(), l3.toArray());
  }

  @Test
  public void testExecuting_InheritedMethod() {
    process.setName("Test6");
    process.setDescription("java.lang.Object.equals(java.lang.Object)");

    final String a = "hello";
    final String b = "hello";

    instance = new OPMJavaProcessInstance(process);
    instance.setArgumentValue("arg0", a);
    instance.setArgumentValue("this", b);
    instance.execute();

    final Object result = instance.getArgumentValue("result");

    assertEquals(true, result);
  }

  @Test
  public void testExecuting_MethodWithBooleanParameter() {
    fail();
  }

  @Test
  public void testExecuting_MethodWithCharParameter() {
    fail();
  }

  @Test
  public void testExecuting_MethodWithByteParameter() {
    fail();
  }

  @Test
  public void testExecuting_MethodWithShortParameter() {
    fail();
  }

  @Test
  public void testExecuting_MethodWithIntParameter() {
    fail();
  }

  @Test
  public void testExecuting_MethodWithLongParameter() {
    fail();
  }

  @Test
  public void testExecuting_MethodWithFloatParameter() {
    fail();
  }

  @Test
  public void testExecuting_MethodWithDoubleParameter() {
    fail();
  }

  @Before
  public void setUp() {
    super.setUp();
    process = OPMFactory.eINSTANCE.createOPMProcess();
  }

}
