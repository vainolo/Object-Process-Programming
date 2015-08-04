/**
 */
package com.vainolo.opm.model.opm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.opm.model.opm.OPElementView#getOpd <em>Opd</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.OPElementView#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.opm.model.opm.OPPackage#getOPElementView()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface OPElementView extends EObject {
	/**
	 * Returns the value of the '<em><b>Opd</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.vainolo.opm.model.opm.OPObjectProcessDiagram#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opd</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opd</em>' container reference.
	 * @see #setOpd(OPObjectProcessDiagram)
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPElementView_Opd()
	 * @see com.vainolo.opm.model.opm.OPObjectProcessDiagram#getElements
	 * @model opposite="elements" transient="false"
	 * @generated
	 */
	OPObjectProcessDiagram getOpd();

	/**
	 * Sets the value of the '{@link com.vainolo.opm.model.opm.OPElementView#getOpd <em>Opd</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opd</em>' container reference.
	 * @see #getOpd()
	 * @generated
	 */
	void setOpd(OPObjectProcessDiagram value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(OPElement)
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPElementView_Model()
	 * @model
	 * @generated
	 */
	OPElement getModel();

	/**
	 * Sets the value of the '{@link com.vainolo.opm.model.opm.OPElementView#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(OPElement value);

} // OPElementView
