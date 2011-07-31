/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model.util;

import com.vainolo.phd.opm.model.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.vainolo.phd.opm.model.OPMPackage
 * @generated
 */
public class OPMAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static OPMPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OPMAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = OPMPackage.eINSTANCE;
        }
    }

	/**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
	@Override
	public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

	/**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected OPMSwitch<Adapter> modelSwitch =
		new OPMSwitch<Adapter>() {
            @Override
            public Adapter caseNamedElement(NamedElement object) {
                return createNamedElementAdapter();
            }
            @Override
            public Adapter caseNode(Node object) {
                return createNodeAdapter();
            }
            @Override
            public Adapter caseNodeContainer(NodeContainer object) {
                return createNodeContainerAdapter();
            }
            @Override
            public Adapter caseOPMObjectProcessDiagram(OPMObjectProcessDiagram object) {
                return createOPMObjectProcessDiagramAdapter();
            }
            @Override
            public Adapter caseOPMState(OPMState object) {
                return createOPMStateAdapter();
            }
            @Override
            public Adapter caseOPMThing(OPMThing object) {
                return createOPMThingAdapter();
            }
            @Override
            public Adapter caseOPMObject(OPMObject object) {
                return createOPMObjectAdapter();
            }
            @Override
            public Adapter caseOPMProcess(OPMProcess object) {
                return createOPMProcessAdapter();
            }
            @Override
            public Adapter caseOPMStructuralLinkAggregator(OPMStructuralLinkAggregator object) {
                return createOPMStructuralLinkAggregatorAdapter();
            }
            @Override
            public Adapter caseOPMAggregationLinkAggregator(OPMAggregationLinkAggregator object) {
                return createOPMAggregationLinkAggregatorAdapter();
            }
            @Override
            public Adapter caseOPMExhibitionLinkAggregator(OPMExhibitionLinkAggregator object) {
                return createOPMExhibitionLinkAggregatorAdapter();
            }
            @Override
            public Adapter caseOPMGeneralizationLinkAggregator(OPMGeneralizationLinkAggregator object) {
                return createOPMGeneralizationLinkAggregatorAdapter();
            }
            @Override
            public Adapter caseLink(Link object) {
                return createLinkAdapter();
            }
            @Override
            public Adapter caseOPMProceduralLink(OPMProceduralLink object) {
                return createOPMProceduralLinkAdapter();
            }
            @Override
            public Adapter caseOPMAgentLink(OPMAgentLink object) {
                return createOPMAgentLinkAdapter();
            }
            @Override
            public Adapter caseOPMInstrumentLink(OPMInstrumentLink object) {
                return createOPMInstrumentLinkAdapter();
            }
            @Override
            public Adapter caseOPMConsumptionLink(OPMConsumptionLink object) {
                return createOPMConsumptionLinkAdapter();
            }
            @Override
            public Adapter caseOPMResultLink(OPMResultLink object) {
                return createOPMResultLinkAdapter();
            }
            @Override
            public Adapter caseOPMEffectLink(OPMEffectLink object) {
                return createOPMEffectLinkAdapter();
            }
            @Override
            public Adapter caseOPMStructuralLink(OPMStructuralLink object) {
                return createOPMStructuralLinkAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

	/**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
	@Override
	public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


	/**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagram <em>Object Process Diagram</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.OPMObjectProcessDiagram
     * @generated
     */
	public Adapter createOPMObjectProcessDiagramAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.OPMObject <em>Object</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.OPMObject
     * @generated
     */
	public Adapter createOPMObjectAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.OPMProcess <em>Process</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.OPMProcess
     * @generated
     */
	public Adapter createOPMProcessAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.OPMThing <em>Thing</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.OPMThing
     * @generated
     */
	public Adapter createOPMThingAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.OPMProceduralLink <em>Procedural Link</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.OPMProceduralLink
     * @generated
     */
	public Adapter createOPMProceduralLinkAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.OPMAgentLink <em>Agent Link</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.OPMAgentLink
     * @generated
     */
    public Adapter createOPMAgentLinkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.OPMInstrumentLink <em>Instrument Link</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.OPMInstrumentLink
     * @generated
     */
    public Adapter createOPMInstrumentLinkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.OPMConsumptionLink <em>Consumption Link</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.OPMConsumptionLink
     * @generated
     */
    public Adapter createOPMConsumptionLinkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.OPMResultLink <em>Result Link</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.OPMResultLink
     * @generated
     */
    public Adapter createOPMResultLinkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.OPMEffectLink <em>Effect Link</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.OPMEffectLink
     * @generated
     */
    public Adapter createOPMEffectLinkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.OPMStructuralLink <em>Structural Link</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.OPMStructuralLink
     * @generated
     */
    public Adapter createOPMStructuralLinkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.NamedElement
     * @generated
     */
    public Adapter createNamedElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.OPMStructuralLinkAggregator <em>Structural Link Aggregator</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.OPMStructuralLinkAggregator
     * @generated
     */
	public Adapter createOPMStructuralLinkAggregatorAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.OPMAggregationLinkAggregator <em>Aggregation Link Aggregator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.OPMAggregationLinkAggregator
     * @generated
     */
    public Adapter createOPMAggregationLinkAggregatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.OPMExhibitionLinkAggregator <em>Exhibition Link Aggregator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.OPMExhibitionLinkAggregator
     * @generated
     */
    public Adapter createOPMExhibitionLinkAggregatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.OPMGeneralizationLinkAggregator <em>Generalization Link Aggregator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.OPMGeneralizationLinkAggregator
     * @generated
     */
    public Adapter createOPMGeneralizationLinkAggregatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.OPMState <em>State</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.OPMState
     * @generated
     */
    public Adapter createOPMStateAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.Node <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.Node
     * @generated
     */
    public Adapter createNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.NodeContainer <em>Node Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.NodeContainer
     * @generated
     */
    public Adapter createNodeContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.vainolo.phd.opm.model.Link <em>Link</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.vainolo.phd.opm.model.Link
     * @generated
     */
    public Adapter createLinkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
	public Adapter createEObjectAdapter() {
        return null;
    }

} //OPMAdapterFactory
