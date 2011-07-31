/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.Node#getIncomingLinks <em>Incoming Links</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.Node#getOutgoingLinks <em>Outgoing Links</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.Node#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.Node#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opm.model.OPMPackage#getNode()
 * @model abstract="true"
 * @generated
 */
public interface Node extends EObject {
    /**
     * Returns the value of the '<em><b>Incoming Links</b></em>' reference list.
     * The list contents are of type {@link com.vainolo.phd.opm.model.Link}.
     * It is bidirectional and its opposite is '{@link com.vainolo.phd.opm.model.Link#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Incoming Links</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Incoming Links</em>' reference list.
     * @see com.vainolo.phd.opm.model.OPMPackage#getNode_IncomingLinks()
     * @see com.vainolo.phd.opm.model.Link#getTarget
     * @model opposite="target"
     * @generated
     */
    EList<Link> getIncomingLinks();

    /**
     * Returns the value of the '<em><b>Outgoing Links</b></em>' reference list.
     * The list contents are of type {@link com.vainolo.phd.opm.model.Link}.
     * It is bidirectional and its opposite is '{@link com.vainolo.phd.opm.model.Link#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Outgoing Links</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Outgoing Links</em>' reference list.
     * @see com.vainolo.phd.opm.model.OPMPackage#getNode_OutgoingLinks()
     * @see com.vainolo.phd.opm.model.Link#getSource
     * @model opposite="source"
     * @generated
     */
    EList<Link> getOutgoingLinks();

    /**
     * Returns the value of the '<em><b>Constraints</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Constraints</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Constraints</em>' attribute.
     * @see #setConstraints(Rectangle)
     * @see com.vainolo.phd.opm.model.OPMPackage#getNode_Constraints()
     * @model dataType="com.vainolo.phd.opm.model.Rectangle"
     * @generated
     */
    Rectangle getConstraints();

    /**
     * Sets the value of the '{@link com.vainolo.phd.opm.model.Node#getConstraints <em>Constraints</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Constraints</em>' attribute.
     * @see #getConstraints()
     * @generated
     */
    void setConstraints(Rectangle value);

    /**
     * Returns the value of the '<em><b>Parent</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.vainolo.phd.opm.model.NodeContainer#getNodes <em>Nodes</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parent</em>' container reference.
     * @see #setParent(NodeContainer)
     * @see com.vainolo.phd.opm.model.OPMPackage#getNode_Parent()
     * @see com.vainolo.phd.opm.model.NodeContainer#getNodes
     * @model opposite="nodes" transient="false"
     * @generated
     */
    NodeContainer getParent();

    /**
     * Sets the value of the '{@link com.vainolo.phd.opm.model.Node#getParent <em>Parent</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent</em>' container reference.
     * @see #getParent()
     * @generated
     */
    void setParent(NodeContainer value);

} // Node
