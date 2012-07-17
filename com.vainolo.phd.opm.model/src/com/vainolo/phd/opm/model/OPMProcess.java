/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Process</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.OPMProcess#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMProcess()
 * @model
 * @generated
 */
public interface OPMProcess extends OPMThing {

  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The default value is <code>""</code>.
   * The literals are from the enumeration {@link com.vainolo.phd.opm.model.OPMProcessKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see com.vainolo.phd.opm.model.OPMProcessKind
   * @see #setKind(OPMProcessKind)
   * @see com.vainolo.phd.opm.model.OPMPackage#getOPMProcess_Kind()
   * @model default="" required="true"
   * @generated
   */
  OPMProcessKind getKind();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opm.model.OPMProcess#getKind <em>Kind</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Kind</em>' attribute.
   * @see com.vainolo.phd.opm.model.OPMProcessKind
   * @see #getKind()
   * @generated
   */
  void setKind(OPMProcessKind value);

} // OPMProcess
