/**
 */
package com.vainolo.phd.opp.model.impl;

import com.vainolo.phd.opp.model.OPPNamedElement;
import com.vainolo.phd.opp.model.OPPPackage;
import com.vainolo.phd.opp.model.OPPVerticalAlignment;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPNamedElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.impl.OPPNamedElementImpl#getAlignment <em>Alignment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class OPPNamedElementImpl extends EObjectImpl implements OPPNamedElement {
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OPPNamedElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return OPPPackage.Literals.OPP_NAMED_ELEMENT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_NAMED_ELEMENT__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, OPPPackage.OPP_NAMED_ELEMENT__ALIGNMENT, oldAlignment, alignment));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case OPPPackage.OPP_NAMED_ELEMENT__NAME:
        return getName();
      case OPPPackage.OPP_NAMED_ELEMENT__ALIGNMENT:
        return getAlignment();
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
      case OPPPackage.OPP_NAMED_ELEMENT__NAME:
        setName((String)newValue);
        return;
      case OPPPackage.OPP_NAMED_ELEMENT__ALIGNMENT:
        setAlignment((OPPVerticalAlignment)newValue);
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
      case OPPPackage.OPP_NAMED_ELEMENT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case OPPPackage.OPP_NAMED_ELEMENT__ALIGNMENT:
        setAlignment(ALIGNMENT_EDEFAULT);
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
      case OPPPackage.OPP_NAMED_ELEMENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case OPPPackage.OPP_NAMED_ELEMENT__ALIGNMENT:
        return alignment != ALIGNMENT_EDEFAULT;
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
    result.append(" (name: ");
    result.append(name);
    result.append(", alignment: ");
    result.append(alignment);
    result.append(')');
    return result.toString();
  }

} //OPPNamedElementImpl
