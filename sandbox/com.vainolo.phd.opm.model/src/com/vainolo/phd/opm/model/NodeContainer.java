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
 * A representation of the model object '<em><b>Node Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.NodeContainer#getNodes <em>Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opm.model.OPMPackage#getNodeContainer()
 * @model
 * @generated
 */
public interface NodeContainer extends EObject {
    /**
     * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
     * The list contents are of type {@link com.vainolo.phd.opm.model.Node}.
     * It is bidirectional and its opposite is '{@link com.vainolo.phd.opm.model.Node#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Nodes</em>' containment reference list.
     * @see com.vainolo.phd.opm.model.OPMPackage#getNodeContainer_Nodes()
     * @see com.vainolo.phd.opm.model.Node#getParent
     * @model opposite="parent" containment="true"
     * @generated
     */
    EList<Node> getNodes();

} // NodeContainer
