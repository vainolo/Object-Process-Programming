/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Preconditions;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class Variable {

  private String name;
  private Object value;
  private boolean valueSet = false;

  public Variable(String name) {
    checkNotNull(name, "Variable name cannot be null.");
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

  public String getName() {
    return name;
  }
}
