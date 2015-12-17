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
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.phd.opp.model.OPPLink#getOpd <em>Opd</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPLink#getSource <em>Source</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPLink#getTarget <em>Target</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPLink#getSourceDecoration <em>Source Decoration</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPLink#getTargetDecoration <em>Target Decoration</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPLink#getCenterDecoration <em>Center Decoration</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPLink#getBendpoints <em>Bendpoints</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opp.model.OPPPackage#getOPPLink()
 * @model
 * @generated
 */
public interface OPPLink extends OPPElement {
  /**
   * Returns the value of the '<em><b>Opd</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link com.vainolo.phd.opp.model.OPPObjectProcessDiagram#getLinks <em>Links</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Opd</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Opd</em>' container reference.
   * @see #setOpd(OPPObjectProcessDiagram)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPLink_Opd()
   * @see com.vainolo.phd.opp.model.OPPObjectProcessDiagram#getLinks
   * @model opposite="links" transient="false"
   * @generated
   */
  OPPObjectProcessDiagram getOpd();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPLink#getOpd <em>Opd</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opd</em>' container reference.
   * @see #getOpd()
   * @generated
   */
  void setOpd(OPPObjectProcessDiagram value);

  /**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * It is bidirectional and its opposite is '{@link com.vainolo.phd.opp.model.OPPNode#getOutgoingLinks <em>Outgoing Links</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(OPPNode)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPLink_Source()
   * @see com.vainolo.phd.opp.model.OPPNode#getOutgoingLinks
   * @model opposite="outgoingLinks"
   * @generated
   */
  OPPNode getSource();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPLink#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
  void setSource(OPPNode value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * It is bidirectional and its opposite is '{@link com.vainolo.phd.opp.model.OPPNode#getIncomingLinks <em>Incoming Links</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(OPPNode)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPLink_Target()
   * @see com.vainolo.phd.opp.model.OPPNode#getIncomingLinks
   * @model opposite="incomingLinks"
   * @generated
   */
  OPPNode getTarget();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPLink#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(OPPNode value);

  /**
   * Returns the value of the '<em><b>Source Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source Decoration</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source Decoration</em>' attribute.
   * @see #setSourceDecoration(String)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPLink_SourceDecoration()
   * @model
   * @generated
   */
  String getSourceDecoration();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPLink#getSourceDecoration <em>Source Decoration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source Decoration</em>' attribute.
   * @see #getSourceDecoration()
   * @generated
   */
  void setSourceDecoration(String value);

  /**
   * Returns the value of the '<em><b>Target Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Decoration</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Decoration</em>' attribute.
   * @see #setTargetDecoration(String)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPLink_TargetDecoration()
   * @model
   * @generated
   */
  String getTargetDecoration();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPLink#getTargetDecoration <em>Target Decoration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Decoration</em>' attribute.
   * @see #getTargetDecoration()
   * @generated
   */
  void setTargetDecoration(String value);

  /**
   * Returns the value of the '<em><b>Center Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Center Decoration</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Center Decoration</em>' attribute.
   * @see #setCenterDecoration(String)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPLink_CenterDecoration()
   * @model
   * @generated
   */
  String getCenterDecoration();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPLink#getCenterDecoration <em>Center Decoration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Center Decoration</em>' attribute.
   * @see #getCenterDecoration()
   * @generated
   */
  void setCenterDecoration(String value);

  /**
   * Returns the value of the '<em><b>Bendpoints</b></em>' containment reference list.
   * The list contents are of type {@link com.vainolo.phd.opp.model.OPPPoint}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bendpoints</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bendpoints</em>' containment reference list.
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPLink_Bendpoints()
   * @model containment="true"
   * @generated
   */
  EList<OPPPoint> getBendpoints();

} // OPPLink
