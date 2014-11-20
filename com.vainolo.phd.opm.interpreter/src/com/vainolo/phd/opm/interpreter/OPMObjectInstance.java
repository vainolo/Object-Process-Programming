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
  private Map<String, OPMObjectInstance> parts = Maps.newHashMap();
  public final InstanceType type;

  private OPMObjectInstance(InstanceType type) {
    this.type = type;
  }

  public static OPMObjectInstance createCompositeInstance() {
    return new OPMObjectInstance(InstanceType.COMPOSITE);
  }

  public static OPMObjectInstance createCollectionInstace() {
    return new OPMObjectInstance(InstanceType.COLLECTION);
  }

  public static OPMObjectInstance createFromValue(BigDecimal decimalValue) {
    Preconditions.checkNotNull(decimalValue, "Value cannot be null.");
    OPMObjectInstance instance = new OPMObjectInstance(InstanceType.NUMERICAL);
    instance.setValue(decimalValue);
    return instance;
  }

  public static OPMObjectInstance createFromValue(String stringValue) {
    Preconditions.checkNotNull(stringValue, "Value cannot be null.");
    OPMObjectInstance instance = new OPMObjectInstance(InstanceType.STRING);
    instance.setValue(stringValue);
    return instance;
  }

  public static OPMObjectInstance createFromExistingInstance(OPMObjectInstance existingInstance) {
    Preconditions.checkNotNull(existingInstance, "Existing instance cannot be null.");
    OPMObjectInstance newInstance = null;
    if(existingInstance.isValue()) {
      if(existingInstance.type == InstanceType.NUMERICAL) {
        newInstance = createFromValue(existingInstance.getNumericalValue());
      } else if(existingInstance.type == InstanceType.STRING) {
        newInstance = createFromValue(existingInstance.getStringValue());
      }
    } else if(existingInstance.type == InstanceType.COMPOSITE) {
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
    if(type == InstanceType.STRING) {
      return String.class.cast(getValue());
    } else if(type == InstanceType.NUMERICAL) {
      return BigDecimal.class.cast(getValue()).toString();
    } else {
      throw new IllegalStateException("Cannot fetch value of an instance that is not a value");
    }
  }

  public BigDecimal getNumericalValue() {
    if(type == InstanceType.STRING) {
      return new BigDecimal(String.class.cast(getValue()));
    } else if(type == InstanceType.NUMERICAL) {
      return BigDecimal.class.cast(getValue());
    } else {
      throw new IllegalStateException("Cannot fetch value of an instance that is not a value");
    }
  }

  public boolean isValue() {
    return value != null;
  }

  @Override
  public String toString() {
    if(type == InstanceType.STRING || type == InstanceType.NUMERICAL)
      return value.toString();
    else if(type == InstanceType.COMPOSITE) {
      StringBuilder ret = new StringBuilder("{");
      for(String partName : parts.keySet()) {
        ret.append(partName + ":" + parts.get(partName) + ",");
      }
      ret.replace(ret.length() - 1, ret.length(), "}");
      return ret.toString();
    } else {
      return "";
    }
  }

  public void addPart(String name, OPMObjectInstance part) {
    checkState(type == InstanceType.COMPOSITE);
    checkNotNull(name);
    checkNotNull(part);
    parts.put(name, part);
  }

  public OPMObjectInstance getPart(String name) {
    checkState(type == InstanceType.COMPOSITE);
    checkNotNull(name, "Part name cannot be null");
    checkArgument(!"".equals(name), "Part name cannot be empty");
    return parts.get(name);
  }

  public Set<Entry<String, OPMObjectInstance>> getParts() {
    checkState(type == InstanceType.COMPOSITE);
    return Collections.unmodifiableSet(parts.entrySet());
  }

  public enum InstanceType {
    NUMERICAL, STRING, COMPOSITE, COLLECTION;
  }
}
