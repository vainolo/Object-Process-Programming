/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model.impl;

import com.vainolo.phd.opm.model.Link;
import com.vainolo.phd.opm.model.NamedElement;
import com.vainolo.phd.opm.model.Node;
import com.vainolo.phd.opm.model.NodeContainer;
import com.vainolo.phd.opm.model.OPMAgentLink;
import com.vainolo.phd.opm.model.OPMAggregationLinkAggregator;
import com.vainolo.phd.opm.model.OPMConsumptionLink;
import com.vainolo.phd.opm.model.OPMEffectLink;
import com.vainolo.phd.opm.model.OPMExhibitionLinkAggregator;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMGeneralizationLinkAggregator;
import com.vainolo.phd.opm.model.OPMInstrumentLink;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMPackage;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMResultLink;
import com.vainolo.phd.opm.model.OPMState;
import com.vainolo.phd.opm.model.OPMStructuralLink;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregator;
import com.vainolo.phd.opm.model.OPMThing;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OPMPackageImpl extends EPackageImpl implements OPMPackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass opmObjectProcessDiagramEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass opmObjectEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass opmProcessEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass opmThingEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass opmProceduralLinkEClass = null;

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass opmAgentLinkEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass opmInstrumentLinkEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass opmConsumptionLinkEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass opmResultLinkEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass opmEffectLinkEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass opmStructuralLinkEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass namedElementEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass opmStructuralLinkAggregatorEClass = null;

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass opmAggregationLinkAggregatorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass opmExhibitionLinkAggregatorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass opmGeneralizationLinkAggregatorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass opmStateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass nodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass nodeContainerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass linkEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType rectangleEDataType = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType pointEDataType = null;

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
     * @see com.vainolo.phd.opm.model.OPMPackage#eNS_URI
     * @see #init()
     * @generated
     */
	private OPMPackageImpl() {
        super(eNS_URI, OPMFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link OPMPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static OPMPackage init() {
        if (isInited) return (OPMPackage)EPackage.Registry.INSTANCE.getEPackage(OPMPackage.eNS_URI);

        // Obtain or create and register package
        OPMPackageImpl theOPMPackage = (OPMPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OPMPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OPMPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theOPMPackage.createPackageContents();

        // Initialize created meta-data
        theOPMPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theOPMPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(OPMPackage.eNS_URI, theOPMPackage);
        return theOPMPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOPMObjectProcessDiagram() {
        return opmObjectProcessDiagramEClass;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOPMObjectProcessDiagram_Links() {
        return (EReference)opmObjectProcessDiagramEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOPMObject() {
        return opmObjectEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOPMProcess() {
        return opmProcessEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOPMThing() {
        return opmThingEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOPMProceduralLink() {
        return opmProceduralLinkEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getOPMProceduralLink_Bendpoints() {
        return (EAttribute)opmProceduralLinkEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOPMAgentLink() {
        return opmAgentLinkEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOPMInstrumentLink() {
        return opmInstrumentLinkEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOPMConsumptionLink() {
        return opmConsumptionLinkEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOPMResultLink() {
        return opmResultLinkEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOPMEffectLink() {
        return opmEffectLinkEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOPMStructuralLink() {
        return opmStructuralLinkEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNamedElement() {
        return namedElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNamedElement_Name() {
        return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOPMStructuralLinkAggregator() {
        return opmStructuralLinkAggregatorEClass;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOPMAggregationLinkAggregator() {
        return opmAggregationLinkAggregatorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOPMExhibitionLinkAggregator() {
        return opmExhibitionLinkAggregatorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOPMGeneralizationLinkAggregator() {
        return opmGeneralizationLinkAggregatorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOPMState() {
        return opmStateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNode() {
        return nodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getNode_IncomingLinks() {
        return (EReference)nodeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getNode_OutgoingLinks() {
        return (EReference)nodeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNode_Constraints() {
        return (EAttribute)nodeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getNode_Parent() {
        return (EReference)nodeEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNodeContainer() {
        return nodeContainerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getNodeContainer_Nodes() {
        return (EReference)nodeContainerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLink() {
        return linkEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLink_Source() {
        return (EReference)linkEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLink_Target() {
        return (EReference)linkEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLink_Opd() {
        return (EReference)linkEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getRectangle() {
        return rectangleEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getPoint() {
        return pointEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OPMFactory getOPMFactory() {
        return (OPMFactory)getEFactoryInstance();
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
        namedElementEClass = createEClass(NAMED_ELEMENT);
        createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

        nodeEClass = createEClass(NODE);
        createEReference(nodeEClass, NODE__INCOMING_LINKS);
        createEReference(nodeEClass, NODE__OUTGOING_LINKS);
        createEAttribute(nodeEClass, NODE__CONSTRAINTS);
        createEReference(nodeEClass, NODE__PARENT);

        nodeContainerEClass = createEClass(NODE_CONTAINER);
        createEReference(nodeContainerEClass, NODE_CONTAINER__NODES);

        opmObjectProcessDiagramEClass = createEClass(OPM_OBJECT_PROCESS_DIAGRAM);
        createEReference(opmObjectProcessDiagramEClass, OPM_OBJECT_PROCESS_DIAGRAM__LINKS);

        opmStateEClass = createEClass(OPM_STATE);

        opmThingEClass = createEClass(OPM_THING);

        opmObjectEClass = createEClass(OPM_OBJECT);

        opmProcessEClass = createEClass(OPM_PROCESS);

        opmStructuralLinkAggregatorEClass = createEClass(OPM_STRUCTURAL_LINK_AGGREGATOR);

        opmAggregationLinkAggregatorEClass = createEClass(OPM_AGGREGATION_LINK_AGGREGATOR);

        opmExhibitionLinkAggregatorEClass = createEClass(OPM_EXHIBITION_LINK_AGGREGATOR);

        opmGeneralizationLinkAggregatorEClass = createEClass(OPM_GENERALIZATION_LINK_AGGREGATOR);

        linkEClass = createEClass(LINK);
        createEReference(linkEClass, LINK__SOURCE);
        createEReference(linkEClass, LINK__TARGET);
        createEReference(linkEClass, LINK__OPD);

        opmProceduralLinkEClass = createEClass(OPM_PROCEDURAL_LINK);
        createEAttribute(opmProceduralLinkEClass, OPM_PROCEDURAL_LINK__BENDPOINTS);

        opmAgentLinkEClass = createEClass(OPM_AGENT_LINK);

        opmInstrumentLinkEClass = createEClass(OPM_INSTRUMENT_LINK);

        opmConsumptionLinkEClass = createEClass(OPM_CONSUMPTION_LINK);

        opmResultLinkEClass = createEClass(OPM_RESULT_LINK);

        opmEffectLinkEClass = createEClass(OPM_EFFECT_LINK);

        opmStructuralLinkEClass = createEClass(OPM_STRUCTURAL_LINK);

        // Create data types
        rectangleEDataType = createEDataType(RECTANGLE);
        pointEDataType = createEDataType(POINT);
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
        opmObjectProcessDiagramEClass.getESuperTypes().add(this.getNodeContainer());
        opmStateEClass.getESuperTypes().add(this.getNode());
        opmStateEClass.getESuperTypes().add(this.getNamedElement());
        opmThingEClass.getESuperTypes().add(this.getNode());
        opmThingEClass.getESuperTypes().add(this.getNamedElement());
        opmThingEClass.getESuperTypes().add(this.getNodeContainer());
        opmObjectEClass.getESuperTypes().add(this.getOPMThing());
        opmProcessEClass.getESuperTypes().add(this.getOPMThing());
        opmStructuralLinkAggregatorEClass.getESuperTypes().add(this.getNode());
        opmAggregationLinkAggregatorEClass.getESuperTypes().add(this.getOPMStructuralLinkAggregator());
        opmExhibitionLinkAggregatorEClass.getESuperTypes().add(this.getOPMStructuralLinkAggregator());
        opmGeneralizationLinkAggregatorEClass.getESuperTypes().add(this.getOPMStructuralLinkAggregator());
        opmProceduralLinkEClass.getESuperTypes().add(this.getLink());
        opmAgentLinkEClass.getESuperTypes().add(this.getOPMProceduralLink());
        opmInstrumentLinkEClass.getESuperTypes().add(this.getOPMProceduralLink());
        opmConsumptionLinkEClass.getESuperTypes().add(this.getOPMProceduralLink());
        opmResultLinkEClass.getESuperTypes().add(this.getOPMProceduralLink());
        opmEffectLinkEClass.getESuperTypes().add(this.getOPMProceduralLink());
        opmStructuralLinkEClass.getESuperTypes().add(this.getLink());

        // Initialize classes and features; add operations and parameters
        initEClass(namedElementEClass, NamedElement.class, "NamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(nodeEClass, Node.class, "Node", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getNode_IncomingLinks(), this.getLink(), this.getLink_Target(), "incomingLinks", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNode_OutgoingLinks(), this.getLink(), this.getLink_Source(), "outgoingLinks", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNode_Constraints(), this.getRectangle(), "constraints", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNode_Parent(), this.getNodeContainer(), this.getNodeContainer_Nodes(), "parent", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(nodeContainerEClass, NodeContainer.class, "NodeContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getNodeContainer_Nodes(), this.getNode(), this.getNode_Parent(), "nodes", null, 0, -1, NodeContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(opmObjectProcessDiagramEClass, OPMObjectProcessDiagram.class, "OPMObjectProcessDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOPMObjectProcessDiagram_Links(), this.getLink(), this.getLink_Opd(), "links", null, 0, -1, OPMObjectProcessDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(opmStateEClass, OPMState.class, "OPMState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(opmThingEClass, OPMThing.class, "OPMThing", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(opmObjectEClass, OPMObject.class, "OPMObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(opmProcessEClass, OPMProcess.class, "OPMProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(opmStructuralLinkAggregatorEClass, OPMStructuralLinkAggregator.class, "OPMStructuralLinkAggregator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(opmAggregationLinkAggregatorEClass, OPMAggregationLinkAggregator.class, "OPMAggregationLinkAggregator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(opmExhibitionLinkAggregatorEClass, OPMExhibitionLinkAggregator.class, "OPMExhibitionLinkAggregator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(opmGeneralizationLinkAggregatorEClass, OPMGeneralizationLinkAggregator.class, "OPMGeneralizationLinkAggregator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(linkEClass, Link.class, "Link", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getLink_Source(), this.getNode(), this.getNode_OutgoingLinks(), "source", null, 1, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getLink_Target(), this.getNode(), this.getNode_IncomingLinks(), "target", null, 1, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getLink_Opd(), this.getOPMObjectProcessDiagram(), this.getOPMObjectProcessDiagram_Links(), "opd", null, 1, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(opmProceduralLinkEClass, OPMProceduralLink.class, "OPMProceduralLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getOPMProceduralLink_Bendpoints(), this.getPoint(), "bendpoints", null, 0, -1, OPMProceduralLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(opmAgentLinkEClass, OPMAgentLink.class, "OPMAgentLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(opmInstrumentLinkEClass, OPMInstrumentLink.class, "OPMInstrumentLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(opmConsumptionLinkEClass, OPMConsumptionLink.class, "OPMConsumptionLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(opmResultLinkEClass, OPMResultLink.class, "OPMResultLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(opmEffectLinkEClass, OPMEffectLink.class, "OPMEffectLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(opmStructuralLinkEClass, OPMStructuralLink.class, "OPMStructuralLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        // Initialize data types
        initEDataType(rectangleEDataType, Rectangle.class, "Rectangle", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(pointEDataType, Point.class, "Point", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} //OPMPackageImpl
