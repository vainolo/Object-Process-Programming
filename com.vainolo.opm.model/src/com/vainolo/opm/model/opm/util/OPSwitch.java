/**
 */
package com.vainolo.opm.model.opm.util;

import com.vainolo.opm.model.opm.*;

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
 * @see com.vainolo.opm.model.opm.OPPackage
 * @generated
 */
public class OPSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OPPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPSwitch() {
		if (modelPackage == null) {
			modelPackage = OPPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
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
			case OPPackage.OP_SYSTEM: {
				OPSystem opSystem = (OPSystem)theEObject;
				T result = caseOPSystem(opSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_OBJECT_PROCESS_DIAGRAM: {
				OPObjectProcessDiagram opObjectProcessDiagram = (OPObjectProcessDiagram)theEObject;
				T result = caseOPObjectProcessDiagram(opObjectProcessDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_ELEMENT: {
				OPElement opElement = (OPElement)theEObject;
				T result = caseOPElement(opElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_LINK: {
				OPLink opLink = (OPLink)theEObject;
				T result = caseOPLink(opLink);
				if (result == null) result = caseOPElement(opLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_NODE: {
				OPNode opNode = (OPNode)theEObject;
				T result = caseOPNode(opNode);
				if (result == null) result = caseOPElement(opNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_STATE: {
				OPState opState = (OPState)theEObject;
				T result = caseOPState(opState);
				if (result == null) result = caseOPNode(opState);
				if (result == null) result = caseOPElement(opState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_THING: {
				OPThing opThing = (OPThing)theEObject;
				T result = caseOPThing(opThing);
				if (result == null) result = caseOPNode(opThing);
				if (result == null) result = caseOPElement(opThing);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_OBJECT: {
				OPObject opObject = (OPObject)theEObject;
				T result = caseOPObject(opObject);
				if (result == null) result = caseOPThing(opObject);
				if (result == null) result = caseOPNode(opObject);
				if (result == null) result = caseOPElement(opObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_PROCESS: {
				OPProcess opProcess = (OPProcess)theEObject;
				T result = caseOPProcess(opProcess);
				if (result == null) result = caseOPThing(opProcess);
				if (result == null) result = caseOPNode(opProcess);
				if (result == null) result = caseOPElement(opProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_PROCEDURAL_LINK: {
				OPProceduralLink opProceduralLink = (OPProceduralLink)theEObject;
				T result = caseOPProceduralLink(opProceduralLink);
				if (result == null) result = caseOPLink(opProceduralLink);
				if (result == null) result = caseOPElement(opProceduralLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_STRUCTURAL_LINK: {
				OPStructuralLink opStructuralLink = (OPStructuralLink)theEObject;
				T result = caseOPStructuralLink(opStructuralLink);
				if (result == null) result = caseOPLink(opStructuralLink);
				if (result == null) result = caseOPElement(opStructuralLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_ELEMENT_VIEW: {
				OPElementView opElementView = (OPElementView)theEObject;
				T result = caseOPElementView(opElementView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_NODE_VIEW: {
				OPNodeView opNodeView = (OPNodeView)theEObject;
				T result = caseOPNodeView(opNodeView);
				if (result == null) result = caseOPElementView(opNodeView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_LINK_VIEW: {
				OPLinkView opLinkView = (OPLinkView)theEObject;
				T result = caseOPLinkView(opLinkView);
				if (result == null) result = caseOPElementView(opLinkView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_THING_VIEW: {
				OPThingView opThingView = (OPThingView)theEObject;
				T result = caseOPThingView(opThingView);
				if (result == null) result = caseOPNodeView(opThingView);
				if (result == null) result = caseOPElementView(opThingView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_STATE_VIEW: {
				OPStateView opStateView = (OPStateView)theEObject;
				T result = caseOPStateView(opStateView);
				if (result == null) result = caseOPNodeView(opStateView);
				if (result == null) result = caseOPElementView(opStateView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_STRUCTURAL_LINK_AGGREGATOR_VIEW: {
				OPStructuralLinkAggregatorView opStructuralLinkAggregatorView = (OPStructuralLinkAggregatorView)theEObject;
				T result = caseOPStructuralLinkAggregatorView(opStructuralLinkAggregatorView);
				if (result == null) result = caseOPNodeView(opStructuralLinkAggregatorView);
				if (result == null) result = caseOPElementView(opStructuralLinkAggregatorView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_OBJECT_VIEW: {
				OPObjectView opObjectView = (OPObjectView)theEObject;
				T result = caseOPObjectView(opObjectView);
				if (result == null) result = caseOPThingView(opObjectView);
				if (result == null) result = caseOPNodeView(opObjectView);
				if (result == null) result = caseOPElementView(opObjectView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_PROCESS_VIEW: {
				OPProcessView opProcessView = (OPProcessView)theEObject;
				T result = caseOPProcessView(opProcessView);
				if (result == null) result = caseOPThingView(opProcessView);
				if (result == null) result = caseOPNodeView(opProcessView);
				if (result == null) result = caseOPElementView(opProcessView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_PROCEDURAL_LINK_VIEW: {
				OPProceduralLinkView opProceduralLinkView = (OPProceduralLinkView)theEObject;
				T result = caseOPProceduralLinkView(opProceduralLinkView);
				if (result == null) result = caseOPLinkView(opProceduralLinkView);
				if (result == null) result = caseOPElementView(opProceduralLinkView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW: {
				OPStructuralLinkPartView opStructuralLinkPartView = (OPStructuralLinkPartView)theEObject;
				T result = caseOPStructuralLinkPartView(opStructuralLinkPartView);
				if (result == null) result = caseOPLinkView(opStructuralLinkPartView);
				if (result == null) result = caseOPElementView(opStructuralLinkPartView);
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
	public T caseOPElement(OPElement object) {
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
	public T caseOPLink(OPLink object) {
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
	public T caseOPObject(OPObject object) {
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
	public T caseOPProcess(OPProcess object) {
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
	public T caseOPProceduralLink(OPProceduralLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structural Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structural Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOPStructuralLink(OPStructuralLink object) {
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
	public T caseOPNode(OPNode object) {
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
	public T caseOPState(OPState object) {
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
	public T caseOPThing(OPThing object) {
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
	public T caseOPObjectProcessDiagram(OPObjectProcessDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOPSystem(OPSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOPObjectView(OPObjectView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOPProcessView(OPProcessView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thing View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thing View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOPThingView(OPThingView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOPStateView(OPStateView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOPNodeView(OPNodeView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOPElementView(OPElementView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOPLinkView(OPLinkView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Procedural Link View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Procedural Link View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOPProceduralLinkView(OPProceduralLinkView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structural Link Part View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structural Link Part View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOPStructuralLinkPartView(OPStructuralLinkPartView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structural Link Aggregator View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structural Link Aggregator View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOPStructuralLinkAggregatorView(OPStructuralLinkAggregatorView object) {
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

} //OPSwitch
