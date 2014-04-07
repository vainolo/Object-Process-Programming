package com.vainolo.phd.opm.interpreter;

import java.math.BigDecimal;
import java.util.Collection;

import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMState;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

/**
 * Helper class to analyze {@link OPMObject} and {@link OPMState} values. All of
 * the methods in this class assume that the passed value is neither
 * <code>null</code> nor empty.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPMObjectInstanceValueAnalyzer {
  /**
   * Check if the value is a string literal. This is done by checking if the
   * initial character in the value is either a " or a '.
   * 
   * @param value
   *          to check. Must not be <code>null</code> or empty.
   * @return <code>true</code> if the value is a string literal,
   *         <code>false</code> otherwise.
   */
  public boolean isStringValue(String value) {
    if(value.startsWith("\"") || value.startsWith("'"))
      return true;
    else
      return false;
  }

  /**
   * Parse a string literal, removing starting and ending "/'.
   * 
   * @param value
   *          to parse. Must not be <code>null</code> or empty.
   * @return the string represented in this string literal.
   */
  public String parseStringValue(String value) {
    return value.substring(1, value.length() - 1);
  }

  /**
   * Check if the value is a number. This is done by checking if the first
   * character of the value is a number.
   * 
   * @param value
   *          to check. Must not be <code>null</code> or empty.
   * @return <code>true</code> if the value is a number, false otherwise.
   */
  public boolean isNumericalValue(String value) {
    return value.matches("-?\\d+(\\.\\d+)?");
  }

  /**
   * Parse a number literal.
   * 
   * @param value
   *          to parse. Must not be <code>null</code> or empty.
   * @return the value that the literal represents.
   */
  public BigDecimal parseNumericalValue(String value) {
    return new BigDecimal(value);
  }

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
  public OPMObjectInstance calculateOPMObjectValue(OPMObject object, OPDAnalyzer analyzer) {
    OPMObjectInstanceValueAnalyzer valueAnalyzer = new OPMObjectInstanceValueAnalyzer();
    OPMObjectInstance objectInstance = null;
  
    String objectName = object.getName();
    if(objectName != null && !objectName.equals("")) {
      if(valueAnalyzer.isStringValue(objectName)) {
        objectInstance = OPMObjectInstance.createFromValue(valueAnalyzer.parseStringValue(objectName));
      } else if(valueAnalyzer.isNumericalValue(objectName)) {
        objectInstance = OPMObjectInstance.createFromValue(valueAnalyzer.parseNumericalValue(objectName));
      }
    } else {
      Collection<OPMState> states = analyzer.findStates(object);
      for(OPMState state : states) {
        if(state.isValue()) {
          objectInstance = OPMObjectInstance.createFromState(state.getName());
        }
      }
    }
    return objectInstance;
  }

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
  public boolean isObjectValueInState(String stateName, BigDecimal value) {
    if(isNumericalValue(stateName)) {
      return parseNumericalValue(stateName).equals(value);
    } else {
      // state name is a numerical logical expression
      // supported expressions are: x < NUM, x <= NUM, x > NUM, x >= NUM. Spaces
      // are MANDATORY
      String[] split = stateName.split(" ");
      BigDecimal number = new BigDecimal(split[2]);
      switch(split[1]) {
      case "<":
        return value.compareTo(number) == -1;
      case "<=":
        return value.compareTo(number) == -1 || value.compareTo(number) == 0;
      case ">":
        return value.compareTo(number) == 1;
      case ">=":
        return value.compareTo(number) == 1 || value.compareTo(number) == 0;
      }
  
    }
    return false;
  }

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
  public boolean isObjectInstanceInState(OPMObjectInstance instance, OPMState state) {
    if(instance == null) {
      return false;
    }
    if(instance.isState()) {
      return state.getName().equals(instance.getState());
    } else {
      if(isStringValue(state.getName())) {
        return parseStringValue(state.getName()).equals(instance.getValue());
      } else {
        return isObjectValueInState(state.getName(), BigDecimal.class.cast(instance.getValue()));
      }
    }
  }
}
