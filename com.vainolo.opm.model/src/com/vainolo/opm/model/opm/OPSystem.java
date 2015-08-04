/**
 */
package com.vainolo.opm.model.opm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.opm.model.opm.OPSystem#getSystemDiagram <em>System Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.opm.model.opm.OPPackage#getOPSystem()
 * @model
 * @generated
 */
public interface OPSystem extends EObject {
	/**
	 * Returns the value of the '<em><b>System Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Diagram</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Diagram</em>' reference.
	 * @see #setSystemDiagram(OPObjectProcessDiagram)
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPSystem_SystemDiagram()
	 * @model
	 * @generated
	 */
	OPObjectProcessDiagram getSystemDiagram();

	/**
	 * Sets the value of the '{@link com.vainolo.opm.model.opm.OPSystem#getSystemDiagram <em>System Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Diagram</em>' reference.
	 * @see #getSystemDiagram()
	 * @generated
	 */
	void setSystemDiagram(OPObjectProcessDiagram value);

} // OPSystem
