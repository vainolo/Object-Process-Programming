/**
 */
package com.vainolo.phd.opp.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element With ID</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.phd.opp.model.OPPElementWithID#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opp.model.OPPPackage#getOPPElementWithID()
 * @model abstract="true"
 * @generated
 */
public interface OPPElementWithID extends EObject {
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(long)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPElementWithID_Id()
   * @model id="true"
   * @generated
   */
  long getId();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPElementWithID#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(long value);

} // OPPElementWithID
