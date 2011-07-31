/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model.tests;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMGeneralizationLinkAggregator;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Generalization Link Aggregator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OPMGeneralizationLinkAggregatorTest extends OPMStructuralLinkAggregatorTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(OPMGeneralizationLinkAggregatorTest.class);
    }

    /**
     * Constructs a new Generalization Link Aggregator test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OPMGeneralizationLinkAggregatorTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Generalization Link Aggregator test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected OPMGeneralizationLinkAggregator getFixture() {
        return (OPMGeneralizationLinkAggregator)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(OPMFactory.eINSTANCE.createOPMGeneralizationLinkAggregator());
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

} //OPMGeneralizationLinkAggregatorTest
