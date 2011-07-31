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
 *   <li>{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMObjectProcessDiagram()
 * @model
 * @generated
 */
public interface OPMObjectProcessDiagram extends NodeContainer {
	/**
     * Returns the value of the '<em><b>Links</b></em>' containment reference list.
     * The list contents are of type {@link com.vainolo.phd.opm.model.Link}.
     * It is bidirectional and its opposite is '{@link com.vainolo.phd.opm.model.Link#getOpd <em>Opd</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Links</em>' containment reference list.
     * @see com.vainolo.phd.opm.model.OPMPackage#getOPMObjectProcessDiagram_Links()
     * @see com.vainolo.phd.opm.model.Link#getOpd
     * @model opposite="opd" containment="true"
     * @generated
     */
    EList<Link> getLinks();

} // OPMObjectProcessDiagram
