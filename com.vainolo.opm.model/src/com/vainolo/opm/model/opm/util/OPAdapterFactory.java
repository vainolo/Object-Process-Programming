/**
 */
package com.vainolo.opm.model.opm.util;

import com.vainolo.opm.model.opm.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.vainolo.opm.model.opm.OPPackage
 * @generated
 */
public class OPAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OPPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = OPPackage.eINSTANCE;
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
	protected OPSwitch<Adapter> modelSwitch =
		new OPSwitch<Adapter>() {
			@Override
			public Adapter caseOPElement(OPElement object) {
				return createOPElementAdapter();
			}
			@Override
			public Adapter caseOPSystem(OPSystem object) {
				return createOPSystemAdapter();
			}
			@Override
			public Adapter caseOPObjectProcessDiagram(OPObjectProcessDiagram object) {
				return createOPObjectProcessDiagramAdapter();
			}
			@Override
			public Adapter caseOPLink(OPLink object) {
				return createOPLinkAdapter();
			}
			@Override
			public Adapter caseOPNode(OPNode object) {
				return createOPNodeAdapter();
			}
			@Override
			public Adapter caseOPState(OPState object) {
				return createOPStateAdapter();
			}
			@Override
			public Adapter caseOPThing(OPThing object) {
				return createOPThingAdapter();
			}
			@Override
			public Adapter caseOPObject(OPObject object) {
				return createOPObjectAdapter();
			}
			@Override
			public Adapter caseOPProcess(OPProcess object) {
				return createOPProcessAdapter();
			}
			@Override
			public Adapter caseOPProceduralLink(OPProceduralLink object) {
				return createOPProceduralLinkAdapter();
			}
			@Override
			public Adapter caseOPStructuralLink(OPStructuralLink object) {
				return createOPStructuralLinkAdapter();
			}
			@Override
			public Adapter caseOPTaggedLink(OPTaggedLink object) {
				return createOPTaggedLinkAdapter();
			}
			@Override
			public Adapter caseOPElementView(OPElementView object) {
				return createOPElementViewAdapter();
			}
			@Override
			public Adapter caseOPNodeView(OPNodeView object) {
				return createOPNodeViewAdapter();
			}
			@Override
			public Adapter caseOPLinkView(OPLinkView object) {
				return createOPLinkViewAdapter();
			}
			@Override
			public Adapter caseOPThingView(OPThingView object) {
				return createOPThingViewAdapter();
			}
			@Override
			public Adapter caseOPStateView(OPStateView object) {
				return createOPStateViewAdapter();
			}
			@Override
			public Adapter caseOPStructuralLinkAggregatorView(OPStructuralLinkAggregatorView object) {
				return createOPStructuralLinkAggregatorViewAdapter();
			}
			@Override
			public Adapter caseOPObjectView(OPObjectView object) {
				return createOPObjectViewAdapter();
			}
			@Override
			public Adapter caseOPProcessView(OPProcessView object) {
				return createOPProcessViewAdapter();
			}
			@Override
			public Adapter caseOPProceduralLinkView(OPProceduralLinkView object) {
				return createOPProceduralLinkViewAdapter();
			}
			@Override
			public Adapter caseOPStructuralLinkPartView(OPStructuralLinkPartView object) {
				return createOPStructuralLinkPartViewAdapter();
			}
			@Override
			public Adapter caseOPTaggedLinkView(OPTaggedLinkView object) {
				return createOPTaggedLinkViewAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPElement
	 * @generated
	 */
	public Adapter createOPElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPLink
	 * @generated
	 */
	public Adapter createOPLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPObject
	 * @generated
	 */
	public Adapter createOPObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPProcess
	 * @generated
	 */
	public Adapter createOPProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPProceduralLink <em>Procedural Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPProceduralLink
	 * @generated
	 */
	public Adapter createOPProceduralLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPStructuralLink <em>Structural Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPStructuralLink
	 * @generated
	 */
	public Adapter createOPStructuralLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPTaggedLink <em>Tagged Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPTaggedLink
	 * @generated
	 */
	public Adapter createOPTaggedLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPNode
	 * @generated
	 */
	public Adapter createOPNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPState
	 * @generated
	 */
	public Adapter createOPStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPThing <em>Thing</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPThing
	 * @generated
	 */
	public Adapter createOPThingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPObjectProcessDiagram <em>Object Process Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPObjectProcessDiagram
	 * @generated
	 */
	public Adapter createOPObjectProcessDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPSystem
	 * @generated
	 */
	public Adapter createOPSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPObjectView <em>Object View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPObjectView
	 * @generated
	 */
	public Adapter createOPObjectViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPProcessView <em>Process View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPProcessView
	 * @generated
	 */
	public Adapter createOPProcessViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPThingView <em>Thing View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPThingView
	 * @generated
	 */
	public Adapter createOPThingViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPStateView <em>State View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPStateView
	 * @generated
	 */
	public Adapter createOPStateViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPNodeView <em>Node View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPNodeView
	 * @generated
	 */
	public Adapter createOPNodeViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPElementView <em>Element View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPElementView
	 * @generated
	 */
	public Adapter createOPElementViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPLinkView <em>Link View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPLinkView
	 * @generated
	 */
	public Adapter createOPLinkViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPProceduralLinkView <em>Procedural Link View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPProceduralLinkView
	 * @generated
	 */
	public Adapter createOPProceduralLinkViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPStructuralLinkPartView <em>Structural Link Part View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPStructuralLinkPartView
	 * @generated
	 */
	public Adapter createOPStructuralLinkPartViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPTaggedLinkView <em>Tagged Link View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPTaggedLinkView
	 * @generated
	 */
	public Adapter createOPTaggedLinkViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vainolo.opm.model.opm.OPStructuralLinkAggregatorView <em>Structural Link Aggregator View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vainolo.opm.model.opm.OPStructuralLinkAggregatorView
	 * @generated
	 */
	public Adapter createOPStructuralLinkAggregatorViewAdapter() {
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

} //OPAdapterFactory
