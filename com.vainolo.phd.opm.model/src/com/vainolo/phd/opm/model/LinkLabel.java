/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.LinkLabel#getText <em>Text</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.LinkLabel#getLink <em>Link</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.LinkLabel#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opm.model.OPMPackage#getLinkLabel()
 * @model
 * @generated
 */
public interface LinkLabel extends EObject {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * The default value is <code>"Hello"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see com.vainolo.phd.opm.model.OPMPackage#getLinkLabel_Text()
	 * @model default="Hello"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link com.vainolo.phd.opm.model.LinkLabel#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Link</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link</em>' reference.
	 * @see #setLink(OPMLink)
	 * @see com.vainolo.phd.opm.model.OPMPackage#getLinkLabel_Link()
	 * @model
	 * @generated
	 */
	OPMLink getLink();

	/**
	 * Sets the value of the '{@link com.vainolo.phd.opm.model.LinkLabel#getLink <em>Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link</em>' reference.
	 * @see #getLink()
	 * @generated
	 */
	void setLink(OPMLink value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * The default value is <code>"0,0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(Point)
	 * @see com.vainolo.phd.opm.model.OPMPackage#getLinkLabel_Location()
	 * @model default="0,0" dataType="com.vainolo.phd.opm.model.Point"
	 * @generated
	 */
	Point getLocation();

	/**
	 * Sets the value of the '{@link com.vainolo.phd.opm.model.LinkLabel#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Point value);

} // LinkLabel
