/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package opm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Thing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link opm.OPMThing#getIncomingLinks <em>Incoming Links</em>}</li>
 *   <li>{@link opm.OPMThing#getOutgoingLinks <em>Outgoing Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see opm.OPMPackage#getOPMThing()
 * @model
 * @generated
 */
public interface OPMThing extends EObject {
	/**
	 * Returns the value of the '<em><b>Incoming Links</b></em>' reference list.
	 * The list contents are of type {@link opm.OPMLink}.
	 * It is bidirectional and its opposite is '{@link opm.OPMLink#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Links</em>' reference list.
	 * @see opm.OPMPackage#getOPMThing_IncomingLinks()
	 * @see opm.OPMLink#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<OPMLink> getIncomingLinks();

	/**
	 * Returns the value of the '<em><b>Outgoing Links</b></em>' reference list.
	 * The list contents are of type {@link opm.OPMLink}.
	 * It is bidirectional and its opposite is '{@link opm.OPMLink#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Links</em>' reference list.
	 * @see opm.OPMPackage#getOPMThing_OutgoingLinks()
	 * @see opm.OPMLink#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<OPMLink> getOutgoingLinks();

} // OPMThing
