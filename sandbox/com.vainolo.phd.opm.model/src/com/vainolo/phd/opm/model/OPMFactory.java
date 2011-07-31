/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.vainolo.phd.opm.model.OPMPackage
 * @generated
 */
public interface OPMFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	OPMFactory eINSTANCE = com.vainolo.phd.opm.model.impl.OPMFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Object Process Diagram</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Object Process Diagram</em>'.
     * @generated
     */
	OPMObjectProcessDiagram createOPMObjectProcessDiagram();

	/**
     * Returns a new object of class '<em>Object</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Object</em>'.
     * @generated
     */
	OPMObject createOPMObject();

	/**
     * Returns a new object of class '<em>Process</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Process</em>'.
     * @generated
     */
	OPMProcess createOPMProcess();

	/**
     * Returns a new object of class '<em>Thing</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Thing</em>'.
     * @generated
     */
	OPMThing createOPMThing();

	/**
     * Returns a new object of class '<em>Procedural Link</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Procedural Link</em>'.
     * @generated
     */
	OPMProceduralLink createOPMProceduralLink();

	/**
     * Returns a new object of class '<em>Agent Link</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Agent Link</em>'.
     * @generated
     */
    OPMAgentLink createOPMAgentLink();

    /**
     * Returns a new object of class '<em>Instrument Link</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Instrument Link</em>'.
     * @generated
     */
    OPMInstrumentLink createOPMInstrumentLink();

    /**
     * Returns a new object of class '<em>Consumption Link</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Consumption Link</em>'.
     * @generated
     */
    OPMConsumptionLink createOPMConsumptionLink();

    /**
     * Returns a new object of class '<em>Result Link</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Result Link</em>'.
     * @generated
     */
    OPMResultLink createOPMResultLink();

    /**
     * Returns a new object of class '<em>Effect Link</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Effect Link</em>'.
     * @generated
     */
    OPMEffectLink createOPMEffectLink();

    /**
     * Returns a new object of class '<em>Structural Link</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Structural Link</em>'.
     * @generated
     */
    OPMStructuralLink createOPMStructuralLink();

    /**
     * Returns a new object of class '<em>Named Element</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Named Element</em>'.
     * @generated
     */
    NamedElement createNamedElement();

    /**
     * Returns a new object of class '<em>Node Container</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Node Container</em>'.
     * @generated
     */
    NodeContainer createNodeContainer();

    /**
     * Returns a new object of class '<em>Structural Link Aggregator</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Structural Link Aggregator</em>'.
     * @generated
     */
	OPMStructuralLinkAggregator createOPMStructuralLinkAggregator();

	/**
     * Returns a new object of class '<em>Aggregation Link Aggregator</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Aggregation Link Aggregator</em>'.
     * @generated
     */
    OPMAggregationLinkAggregator createOPMAggregationLinkAggregator();

    /**
     * Returns a new object of class '<em>Exhibition Link Aggregator</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Exhibition Link Aggregator</em>'.
     * @generated
     */
    OPMExhibitionLinkAggregator createOPMExhibitionLinkAggregator();

    /**
     * Returns a new object of class '<em>Generalization Link Aggregator</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Generalization Link Aggregator</em>'.
     * @generated
     */
    OPMGeneralizationLinkAggregator createOPMGeneralizationLinkAggregator();

    /**
     * Returns a new object of class '<em>State</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>State</em>'.
     * @generated
     */
    OPMState createOPMState();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	OPMPackage getOPMPackage();

} //OPMFactory
