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
 * A representation of the literals of the enumeration '<em><b>Process Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMProcessKind()
 * @model
 * @generated
 */
public enum OPMProcessKind implements Enumerator {
	/**
   * The '<em><b>COMPOUND</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #COMPOUND_VALUE
   * @generated
   * @ordered
   */
	COMPOUND(0, "COMPOUND", "Compound"),

	/**
   * The '<em><b>BUILT IN</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #BUILT_IN_VALUE
   * @generated
   * @ordered
   */
	BUILT_IN(1, "BUILT_IN", "Built In"),

	/**
   * The '<em><b>JAVA</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #JAVA_VALUE
   * @generated
   * @ordered
   */
	JAVA(2, "JAVA", "Java"), /**
   * The '<em><b>CONCEPTUAL</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #CONCEPTUAL_VALUE
   * @generated
   * @ordered
   */
	CONCEPTUAL(3, "CONCEPTUAL", "Conceptual");

	/**
   * The '<em><b>COMPOUND</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMPOUND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #COMPOUND
   * @model literal="Compound"
   * @generated
   * @ordered
   */
	public static final int COMPOUND_VALUE = 0;

	/**
   * The '<em><b>BUILT IN</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BUILT IN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #BUILT_IN
   * @model literal="Built In"
   * @generated
   * @ordered
   */
	public static final int BUILT_IN_VALUE = 1;

	/**
   * The '<em><b>JAVA</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JAVA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #JAVA
   * @model literal="Java"
   * @generated
   * @ordered
   */
	public static final int JAVA_VALUE = 2;

	/**
   * The '<em><b>CONCEPTUAL</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONCEPTUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #CONCEPTUAL
   * @model literal="Conceptual"
   * @generated
   * @ordered
   */
	public static final int CONCEPTUAL_VALUE = 3;

	/**
   * An array of all the '<em><b>Process Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private static final OPMProcessKind[] VALUES_ARRAY =
		new OPMProcessKind[] {
      COMPOUND,
      BUILT_IN,
      JAVA,
      CONCEPTUAL,
    };

	/**
   * A public read-only list of all the '<em><b>Process Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static final List<OPMProcessKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
   * Returns the '<em><b>Process Kind</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static OPMProcessKind get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      OPMProcessKind result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

	/**
   * Returns the '<em><b>Process Kind</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static OPMProcessKind getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      OPMProcessKind result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

	/**
   * Returns the '<em><b>Process Kind</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static OPMProcessKind get(int value) {
    switch (value) {
      case COMPOUND_VALUE: return COMPOUND;
      case BUILT_IN_VALUE: return BUILT_IN;
      case JAVA_VALUE: return JAVA;
      case CONCEPTUAL_VALUE: return CONCEPTUAL;
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
	private OPMProcessKind(int value, String name, String literal) {
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
	
} //OPMProcessKind
