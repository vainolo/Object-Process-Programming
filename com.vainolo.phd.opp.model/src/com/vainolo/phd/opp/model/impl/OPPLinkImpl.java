/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 */
package com.vainolo.phd.opp.model.impl;

import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPLinkRouterKind;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPPackage;

import com.vainolo.phd.opp.model.OPPPoint;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPLinkImpl#getOpd <em>Opd</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPLinkImpl#getSource <em>Source</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPLinkImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPLinkImpl#getSourceDecoration <em>Source Decoration</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPLinkImpl#getTargetDecoration <em>Target Decoration</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPLinkImpl#getCenterDecoration <em>Center Decoration</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPLinkImpl#getBendpoints <em>Bendpoints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OPPLinkImpl extends OPPElementImpl implements OPPLink {
  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected OPPNode source;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected OPPNode target;

  /**
   * The default value of the '{@link #getSourceDecoration() <em>Source Decoration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceDecoration()
   * @generated
   * @ordered
   */
  protected static final String SOURCE_DECORATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSourceDecoration() <em>Source Decoration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceDecoration()
   * @generated
   * @ordered
   */
  protected String sourceDecoration = SOURCE_DECORATION_EDEFAULT;

  /**
   * The default value of the '{@link #getTargetDecoration() <em>Target Decoration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetDecoration()
   * @generated
   * @ordered
   */
  protected static final String TARGET_DECORATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTargetDecoration() <em>Target Decoration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetDecoration()
   * @generated
   * @ordered
   */
  protected String targetDecoration = TARGET_DECORATION_EDEFAULT;

  /**
   * The default value of the '{@link #getCenterDecoration() <em>Center Decoration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCenterDecoration()
   * @generated
   * @ordered
   */
  protected static final String CENTER_DECORATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCenterDecoration() <em>Center Decoration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCenterDecoration()
   * @generated
   * @ordered
   */
  protected String centerDecoration = CENTER_DECORATION_EDEFAULT;

  /**
   * The cached value of the '{@link #getBendpoints() <em>Bendpoints</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBendpoints()
   * @generated
   * @ordered
   */
  protected EList<OPPPoint> bendpoints;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OPPLinkImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return OPPPackage.Literals.OPP_LINK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPObjectProcessDiagram getOpd() {
    if (eContainerFeatureID() != OPPPackage.OPP_LINK__OPD) return null;
    return (OPPObjectProcessDiagram)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOpd(OPPObjectProcessDiagram newOpd, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newOpd, OPPPackage.OPP_LINK__OPD, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpd(OPPObjectProcessDiagram newOpd) {
    if (newOpd != eInternalContainer() || (eContainerFeatureID() != OPPPackage.OPP_LINK__OPD && newOpd != null)) {
      if (EcoreUtil.isAncestor(this, newOpd))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newOpd != null)
        msgs = ((InternalEObject)newOpd).eInverseAdd(this, OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__LINKS, OPPObjectProcessDiagram.class, msgs);
      msgs = basicSetOpd(newOpd, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_LINK__OPD, newOpd, newOpd));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPNode getSource() {
    if (source != null && source.eIsProxy()) {
      InternalEObject oldSource = (InternalEObject)source;
      source = (OPPNode)eResolveProxy(oldSource);
      if (source != oldSource) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPPPackage.OPP_LINK__SOURCE, oldSource, source));
      }
    }
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPNode basicGetSource() {
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSource(OPPNode newSource, NotificationChain msgs) {
    OPPNode oldSource = source;
    source = newSource;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_LINK__SOURCE, oldSource, newSource);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSource(OPPNode newSource) {
    if (newSource != source) {
      NotificationChain msgs = null;
      if (source != null)
        msgs = ((InternalEObject)source).eInverseRemove(this, OPPPackage.OPP_NODE__OUTGOING_LINKS, OPPNode.class, msgs);
      if (newSource != null)
        msgs = ((InternalEObject)newSource).eInverseAdd(this, OPPPackage.OPP_NODE__OUTGOING_LINKS, OPPNode.class, msgs);
      msgs = basicSetSource(newSource, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_LINK__SOURCE, newSource, newSource));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPNode getTarget() {
    if (target != null && target.eIsProxy()) {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (OPPNode)eResolveProxy(oldTarget);
      if (target != oldTarget) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPPPackage.OPP_LINK__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPNode basicGetTarget() {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(OPPNode newTarget) {
    if (newTarget != target) {
      NotificationChain msgs = null;
      if (target != null)
        msgs = ((InternalEObject)target).eInverseRemove(this, OPPPackage.OPP_NODE__INCOMING_LINKS, OPPNode.class, msgs);
      if (newTarget != null)
        msgs = ((InternalEObject)newTarget).eInverseAdd(this, OPPPackage.OPP_NODE__INCOMING_LINKS, OPPNode.class, msgs);
      msgs = basicSetTarget(newTarget, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_LINK__TARGET, newTarget, newTarget));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSourceDecoration() {
    return sourceDecoration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSourceDecoration(String newSourceDecoration) {
    String oldSourceDecoration = sourceDecoration;
    sourceDecoration = newSourceDecoration;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_LINK__SOURCE_DECORATION, oldSourceDecoration, sourceDecoration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTargetDecoration() {
    return targetDecoration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetDecoration(String newTargetDecoration) {
    String oldTargetDecoration = targetDecoration;
    targetDecoration = newTargetDecoration;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_LINK__TARGET_DECORATION, oldTargetDecoration, targetDecoration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTarget(OPPNode newTarget, NotificationChain msgs) {
    OPPNode oldTarget = target;
    target = newTarget;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_LINK__TARGET, oldTarget, newTarget);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCenterDecoration() {
    return centerDecoration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCenterDecoration(String newCenterDecoration) {
    String oldCenterDecoration = centerDecoration;
    centerDecoration = newCenterDecoration;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_LINK__CENTER_DECORATION, oldCenterDecoration, centerDecoration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<OPPPoint> getBendpoints() {
    if (bendpoints == null) {
      bendpoints = new EObjectContainmentEList<OPPPoint>(OPPPoint.class, this, OPPPackage.OPP_LINK__BENDPOINTS);
    }
    return bendpoints;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case OPPPackage.OPP_LINK__OPD:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetOpd((OPPObjectProcessDiagram)otherEnd, msgs);
      case OPPPackage.OPP_LINK__SOURCE:
        if (source != null)
          msgs = ((InternalEObject)source).eInverseRemove(this, OPPPackage.OPP_NODE__OUTGOING_LINKS, OPPNode.class, msgs);
        return basicSetSource((OPPNode)otherEnd, msgs);
      case OPPPackage.OPP_LINK__TARGET:
        if (target != null)
          msgs = ((InternalEObject)target).eInverseRemove(this, OPPPackage.OPP_NODE__INCOMING_LINKS, OPPNode.class, msgs);
        return basicSetTarget((OPPNode)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case OPPPackage.OPP_LINK__OPD:
        return basicSetOpd(null, msgs);
      case OPPPackage.OPP_LINK__SOURCE:
        return basicSetSource(null, msgs);
      case OPPPackage.OPP_LINK__TARGET:
        return basicSetTarget(null, msgs);
      case OPPPackage.OPP_LINK__BENDPOINTS:
        return ((InternalEList<?>)getBendpoints()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID()) {
      case OPPPackage.OPP_LINK__OPD:
        return eInternalContainer().eInverseRemove(this, OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__LINKS, OPPObjectProcessDiagram.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case OPPPackage.OPP_LINK__OPD:
        return getOpd();
      case OPPPackage.OPP_LINK__SOURCE:
        if (resolve) return getSource();
        return basicGetSource();
      case OPPPackage.OPP_LINK__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case OPPPackage.OPP_LINK__SOURCE_DECORATION:
        return getSourceDecoration();
      case OPPPackage.OPP_LINK__TARGET_DECORATION:
        return getTargetDecoration();
      case OPPPackage.OPP_LINK__CENTER_DECORATION:
        return getCenterDecoration();
      case OPPPackage.OPP_LINK__BENDPOINTS:
        return getBendpoints();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case OPPPackage.OPP_LINK__OPD:
        setOpd((OPPObjectProcessDiagram)newValue);
        return;
      case OPPPackage.OPP_LINK__SOURCE:
        setSource((OPPNode)newValue);
        return;
      case OPPPackage.OPP_LINK__TARGET:
        setTarget((OPPNode)newValue);
        return;
      case OPPPackage.OPP_LINK__SOURCE_DECORATION:
        setSourceDecoration((String)newValue);
        return;
      case OPPPackage.OPP_LINK__TARGET_DECORATION:
        setTargetDecoration((String)newValue);
        return;
      case OPPPackage.OPP_LINK__CENTER_DECORATION:
        setCenterDecoration((String)newValue);
        return;
      case OPPPackage.OPP_LINK__BENDPOINTS:
        getBendpoints().clear();
        getBendpoints().addAll((Collection<? extends OPPPoint>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case OPPPackage.OPP_LINK__OPD:
        setOpd((OPPObjectProcessDiagram)null);
        return;
      case OPPPackage.OPP_LINK__SOURCE:
        setSource((OPPNode)null);
        return;
      case OPPPackage.OPP_LINK__TARGET:
        setTarget((OPPNode)null);
        return;
      case OPPPackage.OPP_LINK__SOURCE_DECORATION:
        setSourceDecoration(SOURCE_DECORATION_EDEFAULT);
        return;
      case OPPPackage.OPP_LINK__TARGET_DECORATION:
        setTargetDecoration(TARGET_DECORATION_EDEFAULT);
        return;
      case OPPPackage.OPP_LINK__CENTER_DECORATION:
        setCenterDecoration(CENTER_DECORATION_EDEFAULT);
        return;
      case OPPPackage.OPP_LINK__BENDPOINTS:
        getBendpoints().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case OPPPackage.OPP_LINK__OPD:
        return getOpd() != null;
      case OPPPackage.OPP_LINK__SOURCE:
        return source != null;
      case OPPPackage.OPP_LINK__TARGET:
        return target != null;
      case OPPPackage.OPP_LINK__SOURCE_DECORATION:
        return SOURCE_DECORATION_EDEFAULT == null ? sourceDecoration != null : !SOURCE_DECORATION_EDEFAULT.equals(sourceDecoration);
      case OPPPackage.OPP_LINK__TARGET_DECORATION:
        return TARGET_DECORATION_EDEFAULT == null ? targetDecoration != null : !TARGET_DECORATION_EDEFAULT.equals(targetDecoration);
      case OPPPackage.OPP_LINK__CENTER_DECORATION:
        return CENTER_DECORATION_EDEFAULT == null ? centerDecoration != null : !CENTER_DECORATION_EDEFAULT.equals(centerDecoration);
      case OPPPackage.OPP_LINK__BENDPOINTS:
        return bendpoints != null && !bendpoints.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (sourceDecoration: ");
    result.append(sourceDecoration);
    result.append(", targetDecoration: ");
    result.append(targetDecoration);
    result.append(", centerDecoration: ");
    result.append(centerDecoration);
    result.append(')');
    return result.toString();
  }

} //OPPLinkImpl
