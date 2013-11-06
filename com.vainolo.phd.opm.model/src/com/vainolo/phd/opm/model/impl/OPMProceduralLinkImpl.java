/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model.impl;

import com.vainolo.phd.opm.model.OPMPackage;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Procedural Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.impl.OPMProceduralLinkImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.impl.OPMProceduralLinkImpl#getSubKinds <em>Sub Kinds</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OPMProceduralLinkImpl extends OPMLinkImpl implements OPMProceduralLink {
	/**
   * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
	protected static final OPMProceduralLinkKind KIND_EDEFAULT = OPMProceduralLinkKind.AGENT;

	/**
   * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
	protected OPMProceduralLinkKind kind = KIND_EDEFAULT;

	/**
   * The cached value of the '{@link #getSubKinds() <em>Sub Kinds</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubKinds()
   * @generated
   * @ordered
   */
  protected EList<String> subKinds;

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected OPMProceduralLinkImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return OPMPackage.Literals.OPM_PROCEDURAL_LINK;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public OPMProceduralLinkKind getKind() {
    return kind;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setKind(OPMProceduralLinkKind newKind) {
    OPMProceduralLinkKind oldKind = kind;
    kind = newKind == null ? KIND_EDEFAULT : newKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OPMPackage.OPM_PROCEDURAL_LINK__KIND, oldKind, kind));
  }

	/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getSubKinds() {
    if (subKinds == null) {
      subKinds = new EDataTypeUniqueEList<String>(String.class, this, OPMPackage.OPM_PROCEDURAL_LINK__SUB_KINDS);
    }
    return subKinds;
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case OPMPackage.OPM_PROCEDURAL_LINK__KIND:
        return getKind();
      case OPMPackage.OPM_PROCEDURAL_LINK__SUB_KINDS:
        return getSubKinds();
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
      case OPMPackage.OPM_PROCEDURAL_LINK__KIND:
        setKind((OPMProceduralLinkKind)newValue);
        return;
      case OPMPackage.OPM_PROCEDURAL_LINK__SUB_KINDS:
        getSubKinds().clear();
        getSubKinds().addAll((Collection<? extends String>)newValue);
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
      case OPMPackage.OPM_PROCEDURAL_LINK__KIND:
        setKind(KIND_EDEFAULT);
        return;
      case OPMPackage.OPM_PROCEDURAL_LINK__SUB_KINDS:
        getSubKinds().clear();
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
      case OPMPackage.OPM_PROCEDURAL_LINK__KIND:
        return kind != KIND_EDEFAULT;
      case OPMPackage.OPM_PROCEDURAL_LINK__SUB_KINDS:
        return subKinds != null && !subKinds.isEmpty();
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
    result.append(", subKinds: ");
    result.append(subKinds);
    result.append(')');
    return result.toString();
  }

} //OPMProceduralLinkImpl
