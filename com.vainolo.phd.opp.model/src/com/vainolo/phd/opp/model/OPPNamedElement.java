/**
 */
package com.vainolo.phd.opp.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.phd.opp.model.OPPNamedElement#getName <em>Name</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPNamedElement#getAlignment <em>Alignment</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opp.model.OPPPackage#getOPPNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface OPPNamedElement extends EObject {
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * The default value is <code>"<<name>>"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPNamedElement_Name()
   * @model default="<<name>>"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPNamedElement#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Alignment</b></em>' attribute.
   * The default value is <code>"Center"</code>.
   * The literals are from the enumeration {@link com.vainolo.phd.opp.model.OPPVerticalAlignment}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Alignment</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alignment</em>' attribute.
   * @see com.vainolo.phd.opp.model.OPPVerticalAlignment
   * @see #setAlignment(OPPVerticalAlignment)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPNamedElement_Alignment()
   * @model default="Center"
   * @generated
   */
  OPPVerticalAlignment getAlignment();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPNamedElement#getAlignment <em>Alignment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alignment</em>' attribute.
   * @see com.vainolo.phd.opp.model.OPPVerticalAlignment
   * @see #getAlignment()
   * @generated
   */
  void setAlignment(OPPVerticalAlignment value);

} // OPPNamedElement
