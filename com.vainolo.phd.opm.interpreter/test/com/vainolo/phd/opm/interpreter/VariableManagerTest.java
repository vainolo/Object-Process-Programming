/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opm.interpreter.model.InterpreterFactory;
import com.vainolo.phd.opm.interpreter.model.Variable;

/**
 * @author Arieh 'Vainolo' Bibliowicz
 */
public class VariableManagerTest {
	private VariableManager variableManager;
	private InterpreterFactory entityFactory;

	/**
	 * Run the VariableManager() constructor test.
	 * 
	 * @generatedBy CodePro at 6/29/12 11:06 AM
	 */
	@Test
	public void testConstructor() throws Exception {
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
		assertTrue(!var.isSetValue());
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
	 * Add a non existent variable to the variable manager.
	 */
	@Test
	public void testAddVariable_NewVariable_VariableExists() {
		final String varName = "var";
		final Variable var = InterpreterFactory.eINSTANCE.createVariable();
		var.setName(varName);

		variableManager.addVariable(var);

		assertEquals(var, variableManager.getVariable(varName));
	}

	/**
	 * Try to add an variable with the name of an existing variable.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddVariable_VariableWithExistingName_Exception() {
		final String varName = "var";
		final Variable var = entityFactory.createVariable();
		var.setName(varName);
		variableManager.createVariable(varName);
		variableManager.addVariable(var);
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 6/29/12 11:06 AM
	 */
	@Before
	public void setUp() throws Exception {
		variableManager = new VariableManager();
		entityFactory = InterpreterFactory.eINSTANCE;
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * 
	 * @generatedBy CodePro at 6/29/12 11:06 AM
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 * 
	 * @generatedBy CodePro at 6/29/12 11:06 AM
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(VariableManagerTest.class);
	}
}