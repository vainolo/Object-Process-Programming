/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import org.junit.After;
import org.junit.Before;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMProcessInstanceFactoryTest {

  private OPMProcessInstanceFactory fixture;

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