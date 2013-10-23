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
   * Returns a new object of class '<em>Link</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Link</em>'.
   * @generated
   */
	OPMLink createOPMLink();

	/**
   * Returns a new object of class '<em>State</em>'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return a new object of class '<em>State</em>'.
   * @generated
   */
    OPMState createOPMState();

    /**
   * Returns a new object of class '<em>Structural Link Aggregator</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Structural Link Aggregator</em>'.
   * @generated
   */
	OPMStructuralLinkAggregator createOPMStructuralLinkAggregator();

	/**
   * Returns a new object of class '<em>Procedural Link</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Procedural Link</em>'.
   * @generated
   */
	OPMProceduralLink createOPMProceduralLink();

	/**
   * Returns a new object of class '<em>Label</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Label</em>'.
   * @generated
   */
	Label createLabel();

	/**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
	OPMPackage getOPMPackage();

} //OPMFactory
