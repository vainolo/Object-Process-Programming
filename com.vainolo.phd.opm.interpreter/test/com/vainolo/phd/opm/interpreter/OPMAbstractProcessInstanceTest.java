/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.easymock.IMockBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMAbstractProcessInstanceTest {

	private OPMAbstractProcessInstance fixture;
	private IMockBuilder<OPMAbstractProcessInstance> builder;

	@Test
	public void testExecute() {
		builder.addMockedMethod("getName");
		fixture = builder.createMock();
		EasyMock.expect(fixture.getName()).andReturn("Something");
		EasyMock.replay(fixture);
		fixture.execute();
		EasyMock.verify(fixture);
	}

	@Test
	public void testSetAndGetName() {
		fixture = builder.createMock();
		final String name = "foo";
		fixture.setName(name);

		assertEquals(name, fixture.getName());
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 7/1/12 8:31 PM
	 */
	@Before
	public void setUp() throws Exception {
		builder = EasyMock.createMockBuilder(OPMAbstractProcessInstance.class);

	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * 
	 * @generatedBy CodePro at 7/1/12 8:31 PM
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
	 * @generatedBy CodePro at 7/1/12 8:31 PM
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(OPMAbstractProcessInstanceTest.class);
	}
}