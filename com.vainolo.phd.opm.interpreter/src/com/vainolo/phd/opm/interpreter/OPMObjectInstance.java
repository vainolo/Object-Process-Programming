/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import static com.google.common.base.Preconditions.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

/**
 * And instance of an OPM Object. An OPM object can have two primary constructs:
 * it either has a value or is composite. Values can be {@link String},
 * {@link BigDecimal}, or a state, which is treated pretty similarly to a
 * string.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMObjectInstance {

  private Object value = null;
  private String state = null;
  private Map<String, OPMObjectInstance> parts = Maps.newHashMap();

  private OPMObjectInstance() {
  }

  public static OPMObjectInstance createCompositeInstance() {
    return new OPMObjectInstance();
  }

  public static OPMObjectInstance createFromValue(BigDecimal decimalValue) {
    Preconditions.checkNotNull(decimalValue, "Value cannot be null.");
    OPMObjectInstance instance = new OPMObjectInstance();
    instance.setValue(decimalValue);
    return instance;
  }

  public static OPMObjectInstance createFromValue(String stringValue) {
    Preconditions.checkNotNull(stringValue, "Value cannot be null.");
    OPMObjectInstance instance = new OPMObjectInstance();
    instance.setValue(stringValue);
    return instance;
  }

  // public static OPMObjectInstance createFromState(String state) {
  // Preconditions.checkNotNull(state, "State cannot be null.");
  // OPMObjectInstance instance = new OPMObjectInstance();
  // instance.setState(state);
  // return instance;
  // }

  public static OPMObjectInstance createFromExistingInstance(OPMObjectInstance existingInstance) {
    Preconditions.checkNotNull(existingInstance, "Existing instance cannot be null.");
    OPMObjectInstance newInstance = null;
    if(existingInstance.isValue()) {
      if(existingInstance.isNumericalValue()) {
        newInstance = createFromValue(existingInstance.getNumericalValue());
      } else if(existingInstance.isStringValue()) {
        newInstance = createFromValue(existingInstance.getStringValue());
      }
    } else if(existingInstance.isComposite()) {
      newInstance = createCompositeInstance();
      for(Entry<String, OPMObjectInstance> part : existingInstance.getParts()) {
        newInstance.addPart(part.getKey(), createFromExistingInstance(part.getValue()));
      }
    } else {
      throw new IllegalStateException("Unexpected type of object.");
    }
    return newInstance;
  }

  private void setValue(Object value) {
    checkNotNull(value, "Cannot set null value to variable.");
    this.value = value;
  }

  public Object getValue() {
    checkState(value != null, "Value of variable is not set.");
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

  // public String getState() {
  // checkState(state != null, "State of variable is not set.");
  // return state;
  // }

  // public boolean isState() {
  // return state != null;
  // }

  public boolean isValue() {
    return value != null;
  }

  public boolean isNumericalValue() {
    if(isValue()) {
      if(BigDecimal.class.isInstance(value)) {
        return true;
      }
    }
    return false;
  }

  public boolean isStringValue() {
    if(isValue()) {
      if(String.class.isInstance(value)) {
        return true;
      }
    }
    return false;
  }

  public boolean isComposite() {
    return (value == null) && (state == null);
  }

  @Override
  public String toString() {
    if(state != null)
      return state;
    else if(value != null)
      return value.toString();
    else if(parts.size() > 0) {
      StringBuilder ret = new StringBuilder("{");
      for(String partName : parts.keySet()) {
        ret.append(partName + ":" + parts.get(partName) + ",");
      }
      ret.replace(ret.length() - 1, ret.length(), "}");
      return ret.toString();
    } else {
      throw new IllegalStateException();
    }
  }

  public void addPart(String name, OPMObjectInstance part) {
    checkNotNull(name);
    checkNotNull(part);
    checkState(isComposite());
    parts.put(name, part);
  }

  public OPMObjectInstance getPart(String name) {
    checkNotNull(name, "Part name cannot be null");
    checkArgument(!"".equals(name), "Part name cannot be empty");
    checkState(isComposite());
    return parts.get(name);
  }

  public Set<Entry<String, OPMObjectInstance>> getParts() {
    checkState(isComposite());
    return Collections.unmodifiableSet(parts.entrySet());
  }

  private enum InstanceType {
    NUMERICAL, STRING, COMPOSITE, COLLECTION;
  }
}
