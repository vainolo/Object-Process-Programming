/**
 */
package com.vainolo.opm.model.opm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.opm.model.opm.OPLink#getSource <em>Source</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.OPLink#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.opm.model.opm.OPPackage#getOPLink()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface OPLink extends OPElement {

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.vainolo.opm.model.opm.OPNode#getOutgoingLinks <em>Outgoing Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(OPNode)
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPLink_Source()
	 * @see com.vainolo.opm.model.opm.OPNode#getOutgoingLinks
	 * @model opposite="outgoingLinks"
	 * @generated
	 */
	OPNode getSource();

	/**
	 * Sets the value of the '{@link com.vainolo.opm.model.opm.OPLink#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(OPNode value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.vainolo.opm.model.opm.OPNode#getIncomingLinks <em>Incoming Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(OPNode)
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPLink_Target()
	 * @see com.vainolo.opm.model.opm.OPNode#getIncomingLinks
	 * @model opposite="incomingLinks"
	 * @generated
	 */
	OPNode getTarget();

	/**
	 * Sets the value of the '{@link com.vainolo.opm.model.opm.OPLink#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(OPNode value);
} // OPLink
