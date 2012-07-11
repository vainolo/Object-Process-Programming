/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import org.easymock.IMockBuilder;
import org.junit.After;
import org.junit.Before;

import static org.easymock.EasyMock.createMockBuilder;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 3 Jul 2012
 * 
 */
public class OPMCompoundProcessInstanceTest extends OPMAbstractProcessInstanceTest {

  private IMockBuilder<OPMCompoundProcessInstance> builder;

  /**
   * Perform pre-test initialization.
   * 
   * @throws Exception
   *           if the initialization fails for some reason
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    builder = createMockBuilder(OPMCompoundProcessInstance.class);
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
}