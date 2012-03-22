/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model.impl;

import com.vainolo.phd.opm.model.LinkLabel;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMPackage;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.impl.LinkLabelImpl#getText <em>Text</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.impl.LinkLabelImpl#getLink <em>Link</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.impl.LinkLabelImpl#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkLabelImpl extends EObjectImpl implements LinkLabel {
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = "Hello";

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLink() <em>Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink()
	 * @generated
	 * @ordered
	 */
	protected OPMLink link;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final Point LOCATION_EDEFAULT = (Point)OPMFactory.eINSTANCE.createFromString(OPMPackage.eINSTANCE.getPoint(), "0,0");

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected Point location = LOCATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OPMPackage.Literals.LINK_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPMPackage.LINK_LABEL__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPMLink getLink() {
		if (link != null && link.eIsProxy()) {
			InternalEObject oldLink = (InternalEObject)link;
			link = (OPMLink)eResolveProxy(oldLink);
			if (link != oldLink) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPMPackage.LINK_LABEL__LINK, oldLink, link));
			}
		}
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPMLink basicGetLink() {
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink(OPMLink newLink) {
		OPMLink oldLink = link;
		link = newLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPMPackage.LINK_LABEL__LINK, oldLink, link));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(Point newLocation) {
		Point oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPMPackage.LINK_LABEL__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OPMPackage.LINK_LABEL__TEXT:
				return getText();
			case OPMPackage.LINK_LABEL__LINK:
				if (resolve) return getLink();
				return basicGetLink();
			case OPMPackage.LINK_LABEL__LOCATION:
				return getLocation();
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
			case OPMPackage.LINK_LABEL__TEXT:
				setText((String)newValue);
				return;
			case OPMPackage.LINK_LABEL__LINK:
				setLink((OPMLink)newValue);
				return;
			case OPMPackage.LINK_LABEL__LOCATION:
				setLocation((Point)newValue);
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
			case OPMPackage.LINK_LABEL__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case OPMPackage.LINK_LABEL__LINK:
				setLink((OPMLink)null);
				return;
			case OPMPackage.LINK_LABEL__LOCATION:
				setLocation(LOCATION_EDEFAULT);
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
			case OPMPackage.LINK_LABEL__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case OPMPackage.LINK_LABEL__LINK:
				return link != null;
			case OPMPackage.LINK_LABEL__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
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
		result.append(" (text: ");
		result.append(text);
		result.append(", location: ");
		result.append(location);
		result.append(')');
		return result.toString();
	}

} //LinkLabelImpl
