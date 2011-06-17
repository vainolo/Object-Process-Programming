/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package opm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see opm.OPMFactory
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
	OPMPackage eINSTANCE = opm.impl.OPMPackageImpl.init();

	/**
	 * The meta object id for the '{@link opm.impl.ObjectProcessDiagramImpl <em>Object Process Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see opm.impl.ObjectProcessDiagramImpl
	 * @see opm.impl.OPMPackageImpl#getObjectProcessDiagram()
	 * @generated
	 */
	int OBJECT_PROCESS_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROCESS_DIAGRAM__OBJECTS = 0;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROCESS_DIAGRAM__PROCESSES = 1;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROCESS_DIAGRAM__LINKS = 2;

	/**
	 * The number of structural features of the '<em>Object Process Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROCESS_DIAGRAM_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link opm.impl.OPMThingImpl <em>Thing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see opm.impl.OPMThingImpl
	 * @see opm.impl.OPMPackageImpl#getOPMThing()
	 * @generated
	 */
	int OPM_THING = 4;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_THING__INCOMING_LINKS = 0;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_THING__OUTGOING_LINKS = 1;

	/**
	 * The number of structural features of the '<em>Thing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_THING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link opm.impl.OPMObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see opm.impl.OPMObjectImpl
	 * @see opm.impl.OPMPackageImpl#getOPMObject()
	 * @generated
	 */
	int OPM_OBJECT = 1;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_OBJECT__NAME = OPM_THING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Opd</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_OBJECT__OPD = OPM_THING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_OBJECT_FEATURE_COUNT = OPM_THING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link opm.impl.OPMProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see opm.impl.OPMProcessImpl
	 * @see opm.impl.OPMPackageImpl#getOPMProcess()
	 * @generated
	 */
	int OPM_PROCESS = 2;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_PROCESS__NAME = OPM_THING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Opd</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_PROCESS__OPD = OPM_THING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_PROCESS_FEATURE_COUNT = OPM_THING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link opm.impl.OPMLinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see opm.impl.OPMLinkImpl
	 * @see opm.impl.OPMPackageImpl#getOPMLink()
	 * @generated
	 */
	int OPM_LINK = 3;

	/**
	 * The feature id for the '<em><b>Opd</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_LINK__OPD = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_LINK__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_LINK__TARGET = 2;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_LINK_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link opm.ObjectProcessDiagram <em>Object Process Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Process Diagram</em>'.
	 * @see opm.ObjectProcessDiagram
	 * @generated
	 */
	EClass getObjectProcessDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link opm.ObjectProcessDiagram#getObjects <em>Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Objects</em>'.
	 * @see opm.ObjectProcessDiagram#getObjects()
	 * @see #getObjectProcessDiagram()
	 * @generated
	 */
	EReference getObjectProcessDiagram_Objects();

	/**
	 * Returns the meta object for the containment reference list '{@link opm.ObjectProcessDiagram#getProcesses <em>Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processes</em>'.
	 * @see opm.ObjectProcessDiagram#getProcesses()
	 * @see #getObjectProcessDiagram()
	 * @generated
	 */
	EReference getObjectProcessDiagram_Processes();

	/**
	 * Returns the meta object for the containment reference list '{@link opm.ObjectProcessDiagram#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see opm.ObjectProcessDiagram#getLinks()
	 * @see #getObjectProcessDiagram()
	 * @generated
	 */
	EReference getObjectProcessDiagram_Links();

	/**
	 * Returns the meta object for class '{@link opm.OPMObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see opm.OPMObject
	 * @generated
	 */
	EClass getOPMObject();

	/**
	 * Returns the meta object for the attribute '{@link opm.OPMObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see opm.OPMObject#getName()
	 * @see #getOPMObject()
	 * @generated
	 */
	EAttribute getOPMObject_Name();

	/**
	 * Returns the meta object for the container reference '{@link opm.OPMObject#getOpd <em>Opd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Opd</em>'.
	 * @see opm.OPMObject#getOpd()
	 * @see #getOPMObject()
	 * @generated
	 */
	EReference getOPMObject_Opd();

	/**
	 * Returns the meta object for class '{@link opm.OPMProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process</em>'.
	 * @see opm.OPMProcess
	 * @generated
	 */
	EClass getOPMProcess();

	/**
	 * Returns the meta object for the attribute '{@link opm.OPMProcess#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see opm.OPMProcess#getName()
	 * @see #getOPMProcess()
	 * @generated
	 */
	EAttribute getOPMProcess_Name();

	/**
	 * Returns the meta object for the container reference '{@link opm.OPMProcess#getOpd <em>Opd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Opd</em>'.
	 * @see opm.OPMProcess#getOpd()
	 * @see #getOPMProcess()
	 * @generated
	 */
	EReference getOPMProcess_Opd();

	/**
	 * Returns the meta object for class '{@link opm.OPMLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see opm.OPMLink
	 * @generated
	 */
	EClass getOPMLink();

	/**
	 * Returns the meta object for the container reference '{@link opm.OPMLink#getOpd <em>Opd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Opd</em>'.
	 * @see opm.OPMLink#getOpd()
	 * @see #getOPMLink()
	 * @generated
	 */
	EReference getOPMLink_Opd();

	/**
	 * Returns the meta object for the reference '{@link opm.OPMLink#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see opm.OPMLink#getSource()
	 * @see #getOPMLink()
	 * @generated
	 */
	EReference getOPMLink_Source();

	/**
	 * Returns the meta object for the reference '{@link opm.OPMLink#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see opm.OPMLink#getTarget()
	 * @see #getOPMLink()
	 * @generated
	 */
	EReference getOPMLink_Target();

	/**
	 * Returns the meta object for class '{@link opm.OPMThing <em>Thing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thing</em>'.
	 * @see opm.OPMThing
	 * @generated
	 */
	EClass getOPMThing();

	/**
	 * Returns the meta object for the reference list '{@link opm.OPMThing#getIncomingLinks <em>Incoming Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Links</em>'.
	 * @see opm.OPMThing#getIncomingLinks()
	 * @see #getOPMThing()
	 * @generated
	 */
	EReference getOPMThing_IncomingLinks();

	/**
	 * Returns the meta object for the reference list '{@link opm.OPMThing#getOutgoingLinks <em>Outgoing Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Links</em>'.
	 * @see opm.OPMThing#getOutgoingLinks()
	 * @see #getOPMThing()
	 * @generated
	 */
	EReference getOPMThing_OutgoingLinks();

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
		 * The meta object literal for the '{@link opm.impl.ObjectProcessDiagramImpl <em>Object Process Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see opm.impl.ObjectProcessDiagramImpl
		 * @see opm.impl.OPMPackageImpl#getObjectProcessDiagram()
		 * @generated
		 */
		EClass OBJECT_PROCESS_DIAGRAM = eINSTANCE.getObjectProcessDiagram();

		/**
		 * The meta object literal for the '<em><b>Objects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_PROCESS_DIAGRAM__OBJECTS = eINSTANCE.getObjectProcessDiagram_Objects();

		/**
		 * The meta object literal for the '<em><b>Processes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_PROCESS_DIAGRAM__PROCESSES = eINSTANCE.getObjectProcessDiagram_Processes();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_PROCESS_DIAGRAM__LINKS = eINSTANCE.getObjectProcessDiagram_Links();

		/**
		 * The meta object literal for the '{@link opm.impl.OPMObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see opm.impl.OPMObjectImpl
		 * @see opm.impl.OPMPackageImpl#getOPMObject()
		 * @generated
		 */
		EClass OPM_OBJECT = eINSTANCE.getOPMObject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPM_OBJECT__NAME = eINSTANCE.getOPMObject_Name();

		/**
		 * The meta object literal for the '<em><b>Opd</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPM_OBJECT__OPD = eINSTANCE.getOPMObject_Opd();

		/**
		 * The meta object literal for the '{@link opm.impl.OPMProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see opm.impl.OPMProcessImpl
		 * @see opm.impl.OPMPackageImpl#getOPMProcess()
		 * @generated
		 */
		EClass OPM_PROCESS = eINSTANCE.getOPMProcess();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPM_PROCESS__NAME = eINSTANCE.getOPMProcess_Name();

		/**
		 * The meta object literal for the '<em><b>Opd</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPM_PROCESS__OPD = eINSTANCE.getOPMProcess_Opd();

		/**
		 * The meta object literal for the '{@link opm.impl.OPMLinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see opm.impl.OPMLinkImpl
		 * @see opm.impl.OPMPackageImpl#getOPMLink()
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
		 * The meta object literal for the '{@link opm.impl.OPMThingImpl <em>Thing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see opm.impl.OPMThingImpl
		 * @see opm.impl.OPMPackageImpl#getOPMThing()
		 * @generated
		 */
		EClass OPM_THING = eINSTANCE.getOPMThing();

		/**
		 * The meta object literal for the '<em><b>Incoming Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPM_THING__INCOMING_LINKS = eINSTANCE.getOPMThing_IncomingLinks();

		/**
		 * The meta object literal for the '<em><b>Outgoing Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPM_THING__OUTGOING_LINKS = eINSTANCE.getOPMThing_OutgoingLinks();

	}

} //OPMPackage
