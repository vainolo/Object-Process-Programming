/**
 */
package com.vainolo.opm.model.opm.impl;

import com.vainolo.opm.model.opm.OPElement;
import com.vainolo.opm.model.opm.OPElementView;
import com.vainolo.opm.model.opm.OPFactory;
import com.vainolo.opm.model.opm.OPLink;
import com.vainolo.opm.model.opm.OPLinkView;
import com.vainolo.opm.model.opm.OPNode;
import com.vainolo.opm.model.opm.OPNodeView;
import com.vainolo.opm.model.opm.OPObject;
import com.vainolo.opm.model.opm.OPObjectProcessDiagram;
import com.vainolo.opm.model.opm.OPObjectView;
import com.vainolo.opm.model.opm.OPPackage;
import com.vainolo.opm.model.opm.OPProceduralLink;
import com.vainolo.opm.model.opm.OPProceduralLinkKind;
import com.vainolo.opm.model.opm.OPProceduralLinkView;
import com.vainolo.opm.model.opm.OPProcess;
import com.vainolo.opm.model.opm.OPProcessView;
import com.vainolo.opm.model.opm.OPState;
import com.vainolo.opm.model.opm.OPStateView;
import com.vainolo.opm.model.opm.OPStructuralLink;
import com.vainolo.opm.model.opm.OPStructuralLinkAggregatorView;
import com.vainolo.opm.model.opm.OPStructuralLinkKind;
import com.vainolo.opm.model.opm.OPStructuralLinkPartView;
import com.vainolo.opm.model.opm.OPSystem;
import com.vainolo.opm.model.opm.OPTaggedLink;
import com.vainolo.opm.model.opm.OPTaggedLinkView;
import com.vainolo.opm.model.opm.OPThing;
import com.vainolo.opm.model.opm.OPThingView;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OPPackageImpl extends EPackageImpl implements OPPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opProceduralLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opStructuralLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opTaggedLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opThingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opObjectProcessDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opObjectViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opProcessViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opThingViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opStateViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opNodeViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opElementViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opLinkViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opProceduralLinkViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opStructuralLinkPartViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opTaggedLinkViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum opProceduralLinkKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum opStructuralLinkKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opStructuralLinkAggregatorViewEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.vainolo.opm.model.opm.OPPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OPPackageImpl() {
		super(eNS_URI, OPFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link OPPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OPPackage init() {
		if (isInited) return (OPPackage)EPackage.Registry.INSTANCE.getEPackage(OPPackage.eNS_URI);

		// Obtain or create and register package
		OPPackageImpl theOPPackage = (OPPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OPPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OPPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theOPPackage.createPackageContents();

		// Initialize created meta-data
		theOPPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOPPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OPPackage.eNS_URI, theOPPackage);
		return theOPPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPElement() {
		return opElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPElement_System() {
		return (EReference)opElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPLink() {
		return opLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPLink_Source() {
		return (EReference)opLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPLink_Target() {
		return (EReference)opLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPObject() {
		return opObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPProcess() {
		return opProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPProceduralLink() {
		return opProceduralLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOPProceduralLink_Kind() {
		return (EAttribute)opProceduralLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPStructuralLink() {
		return opStructuralLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPTaggedLink() {
		return opTaggedLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPNode() {
		return opNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOPNode_Name() {
		return (EAttribute)opNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPNode_IncomingLinks() {
		return (EReference)opNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPNode_OutgoingLinks() {
		return (EReference)opNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPState() {
		return opStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPThing() {
		return opThingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPObjectProcessDiagram() {
		return opObjectProcessDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPObjectProcessDiagram_Elements() {
		return (EReference)opObjectProcessDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPSystem() {
		return opSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPSystem_SystemDiagram() {
		return (EReference)opSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOPSystem_Name() {
		return (EAttribute)opSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPSystem_Elements() {
		return (EReference)opSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPObjectView() {
		return opObjectViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPProcessView() {
		return opProcessViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPThingView() {
		return opThingViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPStateView() {
		return opStateViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPNodeView() {
		return opNodeViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOPNodeView_X() {
		return (EAttribute)opNodeViewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOPNodeView_Y() {
		return (EAttribute)opNodeViewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOPNodeView_Width() {
		return (EAttribute)opNodeViewEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOPNodeView_Height() {
		return (EAttribute)opNodeViewEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPNodeView_IncomingLinks() {
		return (EReference)opNodeViewEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPNodeView_OutgoingLinks() {
		return (EReference)opNodeViewEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPElementView() {
		return opElementViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPElementView_Opd() {
		return (EReference)opElementViewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPElementView_Model() {
		return (EReference)opElementViewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPLinkView() {
		return opLinkViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPLinkView_Source() {
		return (EReference)opLinkViewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPLinkView_Target() {
		return (EReference)opLinkViewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPProceduralLinkView() {
		return opProceduralLinkViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPStructuralLinkPartView() {
		return opStructuralLinkPartViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPTaggedLinkView() {
		return opTaggedLinkViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOPProceduralLinkKind() {
		return opProceduralLinkKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOPStructuralLinkKind() {
		return opStructuralLinkKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPStructuralLinkAggregatorView() {
		return opStructuralLinkAggregatorViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOPStructuralLinkAggregatorView_Kind() {
		return (EAttribute)opStructuralLinkAggregatorViewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPFactory getOPFactory() {
		return (OPFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		opElementEClass = createEClass(OP_ELEMENT);
		createEReference(opElementEClass, OP_ELEMENT__SYSTEM);

		opSystemEClass = createEClass(OP_SYSTEM);
		createEReference(opSystemEClass, OP_SYSTEM__SYSTEM_DIAGRAM);
		createEAttribute(opSystemEClass, OP_SYSTEM__NAME);
		createEReference(opSystemEClass, OP_SYSTEM__ELEMENTS);

		opObjectProcessDiagramEClass = createEClass(OP_OBJECT_PROCESS_DIAGRAM);
		createEReference(opObjectProcessDiagramEClass, OP_OBJECT_PROCESS_DIAGRAM__ELEMENTS);

		opLinkEClass = createEClass(OP_LINK);
		createEReference(opLinkEClass, OP_LINK__SOURCE);
		createEReference(opLinkEClass, OP_LINK__TARGET);

		opNodeEClass = createEClass(OP_NODE);
		createEAttribute(opNodeEClass, OP_NODE__NAME);
		createEReference(opNodeEClass, OP_NODE__INCOMING_LINKS);
		createEReference(opNodeEClass, OP_NODE__OUTGOING_LINKS);

		opStateEClass = createEClass(OP_STATE);

		opThingEClass = createEClass(OP_THING);

		opObjectEClass = createEClass(OP_OBJECT);

		opProcessEClass = createEClass(OP_PROCESS);

		opProceduralLinkEClass = createEClass(OP_PROCEDURAL_LINK);
		createEAttribute(opProceduralLinkEClass, OP_PROCEDURAL_LINK__KIND);

		opStructuralLinkEClass = createEClass(OP_STRUCTURAL_LINK);

		opTaggedLinkEClass = createEClass(OP_TAGGED_LINK);

		opElementViewEClass = createEClass(OP_ELEMENT_VIEW);
		createEReference(opElementViewEClass, OP_ELEMENT_VIEW__OPD);
		createEReference(opElementViewEClass, OP_ELEMENT_VIEW__MODEL);

		opNodeViewEClass = createEClass(OP_NODE_VIEW);
		createEAttribute(opNodeViewEClass, OP_NODE_VIEW__X);
		createEAttribute(opNodeViewEClass, OP_NODE_VIEW__Y);
		createEAttribute(opNodeViewEClass, OP_NODE_VIEW__WIDTH);
		createEAttribute(opNodeViewEClass, OP_NODE_VIEW__HEIGHT);
		createEReference(opNodeViewEClass, OP_NODE_VIEW__INCOMING_LINKS);
		createEReference(opNodeViewEClass, OP_NODE_VIEW__OUTGOING_LINKS);

		opLinkViewEClass = createEClass(OP_LINK_VIEW);
		createEReference(opLinkViewEClass, OP_LINK_VIEW__SOURCE);
		createEReference(opLinkViewEClass, OP_LINK_VIEW__TARGET);

		opThingViewEClass = createEClass(OP_THING_VIEW);

		opStateViewEClass = createEClass(OP_STATE_VIEW);

		opStructuralLinkAggregatorViewEClass = createEClass(OP_STRUCTURAL_LINK_AGGREGATOR_VIEW);
		createEAttribute(opStructuralLinkAggregatorViewEClass, OP_STRUCTURAL_LINK_AGGREGATOR_VIEW__KIND);

		opObjectViewEClass = createEClass(OP_OBJECT_VIEW);

		opProcessViewEClass = createEClass(OP_PROCESS_VIEW);

		opProceduralLinkViewEClass = createEClass(OP_PROCEDURAL_LINK_VIEW);

		opStructuralLinkPartViewEClass = createEClass(OP_STRUCTURAL_LINK_PART_VIEW);

		opTaggedLinkViewEClass = createEClass(OP_TAGGED_LINK_VIEW);

		// Create enums
		opProceduralLinkKindEEnum = createEEnum(OP_PROCEDURAL_LINK_KIND);
		opStructuralLinkKindEEnum = createEEnum(OP_STRUCTURAL_LINK_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		opObjectProcessDiagramEClass.getESuperTypes().add(this.getOPElement());
		opLinkEClass.getESuperTypes().add(this.getOPElement());
		opNodeEClass.getESuperTypes().add(this.getOPElement());
		opStateEClass.getESuperTypes().add(this.getOPNode());
		opThingEClass.getESuperTypes().add(this.getOPNode());
		opObjectEClass.getESuperTypes().add(this.getOPThing());
		opProcessEClass.getESuperTypes().add(this.getOPThing());
		opProceduralLinkEClass.getESuperTypes().add(this.getOPLink());
		opStructuralLinkEClass.getESuperTypes().add(this.getOPLink());
		opTaggedLinkEClass.getESuperTypes().add(this.getOPLink());
		opElementViewEClass.getESuperTypes().add(this.getOPElement());
		opNodeViewEClass.getESuperTypes().add(this.getOPElementView());
		opLinkViewEClass.getESuperTypes().add(this.getOPElementView());
		opThingViewEClass.getESuperTypes().add(this.getOPNodeView());
		opStateViewEClass.getESuperTypes().add(this.getOPNodeView());
		opStructuralLinkAggregatorViewEClass.getESuperTypes().add(this.getOPNodeView());
		opObjectViewEClass.getESuperTypes().add(this.getOPThingView());
		opProcessViewEClass.getESuperTypes().add(this.getOPThingView());
		opProceduralLinkViewEClass.getESuperTypes().add(this.getOPLinkView());
		opStructuralLinkPartViewEClass.getESuperTypes().add(this.getOPLinkView());
		opTaggedLinkViewEClass.getESuperTypes().add(this.getOPLinkView());

		// Initialize classes, features, and operations; add parameters
		initEClass(opElementEClass, OPElement.class, "OPElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOPElement_System(), this.getOPSystem(), this.getOPSystem_Elements(), "system", null, 0, 1, OPElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(opSystemEClass, OPSystem.class, "OPSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOPSystem_SystemDiagram(), this.getOPObjectProcessDiagram(), null, "systemDiagram", null, 0, 1, OPSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOPSystem_Name(), ecorePackage.getEString(), "name", null, 0, 1, OPSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOPSystem_Elements(), this.getOPElement(), this.getOPElement_System(), "elements", null, 0, -1, OPSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(opObjectProcessDiagramEClass, OPObjectProcessDiagram.class, "OPObjectProcessDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOPObjectProcessDiagram_Elements(), this.getOPElementView(), this.getOPElementView_Opd(), "elements", null, 0, -1, OPObjectProcessDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(opLinkEClass, OPLink.class, "OPLink", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOPLink_Source(), this.getOPNode(), this.getOPNode_OutgoingLinks(), "source", null, 0, 1, OPLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOPLink_Target(), this.getOPNode(), this.getOPNode_IncomingLinks(), "target", null, 0, 1, OPLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(opNodeEClass, OPNode.class, "OPNode", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOPNode_Name(), ecorePackage.getEString(), "name", null, 0, 1, OPNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOPNode_IncomingLinks(), this.getOPLink(), this.getOPLink_Target(), "incomingLinks", null, 0, -1, OPNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOPNode_OutgoingLinks(), this.getOPLink(), this.getOPLink_Source(), "outgoingLinks", null, 0, -1, OPNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(opStateEClass, OPState.class, "OPState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(opThingEClass, OPThing.class, "OPThing", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(opObjectEClass, OPObject.class, "OPObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(opProcessEClass, OPProcess.class, "OPProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(opProceduralLinkEClass, OPProceduralLink.class, "OPProceduralLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOPProceduralLink_Kind(), this.getOPProceduralLinkKind(), "kind", null, 0, 1, OPProceduralLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(opStructuralLinkEClass, OPStructuralLink.class, "OPStructuralLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(opTaggedLinkEClass, OPTaggedLink.class, "OPTaggedLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(opElementViewEClass, OPElementView.class, "OPElementView", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOPElementView_Opd(), this.getOPObjectProcessDiagram(), this.getOPObjectProcessDiagram_Elements(), "opd", null, 0, 1, OPElementView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOPElementView_Model(), this.getOPElement(), null, "model", null, 0, 1, OPElementView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(opNodeViewEClass, OPNodeView.class, "OPNodeView", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOPNodeView_X(), ecorePackage.getEInt(), "x", null, 0, 1, OPNodeView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOPNodeView_Y(), ecorePackage.getEInt(), "y", null, 0, 1, OPNodeView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOPNodeView_Width(), ecorePackage.getEInt(), "width", null, 0, 1, OPNodeView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOPNodeView_Height(), ecorePackage.getEInt(), "height", null, 0, 1, OPNodeView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOPNodeView_IncomingLinks(), this.getOPLinkView(), this.getOPLinkView_Target(), "incomingLinks", null, 0, -1, OPNodeView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOPNodeView_OutgoingLinks(), this.getOPLinkView(), this.getOPLinkView_Source(), "outgoingLinks", null, 0, -1, OPNodeView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(opLinkViewEClass, OPLinkView.class, "OPLinkView", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOPLinkView_Source(), this.getOPNodeView(), this.getOPNodeView_OutgoingLinks(), "source", null, 0, 1, OPLinkView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOPLinkView_Target(), this.getOPNodeView(), this.getOPNodeView_IncomingLinks(), "target", null, 0, 1, OPLinkView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(opThingViewEClass, OPThingView.class, "OPThingView", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(opStateViewEClass, OPStateView.class, "OPStateView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(opStructuralLinkAggregatorViewEClass, OPStructuralLinkAggregatorView.class, "OPStructuralLinkAggregatorView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOPStructuralLinkAggregatorView_Kind(), this.getOPStructuralLinkKind(), "kind", null, 0, 1, OPStructuralLinkAggregatorView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(opObjectViewEClass, OPObjectView.class, "OPObjectView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(opProcessViewEClass, OPProcessView.class, "OPProcessView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(opProceduralLinkViewEClass, OPProceduralLinkView.class, "OPProceduralLinkView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(opStructuralLinkPartViewEClass, OPStructuralLinkPartView.class, "OPStructuralLinkPartView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(opTaggedLinkViewEClass, OPTaggedLinkView.class, "OPTaggedLinkView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(opProceduralLinkKindEEnum, OPProceduralLinkKind.class, "OPProceduralLinkKind");
		addEEnumLiteral(opProceduralLinkKindEEnum, OPProceduralLinkKind.INSTRUMENT);
		addEEnumLiteral(opProceduralLinkKindEEnum, OPProceduralLinkKind.AGENT);
		addEEnumLiteral(opProceduralLinkKindEEnum, OPProceduralLinkKind.CONSUMPTION);
		addEEnumLiteral(opProceduralLinkKindEEnum, OPProceduralLinkKind.RESULT);

		initEEnum(opStructuralLinkKindEEnum, OPStructuralLinkKind.class, "OPStructuralLinkKind");
		addEEnumLiteral(opStructuralLinkKindEEnum, OPStructuralLinkKind.AGGREGATION);
		addEEnumLiteral(opStructuralLinkKindEEnum, OPStructuralLinkKind.EXHIBITION);

		// Create resource
		createResource(eNS_URI);
	}

} //OPPackageImpl
