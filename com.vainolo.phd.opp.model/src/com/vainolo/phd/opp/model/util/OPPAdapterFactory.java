/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 */
package com.vainolo.phd.opp.model.util;

import com.vainolo.phd.opp.model.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.vainolo.phd.opp.model.OPPPackage
 * @generated
 */
public class OPPAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static OPPPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OPPAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = OPPPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OPPSwitch<Adapter> modelSwitch =
    new OPPSwitch<Adapter>() {
      @Override
      public Adapter caseOPPElement(OPPElement object) {
        return createOPPElementAdapter();
      }
      @Override
      public Adapter caseOPPNamedElement(OPPNamedElement object) {
        return createOPPNamedElementAdapter();
      }
      @Override
      public Adapter caseOPPContainer(OPPContainer object) {
        return createOPPContainerAdapter();
      }
      @Override
      public Adapter caseOPPNode(OPPNode object) {
        return createOPPNodeAdapter();
      }
      @Override
      public Adapter caseOPPObjectProcessDiagram(OPPObjectProcessDiagram object) {
        return createOPPObjectProcessDiagramAdapter();
      }
      @Override
      public Adapter caseOPPThing(OPPThing object) {
        return createOPPThingAdapter();
      }
      @Override
      public Adapter caseOPPState(OPPState object) {
        return createOPPStateAdapter();
      }
      @Override
      public Adapter caseOPPObject(OPPObject object) {
        return createOPPObjectAdapter();
      }
      @Override
      public Adapter caseOPPProcess(OPPProcess object) {
        return createOPPProcessAdapter();
      }
      @Override
      public Adapter caseOPPStructuralLinkAggregator(OPPStructuralLinkAggregator object) {
        return createOPPStructuralLinkAggregatorAdapter();
      }
      @Override
      public Adapter caseOPPLabel(OPPLabel object) {
        return createOPPLabelAdapter();
      }
      @Override
      public Adapter caseOPPLink(OPPLink object) {
        return createOPPLinkAdapter();
      }
      @Override
      public Adapter caseOPPProceduralLink(OPPProceduralLink object) {
        return createOPPProceduralLinkAdapter();
      }
      @Override
      public Adapter caseOPPStructuralLinkPart(OPPStructuralLinkPart object) {
        return createOPPStructuralLinkPartAdapter();
      }
      @Override
      public Adapter caseOPPPoint(OPPPoint object) {
        return createOPPPointAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object) {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link com.vainolo.phd.opp.model.OPPElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.vainolo.phd.opp.model.OPPElement
   * @generated
   */
  public Adapter createOPPElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.vainolo.phd.opp.model.OPPNamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.vainolo.phd.opp.model.OPPNamedElement
   * @generated
   */
  public Adapter createOPPNamedElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.vainolo.phd.opp.model.OPPContainer <em>Container</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.vainolo.phd.opp.model.OPPContainer
   * @generated
   */
  public Adapter createOPPContainerAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.vainolo.phd.opp.model.OPPNode <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.vainolo.phd.opp.model.OPPNode
   * @generated
   */
  public Adapter createOPPNodeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.vainolo.phd.opp.model.OPPObjectProcessDiagram <em>Object Process Diagram</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.vainolo.phd.opp.model.OPPObjectProcessDiagram
   * @generated
   */
  public Adapter createOPPObjectProcessDiagramAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.vainolo.phd.opp.model.OPPThing <em>Thing</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.vainolo.phd.opp.model.OPPThing
   * @generated
   */
  public Adapter createOPPThingAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.vainolo.phd.opp.model.OPPState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.vainolo.phd.opp.model.OPPState
   * @generated
   */
  public Adapter createOPPStateAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.vainolo.phd.opp.model.OPPObject <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.vainolo.phd.opp.model.OPPObject
   * @generated
   */
  public Adapter createOPPObjectAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.vainolo.phd.opp.model.OPPProcess <em>Process</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.vainolo.phd.opp.model.OPPProcess
   * @generated
   */
  public Adapter createOPPProcessAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.vainolo.phd.opp.model.OPPStructuralLinkAggregator <em>Structural Link Aggregator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.vainolo.phd.opp.model.OPPStructuralLinkAggregator
   * @generated
   */
  public Adapter createOPPStructuralLinkAggregatorAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.vainolo.phd.opp.model.OPPLink <em>Link</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.vainolo.phd.opp.model.OPPLink
   * @generated
   */
  public Adapter createOPPLinkAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.vainolo.phd.opp.model.OPPProceduralLink <em>Procedural Link</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.vainolo.phd.opp.model.OPPProceduralLink
   * @generated
   */
  public Adapter createOPPProceduralLinkAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.vainolo.phd.opp.model.OPPStructuralLinkPart <em>Structural Link Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.vainolo.phd.opp.model.OPPStructuralLinkPart
   * @generated
   */
  public Adapter createOPPStructuralLinkPartAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.vainolo.phd.opp.model.OPPLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.vainolo.phd.opp.model.OPPLabel
   * @generated
   */
  public Adapter createOPPLabelAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.vainolo.phd.opp.model.OPPPoint <em>Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.vainolo.phd.opp.model.OPPPoint
   * @generated
   */
  public Adapter createOPPPointAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} //OPPAdapterFactory
