/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Procedural Link Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMProceduralLinkKind()
 * @model
 * @generated
 */
public enum OPMProceduralLinkKind implements Enumerator {
	/**
     * The '<em><b>AGENT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #AGENT_VALUE
     * @generated
     * @ordered
     */
	AGENT(0, "AGENT", "Agent"),

	/**
     * The '<em><b>INSTRUMENT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #INSTRUMENT_VALUE
     * @generated
     * @ordered
     */
	INSTRUMENT(1, "INSTRUMENT", "Instrument"),

	/**
     * The '<em><b>CONSUMPTION</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #CONSUMPTION_VALUE
     * @generated
     * @ordered
     */
	CONSUMPTION(2, "CONSUMPTION", "Consumption"), /**
     * The '<em><b>EFFECT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #EFFECT_VALUE
     * @generated
     * @ordered
     */
	EFFECT(3, "EFFECT", "Effect"), /**
     * The '<em><b>RESULT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #RESULT_VALUE
     * @generated
     * @ordered
     */
	RESULT(4, "RESULT", "Result");

	/**
     * The '<em><b>AGENT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AGENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #AGENT
     * @model literal="Agent"
     * @generated
     * @ordered
     */
	public static final int AGENT_VALUE = 0;

	/**
     * The '<em><b>INSTRUMENT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INSTRUMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #INSTRUMENT
     * @model literal="Instrument"
     * @generated
     * @ordered
     */
	public static final int INSTRUMENT_VALUE = 1;

	/**
     * The '<em><b>CONSUMPTION</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONSUMPTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #CONSUMPTION
     * @model literal="Consumption"
     * @generated
     * @ordered
     */
	public static final int CONSUMPTION_VALUE = 2;

	/**
     * The '<em><b>EFFECT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EFFECT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #EFFECT
     * @model literal="Effect"
     * @generated
     * @ordered
     */
	public static final int EFFECT_VALUE = 3;

	/**
     * The '<em><b>RESULT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RESULT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #RESULT
     * @model literal="Result"
     * @generated
     * @ordered
     */
	public static final int RESULT_VALUE = 4;

	/**
     * An array of all the '<em><b>Procedural Link Kind</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final OPMProceduralLinkKind[] VALUES_ARRAY =
		new OPMProceduralLinkKind[] {
            AGENT,
            INSTRUMENT,
            CONSUMPTION,
            EFFECT,
            RESULT,
        };

	/**
     * A public read-only list of all the '<em><b>Procedural Link Kind</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<OPMProceduralLinkKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Procedural Link Kind</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static OPMProceduralLinkKind get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            OPMProceduralLinkKind result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Procedural Link Kind</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static OPMProceduralLinkKind getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            OPMProceduralLinkKind result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Procedural Link Kind</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static OPMProceduralLinkKind get(int value) {
        switch (value) {
            case AGENT_VALUE: return AGENT;
            case INSTRUMENT_VALUE: return INSTRUMENT;
            case CONSUMPTION_VALUE: return CONSUMPTION;
            case EFFECT_VALUE: return EFFECT;
            case RESULT_VALUE: return RESULT;
        }
        return null;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private final int value;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private final String name;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private final String literal;

	/**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private OPMProceduralLinkKind(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getValue() {
      return value;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getName() {
      return name;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getLiteral() {
      return literal;
    }

	/**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        return literal;
    }
	
} //OPMProceduralLinkKind
