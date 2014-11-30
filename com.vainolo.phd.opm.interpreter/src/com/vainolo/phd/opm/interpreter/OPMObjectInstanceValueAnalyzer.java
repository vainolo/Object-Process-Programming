package com.vainolo.phd.opm.interpreter;

import java.math.BigDecimal;
import java.util.Collection;

import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMState;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

public interface OPMObjectInstanceValueAnalyzer {

  /**
   * Calculate the value of an {@link OPMObjectInstance} based on a string.
   * 
   * @param value
   *          a string that represents a possible OPM{@link OPMObjectInstance}
   *          value, which can be a string, a number or a collection
   *          initializer.
   * @return the value of the {@link OPMObjectInstance}
   */
  public OPMObjectInstance calculateOPMObjectValue(String value);

  /**
   * Calculate the value of an {@link OPMObjectInstance} based on the
   * {@link OPMObject} that represents it. The value can be either a number, a
   * string or a state.
   * 
   * @param object
   *          that has a constant value
   * @param analyzer
   * @return the value of the {@link OPMObjectInstance}
   */
  public OPMObjectInstance calculateOPMObjectValue(OPMObject object, OPDAnalyzer analyzer);

  /**
   * Calculate if the value of an object is in a given state.
   * 
   * @param stateName
   *          the text in the state
   * @param value
   *          of the object instance that containts the state
   * @return <code>true</code> if the value of the object instance matches the
   *         state, <code>false</code> otherwise.
   */
  public boolean isObjectNumericalValueInState(String stateName, BigDecimal value);

  /**
   * Calculate if an object instance is in a state. There are three ways for
   * this to happen:
   * <ol>
   * <li>If the instance has state values, the current state must match the
   * given state</li>
   * <li>If the instance is a string value, the current value must match the
   * given state. In this case, the state contains a string surrounded by """</li>
   * <li>If the instance is a numeric value, the current value must match a
   * numerical comparison to the state. We curently support equality (state with
   * a number in it) and inequalities written "x op VAL" where x is the letter
   * x, the operator can be any of <, <=, >, and >=, and the value is a valid
   * number.
   * </ol>
   * 
   * @param instance
   *          the instance to check
   * @param state
   *          the required state
   * @return <code>true</code> if the instance is in the specific state, <code>
   *         false</code> otherwise.
   */
  public boolean isObjectInstanceInState(OPMObjectInstance instance, OPMState state);

}