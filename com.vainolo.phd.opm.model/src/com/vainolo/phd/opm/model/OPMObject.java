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
 *   <li>{@link com.vainolo.phd.opm.model.OPMObject#isParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMObject()
 * @model
 * @generated
 */
public interface OPMObject extends OPMThing {

  /**
   * Returns the value of the '<em><b>Parameter</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' attribute.
   * @see #setParameter(boolean)
   * @see com.vainolo.phd.opm.model.OPMPackage#getOPMObject_Parameter()
   * @model default="false" required="true"
   * @generated
   */
	boolean isParameter();

		/**
   * Sets the value of the '{@link com.vainolo.phd.opm.model.OPMObject#isParameter <em>Parameter</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter</em>' attribute.
   * @see #isParameter()
   * @generated
   */
	void setParameter(boolean value);

} // OPMObject
