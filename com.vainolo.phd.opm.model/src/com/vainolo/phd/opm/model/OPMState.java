/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.OPMState#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMState()
 * @model
 * @generated
 */
public interface OPMState extends OPMNode {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see com.vainolo.phd.opm.model.OPMPackage#getOPMState_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link com.vainolo.phd.opm.model.OPMState#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

} // OPMState
