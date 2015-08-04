/**
 */
package com.vainolo.opm.model.opm.impl;

import com.vainolo.opm.model.opm.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OPFactoryImpl extends EFactoryImpl implements OPFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OPFactory init() {
		try {
			OPFactory theOPFactory = (OPFactory)EPackage.Registry.INSTANCE.getEFactory(OPPackage.eNS_URI);
			if (theOPFactory != null) {
				return theOPFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OPFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OPPackage.OP_SYSTEM: return createOPSystem();
			case OPPackage.OP_OBJECT_PROCESS_DIAGRAM: return createOPObjectProcessDiagram();
			case OPPackage.OP_ELEMENT: return createOPElement();
			case OPPackage.OP_LINK: return createOPLink();
			case OPPackage.OP_STATE: return createOPState();
			case OPPackage.OP_OBJECT: return createOPObject();
			case OPPackage.OP_PROCESS: return createOPProcess();
			case OPPackage.OP_PROCEDURAL_LINK: return createOPProceduralLink();
			case OPPackage.OP_STRUCTURAL_LINK: return createOPStructuralLink();
			case OPPackage.OP_STATE_VIEW: return createOPStateView();
			case OPPackage.OP_STRUCTURAL_LINK_AGGREGATOR_VIEW: return createOPStructuralLinkAggregatorView();
			case OPPackage.OP_OBJECT_VIEW: return createOPObjectView();
			case OPPackage.OP_PROCESS_VIEW: return createOPProcessView();
			case OPPackage.OP_PROCEDURAL_LINK_VIEW: return createOPProceduralLinkView();
			case OPPackage.OP_STRUCTURAL_LINK_PART_VIEW: return createOPStructuralLinkPartView();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case OPPackage.OP_PROCEDURAL_LINK_KIND:
				return createOPProceduralLinkKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case OPPackage.OP_PROCEDURAL_LINK_KIND:
				return convertOPProceduralLinkKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPElement createOPElement() {
		OPElementImpl opElement = new OPElementImpl();
		return opElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPLink createOPLink() {
		OPLinkImpl opLink = new OPLinkImpl();
		return opLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPObject createOPObject() {
		OPObjectImpl opObject = new OPObjectImpl();
		return opObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPProcess createOPProcess() {
		OPProcessImpl opProcess = new OPProcessImpl();
		return opProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPProceduralLink createOPProceduralLink() {
		OPProceduralLinkImpl opProceduralLink = new OPProceduralLinkImpl();
		return opProceduralLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPStructuralLink createOPStructuralLink() {
		OPStructuralLinkImpl opStructuralLink = new OPStructuralLinkImpl();
		return opStructuralLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPState createOPState() {
		OPStateImpl opState = new OPStateImpl();
		return opState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPObjectProcessDiagram createOPObjectProcessDiagram() {
		OPObjectProcessDiagramImpl opObjectProcessDiagram = new OPObjectProcessDiagramImpl();
		return opObjectProcessDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPSystem createOPSystem() {
		OPSystemImpl opSystem = new OPSystemImpl();
		return opSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPObjectView createOPObjectView() {
		OPObjectViewImpl opObjectView = new OPObjectViewImpl();
		return opObjectView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPProcessView createOPProcessView() {
		OPProcessViewImpl opProcessView = new OPProcessViewImpl();
		return opProcessView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPStateView createOPStateView() {
		OPStateViewImpl opStateView = new OPStateViewImpl();
		return opStateView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPProceduralLinkView createOPProceduralLinkView() {
		OPProceduralLinkViewImpl opProceduralLinkView = new OPProceduralLinkViewImpl();
		return opProceduralLinkView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPStructuralLinkPartView createOPStructuralLinkPartView() {
		OPStructuralLinkPartViewImpl opStructuralLinkPartView = new OPStructuralLinkPartViewImpl();
		return opStructuralLinkPartView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPProceduralLinkKind createOPProceduralLinkKindFromString(EDataType eDataType, String initialValue) {
		OPProceduralLinkKind result = OPProceduralLinkKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOPProceduralLinkKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPStructuralLinkAggregatorView createOPStructuralLinkAggregatorView() {
		OPStructuralLinkAggregatorViewImpl opStructuralLinkAggregatorView = new OPStructuralLinkAggregatorViewImpl();
		return opStructuralLinkAggregatorView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPPackage getOPPackage() {
		return (OPPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OPPackage getPackage() {
		return OPPackage.eINSTANCE;
	}

} //OPFactoryImpl
