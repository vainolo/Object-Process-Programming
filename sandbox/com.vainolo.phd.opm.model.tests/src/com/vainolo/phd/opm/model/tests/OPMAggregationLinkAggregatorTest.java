/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model.tests;

import com.vainolo.phd.opm.model.OPMAggregationLinkAggregator;
import com.vainolo.phd.opm.model.OPMFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Aggregation Link Aggregator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OPMAggregationLinkAggregatorTest extends OPMStructuralLinkAggregatorTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(OPMAggregationLinkAggregatorTest.class);
    }

    /**
     * Constructs a new Aggregation Link Aggregator test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OPMAggregationLinkAggregatorTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Aggregation Link Aggregator test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected OPMAggregationLinkAggregator getFixture() {
        return (OPMAggregationLinkAggregator)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(OPMFactory.eINSTANCE.createOPMAggregationLinkAggregator());
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

} //OPMAggregationLinkAggregatorTest
