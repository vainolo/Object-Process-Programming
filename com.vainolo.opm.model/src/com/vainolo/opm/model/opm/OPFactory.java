/**
 */
package com.vainolo.opm.model.opm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.vainolo.opm.model.opm.OPPackage
 * @generated
 */
public interface OPFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OPFactory eINSTANCE = com.vainolo.opm.model.opm.impl.OPFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object</em>'.
	 * @generated
	 */
	OPObject createOPObject();

	/**
	 * Returns a new object of class '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process</em>'.
	 * @generated
	 */
	OPProcess createOPProcess();

	/**
	 * Returns a new object of class '<em>Procedural Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Procedural Link</em>'.
	 * @generated
	 */
	OPProceduralLink createOPProceduralLink();

	/**
	 * Returns a new object of class '<em>Structural Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structural Link</em>'.
	 * @generated
	 */
	OPStructuralLink createOPStructuralLink();

	/**
	 * Returns a new object of class '<em>Tagged Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tagged Link</em>'.
	 * @generated
	 */
	OPTaggedLink createOPTaggedLink();

	/**
	 * Returns a new object of class '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State</em>'.
	 * @generated
	 */
	OPState createOPState();

	/**
	 * Returns a new object of class '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System</em>'.
	 * @generated
	 */
	OPSystem createOPSystem();

	/**
	 * Returns a new object of class '<em>Object Process Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Process Diagram</em>'.
	 * @generated
	 */
	OPObjectProcessDiagram createOPObjectProcessDiagram();

	/**
	 * Returns a new object of class '<em>Object View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object View</em>'.
	 * @generated
	 */
	OPObjectView createOPObjectView();

	/**
	 * Returns a new object of class '<em>Process View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process View</em>'.
	 * @generated
	 */
	OPProcessView createOPProcessView();

	/**
	 * Returns a new object of class '<em>State View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State View</em>'.
	 * @generated
	 */
	OPStateView createOPStateView();

	/**
	 * Returns a new object of class '<em>Procedural Link View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Procedural Link View</em>'.
	 * @generated
	 */
	OPProceduralLinkView createOPProceduralLinkView();

	/**
	 * Returns a new object of class '<em>Structural Link Part View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structural Link Part View</em>'.
	 * @generated
	 */
	OPStructuralLinkPartView createOPStructuralLinkPartView();

	/**
	 * Returns a new object of class '<em>Tagged Link View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tagged Link View</em>'.
	 * @generated
	 */
	OPTaggedLinkView createOPTaggedLinkView();

	/**
	 * Returns a new object of class '<em>Structural Link Aggregator View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structural Link Aggregator View</em>'.
	 * @generated
	 */
	OPStructuralLinkAggregatorView createOPStructuralLinkAggregatorView();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OPPackage getOPPackage();

} //OPFactory
