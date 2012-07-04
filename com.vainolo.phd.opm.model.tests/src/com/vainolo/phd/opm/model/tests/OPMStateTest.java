/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model.tests;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMState;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OPMStateTest extends OPMNodeTest {

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public static void main(String[] args) {
    TestRunner.run(OPMStateTest.class);
  }

    /**
   * Constructs a new State test case with the given name.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public OPMStateTest(String name) {
    super(name);
  }

    /**
   * Returns the fixture for this State test case.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected OPMState getFixture() {
    return (OPMState)fixture;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
    @Override
    protected void setUp() throws Exception {
    setFixture(OPMFactory.eINSTANCE.createOPMState());
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see junit.framework.TestCase#tearDown()
   * @generated
   */
    @Override
    protected void tearDown() throws Exception {
    setFixture(null);
  }

} //OPMStateTest
