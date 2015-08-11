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
 * A representation of the literals of the enumeration '<em><b>Link Router Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.vainolo.phd.opm.model.OPMPackage#getOPMLinkRouterKind()
 * @model
 * @generated
 */
public enum OPMLinkRouterKind implements Enumerator {
    /**
   * The '<em><b>BENDPOINT</b></em>' literal object.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #BENDPOINT_VALUE
   * @generated
   * @ordered
   */
    BENDPOINT(0, "BENDPOINT", "Bendpoint"),

    /**
   * The '<em><b>MANHATTAN</b></em>' literal object.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #MANHATTAN_VALUE
   * @generated
   * @ordered
   */
    MANHATTAN(1, "MANHATTAN", "Manhattan");

    /**
   * The '<em><b>BENDPOINT</b></em>' literal value.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>BENDPOINT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @see #BENDPOINT
   * @model literal="Bendpoint"
   * @generated
   * @ordered
   */
    public static final int BENDPOINT_VALUE = 0;

    /**
   * The '<em><b>MANHATTAN</b></em>' literal value.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>MANHATTAN</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @see #MANHATTAN
   * @model literal="Manhattan"
   * @generated
   * @ordered
   */
    public static final int MANHATTAN_VALUE = 1;

    /**
   * An array of all the '<em><b>Link Router Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private static final OPMLinkRouterKind[] VALUES_ARRAY =
        new OPMLinkRouterKind[] {
      BENDPOINT,
      MANHATTAN,
    };

    /**
   * A public read-only list of all the '<em><b>Link Router Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public static final List<OPMLinkRouterKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
   * Returns the '<em><b>Link Router Kind</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public static OPMLinkRouterKind get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      OPMLinkRouterKind result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

    /**
   * Returns the '<em><b>Link Router Kind</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public static OPMLinkRouterKind getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      OPMLinkRouterKind result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

    /**
   * Returns the '<em><b>Link Router Kind</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public static OPMLinkRouterKind get(int value) {
    switch (value) {
      case BENDPOINT_VALUE: return BENDPOINT;
      case MANHATTAN_VALUE: return MANHATTAN;
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
    private OPMLinkRouterKind(int value, String name, String literal) {
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
    
} //OPMLinkRouterKind
