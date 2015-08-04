/**
 */
package com.vainolo.opm.model.opm.impl;

import com.vainolo.opm.model.opm.OPObjectProcessDiagram;
import com.vainolo.opm.model.opm.OPPackage;
import com.vainolo.opm.model.opm.OPSystem;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPSystemImpl#getSystemDiagram <em>System Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OPSystemImpl extends MinimalEObjectImpl.Container implements OPSystem {
	/**
	 * The cached value of the '{@link #getSystemDiagram() <em>System Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemDiagram()
	 * @generated
	 * @ordered
	 */
	protected OPObjectProcessDiagram systemDiagram;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OPSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OPPackage.Literals.OP_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPObjectProcessDiagram getSystemDiagram() {
		if (systemDiagram != null && systemDiagram.eIsProxy()) {
			InternalEObject oldSystemDiagram = (InternalEObject)systemDiagram;
			systemDiagram = (OPObjectProcessDiagram)eResolveProxy(oldSystemDiagram);
			if (systemDiagram != oldSystemDiagram) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPPackage.OP_SYSTEM__SYSTEM_DIAGRAM, oldSystemDiagram, systemDiagram));
			}
		}
		return systemDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPObjectProcessDiagram basicGetSystemDiagram() {
		return systemDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemDiagram(OPObjectProcessDiagram newSystemDiagram) {
		OPObjectProcessDiagram oldSystemDiagram = systemDiagram;
		systemDiagram = newSystemDiagram;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_SYSTEM__SYSTEM_DIAGRAM, oldSystemDiagram, systemDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OPPackage.OP_SYSTEM__SYSTEM_DIAGRAM:
				if (resolve) return getSystemDiagram();
				return basicGetSystemDiagram();
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
			case OPPackage.OP_SYSTEM__SYSTEM_DIAGRAM:
				setSystemDiagram((OPObjectProcessDiagram)newValue);
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
			case OPPackage.OP_SYSTEM__SYSTEM_DIAGRAM:
				setSystemDiagram((OPObjectProcessDiagram)null);
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
			case OPPackage.OP_SYSTEM__SYSTEM_DIAGRAM:
				return systemDiagram != null;
		}
		return super.eIsSet(featureID);
	}

} //OPSystemImpl
