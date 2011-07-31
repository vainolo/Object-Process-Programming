/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model.impl;

import com.vainolo.phd.opm.model.Link;
import com.vainolo.phd.opm.model.Node;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.impl.LinkImpl#getSource <em>Source</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.impl.LinkImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.impl.LinkImpl#getOpd <em>Opd</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LinkImpl extends EObjectImpl implements Link {
    /**
     * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSource()
     * @generated
     * @ordered
     */
    protected Node source;

    /**
     * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTarget()
     * @generated
     * @ordered
     */
    protected Node target;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LinkImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return OPMPackage.Literals.LINK;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Node getSource() {
        if (source != null && source.eIsProxy()) {
            InternalEObject oldSource = (InternalEObject)source;
            source = (Node)eResolveProxy(oldSource);
            if (source != oldSource) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPMPackage.LINK__SOURCE, oldSource, source));
            }
        }
        return source;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Node basicGetSource() {
        return source;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSource(Node newSource, NotificationChain msgs) {
        Node oldSource = source;
        source = newSource;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OPMPackage.LINK__SOURCE, oldSource, newSource);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSource(Node newSource) {
        if (newSource != source) {
            NotificationChain msgs = null;
            if (source != null)
                msgs = ((InternalEObject)source).eInverseRemove(this, OPMPackage.NODE__OUTGOING_LINKS, Node.class, msgs);
            if (newSource != null)
                msgs = ((InternalEObject)newSource).eInverseAdd(this, OPMPackage.NODE__OUTGOING_LINKS, Node.class, msgs);
            msgs = basicSetSource(newSource, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OPMPackage.LINK__SOURCE, newSource, newSource));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Node getTarget() {
        if (target != null && target.eIsProxy()) {
            InternalEObject oldTarget = (InternalEObject)target;
            target = (Node)eResolveProxy(oldTarget);
            if (target != oldTarget) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPMPackage.LINK__TARGET, oldTarget, target));
            }
        }
        return target;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Node basicGetTarget() {
        return target;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTarget(Node newTarget, NotificationChain msgs) {
        Node oldTarget = target;
        target = newTarget;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OPMPackage.LINK__TARGET, oldTarget, newTarget);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTarget(Node newTarget) {
        if (newTarget != target) {
            NotificationChain msgs = null;
            if (target != null)
                msgs = ((InternalEObject)target).eInverseRemove(this, OPMPackage.NODE__INCOMING_LINKS, Node.class, msgs);
            if (newTarget != null)
                msgs = ((InternalEObject)newTarget).eInverseAdd(this, OPMPackage.NODE__INCOMING_LINKS, Node.class, msgs);
            msgs = basicSetTarget(newTarget, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OPMPackage.LINK__TARGET, newTarget, newTarget));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OPMObjectProcessDiagram getOpd() {
        if (eContainerFeatureID() != OPMPackage.LINK__OPD) return null;
        return (OPMObjectProcessDiagram)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOpd(OPMObjectProcessDiagram newOpd, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOpd, OPMPackage.LINK__OPD, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOpd(OPMObjectProcessDiagram newOpd) {
        if (newOpd != eInternalContainer() || (eContainerFeatureID() != OPMPackage.LINK__OPD && newOpd != null)) {
            if (EcoreUtil.isAncestor(this, newOpd))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOpd != null)
                msgs = ((InternalEObject)newOpd).eInverseAdd(this, OPMPackage.OPM_OBJECT_PROCESS_DIAGRAM__LINKS, OPMObjectProcessDiagram.class, msgs);
            msgs = basicSetOpd(newOpd, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OPMPackage.LINK__OPD, newOpd, newOpd));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case OPMPackage.LINK__SOURCE:
                if (source != null)
                    msgs = ((InternalEObject)source).eInverseRemove(this, OPMPackage.NODE__OUTGOING_LINKS, Node.class, msgs);
                return basicSetSource((Node)otherEnd, msgs);
            case OPMPackage.LINK__TARGET:
                if (target != null)
                    msgs = ((InternalEObject)target).eInverseRemove(this, OPMPackage.NODE__INCOMING_LINKS, Node.class, msgs);
                return basicSetTarget((Node)otherEnd, msgs);
            case OPMPackage.LINK__OPD:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOpd((OPMObjectProcessDiagram)otherEnd, msgs);
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
            case OPMPackage.LINK__SOURCE:
                return basicSetSource(null, msgs);
            case OPMPackage.LINK__TARGET:
                return basicSetTarget(null, msgs);
            case OPMPackage.LINK__OPD:
                return basicSetOpd(null, msgs);
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
            case OPMPackage.LINK__OPD:
                return eInternalContainer().eInverseRemove(this, OPMPackage.OPM_OBJECT_PROCESS_DIAGRAM__LINKS, OPMObjectProcessDiagram.class, msgs);
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
            case OPMPackage.LINK__SOURCE:
                if (resolve) return getSource();
                return basicGetSource();
            case OPMPackage.LINK__TARGET:
                if (resolve) return getTarget();
                return basicGetTarget();
            case OPMPackage.LINK__OPD:
                return getOpd();
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
            case OPMPackage.LINK__SOURCE:
                setSource((Node)newValue);
                return;
            case OPMPackage.LINK__TARGET:
                setTarget((Node)newValue);
                return;
            case OPMPackage.LINK__OPD:
                setOpd((OPMObjectProcessDiagram)newValue);
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
            case OPMPackage.LINK__SOURCE:
                setSource((Node)null);
                return;
            case OPMPackage.LINK__TARGET:
                setTarget((Node)null);
                return;
            case OPMPackage.LINK__OPD:
                setOpd((OPMObjectProcessDiagram)null);
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
            case OPMPackage.LINK__SOURCE:
                return source != null;
            case OPMPackage.LINK__TARGET:
                return target != null;
            case OPMPackage.LINK__OPD:
                return getOpd() != null;
        }
        return super.eIsSet(featureID);
    }

} //LinkImpl
