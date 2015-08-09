/**
 */
package com.vainolo.opm.model.opm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Structural Link Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.vainolo.opm.model.opm.OPPackage#getOPStructuralLinkKind()
 * @model
 * @generated
 */
public enum OPStructuralLinkKind implements Enumerator {
	/**
	 * The '<em><b>Aggregation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGGREGATION_VALUE
	 * @generated
	 * @ordered
	 */
	AGGREGATION(0, "Aggregation", "AGGREGATION"),

	/**
	 * The '<em><b>Exhibition</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXHIBITION_VALUE
	 * @generated
	 * @ordered
	 */
	EXHIBITION(1, "Exhibition", "EXHIBITION");

	/**
	 * The '<em><b>Aggregation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Aggregation</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AGGREGATION
	 * @model name="Aggregation" literal="AGGREGATION"
	 * @generated
	 * @ordered
	 */
	public static final int AGGREGATION_VALUE = 0;

	/**
	 * The '<em><b>Exhibition</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Exhibition</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXHIBITION
	 * @model name="Exhibition" literal="EXHIBITION"
	 * @generated
	 * @ordered
	 */
	public static final int EXHIBITION_VALUE = 1;

	/**
	 * An array of all the '<em><b>Structural Link Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final OPStructuralLinkKind[] VALUES_ARRAY =
		new OPStructuralLinkKind[] {
			AGGREGATION,
			EXHIBITION,
		};

	/**
	 * A public read-only list of all the '<em><b>Structural Link Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<OPStructuralLinkKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Structural Link Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OPStructuralLinkKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OPStructuralLinkKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Structural Link Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OPStructuralLinkKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OPStructuralLinkKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Structural Link Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OPStructuralLinkKind get(int value) {
		switch (value) {
			case AGGREGATION_VALUE: return AGGREGATION;
			case EXHIBITION_VALUE: return EXHIBITION;
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
	private OPStructuralLinkKind(int value, String name, String literal) {
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
	
} //OPStructuralLinkKind
