/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Procedural Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.OPMProceduralLink#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMProceduralLink()
 * @model
 * @generated
 */
public interface OPMProceduralLink extends OPMLink {
	/**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link com.vainolo.phd.opm.model.OPMProceduralLinkKind}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see com.vainolo.phd.opm.model.OPMProceduralLinkKind
   * @see #setKind(OPMProceduralLinkKind)
   * @see com.vainolo.phd.opm.model.OPMPackage#getOPMProceduralLink_Kind()
   * @model
   * @generated
   */
	OPMProceduralLinkKind getKind();

	/**
   * Sets the value of the '{@link com.vainolo.phd.opm.model.OPMProceduralLink#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see com.vainolo.phd.opm.model.OPMProceduralLinkKind
   * @see #getKind()
   * @generated
   */
	void setKind(OPMProceduralLinkKind value);

} // OPMProceduralLink
