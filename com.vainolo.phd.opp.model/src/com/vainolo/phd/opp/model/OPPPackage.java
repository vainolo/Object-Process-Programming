/**
 */
package com.vainolo.phd.opp.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see com.vainolo.phd.opp.model.OPPFactory
 * @model kind="package"
 * @generated
 */
public interface OPPPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "opp";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "www.vainolo.com/phd/opp";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "opp";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  OPPPackage eINSTANCE = com.vainolo.phd.opp.model.impl.OPPPackageImpl.init();

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.impl.OPPElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.impl.OPPElementImpl
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPElement()
   * @generated
   */
  int OPP_ELEMENT = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_ELEMENT__ID = 0;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.impl.OPPNamedElementImpl <em>Named Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.impl.OPPNamedElementImpl
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPNamedElement()
   * @generated
   */
  int OPP_NAMED_ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_NAMED_ELEMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Alignment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_NAMED_ELEMENT__ALIGNMENT = 1;

  /**
   * The number of structural features of the '<em>Named Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_NAMED_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.impl.OPPContainerImpl <em>Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.impl.OPPContainerImpl
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPContainer()
   * @generated
   */
  int OPP_CONTAINER = 2;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_CONTAINER__ID = OPP_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_CONTAINER__NODES = OPP_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_CONTAINER_FEATURE_COUNT = OPP_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.impl.OPPNodeImpl <em>Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.impl.OPPNodeImpl
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPNode()
   * @generated
   */
  int OPP_NODE = 3;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_NODE__ID = OPP_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_NODE__INCOMING_LINKS = OPP_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_NODE__OUTGOING_LINKS = OPP_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_NODE__CONTAINER = OPP_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_NODE__WIDTH = OPP_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_NODE__HEIGHT = OPP_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_NODE__X = OPP_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_NODE__Y = OPP_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Manual Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_NODE__MANUAL_SIZE = OPP_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_NODE_FEATURE_COUNT = OPP_ELEMENT_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.impl.OPPObjectProcessDiagramImpl <em>Object Process Diagram</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.impl.OPPObjectProcessDiagramImpl
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPObjectProcessDiagram()
   * @generated
   */
  int OPP_OBJECT_PROCESS_DIAGRAM = 4;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT_PROCESS_DIAGRAM__ID = OPP_CONTAINER__ID;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT_PROCESS_DIAGRAM__NODES = OPP_CONTAINER__NODES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT_PROCESS_DIAGRAM__NAME = OPP_CONTAINER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Alignment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT_PROCESS_DIAGRAM__ALIGNMENT = OPP_CONTAINER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Links</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT_PROCESS_DIAGRAM__LINKS = OPP_CONTAINER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Last Known Used Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT_PROCESS_DIAGRAM__LAST_KNOWN_USED_ID = OPP_CONTAINER_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT_PROCESS_DIAGRAM__KIND = OPP_CONTAINER_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Object Process Diagram</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT_PROCESS_DIAGRAM_FEATURE_COUNT = OPP_CONTAINER_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.impl.OPPThingImpl <em>Thing</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.impl.OPPThingImpl
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPThing()
   * @generated
   */
  int OPP_THING = 5;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_THING__ID = OPP_NODE__ID;

  /**
   * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_THING__INCOMING_LINKS = OPP_NODE__INCOMING_LINKS;

  /**
   * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_THING__OUTGOING_LINKS = OPP_NODE__OUTGOING_LINKS;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_THING__CONTAINER = OPP_NODE__CONTAINER;

  /**
   * The feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_THING__WIDTH = OPP_NODE__WIDTH;

  /**
   * The feature id for the '<em><b>Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_THING__HEIGHT = OPP_NODE__HEIGHT;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_THING__X = OPP_NODE__X;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_THING__Y = OPP_NODE__Y;

  /**
   * The feature id for the '<em><b>Manual Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_THING__MANUAL_SIZE = OPP_NODE__MANUAL_SIZE;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_THING__NODES = OPP_NODE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_THING__NAME = OPP_NODE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Alignment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_THING__ALIGNMENT = OPP_NODE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_THING__DESCRIPTION = OPP_NODE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Collection</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_THING__COLLECTION = OPP_NODE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Main</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_THING__MAIN = OPP_NODE_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Thing</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_THING_FEATURE_COUNT = OPP_NODE_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.impl.OPPStateImpl <em>State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.impl.OPPStateImpl
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPState()
   * @generated
   */
  int OPP_STATE = 6;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STATE__ID = OPP_NODE__ID;

  /**
   * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STATE__INCOMING_LINKS = OPP_NODE__INCOMING_LINKS;

  /**
   * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STATE__OUTGOING_LINKS = OPP_NODE__OUTGOING_LINKS;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STATE__CONTAINER = OPP_NODE__CONTAINER;

  /**
   * The feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STATE__WIDTH = OPP_NODE__WIDTH;

  /**
   * The feature id for the '<em><b>Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STATE__HEIGHT = OPP_NODE__HEIGHT;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STATE__X = OPP_NODE__X;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STATE__Y = OPP_NODE__Y;

  /**
   * The feature id for the '<em><b>Manual Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STATE__MANUAL_SIZE = OPP_NODE__MANUAL_SIZE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STATE__NAME = OPP_NODE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Alignment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STATE__ALIGNMENT = OPP_NODE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STATE__VALUE = OPP_NODE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STATE_FEATURE_COUNT = OPP_NODE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.impl.OPPObjectImpl <em>Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.impl.OPPObjectImpl
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPObject()
   * @generated
   */
  int OPP_OBJECT = 7;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT__ID = OPP_THING__ID;

  /**
   * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT__INCOMING_LINKS = OPP_THING__INCOMING_LINKS;

  /**
   * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT__OUTGOING_LINKS = OPP_THING__OUTGOING_LINKS;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT__CONTAINER = OPP_THING__CONTAINER;

  /**
   * The feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT__WIDTH = OPP_THING__WIDTH;

  /**
   * The feature id for the '<em><b>Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT__HEIGHT = OPP_THING__HEIGHT;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT__X = OPP_THING__X;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT__Y = OPP_THING__Y;

  /**
   * The feature id for the '<em><b>Manual Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT__MANUAL_SIZE = OPP_THING__MANUAL_SIZE;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT__NODES = OPP_THING__NODES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT__NAME = OPP_THING__NAME;

  /**
   * The feature id for the '<em><b>Alignment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT__ALIGNMENT = OPP_THING__ALIGNMENT;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT__DESCRIPTION = OPP_THING__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Collection</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT__COLLECTION = OPP_THING__COLLECTION;

  /**
   * The feature id for the '<em><b>Main</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT__MAIN = OPP_THING__MAIN;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT__PARAMETER = OPP_THING_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Global</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT__GLOBAL = OPP_THING_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_OBJECT_FEATURE_COUNT = OPP_THING_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.impl.OPPProcessImpl <em>Process</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.impl.OPPProcessImpl
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPProcess()
   * @generated
   */
  int OPP_PROCESS = 8;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCESS__ID = OPP_THING__ID;

  /**
   * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCESS__INCOMING_LINKS = OPP_THING__INCOMING_LINKS;

  /**
   * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCESS__OUTGOING_LINKS = OPP_THING__OUTGOING_LINKS;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCESS__CONTAINER = OPP_THING__CONTAINER;

  /**
   * The feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCESS__WIDTH = OPP_THING__WIDTH;

  /**
   * The feature id for the '<em><b>Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCESS__HEIGHT = OPP_THING__HEIGHT;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCESS__X = OPP_THING__X;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCESS__Y = OPP_THING__Y;

  /**
   * The feature id for the '<em><b>Manual Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCESS__MANUAL_SIZE = OPP_THING__MANUAL_SIZE;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCESS__NODES = OPP_THING__NODES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCESS__NAME = OPP_THING__NAME;

  /**
   * The feature id for the '<em><b>Alignment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCESS__ALIGNMENT = OPP_THING__ALIGNMENT;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCESS__DESCRIPTION = OPP_THING__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Collection</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCESS__COLLECTION = OPP_THING__COLLECTION;

  /**
   * The feature id for the '<em><b>Main</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCESS__MAIN = OPP_THING__MAIN;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCESS__KIND = OPP_THING_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Order</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCESS__ORDER = OPP_THING_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Process</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCESS_FEATURE_COUNT = OPP_THING_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.impl.OPPStructuralLinkAggregatorImpl <em>Structural Link Aggregator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.impl.OPPStructuralLinkAggregatorImpl
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPStructuralLinkAggregator()
   * @generated
   */
  int OPP_STRUCTURAL_LINK_AGGREGATOR = 9;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_AGGREGATOR__ID = OPP_NODE__ID;

  /**
   * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_AGGREGATOR__INCOMING_LINKS = OPP_NODE__INCOMING_LINKS;

  /**
   * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_AGGREGATOR__OUTGOING_LINKS = OPP_NODE__OUTGOING_LINKS;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_AGGREGATOR__CONTAINER = OPP_NODE__CONTAINER;

  /**
   * The feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_AGGREGATOR__WIDTH = OPP_NODE__WIDTH;

  /**
   * The feature id for the '<em><b>Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_AGGREGATOR__HEIGHT = OPP_NODE__HEIGHT;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_AGGREGATOR__X = OPP_NODE__X;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_AGGREGATOR__Y = OPP_NODE__Y;

  /**
   * The feature id for the '<em><b>Manual Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_AGGREGATOR__MANUAL_SIZE = OPP_NODE__MANUAL_SIZE;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_AGGREGATOR__KIND = OPP_NODE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Structural Link Aggregator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_AGGREGATOR_FEATURE_COUNT = OPP_NODE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.impl.OPPLinkImpl <em>Link</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.impl.OPPLinkImpl
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPLink()
   * @generated
   */
  int OPP_LINK = 11;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.impl.OPPProceduralLinkImpl <em>Procedural Link</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.impl.OPPProceduralLinkImpl
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPProceduralLink()
   * @generated
   */
  int OPP_PROCEDURAL_LINK = 12;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.impl.OPPStructuralLinkPartImpl <em>Structural Link Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.impl.OPPStructuralLinkPartImpl
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPStructuralLinkPart()
   * @generated
   */
  int OPP_STRUCTURAL_LINK_PART = 13;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.impl.OPPLabelImpl <em>Label</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.impl.OPPLabelImpl
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPLabel()
   * @generated
   */
  int OPP_LABEL = 10;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LABEL__ID = OPP_NODE__ID;

  /**
   * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LABEL__INCOMING_LINKS = OPP_NODE__INCOMING_LINKS;

  /**
   * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LABEL__OUTGOING_LINKS = OPP_NODE__OUTGOING_LINKS;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LABEL__CONTAINER = OPP_NODE__CONTAINER;

  /**
   * The feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LABEL__WIDTH = OPP_NODE__WIDTH;

  /**
   * The feature id for the '<em><b>Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LABEL__HEIGHT = OPP_NODE__HEIGHT;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LABEL__X = OPP_NODE__X;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LABEL__Y = OPP_NODE__Y;

  /**
   * The feature id for the '<em><b>Manual Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LABEL__MANUAL_SIZE = OPP_NODE__MANUAL_SIZE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LABEL__NAME = OPP_NODE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Alignment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LABEL__ALIGNMENT = OPP_NODE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Label</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LABEL_FEATURE_COUNT = OPP_NODE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LINK__ID = OPP_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Opd</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LINK__OPD = OPP_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LINK__SOURCE = OPP_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LINK__TARGET = OPP_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Source Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LINK__SOURCE_DECORATION = OPP_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Target Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LINK__TARGET_DECORATION = OPP_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Center Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LINK__CENTER_DECORATION = OPP_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Bendpoints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LINK__BENDPOINTS = OPP_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>Link</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_LINK_FEATURE_COUNT = OPP_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCEDURAL_LINK__ID = OPP_LINK__ID;

  /**
   * The feature id for the '<em><b>Opd</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCEDURAL_LINK__OPD = OPP_LINK__OPD;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCEDURAL_LINK__SOURCE = OPP_LINK__SOURCE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCEDURAL_LINK__TARGET = OPP_LINK__TARGET;

  /**
   * The feature id for the '<em><b>Source Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCEDURAL_LINK__SOURCE_DECORATION = OPP_LINK__SOURCE_DECORATION;

  /**
   * The feature id for the '<em><b>Target Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCEDURAL_LINK__TARGET_DECORATION = OPP_LINK__TARGET_DECORATION;

  /**
   * The feature id for the '<em><b>Center Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCEDURAL_LINK__CENTER_DECORATION = OPP_LINK__CENTER_DECORATION;

  /**
   * The feature id for the '<em><b>Bendpoints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCEDURAL_LINK__BENDPOINTS = OPP_LINK__BENDPOINTS;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCEDURAL_LINK__KIND = OPP_LINK_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Sub Kinds</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCEDURAL_LINK__SUB_KINDS = OPP_LINK_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Procedural Link</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_PROCEDURAL_LINK_FEATURE_COUNT = OPP_LINK_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_PART__ID = OPP_LINK__ID;

  /**
   * The feature id for the '<em><b>Opd</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_PART__OPD = OPP_LINK__OPD;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_PART__SOURCE = OPP_LINK__SOURCE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_PART__TARGET = OPP_LINK__TARGET;

  /**
   * The feature id for the '<em><b>Source Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_PART__SOURCE_DECORATION = OPP_LINK__SOURCE_DECORATION;

  /**
   * The feature id for the '<em><b>Target Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_PART__TARGET_DECORATION = OPP_LINK__TARGET_DECORATION;

  /**
   * The feature id for the '<em><b>Center Decoration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_PART__CENTER_DECORATION = OPP_LINK__CENTER_DECORATION;

  /**
   * The feature id for the '<em><b>Bendpoints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_PART__BENDPOINTS = OPP_LINK__BENDPOINTS;

  /**
   * The number of structural features of the '<em>Structural Link Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_STRUCTURAL_LINK_PART_FEATURE_COUNT = OPP_LINK_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.impl.OPPPointImpl <em>Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.impl.OPPPointImpl
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPPoint()
   * @generated
   */
  int OPP_POINT = 14;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_POINT__ID = OPP_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_POINT__X = OPP_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_POINT__Y = OPP_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPP_POINT_FEATURE_COUNT = OPP_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.OPPStructuralLinkAggregatorKind <em>Structural Link Aggregator Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.OPPStructuralLinkAggregatorKind
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPStructuralLinkAggregatorKind()
   * @generated
   */
  int OPP_STRUCTURAL_LINK_AGGREGATOR_KIND = 15;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.OPPProceduralLinkKind <em>Procedural Link Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.OPPProceduralLinkKind
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPProceduralLinkKind()
   * @generated
   */
  int OPP_PROCEDURAL_LINK_KIND = 16;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.OPPProcessKind <em>Process Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.OPPProcessKind
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPProcessKind()
   * @generated
   */
  int OPP_PROCESS_KIND = 17;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind <em>Object Process Diagram Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPObjectProcessDiagramKind()
   * @generated
   */
  int OPP_OBJECT_PROCESS_DIAGRAM_KIND = 18;

  /**
   * The meta object id for the '{@link com.vainolo.phd.opp.model.OPPVerticalAlignment <em>Vertical Alignment</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.vainolo.phd.opp.model.OPPVerticalAlignment
   * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPVerticalAlignment()
   * @generated
   */
  int OPP_VERTICAL_ALIGNMENT = 19;

  /**
   * Returns the meta object for class '{@link com.vainolo.phd.opp.model.OPPElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see com.vainolo.phd.opp.model.OPPElement
   * @generated
   */
  EClass getOPPElement();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPElement#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see com.vainolo.phd.opp.model.OPPElement#getId()
   * @see #getOPPElement()
   * @generated
   */
  EAttribute getOPPElement_Id();

  /**
   * Returns the meta object for class '{@link com.vainolo.phd.opp.model.OPPNamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Element</em>'.
   * @see com.vainolo.phd.opp.model.OPPNamedElement
   * @generated
   */
  EClass getOPPNamedElement();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPNamedElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.vainolo.phd.opp.model.OPPNamedElement#getName()
   * @see #getOPPNamedElement()
   * @generated
   */
  EAttribute getOPPNamedElement_Name();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPNamedElement#getAlignment <em>Alignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Alignment</em>'.
   * @see com.vainolo.phd.opp.model.OPPNamedElement#getAlignment()
   * @see #getOPPNamedElement()
   * @generated
   */
  EAttribute getOPPNamedElement_Alignment();

  /**
   * Returns the meta object for class '{@link com.vainolo.phd.opp.model.OPPContainer <em>Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Container</em>'.
   * @see com.vainolo.phd.opp.model.OPPContainer
   * @generated
   */
  EClass getOPPContainer();

  /**
   * Returns the meta object for the containment reference list '{@link com.vainolo.phd.opp.model.OPPContainer#getNodes <em>Nodes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nodes</em>'.
   * @see com.vainolo.phd.opp.model.OPPContainer#getNodes()
   * @see #getOPPContainer()
   * @generated
   */
  EReference getOPPContainer_Nodes();

  /**
   * Returns the meta object for class '{@link com.vainolo.phd.opp.model.OPPNode <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node</em>'.
   * @see com.vainolo.phd.opp.model.OPPNode
   * @generated
   */
  EClass getOPPNode();

  /**
   * Returns the meta object for the reference list '{@link com.vainolo.phd.opp.model.OPPNode#getIncomingLinks <em>Incoming Links</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Incoming Links</em>'.
   * @see com.vainolo.phd.opp.model.OPPNode#getIncomingLinks()
   * @see #getOPPNode()
   * @generated
   */
  EReference getOPPNode_IncomingLinks();

  /**
   * Returns the meta object for the reference list '{@link com.vainolo.phd.opp.model.OPPNode#getOutgoingLinks <em>Outgoing Links</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Outgoing Links</em>'.
   * @see com.vainolo.phd.opp.model.OPPNode#getOutgoingLinks()
   * @see #getOPPNode()
   * @generated
   */
  EReference getOPPNode_OutgoingLinks();

  /**
   * Returns the meta object for the container reference '{@link com.vainolo.phd.opp.model.OPPNode#getContainer <em>Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Container</em>'.
   * @see com.vainolo.phd.opp.model.OPPNode#getContainer()
   * @see #getOPPNode()
   * @generated
   */
  EReference getOPPNode_Container();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPNode#getWidth <em>Width</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Width</em>'.
   * @see com.vainolo.phd.opp.model.OPPNode#getWidth()
   * @see #getOPPNode()
   * @generated
   */
  EAttribute getOPPNode_Width();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPNode#getHeight <em>Height</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Height</em>'.
   * @see com.vainolo.phd.opp.model.OPPNode#getHeight()
   * @see #getOPPNode()
   * @generated
   */
  EAttribute getOPPNode_Height();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPNode#getX <em>X</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>X</em>'.
   * @see com.vainolo.phd.opp.model.OPPNode#getX()
   * @see #getOPPNode()
   * @generated
   */
  EAttribute getOPPNode_X();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPNode#getY <em>Y</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Y</em>'.
   * @see com.vainolo.phd.opp.model.OPPNode#getY()
   * @see #getOPPNode()
   * @generated
   */
  EAttribute getOPPNode_Y();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPNode#isManualSize <em>Manual Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Manual Size</em>'.
   * @see com.vainolo.phd.opp.model.OPPNode#isManualSize()
   * @see #getOPPNode()
   * @generated
   */
  EAttribute getOPPNode_ManualSize();

  /**
   * Returns the meta object for class '{@link com.vainolo.phd.opp.model.OPPObjectProcessDiagram <em>Object Process Diagram</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Process Diagram</em>'.
   * @see com.vainolo.phd.opp.model.OPPObjectProcessDiagram
   * @generated
   */
  EClass getOPPObjectProcessDiagram();

  /**
   * Returns the meta object for the containment reference list '{@link com.vainolo.phd.opp.model.OPPObjectProcessDiagram#getLinks <em>Links</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Links</em>'.
   * @see com.vainolo.phd.opp.model.OPPObjectProcessDiagram#getLinks()
   * @see #getOPPObjectProcessDiagram()
   * @generated
   */
  EReference getOPPObjectProcessDiagram_Links();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPObjectProcessDiagram#getLastKnownUsedId <em>Last Known Used Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Last Known Used Id</em>'.
   * @see com.vainolo.phd.opp.model.OPPObjectProcessDiagram#getLastKnownUsedId()
   * @see #getOPPObjectProcessDiagram()
   * @generated
   */
  EAttribute getOPPObjectProcessDiagram_LastKnownUsedId();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPObjectProcessDiagram#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see com.vainolo.phd.opp.model.OPPObjectProcessDiagram#getKind()
   * @see #getOPPObjectProcessDiagram()
   * @generated
   */
  EAttribute getOPPObjectProcessDiagram_Kind();

  /**
   * Returns the meta object for class '{@link com.vainolo.phd.opp.model.OPPThing <em>Thing</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Thing</em>'.
   * @see com.vainolo.phd.opp.model.OPPThing
   * @generated
   */
  EClass getOPPThing();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPThing#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.vainolo.phd.opp.model.OPPThing#getDescription()
   * @see #getOPPThing()
   * @generated
   */
  EAttribute getOPPThing_Description();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPThing#isCollection <em>Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Collection</em>'.
   * @see com.vainolo.phd.opp.model.OPPThing#isCollection()
   * @see #getOPPThing()
   * @generated
   */
  EAttribute getOPPThing_Collection();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPThing#isMain <em>Main</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Main</em>'.
   * @see com.vainolo.phd.opp.model.OPPThing#isMain()
   * @see #getOPPThing()
   * @generated
   */
  EAttribute getOPPThing_Main();

  /**
   * Returns the meta object for class '{@link com.vainolo.phd.opp.model.OPPState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State</em>'.
   * @see com.vainolo.phd.opp.model.OPPState
   * @generated
   */
  EClass getOPPState();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPState#isValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.vainolo.phd.opp.model.OPPState#isValue()
   * @see #getOPPState()
   * @generated
   */
  EAttribute getOPPState_Value();

  /**
   * Returns the meta object for class '{@link com.vainolo.phd.opp.model.OPPObject <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object</em>'.
   * @see com.vainolo.phd.opp.model.OPPObject
   * @generated
   */
  EClass getOPPObject();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPObject#isParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Parameter</em>'.
   * @see com.vainolo.phd.opp.model.OPPObject#isParameter()
   * @see #getOPPObject()
   * @generated
   */
  EAttribute getOPPObject_Parameter();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPObject#isGlobal <em>Global</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Global</em>'.
   * @see com.vainolo.phd.opp.model.OPPObject#isGlobal()
   * @see #getOPPObject()
   * @generated
   */
  EAttribute getOPPObject_Global();

  /**
   * Returns the meta object for class '{@link com.vainolo.phd.opp.model.OPPProcess <em>Process</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Process</em>'.
   * @see com.vainolo.phd.opp.model.OPPProcess
   * @generated
   */
  EClass getOPPProcess();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPProcess#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see com.vainolo.phd.opp.model.OPPProcess#getKind()
   * @see #getOPPProcess()
   * @generated
   */
  EAttribute getOPPProcess_Kind();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPProcess#getOrder <em>Order</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Order</em>'.
   * @see com.vainolo.phd.opp.model.OPPProcess#getOrder()
   * @see #getOPPProcess()
   * @generated
   */
  EAttribute getOPPProcess_Order();

  /**
   * Returns the meta object for class '{@link com.vainolo.phd.opp.model.OPPStructuralLinkAggregator <em>Structural Link Aggregator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Structural Link Aggregator</em>'.
   * @see com.vainolo.phd.opp.model.OPPStructuralLinkAggregator
   * @generated
   */
  EClass getOPPStructuralLinkAggregator();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPStructuralLinkAggregator#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see com.vainolo.phd.opp.model.OPPStructuralLinkAggregator#getKind()
   * @see #getOPPStructuralLinkAggregator()
   * @generated
   */
  EAttribute getOPPStructuralLinkAggregator_Kind();

  /**
   * Returns the meta object for class '{@link com.vainolo.phd.opp.model.OPPLink <em>Link</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Link</em>'.
   * @see com.vainolo.phd.opp.model.OPPLink
   * @generated
   */
  EClass getOPPLink();

  /**
   * Returns the meta object for the container reference '{@link com.vainolo.phd.opp.model.OPPLink#getOpd <em>Opd</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Opd</em>'.
   * @see com.vainolo.phd.opp.model.OPPLink#getOpd()
   * @see #getOPPLink()
   * @generated
   */
  EReference getOPPLink_Opd();

  /**
   * Returns the meta object for the reference '{@link com.vainolo.phd.opp.model.OPPLink#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see com.vainolo.phd.opp.model.OPPLink#getSource()
   * @see #getOPPLink()
   * @generated
   */
  EReference getOPPLink_Source();

  /**
   * Returns the meta object for the reference '{@link com.vainolo.phd.opp.model.OPPLink#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see com.vainolo.phd.opp.model.OPPLink#getTarget()
   * @see #getOPPLink()
   * @generated
   */
  EReference getOPPLink_Target();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPLink#getSourceDecoration <em>Source Decoration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Source Decoration</em>'.
   * @see com.vainolo.phd.opp.model.OPPLink#getSourceDecoration()
   * @see #getOPPLink()
   * @generated
   */
  EAttribute getOPPLink_SourceDecoration();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPLink#getTargetDecoration <em>Target Decoration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Decoration</em>'.
   * @see com.vainolo.phd.opp.model.OPPLink#getTargetDecoration()
   * @see #getOPPLink()
   * @generated
   */
  EAttribute getOPPLink_TargetDecoration();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPLink#getCenterDecoration <em>Center Decoration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Center Decoration</em>'.
   * @see com.vainolo.phd.opp.model.OPPLink#getCenterDecoration()
   * @see #getOPPLink()
   * @generated
   */
  EAttribute getOPPLink_CenterDecoration();

  /**
   * Returns the meta object for the containment reference list '{@link com.vainolo.phd.opp.model.OPPLink#getBendpoints <em>Bendpoints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Bendpoints</em>'.
   * @see com.vainolo.phd.opp.model.OPPLink#getBendpoints()
   * @see #getOPPLink()
   * @generated
   */
  EReference getOPPLink_Bendpoints();

  /**
   * Returns the meta object for class '{@link com.vainolo.phd.opp.model.OPPProceduralLink <em>Procedural Link</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Procedural Link</em>'.
   * @see com.vainolo.phd.opp.model.OPPProceduralLink
   * @generated
   */
  EClass getOPPProceduralLink();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPProceduralLink#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see com.vainolo.phd.opp.model.OPPProceduralLink#getKind()
   * @see #getOPPProceduralLink()
   * @generated
   */
  EAttribute getOPPProceduralLink_Kind();

  /**
   * Returns the meta object for the attribute list '{@link com.vainolo.phd.opp.model.OPPProceduralLink#getSubKinds <em>Sub Kinds</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Sub Kinds</em>'.
   * @see com.vainolo.phd.opp.model.OPPProceduralLink#getSubKinds()
   * @see #getOPPProceduralLink()
   * @generated
   */
  EAttribute getOPPProceduralLink_SubKinds();

  /**
   * Returns the meta object for class '{@link com.vainolo.phd.opp.model.OPPStructuralLinkPart <em>Structural Link Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Structural Link Part</em>'.
   * @see com.vainolo.phd.opp.model.OPPStructuralLinkPart
   * @generated
   */
  EClass getOPPStructuralLinkPart();

  /**
   * Returns the meta object for class '{@link com.vainolo.phd.opp.model.OPPLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Label</em>'.
   * @see com.vainolo.phd.opp.model.OPPLabel
   * @generated
   */
  EClass getOPPLabel();

  /**
   * Returns the meta object for class '{@link com.vainolo.phd.opp.model.OPPPoint <em>Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Point</em>'.
   * @see com.vainolo.phd.opp.model.OPPPoint
   * @generated
   */
  EClass getOPPPoint();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPPoint#getX <em>X</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>X</em>'.
   * @see com.vainolo.phd.opp.model.OPPPoint#getX()
   * @see #getOPPPoint()
   * @generated
   */
  EAttribute getOPPPoint_X();

  /**
   * Returns the meta object for the attribute '{@link com.vainolo.phd.opp.model.OPPPoint#getY <em>Y</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Y</em>'.
   * @see com.vainolo.phd.opp.model.OPPPoint#getY()
   * @see #getOPPPoint()
   * @generated
   */
  EAttribute getOPPPoint_Y();

  /**
   * Returns the meta object for enum '{@link com.vainolo.phd.opp.model.OPPStructuralLinkAggregatorKind <em>Structural Link Aggregator Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Structural Link Aggregator Kind</em>'.
   * @see com.vainolo.phd.opp.model.OPPStructuralLinkAggregatorKind
   * @generated
   */
  EEnum getOPPStructuralLinkAggregatorKind();

  /**
   * Returns the meta object for enum '{@link com.vainolo.phd.opp.model.OPPProceduralLinkKind <em>Procedural Link Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Procedural Link Kind</em>'.
   * @see com.vainolo.phd.opp.model.OPPProceduralLinkKind
   * @generated
   */
  EEnum getOPPProceduralLinkKind();

  /**
   * Returns the meta object for enum '{@link com.vainolo.phd.opp.model.OPPProcessKind <em>Process Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Process Kind</em>'.
   * @see com.vainolo.phd.opp.model.OPPProcessKind
   * @generated
   */
  EEnum getOPPProcessKind();

  /**
   * Returns the meta object for enum '{@link com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind <em>Object Process Diagram Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Object Process Diagram Kind</em>'.
   * @see com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind
   * @generated
   */
  EEnum getOPPObjectProcessDiagramKind();

  /**
   * Returns the meta object for enum '{@link com.vainolo.phd.opp.model.OPPVerticalAlignment <em>Vertical Alignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Vertical Alignment</em>'.
   * @see com.vainolo.phd.opp.model.OPPVerticalAlignment
   * @generated
   */
  EEnum getOPPVerticalAlignment();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  OPPFactory getOPPFactory();

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
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.impl.OPPElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.impl.OPPElementImpl
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPElement()
     * @generated
     */
    EClass OPP_ELEMENT = eINSTANCE.getOPPElement();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_ELEMENT__ID = eINSTANCE.getOPPElement_Id();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.impl.OPPNamedElementImpl <em>Named Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.impl.OPPNamedElementImpl
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPNamedElement()
     * @generated
     */
    EClass OPP_NAMED_ELEMENT = eINSTANCE.getOPPNamedElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_NAMED_ELEMENT__NAME = eINSTANCE.getOPPNamedElement_Name();

    /**
     * The meta object literal for the '<em><b>Alignment</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_NAMED_ELEMENT__ALIGNMENT = eINSTANCE.getOPPNamedElement_Alignment();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.impl.OPPContainerImpl <em>Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.impl.OPPContainerImpl
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPContainer()
     * @generated
     */
    EClass OPP_CONTAINER = eINSTANCE.getOPPContainer();

    /**
     * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPP_CONTAINER__NODES = eINSTANCE.getOPPContainer_Nodes();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.impl.OPPNodeImpl <em>Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.impl.OPPNodeImpl
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPNode()
     * @generated
     */
    EClass OPP_NODE = eINSTANCE.getOPPNode();

    /**
     * The meta object literal for the '<em><b>Incoming Links</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPP_NODE__INCOMING_LINKS = eINSTANCE.getOPPNode_IncomingLinks();

    /**
     * The meta object literal for the '<em><b>Outgoing Links</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPP_NODE__OUTGOING_LINKS = eINSTANCE.getOPPNode_OutgoingLinks();

    /**
     * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPP_NODE__CONTAINER = eINSTANCE.getOPPNode_Container();

    /**
     * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_NODE__WIDTH = eINSTANCE.getOPPNode_Width();

    /**
     * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_NODE__HEIGHT = eINSTANCE.getOPPNode_Height();

    /**
     * The meta object literal for the '<em><b>X</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_NODE__X = eINSTANCE.getOPPNode_X();

    /**
     * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_NODE__Y = eINSTANCE.getOPPNode_Y();

    /**
     * The meta object literal for the '<em><b>Manual Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_NODE__MANUAL_SIZE = eINSTANCE.getOPPNode_ManualSize();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.impl.OPPObjectProcessDiagramImpl <em>Object Process Diagram</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.impl.OPPObjectProcessDiagramImpl
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPObjectProcessDiagram()
     * @generated
     */
    EClass OPP_OBJECT_PROCESS_DIAGRAM = eINSTANCE.getOPPObjectProcessDiagram();

    /**
     * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPP_OBJECT_PROCESS_DIAGRAM__LINKS = eINSTANCE.getOPPObjectProcessDiagram_Links();

    /**
     * The meta object literal for the '<em><b>Last Known Used Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_OBJECT_PROCESS_DIAGRAM__LAST_KNOWN_USED_ID = eINSTANCE.getOPPObjectProcessDiagram_LastKnownUsedId();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_OBJECT_PROCESS_DIAGRAM__KIND = eINSTANCE.getOPPObjectProcessDiagram_Kind();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.impl.OPPThingImpl <em>Thing</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.impl.OPPThingImpl
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPThing()
     * @generated
     */
    EClass OPP_THING = eINSTANCE.getOPPThing();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_THING__DESCRIPTION = eINSTANCE.getOPPThing_Description();

    /**
     * The meta object literal for the '<em><b>Collection</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_THING__COLLECTION = eINSTANCE.getOPPThing_Collection();

    /**
     * The meta object literal for the '<em><b>Main</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_THING__MAIN = eINSTANCE.getOPPThing_Main();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.impl.OPPStateImpl <em>State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.impl.OPPStateImpl
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPState()
     * @generated
     */
    EClass OPP_STATE = eINSTANCE.getOPPState();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_STATE__VALUE = eINSTANCE.getOPPState_Value();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.impl.OPPObjectImpl <em>Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.impl.OPPObjectImpl
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPObject()
     * @generated
     */
    EClass OPP_OBJECT = eINSTANCE.getOPPObject();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_OBJECT__PARAMETER = eINSTANCE.getOPPObject_Parameter();

    /**
     * The meta object literal for the '<em><b>Global</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_OBJECT__GLOBAL = eINSTANCE.getOPPObject_Global();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.impl.OPPProcessImpl <em>Process</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.impl.OPPProcessImpl
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPProcess()
     * @generated
     */
    EClass OPP_PROCESS = eINSTANCE.getOPPProcess();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_PROCESS__KIND = eINSTANCE.getOPPProcess_Kind();

    /**
     * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_PROCESS__ORDER = eINSTANCE.getOPPProcess_Order();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.impl.OPPStructuralLinkAggregatorImpl <em>Structural Link Aggregator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.impl.OPPStructuralLinkAggregatorImpl
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPStructuralLinkAggregator()
     * @generated
     */
    EClass OPP_STRUCTURAL_LINK_AGGREGATOR = eINSTANCE.getOPPStructuralLinkAggregator();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_STRUCTURAL_LINK_AGGREGATOR__KIND = eINSTANCE.getOPPStructuralLinkAggregator_Kind();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.impl.OPPLinkImpl <em>Link</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.impl.OPPLinkImpl
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPLink()
     * @generated
     */
    EClass OPP_LINK = eINSTANCE.getOPPLink();

    /**
     * The meta object literal for the '<em><b>Opd</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPP_LINK__OPD = eINSTANCE.getOPPLink_Opd();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPP_LINK__SOURCE = eINSTANCE.getOPPLink_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPP_LINK__TARGET = eINSTANCE.getOPPLink_Target();

    /**
     * The meta object literal for the '<em><b>Source Decoration</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_LINK__SOURCE_DECORATION = eINSTANCE.getOPPLink_SourceDecoration();

    /**
     * The meta object literal for the '<em><b>Target Decoration</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_LINK__TARGET_DECORATION = eINSTANCE.getOPPLink_TargetDecoration();

    /**
     * The meta object literal for the '<em><b>Center Decoration</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_LINK__CENTER_DECORATION = eINSTANCE.getOPPLink_CenterDecoration();

    /**
     * The meta object literal for the '<em><b>Bendpoints</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPP_LINK__BENDPOINTS = eINSTANCE.getOPPLink_Bendpoints();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.impl.OPPProceduralLinkImpl <em>Procedural Link</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.impl.OPPProceduralLinkImpl
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPProceduralLink()
     * @generated
     */
    EClass OPP_PROCEDURAL_LINK = eINSTANCE.getOPPProceduralLink();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_PROCEDURAL_LINK__KIND = eINSTANCE.getOPPProceduralLink_Kind();

    /**
     * The meta object literal for the '<em><b>Sub Kinds</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_PROCEDURAL_LINK__SUB_KINDS = eINSTANCE.getOPPProceduralLink_SubKinds();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.impl.OPPStructuralLinkPartImpl <em>Structural Link Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.impl.OPPStructuralLinkPartImpl
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPStructuralLinkPart()
     * @generated
     */
    EClass OPP_STRUCTURAL_LINK_PART = eINSTANCE.getOPPStructuralLinkPart();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.impl.OPPLabelImpl <em>Label</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.impl.OPPLabelImpl
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPLabel()
     * @generated
     */
    EClass OPP_LABEL = eINSTANCE.getOPPLabel();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.impl.OPPPointImpl <em>Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.impl.OPPPointImpl
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPPoint()
     * @generated
     */
    EClass OPP_POINT = eINSTANCE.getOPPPoint();

    /**
     * The meta object literal for the '<em><b>X</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_POINT__X = eINSTANCE.getOPPPoint_X();

    /**
     * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPP_POINT__Y = eINSTANCE.getOPPPoint_Y();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.OPPStructuralLinkAggregatorKind <em>Structural Link Aggregator Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.OPPStructuralLinkAggregatorKind
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPStructuralLinkAggregatorKind()
     * @generated
     */
    EEnum OPP_STRUCTURAL_LINK_AGGREGATOR_KIND = eINSTANCE.getOPPStructuralLinkAggregatorKind();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.OPPProceduralLinkKind <em>Procedural Link Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.OPPProceduralLinkKind
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPProceduralLinkKind()
     * @generated
     */
    EEnum OPP_PROCEDURAL_LINK_KIND = eINSTANCE.getOPPProceduralLinkKind();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.OPPProcessKind <em>Process Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.OPPProcessKind
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPProcessKind()
     * @generated
     */
    EEnum OPP_PROCESS_KIND = eINSTANCE.getOPPProcessKind();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind <em>Object Process Diagram Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPObjectProcessDiagramKind()
     * @generated
     */
    EEnum OPP_OBJECT_PROCESS_DIAGRAM_KIND = eINSTANCE.getOPPObjectProcessDiagramKind();

    /**
     * The meta object literal for the '{@link com.vainolo.phd.opp.model.OPPVerticalAlignment <em>Vertical Alignment</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.vainolo.phd.opp.model.OPPVerticalAlignment
     * @see com.vainolo.phd.opp.model.impl.OPPPackageImpl#getOPPVerticalAlignment()
     * @generated
     */
    EEnum OPP_VERTICAL_ALIGNMENT = eINSTANCE.getOPPVerticalAlignment();

  }

} //OPPPackage
