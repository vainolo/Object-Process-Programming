package com.vainolo.phd.opm.interpreter.builtin;

import org.easymock.IMockBuilder;
import org.junit.After;
import org.junit.Before;

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

  /**
   * Perform pre-test initialization.
   * 
   * @throws Exception
   *           if the initialization fails for some reason
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
   *           if the clean-up fails for some reason
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
   *          the command line arguments
   * 
   */
  public static void main(final String[] args) {
    new org.junit.runner.JUnitCore().run(OPMInputProcessInstanceTest.class);
  }
}