/**
 */
package com.vainolo.opm.model.opm;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.opm.model.opm.OPNodeView#getX <em>X</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.OPNodeView#getY <em>Y</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.OPNodeView#getWidth <em>Width</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.OPNodeView#getHeight <em>Height</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.OPNodeView#getIncomingLinks <em>Incoming Links</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.OPNodeView#getOutgoingLinks <em>Outgoing Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.opm.model.opm.OPPackage#getOPNodeView()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface OPNodeView extends OPElementView {

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(int)
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPNodeView_X()
	 * @model
	 * @generated
	 */
	int getX();

	/**
	 * Sets the value of the '{@link com.vainolo.opm.model.opm.OPNodeView#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(int value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(int)
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPNodeView_Y()
	 * @model
	 * @generated
	 */
	int getY();

	/**
	 * Sets the value of the '{@link com.vainolo.opm.model.opm.OPNodeView#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPNodeView_Width()
	 * @model
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link com.vainolo.opm.model.opm.OPNodeView#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(int)
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPNodeView_Height()
	 * @model
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link com.vainolo.opm.model.opm.OPNodeView#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

	/**
	 * Returns the value of the '<em><b>Incoming Links</b></em>' reference list.
	 * The list contents are of type {@link com.vainolo.opm.model.opm.OPLinkView}.
	 * It is bidirectional and its opposite is '{@link com.vainolo.opm.model.opm.OPLinkView#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Links</em>' reference list.
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPNodeView_IncomingLinks()
	 * @see com.vainolo.opm.model.opm.OPLinkView#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<OPLinkView> getIncomingLinks();

	/**
	 * Returns the value of the '<em><b>Outgoing Links</b></em>' reference list.
	 * The list contents are of type {@link com.vainolo.opm.model.opm.OPLinkView}.
	 * It is bidirectional and its opposite is '{@link com.vainolo.opm.model.opm.OPLinkView#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Links</em>' reference list.
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPNodeView_OutgoingLinks()
	 * @see com.vainolo.opm.model.opm.OPLinkView#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<OPLinkView> getOutgoingLinks();
} // OPNodeView
