/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package opm.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import opm.OPMFactory;
import opm.ObjectProcessDiagram;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Object Process Diagram</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ObjectProcessDiagramTest extends TestCase {

	/**
	 * The fixture for this Object Process Diagram test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectProcessDiagram fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ObjectProcessDiagramTest.class);
	}

	/**
	 * Constructs a new Object Process Diagram test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectProcessDiagramTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Object Process Diagram test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ObjectProcessDiagram fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Object Process Diagram test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectProcessDiagram getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OPMFactory.eINSTANCE.createObjectProcessDiagram());
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

} //ObjectProcessDiagramTest
