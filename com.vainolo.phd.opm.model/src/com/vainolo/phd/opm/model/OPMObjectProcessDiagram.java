/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model;

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
 *   <li>{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getObjects <em>Objects</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getProcesses <em>Processes</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMObjectProcessDiagram()
 * @model
 * @generated
 */
public interface OPMObjectProcessDiagram extends EObject {
	/**
	 * Returns the value of the '<em><b>Objects</b></em>' containment reference list.
	 * The list contents are of type {@link com.vainolo.phd.opm.model.OPMObject}.
	 * It is bidirectional and its opposite is '{@link com.vainolo.phd.opm.model.OPMObject#getOpd <em>Opd</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objects</em>' containment reference list.
	 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMObjectProcessDiagram_Objects()
	 * @see com.vainolo.phd.opm.model.OPMObject#getOpd
	 * @model opposite="opd" containment="true"
	 * @generated
	 */
	EList<OPMObject> getObjects();

	/**
	 * Returns the value of the '<em><b>Processes</b></em>' containment reference list.
	 * The list contents are of type {@link com.vainolo.phd.opm.model.OPMProcess}.
	 * It is bidirectional and its opposite is '{@link com.vainolo.phd.opm.model.OPMProcess#getOpd <em>Opd</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processes</em>' containment reference list.
	 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMObjectProcessDiagram_Processes()
	 * @see com.vainolo.phd.opm.model.OPMProcess#getOpd
	 * @model opposite="opd" containment="true"
	 * @generated
	 */
	EList<OPMProcess> getProcesses();

	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link com.vainolo.phd.opm.model.OPMLink}.
	 * It is bidirectional and its opposite is '{@link com.vainolo.phd.opm.model.OPMLink#getOpd <em>Opd</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMObjectProcessDiagram_Links()
	 * @see com.vainolo.phd.opm.model.OPMLink#getOpd
	 * @model opposite="opd" containment="true"
	 * @generated
	 */
	EList<OPMLink> getLinks();

} // OPMObjectProcessDiagram
