/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model.tests;

import com.vainolo.phd.opm.model.LinkLabel;
import com.vainolo.phd.opm.model.OPMFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Link Label</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LinkLabelTest extends TestCase {

	/**
	 * The fixture for this Link Label test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkLabel fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LinkLabelTest.class);
	}

	/**
	 * Constructs a new Link Label test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkLabelTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Link Label test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(LinkLabel fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Link Label test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkLabel getFixture() {
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
		setFixture(OPMFactory.eINSTANCE.createLinkLabel());
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

} //LinkLabelTest
