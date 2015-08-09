/**
 */
package com.vainolo.opm.model.opm.impl;

import com.vainolo.opm.model.opm.OPElement;
import com.vainolo.opm.model.opm.OPNodeView;
import com.vainolo.opm.model.opm.OPObjectProcessDiagram;
import com.vainolo.opm.model.opm.OPPackage;
import com.vainolo.opm.model.opm.OPStructuralLinkPartView;

import com.vainolo.opm.model.opm.OPSystem;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structural Link Part View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPStructuralLinkPartViewImpl#getSystem <em>System</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPStructuralLinkPartViewImpl#getOpd <em>Opd</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPStructuralLinkPartViewImpl#getModel <em>Model</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPStructuralLinkPartViewImpl#getSource <em>Source</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPStructuralLinkPartViewImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OPStructuralLinkPartViewImpl extends MinimalEObjectImpl.Container implements OPStructuralLinkPartView {
	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected OPElement model;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected OPNodeView source;
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected OPNodeView target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OPStructuralLinkPartViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OPPackage.Literals.OP_STRUCTURAL_LINK_PART_VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPSystem getSystem() {
		if (eContainerFeatureID() != OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SYSTEM) return null;
		return (OPSystem)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystem(OPSystem newSystem, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSystem, OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SYSTEM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem(OPSystem newSystem) {
		if (newSystem != eInternalContainer() || (eContainerFeatureID() != OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SYSTEM && newSystem != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SYSTEM, newSystem, newSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPObjectProcessDiagram getOpd() {
		if (eContainerFeatureID() != OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__OPD) return null;
		return (OPObjectProcessDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOpd(OPObjectProcessDiagram newOpd, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOpd, OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__OPD, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpd(OPObjectProcessDiagram newOpd) {
		if (newOpd != eInternalContainer() || (eContainerFeatureID() != OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__OPD && newOpd != null)) {
			if (EcoreUtil.isAncestor(this, newOpd))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOpd != null)
				msgs = ((InternalEObject)newOpd).eInverseAdd(this, OPPackage.OP_OBJECT_PROCESS_DIAGRAM__ELEMENTS, OPObjectProcessDiagram.class, msgs);
			msgs = basicSetOpd(newOpd, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__OPD, newOpd, newOpd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPElement getModel() {
		if (model != null && model.eIsProxy()) {
			InternalEObject oldModel = (InternalEObject)model;
			model = (OPElement)eResolveProxy(oldModel);
			if (model != oldModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__MODEL, oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPElement basicGetModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(OPElement newModel) {
		OPElement oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPNodeView getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (OPNodeView)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPNodeView basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(OPNodeView newSource, NotificationChain msgs) {
		OPNodeView oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(OPNodeView newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, OPPackage.OP_NODE_VIEW__OUTGOING_LINKS, OPNodeView.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, OPPackage.OP_NODE_VIEW__OUTGOING_LINKS, OPNodeView.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPNodeView getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (OPNodeView)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPNodeView basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(OPNodeView newTarget, NotificationChain msgs) {
		OPNodeView oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(OPNodeView newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, OPPackage.OP_NODE_VIEW__INCOMING_LINKS, OPNodeView.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, OPPackage.OP_NODE_VIEW__INCOMING_LINKS, OPNodeView.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SYSTEM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSystem((OPSystem)otherEnd, msgs);
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__OPD:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOpd((OPObjectProcessDiagram)otherEnd, msgs);
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, OPPackage.OP_NODE_VIEW__OUTGOING_LINKS, OPNodeView.class, msgs);
				return basicSetSource((OPNodeView)otherEnd, msgs);
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, OPPackage.OP_NODE_VIEW__INCOMING_LINKS, OPNodeView.class, msgs);
				return basicSetTarget((OPNodeView)otherEnd, msgs);
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
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SYSTEM:
				return basicSetSystem(null, msgs);
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__OPD:
				return basicSetOpd(null, msgs);
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SOURCE:
				return basicSetSource(null, msgs);
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__TARGET:
				return basicSetTarget(null, msgs);
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
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SYSTEM:
				return eInternalContainer().eInverseRemove(this, OPPackage.OP_SYSTEM__ELEMENTS, OPSystem.class, msgs);
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__OPD:
				return eInternalContainer().eInverseRemove(this, OPPackage.OP_OBJECT_PROCESS_DIAGRAM__ELEMENTS, OPObjectProcessDiagram.class, msgs);
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
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SYSTEM:
				return getSystem();
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__OPD:
				return getOpd();
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
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
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SYSTEM:
				setSystem((OPSystem)newValue);
				return;
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__OPD:
				setOpd((OPObjectProcessDiagram)newValue);
				return;
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__MODEL:
				setModel((OPElement)newValue);
				return;
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SOURCE:
				setSource((OPNodeView)newValue);
				return;
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__TARGET:
				setTarget((OPNodeView)newValue);
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
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SYSTEM:
				setSystem((OPSystem)null);
				return;
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__OPD:
				setOpd((OPObjectProcessDiagram)null);
				return;
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__MODEL:
				setModel((OPElement)null);
				return;
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SOURCE:
				setSource((OPNodeView)null);
				return;
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__TARGET:
				setTarget((OPNodeView)null);
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
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SYSTEM:
				return getSystem() != null;
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__OPD:
				return getOpd() != null;
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__MODEL:
				return model != null;
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__SOURCE:
				return source != null;
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW__TARGET:
				return target != null;
		}
		return super.eIsSet(featureID);
	}

} //OPStructuralLinkPartViewImpl
