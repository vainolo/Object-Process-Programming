/**
 */
package com.vainolo.opm.model.opm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.opm.model.opm.OPLinkView#getSource <em>Source</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.OPLinkView#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.opm.model.opm.OPPackage#getOPLinkView()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface OPLinkView extends OPElementView {

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.vainolo.opm.model.opm.OPNodeView#getOutgoingLinks <em>Outgoing Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(OPNodeView)
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPLinkView_Source()
	 * @see com.vainolo.opm.model.opm.OPNodeView#getOutgoingLinks
	 * @model opposite="outgoingLinks"
	 * @generated
	 */
	OPNodeView getSource();

	/**
	 * Sets the value of the '{@link com.vainolo.opm.model.opm.OPLinkView#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(OPNodeView value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.vainolo.opm.model.opm.OPNodeView#getIncomingLinks <em>Incoming Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(OPNodeView)
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPLinkView_Target()
	 * @see com.vainolo.opm.model.opm.OPNodeView#getIncomingLinks
	 * @model opposite="incomingLinks"
	 * @generated
	 */
	OPNodeView getTarget();

	/**
	 * Sets the value of the '{@link com.vainolo.opm.model.opm.OPLinkView#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(OPNodeView value);
} // OPLinkView
