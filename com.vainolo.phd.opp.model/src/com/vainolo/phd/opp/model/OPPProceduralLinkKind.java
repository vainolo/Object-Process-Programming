/**
 */
package com.vainolo.phd.opp.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Procedural Link Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.vainolo.phd.opp.model.OPPPackage#getOPPProceduralLinkKind()
 * @model
 * @generated
 */
public enum OPPProceduralLinkKind implements Enumerator {
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
   * The '<em><b>CONS RES</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CONS_RES_VALUE
   * @generated
   * @ordered
   */
  CONS_RES(1, "CONS_RES", "Consumption/Result"), /**
   * The '<em><b>INSTRUMENT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INSTRUMENT_VALUE
   * @generated
   * @ordered
   */
  INSTRUMENT(2, "INSTRUMENT", "Instrument");

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
   * The '<em><b>CONS RES</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CONS RES</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CONS_RES
   * @model literal="Consumption/Result"
   * @generated
   * @ordered
   */
  public static final int CONS_RES_VALUE = 1;

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
  public static final int INSTRUMENT_VALUE = 2;

  /**
   * An array of all the '<em><b>Procedural Link Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final OPPProceduralLinkKind[] VALUES_ARRAY =
    new OPPProceduralLinkKind[] {
      AGENT,
      CONS_RES,
      INSTRUMENT,
    };

  /**
   * A public read-only list of all the '<em><b>Procedural Link Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<OPPProceduralLinkKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Procedural Link Kind</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static OPPProceduralLinkKind get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      OPPProceduralLinkKind result = VALUES_ARRAY[i];
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
  public static OPPProceduralLinkKind getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      OPPProceduralLinkKind result = VALUES_ARRAY[i];
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
  public static OPPProceduralLinkKind get(int value) {
    switch (value) {
      case AGENT_VALUE: return AGENT;
      case CONS_RES_VALUE: return CONS_RES;
      case INSTRUMENT_VALUE: return INSTRUMENT;
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
  private OPPProceduralLinkKind(int value, String name, String literal) {
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
  
} //OPPProceduralLinkKind
