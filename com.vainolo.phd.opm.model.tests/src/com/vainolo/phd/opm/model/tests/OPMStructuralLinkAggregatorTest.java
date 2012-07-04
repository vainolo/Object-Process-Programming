/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model.tests;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregator;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Structural Link Aggregator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OPMStructuralLinkAggregatorTest extends OPMNodeTest {

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static void main(String[] args) {
    TestRunner.run(OPMStructuralLinkAggregatorTest.class);
  }

	/**
   * Constructs a new Structural Link Aggregator test case with the given name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public OPMStructuralLinkAggregatorTest(String name) {
    super(name);
  }

	/**
   * Returns the fixture for this Structural Link Aggregator test case.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected OPMStructuralLinkAggregator getFixture() {
    return (OPMStructuralLinkAggregator)fixture;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
	@Override
	protected void setUp() throws Exception {
    setFixture(OPMFactory.eINSTANCE.createOPMStructuralLinkAggregator());
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

} //OPMStructuralLinkAggregatorTest
