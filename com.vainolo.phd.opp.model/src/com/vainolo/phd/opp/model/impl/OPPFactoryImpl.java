/**
 */
package com.vainolo.phd.opp.model.impl;

import com.vainolo.phd.opp.model.*;

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
public class OPPFactoryImpl extends EFactoryImpl implements OPPFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static OPPFactory init() {
    try {
      OPPFactory theOPPFactory = (OPPFactory)EPackage.Registry.INSTANCE.getEFactory(OPPPackage.eNS_URI);
      if (theOPPFactory != null) {
        return theOPPFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new OPPFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPFactoryImpl() {
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
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM: return createOPPObjectProcessDiagram();
      case OPPPackage.OPP_STATE: return createOPPState();
      case OPPPackage.OPP_OBJECT: return createOPPObject();
      case OPPPackage.OPP_PROCESS: return createOPPProcess();
      case OPPPackage.OPP_STRUCTURAL_LINK_AGGREGATOR: return createOPPStructuralLinkAggregator();
      case OPPPackage.OPP_LABEL: return createOPPLabel();
      case OPPPackage.OPP_LINK: return createOPPLink();
      case OPPPackage.OPP_PROCEDURAL_LINK: return createOPPProceduralLink();
      case OPPPackage.OPP_STRUCTURAL_LINK_PART: return createOPPStructuralLinkPart();
      case OPPPackage.OPP_POINT: return createOPPPoint();
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
      case OPPPackage.OPP_STRUCTURAL_LINK_AGGREGATOR_KIND:
        return createOPPStructuralLinkAggregatorKindFromString(eDataType, initialValue);
      case OPPPackage.OPP_PROCEDURAL_LINK_KIND:
        return createOPPProceduralLinkKindFromString(eDataType, initialValue);
      case OPPPackage.OPP_PROCESS_KIND:
        return createOPPProcessKindFromString(eDataType, initialValue);
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM_KIND:
        return createOPPObjectProcessDiagramKindFromString(eDataType, initialValue);
      case OPPPackage.OPP_VERTICAL_ALIGNMENT:
        return createOPPVerticalAlignmentFromString(eDataType, initialValue);
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
      case OPPPackage.OPP_STRUCTURAL_LINK_AGGREGATOR_KIND:
        return convertOPPStructuralLinkAggregatorKindToString(eDataType, instanceValue);
      case OPPPackage.OPP_PROCEDURAL_LINK_KIND:
        return convertOPPProceduralLinkKindToString(eDataType, instanceValue);
      case OPPPackage.OPP_PROCESS_KIND:
        return convertOPPProcessKindToString(eDataType, instanceValue);
      case OPPPackage.OPP_OBJECT_PROCESS_DIAGRAM_KIND:
        return convertOPPObjectProcessDiagramKindToString(eDataType, instanceValue);
      case OPPPackage.OPP_VERTICAL_ALIGNMENT:
        return convertOPPVerticalAlignmentToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPObjectProcessDiagram createOPPObjectProcessDiagram() {
    OPPObjectProcessDiagramImpl oppObjectProcessDiagram = new OPPObjectProcessDiagramImpl();
    return oppObjectProcessDiagram;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPState createOPPState() {
    OPPStateImpl oppState = new OPPStateImpl();
    return oppState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPObject createOPPObject() {
    OPPObjectImpl oppObject = new OPPObjectImpl();
    return oppObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPProcess createOPPProcess() {
    OPPProcessImpl oppProcess = new OPPProcessImpl();
    return oppProcess;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPStructuralLinkAggregator createOPPStructuralLinkAggregator() {
    OPPStructuralLinkAggregatorImpl oppStructuralLinkAggregator = new OPPStructuralLinkAggregatorImpl();
    return oppStructuralLinkAggregator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPLink createOPPLink() {
    OPPLinkImpl oppLink = new OPPLinkImpl();
    return oppLink;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPProceduralLink createOPPProceduralLink() {
    OPPProceduralLinkImpl oppProceduralLink = new OPPProceduralLinkImpl();
    return oppProceduralLink;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPStructuralLinkPart createOPPStructuralLinkPart() {
    OPPStructuralLinkPartImpl oppStructuralLinkPart = new OPPStructuralLinkPartImpl();
    return oppStructuralLinkPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPLabel createOPPLabel() {
    OPPLabelImpl oppLabel = new OPPLabelImpl();
    return oppLabel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPPoint createOPPPoint() {
    OPPPointImpl oppPoint = new OPPPointImpl();
    return oppPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPStructuralLinkAggregatorKind createOPPStructuralLinkAggregatorKindFromString(EDataType eDataType, String initialValue) {
    OPPStructuralLinkAggregatorKind result = OPPStructuralLinkAggregatorKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertOPPStructuralLinkAggregatorKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPProceduralLinkKind createOPPProceduralLinkKindFromString(EDataType eDataType, String initialValue) {
    OPPProceduralLinkKind result = OPPProceduralLinkKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertOPPProceduralLinkKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPProcessKind createOPPProcessKindFromString(EDataType eDataType, String initialValue) {
    OPPProcessKind result = OPPProcessKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertOPPProcessKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPObjectProcessDiagramKind createOPPObjectProcessDiagramKindFromString(EDataType eDataType, String initialValue) {
    OPPObjectProcessDiagramKind result = OPPObjectProcessDiagramKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertOPPObjectProcessDiagramKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPVerticalAlignment createOPPVerticalAlignmentFromString(EDataType eDataType, String initialValue) {
    OPPVerticalAlignment result = OPPVerticalAlignment.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertOPPVerticalAlignmentToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPPackage getOPPPackage() {
    return (OPPPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static OPPPackage getPackage() {
    return OPPPackage.eINSTANCE;
  }

} //OPPFactoryImpl
