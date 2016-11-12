/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 */
package com.vainolo.phd.opp.model.impl;

import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPObjectImpl#isGlobal <em>Global</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPObjectImpl#getInitialValue <em>Initial Value</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPObjectImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPObjectImpl#isConstant <em>Constant</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OPPObjectImpl extends OPPThingImpl implements OPPObject {
  /**
   * The default value of the '{@link #isGlobal() <em>Global</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isGlobal()
   * @generated
   * @ordered
   */
  protected static final boolean GLOBAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isGlobal() <em>Global</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isGlobal()
   * @generated
   * @ordered
   */
  protected boolean global = GLOBAL_EDEFAULT;

  /**
   * The default value of the '{@link #getInitialValue() <em>Initial Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitialValue()
   * @generated
   * @ordered
   */
  protected static final String INITIAL_VALUE_EDEFAULT = "";

  /**
   * The cached value of the '{@link #getInitialValue() <em>Initial Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitialValue()
   * @generated
   * @ordered
   */
  protected String initialValue = INITIAL_VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = "";

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #isConstant() <em>Constant</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isConstant()
   * @generated
   * @ordered
   */
  protected static final boolean CONSTANT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isConstant() <em>Constant</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isConstant()
   * @generated
   * @ordered
   */
  protected boolean constant = CONSTANT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OPPObjectImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return OPPPackage.Literals.OPP_OBJECT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isGlobal() {
    return global;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGlobal(boolean newGlobal) {
    boolean oldGlobal = global;
    global = newGlobal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_OBJECT__GLOBAL, oldGlobal, global));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getInitialValue() {
    return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitialValue(String newInitialValue) {
    String oldInitialValue = initialValue;
    initialValue = newInitialValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_OBJECT__INITIAL_VALUE, oldInitialValue, initialValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getType() {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(String newType) {
    String oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_OBJECT__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isConstant() {
    return constant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstant(boolean newConstant) {
    boolean oldConstant = constant;
    constant = newConstant;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_OBJECT__CONSTANT, oldConstant, constant));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case OPPPackage.OPP_OBJECT__GLOBAL:
        return isGlobal();
      case OPPPackage.OPP_OBJECT__INITIAL_VALUE:
        return getInitialValue();
      case OPPPackage.OPP_OBJECT__TYPE:
        return getType();
      case OPPPackage.OPP_OBJECT__CONSTANT:
        return isConstant();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case OPPPackage.OPP_OBJECT__GLOBAL:
        setGlobal((Boolean)newValue);
        return;
      case OPPPackage.OPP_OBJECT__INITIAL_VALUE:
        setInitialValue((String)newValue);
        return;
      case OPPPackage.OPP_OBJECT__TYPE:
        setType((String)newValue);
        return;
      case OPPPackage.OPP_OBJECT__CONSTANT:
        setConstant((Boolean)newValue);
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
      case OPPPackage.OPP_OBJECT__GLOBAL:
        setGlobal(GLOBAL_EDEFAULT);
        return;
      case OPPPackage.OPP_OBJECT__INITIAL_VALUE:
        setInitialValue(INITIAL_VALUE_EDEFAULT);
        return;
      case OPPPackage.OPP_OBJECT__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case OPPPackage.OPP_OBJECT__CONSTANT:
        setConstant(CONSTANT_EDEFAULT);
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
      case OPPPackage.OPP_OBJECT__GLOBAL:
        return global != GLOBAL_EDEFAULT;
      case OPPPackage.OPP_OBJECT__INITIAL_VALUE:
        return INITIAL_VALUE_EDEFAULT == null ? initialValue != null : !INITIAL_VALUE_EDEFAULT.equals(initialValue);
      case OPPPackage.OPP_OBJECT__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case OPPPackage.OPP_OBJECT__CONSTANT:
        return constant != CONSTANT_EDEFAULT;
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
    result.append(" (global: ");
    result.append(global);
    result.append(", initialValue: ");
    result.append(initialValue);
    result.append(", type: ");
    result.append(type);
    result.append(", constant: ");
    result.append(constant);
    result.append(')');
    return result.toString();
  }

} //OPPObjectImpl
