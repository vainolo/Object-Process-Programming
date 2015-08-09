/**
 */
package com.vainolo.opm.model.opm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structural Link Aggregator View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.opm.model.opm.OPStructuralLinkAggregatorView#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.opm.model.opm.OPPackage#getOPStructuralLinkAggregatorView()
 * @model
 * @generated
 */
public interface OPStructuralLinkAggregatorView extends OPNodeView {

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link com.vainolo.opm.model.opm.OPStructuralLinkKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see com.vainolo.opm.model.opm.OPStructuralLinkKind
	 * @see #setKind(OPStructuralLinkKind)
	 * @see com.vainolo.opm.model.opm.OPPackage#getOPStructuralLinkAggregatorView_Kind()
	 * @model
	 * @generated
	 */
	OPStructuralLinkKind getKind();

	/**
	 * Sets the value of the '{@link com.vainolo.opm.model.opm.OPStructuralLinkAggregatorView#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see com.vainolo.opm.model.opm.OPStructuralLinkKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(OPStructuralLinkKind value);
} // OPStructuralLinkAggregatorView
