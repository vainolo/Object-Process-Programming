/**
 */
package com.vainolo.phd.opm.model.tests;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Object Process Diagram</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OPMObjectProcessDiagramTest extends OPMContainerTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OPMObjectProcessDiagramTest.class);
	}

	/**
	 * Constructs a new Object Process Diagram test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPMObjectProcessDiagramTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Object Process Diagram test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OPMObjectProcessDiagram getFixture() {
		return (OPMObjectProcessDiagram)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OPMFactory.eINSTANCE.createOPMObjectProcessDiagram());
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

} //OPMObjectProcessDiagramTest
