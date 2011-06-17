/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package opm.impl;

import opm.OPMFactory;
import opm.OPMLink;
import opm.OPMObject;
import opm.OPMPackage;
import opm.OPMProcess;
import opm.OPMThing;
import opm.ObjectProcessDiagram;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
	private EClass objectProcessDiagramEClass = null;

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
	private EClass opmLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opmThingEClass = null;

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
	 * @see opm.OPMPackage#eNS_URI
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
	public EClass getObjectProcessDiagram() {
		return objectProcessDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectProcessDiagram_Objects() {
		return (EReference)objectProcessDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectProcessDiagram_Processes() {
		return (EReference)objectProcessDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectProcessDiagram_Links() {
		return (EReference)objectProcessDiagramEClass.getEStructuralFeatures().get(2);
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
	public EAttribute getOPMObject_Name() {
		return (EAttribute)opmObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPMObject_Opd() {
		return (EReference)opmObjectEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getOPMProcess_Name() {
		return (EAttribute)opmProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPMProcess_Opd() {
		return (EReference)opmProcessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOPMLink() {
		return opmLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPMLink_Opd() {
		return (EReference)opmLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPMLink_Source() {
		return (EReference)opmLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPMLink_Target() {
		return (EReference)opmLinkEClass.getEStructuralFeatures().get(2);
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
	public EReference getOPMThing_IncomingLinks() {
		return (EReference)opmThingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOPMThing_OutgoingLinks() {
		return (EReference)opmThingEClass.getEStructuralFeatures().get(1);
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
		objectProcessDiagramEClass = createEClass(OBJECT_PROCESS_DIAGRAM);
		createEReference(objectProcessDiagramEClass, OBJECT_PROCESS_DIAGRAM__OBJECTS);
		createEReference(objectProcessDiagramEClass, OBJECT_PROCESS_DIAGRAM__PROCESSES);
		createEReference(objectProcessDiagramEClass, OBJECT_PROCESS_DIAGRAM__LINKS);

		opmObjectEClass = createEClass(OPM_OBJECT);
		createEAttribute(opmObjectEClass, OPM_OBJECT__NAME);
		createEReference(opmObjectEClass, OPM_OBJECT__OPD);

		opmProcessEClass = createEClass(OPM_PROCESS);
		createEAttribute(opmProcessEClass, OPM_PROCESS__NAME);
		createEReference(opmProcessEClass, OPM_PROCESS__OPD);

		opmLinkEClass = createEClass(OPM_LINK);
		createEReference(opmLinkEClass, OPM_LINK__OPD);
		createEReference(opmLinkEClass, OPM_LINK__SOURCE);
		createEReference(opmLinkEClass, OPM_LINK__TARGET);

		opmThingEClass = createEClass(OPM_THING);
		createEReference(opmThingEClass, OPM_THING__INCOMING_LINKS);
		createEReference(opmThingEClass, OPM_THING__OUTGOING_LINKS);
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
		opmObjectEClass.getESuperTypes().add(this.getOPMThing());
		opmProcessEClass.getESuperTypes().add(this.getOPMThing());

		// Initialize classes and features; add operations and parameters
		initEClass(objectProcessDiagramEClass, ObjectProcessDiagram.class, "ObjectProcessDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectProcessDiagram_Objects(), this.getOPMObject(), this.getOPMObject_Opd(), "objects", null, 0, -1, ObjectProcessDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectProcessDiagram_Processes(), this.getOPMProcess(), this.getOPMProcess_Opd(), "processes", null, 0, -1, ObjectProcessDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectProcessDiagram_Links(), this.getOPMLink(), this.getOPMLink_Opd(), "links", null, 0, -1, ObjectProcessDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(opmObjectEClass, OPMObject.class, "OPMObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOPMObject_Name(), ecorePackage.getEString(), "name", null, 0, 1, OPMObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOPMObject_Opd(), this.getObjectProcessDiagram(), this.getObjectProcessDiagram_Objects(), "opd", null, 0, 1, OPMObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(opmProcessEClass, OPMProcess.class, "OPMProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOPMProcess_Name(), ecorePackage.getEString(), "name", null, 0, 1, OPMProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOPMProcess_Opd(), this.getObjectProcessDiagram(), this.getObjectProcessDiagram_Processes(), "opd", null, 0, 1, OPMProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(opmLinkEClass, OPMLink.class, "OPMLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOPMLink_Opd(), this.getObjectProcessDiagram(), this.getObjectProcessDiagram_Links(), "opd", null, 0, 1, OPMLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOPMLink_Source(), this.getOPMThing(), this.getOPMThing_OutgoingLinks(), "source", null, 0, 1, OPMLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOPMLink_Target(), this.getOPMThing(), this.getOPMThing_IncomingLinks(), "target", null, 0, 1, OPMLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(opmThingEClass, OPMThing.class, "OPMThing", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOPMThing_IncomingLinks(), this.getOPMLink(), this.getOPMLink_Target(), "incomingLinks", null, 0, -1, OPMThing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOPMThing_OutgoingLinks(), this.getOPMLink(), this.getOPMLink_Source(), "outgoingLinks", null, 0, -1, OPMThing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //OPMPackageImpl
