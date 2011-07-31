/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.Link#getSource <em>Source</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.Link#getTarget <em>Target</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.Link#getOpd <em>Opd</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opm.model.OPMPackage#getLink()
 * @model abstract="true"
 * @generated
 */
public interface Link extends EObject {
    /**
     * Returns the value of the '<em><b>Source</b></em>' reference.
     * It is bidirectional and its opposite is '{@link com.vainolo.phd.opm.model.Node#getOutgoingLinks <em>Outgoing Links</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' reference.
     * @see #setSource(Node)
     * @see com.vainolo.phd.opm.model.OPMPackage#getLink_Source()
     * @see com.vainolo.phd.opm.model.Node#getOutgoingLinks
     * @model opposite="outgoingLinks" required="true"
     * @generated
     */
    Node getSource();

    /**
     * Sets the value of the '{@link com.vainolo.phd.opm.model.Link#getSource <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' reference.
     * @see #getSource()
     * @generated
     */
    void setSource(Node value);

    /**
     * Returns the value of the '<em><b>Target</b></em>' reference.
     * It is bidirectional and its opposite is '{@link com.vainolo.phd.opm.model.Node#getIncomingLinks <em>Incoming Links</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target</em>' reference.
     * @see #setTarget(Node)
     * @see com.vainolo.phd.opm.model.OPMPackage#getLink_Target()
     * @see com.vainolo.phd.opm.model.Node#getIncomingLinks
     * @model opposite="incomingLinks" required="true"
     * @generated
     */
    Node getTarget();

    /**
     * Sets the value of the '{@link com.vainolo.phd.opm.model.Link#getTarget <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target</em>' reference.
     * @see #getTarget()
     * @generated
     */
    void setTarget(Node value);

    /**
     * Returns the value of the '<em><b>Opd</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getLinks <em>Links</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Opd</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Opd</em>' container reference.
     * @see #setOpd(OPMObjectProcessDiagram)
     * @see com.vainolo.phd.opm.model.OPMPackage#getLink_Opd()
     * @see com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getLinks
     * @model opposite="links" required="true" transient="false"
     * @generated
     */
    OPMObjectProcessDiagram getOpd();

    /**
     * Sets the value of the '{@link com.vainolo.phd.opm.model.Link#getOpd <em>Opd</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Opd</em>' container reference.
     * @see #getOpd()
     * @generated
     */
    void setOpd(OPMObjectProcessDiagram value);

} // Link
