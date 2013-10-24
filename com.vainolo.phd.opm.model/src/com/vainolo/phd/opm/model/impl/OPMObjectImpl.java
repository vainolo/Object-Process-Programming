/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package com.vainolo.phd.opm.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectKind;
import com.vainolo.phd.opm.model.OPMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.impl.OPMObjectImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.impl.OPMObjectImpl#isParameter <em>Parameter</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.impl.OPMObjectImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OPMObjectImpl extends OPMThingImpl implements OPMObject {
  /**
   * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected static final OPMObjectKind KIND_EDEFAULT = OPMObjectKind.SIMPLE;
  /**
   * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected OPMObjectKind kind = KIND_EDEFAULT;

  /**
   * The default value of the '{@link #isParameter() <em>Parameter</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #isParameter()
   * @generated
   * @ordered
   */
	protected static final boolean PARAMETER_EDEFAULT = false;
		/**
   * The cached value of the '{@link #isParameter() <em>Parameter</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #isParameter()
   * @generated
   * @ordered
   */
	protected boolean parameter = PARAMETER_EDEFAULT;

		/**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final Object VALUE_EDEFAULT = null;
    /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected Object value = VALUE_EDEFAULT;

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OPMObjectImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return OPMPackage.Literals.OPM_OBJECT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPMObjectKind getKind() {
    return kind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKind(OPMObjectKind newKind) {
    OPMObjectKind oldKind = kind;
    kind = newKind == null ? KIND_EDEFAULT : newKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPMPackage.OPM_OBJECT__KIND, oldKind, kind));
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public boolean isParameter() {
    return parameter;
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setParameter(boolean newParameter) {
    boolean oldParameter = parameter;
    parameter = newParameter;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPMPackage.OPM_OBJECT__PARAMETER, oldParameter, parameter));
  }

		/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object getValue() {
    return value;
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(Object newValue) {
    Object oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPMPackage.OPM_OBJECT__VALUE, oldValue, value));
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case OPMPackage.OPM_OBJECT__KIND:
        return getKind();
      case OPMPackage.OPM_OBJECT__PARAMETER:
        return isParameter();
      case OPMPackage.OPM_OBJECT__VALUE:
        return getValue();
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
      case OPMPackage.OPM_OBJECT__KIND:
        setKind((OPMObjectKind)newValue);
        return;
      case OPMPackage.OPM_OBJECT__PARAMETER:
        setParameter((Boolean)newValue);
        return;
      case OPMPackage.OPM_OBJECT__VALUE:
        setValue(newValue);
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
      case OPMPackage.OPM_OBJECT__KIND:
        setKind(KIND_EDEFAULT);
        return;
      case OPMPackage.OPM_OBJECT__PARAMETER:
        setParameter(PARAMETER_EDEFAULT);
        return;
      case OPMPackage.OPM_OBJECT__VALUE:
        setValue(VALUE_EDEFAULT);
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
      case OPMPackage.OPM_OBJECT__KIND:
        return kind != KIND_EDEFAULT;
      case OPMPackage.OPM_OBJECT__PARAMETER:
        return parameter != PARAMETER_EDEFAULT;
      case OPMPackage.OPM_OBJECT__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
    result.append(" (kind: ");
    result.append(kind);
    result.append(", parameter: ");
    result.append(parameter);
    result.append(", value: ");
    result.append(value);
    result.append(')');
    return result.toString();
  }

} // OPMObjectImpl
