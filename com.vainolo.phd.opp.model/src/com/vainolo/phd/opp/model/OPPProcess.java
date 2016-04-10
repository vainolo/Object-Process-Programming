/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 */
package com.vainolo.phd.opp.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.vainolo.phd.opp.model.OPPProcess#getKind <em>Kind</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPProcess#getOrder <em>Order</em>}</li>
 * </ul>
 *
 * @see com.vainolo.phd.opp.model.OPPPackage#getOPPProcess()
 * @model
 * @generated
 */
public interface OPPProcess extends OPPThing {
  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The default value is <code>"Compound"</code>.
   * The literals are from the enumeration {@link com.vainolo.phd.opp.model.OPPProcessKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see com.vainolo.phd.opp.model.OPPProcessKind
   * @see #setKind(OPPProcessKind)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPProcess_Kind()
   * @model default="Compound" required="true"
   * @generated
   */
  OPPProcessKind getKind();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPProcess#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see com.vainolo.phd.opp.model.OPPProcessKind
   * @see #getKind()
   * @generated
   */
  void setKind(OPPProcessKind value);

  /**
   * Returns the value of the '<em><b>Order</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Order</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Order</em>' attribute.
   * @see #setOrder(int)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPProcess_Order()
   * @model
   * @generated
   */
  int getOrder();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPProcess#getOrder <em>Order</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Order</em>' attribute.
   * @see #getOrder()
   * @generated
   */
  void setOrder(int value);

} // OPPProcess
