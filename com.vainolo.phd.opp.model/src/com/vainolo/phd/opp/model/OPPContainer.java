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
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.vainolo.phd.opp.model.OPPContainer#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see com.vainolo.phd.opp.model.OPPPackage#getOPPContainer()
 * @model abstract="true"
 * @generated
 */
public interface OPPContainer extends OPPElement {
  /**
   * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
   * The list contents are of type {@link com.vainolo.phd.opp.model.OPPNode}.
   * It is bidirectional and its opposite is '{@link com.vainolo.phd.opp.model.OPPNode#getContainer <em>Container</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nodes</em>' containment reference list.
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPContainer_Nodes()
   * @see com.vainolo.phd.opp.model.OPPNode#getContainer
   * @model opposite="container" containment="true"
   * @generated
   */
  EList<OPPNode> getNodes();

} // OPPContainer
