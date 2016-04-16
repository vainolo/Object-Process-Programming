/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 */
package com.vainolo.phd.opp.model.impl;

import com.vainolo.phd.opp.model.OPPContainer;
import com.vainolo.phd.opp.model.OPPElement;
import com.vainolo.phd.opp.model.OPPElementWithID;
import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPLabel;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPLinkRouterKind;
import com.vainolo.phd.opp.model.OPPNamedElement;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPObjectKind;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind;
import com.vainolo.phd.opp.model.OPPPackage;
import com.vainolo.phd.opp.model.OPPPoint;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProceduralLinkKind;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPProcessKind;
import com.vainolo.phd.opp.model.OPPState;
import com.vainolo.phd.opp.model.OPPStructuralLinkAggregator;
import com.vainolo.phd.opp.model.OPPStructuralLinkAggregatorKind;
import com.vainolo.phd.opp.model.OPPStructuralLinkPart;
import com.vainolo.phd.opp.model.OPPThing;
import com.vainolo.phd.opp.model.OPPVerticalAlignment;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OPPPackageImpl extends EPackageImpl implements OPPPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass oppElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass oppNamedElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass oppContainerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass oppNodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass oppObjectProcessDiagramEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass oppThingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass oppStateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass oppObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass oppProcessEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass oppStructuralLinkAggregatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass oppLinkEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass oppProceduralLinkEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass oppStructuralLinkPartEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass oppLabelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass oppPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum oppStructuralLinkAggregatorKindEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum oppProceduralLinkKindEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum oppProcessKindEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum oppObjectProcessDiagramKindEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum oppVerticalAlignmentEEnum = null;

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
   * @see com.vainolo.phd.opp.model.OPPPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private OPPPackageImpl() {
    super(eNS_URI, OPPFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link OPPPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static OPPPackage init() {
    if (isInited) return (OPPPackage)EPackage.Registry.INSTANCE.getEPackage(OPPPackage.eNS_URI);

    // Obtain or create and register package
    OPPPackageImpl theOPPPackage = (OPPPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OPPPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OPPPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theOPPPackage.createPackageContents();

    // Initialize created meta-data
    theOPPPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theOPPPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(OPPPackage.eNS_URI, theOPPPackage);
    return theOPPPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOPPElement() {
    return oppElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPElement_Id() {
    return (EAttribute)oppElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOPPNamedElement() {
    return oppNamedElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPNamedElement_Name() {
    return (EAttribute)oppNamedElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPNamedElement_Alignment() {
    return (EAttribute)oppNamedElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOPPContainer() {
    return oppContainerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOPPContainer_Nodes() {
    return (EReference)oppContainerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOPPNode() {
    return oppNodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOPPNode_IncomingLinks() {
    return (EReference)oppNodeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOPPNode_OutgoingLinks() {
    return (EReference)oppNodeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOPPNode_Container() {
    return (EReference)oppNodeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPNode_Width() {
    return (EAttribute)oppNodeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPNode_Height() {
    return (EAttribute)oppNodeEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPNode_X() {
    return (EAttribute)oppNodeEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPNode_Y() {
    return (EAttribute)oppNodeEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPNode_ManualSize() {
    return (EAttribute)oppNodeEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOPPObjectProcessDiagram() {
    return oppObjectProcessDiagramEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOPPObjectProcessDiagram_Links() {
    return (EReference)oppObjectProcessDiagramEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPObjectProcessDiagram_LastKnownUsedId() {
    return (EAttribute)oppObjectProcessDiagramEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPObjectProcessDiagram_Kind() {
    return (EAttribute)oppObjectProcessDiagramEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOPPThing() {
    return oppThingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPThing_Description() {
    return (EAttribute)oppThingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPThing_Main() {
    return (EAttribute)oppThingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPThing_Abstract() {
    return (EAttribute)oppThingEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOPPState() {
    return oppStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPState_Value() {
    return (EAttribute)oppStateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOPPObject() {
    return oppObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPObject_Global() {
    return (EAttribute)oppObjectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPObject_InitialValue() {
    return (EAttribute)oppObjectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOPPProcess() {
    return oppProcessEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPProcess_Kind() {
    return (EAttribute)oppProcessEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOPPStructuralLinkAggregator() {
    return oppStructuralLinkAggregatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPStructuralLinkAggregator_Kind() {
    return (EAttribute)oppStructuralLinkAggregatorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOPPLink() {
    return oppLinkEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOPPLink_Opd() {
    return (EReference)oppLinkEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOPPLink_Source() {
    return (EReference)oppLinkEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOPPLink_Target() {
    return (EReference)oppLinkEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPLink_SourceDecoration() {
    return (EAttribute)oppLinkEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPLink_TargetDecoration() {
    return (EAttribute)oppLinkEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPLink_CenterDecoration() {
    return (EAttribute)oppLinkEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOPPLink_Bendpoints() {
    return (EReference)oppLinkEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOPPProceduralLink() {
    return oppProceduralLinkEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPProceduralLink_Kind() {
    return (EAttribute)oppProceduralLinkEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPProceduralLink_SubKinds() {
    return (EAttribute)oppProceduralLinkEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOPPStructuralLinkPart() {
    return oppStructuralLinkPartEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOPPLabel() {
    return oppLabelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOPPPoint() {
    return oppPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPPoint_X() {
    return (EAttribute)oppPointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOPPPoint_Y() {
    return (EAttribute)oppPointEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getOPPStructuralLinkAggregatorKind() {
    return oppStructuralLinkAggregatorKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getOPPProceduralLinkKind() {
    return oppProceduralLinkKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getOPPProcessKind() {
    return oppProcessKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getOPPObjectProcessDiagramKind() {
    return oppObjectProcessDiagramKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getOPPVerticalAlignment() {
    return oppVerticalAlignmentEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPFactory getOPPFactory() {
    return (OPPFactory)getEFactoryInstance();
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
    oppElementEClass = createEClass(OPP_ELEMENT);
    createEAttribute(oppElementEClass, OPP_ELEMENT__ID);

    oppNamedElementEClass = createEClass(OPP_NAMED_ELEMENT);
    createEAttribute(oppNamedElementEClass, OPP_NAMED_ELEMENT__NAME);
    createEAttribute(oppNamedElementEClass, OPP_NAMED_ELEMENT__ALIGNMENT);

    oppContainerEClass = createEClass(OPP_CONTAINER);
    createEReference(oppContainerEClass, OPP_CONTAINER__NODES);

    oppNodeEClass = createEClass(OPP_NODE);
    createEReference(oppNodeEClass, OPP_NODE__INCOMING_LINKS);
    createEReference(oppNodeEClass, OPP_NODE__OUTGOING_LINKS);
    createEReference(oppNodeEClass, OPP_NODE__CONTAINER);
    createEAttribute(oppNodeEClass, OPP_NODE__WIDTH);
    createEAttribute(oppNodeEClass, OPP_NODE__HEIGHT);
    createEAttribute(oppNodeEClass, OPP_NODE__X);
    createEAttribute(oppNodeEClass, OPP_NODE__Y);
    createEAttribute(oppNodeEClass, OPP_NODE__MANUAL_SIZE);

    oppObjectProcessDiagramEClass = createEClass(OPP_OBJECT_PROCESS_DIAGRAM);
    createEReference(oppObjectProcessDiagramEClass, OPP_OBJECT_PROCESS_DIAGRAM__LINKS);
    createEAttribute(oppObjectProcessDiagramEClass, OPP_OBJECT_PROCESS_DIAGRAM__LAST_KNOWN_USED_ID);
    createEAttribute(oppObjectProcessDiagramEClass, OPP_OBJECT_PROCESS_DIAGRAM__KIND);

    oppThingEClass = createEClass(OPP_THING);
    createEAttribute(oppThingEClass, OPP_THING__DESCRIPTION);
    createEAttribute(oppThingEClass, OPP_THING__MAIN);
    createEAttribute(oppThingEClass, OPP_THING__ABSTRACT);

    oppStateEClass = createEClass(OPP_STATE);
    createEAttribute(oppStateEClass, OPP_STATE__VALUE);

    oppObjectEClass = createEClass(OPP_OBJECT);
    createEAttribute(oppObjectEClass, OPP_OBJECT__GLOBAL);
    createEAttribute(oppObjectEClass, OPP_OBJECT__INITIAL_VALUE);

    oppProcessEClass = createEClass(OPP_PROCESS);
    createEAttribute(oppProcessEClass, OPP_PROCESS__KIND);

    oppStructuralLinkAggregatorEClass = createEClass(OPP_STRUCTURAL_LINK_AGGREGATOR);
    createEAttribute(oppStructuralLinkAggregatorEClass, OPP_STRUCTURAL_LINK_AGGREGATOR__KIND);

    oppLabelEClass = createEClass(OPP_LABEL);

    oppLinkEClass = createEClass(OPP_LINK);
    createEReference(oppLinkEClass, OPP_LINK__OPD);
    createEReference(oppLinkEClass, OPP_LINK__SOURCE);
    createEReference(oppLinkEClass, OPP_LINK__TARGET);
    createEAttribute(oppLinkEClass, OPP_LINK__SOURCE_DECORATION);
    createEAttribute(oppLinkEClass, OPP_LINK__TARGET_DECORATION);
    createEAttribute(oppLinkEClass, OPP_LINK__CENTER_DECORATION);
    createEReference(oppLinkEClass, OPP_LINK__BENDPOINTS);

    oppProceduralLinkEClass = createEClass(OPP_PROCEDURAL_LINK);
    createEAttribute(oppProceduralLinkEClass, OPP_PROCEDURAL_LINK__KIND);
    createEAttribute(oppProceduralLinkEClass, OPP_PROCEDURAL_LINK__SUB_KINDS);

    oppStructuralLinkPartEClass = createEClass(OPP_STRUCTURAL_LINK_PART);

    oppPointEClass = createEClass(OPP_POINT);
    createEAttribute(oppPointEClass, OPP_POINT__X);
    createEAttribute(oppPointEClass, OPP_POINT__Y);

    // Create enums
    oppStructuralLinkAggregatorKindEEnum = createEEnum(OPP_STRUCTURAL_LINK_AGGREGATOR_KIND);
    oppProceduralLinkKindEEnum = createEEnum(OPP_PROCEDURAL_LINK_KIND);
    oppProcessKindEEnum = createEEnum(OPP_PROCESS_KIND);
    oppObjectProcessDiagramKindEEnum = createEEnum(OPP_OBJECT_PROCESS_DIAGRAM_KIND);
    oppVerticalAlignmentEEnum = createEEnum(OPP_VERTICAL_ALIGNMENT);
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
    oppContainerEClass.getESuperTypes().add(this.getOPPElement());
    oppNodeEClass.getESuperTypes().add(this.getOPPElement());
    oppObjectProcessDiagramEClass.getESuperTypes().add(this.getOPPContainer());
    oppObjectProcessDiagramEClass.getESuperTypes().add(this.getOPPNamedElement());
    oppThingEClass.getESuperTypes().add(this.getOPPNode());
    oppThingEClass.getESuperTypes().add(this.getOPPContainer());
    oppThingEClass.getESuperTypes().add(this.getOPPNamedElement());
    oppStateEClass.getESuperTypes().add(this.getOPPNode());
    oppStateEClass.getESuperTypes().add(this.getOPPNamedElement());
    oppObjectEClass.getESuperTypes().add(this.getOPPThing());
    oppProcessEClass.getESuperTypes().add(this.getOPPThing());
    oppStructuralLinkAggregatorEClass.getESuperTypes().add(this.getOPPNode());
    oppLabelEClass.getESuperTypes().add(this.getOPPNode());
    oppLabelEClass.getESuperTypes().add(this.getOPPNamedElement());
    oppLinkEClass.getESuperTypes().add(this.getOPPElement());
    oppProceduralLinkEClass.getESuperTypes().add(this.getOPPLink());
    oppStructuralLinkPartEClass.getESuperTypes().add(this.getOPPLink());
    oppPointEClass.getESuperTypes().add(this.getOPPElement());

    // Initialize classes and features; add operations and parameters
    initEClass(oppElementEClass, OPPElement.class, "OPPElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOPPElement_Id(), ecorePackage.getELong(), "id", null, 0, 1, OPPElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(oppNamedElementEClass, OPPNamedElement.class, "OPPNamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOPPNamedElement_Name(), ecorePackage.getEString(), "name", "", 0, 1, OPPNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOPPNamedElement_Alignment(), this.getOPPVerticalAlignment(), "alignment", "Center", 0, 1, OPPNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(oppContainerEClass, OPPContainer.class, "OPPContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOPPContainer_Nodes(), this.getOPPNode(), this.getOPPNode_Container(), "nodes", null, 0, -1, OPPContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(oppNodeEClass, OPPNode.class, "OPPNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOPPNode_IncomingLinks(), this.getOPPLink(), this.getOPPLink_Target(), "incomingLinks", null, 0, -1, OPPNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOPPNode_OutgoingLinks(), this.getOPPLink(), this.getOPPLink_Source(), "outgoingLinks", null, 0, -1, OPPNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOPPNode_Container(), this.getOPPContainer(), this.getOPPContainer_Nodes(), "container", null, 0, 1, OPPNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOPPNode_Width(), ecorePackage.getEInt(), "width", "0", 0, 1, OPPNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOPPNode_Height(), ecorePackage.getEInt(), "height", "0", 0, 1, OPPNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOPPNode_X(), ecorePackage.getEInt(), "x", "0", 0, 1, OPPNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOPPNode_Y(), ecorePackage.getEInt(), "y", "0", 0, 1, OPPNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOPPNode_ManualSize(), ecorePackage.getEBoolean(), "manualSize", "false", 0, 1, OPPNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    EOperation op = addEOperation(oppNodeEClass, null, "setConstraints", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEInt(), "x", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEInt(), "y", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEInt(), "width", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEInt(), "height", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(oppObjectProcessDiagramEClass, OPPObjectProcessDiagram.class, "OPPObjectProcessDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOPPObjectProcessDiagram_Links(), this.getOPPLink(), this.getOPPLink_Opd(), "links", null, 0, -1, OPPObjectProcessDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOPPObjectProcessDiagram_LastKnownUsedId(), ecorePackage.getELong(), "lastKnownUsedId", "0", 0, 1, OPPObjectProcessDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOPPObjectProcessDiagram_Kind(), this.getOPPObjectProcessDiagramKind(), "kind", "Compound", 1, 1, OPPObjectProcessDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(oppThingEClass, OPPThing.class, "OPPThing", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOPPThing_Description(), ecorePackage.getEString(), "description", null, 0, 1, OPPThing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOPPThing_Main(), ecorePackage.getEBoolean(), "main", "false", 1, 1, OPPThing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOPPThing_Abstract(), ecorePackage.getEBoolean(), "abstract", "false", 0, 1, OPPThing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(oppStateEClass, OPPState.class, "OPPState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOPPState_Value(), ecorePackage.getEBoolean(), "value", "false", 1, 1, OPPState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(oppObjectEClass, OPPObject.class, "OPPObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOPPObject_Global(), ecorePackage.getEBoolean(), "global", null, 0, 1, OPPObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOPPObject_InitialValue(), ecorePackage.getEString(), "initialValue", "", 0, 1, OPPObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(oppProcessEClass, OPPProcess.class, "OPPProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOPPProcess_Kind(), this.getOPPProcessKind(), "kind", "Compound", 1, 1, OPPProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(oppStructuralLinkAggregatorEClass, OPPStructuralLinkAggregator.class, "OPPStructuralLinkAggregator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOPPStructuralLinkAggregator_Kind(), this.getOPPStructuralLinkAggregatorKind(), "kind", null, 0, 1, OPPStructuralLinkAggregator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(oppLabelEClass, OPPLabel.class, "OPPLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(oppLinkEClass, OPPLink.class, "OPPLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOPPLink_Opd(), this.getOPPObjectProcessDiagram(), this.getOPPObjectProcessDiagram_Links(), "opd", null, 0, 1, OPPLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOPPLink_Source(), this.getOPPNode(), this.getOPPNode_OutgoingLinks(), "source", null, 0, 1, OPPLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOPPLink_Target(), this.getOPPNode(), this.getOPPNode_IncomingLinks(), "target", null, 0, 1, OPPLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOPPLink_SourceDecoration(), ecorePackage.getEString(), "sourceDecoration", null, 0, 1, OPPLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOPPLink_TargetDecoration(), ecorePackage.getEString(), "targetDecoration", null, 0, 1, OPPLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOPPLink_CenterDecoration(), ecorePackage.getEString(), "centerDecoration", null, 0, 1, OPPLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOPPLink_Bendpoints(), this.getOPPPoint(), null, "bendpoints", null, 0, -1, OPPLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(oppProceduralLinkEClass, OPPProceduralLink.class, "OPPProceduralLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOPPProceduralLink_Kind(), this.getOPPProceduralLinkKind(), "kind", null, 0, 1, OPPProceduralLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOPPProceduralLink_SubKinds(), ecorePackage.getEString(), "subKinds", null, 0, -1, OPPProceduralLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(oppStructuralLinkPartEClass, OPPStructuralLinkPart.class, "OPPStructuralLinkPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(oppPointEClass, OPPPoint.class, "OPPPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOPPPoint_X(), ecorePackage.getEInt(), "x", null, 0, 1, OPPPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOPPPoint_Y(), ecorePackage.getEInt(), "y", null, 0, 1, OPPPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(oppStructuralLinkAggregatorKindEEnum, OPPStructuralLinkAggregatorKind.class, "OPPStructuralLinkAggregatorKind");
    addEEnumLiteral(oppStructuralLinkAggregatorKindEEnum, OPPStructuralLinkAggregatorKind.AGGREGATION);
    addEEnumLiteral(oppStructuralLinkAggregatorKindEEnum, OPPStructuralLinkAggregatorKind.GENERALIZATION);

    initEEnum(oppProceduralLinkKindEEnum, OPPProceduralLinkKind.class, "OPPProceduralLinkKind");
    addEEnumLiteral(oppProceduralLinkKindEEnum, OPPProceduralLinkKind.AGENT);
    addEEnumLiteral(oppProceduralLinkKindEEnum, OPPProceduralLinkKind.CONS_RES);
    addEEnumLiteral(oppProceduralLinkKindEEnum, OPPProceduralLinkKind.INSTRUMENT);

    initEEnum(oppProcessKindEEnum, OPPProcessKind.class, "OPPProcessKind");
    addEEnumLiteral(oppProcessKindEEnum, OPPProcessKind.COMPOUND);
    addEEnumLiteral(oppProcessKindEEnum, OPPProcessKind.BUILT_IN);
    addEEnumLiteral(oppProcessKindEEnum, OPPProcessKind.JAVA);
    addEEnumLiteral(oppProcessKindEEnum, OPPProcessKind.CONCEPTUAL);

    initEEnum(oppObjectProcessDiagramKindEEnum, OPPObjectProcessDiagramKind.class, "OPPObjectProcessDiagramKind");
    addEEnumLiteral(oppObjectProcessDiagramKindEEnum, OPPObjectProcessDiagramKind.COMPOUND);
    addEEnumLiteral(oppObjectProcessDiagramKindEEnum, OPPObjectProcessDiagramKind.UNFOLDED);
    addEEnumLiteral(oppObjectProcessDiagramKindEEnum, OPPObjectProcessDiagramKind.SYSTEM);
    addEEnumLiteral(oppObjectProcessDiagramKindEEnum, OPPObjectProcessDiagramKind.IN_ZOOMED_PROCESS);
    addEEnumLiteral(oppObjectProcessDiagramKindEEnum, OPPObjectProcessDiagramKind.IN_ZOOMED_OBJECT);
    addEEnumLiteral(oppObjectProcessDiagramKindEEnum, OPPObjectProcessDiagramKind.UNFOLDED_PROCESS);
    addEEnumLiteral(oppObjectProcessDiagramKindEEnum, OPPObjectProcessDiagramKind.UNFOLDED_OBJECT);
    addEEnumLiteral(oppObjectProcessDiagramKindEEnum, OPPObjectProcessDiagramKind.FREE_FORM);

    initEEnum(oppVerticalAlignmentEEnum, OPPVerticalAlignment.class, "OPPVerticalAlignment");
    addEEnumLiteral(oppVerticalAlignmentEEnum, OPPVerticalAlignment.TOP);
    addEEnumLiteral(oppVerticalAlignmentEEnum, OPPVerticalAlignment.CENTER);
    addEEnumLiteral(oppVerticalAlignmentEEnum, OPPVerticalAlignment.BOTTOM);

    // Create resource
    createResource(eNS_URI);
  }

} //OPPPackageImpl
