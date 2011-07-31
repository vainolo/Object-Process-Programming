/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model.tests;

import com.vainolo.phd.opm.model.OPMExhibitionLinkAggregator;
import com.vainolo.phd.opm.model.OPMFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Exhibition Link Aggregator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OPMExhibitionLinkAggregatorTest extends OPMStructuralLinkAggregatorTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(OPMExhibitionLinkAggregatorTest.class);
    }

    /**
     * Constructs a new Exhibition Link Aggregator test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OPMExhibitionLinkAggregatorTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Exhibition Link Aggregator test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected OPMExhibitionLinkAggregator getFixture() {
        return (OPMExhibitionLinkAggregator)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(OPMFactory.eINSTANCE.createOPMExhibitionLinkAggregator());
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

} //OPMExhibitionLinkAggregatorTest
