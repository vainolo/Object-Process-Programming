/**
 */
package com.vainolo.opm.model.opm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Process Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.opm.model.opm.OPObjectProcessDiagram#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.opm.model.opm.OPPackage#getOPObjectProcessDiagram()
 * @model
 * @generated
 */
public interface OPObjectProcessDiagram extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link com.vainolo.opm.model.opm.OPElementView}.
	 * It is bidirectional and its opposite is '{@link com.vainolo.opm.model.opm.OPElementView#getOpd <em>Opd</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPObjectProcessDiagram_Elements()
	 * @see com.vainolo.opm.model.opm.OPElementView#getOpd
	 * @model opposite="opd" containment="true"
	 * @generated
	 */
	EList<OPElementView> getElements();

} // OPObjectProcessDiagram
