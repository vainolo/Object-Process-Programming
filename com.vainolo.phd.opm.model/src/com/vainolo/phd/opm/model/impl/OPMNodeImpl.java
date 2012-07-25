/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package com.vainolo.phd.opm.model.impl;

import java.util.Collection;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Node</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.impl.OPMNodeImpl#getIncomingLinks <em>Incoming Links</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.impl.OPMNodeImpl#getOutgoingLinks <em>Outgoing Links</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.impl.OPMNodeImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.impl.OPMNodeImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class OPMNodeImpl extends OPMElementWithIDImpl implements OPMNode {
  /**
   * The cached value of the '{@link #getIncomingLinks() <em>Incoming Links</em>}' reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see #getIncomingLinks()
   * @generated
   * @ordered
   */
  protected EList<OPMLink> incomingLinks;

  /**
   * The cached value of the '{@link #getOutgoingLinks() <em>Outgoing Links</em>}' reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see #getOutgoingLinks()
   * @generated
   * @ordered
   */
  protected EList<OPMLink> outgoingLinks;

  /**
   * The default value of the '{@link #getConstraints() <em>Constraints</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getConstraints()
   * @generated
   * @ordered
   */
  protected static final Rectangle CONSTRAINTS_EDEFAULT = (Rectangle)OPMFactory.eINSTANCE.createFromString(OPMPackage.eINSTANCE.getRectangle(), "0,0,50,50");

  /**
   * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getConstraints()
   * @generated
   * @ordered
   */
  protected Rectangle constraints = CONSTRAINTS_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected OPMNodeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return OPMPackage.Literals.OPM_NODE;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<OPMLink> getIncomingLinks() {
    if (incomingLinks == null) {
      incomingLinks = new EObjectWithInverseResolvingEList<OPMLink>(OPMLink.class, this, OPMPackage.OPM_NODE__INCOMING_LINKS, OPMPackage.OPM_LINK__TARGET);
    }
    return incomingLinks;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<OPMLink> getOutgoingLinks() {
    if (outgoingLinks == null) {
      outgoingLinks = new EObjectWithInverseResolvingEList<OPMLink>(OPMLink.class, this, OPMPackage.OPM_NODE__OUTGOING_LINKS, OPMPackage.OPM_LINK__SOURCE);
    }
    return outgoingLinks;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OPMContainer getContainer() {
    if (eContainerFeatureID() != OPMPackage.OPM_NODE__CONTAINER) return null;
    return (OPMContainer)eContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContainer(OPMContainer newContainer, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newContainer, OPMPackage.OPM_NODE__CONTAINER, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setContainer(OPMContainer newContainer) {
    if (newContainer != eInternalContainer() || (eContainerFeatureID() != OPMPackage.OPM_NODE__CONTAINER && newContainer != null)) {
      if (EcoreUtil.isAncestor(this, newContainer))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newContainer != null)
        msgs = ((InternalEObject)newContainer).eInverseAdd(this, OPMPackage.OPM_CONTAINER__NODES, OPMContainer.class, msgs);
      msgs = basicSetContainer(newContainer, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPMPackage.OPM_NODE__CONTAINER, newContainer, newContainer));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Rectangle getConstraints() {
    return constraints;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setConstraints(Rectangle newConstraints) {
    Rectangle oldConstraints = constraints;
    constraints = newConstraints;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPMPackage.OPM_NODE__CONSTRAINTS, oldConstraints, constraints));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case OPMPackage.OPM_NODE__INCOMING_LINKS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingLinks()).basicAdd(otherEnd, msgs);
      case OPMPackage.OPM_NODE__OUTGOING_LINKS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingLinks()).basicAdd(otherEnd, msgs);
      case OPMPackage.OPM_NODE__CONTAINER:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetContainer((OPMContainer)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case OPMPackage.OPM_NODE__INCOMING_LINKS:
        return ((InternalEList<?>)getIncomingLinks()).basicRemove(otherEnd, msgs);
      case OPMPackage.OPM_NODE__OUTGOING_LINKS:
        return ((InternalEList<?>)getOutgoingLinks()).basicRemove(otherEnd, msgs);
      case OPMPackage.OPM_NODE__CONTAINER:
        return basicSetContainer(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID()) {
      case OPMPackage.OPM_NODE__CONTAINER:
        return eInternalContainer().eInverseRemove(this, OPMPackage.OPM_CONTAINER__NODES, OPMContainer.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case OPMPackage.OPM_NODE__INCOMING_LINKS:
        return getIncomingLinks();
      case OPMPackage.OPM_NODE__OUTGOING_LINKS:
        return getOutgoingLinks();
      case OPMPackage.OPM_NODE__CONTAINER:
        return getContainer();
      case OPMPackage.OPM_NODE__CONSTRAINTS:
        return getConstraints();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case OPMPackage.OPM_NODE__INCOMING_LINKS:
        getIncomingLinks().clear();
        getIncomingLinks().addAll((Collection<? extends OPMLink>)newValue);
        return;
      case OPMPackage.OPM_NODE__OUTGOING_LINKS:
        getOutgoingLinks().clear();
        getOutgoingLinks().addAll((Collection<? extends OPMLink>)newValue);
        return;
      case OPMPackage.OPM_NODE__CONTAINER:
        setContainer((OPMContainer)newValue);
        return;
      case OPMPackage.OPM_NODE__CONSTRAINTS:
        setConstraints((Rectangle)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case OPMPackage.OPM_NODE__INCOMING_LINKS:
        getIncomingLinks().clear();
        return;
      case OPMPackage.OPM_NODE__OUTGOING_LINKS:
        getOutgoingLinks().clear();
        return;
      case OPMPackage.OPM_NODE__CONTAINER:
        setContainer((OPMContainer)null);
        return;
      case OPMPackage.OPM_NODE__CONSTRAINTS:
        setConstraints(CONSTRAINTS_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case OPMPackage.OPM_NODE__INCOMING_LINKS:
        return incomingLinks != null && !incomingLinks.isEmpty();
      case OPMPackage.OPM_NODE__OUTGOING_LINKS:
        return outgoingLinks != null && !outgoingLinks.isEmpty();
      case OPMPackage.OPM_NODE__CONTAINER:
        return getContainer() != null;
      case OPMPackage.OPM_NODE__CONSTRAINTS:
        return CONSTRAINTS_EDEFAULT == null ? constraints != null : !CONSTRAINTS_EDEFAULT.equals(constraints);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (constraints: ");
    result.append(constraints);
    result.append(')');
    return result.toString();
  }

} // OPMNodeImpl
