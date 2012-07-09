/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import org.junit.After;
import org.junit.Before;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstanceTest;
import com.vainolo.phd.opm.interpreter.model.InterpreterFactory;
import com.vainolo.phd.opm.interpreter.model.Variable;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;

import static org.junit.Assert.assertEquals;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMAddProcessInstanceTest extends OPMAbstractProcessInstanceTest {

  private OPMAbstractProcessInstance fixture;

  @Override
  public void testExecute() {
    Variable a = InterpreterFactory.eINSTANCE.createVariable();
    Variable b = InterpreterFactory.eINSTANCE.createVariable();
    Variable c = InterpreterFactory.eINSTANCE.createVariable();
    a.setValue(4);
    b.setValue(6);
    fixture = new OPMAddProcessInstance();
    fixture.addParameter("a", a, OPMProceduralLinkKind.INSTRUMENT);
    fixture.addParameter("b", b, OPMProceduralLinkKind.INSTRUMENT);
    fixture.addParameter("c", c, OPMProceduralLinkKind.RESULT);

    fixture.execute();
    Object result = c.getValue();

    assertEquals(10, result);
  }

  /**
   * Perform pre-test initialization.
   * 
   * @throws Exception
   *           if the initialization fails for some reason
   * 
   * @generatedBy CodePro at 02/07/12 16:48
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
   * 
   * @generatedBy CodePro at 02/07/12 16:48
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
   * @generatedBy CodePro at 02/07/12 16:48
   */
  public static void main(final String[] args) {
    new org.junit.runner.JUnitCore().run(OPMAddProcessInstanceTest.class);
  }
}