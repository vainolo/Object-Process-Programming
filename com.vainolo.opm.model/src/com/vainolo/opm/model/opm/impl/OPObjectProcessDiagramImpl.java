/**
 */
package com.vainolo.opm.model.opm.impl;

import com.vainolo.opm.model.opm.OPElementView;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Process Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPObjectProcessDiagramImpl#getSystem <em>System</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPObjectProcessDiagramImpl#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OPObjectProcessDiagramImpl extends MinimalEObjectImpl.Container implements OPObjectProcessDiagram {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<OPElementView> elements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OPObjectProcessDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OPPackage.Literals.OP_OBJECT_PROCESS_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPSystem getSystem() {
		if (eContainerFeatureID() != OPPackage.OP_OBJECT_PROCESS_DIAGRAM__SYSTEM) return null;
		return (OPSystem)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystem(OPSystem newSystem, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSystem, OPPackage.OP_OBJECT_PROCESS_DIAGRAM__SYSTEM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem(OPSystem newSystem) {
		if (newSystem != eInternalContainer() || (eContainerFeatureID() != OPPackage.OP_OBJECT_PROCESS_DIAGRAM__SYSTEM && newSystem != null)) {
			if (EcoreUtil.isAncestor(this, newSystem))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSystem != null)
				msgs = ((InternalEObject)newSystem).eInverseAdd(this, OPPackage.OP_SYSTEM__ELEMENTS, OPSystem.class, msgs);
			msgs = basicSetSystem(newSystem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_OBJECT_PROCESS_DIAGRAM__SYSTEM, newSystem, newSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OPElementView> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentWithInverseEList<OPElementView>(OPElementView.class, this, OPPackage.OP_OBJECT_PROCESS_DIAGRAM__ELEMENTS, OPPackage.OP_ELEMENT_VIEW__OPD);
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
			case OPPackage.OP_OBJECT_PROCESS_DIAGRAM__SYSTEM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSystem((OPSystem)otherEnd, msgs);
			case OPPackage.OP_OBJECT_PROCESS_DIAGRAM__ELEMENTS:
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
			case OPPackage.OP_OBJECT_PROCESS_DIAGRAM__SYSTEM:
				return basicSetSystem(null, msgs);
			case OPPackage.OP_OBJECT_PROCESS_DIAGRAM__ELEMENTS:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case OPPackage.OP_OBJECT_PROCESS_DIAGRAM__SYSTEM:
				return eInternalContainer().eInverseRemove(this, OPPackage.OP_SYSTEM__ELEMENTS, OPSystem.class, msgs);
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
			case OPPackage.OP_OBJECT_PROCESS_DIAGRAM__SYSTEM:
				return getSystem();
			case OPPackage.OP_OBJECT_PROCESS_DIAGRAM__ELEMENTS:
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
			case OPPackage.OP_OBJECT_PROCESS_DIAGRAM__SYSTEM:
				setSystem((OPSystem)newValue);
				return;
			case OPPackage.OP_OBJECT_PROCESS_DIAGRAM__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends OPElementView>)newValue);
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
			case OPPackage.OP_OBJECT_PROCESS_DIAGRAM__SYSTEM:
				setSystem((OPSystem)null);
				return;
			case OPPackage.OP_OBJECT_PROCESS_DIAGRAM__ELEMENTS:
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
			case OPPackage.OP_OBJECT_PROCESS_DIAGRAM__SYSTEM:
				return getSystem() != null;
			case OPPackage.OP_OBJECT_PROCESS_DIAGRAM__ELEMENTS:
				return elements != null && !elements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OPObjectProcessDiagramImpl
