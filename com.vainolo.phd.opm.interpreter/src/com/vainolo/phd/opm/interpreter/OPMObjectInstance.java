/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import static com.google.common.base.Preconditions.checkNotNull;

import java.math.BigDecimal;

import javax.naming.OperationNotSupportedException;

import com.google.common.base.Preconditions;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMObjectInstance {

  private Object value = null;
  private boolean valueSet = false;
  private String state = null;

  private OPMObjectInstance() {
  }

  public static OPMObjectInstance createFromValue(Object o) {
    throw new UnsupportedOperationException();
  }

  public static OPMObjectInstance createFromValue(BigDecimal o) {
    OPMObjectInstance instance = new OPMObjectInstance();
    instance.setValue(o);
    return instance;
  }

  public static OPMObjectInstance createFromValue(String o) {
    OPMObjectInstance instance = new OPMObjectInstance();
    instance.setValue(o);
    return instance;
  }

  public static OPMObjectInstance createFromState(String state) {
    OPMObjectInstance instance = new OPMObjectInstance();
    instance.setState(state);
    return instance;
  }

  private void setState(String state) {
    checkNotNull(state, "Cannot set null state to variable.");
    this.state = state;
  }

  private void setValue(Object value) {
    checkNotNull(value, "Cannot set null value to variable.");
    this.value = value;
    valueSet = true;
  }

  public Object getValue() {
    Preconditions.checkState(value != null, "Value of variable is not set.");
    return value;
  }

  public String getStringValue() {
    Object value = getValue();
    if(String.class.isInstance(value)) {
      return String.class.cast(value);
    } else if(BigDecimal.class.isInstance(value)) {
      return BigDecimal.class.cast(value).toString();
    } else {
      return null;
    }
  }

  public BigDecimal getNumericalValue() {
    Object value = getValue();
    if(String.class.isInstance(value)) {
      return new BigDecimal(String.class.cast(value));
    } else if(BigDecimal.class.isInstance(value)) {
      return BigDecimal.class.cast(value);
    } else {
      return null;

    }
  }

  public String getState() {
    Preconditions.checkState(state != null, "State of variable is not set.");
    return state;
  }

  public boolean isState() {
    return state != null;
  }

  public boolean isValue() {
    return value != null;
  }

  @Override
  public String toString() {
    if(state != null)
      return state;
    else
      return value.toString();
  }

}
