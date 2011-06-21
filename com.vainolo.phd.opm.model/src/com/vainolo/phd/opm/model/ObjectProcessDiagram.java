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
 *   <li>{@link com.vainolo.phd.opm.model.ObjectProcessDiagram#getObjects <em>Objects</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.ObjectProcessDiagram#getProcesses <em>Processes</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.ObjectProcessDiagram#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opm.model.OPMPackage#getObjectProcessDiagram()
 * @model
 * @generated
 */
public interface ObjectProcessDiagram extends EObject {
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
	 * @see com.vainolo.phd.opm.model.OPMPackage#getObjectProcessDiagram_Objects()
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
	 * @see com.vainolo.phd.opm.model.OPMPackage#getObjectProcessDiagram_Processes()
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
	 * @see com.vainolo.phd.opm.model.OPMPackage#getObjectProcessDiagram_Links()
	 * @see com.vainolo.phd.opm.model.OPMLink#getOpd
	 * @model opposite="opd" containment="true"
	 * @generated
	 */
	EList<OPMLink> getLinks();

} // ObjectProcessDiagram
