/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import static com.google.common.base.Preconditions.*;

import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMObjectInstance {
  public static final String UNKNOWN_STATE = "unknown";

  private Object value;
  private boolean valueSet = false;

  private final Set<String> states = Sets.newHashSet(); // TODO: if the variable is of a specified type the states
                                                        // should be defined in that type.
  private String currentState = UNKNOWN_STATE;

  public OPMObjectInstance() {
  }

  public void setValue(Object value) {
    checkNotNull(value, "Cannot set null value to variable. Use unsetValue instead.");
    this.value = value;
    valueSet = true;
  }

  public void unsetValue() {
    valueSet = false;
    value = null;
  }

  public boolean isValueSet() {
    return valueSet;
  }

  public Object getValue() {
    Preconditions.checkState(isValueSet(), "Value of variable is not set.");
    return value;
  }

  public void addState(String stateName) {
    checkNotNull(stateName, "State name cannot be null");
    checkState(!states.contains(stateName), "State %s is already defined in instance.", stateName);
    states.add(stateName);
  }

  public void setState(String stateName) {
    checkNotNull(stateName, "State name cannot be null");
    if(!states.contains(stateName))
      states.add(stateName);
    currentState = stateName;
  }

  public String getState() {
    return currentState;
  }

  @Override
  public String toString() {
    if(isValueSet())
      return getValue().toString();
    else
      return currentState;
  }

}
