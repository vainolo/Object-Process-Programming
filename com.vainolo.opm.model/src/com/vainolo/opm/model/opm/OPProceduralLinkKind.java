/**
 */
package com.vainolo.opm.model.opm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Procedural Link Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.vainolo.opm.model.opm.OPPackage#getOPProceduralLinkKind()
 * @model
 * @generated
 */
public enum OPProceduralLinkKind implements Enumerator {
	/**
	 * The '<em><b>Instrument</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSTRUMENT_VALUE
	 * @generated
	 * @ordered
	 */
	INSTRUMENT(0, "Instrument", "INSTRUMENT"), /**
	 * The '<em><b>Agent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGENT_VALUE
	 * @generated
	 * @ordered
	 */
	AGENT(1, "Agent", "AGENT"), /**
	 * The '<em><b>Consumption</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSUMPTION_VALUE
	 * @generated
	 * @ordered
	 */
	CONSUMPTION(2, "Consumption", "CONSUMPTION"), /**
	 * The '<em><b>Result</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESULT_VALUE
	 * @generated
	 * @ordered
	 */
	RESULT(0, "Result", "RESULT");

	/**
	 * The '<em><b>Instrument</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Instrument</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSTRUMENT
	 * @model name="Instrument" literal="INSTRUMENT"
	 * @generated
	 * @ordered
	 */
	public static final int INSTRUMENT_VALUE = 0;

	/**
	 * The '<em><b>Agent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Agent</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AGENT
	 * @model name="Agent" literal="AGENT"
	 * @generated
	 * @ordered
	 */
	public static final int AGENT_VALUE = 1;

	/**
	 * The '<em><b>Consumption</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Consumption</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONSUMPTION
	 * @model name="Consumption" literal="CONSUMPTION"
	 * @generated
	 * @ordered
	 */
	public static final int CONSUMPTION_VALUE = 2;

	/**
	 * The '<em><b>Result</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Result</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESULT
	 * @model name="Result" literal="RESULT"
	 * @generated
	 * @ordered
	 */
	public static final int RESULT_VALUE = 0;

	/**
	 * An array of all the '<em><b>Procedural Link Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final OPProceduralLinkKind[] VALUES_ARRAY =
		new OPProceduralLinkKind[] {
			INSTRUMENT,
			AGENT,
			CONSUMPTION,
			RESULT,
		};

	/**
	 * A public read-only list of all the '<em><b>Procedural Link Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<OPProceduralLinkKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Procedural Link Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OPProceduralLinkKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OPProceduralLinkKind result = VALUES_ARRAY[i];
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
	public static OPProceduralLinkKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OPProceduralLinkKind result = VALUES_ARRAY[i];
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
	public static OPProceduralLinkKind get(int value) {
		switch (value) {
			case INSTRUMENT_VALUE: return INSTRUMENT;
			case AGENT_VALUE: return AGENT;
			case CONSUMPTION_VALUE: return CONSUMPTION;
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
	private OPProceduralLinkKind(int value, String name, String literal) {
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
	
} //OPProceduralLinkKind
