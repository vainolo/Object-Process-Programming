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
import com.vainolo.phd.opp.model.OPPNamedElement;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPPackage;
import com.vainolo.phd.opp.model.OPPThing;
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
 * An implementation of the model object '<em><b>Thing</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPThingImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPThingImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPThingImpl#getAlignment <em>Alignment</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPThingImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPThingImpl#isCollection <em>Collection</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPThingImpl#isMain <em>Main</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class OPPThingImpl extends OPPNodeImpl implements OPPThing {
  /**
   * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNodes()
   * @generated
   * @ordered
   */
  protected EList<OPPNode> nodes;

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
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #isCollection() <em>Collection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCollection()
   * @generated
   * @ordered
   */
  protected static final boolean COLLECTION_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCollection() <em>Collection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCollection()
   * @generated
   * @ordered
   */
  protected boolean collection = COLLECTION_EDEFAULT;

  /**
   * The default value of the '{@link #isMain() <em>Main</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMain()
   * @generated
   * @ordered
   */
  protected static final boolean MAIN_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMain() <em>Main</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMain()
   * @generated
   * @ordered
   */
  protected boolean main = MAIN_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OPPThingImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return OPPPackage.Literals.OPP_THING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<OPPNode> getNodes() {
    if (nodes == null) {
      nodes = new EObjectContainmentWithInverseEList<OPPNode>(OPPNode.class, this, OPPPackage.OPP_THING__NODES, OPPPackage.OPP_NODE__CONTAINER);
    }
    return nodes;
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
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_THING__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_THING__ALIGNMENT, oldAlignment, alignment));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription() {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription) {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_THING__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isCollection() {
    return collection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCollection(boolean newCollection) {
    boolean oldCollection = collection;
    collection = newCollection;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_THING__COLLECTION, oldCollection, collection));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isMain() {
    return main;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMain(boolean newMain) {
    boolean oldMain = main;
    main = newMain;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_THING__MAIN, oldMain, main));
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
      case OPPPackage.OPP_THING__NODES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getNodes()).basicAdd(otherEnd, msgs);
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
      case OPPPackage.OPP_THING__NODES:
        return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
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
      case OPPPackage.OPP_THING__NODES:
        return getNodes();
      case OPPPackage.OPP_THING__NAME:
        return getName();
      case OPPPackage.OPP_THING__ALIGNMENT:
        return getAlignment();
      case OPPPackage.OPP_THING__DESCRIPTION:
        return getDescription();
      case OPPPackage.OPP_THING__COLLECTION:
        return isCollection();
      case OPPPackage.OPP_THING__MAIN:
        return isMain();
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
      case OPPPackage.OPP_THING__NODES:
        getNodes().clear();
        getNodes().addAll((Collection<? extends OPPNode>)newValue);
        return;
      case OPPPackage.OPP_THING__NAME:
        setName((String)newValue);
        return;
      case OPPPackage.OPP_THING__ALIGNMENT:
        setAlignment((OPPVerticalAlignment)newValue);
        return;
      case OPPPackage.OPP_THING__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case OPPPackage.OPP_THING__COLLECTION:
        setCollection((Boolean)newValue);
        return;
      case OPPPackage.OPP_THING__MAIN:
        setMain((Boolean)newValue);
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
      case OPPPackage.OPP_THING__NODES:
        getNodes().clear();
        return;
      case OPPPackage.OPP_THING__NAME:
        setName(NAME_EDEFAULT);
        return;
      case OPPPackage.OPP_THING__ALIGNMENT:
        setAlignment(ALIGNMENT_EDEFAULT);
        return;
      case OPPPackage.OPP_THING__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case OPPPackage.OPP_THING__COLLECTION:
        setCollection(COLLECTION_EDEFAULT);
        return;
      case OPPPackage.OPP_THING__MAIN:
        setMain(MAIN_EDEFAULT);
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
      case OPPPackage.OPP_THING__NODES:
        return nodes != null && !nodes.isEmpty();
      case OPPPackage.OPP_THING__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case OPPPackage.OPP_THING__ALIGNMENT:
        return alignment != ALIGNMENT_EDEFAULT;
      case OPPPackage.OPP_THING__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case OPPPackage.OPP_THING__COLLECTION:
        return collection != COLLECTION_EDEFAULT;
      case OPPPackage.OPP_THING__MAIN:
        return main != MAIN_EDEFAULT;
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
    if (baseClass == OPPContainer.class) {
      switch (derivedFeatureID) {
        case OPPPackage.OPP_THING__NODES: return OPPPackage.OPP_CONTAINER__NODES;
        default: return -1;
      }
    }
    if (baseClass == OPPNamedElement.class) {
      switch (derivedFeatureID) {
        case OPPPackage.OPP_THING__NAME: return OPPPackage.OPP_NAMED_ELEMENT__NAME;
        case OPPPackage.OPP_THING__ALIGNMENT: return OPPPackage.OPP_NAMED_ELEMENT__ALIGNMENT;
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
    if (baseClass == OPPContainer.class) {
      switch (baseFeatureID) {
        case OPPPackage.OPP_CONTAINER__NODES: return OPPPackage.OPP_THING__NODES;
        default: return -1;
      }
    }
    if (baseClass == OPPNamedElement.class) {
      switch (baseFeatureID) {
        case OPPPackage.OPP_NAMED_ELEMENT__NAME: return OPPPackage.OPP_THING__NAME;
        case OPPPackage.OPP_NAMED_ELEMENT__ALIGNMENT: return OPPPackage.OPP_THING__ALIGNMENT;
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
    result.append(", description: ");
    result.append(description);
    result.append(", collection: ");
    result.append(collection);
    result.append(", main: ");
    result.append(main);
    result.append(')');
    return result.toString();
  }

} //OPPThingImpl
