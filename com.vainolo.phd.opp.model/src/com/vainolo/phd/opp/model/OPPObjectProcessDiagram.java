/**
 */
package com.vainolo.phd.opp.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Process Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.phd.opp.model.OPPObjectProcessDiagram#getLinks <em>Links</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPObjectProcessDiagram#getLastKnownUsedId <em>Last Known Used Id</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPObjectProcessDiagram#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opp.model.OPPPackage#getOPPObjectProcessDiagram()
 * @model
 * @generated
 */
public interface OPPObjectProcessDiagram extends OPPContainer, OPPNamedElement {
  /**
   * Returns the value of the '<em><b>Links</b></em>' containment reference list.
   * The list contents are of type {@link com.vainolo.phd.opp.model.OPPLink}.
   * It is bidirectional and its opposite is '{@link com.vainolo.phd.opp.model.OPPLink#getOpd <em>Opd</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Links</em>' containment reference list.
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPObjectProcessDiagram_Links()
   * @see com.vainolo.phd.opp.model.OPPLink#getOpd
   * @model opposite="opd" containment="true"
   * @generated
   */
  EList<OPPLink> getLinks();

  /**
   * Returns the value of the '<em><b>Last Known Used Id</b></em>' attribute.
   * The default value is <code>"0"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Last Known Used Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Last Known Used Id</em>' attribute.
   * @see #setLastKnownUsedId(long)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPObjectProcessDiagram_LastKnownUsedId()
   * @model default="0"
   * @generated
   */
  long getLastKnownUsedId();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPObjectProcessDiagram#getLastKnownUsedId <em>Last Known Used Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Last Known Used Id</em>' attribute.
   * @see #getLastKnownUsedId()
   * @generated
   */
  void setLastKnownUsedId(long value);

  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The default value is <code>"Compound"</code>.
   * The literals are from the enumeration {@link com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind
   * @see #setKind(OPPObjectProcessDiagramKind)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPObjectProcessDiagram_Kind()
   * @model default="Compound" required="true"
   * @generated
   */
  OPPObjectProcessDiagramKind getKind();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPObjectProcessDiagram#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind
   * @see #getKind()
   * @generated
   */
  void setKind(OPPObjectProcessDiagramKind value);

} // OPPObjectProcessDiagram
