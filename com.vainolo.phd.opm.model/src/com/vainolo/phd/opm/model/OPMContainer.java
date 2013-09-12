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
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Container</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.OPMContainer#getNodes <em>Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMContainer()
 * @model abstract="true"
 * @generated
 */
public interface OPMContainer extends OPMElementWithID {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link com.vainolo.phd.opm.model.OPMNode}.
	 * It is bidirectional and its opposite is '{@link com.vainolo.phd.opm.model.OPMNode#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMContainer_Nodes()
	 * @see com.vainolo.phd.opm.model.OPMNode#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	EList<OPMNode> getNodes();

} // OPMContainer
