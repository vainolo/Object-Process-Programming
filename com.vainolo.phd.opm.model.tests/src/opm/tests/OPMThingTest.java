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
import opm.OPMThing;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Thing</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OPMThingTest extends TestCase {

	/**
	 * The fixture for this Thing test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OPMThing fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OPMThingTest.class);
	}

	/**
	 * Constructs a new Thing test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPMThingTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Thing test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(OPMThing fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Thing test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OPMThing getFixture() {
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
		setFixture(OPMFactory.eINSTANCE.createOPMThing());
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

} //OPMThingTest
