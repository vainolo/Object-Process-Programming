/**
 */
package com.vainolo.opm.model.opm.impl;

import com.vainolo.opm.model.opm.OPNode;
import com.vainolo.opm.model.opm.OPPackage;
import com.vainolo.opm.model.opm.OPProceduralLink;

import com.vainolo.opm.model.opm.OPProceduralLinkKind;
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
 * An implementation of the model object '<em><b>Procedural Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPProceduralLinkImpl#getSystem <em>System</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPProceduralLinkImpl#getSource <em>Source</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPProceduralLinkImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPProceduralLinkImpl#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OPProceduralLinkImpl extends MinimalEObjectImpl.Container implements OPProceduralLink {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected OPNode source;
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected OPNode target;
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final OPProceduralLinkKind KIND_EDEFAULT = OPProceduralLinkKind.INSTRUMENT;
	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected OPProceduralLinkKind kind = KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OPProceduralLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OPPackage.Literals.OP_PROCEDURAL_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPSystem getSystem() {
		if (eContainerFeatureID() != OPPackage.OP_PROCEDURAL_LINK__SYSTEM) return null;
		return (OPSystem)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystem(OPSystem newSystem, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSystem, OPPackage.OP_PROCEDURAL_LINK__SYSTEM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem(OPSystem newSystem) {
		if (newSystem != eInternalContainer() || (eContainerFeatureID() != OPPackage.OP_PROCEDURAL_LINK__SYSTEM && newSystem != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_PROCEDURAL_LINK__SYSTEM, newSystem, newSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPNode getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (OPNode)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPPackage.OP_PROCEDURAL_LINK__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPNode basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(OPNode newSource, NotificationChain msgs) {
		OPNode oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OPPackage.OP_PROCEDURAL_LINK__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(OPNode newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, OPPackage.OP_NODE__OUTGOING_LINKS, OPNode.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, OPPackage.OP_NODE__OUTGOING_LINKS, OPNode.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_PROCEDURAL_LINK__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPNode getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (OPNode)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPPackage.OP_PROCEDURAL_LINK__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPNode basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(OPNode newTarget, NotificationChain msgs) {
		OPNode oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OPPackage.OP_PROCEDURAL_LINK__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(OPNode newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, OPPackage.OP_NODE__INCOMING_LINKS, OPNode.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, OPPackage.OP_NODE__INCOMING_LINKS, OPNode.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_PROCEDURAL_LINK__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPProceduralLinkKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(OPProceduralLinkKind newKind) {
		OPProceduralLinkKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_PROCEDURAL_LINK__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OPPackage.OP_PROCEDURAL_LINK__SYSTEM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSystem((OPSystem)otherEnd, msgs);
			case OPPackage.OP_PROCEDURAL_LINK__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, OPPackage.OP_NODE__OUTGOING_LINKS, OPNode.class, msgs);
				return basicSetSource((OPNode)otherEnd, msgs);
			case OPPackage.OP_PROCEDURAL_LINK__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, OPPackage.OP_NODE__INCOMING_LINKS, OPNode.class, msgs);
				return basicSetTarget((OPNode)otherEnd, msgs);
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
			case OPPackage.OP_PROCEDURAL_LINK__SYSTEM:
				return basicSetSystem(null, msgs);
			case OPPackage.OP_PROCEDURAL_LINK__SOURCE:
				return basicSetSource(null, msgs);
			case OPPackage.OP_PROCEDURAL_LINK__TARGET:
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
			case OPPackage.OP_PROCEDURAL_LINK__SYSTEM:
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
			case OPPackage.OP_PROCEDURAL_LINK__SYSTEM:
				return getSystem();
			case OPPackage.OP_PROCEDURAL_LINK__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case OPPackage.OP_PROCEDURAL_LINK__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case OPPackage.OP_PROCEDURAL_LINK__KIND:
				return getKind();
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
			case OPPackage.OP_PROCEDURAL_LINK__SYSTEM:
				setSystem((OPSystem)newValue);
				return;
			case OPPackage.OP_PROCEDURAL_LINK__SOURCE:
				setSource((OPNode)newValue);
				return;
			case OPPackage.OP_PROCEDURAL_LINK__TARGET:
				setTarget((OPNode)newValue);
				return;
			case OPPackage.OP_PROCEDURAL_LINK__KIND:
				setKind((OPProceduralLinkKind)newValue);
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
			case OPPackage.OP_PROCEDURAL_LINK__SYSTEM:
				setSystem((OPSystem)null);
				return;
			case OPPackage.OP_PROCEDURAL_LINK__SOURCE:
				setSource((OPNode)null);
				return;
			case OPPackage.OP_PROCEDURAL_LINK__TARGET:
				setTarget((OPNode)null);
				return;
			case OPPackage.OP_PROCEDURAL_LINK__KIND:
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
			case OPPackage.OP_PROCEDURAL_LINK__SYSTEM:
				return getSystem() != null;
			case OPPackage.OP_PROCEDURAL_LINK__SOURCE:
				return source != null;
			case OPPackage.OP_PROCEDURAL_LINK__TARGET:
				return target != null;
			case OPPackage.OP_PROCEDURAL_LINK__KIND:
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
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //OPProceduralLinkImpl
