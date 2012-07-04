/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model.tests;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMProcess;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OPMProcessTest extends OPMThingTest {

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static void main(String[] args) {
    TestRunner.run(OPMProcessTest.class);
  }

	/**
   * Constructs a new Process test case with the given name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public OPMProcessTest(String name) {
    super(name);
  }

	/**
   * Returns the fixture for this Process test case.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected OPMProcess getFixture() {
    return (OPMProcess)fixture;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
	@Override
	protected void setUp() throws Exception {
    setFixture(OPMFactory.eINSTANCE.createOPMProcess());
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

} //OPMProcessTest
