/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 */
package com.vainolo.phd.opp.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Procedural Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.vainolo.phd.opp.model.OPPProceduralLink#getKind <em>Kind</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPProceduralLink#getSubKinds <em>Sub Kinds</em>}</li>
 * </ul>
 *
 * @see com.vainolo.phd.opp.model.OPPPackage#getOPPProceduralLink()
 * @model
 * @generated
 */
public interface OPPProceduralLink extends OPPLink {
  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link com.vainolo.phd.opp.model.OPPProceduralLinkKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see com.vainolo.phd.opp.model.OPPProceduralLinkKind
   * @see #setKind(OPPProceduralLinkKind)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPProceduralLink_Kind()
   * @model
   * @generated
   */
  OPPProceduralLinkKind getKind();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPProceduralLink#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see com.vainolo.phd.opp.model.OPPProceduralLinkKind
   * @see #getKind()
   * @generated
   */
  void setKind(OPPProceduralLinkKind value);

  /**
   * Returns the value of the '<em><b>Sub Kinds</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Kinds</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Kinds</em>' attribute list.
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPProceduralLink_SubKinds()
   * @model
   * @generated
   */
  EList<String> getSubKinds();

} // OPPProceduralLink
