/**
 */
package com.vainolo.opm.model.opm.impl;

import com.vainolo.opm.model.opm.OPElement;
import com.vainolo.opm.model.opm.OPLinkView;
import com.vainolo.opm.model.opm.OPObjectProcessDiagram;
import com.vainolo.opm.model.opm.OPPackage;
import com.vainolo.opm.model.opm.OPProcessView;

import com.vainolo.opm.model.opm.OPSystem;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPProcessViewImpl#getSystem <em>System</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPProcessViewImpl#getOpd <em>Opd</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPProcessViewImpl#getModel <em>Model</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPProcessViewImpl#getX <em>X</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPProcessViewImpl#getY <em>Y</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPProcessViewImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPProcessViewImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPProcessViewImpl#getIncomingLinks <em>Incoming Links</em>}</li>
 *   <li>{@link com.vainolo.opm.model.opm.impl.OPProcessViewImpl#getOutgoingLinks <em>Outgoing Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OPProcessViewImpl extends MinimalEObjectImpl.Container implements OPProcessView {
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
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected static final int X_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected int x = X_EDEFAULT;
	/**
	 * The default value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected static final int Y_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected int y = Y_EDEFAULT;
	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int WIDTH_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected int width = WIDTH_EDEFAULT;
	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int HEIGHT_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected int height = HEIGHT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIncomingLinks() <em>Incoming Links</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<OPLinkView> incomingLinks;

	/**
	 * The cached value of the '{@link #getOutgoingLinks() <em>Outgoing Links</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<OPLinkView> outgoingLinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OPProcessViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OPPackage.Literals.OP_PROCESS_VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPSystem getSystem() {
		if (eContainerFeatureID() != OPPackage.OP_PROCESS_VIEW__SYSTEM) return null;
		return (OPSystem)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystem(OPSystem newSystem, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSystem, OPPackage.OP_PROCESS_VIEW__SYSTEM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem(OPSystem newSystem) {
		if (newSystem != eInternalContainer() || (eContainerFeatureID() != OPPackage.OP_PROCESS_VIEW__SYSTEM && newSystem != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_PROCESS_VIEW__SYSTEM, newSystem, newSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPObjectProcessDiagram getOpd() {
		if (eContainerFeatureID() != OPPackage.OP_PROCESS_VIEW__OPD) return null;
		return (OPObjectProcessDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOpd(OPObjectProcessDiagram newOpd, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOpd, OPPackage.OP_PROCESS_VIEW__OPD, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpd(OPObjectProcessDiagram newOpd) {
		if (newOpd != eInternalContainer() || (eContainerFeatureID() != OPPackage.OP_PROCESS_VIEW__OPD && newOpd != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_PROCESS_VIEW__OPD, newOpd, newOpd));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPPackage.OP_PROCESS_VIEW__MODEL, oldModel, model));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_PROCESS_VIEW__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getX() {
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX(int newX) {
		int oldX = x;
		x = newX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_PROCESS_VIEW__X, oldX, x));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getY() {
		return y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setY(int newY) {
		int oldY = y;
		y = newY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_PROCESS_VIEW__Y, oldY, y));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(int newWidth) {
		int oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_PROCESS_VIEW__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(int newHeight) {
		int oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPPackage.OP_PROCESS_VIEW__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OPLinkView> getIncomingLinks() {
		if (incomingLinks == null) {
			incomingLinks = new EObjectWithInverseResolvingEList<OPLinkView>(OPLinkView.class, this, OPPackage.OP_PROCESS_VIEW__INCOMING_LINKS, OPPackage.OP_LINK_VIEW__TARGET);
		}
		return incomingLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OPLinkView> getOutgoingLinks() {
		if (outgoingLinks == null) {
			outgoingLinks = new EObjectWithInverseResolvingEList<OPLinkView>(OPLinkView.class, this, OPPackage.OP_PROCESS_VIEW__OUTGOING_LINKS, OPPackage.OP_LINK_VIEW__SOURCE);
		}
		return outgoingLinks;
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
			case OPPackage.OP_PROCESS_VIEW__SYSTEM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSystem((OPSystem)otherEnd, msgs);
			case OPPackage.OP_PROCESS_VIEW__OPD:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOpd((OPObjectProcessDiagram)otherEnd, msgs);
			case OPPackage.OP_PROCESS_VIEW__INCOMING_LINKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingLinks()).basicAdd(otherEnd, msgs);
			case OPPackage.OP_PROCESS_VIEW__OUTGOING_LINKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingLinks()).basicAdd(otherEnd, msgs);
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
			case OPPackage.OP_PROCESS_VIEW__SYSTEM:
				return basicSetSystem(null, msgs);
			case OPPackage.OP_PROCESS_VIEW__OPD:
				return basicSetOpd(null, msgs);
			case OPPackage.OP_PROCESS_VIEW__INCOMING_LINKS:
				return ((InternalEList<?>)getIncomingLinks()).basicRemove(otherEnd, msgs);
			case OPPackage.OP_PROCESS_VIEW__OUTGOING_LINKS:
				return ((InternalEList<?>)getOutgoingLinks()).basicRemove(otherEnd, msgs);
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
			case OPPackage.OP_PROCESS_VIEW__SYSTEM:
				return eInternalContainer().eInverseRemove(this, OPPackage.OP_SYSTEM__ELEMENTS, OPSystem.class, msgs);
			case OPPackage.OP_PROCESS_VIEW__OPD:
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
			case OPPackage.OP_PROCESS_VIEW__SYSTEM:
				return getSystem();
			case OPPackage.OP_PROCESS_VIEW__OPD:
				return getOpd();
			case OPPackage.OP_PROCESS_VIEW__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case OPPackage.OP_PROCESS_VIEW__X:
				return getX();
			case OPPackage.OP_PROCESS_VIEW__Y:
				return getY();
			case OPPackage.OP_PROCESS_VIEW__WIDTH:
				return getWidth();
			case OPPackage.OP_PROCESS_VIEW__HEIGHT:
				return getHeight();
			case OPPackage.OP_PROCESS_VIEW__INCOMING_LINKS:
				return getIncomingLinks();
			case OPPackage.OP_PROCESS_VIEW__OUTGOING_LINKS:
				return getOutgoingLinks();
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
			case OPPackage.OP_PROCESS_VIEW__SYSTEM:
				setSystem((OPSystem)newValue);
				return;
			case OPPackage.OP_PROCESS_VIEW__OPD:
				setOpd((OPObjectProcessDiagram)newValue);
				return;
			case OPPackage.OP_PROCESS_VIEW__MODEL:
				setModel((OPElement)newValue);
				return;
			case OPPackage.OP_PROCESS_VIEW__X:
				setX((Integer)newValue);
				return;
			case OPPackage.OP_PROCESS_VIEW__Y:
				setY((Integer)newValue);
				return;
			case OPPackage.OP_PROCESS_VIEW__WIDTH:
				setWidth((Integer)newValue);
				return;
			case OPPackage.OP_PROCESS_VIEW__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case OPPackage.OP_PROCESS_VIEW__INCOMING_LINKS:
				getIncomingLinks().clear();
				getIncomingLinks().addAll((Collection<? extends OPLinkView>)newValue);
				return;
			case OPPackage.OP_PROCESS_VIEW__OUTGOING_LINKS:
				getOutgoingLinks().clear();
				getOutgoingLinks().addAll((Collection<? extends OPLinkView>)newValue);
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
			case OPPackage.OP_PROCESS_VIEW__SYSTEM:
				setSystem((OPSystem)null);
				return;
			case OPPackage.OP_PROCESS_VIEW__OPD:
				setOpd((OPObjectProcessDiagram)null);
				return;
			case OPPackage.OP_PROCESS_VIEW__MODEL:
				setModel((OPElement)null);
				return;
			case OPPackage.OP_PROCESS_VIEW__X:
				setX(X_EDEFAULT);
				return;
			case OPPackage.OP_PROCESS_VIEW__Y:
				setY(Y_EDEFAULT);
				return;
			case OPPackage.OP_PROCESS_VIEW__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case OPPackage.OP_PROCESS_VIEW__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case OPPackage.OP_PROCESS_VIEW__INCOMING_LINKS:
				getIncomingLinks().clear();
				return;
			case OPPackage.OP_PROCESS_VIEW__OUTGOING_LINKS:
				getOutgoingLinks().clear();
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
			case OPPackage.OP_PROCESS_VIEW__SYSTEM:
				return getSystem() != null;
			case OPPackage.OP_PROCESS_VIEW__OPD:
				return getOpd() != null;
			case OPPackage.OP_PROCESS_VIEW__MODEL:
				return model != null;
			case OPPackage.OP_PROCESS_VIEW__X:
				return x != X_EDEFAULT;
			case OPPackage.OP_PROCESS_VIEW__Y:
				return y != Y_EDEFAULT;
			case OPPackage.OP_PROCESS_VIEW__WIDTH:
				return width != WIDTH_EDEFAULT;
			case OPPackage.OP_PROCESS_VIEW__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case OPPackage.OP_PROCESS_VIEW__INCOMING_LINKS:
				return incomingLinks != null && !incomingLinks.isEmpty();
			case OPPackage.OP_PROCESS_VIEW__OUTGOING_LINKS:
				return outgoingLinks != null && !outgoingLinks.isEmpty();
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
		result.append(" (x: ");
		result.append(x);
		result.append(", y: ");
		result.append(y);
		result.append(", width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(')');
		return result.toString();
	}

} //OPProcessViewImpl
