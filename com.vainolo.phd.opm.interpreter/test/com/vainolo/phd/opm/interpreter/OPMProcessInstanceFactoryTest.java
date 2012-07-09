/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opm.interpreter.builtin.OPMAddProcessInstance;
import com.vainolo.phd.opm.interpreter.builtin.OPMInputProcessInstance;
import com.vainolo.phd.opm.interpreter.builtin.OPMOutputProcessInstance;
import com.vainolo.phd.opm.model.OPMProcessKind;

import static org.junit.Assert.*;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMProcessInstanceFactoryTest {

  private OPMProcessInstanceFactory fixture;

  @Test
  public void testCreateProcessInstance_BuiltInInputProcess() {
    final String processName = "Input";
    final OPMProcessKind kind = OPMProcessKind.BUILT_IN;

    final OPMProcessInstance result = fixture.createProcessInstance(processName, kind);

    // add additional test code here
    assertNotNull(result);
    assertEquals(processName, result.getName());
    assertTrue(result instanceof OPMInputProcessInstance);
  }

  @Test
  public void testCreateProcessInstance_BuiltInAddProcess() {
    final String processName = "Add";
    final OPMProcessKind kind = OPMProcessKind.BUILT_IN;

    final OPMProcessInstance result = fixture.createProcessInstance(processName, kind);

    // add additional test code here
    assertNotNull(result);
    assertEquals(processName, result.getName());
    assertTrue(result instanceof OPMAddProcessInstance);
  }

  @Test
  public void testCreateProcessInstance_BuiltInOutputProcess() {
    final String processName = "Output";
    final OPMProcessKind kind = OPMProcessKind.BUILT_IN;

    final OPMProcessInstance result = fixture.createProcessInstance(processName, kind);

    // add additional test code here
    assertNotNull(result);
    assertEquals(processName, result.getName());
    assertTrue(result instanceof OPMOutputProcessInstance);
  }

  @Test(expected = IllegalStateException.class)
  public void testCreateProcessInstance_UnexistentBuiltInProcess() {
    final String processName = "something";
    final OPMProcessKind kind = OPMProcessKind.BUILT_IN;

    final OPMProcessInstance result = fixture.createProcessInstance(processName, kind);

  }

  /**
   * Perform pre-test initialization.
   * 
   * @throws Exception
   *           if the initialization fails for some reason
   * 
   * @generatedBy CodePro at 7/1/12 3:56 PM
   */
  @Before
  public void setUp() throws Exception {
    fixture = OPMProcessInstanceFactory.INSTANCE;
  }

  /**
   * Perform post-test clean-up.
   * 
   * @throws Exception
   *           if the clean-up fails for some reason
   * 
   * @generatedBy CodePro at 7/1/12 3:56 PM
   */
  @After
  public void tearDown() throws Exception {
    // Add additional tear down code here
  }

  /**
   * Launch the test.
   * 
   * @param args
   *          the command line arguments
   * 
   * @generatedBy CodePro at 7/1/12 3:56 PM
   */
  public static void main(final String[] args) {
    new org.junit.runner.JUnitCore().run(OPMProcessInstanceFactoryTest.class);
  }
}