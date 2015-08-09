/**
 */
package com.vainolo.opm.model.opm;

import org.eclipse.emf.common.util.EList;
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
 *   <li>{@link com.vainolo.opm.model.opm.OPSystem#getName <em>Name</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.OPSystem#getElements <em>Elements</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPSystem_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.vainolo.opm.model.opm.OPSystem#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link com.vainolo.opm.model.opm.OPElement}.
	 * It is bidirectional and its opposite is '{@link com.vainolo.opm.model.opm.OPElement#getSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPSystem_Elements()
	 * @see com.vainolo.opm.model.opm.OPElement#getSystem
	 * @model opposite="system" containment="true"
	 * @generated
	 */
	EList<OPElement> getElements();

} // OPSystem
