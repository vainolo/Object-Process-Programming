/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 */
package com.vainolo.phd.opp.model.impl;

import com.vainolo.phd.opp.model.OPPContainer;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPPackage;
import com.vainolo.phd.opp.model.OPPPoint;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPNodeImpl#getIncomingLinks <em>Incoming Links</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPNodeImpl#getOutgoingLinks <em>Outgoing Links</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPNodeImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPNodeImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPNodeImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPNodeImpl#getX <em>X</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPNodeImpl#getY <em>Y</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPNodeImpl#isManualSize <em>Manual Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class OPPNodeImpl extends OPPElementImpl implements OPPNode {
  /**
   * The cached value of the '{@link #getIncomingLinks() <em>Incoming Links</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncomingLinks()
   * @generated
   * @ordered
   */
  protected EList<OPPLink> incomingLinks;

  /**
   * The cached value of the '{@link #getOutgoingLinks() <em>Outgoing Links</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutgoingLinks()
   * @generated
   * @ordered
   */
  protected EList<OPPLink> outgoingLinks;

  /**
   * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWidth()
   * @generated
   * @ordered
   */
  protected static final int WIDTH_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWidth()
   * @generated
   * @ordered
   */
  protected int width = WIDTH_EDEFAULT;

  /**
   * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHeight()
   * @generated
   * @ordered
   */
  protected static final int HEIGHT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHeight()
   * @generated
   * @ordered
   */
  protected int height = HEIGHT_EDEFAULT;

  /**
   * The default value of the '{@link #getX() <em>X</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX()
   * @generated
   * @ordered
   */
  protected static final int X_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getX() <em>X</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX()
   * @generated
   * @ordered
   */
  protected int x = X_EDEFAULT;

  /**
   * The default value of the '{@link #getY() <em>Y</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getY()
   * @generated
   * @ordered
   */
  protected static final int Y_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getY()
   * @generated
   * @ordered
   */
  protected int y = Y_EDEFAULT;

  /**
   * The default value of the '{@link #isManualSize() <em>Manual Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isManualSize()
   * @generated
   * @ordered
   */
  protected static final boolean MANUAL_SIZE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isManualSize() <em>Manual Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isManualSize()
   * @generated
   * @ordered
   */
  protected boolean manualSize = MANUAL_SIZE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OPPNodeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return OPPPackage.Literals.OPP_NODE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<OPPLink> getIncomingLinks() {
    if (incomingLinks == null) {
      incomingLinks = new EObjectWithInverseResolvingEList<>(OPPLink.class, this, OPPPackage.OPP_NODE__INCOMING_LINKS, OPPPackage.OPP_LINK__TARGET);
    }
    return incomingLinks;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<OPPLink> getOutgoingLinks() {
    if (outgoingLinks == null) {
      outgoingLinks = new EObjectWithInverseResolvingEList<>(OPPLink.class, this, OPPPackage.OPP_NODE__OUTGOING_LINKS, OPPPackage.OPP_LINK__SOURCE);
    }
    return outgoingLinks;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPContainer getContainer() {
    if (eContainerFeatureID() != OPPPackage.OPP_NODE__CONTAINER) return null;
    return (OPPContainer)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContainer(OPPContainer newContainer, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newContainer, OPPPackage.OPP_NODE__CONTAINER, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContainer(OPPContainer newContainer) {
    if (newContainer != eInternalContainer() || (eContainerFeatureID() != OPPPackage.OPP_NODE__CONTAINER && newContainer != null)) {
      if (EcoreUtil.isAncestor(this, newContainer))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newContainer != null)
        msgs = ((InternalEObject)newContainer).eInverseAdd(this, OPPPackage.OPP_CONTAINER__NODES, OPPContainer.class, msgs);
      msgs = basicSetContainer(newContainer, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_NODE__CONTAINER, newContainer, newContainer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getWidth() {
    return width;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWidth(int newWidth) {
    int oldWidth = width;
    width = newWidth;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_NODE__WIDTH, oldWidth, width));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getHeight() {
    return height;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHeight(int newHeight) {
    int oldHeight = height;
    height = newHeight;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_NODE__HEIGHT, oldHeight, height));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getX() {
    return x;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX(int newX) {
    int oldX = x;
    x = newX;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_NODE__X, oldX, x));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getY() {
    return y;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setY(int newY) {
    int oldY = y;
    y = newY;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_NODE__Y, oldY, y));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isManualSize() {
    return manualSize;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setManualSize(boolean newManualSize) {
    boolean oldManualSize = manualSize;
    manualSize = newManualSize;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_NODE__MANUAL_SIZE, oldManualSize, manualSize));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public void setConstraints(int x, int y, int width, int height) {
    setX(x);
    setY(y);
    setWidth(width);
    setHeight(height);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case OPPPackage.OPP_NODE__INCOMING_LINKS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingLinks()).basicAdd(otherEnd, msgs);
      case OPPPackage.OPP_NODE__OUTGOING_LINKS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingLinks()).basicAdd(otherEnd, msgs);
      case OPPPackage.OPP_NODE__CONTAINER:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetContainer((OPPContainer)otherEnd, msgs);
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
      case OPPPackage.OPP_NODE__INCOMING_LINKS:
        return ((InternalEList<?>)getIncomingLinks()).basicRemove(otherEnd, msgs);
      case OPPPackage.OPP_NODE__OUTGOING_LINKS:
        return ((InternalEList<?>)getOutgoingLinks()).basicRemove(otherEnd, msgs);
      case OPPPackage.OPP_NODE__CONTAINER:
        return basicSetContainer(null, msgs);
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
      case OPPPackage.OPP_NODE__CONTAINER:
        return eInternalContainer().eInverseRemove(this, OPPPackage.OPP_CONTAINER__NODES, OPPContainer.class, msgs);
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
      case OPPPackage.OPP_NODE__INCOMING_LINKS:
        return getIncomingLinks();
      case OPPPackage.OPP_NODE__OUTGOING_LINKS:
        return getOutgoingLinks();
      case OPPPackage.OPP_NODE__CONTAINER:
        return getContainer();
      case OPPPackage.OPP_NODE__WIDTH:
        return getWidth();
      case OPPPackage.OPP_NODE__HEIGHT:
        return getHeight();
      case OPPPackage.OPP_NODE__X:
        return getX();
      case OPPPackage.OPP_NODE__Y:
        return getY();
      case OPPPackage.OPP_NODE__MANUAL_SIZE:
        return isManualSize();
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
      case OPPPackage.OPP_NODE__INCOMING_LINKS:
        getIncomingLinks().clear();
        getIncomingLinks().addAll((Collection<? extends OPPLink>)newValue);
        return;
      case OPPPackage.OPP_NODE__OUTGOING_LINKS:
        getOutgoingLinks().clear();
        getOutgoingLinks().addAll((Collection<? extends OPPLink>)newValue);
        return;
      case OPPPackage.OPP_NODE__CONTAINER:
        setContainer((OPPContainer)newValue);
        return;
      case OPPPackage.OPP_NODE__WIDTH:
        setWidth((Integer)newValue);
        return;
      case OPPPackage.OPP_NODE__HEIGHT:
        setHeight((Integer)newValue);
        return;
      case OPPPackage.OPP_NODE__X:
        setX((Integer)newValue);
        return;
      case OPPPackage.OPP_NODE__Y:
        setY((Integer)newValue);
        return;
      case OPPPackage.OPP_NODE__MANUAL_SIZE:
        setManualSize((Boolean)newValue);
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
      case OPPPackage.OPP_NODE__INCOMING_LINKS:
        getIncomingLinks().clear();
        return;
      case OPPPackage.OPP_NODE__OUTGOING_LINKS:
        getOutgoingLinks().clear();
        return;
      case OPPPackage.OPP_NODE__CONTAINER:
        setContainer((OPPContainer)null);
        return;
      case OPPPackage.OPP_NODE__WIDTH:
        setWidth(WIDTH_EDEFAULT);
        return;
      case OPPPackage.OPP_NODE__HEIGHT:
        setHeight(HEIGHT_EDEFAULT);
        return;
      case OPPPackage.OPP_NODE__X:
        setX(X_EDEFAULT);
        return;
      case OPPPackage.OPP_NODE__Y:
        setY(Y_EDEFAULT);
        return;
      case OPPPackage.OPP_NODE__MANUAL_SIZE:
        setManualSize(MANUAL_SIZE_EDEFAULT);
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
      case OPPPackage.OPP_NODE__INCOMING_LINKS:
        return incomingLinks != null && !incomingLinks.isEmpty();
      case OPPPackage.OPP_NODE__OUTGOING_LINKS:
        return outgoingLinks != null && !outgoingLinks.isEmpty();
      case OPPPackage.OPP_NODE__CONTAINER:
        return getContainer() != null;
      case OPPPackage.OPP_NODE__WIDTH:
        return width != WIDTH_EDEFAULT;
      case OPPPackage.OPP_NODE__HEIGHT:
        return height != HEIGHT_EDEFAULT;
      case OPPPackage.OPP_NODE__X:
        return x != X_EDEFAULT;
      case OPPPackage.OPP_NODE__Y:
        return y != Y_EDEFAULT;
      case OPPPackage.OPP_NODE__MANUAL_SIZE:
        return manualSize != MANUAL_SIZE_EDEFAULT;
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
    result.append(" (width: ");
    result.append(width);
    result.append(", height: ");
    result.append(height);
    result.append(", x: ");
    result.append(x);
    result.append(", y: ");
    result.append(y);
    result.append(", manualSize: ");
    result.append(manualSize);
    result.append(')');
    return result.toString();
  }

} //OPPNodeImpl
