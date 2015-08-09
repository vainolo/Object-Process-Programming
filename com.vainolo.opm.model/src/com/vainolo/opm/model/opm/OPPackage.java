/**
 */
package com.vainolo.opm.model.opm;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.vainolo.opm.model.opm.OPFactory
 * @model kind="package"
 * @generated
 */
public interface OPPackage extends EPackage {
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
	String eNS_URI = "http://www.vainolo.org/opm";

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
	OPPackage eINSTANCE = com.vainolo.opm.model.opm.impl.OPPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.OPElement <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.OPElement
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPElement()
	 * @generated
	 */
	int OP_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_ELEMENT__SYSTEM = 0;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.OPLink <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.OPLink
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPLink()
	 * @generated
	 */
	int OP_LINK = 3;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.OPNode <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.OPNode
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPNode()
	 * @generated
	 */
	int OP_NODE = 4;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.OPThing <em>Thing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.OPThing
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPThing()
	 * @generated
	 */
	int OP_THING = 6;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.impl.OPObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.impl.OPObjectImpl
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPObject()
	 * @generated
	 */
	int OP_OBJECT = 7;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.impl.OPStateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.impl.OPStateImpl
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPState()
	 * @generated
	 */
	int OP_STATE = 5;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.impl.OPProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.impl.OPProcessImpl
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPProcess()
	 * @generated
	 */
	int OP_PROCESS = 8;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.impl.OPProceduralLinkImpl <em>Procedural Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.impl.OPProceduralLinkImpl
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPProceduralLink()
	 * @generated
	 */
	int OP_PROCEDURAL_LINK = 9;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.impl.OPStructuralLinkImpl <em>Structural Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.impl.OPStructuralLinkImpl
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPStructuralLink()
	 * @generated
	 */
	int OP_STRUCTURAL_LINK = 10;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.impl.OPObjectProcessDiagramImpl <em>Object Process Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.impl.OPObjectProcessDiagramImpl
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPObjectProcessDiagram()
	 * @generated
	 */
	int OP_OBJECT_PROCESS_DIAGRAM = 2;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.impl.OPSystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.impl.OPSystemImpl
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPSystem()
	 * @generated
	 */
	int OP_SYSTEM = 1;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>System Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_SYSTEM__SYSTEM_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_SYSTEM__NAME = 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_SYSTEM__ELEMENTS = 2;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_SYSTEM_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_SYSTEM_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT_PROCESS_DIAGRAM__SYSTEM = OP_ELEMENT__SYSTEM;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT_PROCESS_DIAGRAM__ELEMENTS = OP_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Process Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT_PROCESS_DIAGRAM_FEATURE_COUNT = OP_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Object Process Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT_PROCESS_DIAGRAM_OPERATION_COUNT = OP_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_LINK__SYSTEM = OP_ELEMENT__SYSTEM;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_LINK__SOURCE = OP_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_LINK__TARGET = OP_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_LINK_FEATURE_COUNT = OP_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_LINK_OPERATION_COUNT = OP_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_NODE__SYSTEM = OP_ELEMENT__SYSTEM;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_NODE__NAME = OP_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_NODE__INCOMING_LINKS = OP_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_NODE__OUTGOING_LINKS = OP_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_NODE_FEATURE_COUNT = OP_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_NODE_OPERATION_COUNT = OP_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STATE__SYSTEM = OP_NODE__SYSTEM;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STATE__NAME = OP_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STATE__INCOMING_LINKS = OP_NODE__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STATE__OUTGOING_LINKS = OP_NODE__OUTGOING_LINKS;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STATE_FEATURE_COUNT = OP_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STATE_OPERATION_COUNT = OP_NODE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_THING__SYSTEM = OP_NODE__SYSTEM;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_THING__NAME = OP_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_THING__INCOMING_LINKS = OP_NODE__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_THING__OUTGOING_LINKS = OP_NODE__OUTGOING_LINKS;

	/**
	 * The number of structural features of the '<em>Thing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_THING_FEATURE_COUNT = OP_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Thing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_THING_OPERATION_COUNT = OP_NODE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT__SYSTEM = OP_THING__SYSTEM;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT__NAME = OP_THING__NAME;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT__INCOMING_LINKS = OP_THING__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT__OUTGOING_LINKS = OP_THING__OUTGOING_LINKS;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT_FEATURE_COUNT = OP_THING_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT_OPERATION_COUNT = OP_THING_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCESS__SYSTEM = OP_THING__SYSTEM;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCESS__NAME = OP_THING__NAME;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCESS__INCOMING_LINKS = OP_THING__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCESS__OUTGOING_LINKS = OP_THING__OUTGOING_LINKS;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCESS_FEATURE_COUNT = OP_THING_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCESS_OPERATION_COUNT = OP_THING_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCEDURAL_LINK__SYSTEM = OP_LINK__SYSTEM;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCEDURAL_LINK__SOURCE = OP_LINK__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCEDURAL_LINK__TARGET = OP_LINK__TARGET;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCEDURAL_LINK__KIND = OP_LINK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Procedural Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCEDURAL_LINK_FEATURE_COUNT = OP_LINK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Procedural Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCEDURAL_LINK_OPERATION_COUNT = OP_LINK_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK__SYSTEM = OP_LINK__SYSTEM;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK__SOURCE = OP_LINK__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK__TARGET = OP_LINK__TARGET;

	/**
	 * The number of structural features of the '<em>Structural Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_FEATURE_COUNT = OP_LINK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Structural Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_OPERATION_COUNT = OP_LINK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.impl.OPTaggedLinkImpl <em>Tagged Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.impl.OPTaggedLinkImpl
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPTaggedLink()
	 * @generated
	 */
	int OP_TAGGED_LINK = 11;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_TAGGED_LINK__SYSTEM = OP_LINK__SYSTEM;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_TAGGED_LINK__SOURCE = OP_LINK__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_TAGGED_LINK__TARGET = OP_LINK__TARGET;

	/**
	 * The number of structural features of the '<em>Tagged Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_TAGGED_LINK_FEATURE_COUNT = OP_LINK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tagged Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_TAGGED_LINK_OPERATION_COUNT = OP_LINK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.OPElementView <em>Element View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.OPElementView
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPElementView()
	 * @generated
	 */
	int OP_ELEMENT_VIEW = 12;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_ELEMENT_VIEW__SYSTEM = OP_ELEMENT__SYSTEM;

	/**
	 * The feature id for the '<em><b>Opd</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_ELEMENT_VIEW__OPD = OP_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_ELEMENT_VIEW__MODEL = OP_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Element View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_ELEMENT_VIEW_FEATURE_COUNT = OP_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Element View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_ELEMENT_VIEW_OPERATION_COUNT = OP_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.OPNodeView <em>Node View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.OPNodeView
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPNodeView()
	 * @generated
	 */
	int OP_NODE_VIEW = 13;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_NODE_VIEW__SYSTEM = OP_ELEMENT_VIEW__SYSTEM;

	/**
	 * The feature id for the '<em><b>Opd</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_NODE_VIEW__OPD = OP_ELEMENT_VIEW__OPD;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_NODE_VIEW__MODEL = OP_ELEMENT_VIEW__MODEL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_NODE_VIEW__X = OP_ELEMENT_VIEW_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_NODE_VIEW__Y = OP_ELEMENT_VIEW_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_NODE_VIEW__WIDTH = OP_ELEMENT_VIEW_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_NODE_VIEW__HEIGHT = OP_ELEMENT_VIEW_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_NODE_VIEW__INCOMING_LINKS = OP_ELEMENT_VIEW_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_NODE_VIEW__OUTGOING_LINKS = OP_ELEMENT_VIEW_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Node View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_NODE_VIEW_FEATURE_COUNT = OP_ELEMENT_VIEW_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Node View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_NODE_VIEW_OPERATION_COUNT = OP_ELEMENT_VIEW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.OPThingView <em>Thing View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.OPThingView
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPThingView()
	 * @generated
	 */
	int OP_THING_VIEW = 15;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.impl.OPObjectViewImpl <em>Object View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.impl.OPObjectViewImpl
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPObjectView()
	 * @generated
	 */
	int OP_OBJECT_VIEW = 18;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.impl.OPProcessViewImpl <em>Process View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.impl.OPProcessViewImpl
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPProcessView()
	 * @generated
	 */
	int OP_PROCESS_VIEW = 19;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.impl.OPStateViewImpl <em>State View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.impl.OPStateViewImpl
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPStateView()
	 * @generated
	 */
	int OP_STATE_VIEW = 16;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.OPLinkView <em>Link View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.OPLinkView
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPLinkView()
	 * @generated
	 */
	int OP_LINK_VIEW = 14;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_LINK_VIEW__SYSTEM = OP_ELEMENT_VIEW__SYSTEM;

	/**
	 * The feature id for the '<em><b>Opd</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_LINK_VIEW__OPD = OP_ELEMENT_VIEW__OPD;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_LINK_VIEW__MODEL = OP_ELEMENT_VIEW__MODEL;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_LINK_VIEW__SOURCE = OP_ELEMENT_VIEW_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_LINK_VIEW__TARGET = OP_ELEMENT_VIEW_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Link View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_LINK_VIEW_FEATURE_COUNT = OP_ELEMENT_VIEW_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Link View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_LINK_VIEW_OPERATION_COUNT = OP_ELEMENT_VIEW_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_THING_VIEW__SYSTEM = OP_NODE_VIEW__SYSTEM;

	/**
	 * The feature id for the '<em><b>Opd</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_THING_VIEW__OPD = OP_NODE_VIEW__OPD;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_THING_VIEW__MODEL = OP_NODE_VIEW__MODEL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_THING_VIEW__X = OP_NODE_VIEW__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_THING_VIEW__Y = OP_NODE_VIEW__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_THING_VIEW__WIDTH = OP_NODE_VIEW__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_THING_VIEW__HEIGHT = OP_NODE_VIEW__HEIGHT;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_THING_VIEW__INCOMING_LINKS = OP_NODE_VIEW__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_THING_VIEW__OUTGOING_LINKS = OP_NODE_VIEW__OUTGOING_LINKS;

	/**
	 * The number of structural features of the '<em>Thing View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_THING_VIEW_FEATURE_COUNT = OP_NODE_VIEW_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Thing View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_THING_VIEW_OPERATION_COUNT = OP_NODE_VIEW_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STATE_VIEW__SYSTEM = OP_NODE_VIEW__SYSTEM;

	/**
	 * The feature id for the '<em><b>Opd</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STATE_VIEW__OPD = OP_NODE_VIEW__OPD;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STATE_VIEW__MODEL = OP_NODE_VIEW__MODEL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STATE_VIEW__X = OP_NODE_VIEW__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STATE_VIEW__Y = OP_NODE_VIEW__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STATE_VIEW__WIDTH = OP_NODE_VIEW__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STATE_VIEW__HEIGHT = OP_NODE_VIEW__HEIGHT;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STATE_VIEW__INCOMING_LINKS = OP_NODE_VIEW__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STATE_VIEW__OUTGOING_LINKS = OP_NODE_VIEW__OUTGOING_LINKS;

	/**
	 * The number of structural features of the '<em>State View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STATE_VIEW_FEATURE_COUNT = OP_NODE_VIEW_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>State View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STATE_VIEW_OPERATION_COUNT = OP_NODE_VIEW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.impl.OPProceduralLinkViewImpl <em>Procedural Link View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.impl.OPProceduralLinkViewImpl
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPProceduralLinkView()
	 * @generated
	 */
	int OP_PROCEDURAL_LINK_VIEW = 20;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.impl.OPStructuralLinkPartViewImpl <em>Structural Link Part View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.impl.OPStructuralLinkPartViewImpl
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPStructuralLinkPartView()
	 * @generated
	 */
	int OP_STRUCTURAL_LINK_PART_VIEW = 21;

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see com.vainolo.opm.model.opm.OPElement
	 * @generated
	 */
	EClass getOPElement();

	/**
	 * Returns the meta object for the container reference '{@link com.vainolo.opm.model.opm.OPElement#getSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>System</em>'.
	 * @see com.vainolo.opm.model.opm.OPElement#getSystem()
	 * @see #getOPElement()
	 * @generated
	 */
	EReference getOPElement_System();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see com.vainolo.opm.model.opm.OPLink
	 * @generated
	 */
	EClass getOPLink();

	/**
	 * Returns the meta object for the reference '{@link com.vainolo.opm.model.opm.OPLink#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see com.vainolo.opm.model.opm.OPLink#getSource()
	 * @see #getOPLink()
	 * @generated
	 */
	EReference getOPLink_Source();

	/**
	 * Returns the meta object for the reference '{@link com.vainolo.opm.model.opm.OPLink#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see com.vainolo.opm.model.opm.OPLink#getTarget()
	 * @see #getOPLink()
	 * @generated
	 */
	EReference getOPLink_Target();

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.impl.OPStructuralLinkAggregatorViewImpl <em>Structural Link Aggregator View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.impl.OPStructuralLinkAggregatorViewImpl
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPStructuralLinkAggregatorView()
	 * @generated
	 */
	int OP_STRUCTURAL_LINK_AGGREGATOR_VIEW = 17;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_AGGREGATOR_VIEW__SYSTEM = OP_NODE_VIEW__SYSTEM;

	/**
	 * The feature id for the '<em><b>Opd</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_AGGREGATOR_VIEW__OPD = OP_NODE_VIEW__OPD;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_AGGREGATOR_VIEW__MODEL = OP_NODE_VIEW__MODEL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_AGGREGATOR_VIEW__X = OP_NODE_VIEW__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_AGGREGATOR_VIEW__Y = OP_NODE_VIEW__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_AGGREGATOR_VIEW__WIDTH = OP_NODE_VIEW__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_AGGREGATOR_VIEW__HEIGHT = OP_NODE_VIEW__HEIGHT;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_AGGREGATOR_VIEW__INCOMING_LINKS = OP_NODE_VIEW__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_AGGREGATOR_VIEW__OUTGOING_LINKS = OP_NODE_VIEW__OUTGOING_LINKS;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_AGGREGATOR_VIEW__KIND = OP_NODE_VIEW_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Structural Link Aggregator View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_AGGREGATOR_VIEW_FEATURE_COUNT = OP_NODE_VIEW_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Structural Link Aggregator View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_AGGREGATOR_VIEW_OPERATION_COUNT = OP_NODE_VIEW_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT_VIEW__SYSTEM = OP_THING_VIEW__SYSTEM;

	/**
	 * The feature id for the '<em><b>Opd</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT_VIEW__OPD = OP_THING_VIEW__OPD;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT_VIEW__MODEL = OP_THING_VIEW__MODEL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT_VIEW__X = OP_THING_VIEW__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT_VIEW__Y = OP_THING_VIEW__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT_VIEW__WIDTH = OP_THING_VIEW__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT_VIEW__HEIGHT = OP_THING_VIEW__HEIGHT;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT_VIEW__INCOMING_LINKS = OP_THING_VIEW__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT_VIEW__OUTGOING_LINKS = OP_THING_VIEW__OUTGOING_LINKS;

	/**
	 * The number of structural features of the '<em>Object View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT_VIEW_FEATURE_COUNT = OP_THING_VIEW_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Object View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_OBJECT_VIEW_OPERATION_COUNT = OP_THING_VIEW_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCESS_VIEW__SYSTEM = OP_THING_VIEW__SYSTEM;

	/**
	 * The feature id for the '<em><b>Opd</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCESS_VIEW__OPD = OP_THING_VIEW__OPD;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCESS_VIEW__MODEL = OP_THING_VIEW__MODEL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCESS_VIEW__X = OP_THING_VIEW__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCESS_VIEW__Y = OP_THING_VIEW__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCESS_VIEW__WIDTH = OP_THING_VIEW__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCESS_VIEW__HEIGHT = OP_THING_VIEW__HEIGHT;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCESS_VIEW__INCOMING_LINKS = OP_THING_VIEW__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCESS_VIEW__OUTGOING_LINKS = OP_THING_VIEW__OUTGOING_LINKS;

	/**
	 * The number of structural features of the '<em>Process View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCESS_VIEW_FEATURE_COUNT = OP_THING_VIEW_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Process View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCESS_VIEW_OPERATION_COUNT = OP_THING_VIEW_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCEDURAL_LINK_VIEW__SYSTEM = OP_LINK_VIEW__SYSTEM;

	/**
	 * The feature id for the '<em><b>Opd</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCEDURAL_LINK_VIEW__OPD = OP_LINK_VIEW__OPD;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCEDURAL_LINK_VIEW__MODEL = OP_LINK_VIEW__MODEL;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCEDURAL_LINK_VIEW__SOURCE = OP_LINK_VIEW__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCEDURAL_LINK_VIEW__TARGET = OP_LINK_VIEW__TARGET;

	/**
	 * The number of structural features of the '<em>Procedural Link View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCEDURAL_LINK_VIEW_FEATURE_COUNT = OP_LINK_VIEW_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Procedural Link View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_PROCEDURAL_LINK_VIEW_OPERATION_COUNT = OP_LINK_VIEW_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_PART_VIEW__SYSTEM = OP_LINK_VIEW__SYSTEM;

	/**
	 * The feature id for the '<em><b>Opd</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_PART_VIEW__OPD = OP_LINK_VIEW__OPD;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_PART_VIEW__MODEL = OP_LINK_VIEW__MODEL;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_PART_VIEW__SOURCE = OP_LINK_VIEW__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_PART_VIEW__TARGET = OP_LINK_VIEW__TARGET;

	/**
	 * The number of structural features of the '<em>Structural Link Part View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_PART_VIEW_FEATURE_COUNT = OP_LINK_VIEW_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Structural Link Part View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_STRUCTURAL_LINK_PART_VIEW_OPERATION_COUNT = OP_LINK_VIEW_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.impl.OPTaggedLinkViewImpl <em>Tagged Link View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.impl.OPTaggedLinkViewImpl
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPTaggedLinkView()
	 * @generated
	 */
	int OP_TAGGED_LINK_VIEW = 22;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_TAGGED_LINK_VIEW__SYSTEM = OP_LINK_VIEW__SYSTEM;

	/**
	 * The feature id for the '<em><b>Opd</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_TAGGED_LINK_VIEW__OPD = OP_LINK_VIEW__OPD;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_TAGGED_LINK_VIEW__MODEL = OP_LINK_VIEW__MODEL;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_TAGGED_LINK_VIEW__SOURCE = OP_LINK_VIEW__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_TAGGED_LINK_VIEW__TARGET = OP_LINK_VIEW__TARGET;

	/**
	 * The number of structural features of the '<em>Tagged Link View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_TAGGED_LINK_VIEW_FEATURE_COUNT = OP_LINK_VIEW_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tagged Link View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OP_TAGGED_LINK_VIEW_OPERATION_COUNT = OP_LINK_VIEW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.OPProceduralLinkKind <em>Procedural Link Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.OPProceduralLinkKind
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPProceduralLinkKind()
	 * @generated
	 */
	int OP_PROCEDURAL_LINK_KIND = 23;

	/**
	 * The meta object id for the '{@link com.vainolo.opm.model.opm.OPStructuralLinkKind <em>Structural Link Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vainolo.opm.model.opm.OPStructuralLinkKind
	 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPStructuralLinkKind()
	 * @generated
	 */
	int OP_STRUCTURAL_LINK_KIND = 24;

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see com.vainolo.opm.model.opm.OPObject
	 * @generated
	 */
	EClass getOPObject();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process</em>'.
	 * @see com.vainolo.opm.model.opm.OPProcess
	 * @generated
	 */
	EClass getOPProcess();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPProceduralLink <em>Procedural Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Procedural Link</em>'.
	 * @see com.vainolo.opm.model.opm.OPProceduralLink
	 * @generated
	 */
	EClass getOPProceduralLink();

	/**
	 * Returns the meta object for the attribute '{@link com.vainolo.opm.model.opm.OPProceduralLink#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see com.vainolo.opm.model.opm.OPProceduralLink#getKind()
	 * @see #getOPProceduralLink()
	 * @generated
	 */
	EAttribute getOPProceduralLink_Kind();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPStructuralLink <em>Structural Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Link</em>'.
	 * @see com.vainolo.opm.model.opm.OPStructuralLink
	 * @generated
	 */
	EClass getOPStructuralLink();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPTaggedLink <em>Tagged Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tagged Link</em>'.
	 * @see com.vainolo.opm.model.opm.OPTaggedLink
	 * @generated
	 */
	EClass getOPTaggedLink();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see com.vainolo.opm.model.opm.OPNode
	 * @generated
	 */
	EClass getOPNode();

	/**
	 * Returns the meta object for the attribute '{@link com.vainolo.opm.model.opm.OPNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.vainolo.opm.model.opm.OPNode#getName()
	 * @see #getOPNode()
	 * @generated
	 */
	EAttribute getOPNode_Name();

	/**
	 * Returns the meta object for the reference list '{@link com.vainolo.opm.model.opm.OPNode#getIncomingLinks <em>Incoming Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Links</em>'.
	 * @see com.vainolo.opm.model.opm.OPNode#getIncomingLinks()
	 * @see #getOPNode()
	 * @generated
	 */
	EReference getOPNode_IncomingLinks();

	/**
	 * Returns the meta object for the reference list '{@link com.vainolo.opm.model.opm.OPNode#getOutgoingLinks <em>Outgoing Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Links</em>'.
	 * @see com.vainolo.opm.model.opm.OPNode#getOutgoingLinks()
	 * @see #getOPNode()
	 * @generated
	 */
	EReference getOPNode_OutgoingLinks();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see com.vainolo.opm.model.opm.OPState
	 * @generated
	 */
	EClass getOPState();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPThing <em>Thing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thing</em>'.
	 * @see com.vainolo.opm.model.opm.OPThing
	 * @generated
	 */
	EClass getOPThing();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPObjectProcessDiagram <em>Object Process Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Process Diagram</em>'.
	 * @see com.vainolo.opm.model.opm.OPObjectProcessDiagram
	 * @generated
	 */
	EClass getOPObjectProcessDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vainolo.opm.model.opm.OPObjectProcessDiagram#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see com.vainolo.opm.model.opm.OPObjectProcessDiagram#getElements()
	 * @see #getOPObjectProcessDiagram()
	 * @generated
	 */
	EReference getOPObjectProcessDiagram_Elements();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see com.vainolo.opm.model.opm.OPSystem
	 * @generated
	 */
	EClass getOPSystem();

	/**
	 * Returns the meta object for the reference '{@link com.vainolo.opm.model.opm.OPSystem#getSystemDiagram <em>System Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>System Diagram</em>'.
	 * @see com.vainolo.opm.model.opm.OPSystem#getSystemDiagram()
	 * @see #getOPSystem()
	 * @generated
	 */
	EReference getOPSystem_SystemDiagram();

	/**
	 * Returns the meta object for the attribute '{@link com.vainolo.opm.model.opm.OPSystem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.vainolo.opm.model.opm.OPSystem#getName()
	 * @see #getOPSystem()
	 * @generated
	 */
	EAttribute getOPSystem_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vainolo.opm.model.opm.OPSystem#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see com.vainolo.opm.model.opm.OPSystem#getElements()
	 * @see #getOPSystem()
	 * @generated
	 */
	EReference getOPSystem_Elements();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPObjectView <em>Object View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object View</em>'.
	 * @see com.vainolo.opm.model.opm.OPObjectView
	 * @generated
	 */
	EClass getOPObjectView();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPProcessView <em>Process View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process View</em>'.
	 * @see com.vainolo.opm.model.opm.OPProcessView
	 * @generated
	 */
	EClass getOPProcessView();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPThingView <em>Thing View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thing View</em>'.
	 * @see com.vainolo.opm.model.opm.OPThingView
	 * @generated
	 */
	EClass getOPThingView();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPStateView <em>State View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State View</em>'.
	 * @see com.vainolo.opm.model.opm.OPStateView
	 * @generated
	 */
	EClass getOPStateView();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPNodeView <em>Node View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node View</em>'.
	 * @see com.vainolo.opm.model.opm.OPNodeView
	 * @generated
	 */
	EClass getOPNodeView();

	/**
	 * Returns the meta object for the attribute '{@link com.vainolo.opm.model.opm.OPNodeView#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see com.vainolo.opm.model.opm.OPNodeView#getX()
	 * @see #getOPNodeView()
	 * @generated
	 */
	EAttribute getOPNodeView_X();

	/**
	 * Returns the meta object for the attribute '{@link com.vainolo.opm.model.opm.OPNodeView#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see com.vainolo.opm.model.opm.OPNodeView#getY()
	 * @see #getOPNodeView()
	 * @generated
	 */
	EAttribute getOPNodeView_Y();

	/**
	 * Returns the meta object for the attribute '{@link com.vainolo.opm.model.opm.OPNodeView#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see com.vainolo.opm.model.opm.OPNodeView#getWidth()
	 * @see #getOPNodeView()
	 * @generated
	 */
	EAttribute getOPNodeView_Width();

	/**
	 * Returns the meta object for the attribute '{@link com.vainolo.opm.model.opm.OPNodeView#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see com.vainolo.opm.model.opm.OPNodeView#getHeight()
	 * @see #getOPNodeView()
	 * @generated
	 */
	EAttribute getOPNodeView_Height();

	/**
	 * Returns the meta object for the reference list '{@link com.vainolo.opm.model.opm.OPNodeView#getIncomingLinks <em>Incoming Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Links</em>'.
	 * @see com.vainolo.opm.model.opm.OPNodeView#getIncomingLinks()
	 * @see #getOPNodeView()
	 * @generated
	 */
	EReference getOPNodeView_IncomingLinks();

	/**
	 * Returns the meta object for the reference list '{@link com.vainolo.opm.model.opm.OPNodeView#getOutgoingLinks <em>Outgoing Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Links</em>'.
	 * @see com.vainolo.opm.model.opm.OPNodeView#getOutgoingLinks()
	 * @see #getOPNodeView()
	 * @generated
	 */
	EReference getOPNodeView_OutgoingLinks();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPElementView <em>Element View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element View</em>'.
	 * @see com.vainolo.opm.model.opm.OPElementView
	 * @generated
	 */
	EClass getOPElementView();

	/**
	 * Returns the meta object for the container reference '{@link com.vainolo.opm.model.opm.OPElementView#getOpd <em>Opd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Opd</em>'.
	 * @see com.vainolo.opm.model.opm.OPElementView#getOpd()
	 * @see #getOPElementView()
	 * @generated
	 */
	EReference getOPElementView_Opd();

	/**
	 * Returns the meta object for the reference '{@link com.vainolo.opm.model.opm.OPElementView#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see com.vainolo.opm.model.opm.OPElementView#getModel()
	 * @see #getOPElementView()
	 * @generated
	 */
	EReference getOPElementView_Model();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPLinkView <em>Link View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link View</em>'.
	 * @see com.vainolo.opm.model.opm.OPLinkView
	 * @generated
	 */
	EClass getOPLinkView();

	/**
	 * Returns the meta object for the reference '{@link com.vainolo.opm.model.opm.OPLinkView#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see com.vainolo.opm.model.opm.OPLinkView#getSource()
	 * @see #getOPLinkView()
	 * @generated
	 */
	EReference getOPLinkView_Source();

	/**
	 * Returns the meta object for the reference '{@link com.vainolo.opm.model.opm.OPLinkView#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see com.vainolo.opm.model.opm.OPLinkView#getTarget()
	 * @see #getOPLinkView()
	 * @generated
	 */
	EReference getOPLinkView_Target();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPProceduralLinkView <em>Procedural Link View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Procedural Link View</em>'.
	 * @see com.vainolo.opm.model.opm.OPProceduralLinkView
	 * @generated
	 */
	EClass getOPProceduralLinkView();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPStructuralLinkPartView <em>Structural Link Part View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Link Part View</em>'.
	 * @see com.vainolo.opm.model.opm.OPStructuralLinkPartView
	 * @generated
	 */
	EClass getOPStructuralLinkPartView();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPTaggedLinkView <em>Tagged Link View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tagged Link View</em>'.
	 * @see com.vainolo.opm.model.opm.OPTaggedLinkView
	 * @generated
	 */
	EClass getOPTaggedLinkView();

	/**
	 * Returns the meta object for enum '{@link com.vainolo.opm.model.opm.OPProceduralLinkKind <em>Procedural Link Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Procedural Link Kind</em>'.
	 * @see com.vainolo.opm.model.opm.OPProceduralLinkKind
	 * @generated
	 */
	EEnum getOPProceduralLinkKind();

	/**
	 * Returns the meta object for enum '{@link com.vainolo.opm.model.opm.OPStructuralLinkKind <em>Structural Link Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Structural Link Kind</em>'.
	 * @see com.vainolo.opm.model.opm.OPStructuralLinkKind
	 * @generated
	 */
	EEnum getOPStructuralLinkKind();

	/**
	 * Returns the meta object for class '{@link com.vainolo.opm.model.opm.OPStructuralLinkAggregatorView <em>Structural Link Aggregator View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Link Aggregator View</em>'.
	 * @see com.vainolo.opm.model.opm.OPStructuralLinkAggregatorView
	 * @generated
	 */
	EClass getOPStructuralLinkAggregatorView();

	/**
	 * Returns the meta object for the attribute '{@link com.vainolo.opm.model.opm.OPStructuralLinkAggregatorView#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see com.vainolo.opm.model.opm.OPStructuralLinkAggregatorView#getKind()
	 * @see #getOPStructuralLinkAggregatorView()
	 * @generated
	 */
	EAttribute getOPStructuralLinkAggregatorView_Kind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OPFactory getOPFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.OPElement <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.OPElement
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPElement()
		 * @generated
		 */
		EClass OP_ELEMENT = eINSTANCE.getOPElement();

		/**
		 * The meta object literal for the '<em><b>System</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OP_ELEMENT__SYSTEM = eINSTANCE.getOPElement_System();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.OPLink <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.OPLink
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPLink()
		 * @generated
		 */
		EClass OP_LINK = eINSTANCE.getOPLink();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OP_LINK__SOURCE = eINSTANCE.getOPLink_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OP_LINK__TARGET = eINSTANCE.getOPLink_Target();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.impl.OPObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.impl.OPObjectImpl
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPObject()
		 * @generated
		 */
		EClass OP_OBJECT = eINSTANCE.getOPObject();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.impl.OPProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.impl.OPProcessImpl
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPProcess()
		 * @generated
		 */
		EClass OP_PROCESS = eINSTANCE.getOPProcess();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.impl.OPProceduralLinkImpl <em>Procedural Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.impl.OPProceduralLinkImpl
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPProceduralLink()
		 * @generated
		 */
		EClass OP_PROCEDURAL_LINK = eINSTANCE.getOPProceduralLink();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OP_PROCEDURAL_LINK__KIND = eINSTANCE.getOPProceduralLink_Kind();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.impl.OPStructuralLinkImpl <em>Structural Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.impl.OPStructuralLinkImpl
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPStructuralLink()
		 * @generated
		 */
		EClass OP_STRUCTURAL_LINK = eINSTANCE.getOPStructuralLink();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.impl.OPTaggedLinkImpl <em>Tagged Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.impl.OPTaggedLinkImpl
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPTaggedLink()
		 * @generated
		 */
		EClass OP_TAGGED_LINK = eINSTANCE.getOPTaggedLink();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.OPNode <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.OPNode
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPNode()
		 * @generated
		 */
		EClass OP_NODE = eINSTANCE.getOPNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OP_NODE__NAME = eINSTANCE.getOPNode_Name();

		/**
		 * The meta object literal for the '<em><b>Incoming Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OP_NODE__INCOMING_LINKS = eINSTANCE.getOPNode_IncomingLinks();

		/**
		 * The meta object literal for the '<em><b>Outgoing Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OP_NODE__OUTGOING_LINKS = eINSTANCE.getOPNode_OutgoingLinks();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.impl.OPStateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.impl.OPStateImpl
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPState()
		 * @generated
		 */
		EClass OP_STATE = eINSTANCE.getOPState();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.OPThing <em>Thing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.OPThing
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPThing()
		 * @generated
		 */
		EClass OP_THING = eINSTANCE.getOPThing();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.impl.OPObjectProcessDiagramImpl <em>Object Process Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.impl.OPObjectProcessDiagramImpl
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPObjectProcessDiagram()
		 * @generated
		 */
		EClass OP_OBJECT_PROCESS_DIAGRAM = eINSTANCE.getOPObjectProcessDiagram();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OP_OBJECT_PROCESS_DIAGRAM__ELEMENTS = eINSTANCE.getOPObjectProcessDiagram_Elements();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.impl.OPSystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.impl.OPSystemImpl
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPSystem()
		 * @generated
		 */
		EClass OP_SYSTEM = eINSTANCE.getOPSystem();

		/**
		 * The meta object literal for the '<em><b>System Diagram</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OP_SYSTEM__SYSTEM_DIAGRAM = eINSTANCE.getOPSystem_SystemDiagram();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OP_SYSTEM__NAME = eINSTANCE.getOPSystem_Name();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OP_SYSTEM__ELEMENTS = eINSTANCE.getOPSystem_Elements();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.impl.OPObjectViewImpl <em>Object View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.impl.OPObjectViewImpl
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPObjectView()
		 * @generated
		 */
		EClass OP_OBJECT_VIEW = eINSTANCE.getOPObjectView();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.impl.OPProcessViewImpl <em>Process View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.impl.OPProcessViewImpl
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPProcessView()
		 * @generated
		 */
		EClass OP_PROCESS_VIEW = eINSTANCE.getOPProcessView();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.OPThingView <em>Thing View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.OPThingView
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPThingView()
		 * @generated
		 */
		EClass OP_THING_VIEW = eINSTANCE.getOPThingView();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.impl.OPStateViewImpl <em>State View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.impl.OPStateViewImpl
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPStateView()
		 * @generated
		 */
		EClass OP_STATE_VIEW = eINSTANCE.getOPStateView();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.OPNodeView <em>Node View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.OPNodeView
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPNodeView()
		 * @generated
		 */
		EClass OP_NODE_VIEW = eINSTANCE.getOPNodeView();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OP_NODE_VIEW__X = eINSTANCE.getOPNodeView_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OP_NODE_VIEW__Y = eINSTANCE.getOPNodeView_Y();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OP_NODE_VIEW__WIDTH = eINSTANCE.getOPNodeView_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OP_NODE_VIEW__HEIGHT = eINSTANCE.getOPNodeView_Height();

		/**
		 * The meta object literal for the '<em><b>Incoming Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OP_NODE_VIEW__INCOMING_LINKS = eINSTANCE.getOPNodeView_IncomingLinks();

		/**
		 * The meta object literal for the '<em><b>Outgoing Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OP_NODE_VIEW__OUTGOING_LINKS = eINSTANCE.getOPNodeView_OutgoingLinks();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.OPElementView <em>Element View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.OPElementView
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPElementView()
		 * @generated
		 */
		EClass OP_ELEMENT_VIEW = eINSTANCE.getOPElementView();

		/**
		 * The meta object literal for the '<em><b>Opd</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OP_ELEMENT_VIEW__OPD = eINSTANCE.getOPElementView_Opd();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OP_ELEMENT_VIEW__MODEL = eINSTANCE.getOPElementView_Model();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.OPLinkView <em>Link View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.OPLinkView
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPLinkView()
		 * @generated
		 */
		EClass OP_LINK_VIEW = eINSTANCE.getOPLinkView();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OP_LINK_VIEW__SOURCE = eINSTANCE.getOPLinkView_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OP_LINK_VIEW__TARGET = eINSTANCE.getOPLinkView_Target();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.impl.OPProceduralLinkViewImpl <em>Procedural Link View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.impl.OPProceduralLinkViewImpl
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPProceduralLinkView()
		 * @generated
		 */
		EClass OP_PROCEDURAL_LINK_VIEW = eINSTANCE.getOPProceduralLinkView();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.impl.OPStructuralLinkPartViewImpl <em>Structural Link Part View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.impl.OPStructuralLinkPartViewImpl
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPStructuralLinkPartView()
		 * @generated
		 */
		EClass OP_STRUCTURAL_LINK_PART_VIEW = eINSTANCE.getOPStructuralLinkPartView();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.impl.OPTaggedLinkViewImpl <em>Tagged Link View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.impl.OPTaggedLinkViewImpl
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPTaggedLinkView()
		 * @generated
		 */
		EClass OP_TAGGED_LINK_VIEW = eINSTANCE.getOPTaggedLinkView();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.OPProceduralLinkKind <em>Procedural Link Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.OPProceduralLinkKind
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPProceduralLinkKind()
		 * @generated
		 */
		EEnum OP_PROCEDURAL_LINK_KIND = eINSTANCE.getOPProceduralLinkKind();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.OPStructuralLinkKind <em>Structural Link Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.OPStructuralLinkKind
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPStructuralLinkKind()
		 * @generated
		 */
		EEnum OP_STRUCTURAL_LINK_KIND = eINSTANCE.getOPStructuralLinkKind();

		/**
		 * The meta object literal for the '{@link com.vainolo.opm.model.opm.impl.OPStructuralLinkAggregatorViewImpl <em>Structural Link Aggregator View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vainolo.opm.model.opm.impl.OPStructuralLinkAggregatorViewImpl
		 * @see com.vainolo.opm.model.opm.impl.OPPackageImpl#getOPStructuralLinkAggregatorView()
		 * @generated
		 */
		EClass OP_STRUCTURAL_LINK_AGGREGATOR_VIEW = eINSTANCE.getOPStructuralLinkAggregatorView();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OP_STRUCTURAL_LINK_AGGREGATOR_VIEW__KIND = eINSTANCE.getOPStructuralLinkAggregatorView_Kind();

	}

} //OPPackage
