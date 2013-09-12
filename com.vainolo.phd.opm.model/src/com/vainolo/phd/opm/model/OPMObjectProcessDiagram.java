/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Process Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getLinks <em>Links</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getNextId <em>Next Id</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMObjectProcessDiagram()
 * @model
 * @generated
 */
public interface OPMObjectProcessDiagram extends OPMContainer, OPMNamedElement {
	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link com.vainolo.phd.opm.model.OPMLink}.
	 * It is bidirectional and its opposite is '{@link com.vainolo.phd.opm.model.OPMLink#getOpd <em>Opd</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMObjectProcessDiagram_Links()
	 * @see com.vainolo.phd.opm.model.OPMLink#getOpd
	 * @model opposite="opd" containment="true"
	 * @generated
	 */
	EList<OPMLink> getLinks();

	/**
	 * Returns the value of the '<em><b>Next Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Next Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Id</em>' attribute.
	 * @see #setNextId(long)
	 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMObjectProcessDiagram_NextId()
	 * @model
	 * @generated
	 */
  long getNextId();

  /**
	 * Sets the value of the '{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getNextId <em>Next Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Id</em>' attribute.
	 * @see #getNextId()
	 * @generated
	 */
  void setNextId(long value);

  /**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"Compound"</code>.
	 * The literals are from the enumeration {@link com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind
	 * @see #setKind(OPMObjectProcessDiagramKind)
	 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMObjectProcessDiagram_Kind()
	 * @model default="Compound" required="true"
	 * @generated
	 */
  OPMObjectProcessDiagramKind getKind();

  /**
	 * Sets the value of the '{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind
	 * @see #getKind()
	 * @generated
	 */
  void setKind(OPMObjectProcessDiagramKind value);

} // OPMObjectProcessDiagram
