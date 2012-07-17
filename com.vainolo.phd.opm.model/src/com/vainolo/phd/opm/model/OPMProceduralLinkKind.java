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
   * The '<em><b>EFFECT</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #EFFECT_VALUE
   * @generated
   * @ordered
   */
	EFFECT(3, "EFFECT", "Effect"), /**
   * The '<em><b>EFFECT EVENT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EFFECT_EVENT_VALUE
   * @generated
   * @ordered
   */
  EFFECT_EVENT(10, "EFFECT_EVENT", "Effect Event"), /**
   * The '<em><b>EFFECT CONDITION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EFFECT_CONDITION_VALUE
   * @generated
   * @ordered
   */
  EFFECT_CONDITION(10, "EFFECT_CONDITION", "Effect Condition"), /**
   * The '<em><b>RESULT</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #RESULT_VALUE
   * @generated
   * @ordered
   */
	RESULT(4, "RESULT", "Result"), /**
   * The '<em><b>INVOCATION</b></em>' literal object.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #INVOCATION_VALUE
   * @generated
   * @ordered
   */
    INVOCATION(5, "INVOCATION", "Invocation"), /**
   * The '<em><b>INSTRUMENT</b></em>' literal object.
   * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
   * @see #INSTRUMENT_VALUE
   * @generated
   * @ordered
   */
INSTRUMENT(1, "INSTRUMENT", "Instrument"), /**
   * The '<em><b>INSTRUMENT EVENT</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #INSTRUMENT_EVENT_VALUE
   * @generated
   * @ordered
   */
	INSTRUMENT_EVENT(6, "INSTRUMENT_EVENT", "Instrument Event"), /**
   * The '<em><b>INSTRUMENT CONDITION</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #INSTRUMENT_CONDITION_VALUE
   * @generated
   * @ordered
   */
	INSTRUMENT_CONDITION(7, "INSTRUMENT_CONDITION", "Instrument Condition"), /**
   * The '<em><b>CONSUMPTION</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #CONSUMPTION_VALUE
   * @generated
   * @ordered
   */
	CONSUMPTION(2, "CONSUMPTION", "Consumption"), /**
   * The '<em><b>CONSUMPTION EVENT</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #CONSUMPTION_EVENT_VALUE
   * @generated
   * @ordered
   */
	CONSUMPTION_EVENT(8, "CONSUMPTION_EVENT", "Consumption Event"), /**
   * The '<em><b>CONSUMPTION CONDITION</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #CONSUMPTION_CONDITION_VALUE
   * @generated
   * @ordered
   */
	CONSUMPTION_CONDITION(9, "CONSUMPTION_CONDITION", "Consumption Condition");

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
   * The '<em><b>EFFECT EVENT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EFFECT EVENT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EFFECT_EVENT
   * @model literal="Effect Event"
   * @generated
   * @ordered
   */
  public static final int EFFECT_EVENT_VALUE = 10;

  /**
   * The '<em><b>EFFECT CONDITION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EFFECT CONDITION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EFFECT_CONDITION
   * @model literal="Effect Condition"
   * @generated
   * @ordered
   */
  public static final int EFFECT_CONDITION_VALUE = 10;

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
   * The '<em><b>INVOCATION</b></em>' literal value.
   * <!-- begin-user-doc -->
           * <p>
           * If the meaning of '<em><b>INVOCATION</b></em>' literal object isn't clear,
           * there really should be more of a description here...
           * </p>
           * <!-- end-user-doc -->
   * @see #INVOCATION
   * @model literal="Invocation"
   * @generated
   * @ordered
   */
          public static final int INVOCATION_VALUE = 5;

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
   * The '<em><b>INSTRUMENT EVENT</b></em>' literal value.
   * <!-- begin-user-doc -->
 * <p>
 * If the meaning of '<em><b>INSTRUMENT EVENT</b></em>' literal object isn't clear,
 * there really should be more of a description here...
 * </p>
 * <!-- end-user-doc -->
   * @see #INSTRUMENT_EVENT
   * @model literal="Instrument Event"
   * @generated
   * @ordered
   */
public static final int INSTRUMENT_EVENT_VALUE = 6;

        /**
   * The '<em><b>INSTRUMENT CONDITION</b></em>' literal value.
   * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>INSTRUMENT CONDITION</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
   * @see #INSTRUMENT_CONDITION
   * @model literal="Instrument Condition"
   * @generated
   * @ordered
   */
        public static final int INSTRUMENT_CONDITION_VALUE = 7;

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
   * The '<em><b>CONSUMPTION EVENT</b></em>' literal value.
   * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>CONSUMPTION EVENT</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
   * @see #CONSUMPTION_EVENT
   * @model literal="Consumption Event"
   * @generated
   * @ordered
   */
        public static final int CONSUMPTION_EVENT_VALUE = 8;

        /**
   * The '<em><b>CONSUMPTION CONDITION</b></em>' literal value.
   * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>CONSUMPTION CONDITION</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
   * @see #CONSUMPTION_CONDITION
   * @model literal="Consumption Condition"
   * @generated
   * @ordered
   */
        public static final int CONSUMPTION_CONDITION_VALUE = 9;

        /**
   * An array of all the '<em><b>Procedural Link Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private static final OPMProceduralLinkKind[] VALUES_ARRAY =
		new OPMProceduralLinkKind[] {
      AGENT,
      EFFECT,
      EFFECT_EVENT,
      EFFECT_CONDITION,
      RESULT,
      INVOCATION,
      INSTRUMENT,
      INSTRUMENT_EVENT,
      INSTRUMENT_CONDITION,
      CONSUMPTION,
      CONSUMPTION_EVENT,
      CONSUMPTION_CONDITION,
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
      case EFFECT_VALUE: return EFFECT;
      case EFFECT_EVENT_VALUE: return EFFECT_EVENT;
      case RESULT_VALUE: return RESULT;
      case INVOCATION_VALUE: return INVOCATION;
      case INSTRUMENT_VALUE: return INSTRUMENT;
      case INSTRUMENT_EVENT_VALUE: return INSTRUMENT_EVENT;
      case INSTRUMENT_CONDITION_VALUE: return INSTRUMENT_CONDITION;
      case CONSUMPTION_VALUE: return CONSUMPTION;
      case CONSUMPTION_EVENT_VALUE: return CONSUMPTION_EVENT;
      case CONSUMPTION_CONDITION_VALUE: return CONSUMPTION_CONDITION;
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
