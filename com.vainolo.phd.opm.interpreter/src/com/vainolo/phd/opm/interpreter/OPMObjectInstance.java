/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMObjectInstance {

  private Object value = null;
  private boolean valueSet = false;

  private OPMObjectInstance() {
  }

  public static OPMObjectInstance create(Object o) {
    OPMObjectInstance instance = new OPMObjectInstance();
    instance.setValue(o);
    return instance;
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

  @Override
  public String toString() {
    if(isValueSet())
      return getValue().toString();
    else
      return "Nothing";
  }

}
