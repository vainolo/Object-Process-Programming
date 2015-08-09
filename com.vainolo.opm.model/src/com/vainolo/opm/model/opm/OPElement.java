/**
 */
package com.vainolo.opm.model.opm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.opm.model.opm.OPElement#getSystem <em>System</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.opm.model.opm.OPPackage#getOPElement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface OPElement extends EObject {

	/**
	 * Returns the value of the '<em><b>System</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.vainolo.opm.model.opm.OPSystem#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System</em>' container reference.
	 * @see #setSystem(OPSystem)
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPElement_System()
	 * @see com.vainolo.opm.model.opm.OPSystem#getElements
	 * @model opposite="elements" transient="false"
	 * @generated
	 */
	OPSystem getSystem();

	/**
	 * Sets the value of the '{@link com.vainolo.opm.model.opm.OPElement#getSystem <em>System</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System</em>' container reference.
	 * @see #getSystem()
	 * @generated
	 */
	void setSystem(OPSystem value);
} // OPElement
