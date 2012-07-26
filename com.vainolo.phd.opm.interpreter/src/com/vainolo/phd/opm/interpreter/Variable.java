/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import com.google.common.base.Preconditions;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class Variable {

  private String name;
  private Object value;
  private boolean valueSet = false;

  public void setName(String name) {
    checkNotNull(name);
    this.name = name;
  }

  public void setValue(Object value) {
    checkNotNull(value);
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
    Preconditions.checkState(isValueSet());
    return value;
  }

  public String getName() {
    return name;
  }

}
