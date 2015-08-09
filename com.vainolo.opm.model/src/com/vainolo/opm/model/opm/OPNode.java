/**
 */
package com.vainolo.opm.model.opm;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.opm.model.opm.OPNode#getName <em>Name</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.OPNode#getIncomingLinks <em>Incoming Links</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.OPNode#getOutgoingLinks <em>Outgoing Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.opm.model.opm.OPPackage#getOPNode()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface OPNode extends OPElement {

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
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPNode_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.vainolo.opm.model.opm.OPNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Incoming Links</b></em>' reference list.
	 * The list contents are of type {@link com.vainolo.opm.model.opm.OPLink}.
	 * It is bidirectional and its opposite is '{@link com.vainolo.opm.model.opm.OPLink#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Links</em>' reference list.
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPNode_IncomingLinks()
	 * @see com.vainolo.opm.model.opm.OPLink#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<OPLink> getIncomingLinks();

	/**
	 * Returns the value of the '<em><b>Outgoing Links</b></em>' reference list.
	 * The list contents are of type {@link com.vainolo.opm.model.opm.OPLink}.
	 * It is bidirectional and its opposite is '{@link com.vainolo.opm.model.opm.OPLink#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Links</em>' reference list.
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPNode_OutgoingLinks()
	 * @see com.vainolo.opm.model.opm.OPLink#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<OPLink> getOutgoingLinks();
} // OPNode
