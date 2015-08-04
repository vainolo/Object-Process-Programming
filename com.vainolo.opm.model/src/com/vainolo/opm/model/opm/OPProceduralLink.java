/**
 */
package com.vainolo.opm.model.opm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Procedural Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.opm.model.opm.OPProceduralLink#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.opm.model.opm.OPPackage#getOPProceduralLink()
 * @model
 * @generated
 */
public interface OPProceduralLink extends OPLink {

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link com.vainolo.opm.model.opm.OPProceduralLinkKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see com.vainolo.opm.model.opm.OPProceduralLinkKind
	 * @see #setKind(OPProceduralLinkKind)
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPProceduralLink_Kind()
	 * @model
	 * @generated
	 */
	OPProceduralLinkKind getKind();

	/**
	 * Sets the value of the '{@link com.vainolo.opm.model.opm.OPProceduralLink#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see com.vainolo.opm.model.opm.OPProceduralLinkKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(OPProceduralLinkKind value);
} // OPProceduralLink
