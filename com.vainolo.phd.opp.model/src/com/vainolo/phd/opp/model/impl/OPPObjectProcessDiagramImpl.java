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
import com.vainolo.phd.opp.model.OPPNamedElement;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind;
import com.vainolo.phd.opp.model.OPPPackage;
import com.vainolo.phd.opp.model.OPPVerticalAlignment;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Process Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPObjectProcessDiagramImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPObjectProcessDiagramImpl#getAlignment <em>Alignment</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPObjectProcessDiagramImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPObjectProcessDiagramImpl#getLastKnownUsedId <em>Last Known Used Id</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPObjectProcessDiagramImpl#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OPPObjectProcessDiagramImpl extends OPPContainerImpl implements OPPObjectProcessDiagram {
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = "";

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getAlignment() <em>Alignment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlignment()
   * @generated
   * @ordered
   */
  protected static final OPPVerticalAlignment ALIGNMENT_EDEFAULT = OPPVerticalAlignment.CENTER;

  /**
   * The cached value of the '{@link #getAlignment() <em>Alignment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlignment()
   * @generated
   * @ordered
   */
  protected OPPVerticalAlignment alignment = ALIGNMENT_EDEFAULT;

  /**
   * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLinks()
   * @generated
   * @ordered
   */
  protected EList<OPPLink> links;

  /**
   * The default value of the '{@link #getLastKnownUsedId() <em>Last Known Used Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLastKnownUsedId()
   * @generated
   * @ordered
   */
  protected static final long LAST_KNOWN_USED_ID_EDEFAULT = 0L;

  /**
   * The cached value of the '{@link #getLastKnownUsedId() <em>Last Known Used Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLastKnownUsedId()
   * @generated
   * @ordered
   */
  protected long lastKnownUsedId = LAST_KNOWN_USED_ID_EDEFAULT;

  /**
   * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected static final OPPObjectProcessDiagramKind KIND_EDEFAULT = OPPObjectProcessDiagramKind.COMPOUND;

  /**
   * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected OPPObjectProcessDiagramKind kind = KIND_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OPPObjectProcessDiagramImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return OPPPackage.Literals.OPP_OBJECT_PROCESS_DIAGRAM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPVerticalAlignment getAlignment() {
    return alignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAlignment(OPPVerticalAlignment newAlignment) {
    OPPVerticalAlignment oldAlignment = alignment;
    alignment = newAlignment == null ? ALIGNMENT_EDEFAULT : newAlignment;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__ALIGNMENT, oldAlignment, alignment));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<OPPLink> getLinks() {
    if (links == null) {
      links = new EObjectContainmentWithInverseEList<OPPLink>(OPPLink.class, this, OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__LINKS, OPPPackage.OPP_LINK__OPD);
    }
    return links;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getLastKnownUsedId() {
    return lastKnownUsedId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLastKnownUsedId(long newLastKnownUsedId) {
    long oldLastKnownUsedId = lastKnownUsedId;
    lastKnownUsedId = newLastKnownUsedId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__LAST_KNOWN_USED_ID, oldLastKnownUsedId, lastKnownUsedId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPObjectProcessDiagramKind getKind() {
    return kind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKind(OPPObjectProcessDiagramKind newKind) {
    OPPObjectProcessDiagramKind oldKind = kind;
    kind = newKind == null ? KIND_EDEFAULT : newKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__KIND, oldKind, kind));
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
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__LINKS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getLinks()).basicAdd(otherEnd, msgs);
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
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__LINKS:
        return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__NAME:
        return getName();
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__ALIGNMENT:
        return getAlignment();
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__LINKS:
        return getLinks();
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__LAST_KNOWN_USED_ID:
        return getLastKnownUsedId();
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__KIND:
        return getKind();
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
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__NAME:
        setName((String)newValue);
        return;
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__ALIGNMENT:
        setAlignment((OPPVerticalAlignment)newValue);
        return;
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__LINKS:
        getLinks().clear();
        getLinks().addAll((Collection<? extends OPPLink>)newValue);
        return;
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__LAST_KNOWN_USED_ID:
        setLastKnownUsedId((Long)newValue);
        return;
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__KIND:
        setKind((OPPObjectProcessDiagramKind)newValue);
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
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__NAME:
        setName(NAME_EDEFAULT);
        return;
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__ALIGNMENT:
        setAlignment(ALIGNMENT_EDEFAULT);
        return;
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__LINKS:
        getLinks().clear();
        return;
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__LAST_KNOWN_USED_ID:
        setLastKnownUsedId(LAST_KNOWN_USED_ID_EDEFAULT);
        return;
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__KIND:
        setKind(KIND_EDEFAULT);
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
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__ALIGNMENT:
        return alignment != ALIGNMENT_EDEFAULT;
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__LINKS:
        return links != null && !links.isEmpty();
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__LAST_KNOWN_USED_ID:
        return lastKnownUsedId != LAST_KNOWN_USED_ID_EDEFAULT;
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__KIND:
        return kind != KIND_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
    if (baseClass == OPPNamedElement.class) {
      switch (derivedFeatureID) {
        case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__NAME: return OPPPackage.OPP_NAMED_ELEMENT__NAME;
        case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__ALIGNMENT: return OPPPackage.OPP_NAMED_ELEMENT__ALIGNMENT;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
    if (baseClass == OPPNamedElement.class) {
      switch (baseFeatureID) {
        case OPPPackage.OPP_NAMED_ELEMENT__NAME: return OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__NAME;
        case OPPPackage.OPP_NAMED_ELEMENT__ALIGNMENT: return OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM__ALIGNMENT;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", alignment: ");
    result.append(alignment);
    result.append(", lastKnownUsedId: ");
    result.append(lastKnownUsedId);
    result.append(", kind: ");
    result.append(kind);
    result.append(')');
    return result.toString();
  }

} //OPPObjectProcessDiagramImpl
