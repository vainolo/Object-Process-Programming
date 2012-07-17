/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vainolo.phd.opm.model.OPMLink#getOpd <em>Opd</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.OPMLink#getSource <em>Source</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.OPMLink#getTarget <em>Target</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.OPMLink#getBendpoints <em>Bendpoints</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.OPMLink#getRouterKind <em>Router Kind</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.OPMLink#getSourceDecoration <em>Source Decoration</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.OPMLink#getTargetDecoration <em>Target Decoration</em>}</li>
 *   <li>{@link com.vainolo.phd.opm.model.OPMLink#getCenterDecoration <em>Center Decoration</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMLink()
 * @model
 * @generated
 */
public interface OPMLink extends OPMNode {
	/**
   * Returns the value of the '<em><b>Opd</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getLinks <em>Links</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opd</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Opd</em>' container reference.
   * @see #setOpd(OPMObjectProcessDiagram)
   * @see com.vainolo.phd.opm.model.OPMPackage#getOPMLink_Opd()
   * @see com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getLinks
   * @model opposite="links" transient="false"
   * @generated
   */
	OPMObjectProcessDiagram getOpd();

	/**
   * Sets the value of the '{@link com.vainolo.phd.opm.model.OPMLink#getOpd <em>Opd</em>}' container reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opd</em>' container reference.
   * @see #getOpd()
   * @generated
   */
	void setOpd(OPMObjectProcessDiagram value);

	/**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * It is bidirectional and its opposite is '{@link com.vainolo.phd.opm.model.OPMNode#getOutgoingLinks <em>Outgoing Links</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(OPMNode)
   * @see com.vainolo.phd.opm.model.OPMPackage#getOPMLink_Source()
   * @see com.vainolo.phd.opm.model.OPMNode#getOutgoingLinks
   * @model opposite="outgoingLinks"
   * @generated
   */
	OPMNode getSource();

	/**
   * Sets the value of the '{@link com.vainolo.phd.opm.model.OPMLink#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
	void setSource(OPMNode value);

	/**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * It is bidirectional and its opposite is '{@link com.vainolo.phd.opm.model.OPMNode#getIncomingLinks <em>Incoming Links</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(OPMNode)
   * @see com.vainolo.phd.opm.model.OPMPackage#getOPMLink_Target()
   * @see com.vainolo.phd.opm.model.OPMNode#getIncomingLinks
   * @model opposite="incomingLinks"
   * @generated
   */
	OPMNode getTarget();

	/**
   * Sets the value of the '{@link com.vainolo.phd.opm.model.OPMLink#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
	void setTarget(OPMNode value);

	/**
   * Returns the value of the '<em><b>Bendpoints</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.draw2d.geometry.Point}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bendpoints</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Bendpoints</em>' attribute list.
   * @see com.vainolo.phd.opm.model.OPMPackage#getOPMLink_Bendpoints()
   * @model dataType="com.vainolo.phd.opm.model.Point"
   * @generated
   */
	EList<Point> getBendpoints();

    /**
   * Returns the value of the '<em><b>Router Kind</b></em>' attribute.
   * The default value is <code>""</code>.
   * The literals are from the enumeration {@link com.vainolo.phd.opm.model.OPMLinkRouterKind}.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Router Kind</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Router Kind</em>' attribute.
   * @see com.vainolo.phd.opm.model.OPMLinkRouterKind
   * @see #setRouterKind(OPMLinkRouterKind)
   * @see com.vainolo.phd.opm.model.OPMPackage#getOPMLink_RouterKind()
   * @model default=""
   * @generated
   */
    OPMLinkRouterKind getRouterKind();

    /**
   * Sets the value of the '{@link com.vainolo.phd.opm.model.OPMLink#getRouterKind <em>Router Kind</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Router Kind</em>' attribute.
   * @see com.vainolo.phd.opm.model.OPMLinkRouterKind
   * @see #getRouterKind()
   * @generated
   */
    void setRouterKind(OPMLinkRouterKind value);

    /**
   * Returns the value of the '<em><b>Source Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Decoration</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Source Decoration</em>' attribute.
   * @see #setSourceDecoration(String)
   * @see com.vainolo.phd.opm.model.OPMPackage#getOPMLink_SourceDecoration()
   * @model
   * @generated
   */
    String getSourceDecoration();

    /**
   * Sets the value of the '{@link com.vainolo.phd.opm.model.OPMLink#getSourceDecoration <em>Source Decoration</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source Decoration</em>' attribute.
   * @see #getSourceDecoration()
   * @generated
   */
    void setSourceDecoration(String value);

    /**
   * Returns the value of the '<em><b>Target Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Decoration</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Target Decoration</em>' attribute.
   * @see #setTargetDecoration(String)
   * @see com.vainolo.phd.opm.model.OPMPackage#getOPMLink_TargetDecoration()
   * @model
   * @generated
   */
    String getTargetDecoration();

    /**
   * Sets the value of the '{@link com.vainolo.phd.opm.model.OPMLink#getTargetDecoration <em>Target Decoration</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Decoration</em>' attribute.
   * @see #getTargetDecoration()
   * @generated
   */
    void setTargetDecoration(String value);

    /**
   * Returns the value of the '<em><b>Center Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Center Decoration</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Center Decoration</em>' attribute.
   * @see #setCenterDecoration(String)
   * @see com.vainolo.phd.opm.model.OPMPackage#getOPMLink_CenterDecoration()
   * @model
   * @generated
   */
    String getCenterDecoration();

    /**
   * Sets the value of the '{@link com.vainolo.phd.opm.model.OPMLink#getCenterDecoration <em>Center Decoration</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @param value the new value of the '<em>Center Decoration</em>' attribute.
   * @see #getCenterDecoration()
   * @generated
   */
    void setCenterDecoration(String value);

} // OPMLink
