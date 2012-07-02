package com.vainolo.phd.opm.interpreter.builtin;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.easymock.IMockBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstanceTest;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 2 Jul 2012
 * 
 */
public class OPMInputProcessInstanceTest extends OPMAbstractProcessInstanceTest {

	private OPMInputProcessInstance fixture;
	private IMockBuilder<OPMInputProcessInstance> builder;

	@Override
	@Test
	public void testExecute() {
		builder = EasyMock.createMockBuilder(OPMInputProcessInstance.class);
		builder.addMockedMethod("showInputDialog");
		fixture = builder.createMock();
		final String inputText = "Hello";
		EasyMock.expect(fixture.showInputDialog()).andReturn(inputText);
		EasyMock.replay(fixture);

		fixture.execute();
		assertEquals(inputText, fixture.getArgumentValue("text"));

		EasyMock.verify(fixture);

	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 */
	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 * 
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(OPMInputProcessInstanceTest.class);
	}
}