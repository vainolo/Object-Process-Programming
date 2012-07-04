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
 * A representation of the literals of the enumeration '<em><b>Structural Link Aggregator Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMStructuralLinkAggregatorKind()
 * @model
 * @generated
 */
public enum OPMStructuralLinkAggregatorKind implements Enumerator {
	/**
   * The '<em><b>AGGREGATION</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #AGGREGATION_VALUE
   * @generated
   * @ordered
   */
	AGGREGATION(0, "AGGREGATION", "Aggregation"),

	/**
   * The '<em><b>EXHIBITION</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #EXHIBITION_VALUE
   * @generated
   * @ordered
   */
	EXHIBITION(1, "EXHIBITION", "Exhibition"),

	/**
   * The '<em><b>GENERALIZATION</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #GENERALIZATION_VALUE
   * @generated
   * @ordered
   */
	GENERALIZATION(2, "GENERALIZATION", "Generalization");

	/**
   * The '<em><b>AGGREGATION</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AGGREGATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #AGGREGATION
   * @model literal="Aggregation"
   * @generated
   * @ordered
   */
	public static final int AGGREGATION_VALUE = 0;

	/**
   * The '<em><b>EXHIBITION</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXHIBITION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #EXHIBITION
   * @model literal="Exhibition"
   * @generated
   * @ordered
   */
	public static final int EXHIBITION_VALUE = 1;

	/**
   * The '<em><b>GENERALIZATION</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GENERALIZATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #GENERALIZATION
   * @model literal="Generalization"
   * @generated
   * @ordered
   */
	public static final int GENERALIZATION_VALUE = 2;

	/**
   * An array of all the '<em><b>Structural Link Aggregator Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private static final OPMStructuralLinkAggregatorKind[] VALUES_ARRAY =
		new OPMStructuralLinkAggregatorKind[] {
      AGGREGATION,
      EXHIBITION,
      GENERALIZATION,
    };

	/**
   * A public read-only list of all the '<em><b>Structural Link Aggregator Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static final List<OPMStructuralLinkAggregatorKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
   * Returns the '<em><b>Structural Link Aggregator Kind</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static OPMStructuralLinkAggregatorKind get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      OPMStructuralLinkAggregatorKind result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

	/**
   * Returns the '<em><b>Structural Link Aggregator Kind</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static OPMStructuralLinkAggregatorKind getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      OPMStructuralLinkAggregatorKind result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

	/**
   * Returns the '<em><b>Structural Link Aggregator Kind</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static OPMStructuralLinkAggregatorKind get(int value) {
    switch (value) {
      case AGGREGATION_VALUE: return AGGREGATION;
      case EXHIBITION_VALUE: return EXHIBITION;
      case GENERALIZATION_VALUE: return GENERALIZATION;
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
	private OPMStructuralLinkAggregatorKind(int value, String name, String literal) {
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
	
} //OPMStructuralLinkAggregatorKind
