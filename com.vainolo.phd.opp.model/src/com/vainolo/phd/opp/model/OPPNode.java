/**
 */
package com.vainolo.phd.opp.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.phd.opp.model.OPPNode#getIncomingLinks <em>Incoming Links</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPNode#getOutgoingLinks <em>Outgoing Links</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPNode#getContainer <em>Container</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPNode#getWidth <em>Width</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPNode#getHeight <em>Height</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPNode#getX <em>X</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPNode#getY <em>Y</em>}</li>
 *   <li>{@link com.vainolo.phd.opp.model.OPPNode#isManualSize <em>Manual Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opp.model.OPPPackage#getOPPNode()
 * @model abstract="true"
 * @generated
 */
public interface OPPNode extends OPPElement {
  /**
   * Returns the value of the '<em><b>Incoming Links</b></em>' reference list.
   * The list contents are of type {@link com.vainolo.phd.opp.model.OPPLink}.
   * It is bidirectional and its opposite is '{@link com.vainolo.phd.opp.model.OPPLink#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Incoming Links</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Incoming Links</em>' reference list.
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPNode_IncomingLinks()
   * @see com.vainolo.phd.opp.model.OPPLink#getTarget
   * @model opposite="target"
   * @generated
   */
  EList<OPPLink> getIncomingLinks();

  /**
   * Returns the value of the '<em><b>Outgoing Links</b></em>' reference list.
   * The list contents are of type {@link com.vainolo.phd.opp.model.OPPLink}.
   * It is bidirectional and its opposite is '{@link com.vainolo.phd.opp.model.OPPLink#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outgoing Links</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outgoing Links</em>' reference list.
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPNode_OutgoingLinks()
   * @see com.vainolo.phd.opp.model.OPPLink#getSource
   * @model opposite="source"
   * @generated
   */
  EList<OPPLink> getOutgoingLinks();

  /**
   * Returns the value of the '<em><b>Container</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link com.vainolo.phd.opp.model.OPPContainer#getNodes <em>Nodes</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Container</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Container</em>' container reference.
   * @see #setContainer(OPPContainer)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPNode_Container()
   * @see com.vainolo.phd.opp.model.OPPContainer#getNodes
   * @model opposite="nodes" transient="false"
   * @generated
   */
  OPPContainer getContainer();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPNode#getContainer <em>Container</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Container</em>' container reference.
   * @see #getContainer()
   * @generated
   */
  void setContainer(OPPContainer value);

  /**
   * Returns the value of the '<em><b>Width</b></em>' attribute.
   * The default value is <code>"0"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Width</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Width</em>' attribute.
   * @see #setWidth(int)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPNode_Width()
   * @model default="0"
   * @generated
   */
  int getWidth();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPNode#getWidth <em>Width</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Width</em>' attribute.
   * @see #getWidth()
   * @generated
   */
  void setWidth(int value);

  /**
   * Returns the value of the '<em><b>Height</b></em>' attribute.
   * The default value is <code>"0"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Height</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Height</em>' attribute.
   * @see #setHeight(int)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPNode_Height()
   * @model default="0"
   * @generated
   */
  int getHeight();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPNode#getHeight <em>Height</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Height</em>' attribute.
   * @see #getHeight()
   * @generated
   */
  void setHeight(int value);

  /**
   * Returns the value of the '<em><b>X</b></em>' attribute.
   * The default value is <code>"0"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>X</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>X</em>' attribute.
   * @see #setX(int)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPNode_X()
   * @model default="0"
   * @generated
   */
  int getX();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPNode#getX <em>X</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>X</em>' attribute.
   * @see #getX()
   * @generated
   */
  void setX(int value);

  /**
   * Returns the value of the '<em><b>Y</b></em>' attribute.
   * The default value is <code>"0"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Y</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Y</em>' attribute.
   * @see #setY(int)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPNode_Y()
   * @model default="0"
   * @generated
   */
  int getY();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPNode#getY <em>Y</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Y</em>' attribute.
   * @see #getY()
   * @generated
   */
  void setY(int value);

  /**
   * Returns the value of the '<em><b>Manual Size</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Manual Size</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Manual Size</em>' attribute.
   * @see #setManualSize(boolean)
   * @see com.vainolo.phd.opp.model.OPPPackage#getOPPNode_ManualSize()
   * @model default="false"
   * @generated
   */
  boolean isManualSize();

  /**
   * Sets the value of the '{@link com.vainolo.phd.opp.model.OPPNode#isManualSize <em>Manual Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Manual Size</em>' attribute.
   * @see #isManualSize()
   * @generated
   */
  void setManualSize(boolean value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  void setConstraints(int x, int y, int width, int height);

} // OPPNode
