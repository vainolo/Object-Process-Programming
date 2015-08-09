/**
 */
package com.vainolo.opm.model.opm.impl;

import com.vainolo.opm.model.opm.OPElement;
import com.vainolo.opm.model.opm.OPObjectProcessDiagram;
import com.vainolo.opm.model.opm.OPPackage;
import com.vainolo.opm.model.opm.OPSystem;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPSystemImpl#getSystemDiagram <em>System Diagram</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPSystemImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPSystemImpl#getElements <em>Elements</em>}</li>
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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
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
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<OPElement> elements;
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
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_SYSTEM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OPElement> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentWithInverseEList<OPElement>(OPElement.class, this, OPPackage.OP_SYSTEM__ELEMENTS, OPPackage.OP_ELEMENT__SYSTEM);
		}
		return elements;
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
			case OPPackage.OP_SYSTEM__ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getElements()).basicAdd(otherEnd, msgs);
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
			case OPPackage.OP_SYSTEM__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
			case OPPackage.OP_SYSTEM__SYSTEM_DIAGRAM:
				if (resolve) return getSystemDiagram();
				return basicGetSystemDiagram();
			case OPPackage.OP_SYSTEM__NAME:
				return getName();
			case OPPackage.OP_SYSTEM__ELEMENTS:
				return getElements();
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
			case OPPackage.OP_SYSTEM__SYSTEM_DIAGRAM:
				setSystemDiagram((OPObjectProcessDiagram)newValue);
				return;
			case OPPackage.OP_SYSTEM__NAME:
				setName((String)newValue);
				return;
			case OPPackage.OP_SYSTEM__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends OPElement>)newValue);
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
			case OPPackage.OP_SYSTEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OPPackage.OP_SYSTEM__ELEMENTS:
				getElements().clear();
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
			case OPPackage.OP_SYSTEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OPPackage.OP_SYSTEM__ELEMENTS:
				return elements != null && !elements.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //OPSystemImpl
