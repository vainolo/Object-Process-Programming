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
 * A representation of the model object '<em><b>Thing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.vainolo.phd.opp.model.OPPThing#getDescription <em>Description</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPThing#isMain <em>Main</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPThing#isAbstract <em>Abstract</em>}</li>
 * </ul>
 *
 * @see com.vainolo.phd.opp.model.OPPPackage#getOPPThing()
 * @model abstract="true"
 * @generated
 */
public interface OPPThing extends OPPNode, OPPContainer, OPPNamedElement {
  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPThing_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPThing#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Main</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Main</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Main</em>' attribute.
   * @see #setMain(boolean)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPThing_Main()
   * @model default="false" required="true"
   * @generated
   */
  boolean isMain();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPThing#isMain <em>Main</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Main</em>' attribute.
   * @see #isMain()
   * @generated
   */
  void setMain(boolean value);

  /**
   * Returns the value of the '<em><b>Abstract</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' attribute.
   * @see #setAbstract(boolean)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPThing_Abstract()
   * @model default="false"
   * @generated
   */
  boolean isAbstract();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPThing#isAbstract <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' attribute.
   * @see #isAbstract()
   * @generated
   */
  void setAbstract(boolean value);

} // OPPThing
