/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model.util;

import com.vainolo.phd.opm.model.*;

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
 * @see com.vainolo.phd.opm.model.OPMPackage
 * @generated
 */
public class OPMSwitch<T> extends Switch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static OPMPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OPMSwitch() {
        if (modelPackage == null) {
            modelPackage = OPMPackage.eINSTANCE;
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
            case OPMPackage.NAMED_ELEMENT: {
                NamedElement namedElement = (NamedElement)theEObject;
                T result = caseNamedElement(namedElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.NODE: {
                Node node = (Node)theEObject;
                T result = caseNode(node);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.NODE_CONTAINER: {
                NodeContainer nodeContainer = (NodeContainer)theEObject;
                T result = caseNodeContainer(nodeContainer);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.OPM_OBJECT_PROCESS_DIAGRAM: {
                OPMObjectProcessDiagram opmObjectProcessDiagram = (OPMObjectProcessDiagram)theEObject;
                T result = caseOPMObjectProcessDiagram(opmObjectProcessDiagram);
                if (result == null) result = caseNodeContainer(opmObjectProcessDiagram);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.OPM_STATE: {
                OPMState opmState = (OPMState)theEObject;
                T result = caseOPMState(opmState);
                if (result == null) result = caseNode(opmState);
                if (result == null) result = caseNamedElement(opmState);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.OPM_THING: {
                OPMThing opmThing = (OPMThing)theEObject;
                T result = caseOPMThing(opmThing);
                if (result == null) result = caseNode(opmThing);
                if (result == null) result = caseNamedElement(opmThing);
                if (result == null) result = caseNodeContainer(opmThing);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.OPM_OBJECT: {
                OPMObject opmObject = (OPMObject)theEObject;
                T result = caseOPMObject(opmObject);
                if (result == null) result = caseOPMThing(opmObject);
                if (result == null) result = caseNode(opmObject);
                if (result == null) result = caseNamedElement(opmObject);
                if (result == null) result = caseNodeContainer(opmObject);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.OPM_PROCESS: {
                OPMProcess opmProcess = (OPMProcess)theEObject;
                T result = caseOPMProcess(opmProcess);
                if (result == null) result = caseOPMThing(opmProcess);
                if (result == null) result = caseNode(opmProcess);
                if (result == null) result = caseNamedElement(opmProcess);
                if (result == null) result = caseNodeContainer(opmProcess);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.OPM_STRUCTURAL_LINK_AGGREGATOR: {
                OPMStructuralLinkAggregator opmStructuralLinkAggregator = (OPMStructuralLinkAggregator)theEObject;
                T result = caseOPMStructuralLinkAggregator(opmStructuralLinkAggregator);
                if (result == null) result = caseNode(opmStructuralLinkAggregator);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.OPM_AGGREGATION_LINK_AGGREGATOR: {
                OPMAggregationLinkAggregator opmAggregationLinkAggregator = (OPMAggregationLinkAggregator)theEObject;
                T result = caseOPMAggregationLinkAggregator(opmAggregationLinkAggregator);
                if (result == null) result = caseOPMStructuralLinkAggregator(opmAggregationLinkAggregator);
                if (result == null) result = caseNode(opmAggregationLinkAggregator);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.OPM_EXHIBITION_LINK_AGGREGATOR: {
                OPMExhibitionLinkAggregator opmExhibitionLinkAggregator = (OPMExhibitionLinkAggregator)theEObject;
                T result = caseOPMExhibitionLinkAggregator(opmExhibitionLinkAggregator);
                if (result == null) result = caseOPMStructuralLinkAggregator(opmExhibitionLinkAggregator);
                if (result == null) result = caseNode(opmExhibitionLinkAggregator);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.OPM_GENERALIZATION_LINK_AGGREGATOR: {
                OPMGeneralizationLinkAggregator opmGeneralizationLinkAggregator = (OPMGeneralizationLinkAggregator)theEObject;
                T result = caseOPMGeneralizationLinkAggregator(opmGeneralizationLinkAggregator);
                if (result == null) result = caseOPMStructuralLinkAggregator(opmGeneralizationLinkAggregator);
                if (result == null) result = caseNode(opmGeneralizationLinkAggregator);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.LINK: {
                Link link = (Link)theEObject;
                T result = caseLink(link);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.OPM_PROCEDURAL_LINK: {
                OPMProceduralLink opmProceduralLink = (OPMProceduralLink)theEObject;
                T result = caseOPMProceduralLink(opmProceduralLink);
                if (result == null) result = caseLink(opmProceduralLink);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.OPM_AGENT_LINK: {
                OPMAgentLink opmAgentLink = (OPMAgentLink)theEObject;
                T result = caseOPMAgentLink(opmAgentLink);
                if (result == null) result = caseOPMProceduralLink(opmAgentLink);
                if (result == null) result = caseLink(opmAgentLink);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.OPM_INSTRUMENT_LINK: {
                OPMInstrumentLink opmInstrumentLink = (OPMInstrumentLink)theEObject;
                T result = caseOPMInstrumentLink(opmInstrumentLink);
                if (result == null) result = caseOPMProceduralLink(opmInstrumentLink);
                if (result == null) result = caseLink(opmInstrumentLink);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.OPM_CONSUMPTION_LINK: {
                OPMConsumptionLink opmConsumptionLink = (OPMConsumptionLink)theEObject;
                T result = caseOPMConsumptionLink(opmConsumptionLink);
                if (result == null) result = caseOPMProceduralLink(opmConsumptionLink);
                if (result == null) result = caseLink(opmConsumptionLink);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.OPM_RESULT_LINK: {
                OPMResultLink opmResultLink = (OPMResultLink)theEObject;
                T result = caseOPMResultLink(opmResultLink);
                if (result == null) result = caseOPMProceduralLink(opmResultLink);
                if (result == null) result = caseLink(opmResultLink);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.OPM_EFFECT_LINK: {
                OPMEffectLink opmEffectLink = (OPMEffectLink)theEObject;
                T result = caseOPMEffectLink(opmEffectLink);
                if (result == null) result = caseOPMProceduralLink(opmEffectLink);
                if (result == null) result = caseLink(opmEffectLink);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case OPMPackage.OPM_STRUCTURAL_LINK: {
                OPMStructuralLink opmStructuralLink = (OPMStructuralLink)theEObject;
                T result = caseOPMStructuralLink(opmStructuralLink);
                if (result == null) result = caseLink(opmStructuralLink);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
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
	public T caseOPMObjectProcessDiagram(OPMObjectProcessDiagram object) {
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
	public T caseOPMObject(OPMObject object) {
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
	public T caseOPMProcess(OPMProcess object) {
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
	public T caseOPMThing(OPMThing object) {
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
	public T caseOPMProceduralLink(OPMProceduralLink object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Agent Link</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Agent Link</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOPMAgentLink(OPMAgentLink object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Instrument Link</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Instrument Link</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOPMInstrumentLink(OPMInstrumentLink object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Consumption Link</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Consumption Link</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOPMConsumptionLink(OPMConsumptionLink object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Result Link</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Result Link</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOPMResultLink(OPMResultLink object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Effect Link</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Effect Link</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOPMEffectLink(OPMEffectLink object) {
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
    public T caseOPMStructuralLink(OPMStructuralLink object) {
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
    public T caseNamedElement(NamedElement object) {
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
	public T caseOPMStructuralLinkAggregator(OPMStructuralLinkAggregator object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Aggregation Link Aggregator</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Aggregation Link Aggregator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOPMAggregationLinkAggregator(OPMAggregationLinkAggregator object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Exhibition Link Aggregator</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Exhibition Link Aggregator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOPMExhibitionLinkAggregator(OPMExhibitionLinkAggregator object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Generalization Link Aggregator</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Generalization Link Aggregator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOPMGeneralizationLinkAggregator(OPMGeneralizationLinkAggregator object) {
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
    public T caseOPMState(OPMState object) {
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
    public T caseNode(Node object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Node Container</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Node Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNodeContainer(NodeContainer object) {
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
    public T caseLink(Link object) {
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

} //OPMSwitch
