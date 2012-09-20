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
import org.eclipse.emf.ecore.EEnum;
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
   * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMContainerImpl <em>Container</em>}' class.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see com.vainolo.phd.opm.model.impl.OPMContainerImpl
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMContainer()
   * @generated
   */
    int OPM_CONTAINER = 2;

    /**
   * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMElementWithIDImpl <em>Element With ID</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opm.model.impl.OPMElementWithIDImpl
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMElementWithID()
   * @generated
   */
  int OPM_ELEMENT_WITH_ID = 0;

    /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_ELEMENT_WITH_ID__ID = 0;

    /**
   * The number of structural features of the '<em>Element With ID</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_ELEMENT_WITH_ID_FEATURE_COUNT = 1;

    /**
   * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMObjectProcessDiagramImpl <em>Object Process Diagram</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see com.vainolo.phd.opm.model.impl.OPMObjectProcessDiagramImpl
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMObjectProcessDiagram()
   * @generated
   */
	int OPM_OBJECT_PROCESS_DIAGRAM = 4;

	/**
   * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMNodeImpl <em>Node</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see com.vainolo.phd.opm.model.impl.OPMNodeImpl
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMNode()
   * @generated
   */
	int OPM_NODE = 3;

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
   * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMStateImpl <em>State</em>}' class.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see com.vainolo.phd.opm.model.impl.OPMStateImpl
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMState()
   * @generated
   */
    int OPM_STATE = 6;

    /**
   * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMObjectImpl <em>Object</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see com.vainolo.phd.opm.model.impl.OPMObjectImpl
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMObject()
   * @generated
   */
	int OPM_OBJECT = 7;

	/**
   * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMProcessImpl <em>Process</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see com.vainolo.phd.opm.model.impl.OPMProcessImpl
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMProcess()
   * @generated
   */
	int OPM_PROCESS = 8;

	/**
   * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMLinkImpl <em>Link</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see com.vainolo.phd.opm.model.impl.OPMLinkImpl
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMLink()
   * @generated
   */
	int OPM_LINK = 10;

	/**
   * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMStructuralLinkAggregatorImpl <em>Structural Link Aggregator</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see com.vainolo.phd.opm.model.impl.OPMStructuralLinkAggregatorImpl
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMStructuralLinkAggregator()
   * @generated
   */
	int OPM_STRUCTURAL_LINK_AGGREGATOR = 9;

	/**
   * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMProceduralLinkImpl <em>Procedural Link</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see com.vainolo.phd.opm.model.impl.OPMProceduralLinkImpl
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMProceduralLink()
   * @generated
   */
	int OPM_PROCEDURAL_LINK = 11;

	/**
   * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.OPMNamedElementImpl <em>Named Element</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see com.vainolo.phd.opm.model.impl.OPMNamedElementImpl
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMNamedElement()
   * @generated
   */
	int OPM_NAMED_ELEMENT = 1;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPM_NAMED_ELEMENT__NAME = 0;

	/**
   * The feature id for the '<em><b>Alignment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_NAMED_ELEMENT__ALIGNMENT = 1;

  /**
   * The number of structural features of the '<em>Named Element</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPM_NAMED_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_CONTAINER__ID = OPM_ELEMENT_WITH_ID__ID;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_CONTAINER__NODES = OPM_ELEMENT_WITH_ID_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_CONTAINER_FEATURE_COUNT = OPM_ELEMENT_WITH_ID_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_NODE__ID = OPM_ELEMENT_WITH_ID__ID;

  /**
   * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPM_NODE__INCOMING_LINKS = OPM_ELEMENT_WITH_ID_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPM_NODE__OUTGOING_LINKS = OPM_ELEMENT_WITH_ID_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int OPM_NODE__CONTAINER = OPM_ELEMENT_WITH_ID_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_NODE__CONSTRAINTS = OPM_ELEMENT_WITH_ID_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Node</em>' class.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_NODE_FEATURE_COUNT = OPM_ELEMENT_WITH_ID_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_OBJECT_PROCESS_DIAGRAM__ID = OPM_CONTAINER__ID;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int OPM_OBJECT_PROCESS_DIAGRAM__NODES = OPM_CONTAINER__NODES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_OBJECT_PROCESS_DIAGRAM__NAME = OPM_CONTAINER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Alignment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_OBJECT_PROCESS_DIAGRAM__ALIGNMENT = OPM_CONTAINER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Links</b></em>' containment reference list.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_OBJECT_PROCESS_DIAGRAM__LINKS = OPM_CONTAINER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Next Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_OBJECT_PROCESS_DIAGRAM__NEXT_ID = OPM_CONTAINER_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_OBJECT_PROCESS_DIAGRAM__KIND = OPM_CONTAINER_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Object Process Diagram</em>' class.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_OBJECT_PROCESS_DIAGRAM_FEATURE_COUNT = OPM_CONTAINER_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_THING__ID = OPM_NODE__ID;

  /**
   * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPM_THING__INCOMING_LINKS = OPM_NODE__INCOMING_LINKS;

  /**
   * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPM_THING__OUTGOING_LINKS = OPM_NODE__OUTGOING_LINKS;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int OPM_THING__CONTAINER = OPM_NODE__CONTAINER;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' attribute.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_THING__CONSTRAINTS = OPM_NODE__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_THING__NODES = OPM_NODE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_THING__NAME = OPM_NODE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Alignment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_THING__ALIGNMENT = OPM_NODE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int OPM_THING__DESCRIPTION = OPM_NODE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Thing</em>' class.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_THING_FEATURE_COUNT = OPM_NODE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_STATE__ID = OPM_NODE__ID;

  /**
   * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_STATE__INCOMING_LINKS = OPM_NODE__INCOMING_LINKS;

  /**
   * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_STATE__OUTGOING_LINKS = OPM_NODE__OUTGOING_LINKS;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_STATE__CONTAINER = OPM_NODE__CONTAINER;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_STATE__CONSTRAINTS = OPM_NODE__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_STATE__NAME = OPM_NODE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Alignment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_STATE__ALIGNMENT = OPM_NODE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_STATE_FEATURE_COUNT = OPM_NODE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_OBJECT__ID = OPM_THING__ID;

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
   * The feature id for the '<em><b>Container</b></em>' container reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int OPM_OBJECT__CONTAINER = OPM_THING__CONTAINER;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' attribute.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_OBJECT__CONSTRAINTS = OPM_THING__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_OBJECT__NODES = OPM_THING__NODES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_OBJECT__NAME = OPM_THING__NAME;

  /**
   * The feature id for the '<em><b>Alignment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_OBJECT__ALIGNMENT = OPM_THING__ALIGNMENT;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int OPM_OBJECT__DESCRIPTION = OPM_THING__DESCRIPTION;

  /**
   * The number of structural features of the '<em>Object</em>' class.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_OBJECT_FEATURE_COUNT = OPM_THING_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_PROCESS__ID = OPM_THING__ID;

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
   * The feature id for the '<em><b>Container</b></em>' container reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int OPM_PROCESS__CONTAINER = OPM_THING__CONTAINER;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' attribute.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_PROCESS__CONSTRAINTS = OPM_THING__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_PROCESS__NODES = OPM_THING__NODES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_PROCESS__NAME = OPM_THING__NAME;

  /**
   * The feature id for the '<em><b>Alignment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_PROCESS__ALIGNMENT = OPM_THING__ALIGNMENT;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int OPM_PROCESS__DESCRIPTION = OPM_THING__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_PROCESS__KIND = OPM_THING_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Process</em>' class.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_PROCESS_FEATURE_COUNT = OPM_THING_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_STRUCTURAL_LINK_AGGREGATOR__ID = OPM_NODE__ID;

  /**
   * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPM_STRUCTURAL_LINK_AGGREGATOR__INCOMING_LINKS = OPM_NODE__INCOMING_LINKS;

  /**
   * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPM_STRUCTURAL_LINK_AGGREGATOR__OUTGOING_LINKS = OPM_NODE__OUTGOING_LINKS;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int OPM_STRUCTURAL_LINK_AGGREGATOR__CONTAINER = OPM_NODE__CONTAINER;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_STRUCTURAL_LINK_AGGREGATOR__CONSTRAINTS = OPM_NODE__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_STRUCTURAL_LINK_AGGREGATOR__KIND = OPM_NODE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Structural Link Aggregator</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPM_STRUCTURAL_LINK_AGGREGATOR_FEATURE_COUNT = OPM_NODE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_LINK__ID = OPM_NODE__ID;

  /**
   * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_LINK__INCOMING_LINKS = OPM_NODE__INCOMING_LINKS;

  /**
   * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_LINK__OUTGOING_LINKS = OPM_NODE__OUTGOING_LINKS;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_LINK__CONTAINER = OPM_NODE__CONTAINER;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_LINK__CONSTRAINTS = OPM_NODE__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Opd</b></em>' container reference.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_LINK__OPD = OPM_NODE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_LINK__SOURCE = OPM_NODE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_LINK__TARGET = OPM_NODE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Bendpoints</b></em>' attribute list.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_LINK__BENDPOINTS = OPM_NODE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Router Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_LINK__ROUTER_KIND = OPM_NODE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Source Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_LINK__SOURCE_DECORATION = OPM_NODE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Target Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_LINK__TARGET_DECORATION = OPM_NODE_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Center Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_LINK__CENTER_DECORATION = OPM_NODE_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>Link</em>' class.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_LINK_FEATURE_COUNT = OPM_NODE_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_PROCEDURAL_LINK__ID = OPM_LINK__ID;

  /**
   * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_PROCEDURAL_LINK__INCOMING_LINKS = OPM_LINK__INCOMING_LINKS;

  /**
   * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_PROCEDURAL_LINK__OUTGOING_LINKS = OPM_LINK__OUTGOING_LINKS;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_PROCEDURAL_LINK__CONTAINER = OPM_LINK__CONTAINER;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPM_PROCEDURAL_LINK__CONSTRAINTS = OPM_LINK__CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Opd</b></em>' container reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPM_PROCEDURAL_LINK__OPD = OPM_LINK__OPD;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPM_PROCEDURAL_LINK__SOURCE = OPM_LINK__SOURCE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPM_PROCEDURAL_LINK__TARGET = OPM_LINK__TARGET;

  /**
   * The feature id for the '<em><b>Bendpoints</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPM_PROCEDURAL_LINK__BENDPOINTS = OPM_LINK__BENDPOINTS;

  /**
   * The feature id for the '<em><b>Router Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    int OPM_PROCEDURAL_LINK__ROUTER_KIND = OPM_LINK__ROUTER_KIND;

  /**
   * The feature id for the '<em><b>Source Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_PROCEDURAL_LINK__SOURCE_DECORATION = OPM_LINK__SOURCE_DECORATION;

  /**
   * The feature id for the '<em><b>Target Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPM_PROCEDURAL_LINK__TARGET_DECORATION = OPM_LINK__TARGET_DECORATION;

  /**
   * The feature id for the '<em><b>Center Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPM_PROCEDURAL_LINK__CENTER_DECORATION = OPM_LINK__CENTER_DECORATION;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
int OPM_PROCEDURAL_LINK__KIND = OPM_LINK_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Procedural Link</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPM_PROCEDURAL_LINK_FEATURE_COUNT = OPM_LINK_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link com.vainolo.phd.opm.model.impl.LabelImpl <em>Label</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see com.vainolo.phd.opm.model.impl.LabelImpl
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getLabel()
   * @generated
   */
	int LABEL = 12;

	/**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABEL__ID = OPM_NODE__ID;

  /**
   * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LABEL__INCOMING_LINKS = OPM_NODE__INCOMING_LINKS;

	/**
   * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LABEL__OUTGOING_LINKS = OPM_NODE__OUTGOING_LINKS;

	/**
   * The feature id for the '<em><b>Container</b></em>' container reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LABEL__CONTAINER = OPM_NODE__CONTAINER;

	/**
   * The feature id for the '<em><b>Constraints</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LABEL__CONSTRAINTS = OPM_NODE__CONSTRAINTS;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LABEL__NAME = OPM_NODE_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Alignment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABEL__ALIGNMENT = OPM_NODE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Label</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LABEL_FEATURE_COUNT = OPM_NODE_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link com.vainolo.phd.opm.model.OPMStructuralLinkAggregatorKind <em>Structural Link Aggregator Kind</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see com.vainolo.phd.opm.model.OPMStructuralLinkAggregatorKind
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMStructuralLinkAggregatorKind()
   * @generated
   */
	int OPM_STRUCTURAL_LINK_AGGREGATOR_KIND = 13;

	/**
   * The meta object id for the '{@link com.vainolo.phd.opm.model.OPMProceduralLinkKind <em>Procedural Link Kind</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see com.vainolo.phd.opm.model.OPMProceduralLinkKind
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMProceduralLinkKind()
   * @generated
   */
	int OPM_PROCEDURAL_LINK_KIND = 14;

	/**
   * The meta object id for the '{@link com.vainolo.phd.opm.model.OPMLinkRouterKind <em>Link Router Kind</em>}' enum.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see com.vainolo.phd.opm.model.OPMLinkRouterKind
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMLinkRouterKind()
   * @generated
   */
    int OPM_LINK_ROUTER_KIND = 15;

    /**
   * The meta object id for the '{@link com.vainolo.phd.opm.model.OPMProcessKind <em>Process Kind</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see com.vainolo.phd.opm.model.OPMProcessKind
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMProcessKind()
   * @generated
   */
	int OPM_PROCESS_KIND = 16;

				/**
   * The meta object id for the '{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind <em>Object Process Diagram Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMObjectProcessDiagramKind()
   * @generated
   */
  int OPM_OBJECT_PROCESS_DIAGRAM_KIND = 17;

        /**
   * The meta object id for the '{@link com.vainolo.phd.opm.model.VerticalAlignment <em>Vertical Alignment</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opm.model.VerticalAlignment
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getVerticalAlignment()
   * @generated
   */
  int VERTICAL_ALIGNMENT = 18;

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
   * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMContainer <em>Container</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for class '<em>Container</em>'.
   * @see com.vainolo.phd.opm.model.OPMContainer
   * @generated
   */
    EClass getOPMContainer();

    /**
   * Returns the meta object for the containment reference list '{@link com.vainolo.phd.opm.model.OPMContainer#getNodes <em>Nodes</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nodes</em>'.
   * @see com.vainolo.phd.opm.model.OPMContainer#getNodes()
   * @see #getOPMContainer()
   * @generated
   */
    EReference getOPMContainer_Nodes();

    /**
   * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMElementWithID <em>Element With ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element With ID</em>'.
   * @see com.vainolo.phd.opm.model.OPMElementWithID
   * @generated
   */
  EClass getOPMElementWithID();

    /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opm.model.OPMElementWithID#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see com.vainolo.phd.opm.model.OPMElementWithID#getId()
   * @see #getOPMElementWithID()
   * @generated
   */
  EAttribute getOPMElementWithID_Id();

    /**
   * The meta object id for the '<em>Point</em>' data type.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.eclipse.draw2d.geometry.Point
   * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getPoint()
   * @generated
   */
	int POINT = 19;


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
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getNextId <em>Next Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Next Id</em>'.
   * @see com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getNextId()
   * @see #getOPMObjectProcessDiagram()
   * @generated
   */
  EAttribute getOPMObjectProcessDiagram_NextId();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see com.vainolo.phd.opm.model.OPMObjectProcessDiagram#getKind()
   * @see #getOPMObjectProcessDiagram()
   * @generated
   */
  EAttribute getOPMObjectProcessDiagram_Kind();

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
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opm.model.OPMProcess#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see com.vainolo.phd.opm.model.OPMProcess#getKind()
   * @see #getOPMProcess()
   * @generated
   */
	EAttribute getOPMProcess_Kind();

	/**
   * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMLink <em>Link</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Link</em>'.
   * @see com.vainolo.phd.opm.model.OPMLink
   * @generated
   */
	EClass getOPMLink();

	/**
   * Returns the meta object for the container reference '{@link com.vainolo.phd.opm.model.OPMLink#getOpd <em>Opd</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Opd</em>'.
   * @see com.vainolo.phd.opm.model.OPMLink#getOpd()
   * @see #getOPMLink()
   * @generated
   */
	EReference getOPMLink_Opd();

	/**
   * Returns the meta object for the reference '{@link com.vainolo.phd.opm.model.OPMLink#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see com.vainolo.phd.opm.model.OPMLink#getSource()
   * @see #getOPMLink()
   * @generated
   */
	EReference getOPMLink_Source();

	/**
   * Returns the meta object for the reference '{@link com.vainolo.phd.opm.model.OPMLink#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see com.vainolo.phd.opm.model.OPMLink#getTarget()
   * @see #getOPMLink()
   * @generated
   */
	EReference getOPMLink_Target();

	/**
   * Returns the meta object for the attribute list '{@link com.vainolo.phd.opm.model.OPMLink#getBendpoints <em>Bendpoints</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Bendpoints</em>'.
   * @see com.vainolo.phd.opm.model.OPMLink#getBendpoints()
   * @see #getOPMLink()
   * @generated
   */
	EAttribute getOPMLink_Bendpoints();

	/**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opm.model.OPMLink#getRouterKind <em>Router Kind</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Router Kind</em>'.
   * @see com.vainolo.phd.opm.model.OPMLink#getRouterKind()
   * @see #getOPMLink()
   * @generated
   */
    EAttribute getOPMLink_RouterKind();

    /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opm.model.OPMLink#getSourceDecoration <em>Source Decoration</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Source Decoration</em>'.
   * @see com.vainolo.phd.opm.model.OPMLink#getSourceDecoration()
   * @see #getOPMLink()
   * @generated
   */
	EAttribute getOPMLink_SourceDecoration();

	/**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opm.model.OPMLink#getTargetDecoration <em>Target Decoration</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Decoration</em>'.
   * @see com.vainolo.phd.opm.model.OPMLink#getTargetDecoration()
   * @see #getOPMLink()
   * @generated
   */
	EAttribute getOPMLink_TargetDecoration();

	/**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opm.model.OPMLink#getCenterDecoration <em>Center Decoration</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Center Decoration</em>'.
   * @see com.vainolo.phd.opm.model.OPMLink#getCenterDecoration()
   * @see #getOPMLink()
   * @generated
   */
	EAttribute getOPMLink_CenterDecoration();

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
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opm.model.OPMThing#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.vainolo.phd.opm.model.OPMThing#getDescription()
   * @see #getOPMThing()
   * @generated
   */
    EAttribute getOPMThing_Description();

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
   * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMNode <em>Node</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node</em>'.
   * @see com.vainolo.phd.opm.model.OPMNode
   * @generated
   */
	EClass getOPMNode();

	/**
   * Returns the meta object for the reference list '{@link com.vainolo.phd.opm.model.OPMNode#getIncomingLinks <em>Incoming Links</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Incoming Links</em>'.
   * @see com.vainolo.phd.opm.model.OPMNode#getIncomingLinks()
   * @see #getOPMNode()
   * @generated
   */
	EReference getOPMNode_IncomingLinks();

	/**
   * Returns the meta object for the reference list '{@link com.vainolo.phd.opm.model.OPMNode#getOutgoingLinks <em>Outgoing Links</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Outgoing Links</em>'.
   * @see com.vainolo.phd.opm.model.OPMNode#getOutgoingLinks()
   * @see #getOPMNode()
   * @generated
   */
	EReference getOPMNode_OutgoingLinks();

	/**
   * Returns the meta object for the container reference '{@link com.vainolo.phd.opm.model.OPMNode#getContainer <em>Container</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Container</em>'.
   * @see com.vainolo.phd.opm.model.OPMNode#getContainer()
   * @see #getOPMNode()
   * @generated
   */
    EReference getOPMNode_Container();

    /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opm.model.OPMNode#getConstraints <em>Constraints</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constraints</em>'.
   * @see com.vainolo.phd.opm.model.OPMNode#getConstraints()
   * @see #getOPMNode()
   * @generated
   */
    EAttribute getOPMNode_Constraints();

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
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opm.model.OPMStructuralLinkAggregator#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see com.vainolo.phd.opm.model.OPMStructuralLinkAggregator#getKind()
   * @see #getOPMStructuralLinkAggregator()
   * @generated
   */
	EAttribute getOPMStructuralLinkAggregator_Kind();

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
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opm.model.OPMProceduralLink#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see com.vainolo.phd.opm.model.OPMProceduralLink#getKind()
   * @see #getOPMProceduralLink()
   * @generated
   */
	EAttribute getOPMProceduralLink_Kind();

	/**
   * Returns the meta object for class '{@link com.vainolo.phd.opm.model.OPMNamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Element</em>'.
   * @see com.vainolo.phd.opm.model.OPMNamedElement
   * @generated
   */
	EClass getOPMNamedElement();

	/**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opm.model.OPMNamedElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.vainolo.phd.opm.model.OPMNamedElement#getName()
   * @see #getOPMNamedElement()
   * @generated
   */
	EAttribute getOPMNamedElement_Name();

	/**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opm.model.OPMNamedElement#getAlignment <em>Alignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Alignment</em>'.
   * @see com.vainolo.phd.opm.model.OPMNamedElement#getAlignment()
   * @see #getOPMNamedElement()
   * @generated
   */
  EAttribute getOPMNamedElement_Alignment();

  /**
   * Returns the meta object for class '{@link com.vainolo.phd.opm.model.Label <em>Label</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Label</em>'.
   * @see com.vainolo.phd.opm.model.Label
   * @generated
   */
	EClass getLabel();

	/**
   * Returns the meta object for enum '{@link com.vainolo.phd.opm.model.OPMStructuralLinkAggregatorKind <em>Structural Link Aggregator Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Structural Link Aggregator Kind</em>'.
   * @see com.vainolo.phd.opm.model.OPMStructuralLinkAggregatorKind
   * @generated
   */
	EEnum getOPMStructuralLinkAggregatorKind();

	/**
   * Returns the meta object for enum '{@link com.vainolo.phd.opm.model.OPMProceduralLinkKind <em>Procedural Link Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Procedural Link Kind</em>'.
   * @see com.vainolo.phd.opm.model.OPMProceduralLinkKind
   * @generated
   */
	EEnum getOPMProceduralLinkKind();

	/**
   * Returns the meta object for enum '{@link com.vainolo.phd.opm.model.OPMLinkRouterKind <em>Link Router Kind</em>}'.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Link Router Kind</em>'.
   * @see com.vainolo.phd.opm.model.OPMLinkRouterKind
   * @generated
   */
    EEnum getOPMLinkRouterKind();

    /**
   * Returns the meta object for enum '{@link com.vainolo.phd.opm.model.OPMProcessKind <em>Process Kind</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Process Kind</em>'.
   * @see com.vainolo.phd.opm.model.OPMProcessKind
   * @generated
   */
	EEnum getOPMProcessKind();

				/**
   * Returns the meta object for enum '{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind <em>Object Process Diagram Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Object Process Diagram Kind</em>'.
   * @see com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind
   * @generated
   */
  EEnum getOPMObjectProcessDiagramKind();

        /**
   * Returns the meta object for enum '{@link com.vainolo.phd.opm.model.VerticalAlignment <em>Vertical Alignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Vertical Alignment</em>'.
   * @see com.vainolo.phd.opm.model.VerticalAlignment
   * @generated
   */
  EEnum getVerticalAlignment();

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
     * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMContainerImpl <em>Container</em>}' class.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMContainerImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMContainer()
     * @generated
     */
        EClass OPM_CONTAINER = eINSTANCE.getOPMContainer();

        /**
     * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EReference OPM_CONTAINER__NODES = eINSTANCE.getOPMContainer_Nodes();

        /**
     * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMElementWithIDImpl <em>Element With ID</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMElementWithIDImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMElementWithID()
     * @generated
     */
    EClass OPM_ELEMENT_WITH_ID = eINSTANCE.getOPMElementWithID();

        /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPM_ELEMENT_WITH_ID__ID = eINSTANCE.getOPMElementWithID_Id();

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
     * The meta object literal for the '<em><b>Next Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPM_OBJECT_PROCESS_DIAGRAM__NEXT_ID = eINSTANCE.getOPMObjectProcessDiagram_NextId();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPM_OBJECT_PROCESS_DIAGRAM__KIND = eINSTANCE.getOPMObjectProcessDiagram_Kind();

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
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute OPM_PROCESS__KIND = eINSTANCE.getOPMProcess_Kind();

		/**
     * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMLinkImpl <em>Link</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMLinkImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMLink()
     * @generated
     */
		EClass OPM_LINK = eINSTANCE.getOPMLink();

		/**
     * The meta object literal for the '<em><b>Opd</b></em>' container reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference OPM_LINK__OPD = eINSTANCE.getOPMLink_Opd();

		/**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference OPM_LINK__SOURCE = eINSTANCE.getOPMLink_Source();

		/**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference OPM_LINK__TARGET = eINSTANCE.getOPMLink_Target();

		/**
     * The meta object literal for the '<em><b>Bendpoints</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute OPM_LINK__BENDPOINTS = eINSTANCE.getOPMLink_Bendpoints();

		/**
     * The meta object literal for the '<em><b>Router Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EAttribute OPM_LINK__ROUTER_KIND = eINSTANCE.getOPMLink_RouterKind();

        /**
     * The meta object literal for the '<em><b>Source Decoration</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute OPM_LINK__SOURCE_DECORATION = eINSTANCE.getOPMLink_SourceDecoration();

		/**
     * The meta object literal for the '<em><b>Target Decoration</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute OPM_LINK__TARGET_DECORATION = eINSTANCE.getOPMLink_TargetDecoration();

		/**
     * The meta object literal for the '<em><b>Center Decoration</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute OPM_LINK__CENTER_DECORATION = eINSTANCE.getOPMLink_CenterDecoration();

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
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EAttribute OPM_THING__DESCRIPTION = eINSTANCE.getOPMThing_Description();

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
     * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMNodeImpl <em>Node</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMNodeImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMNode()
     * @generated
     */
		EClass OPM_NODE = eINSTANCE.getOPMNode();

		/**
     * The meta object literal for the '<em><b>Incoming Links</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference OPM_NODE__INCOMING_LINKS = eINSTANCE.getOPMNode_IncomingLinks();

		/**
     * The meta object literal for the '<em><b>Outgoing Links</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference OPM_NODE__OUTGOING_LINKS = eINSTANCE.getOPMNode_OutgoingLinks();

		/**
     * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EReference OPM_NODE__CONTAINER = eINSTANCE.getOPMNode_Container();

        /**
     * The meta object literal for the '<em><b>Constraints</b></em>' attribute feature.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        EAttribute OPM_NODE__CONSTRAINTS = eINSTANCE.getOPMNode_Constraints();

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
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute OPM_STRUCTURAL_LINK_AGGREGATOR__KIND = eINSTANCE.getOPMStructuralLinkAggregator_Kind();

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
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute OPM_PROCEDURAL_LINK__KIND = eINSTANCE.getOPMProceduralLink_Kind();

		/**
     * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.OPMNamedElementImpl <em>Named Element</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.OPMNamedElementImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMNamedElement()
     * @generated
     */
		EClass OPM_NAMED_ELEMENT = eINSTANCE.getOPMNamedElement();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute OPM_NAMED_ELEMENT__NAME = eINSTANCE.getOPMNamedElement_Name();

		/**
     * The meta object literal for the '<em><b>Alignment</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPM_NAMED_ELEMENT__ALIGNMENT = eINSTANCE.getOPMNamedElement_Alignment();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opm.model.impl.LabelImpl <em>Label</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.impl.LabelImpl
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getLabel()
     * @generated
     */
		EClass LABEL = eINSTANCE.getLabel();

		/**
     * The meta object literal for the '{@link com.vainolo.phd.opm.model.OPMStructuralLinkAggregatorKind <em>Structural Link Aggregator Kind</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.OPMStructuralLinkAggregatorKind
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMStructuralLinkAggregatorKind()
     * @generated
     */
		EEnum OPM_STRUCTURAL_LINK_AGGREGATOR_KIND = eINSTANCE.getOPMStructuralLinkAggregatorKind();

		/**
     * The meta object literal for the '{@link com.vainolo.phd.opm.model.OPMProceduralLinkKind <em>Procedural Link Kind</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.OPMProceduralLinkKind
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMProceduralLinkKind()
     * @generated
     */
		EEnum OPM_PROCEDURAL_LINK_KIND = eINSTANCE.getOPMProceduralLinkKind();

		/**
     * The meta object literal for the '{@link com.vainolo.phd.opm.model.OPMLinkRouterKind <em>Link Router Kind</em>}' enum.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.OPMLinkRouterKind
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMLinkRouterKind()
     * @generated
     */
        EEnum OPM_LINK_ROUTER_KIND = eINSTANCE.getOPMLinkRouterKind();

        /**
     * The meta object literal for the '{@link com.vainolo.phd.opm.model.OPMProcessKind <em>Process Kind</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.OPMProcessKind
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMProcessKind()
     * @generated
     */
		EEnum OPM_PROCESS_KIND = eINSTANCE.getOPMProcessKind();

								/**
     * The meta object literal for the '{@link com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind <em>Object Process Diagram Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getOPMObjectProcessDiagramKind()
     * @generated
     */
    EEnum OPM_OBJECT_PROCESS_DIAGRAM_KIND = eINSTANCE.getOPMObjectProcessDiagramKind();

                /**
     * The meta object literal for the '{@link com.vainolo.phd.opm.model.VerticalAlignment <em>Vertical Alignment</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opm.model.VerticalAlignment
     * @see com.vainolo.phd.opm.model.impl.OPMPackageImpl#getVerticalAlignment()
     * @generated
     */
    EEnum VERTICAL_ALIGNMENT = eINSTANCE.getVerticalAlignment();

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
