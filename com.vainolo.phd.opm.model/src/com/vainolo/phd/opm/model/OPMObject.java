/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.OPMObject#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMObject()
 * @model
 * @generated
 */
public interface OPMObject extends OPMThing {

  /**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"Simple"</code>.
	 * The literals are from the enumeration {@link com.vainolo.phd.opm.model.OPMObjectKind}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see com.vainolo.phd.opm.model.OPMObjectKind
	 * @see #setKind(OPMObjectKind)
	 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMObject_Kind()
	 * @model default="Simple" required="true"
	 * @generated
	 */
  OPMObjectKind getKind();

  /**
	 * Sets the value of the '{@link com.vainolo.phd.opm.model.OPMObject#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see com.vainolo.phd.opm.model.OPMObjectKind
	 * @see #getKind()
	 * @generated
	 */
  void setKind(OPMObjectKind value);

} // OPMObject
