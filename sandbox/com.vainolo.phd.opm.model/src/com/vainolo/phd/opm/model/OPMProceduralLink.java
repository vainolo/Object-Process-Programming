/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model;

import org.eclipse.draw2d.geometry.Point;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Procedural Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.OPMProceduralLink#getBendpoints <em>Bendpoints</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMProceduralLink()
 * @model
 * @generated
 */
public interface OPMProceduralLink extends Link {
	/**
     * Returns the value of the '<em><b>Bendpoints</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.draw2d.geometry.Point}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bendpoints</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Bendpoints</em>' attribute list.
     * @see com.vainolo.phd.opm.model.OPMPackage#getOPMProceduralLink_Bendpoints()
     * @model dataType="com.vainolo.phd.opm.model.Point"
     * @generated
     */
	EList<Point> getBendpoints();

} // OPMProceduralLink
