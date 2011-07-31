/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model.impl;

import com.vainolo.phd.opm.model.*;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
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
public class OPMFactoryImpl extends EFactoryImpl implements OPMFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static OPMFactory init() {
        try {
            OPMFactory theOPMFactory = (OPMFactory)EPackage.Registry.INSTANCE.getEFactory("www.vainolo.com/phd/opm"); 
            if (theOPMFactory != null) {
                return theOPMFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new OPMFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OPMFactoryImpl() {
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
            case OPMPackage.NAMED_ELEMENT: return createNamedElement();
            case OPMPackage.NODE_CONTAINER: return createNodeContainer();
            case OPMPackage.OPM_OBJECT_PROCESS_DIAGRAM: return createOPMObjectProcessDiagram();
            case OPMPackage.OPM_STATE: return createOPMState();
            case OPMPackage.OPM_THING: return createOPMThing();
            case OPMPackage.OPM_OBJECT: return createOPMObject();
            case OPMPackage.OPM_PROCESS: return createOPMProcess();
            case OPMPackage.OPM_STRUCTURAL_LINK_AGGREGATOR: return createOPMStructuralLinkAggregator();
            case OPMPackage.OPM_AGGREGATION_LINK_AGGREGATOR: return createOPMAggregationLinkAggregator();
            case OPMPackage.OPM_EXHIBITION_LINK_AGGREGATOR: return createOPMExhibitionLinkAggregator();
            case OPMPackage.OPM_GENERALIZATION_LINK_AGGREGATOR: return createOPMGeneralizationLinkAggregator();
            case OPMPackage.OPM_PROCEDURAL_LINK: return createOPMProceduralLink();
            case OPMPackage.OPM_AGENT_LINK: return createOPMAgentLink();
            case OPMPackage.OPM_INSTRUMENT_LINK: return createOPMInstrumentLink();
            case OPMPackage.OPM_CONSUMPTION_LINK: return createOPMConsumptionLink();
            case OPMPackage.OPM_RESULT_LINK: return createOPMResultLink();
            case OPMPackage.OPM_EFFECT_LINK: return createOPMEffectLink();
            case OPMPackage.OPM_STRUCTURAL_LINK: return createOPMStructuralLink();
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
            case OPMPackage.RECTANGLE:
                return createRectangleFromString(eDataType, initialValue);
            case OPMPackage.POINT:
                return createPointFromString(eDataType, initialValue);
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
            case OPMPackage.RECTANGLE:
                return convertRectangleToString(eDataType, instanceValue);
            case OPMPackage.POINT:
                return convertPointToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OPMObjectProcessDiagram createOPMObjectProcessDiagram() {
        OPMObjectProcessDiagramImpl opmObjectProcessDiagram = new OPMObjectProcessDiagramImpl();
        return opmObjectProcessDiagram;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OPMObject createOPMObject() {
        OPMObjectImpl opmObject = new OPMObjectImpl();
        return opmObject;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OPMProcess createOPMProcess() {
        OPMProcessImpl opmProcess = new OPMProcessImpl();
        return opmProcess;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OPMThing createOPMThing() {
        OPMThingImpl opmThing = new OPMThingImpl();
        return opmThing;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OPMProceduralLink createOPMProceduralLink() {
        OPMProceduralLinkImpl opmProceduralLink = new OPMProceduralLinkImpl();
        return opmProceduralLink;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OPMAgentLink createOPMAgentLink() {
        OPMAgentLinkImpl opmAgentLink = new OPMAgentLinkImpl();
        return opmAgentLink;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OPMInstrumentLink createOPMInstrumentLink() {
        OPMInstrumentLinkImpl opmInstrumentLink = new OPMInstrumentLinkImpl();
        return opmInstrumentLink;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OPMConsumptionLink createOPMConsumptionLink() {
        OPMConsumptionLinkImpl opmConsumptionLink = new OPMConsumptionLinkImpl();
        return opmConsumptionLink;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OPMResultLink createOPMResultLink() {
        OPMResultLinkImpl opmResultLink = new OPMResultLinkImpl();
        return opmResultLink;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OPMEffectLink createOPMEffectLink() {
        OPMEffectLinkImpl opmEffectLink = new OPMEffectLinkImpl();
        return opmEffectLink;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OPMStructuralLink createOPMStructuralLink() {
        OPMStructuralLinkImpl opmStructuralLink = new OPMStructuralLinkImpl();
        return opmStructuralLink;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NamedElement createNamedElement() {
        NamedElementImpl namedElement = new NamedElementImpl();
        return namedElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NodeContainer createNodeContainer() {
        NodeContainerImpl nodeContainer = new NodeContainerImpl();
        return nodeContainer;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OPMStructuralLinkAggregator createOPMStructuralLinkAggregator() {
        OPMStructuralLinkAggregatorImpl opmStructuralLinkAggregator = new OPMStructuralLinkAggregatorImpl();
        return opmStructuralLinkAggregator;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OPMAggregationLinkAggregator createOPMAggregationLinkAggregator() {
        OPMAggregationLinkAggregatorImpl opmAggregationLinkAggregator = new OPMAggregationLinkAggregatorImpl();
        return opmAggregationLinkAggregator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OPMExhibitionLinkAggregator createOPMExhibitionLinkAggregator() {
        OPMExhibitionLinkAggregatorImpl opmExhibitionLinkAggregator = new OPMExhibitionLinkAggregatorImpl();
        return opmExhibitionLinkAggregator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OPMGeneralizationLinkAggregator createOPMGeneralizationLinkAggregator() {
        OPMGeneralizationLinkAggregatorImpl opmGeneralizationLinkAggregator = new OPMGeneralizationLinkAggregatorImpl();
        return opmGeneralizationLinkAggregator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OPMState createOPMState() {
        OPMStateImpl opmState = new OPMStateImpl();
        return opmState;
    }

    /**
	 * <!-- begin-user-doc -->
	 * Create a <code>Rectangle</code> instance from a <code>String</code>. The expected
	 * representation is "x,y,width,height". Illegal representations will return a null
	 * value. 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Rectangle createRectangleFromString(EDataType eDataType, String initialValue) {
		if(initialValue == null) {
			return null;
		}
		initialValue.replaceAll("\\s", "");
		String[] values = initialValue.split(",");
		if(values.length != 4) {
			return null;
		}

		Rectangle rect = new Rectangle();
		try {
			rect.setLocation(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
			rect.setSize(Integer.parseInt(values[2]), Integer.parseInt(values[3]));
		} catch(NumberFormatException e) {
			EcorePlugin.INSTANCE.log(e);
			rect = null;
		}
		return rect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Convert a <code>Rectangle</code> to a <code>String</code> representation. The
	 * <code>Rectangle</code> is represented as "x,y,width,heigth". 
	 * <!-- end-user-doc -->
	 * @generated NOT 
	 */
	public String convertRectangleToString(EDataType eDataType, Object instanceValue) {
		if(instanceValue == null) {
			return null;
		}
		Rectangle rect = (Rectangle) instanceValue;
		return rect.x+","+rect.y+","+rect.width+","+rect.height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Point createPointFromString(EDataType eDataType, String initialValue) {
		if(initialValue == null) {
			return null;
		}
		initialValue.replaceAll("\\s", "");
		String[] values = initialValue.split(",");
		if(values.length != 2) {
			return null;
		}
		
		Point p = new Point();
		try {
			p.setLocation(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
		} catch(NumberFormatException e) {
			EcorePlugin.INSTANCE.log(e);
			p = null;
		}
		return p;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertPointToString(EDataType eDataType, Object instanceValue) {
		if(instanceValue == null) {
			return null;
		}
		Point p = (Point) instanceValue;
		return p.x+","+p.y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Dimension createDimensionFromString(EDataType eDataType, String initialValue) {
		if(initialValue == null) {
			return null;
		}
		initialValue.replaceAll("\\s", "");
		String[] values = initialValue.split(",");
		if(values.length != 2) {
			return null;
		}
		
		Dimension d = new Dimension();
		try {
			d.width = Integer.parseInt(values[0]);
			d.height = Integer.parseInt(values[1]);
		} catch(NumberFormatException e) {
			EcorePlugin.INSTANCE.log(e);
			d = null;
		}
		return d;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertDimensionToString(EDataType eDataType, Object instanceValue) {
		if(instanceValue == null) {
			return null;
		}
		Dimension d = (Dimension)instanceValue;
		return d.width+","+d.height;
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OPMPackage getOPMPackage() {
        return (OPMPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static OPMPackage getPackage() {
        return OPMPackage.eINSTANCE;
    }

} //OPMFactoryImpl
