/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model.impl;

import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMPackage;
import com.vainolo.phd.opm.model.OPMThing;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Process Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.impl.OPMObjectProcessDiagramImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.impl.OPMObjectProcessDiagramImpl#getThings <em>Things</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OPMObjectProcessDiagramImpl extends EObjectImpl implements OPMObjectProcessDiagram {
	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<OPMLink> links;

	/**
	 * The cached value of the '{@link #getThings() <em>Things</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThings()
	 * @generated
	 * @ordered
	 */
	protected EList<OPMThing> things;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OPMObjectProcessDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OPMPackage.Literals.OPM_OBJECT_PROCESS_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OPMLink> getLinks() {
		if (links == null) {
			links = new EObjectContainmentWithInverseEList<OPMLink>(OPMLink.class, this, OPMPackage.OPM_OBJECT_PROCESS_DIAGRAM__LINKS, OPMPackage.OPM_LINK__OPD);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OPMThing> getThings() {
		if (things == null) {
			things = new EObjectContainmentWithInverseEList<OPMThing>(OPMThing.class, this, OPMPackage.OPM_OBJECT_PROCESS_DIAGRAM__THINGS, OPMPackage.OPM_THING__OPD);
		}
		return things;
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
			case OPMPackage.OPM_OBJECT_PROCESS_DIAGRAM__LINKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLinks()).basicAdd(otherEnd, msgs);
			case OPMPackage.OPM_OBJECT_PROCESS_DIAGRAM__THINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getThings()).basicAdd(otherEnd, msgs);
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
			case OPMPackage.OPM_OBJECT_PROCESS_DIAGRAM__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
			case OPMPackage.OPM_OBJECT_PROCESS_DIAGRAM__THINGS:
				return ((InternalEList<?>)getThings()).basicRemove(otherEnd, msgs);
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
			case OPMPackage.OPM_OBJECT_PROCESS_DIAGRAM__LINKS:
				return getLinks();
			case OPMPackage.OPM_OBJECT_PROCESS_DIAGRAM__THINGS:
				return getThings();
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
			case OPMPackage.OPM_OBJECT_PROCESS_DIAGRAM__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends OPMLink>)newValue);
				return;
			case OPMPackage.OPM_OBJECT_PROCESS_DIAGRAM__THINGS:
				getThings().clear();
				getThings().addAll((Collection<? extends OPMThing>)newValue);
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
			case OPMPackage.OPM_OBJECT_PROCESS_DIAGRAM__LINKS:
				getLinks().clear();
				return;
			case OPMPackage.OPM_OBJECT_PROCESS_DIAGRAM__THINGS:
				getThings().clear();
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
			case OPMPackage.OPM_OBJECT_PROCESS_DIAGRAM__LINKS:
				return links != null && !links.isEmpty();
			case OPMPackage.OPM_OBJECT_PROCESS_DIAGRAM__THINGS:
				return things != null && !things.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OPMObjectProcessDiagramImpl
