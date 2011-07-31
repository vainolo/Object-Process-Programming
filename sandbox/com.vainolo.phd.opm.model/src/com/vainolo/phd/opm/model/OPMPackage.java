/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.vainolo.phd.opm.model.OPMFactory
 * @model kind="package"
 * @generated
 */
public interface OPMPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "opm";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "www.vainolo.com/phd/opm";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "opm";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	OPMPackage eINSTANCE = com.vainolo.phd.opm.model.impl.OPMPackageImpl.init();

	/**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMObjectProcessDiagramImpl <em>Object Process Diagram</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMObjectProcessDiagramImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMObjectProcessDiagram()
     * @generated
     */
	int OPM_OBJECT_PROCESS_DIAGRAM = 3;

	/**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMThingImpl <em>Thing</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMThingImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMThing()
     * @generated
     */
	int OPM_THING = 5;

	/**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMObjectImpl <em>Object</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMObjectImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMObject()
     * @generated
     */
	int OPM_OBJECT = 6;

	/**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMProcessImpl <em>Process</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMProcessImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMProcess()
     * @generated
     */
	int OPM_PROCESS = 7;

	/**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMProceduralLinkImpl <em>Procedural Link</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMProceduralLinkImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMProceduralLink()
     * @generated
     */
	int OPM_PROCEDURAL_LINK = 13;

	/**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMStructuralLinkAggregatorImpl <em>Structural Link Aggregator</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMStructuralLinkAggregatorImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMStructuralLinkAggregator()
     * @generated
     */
	int OPM_STRUCTURAL_LINK_AGGREGATOR = 8;

	/**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.NodeImpl <em>Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.NodeImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getNode()
     * @generated
     */
    int NODE = 1;

    /**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.NodeContainerImpl <em>Node Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.NodeContainerImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getNodeContainer()
     * @generated
     */
    int NODE_CONTAINER = 2;

    /**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.LinkImpl <em>Link</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.LinkImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getLink()
     * @generated
     */
    int LINK = 12;

    /**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMAggregationLinkAggregatorImpl <em>Aggregation Link Aggregator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMAggregationLinkAggregatorImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMAggregationLinkAggregator()
     * @generated
     */
    int OPM_AGGREGATION_LINK_AGGREGATOR = 9;

    /**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMExhibitionLinkAggregatorImpl <em>Exhibition Link Aggregator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMExhibitionLinkAggregatorImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMExhibitionLinkAggregator()
     * @generated
     */
    int OPM_EXHIBITION_LINK_AGGREGATOR = 10;

    /**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMGeneralizationLinkAggregatorImpl <em>Generalization Link Aggregator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMGeneralizationLinkAggregatorImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMGeneralizationLinkAggregator()
     * @generated
     */
    int OPM_GENERALIZATION_LINK_AGGREGATOR = 11;

    /**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMStateImpl <em>State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMStateImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMState()
     * @generated
     */
    int OPM_STATE = 4;

    /**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMAgentLinkImpl <em>Agent Link</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMAgentLinkImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMAgentLink()
     * @generated
     */
    int OPM_AGENT_LINK = 14;

    /**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMInstrumentLinkImpl <em>Instrument Link</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMInstrumentLinkImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMInstrumentLink()
     * @generated
     */
    int OPM_INSTRUMENT_LINK = 15;

    /**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMConsumptionLinkImpl <em>Consumption Link</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMConsumptionLinkImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMConsumptionLink()
     * @generated
     */
    int OPM_CONSUMPTION_LINK = 16;

    /**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMResultLinkImpl <em>Result Link</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMResultLinkImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMResultLink()
     * @generated
     */
    int OPM_RESULT_LINK = 17;

    /**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMEffectLinkImpl <em>Effect Link</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMEffectLinkImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMEffectLink()
     * @generated
     */
    int OPM_EFFECT_LINK = 18;

    /**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMStructuralLinkImpl <em>Structural Link</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMStructuralLinkImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMStructuralLink()
     * @generated
     */
    int OPM_STRUCTURAL_LINK = 19;

    /**
     * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.NamedElementImpl <em>Named Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.NamedElementImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getNamedElement()
     * @generated
     */
    int NAMED_ELEMENT = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_ELEMENT__NAME = 0;

    /**
     * The number of structural features of the '<em>Named Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_ELEMENT_FEATURE_COUNT = 1;

    /**
     * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE__INCOMING_LINKS = 0;

    /**
     * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE__OUTGOING_LINKS = 1;

    /**
     * The feature id for the '<em><b>Constraints</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE__CONSTRAINTS = 2;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE__PARENT = 3;

    /**
     * The number of structural features of the '<em>Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_FEATURE_COUNT = 4;

    /**
     * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_CONTAINER__NODES = 0;

    /**
     * The number of structural features of the '<em>Node Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_CONTAINER_FEATURE_COUNT = 1;

    /**
     * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_OBJECT_PROCESS_DIAGRAM__NODES = NODE_CONTAINER__NODES;

    /**
     * The feature id for the '<em><b>Links</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_OBJECT_PROCESS_DIAGRAM__LINKS = NODE_CONTAINER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Object Process Diagram</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPM_OBJECT_PROCESS_DIAGRAM_FEATURE_COUNT = NODE_CONTAINER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_STATE__INCOMING_LINKS = NODE__INCOMING_LINKS;

    /**
     * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_STATE__OUTGOING_LINKS = NODE__OUTGOING_LINKS;

    /**
     * The feature id for the '<em><b>Constraints</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_STATE__CONSTRAINTS = NODE__CONSTRAINTS;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_STATE__PARENT = NODE__PARENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_STATE__NAME = NODE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>State</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_STATE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_THING__INCOMING_LINKS = NODE__INCOMING_LINKS;

    /**
     * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_THING__OUTGOING_LINKS = NODE__OUTGOING_LINKS;

    /**
     * The feature id for the '<em><b>Constraints</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPM_THING__CONSTRAINTS = NODE__CONSTRAINTS;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_THING__PARENT = NODE__PARENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPM_THING__NAME = NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_THING__NODES = NODE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Thing</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPM_THING_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_OBJECT__INCOMING_LINKS = OPM_THING__INCOMING_LINKS;

    /**
     * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_OBJECT__OUTGOING_LINKS = OPM_THING__OUTGOING_LINKS;

    /**
     * The feature id for the '<em><b>Constraints</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPM_OBJECT__CONSTRAINTS = OPM_THING__CONSTRAINTS;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_OBJECT__PARENT = OPM_THING__PARENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPM_OBJECT__NAME = OPM_THING__NAME;

    /**
     * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_OBJECT__NODES = OPM_THING__NODES;

    /**
     * The number of structural features of the '<em>Object</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPM_OBJECT_FEATURE_COUNT = OPM_THING_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_PROCESS__INCOMING_LINKS = OPM_THING__INCOMING_LINKS;

    /**
     * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_PROCESS__OUTGOING_LINKS = OPM_THING__OUTGOING_LINKS;

    /**
     * The feature id for the '<em><b>Constraints</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPM_PROCESS__CONSTRAINTS = OPM_THING__CONSTRAINTS;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_PROCESS__PARENT = OPM_THING__PARENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPM_PROCESS__NAME = OPM_THING__NAME;

    /**
     * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_PROCESS__NODES = OPM_THING__NODES;

    /**
     * The number of structural features of the '<em>Process</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPM_PROCESS_FEATURE_COUNT = OPM_THING_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_STRUCTURAL_LINK_AGGREGATOR__INCOMING_LINKS = NODE__INCOMING_LINKS;

    /**
     * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPM_STRUCTURAL_LINK_AGGREGATOR__OUTGOING_LINKS = NODE__OUTGOING_LINKS;

    /**
     * The feature id for the '<em><b>Constraints</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_STRUCTURAL_LINK_AGGREGATOR__CONSTRAINTS = NODE__CONSTRAINTS;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_STRUCTURAL_LINK_AGGREGATOR__PARENT = NODE__PARENT;

    /**
     * The number of structural features of the '<em>Structural Link Aggregator</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPM_STRUCTURAL_LINK_AGGREGATOR_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_AGGREGATION_LINK_AGGREGATOR__INCOMING_LINKS = OPM_STRUCTURAL_LINK_AGGREGATOR__INCOMING_LINKS;

    /**
     * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_AGGREGATION_LINK_AGGREGATOR__OUTGOING_LINKS = OPM_STRUCTURAL_LINK_AGGREGATOR__OUTGOING_LINKS;

    /**
     * The feature id for the '<em><b>Constraints</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_AGGREGATION_LINK_AGGREGATOR__CONSTRAINTS = OPM_STRUCTURAL_LINK_AGGREGATOR__CONSTRAINTS;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_AGGREGATION_LINK_AGGREGATOR__PARENT = OPM_STRUCTURAL_LINK_AGGREGATOR__PARENT;

    /**
     * The number of structural features of the '<em>Aggregation Link Aggregator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_AGGREGATION_LINK_AGGREGATOR_FEATURE_COUNT = OPM_STRUCTURAL_LINK_AGGREGATOR_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_EXHIBITION_LINK_AGGREGATOR__INCOMING_LINKS = OPM_STRUCTURAL_LINK_AGGREGATOR__INCOMING_LINKS;

    /**
     * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_EXHIBITION_LINK_AGGREGATOR__OUTGOING_LINKS = OPM_STRUCTURAL_LINK_AGGREGATOR__OUTGOING_LINKS;

    /**
     * The feature id for the '<em><b>Constraints</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_EXHIBITION_LINK_AGGREGATOR__CONSTRAINTS = OPM_STRUCTURAL_LINK_AGGREGATOR__CONSTRAINTS;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_EXHIBITION_LINK_AGGREGATOR__PARENT = OPM_STRUCTURAL_LINK_AGGREGATOR__PARENT;

    /**
     * The number of structural features of the '<em>Exhibition Link Aggregator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_EXHIBITION_LINK_AGGREGATOR_FEATURE_COUNT = OPM_STRUCTURAL_LINK_AGGREGATOR_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_GENERALIZATION_LINK_AGGREGATOR__INCOMING_LINKS = OPM_STRUCTURAL_LINK_AGGREGATOR__INCOMING_LINKS;

    /**
     * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_GENERALIZATION_LINK_AGGREGATOR__OUTGOING_LINKS = OPM_STRUCTURAL_LINK_AGGREGATOR__OUTGOING_LINKS;

    /**
     * The feature id for the '<em><b>Constraints</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_GENERALIZATION_LINK_AGGREGATOR__CONSTRAINTS = OPM_STRUCTURAL_LINK_AGGREGATOR__CONSTRAINTS;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_GENERALIZATION_LINK_AGGREGATOR__PARENT = OPM_STRUCTURAL_LINK_AGGREGATOR__PARENT;

    /**
     * The number of structural features of the '<em>Generalization Link Aggregator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_GENERALIZATION_LINK_AGGREGATOR_FEATURE_COUNT = OPM_STRUCTURAL_LINK_AGGREGATOR_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK__SOURCE = 0;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK__TARGET = 1;

    /**
     * The feature id for the '<em><b>Opd</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK__OPD = 2;

    /**
     * The number of structural features of the '<em>Link</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINK_FEATURE_COUNT = 3;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPM_PROCEDURAL_LINK__SOURCE = LINK__SOURCE;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPM_PROCEDURAL_LINK__TARGET = LINK__TARGET;

    /**
     * The feature id for the '<em><b>Opd</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPM_PROCEDURAL_LINK__OPD = LINK__OPD;

    /**
     * The feature id for the '<em><b>Bendpoints</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPM_PROCEDURAL_LINK__BENDPOINTS = LINK_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Procedural Link</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPM_PROCEDURAL_LINK_FEATURE_COUNT = LINK_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_AGENT_LINK__SOURCE = OPM_PROCEDURAL_LINK__SOURCE;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_AGENT_LINK__TARGET = OPM_PROCEDURAL_LINK__TARGET;

    /**
     * The feature id for the '<em><b>Opd</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_AGENT_LINK__OPD = OPM_PROCEDURAL_LINK__OPD;

    /**
     * The feature id for the '<em><b>Bendpoints</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_AGENT_LINK__BENDPOINTS = OPM_PROCEDURAL_LINK__BENDPOINTS;

    /**
     * The number of structural features of the '<em>Agent Link</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_AGENT_LINK_FEATURE_COUNT = OPM_PROCEDURAL_LINK_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_INSTRUMENT_LINK__SOURCE = OPM_PROCEDURAL_LINK__SOURCE;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_INSTRUMENT_LINK__TARGET = OPM_PROCEDURAL_LINK__TARGET;

    /**
     * The feature id for the '<em><b>Opd</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_INSTRUMENT_LINK__OPD = OPM_PROCEDURAL_LINK__OPD;

    /**
     * The feature id for the '<em><b>Bendpoints</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_INSTRUMENT_LINK__BENDPOINTS = OPM_PROCEDURAL_LINK__BENDPOINTS;

    /**
     * The number of structural features of the '<em>Instrument Link</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_INSTRUMENT_LINK_FEATURE_COUNT = OPM_PROCEDURAL_LINK_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_CONSUMPTION_LINK__SOURCE = OPM_PROCEDURAL_LINK__SOURCE;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_CONSUMPTION_LINK__TARGET = OPM_PROCEDURAL_LINK__TARGET;

    /**
     * The feature id for the '<em><b>Opd</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_CONSUMPTION_LINK__OPD = OPM_PROCEDURAL_LINK__OPD;

    /**
     * The feature id for the '<em><b>Bendpoints</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_CONSUMPTION_LINK__BENDPOINTS = OPM_PROCEDURAL_LINK__BENDPOINTS;

    /**
     * The number of structural features of the '<em>Consumption Link</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_CONSUMPTION_LINK_FEATURE_COUNT = OPM_PROCEDURAL_LINK_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_RESULT_LINK__SOURCE = OPM_PROCEDURAL_LINK__SOURCE;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_RESULT_LINK__TARGET = OPM_PROCEDURAL_LINK__TARGET;

    /**
     * The feature id for the '<em><b>Opd</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_RESULT_LINK__OPD = OPM_PROCEDURAL_LINK__OPD;

    /**
     * The feature id for the '<em><b>Bendpoints</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_RESULT_LINK__BENDPOINTS = OPM_PROCEDURAL_LINK__BENDPOINTS;

    /**
     * The number of structural features of the '<em>Result Link</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_RESULT_LINK_FEATURE_COUNT = OPM_PROCEDURAL_LINK_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_EFFECT_LINK__SOURCE = OPM_PROCEDURAL_LINK__SOURCE;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_EFFECT_LINK__TARGET = OPM_PROCEDURAL_LINK__TARGET;

    /**
     * The feature id for the '<em><b>Opd</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_EFFECT_LINK__OPD = OPM_PROCEDURAL_LINK__OPD;

    /**
     * The feature id for the '<em><b>Bendpoints</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_EFFECT_LINK__BENDPOINTS = OPM_PROCEDURAL_LINK__BENDPOINTS;

    /**
     * The number of structural features of the '<em>Effect Link</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_EFFECT_LINK_FEATURE_COUNT = OPM_PROCEDURAL_LINK_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_STRUCTURAL_LINK__SOURCE = LINK__SOURCE;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_STRUCTURAL_LINK__TARGET = LINK__TARGET;

    /**
     * The feature id for the '<em><b>Opd</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_STRUCTURAL_LINK__OPD = LINK__OPD;

    /**
     * The number of structural features of the '<em>Structural Link</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPM_STRUCTURAL_LINK_FEATURE_COUNT = LINK_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '<em>Rectangle</em>' data type.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.draw2d.geometry.Rectangle
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getRectangle()
     * @generated
     */
	int RECTANGLE = 20;

	/**
     * The meta object id for the '<em>Point</em>' data type.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.draw2d.geometry.Point
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getPoint()
     * @generated
     */
	int POINT = 21;


	/**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagram <em>Object Process Diagram</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Object Process Diagram</em>'.
     * @see com.vainolo.phd.opm.model.OPMObjectProcessDiagram
     * @generated
     */
	EClass getOPMObjectProcessDiagram();

	/**
     * Returns the meta object for the containment reference list '{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getLinks <em>Links</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Links</em>'.
     * @see com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getLinks()
     * @see #getOPMObjectProcessDiagram()
     * @generated
     */
    EReference getOPMObjectProcessDiagram_Links();

    /**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMObject <em>Object</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Object</em>'.
     * @see com.vainolo.phd.opm.model.OPMObject
     * @generated
     */
	EClass getOPMObject();

	/**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMProcess <em>Process</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Process</em>'.
     * @see com.vainolo.phd.opm.model.OPMProcess
     * @generated
     */
	EClass getOPMProcess();

	/**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMThing <em>Thing</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Thing</em>'.
     * @see com.vainolo.phd.opm.model.OPMThing
     * @generated
     */
	EClass getOPMThing();

	/**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMProceduralLink <em>Procedural Link</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Procedural Link</em>'.
     * @see com.vainolo.phd.opm.model.OPMProceduralLink
     * @generated
     */
	EClass getOPMProceduralLink();

	/**
     * Returns the meta object for the attribute list '{@link com.vainolo.phd.opm.model.OPMProceduralLink#getBendpoints <em>Bendpoints</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Bendpoints</em>'.
     * @see com.vainolo.phd.opm.model.OPMProceduralLink#getBendpoints()
     * @see #getOPMProceduralLink()
     * @generated
     */
	EAttribute getOPMProceduralLink_Bendpoints();

	/**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMAgentLink <em>Agent Link</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Agent Link</em>'.
     * @see com.vainolo.phd.opm.model.OPMAgentLink
     * @generated
     */
    EClass getOPMAgentLink();

    /**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMInstrumentLink <em>Instrument Link</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Instrument Link</em>'.
     * @see com.vainolo.phd.opm.model.OPMInstrumentLink
     * @generated
     */
    EClass getOPMInstrumentLink();

    /**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMConsumptionLink <em>Consumption Link</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Consumption Link</em>'.
     * @see com.vainolo.phd.opm.model.OPMConsumptionLink
     * @generated
     */
    EClass getOPMConsumptionLink();

    /**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMResultLink <em>Result Link</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Result Link</em>'.
     * @see com.vainolo.phd.opm.model.OPMResultLink
     * @generated
     */
    EClass getOPMResultLink();

    /**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMEffectLink <em>Effect Link</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Effect Link</em>'.
     * @see com.vainolo.phd.opm.model.OPMEffectLink
     * @generated
     */
    EClass getOPMEffectLink();

    /**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMStructuralLink <em>Structural Link</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Structural Link</em>'.
     * @see com.vainolo.phd.opm.model.OPMStructuralLink
     * @generated
     */
    EClass getOPMStructuralLink();

    /**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Named Element</em>'.
     * @see com.vainolo.phd.opm.model.NamedElement
     * @generated
     */
    EClass getNamedElement();

    /**
     * Returns the meta object for the attribute '{@link com.vainolo.phd.opm.model.NamedElement#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.vainolo.phd.opm.model.NamedElement#getName()
     * @see #getNamedElement()
     * @generated
     */
    EAttribute getNamedElement_Name();

    /**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMStructuralLinkAggregator <em>Structural Link Aggregator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Structural Link Aggregator</em>'.
     * @see com.vainolo.phd.opm.model.OPMStructuralLinkAggregator
     * @generated
     */
	EClass getOPMStructuralLinkAggregator();

	/**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMAggregationLinkAggregator <em>Aggregation Link Aggregator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Aggregation Link Aggregator</em>'.
     * @see com.vainolo.phd.opm.model.OPMAggregationLinkAggregator
     * @generated
     */
    EClass getOPMAggregationLinkAggregator();

    /**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMExhibitionLinkAggregator <em>Exhibition Link Aggregator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Exhibition Link Aggregator</em>'.
     * @see com.vainolo.phd.opm.model.OPMExhibitionLinkAggregator
     * @generated
     */
    EClass getOPMExhibitionLinkAggregator();

    /**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMGeneralizationLinkAggregator <em>Generalization Link Aggregator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Generalization Link Aggregator</em>'.
     * @see com.vainolo.phd.opm.model.OPMGeneralizationLinkAggregator
     * @generated
     */
    EClass getOPMGeneralizationLinkAggregator();

    /**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMState <em>State</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>State</em>'.
     * @see com.vainolo.phd.opm.model.OPMState
     * @generated
     */
    EClass getOPMState();

    /**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.Node <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Node</em>'.
     * @see com.vainolo.phd.opm.model.Node
     * @generated
     */
    EClass getNode();

    /**
     * Returns the meta object for the reference list '{@link com.vainolo.phd.opm.model.Node#getIncomingLinks <em>Incoming Links</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Incoming Links</em>'.
     * @see com.vainolo.phd.opm.model.Node#getIncomingLinks()
     * @see #getNode()
     * @generated
     */
    EReference getNode_IncomingLinks();

    /**
     * Returns the meta object for the reference list '{@link com.vainolo.phd.opm.model.Node#getOutgoingLinks <em>Outgoing Links</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Outgoing Links</em>'.
     * @see com.vainolo.phd.opm.model.Node#getOutgoingLinks()
     * @see #getNode()
     * @generated
     */
    EReference getNode_OutgoingLinks();

    /**
     * Returns the meta object for the attribute '{@link com.vainolo.phd.opm.model.Node#getConstraints <em>Constraints</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Constraints</em>'.
     * @see com.vainolo.phd.opm.model.Node#getConstraints()
     * @see #getNode()
     * @generated
     */
    EAttribute getNode_Constraints();

    /**
     * Returns the meta object for the container reference '{@link com.vainolo.phd.opm.model.Node#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Parent</em>'.
     * @see com.vainolo.phd.opm.model.Node#getParent()
     * @see #getNode()
     * @generated
     */
    EReference getNode_Parent();

    /**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.NodeContainer <em>Node Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Node Container</em>'.
     * @see com.vainolo.phd.opm.model.NodeContainer
     * @generated
     */
    EClass getNodeContainer();

    /**
     * Returns the meta object for the containment reference list '{@link com.vainolo.phd.opm.model.NodeContainer#getNodes <em>Nodes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Nodes</em>'.
     * @see com.vainolo.phd.opm.model.NodeContainer#getNodes()
     * @see #getNodeContainer()
     * @generated
     */
    EReference getNodeContainer_Nodes();

    /**
     * Returns the meta object for class '{@link com.vainolo.phd.opm.model.Link <em>Link</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Link</em>'.
     * @see com.vainolo.phd.opm.model.Link
     * @generated
     */
    EClass getLink();

    /**
     * Returns the meta object for the reference '{@link com.vainolo.phd.opm.model.Link#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see com.vainolo.phd.opm.model.Link#getSource()
     * @see #getLink()
     * @generated
     */
    EReference getLink_Source();

    /**
     * Returns the meta object for the reference '{@link com.vainolo.phd.opm.model.Link#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see com.vainolo.phd.opm.model.Link#getTarget()
     * @see #getLink()
     * @generated
     */
    EReference getLink_Target();

    /**
     * Returns the meta object for the container reference '{@link com.vainolo.phd.opm.model.Link#getOpd <em>Opd</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Opd</em>'.
     * @see com.vainolo.phd.opm.model.Link#getOpd()
     * @see #getLink()
     * @generated
     */
    EReference getLink_Opd();

    /**
     * Returns the meta object for data type '{@link org.eclipse.draw2d.geometry.Rectangle <em>Rectangle</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Rectangle</em>'.
     * @see org.eclipse.draw2d.geometry.Rectangle
     * @model instanceClass="org.eclipse.draw2d.geometry.Rectangle"
     * @generated
     */
	EDataType getRectangle();

	/**
     * Returns the meta object for data type '{@link org.eclipse.draw2d.geometry.Point <em>Point</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Point</em>'.
     * @see org.eclipse.draw2d.geometry.Point
     * @model instanceClass="org.eclipse.draw2d.geometry.Point"
     * @generated
     */
	EDataType getPoint();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	OPMFactory getOPMFactory();

	/**
     * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
     * @generated
     */
	interface Literals {
		/**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMObjectProcessDiagramImpl <em>Object Process Diagram</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.OPMObjectProcessDiagramImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMObjectProcessDiagram()
         * @generated
         */
		EClass OPM_OBJECT_PROCESS_DIAGRAM = eINSTANCE.getOPMObjectProcessDiagram();

		/**
         * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OPM_OBJECT_PROCESS_DIAGRAM__LINKS = eINSTANCE.getOPMObjectProcessDiagram_Links();

        /**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMObjectImpl <em>Object</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.OPMObjectImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMObject()
         * @generated
         */
		EClass OPM_OBJECT = eINSTANCE.getOPMObject();

		/**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMProcessImpl <em>Process</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.OPMProcessImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMProcess()
         * @generated
         */
		EClass OPM_PROCESS = eINSTANCE.getOPMProcess();

		/**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMThingImpl <em>Thing</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.OPMThingImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMThing()
         * @generated
         */
		EClass OPM_THING = eINSTANCE.getOPMThing();

		/**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMProceduralLinkImpl <em>Procedural Link</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.OPMProceduralLinkImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMProceduralLink()
         * @generated
         */
		EClass OPM_PROCEDURAL_LINK = eINSTANCE.getOPMProceduralLink();

		/**
         * The meta object literal for the '<em><b>Bendpoints</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute OPM_PROCEDURAL_LINK__BENDPOINTS = eINSTANCE.getOPMProceduralLink_Bendpoints();

		/**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMAgentLinkImpl <em>Agent Link</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.OPMAgentLinkImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMAgentLink()
         * @generated
         */
        EClass OPM_AGENT_LINK = eINSTANCE.getOPMAgentLink();

        /**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMInstrumentLinkImpl <em>Instrument Link</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.OPMInstrumentLinkImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMInstrumentLink()
         * @generated
         */
        EClass OPM_INSTRUMENT_LINK = eINSTANCE.getOPMInstrumentLink();

        /**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMConsumptionLinkImpl <em>Consumption Link</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.OPMConsumptionLinkImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMConsumptionLink()
         * @generated
         */
        EClass OPM_CONSUMPTION_LINK = eINSTANCE.getOPMConsumptionLink();

        /**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMResultLinkImpl <em>Result Link</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.OPMResultLinkImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMResultLink()
         * @generated
         */
        EClass OPM_RESULT_LINK = eINSTANCE.getOPMResultLink();

        /**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMEffectLinkImpl <em>Effect Link</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.OPMEffectLinkImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMEffectLink()
         * @generated
         */
        EClass OPM_EFFECT_LINK = eINSTANCE.getOPMEffectLink();

        /**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMStructuralLinkImpl <em>Structural Link</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.OPMStructuralLinkImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMStructuralLink()
         * @generated
         */
        EClass OPM_STRUCTURAL_LINK = eINSTANCE.getOPMStructuralLink();

        /**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.NamedElementImpl <em>Named Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.NamedElementImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getNamedElement()
         * @generated
         */
        EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

        /**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMStructuralLinkAggregatorImpl <em>Structural Link Aggregator</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.OPMStructuralLinkAggregatorImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMStructuralLinkAggregator()
         * @generated
         */
		EClass OPM_STRUCTURAL_LINK_AGGREGATOR = eINSTANCE.getOPMStructuralLinkAggregator();

		/**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMAggregationLinkAggregatorImpl <em>Aggregation Link Aggregator</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.OPMAggregationLinkAggregatorImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMAggregationLinkAggregator()
         * @generated
         */
        EClass OPM_AGGREGATION_LINK_AGGREGATOR = eINSTANCE.getOPMAggregationLinkAggregator();

        /**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMExhibitionLinkAggregatorImpl <em>Exhibition Link Aggregator</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.OPMExhibitionLinkAggregatorImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMExhibitionLinkAggregator()
         * @generated
         */
        EClass OPM_EXHIBITION_LINK_AGGREGATOR = eINSTANCE.getOPMExhibitionLinkAggregator();

        /**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMGeneralizationLinkAggregatorImpl <em>Generalization Link Aggregator</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.OPMGeneralizationLinkAggregatorImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMGeneralizationLinkAggregator()
         * @generated
         */
        EClass OPM_GENERALIZATION_LINK_AGGREGATOR = eINSTANCE.getOPMGeneralizationLinkAggregator();

        /**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMStateImpl <em>State</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.OPMStateImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMState()
         * @generated
         */
        EClass OPM_STATE = eINSTANCE.getOPMState();

        /**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.NodeImpl <em>Node</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.NodeImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getNode()
         * @generated
         */
        EClass NODE = eINSTANCE.getNode();

        /**
         * The meta object literal for the '<em><b>Incoming Links</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NODE__INCOMING_LINKS = eINSTANCE.getNode_IncomingLinks();

        /**
         * The meta object literal for the '<em><b>Outgoing Links</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NODE__OUTGOING_LINKS = eINSTANCE.getNode_OutgoingLinks();

        /**
         * The meta object literal for the '<em><b>Constraints</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NODE__CONSTRAINTS = eINSTANCE.getNode_Constraints();

        /**
         * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NODE__PARENT = eINSTANCE.getNode_Parent();

        /**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.NodeContainerImpl <em>Node Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.NodeContainerImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getNodeContainer()
         * @generated
         */
        EClass NODE_CONTAINER = eINSTANCE.getNodeContainer();

        /**
         * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NODE_CONTAINER__NODES = eINSTANCE.getNodeContainer_Nodes();

        /**
         * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.LinkImpl <em>Link</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.vainolo.phd.opm.model.impl.LinkImpl
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getLink()
         * @generated
         */
        EClass LINK = eINSTANCE.getLink();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LINK__SOURCE = eINSTANCE.getLink_Source();

        /**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LINK__TARGET = eINSTANCE.getLink_Target();

        /**
         * The meta object literal for the '<em><b>Opd</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LINK__OPD = eINSTANCE.getLink_Opd();

        /**
         * The meta object literal for the '<em>Rectangle</em>' data type.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.draw2d.geometry.Rectangle
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getRectangle()
         * @generated
         */
		EDataType RECTANGLE = eINSTANCE.getRectangle();

		/**
         * The meta object literal for the '<em>Point</em>' data type.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.draw2d.geometry.Point
         * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getPoint()
         * @generated
         */
		EDataType POINT = eINSTANCE.getPoint();

	}

} //OPMPackage
