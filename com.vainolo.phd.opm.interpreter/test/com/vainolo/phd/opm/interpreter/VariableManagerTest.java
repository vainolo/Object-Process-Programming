/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Arieh 'Vainolo' Bibliowicz
 */
public class VariableManagerTest {
  private VariableManager variableManager;

  /**
   * Run the VariableManager() constructor test.
   * 
   * @generatedBy CodePro at 6/29/12 11:06 AM
   */
  @Test
  public void testConstructor() {
    final VariableManager result = new VariableManager();
    assertNotNull(result);
  }

  /**
   * Try to create a variable with a null name.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCreateVariable_NullName_Exception() {
    variableManager.createVariable(null);
  }

  /**
   * Create a variable correctly.
   */
  @Test
  public void testCreateVariable_NewVariable_VariableFound() {
    final String varName = "var1";
    variableManager.createVariable(varName);
    assertNotNull(variableManager.getVariable(varName));
    assertEquals(varName, variableManager.getVariable(varName).getName());
  }

  /**
   * Try to create an variable with an existing name.
   */
  @Test(expected = IllegalStateException.class)
  public void testCreateVariable_CreateExistingVariable_Exception() {
    final String varName = "var1";
    variableManager.createVariable(varName);
    variableManager.createVariable(varName);
  }

  /**
   * Fetch a variable.
   */
  @Test
  public void testFetchVariable_ExistingVariable() {
    final String varName = "var";
    variableManager.createVariable(varName);

    final Variable var = variableManager.getVariable(varName);

    assertEquals(varName, var.getName());
    assertTrue(!var.isValueSet());
  }

  /**
   * Fetch a non-existent variable.
   */
  @Test(expected = IllegalStateException.class)
  public void testFetchVariable_NonExistentVariable_Exception() {
    final String varName = "var";
    variableManager.getVariable(varName);
  }

  /**
   * Perform pre-test initialization.
   */
  @Before
  public void setUp() {
    variableManager = new VariableManager();
  }

  /**
   * Perform post-test clean-up.
   */
  @After
  public void tearDown() {
  }
}