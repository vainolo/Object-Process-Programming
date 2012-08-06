/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import static com.google.common.base.Preconditions.*;

import java.util.Set;

import com.google.common.collect.Sets;

public class OPMObjectInstance {
  public static final String UNKNOWN_STATE = "unknown";

  private final Set<String> states = Sets.newHashSet();

  private Object value = null;
  private String currentState = UNKNOWN_STATE;

  public OPMObjectInstance() {
  }

  public OPMObjectInstance(Object value) {
    checkNotNull(value, "Value cannot be null");
    this.value = value;
  }

  public void addState(String stateName) {
    checkNotNull(stateName, "State name cannot be null");
    checkState(!states.contains(stateName), "State %s is already defined in instance.", stateName);
    states.add(stateName);
  }

  public void setCurrentState(String stateName) {
    checkNotNull(stateName, "State name cannot be null");
    checkState(states.contains(stateName), "State %s not defined in instance.", stateName);
    currentState = stateName;
  }

  public String getCurrentState() {
    return currentState;
  }

  public void setValue(Object value) {
    checkNotNull(value, "Value cannot be null.");
    this.value = value;
  }

  public Object getValue() {
    return value;
  }
}
