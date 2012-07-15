/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import org.easymock.IMockBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;

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
    expect(fixture.getName()).andReturn("Something");
    replay(fixture);
    fixture.executing();
    verify(fixture);
  }

  /**
   * Perform pre-test initialization.
   * 
   * @throws Exception
   *           if the initialization fails for some reason
   * 
   */
  @Before
  public void setUp() throws Exception {
    builder = createMockBuilder(OPMAbstractProcessInstance.class);

  }

  /**
   * Perform post-test clean-up.
   * 
   * @throws Exception
   *           if the clean-up fails for some reason
   * 
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
   * @generatedBy CodePro at 7/1/12 8:31 PM
   */
  public static void main(final String[] args) {
    new org.junit.runner.JUnitCore().run(OPMAbstractProcessInstanceTest.class);
  }
}