package com.vainolo.phd.opm.interpreter;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMState;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

import static com.google.common.base.Preconditions.*;

/**
 * Helper class to analyze {@link OPMObject} and {@link OPMState} values. All of
 * the methods in this class assume that the passed value is neither
 * <code>null</code> nor empty.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPMObjectInstanceValueAnalyzerImpl implements OPMObjectInstanceValueAnalyzer {
  /**
   * Check if the value is a string literal. This is done by checking if the
   * initial character in the value is either a " or a '.
   * 
   * @param value
   *          to check. Must not be <code>null</code> or empty.
   * @return <code>true</code> if the value is a string literal,
   *         <code>false</code> otherwise.
   */
  private boolean isStringLiteral(String value) {
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
  private String parseStringLiteral(String value) {
    return value.substring(1, value.length() - 1);
  }

  /**
   * Check if the literal is a number. This is done by checking if the first
   * character of the value is a number.
   * 
   * @param value
   *          to check. Must not be <code>null</code> or empty.
   * @return <code>true</code> if the value is a number, false otherwise.
   */
  private boolean isNumericalLiteral(String value) {
    return value.matches("-?\\d+(\\.\\d+)?");
  }

  /**
   * Parse a number literal.
   * 
   * @param value
   *          to parse. Must not be <code>null</code> or empty.
   * @return the value that the literal represents.
   */
  private BigDecimal parseNumericalLiteral(String value) {
    return new BigDecimal(value);
  }

  /**
   * Check if the literal is a collections. Collections can be initialized with
   * a set of integer values that are specified in the initializer. The first
   * value of the collection must be less than or equal than the final value of
   * the collection. For example [1..5], [1..1], [5..19]
   */
  public boolean isCollectionLiteral(String value) {
    return value.startsWith("[");
  }

  /**
   * Check if the value is a collections. Collections can be initialized with a
   * set of integer values that are specified in the initializer. The first
   * value of the collection must be less than or equal than the final value of
   * the collection. For example [1..5], [1..1], [5..19]
   */
  public List<BigDecimal> parseCollectionLiteral(String literal) {
    List<BigDecimal> collection = Lists.newArrayList();
    literal = literal.substring(1, literal.length() - 1);
    String[] indices = literal.split("\\.\\.");
    int start = Integer.parseInt(indices[0]);
    int end = Integer.parseInt(indices[1]);
    if(start <= end) {
      for(int i = start; i <= end; i++) {
        collection.add(new BigDecimal(i));
      }
    } else {
      for(int i = start; i >= end; i--) {
        collection.add(new BigDecimal(i));
      }
    }
    return collection;
  }

  /**
   * Calculate the value of an {@link OPMObjectInstance} based on the
   * {@link OPMObject} that represents it. The value can be either a number, a
   * string a state or a collection initializer.
   * 
   * @param object
   *          that has a constant value
   * @param analyzer
   * @return the value of the {@link OPMObjectInstance}
   */
  @Override
  public OPMObjectInstance calculateOPMObjectValue(OPMObject object, OPDAnalyzer analyzer) {
    OPMObjectInstance objectInstance = null;

    String objectName = object.getName();
    if(objectName != null && !"".equals(objectName)) {
      if(isStringLiteral(objectName)) {
        objectInstance = OPMObjectInstance.createFromValue(parseStringLiteral(objectName));
      } else if(isNumericalLiteral(objectName)) {
        objectInstance = OPMObjectInstance.createFromValue(parseNumericalLiteral(objectName));
      } else if(isCollectionLiteral(objectName)) {
        objectInstance = OPMObjectInstance.createCollectionInstace();
        for(BigDecimal value : parseCollectionLiteral(objectName)) {
          objectInstance.appendCollectionElement(OPMObjectInstance.createFromValue(value));
        }
      }
    } else {
      Collection<OPMState> states = analyzer.findStates(object);
      for(OPMState state : states) {
        if(state.isValue()) {
          objectInstance = OPMObjectInstance.createFromValue(state.getName());
        }
      }
    }
    return objectInstance;
  }

  @Override
  public OPMObjectInstance calculateOPMObjectValue(String value) {
    checkArgument((value != null) && (!"".equals(value)), "Value cannot be null or empty.");
    OPMObjectInstance objectInstance = null;
    if(isStringLiteral(value)) {
      objectInstance = OPMObjectInstance.createFromValue(parseStringLiteral(value));
    } else if(isNumericalLiteral(value)) {
      objectInstance = OPMObjectInstance.createFromValue(parseNumericalLiteral(value));
    } else if(isCollectionLiteral(value)) {
      objectInstance = OPMObjectInstance.createCollectionInstace();
      for(BigDecimal v : parseCollectionLiteral(value)) {
        objectInstance.appendCollectionElement(OPMObjectInstance.createFromValue(v));
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
  @Override
  public boolean isObjectNumericalValueInState(String stateName, BigDecimal value) {
    if(isNumericalLiteral(stateName)) {
      return parseNumericalLiteral(stateName).equals(value);
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
  @Override
  public boolean isObjectInstanceInState(OPMObjectInstance instance, OPMState state) {
    if(instance == null) {
      return false;
    }
    if(isStringLiteral(state.getName())) {
      return parseStringLiteral(state.getName()).equals(instance.getValue());
    } else {
      return isObjectNumericalValueInState(state.getName(), BigDecimal.class.cast(instance.getValue()));
    }
  }
}
