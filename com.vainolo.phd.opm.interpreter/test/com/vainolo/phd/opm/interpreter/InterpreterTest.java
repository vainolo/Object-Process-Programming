/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import org.easymock.EasyMock;
import org.eclipse.core.resources.IContainer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opm.model.OPMProcessKind;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class InterpreterTest {

	/**
	 * Run the void interpret(String,IContainer) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 7/1/12 5:41 PM
	 */
	@Test
	public void testInterpret_interpret() throws Exception {
		final Interpreter fixture = Interpreter.INSTANCE;
		final String processName = "P1";
		final IContainer container = null;
		final OPMProcessInstance instance = EasyMock.createMock(OPMProcessInstance.class);
		final OPMProcessInstanceFactory factory = EasyMock.createMock(OPMProcessInstanceFactory.class);
		EasyMock.expect(factory.createProcessInstance(processName, OPMProcessKind.COMPOUND)).andReturn(instance);
		instance.execute();
		EasyMock.replay(factory);
		EasyMock.replay(instance);

		fixture.setOPMProcessInstanceFactory(factory);
		fixture.interpret(processName, container);

		// add additional test code here
		EasyMock.verify(factory);
		EasyMock.verify(instance);
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 7/1/12 5:41 PM
	 */
	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * 
	 * @generatedBy CodePro at 7/1/12 5:41 PM
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
	 * @generatedBy CodePro at 7/1/12 5:41 PM
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(InterpreterTest.class);
	}
}