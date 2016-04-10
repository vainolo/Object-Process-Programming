/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 */
package com.vainolo.phd.opp.model.util;

import com.vainolo.phd.opp.model.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.vainolo.phd.opp.model.OPPPackage
 * @generated
 */
public class OPPSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static OPPPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPSwitch() {
    if (modelPackage == null) {
      modelPackage = OPPPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
      case OPPPackage.OPP_ELEMENT: {
        OPPElement oppElement = (OPPElement)theEObject;
        T result = caseOPPElement(oppElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OPPPackage.OPP_NAMED_ELEMENT: {
        OPPNamedElement oppNamedElement = (OPPNamedElement)theEObject;
        T result = caseOPPNamedElement(oppNamedElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OPPPackage.OPP_CONTAINER: {
        OPPContainer oppContainer = (OPPContainer)theEObject;
        T result = caseOPPContainer(oppContainer);
        if (result == null) result = caseOPPElement(oppContainer);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OPPPackage.OPP_NODE: {
        OPPNode oppNode = (OPPNode)theEObject;
        T result = caseOPPNode(oppNode);
        if (result == null) result = caseOPPElement(oppNode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM: {
        OPPObjectProcessDiagram oppObjectProcessDiagram = (OPPObjectProcessDiagram)theEObject;
        T result = caseOPPObjectProcessDiagram(oppObjectProcessDiagram);
        if (result == null) result = caseOPPContainer(oppObjectProcessDiagram);
        if (result == null) result = caseOPPNamedElement(oppObjectProcessDiagram);
        if (result == null) result = caseOPPElement(oppObjectProcessDiagram);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OPPPackage.OPP_THING: {
        OPPThing oppThing = (OPPThing)theEObject;
        T result = caseOPPThing(oppThing);
        if (result == null) result = caseOPPNode(oppThing);
        if (result == null) result = caseOPPContainer(oppThing);
        if (result == null) result = caseOPPNamedElement(oppThing);
        if (result == null) result = caseOPPElement(oppThing);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OPPPackage.OPP_STATE: {
        OPPState oppState = (OPPState)theEObject;
        T result = caseOPPState(oppState);
        if (result == null) result = caseOPPNode(oppState);
        if (result == null) result = caseOPPNamedElement(oppState);
        if (result == null) result = caseOPPElement(oppState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OPPPackage.OPP_OBJECT: {
        OPPObject oppObject = (OPPObject)theEObject;
        T result = caseOPPObject(oppObject);
        if (result == null) result = caseOPPThing(oppObject);
        if (result == null) result = caseOPPNode(oppObject);
        if (result == null) result = caseOPPContainer(oppObject);
        if (result == null) result = caseOPPNamedElement(oppObject);
        if (result == null) result = caseOPPElement(oppObject);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OPPPackage.OPP_PROCESS: {
        OPPProcess oppProcess = (OPPProcess)theEObject;
        T result = caseOPPProcess(oppProcess);
        if (result == null) result = caseOPPThing(oppProcess);
        if (result == null) result = caseOPPNode(oppProcess);
        if (result == null) result = caseOPPContainer(oppProcess);
        if (result == null) result = caseOPPNamedElement(oppProcess);
        if (result == null) result = caseOPPElement(oppProcess);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OPPPackage.OPP_STRUCTURAL_LINK_AGGREGATOR: {
        OPPStructuralLinkAggregator oppStructuralLinkAggregator = (OPPStructuralLinkAggregator)theEObject;
        T result = caseOPPStructuralLinkAggregator(oppStructuralLinkAggregator);
        if (result == null) result = caseOPPNode(oppStructuralLinkAggregator);
        if (result == null) result = caseOPPElement(oppStructuralLinkAggregator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OPPPackage.OPP_LABEL: {
        OPPLabel oppLabel = (OPPLabel)theEObject;
        T result = caseOPPLabel(oppLabel);
        if (result == null) result = caseOPPNode(oppLabel);
        if (result == null) result = caseOPPNamedElement(oppLabel);
        if (result == null) result = caseOPPElement(oppLabel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OPPPackage.OPP_LINK: {
        OPPLink oppLink = (OPPLink)theEObject;
        T result = caseOPPLink(oppLink);
        if (result == null) result = caseOPPElement(oppLink);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OPPPackage.OPP_PROCEDURAL_LINK: {
        OPPProceduralLink oppProceduralLink = (OPPProceduralLink)theEObject;
        T result = caseOPPProceduralLink(oppProceduralLink);
        if (result == null) result = caseOPPLink(oppProceduralLink);
        if (result == null) result = caseOPPElement(oppProceduralLink);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OPPPackage.OPP_STRUCTURAL_LINK_PART: {
        OPPStructuralLinkPart oppStructuralLinkPart = (OPPStructuralLinkPart)theEObject;
        T result = caseOPPStructuralLinkPart(oppStructuralLinkPart);
        if (result == null) result = caseOPPLink(oppStructuralLinkPart);
        if (result == null) result = caseOPPElement(oppStructuralLinkPart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case OPPPackage.OPP_POINT: {
        OPPPoint oppPoint = (OPPPoint)theEObject;
        T result = caseOPPPoint(oppPoint);
        if (result == null) result = caseOPPElement(oppPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOPPElement(OPPElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOPPNamedElement(OPPNamedElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOPPContainer(OPPContainer object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOPPNode(OPPNode object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object Process Diagram</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object Process Diagram</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOPPObjectProcessDiagram(OPPObjectProcessDiagram object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Thing</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Thing</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOPPThing(OPPThing object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOPPState(OPPState object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOPPObject(OPPObject object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Process</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Process</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOPPProcess(OPPProcess object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Structural Link Aggregator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Structural Link Aggregator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOPPStructuralLinkAggregator(OPPStructuralLinkAggregator object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Link</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Link</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOPPLink(OPPLink object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Procedural Link</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Procedural Link</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOPPProceduralLink(OPPProceduralLink object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Structural Link Part</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Structural Link Part</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOPPStructuralLinkPart(OPPStructuralLinkPart object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Label</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOPPLabel(OPPLabel object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOPPPoint(OPPPoint object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object) {
    return null;
  }

} //OPPSwitch
