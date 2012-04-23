/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.Label#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opm.model.OPMPackage#getLabel()
 * @model
 * @generated
 */
public interface Label extends OPMNode, OPMNamedElement {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * The default value is <code>"text"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see com.vainolo.phd.opm.model.OPMPackage#getLabel_Text()
	 * @model default="text"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link com.vainolo.phd.opm.model.Label#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

} // Label
