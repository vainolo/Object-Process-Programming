/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter;

import static com.google.common.base.Preconditions.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.SortedMap;
import java.util.UUID;

import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

/**
 * And instance of an OPM Object. An OPM object can have two primary constructs: it either has a value or is composite.
 * Values can be {@link String}, {@link BigDecimal}, or a state, which is treated pretty similarly to a string.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPPObjectInstance {

  private Object value = null;
  private SortedMap<Integer, OPPObjectInstance> compositeValues = Maps.newTreeMap();
  private BiMap<String, Integer> compositeKeyToIndexMapping = HashBiMap.create();
  public final InstanceKind kind;
  public final String type;
  private UUID internalId;

  private OPPObjectInstance(InstanceKind kind, String type) {
    this.kind = kind;
    this.type = type;
    this.internalId = UUID.randomUUID();
  }

  private String getInternalId() {
    return internalId.toString();
  }

  public String getId() {
    switch (type) {
    case "Number":
    case "String":
      return getStringValue();
    case "List":
    case "Complex Object":
      return getInternalId();
    default:
      throw new IllegalStateException();
    }
  }

  // Creation
  public static OPPObjectInstance createCompositeInstance() {
    return new OPPObjectInstance(InstanceKind.COMPOSITE, "Complex Object");
  }

  public static OPPObjectInstance createListInstance() {
    return new OPPObjectInstance(InstanceKind.COMPOSITE, "List");
  }

  public static OPPObjectInstance createFromValue(BigDecimal decimalValue) {
    Preconditions.checkNotNull(decimalValue, "Value cannot be null.");
    OPPObjectInstance instance = new OPPObjectInstance(InstanceKind.NUMERICAL, "Number");
    instance.setValue(decimalValue);
    return instance;
  }

  public static OPPObjectInstance createFromValue(String stringValue) {
    Preconditions.checkNotNull(stringValue, "Value cannot be null.");
    OPPObjectInstance instance = new OPPObjectInstance(InstanceKind.STRING, "String");
    instance.setValue(stringValue);
    return instance;
  }

  public static OPPObjectInstance createFromValue(Object object) {
    Preconditions.checkNotNull(object);
    OPPObjectInstance instance = new OPPObjectInstance(InstanceKind.JAVA_OBJECT, "Java Object");
    instance.setValue(object);
    return instance;
  }

  public static OPPObjectInstance createFromExistingInstance(OPPObjectInstance existingInstance) {
    Preconditions.checkNotNull(existingInstance, "Existing instance cannot be null.");
    OPPObjectInstance newInstance = null;
    switch (existingInstance.type) {
    case "Number":
      newInstance = createFromValue(existingInstance.getNumericalValue());
      break;
    case "String":
      newInstance = createFromValue(existingInstance.getStringValue());
      break;
    case "Complex Object":
    case "List":
      newInstance = createCompositeInstance();
      for (Integer index : existingInstance.compositeValues.keySet()) {
        newInstance.compositeValues.put(index, existingInstance.compositeValues.get(index));
        newInstance.compositeKeyToIndexMapping.inverse().put(index, existingInstance.compositeKeyToIndexMapping.inverse().get(index));
      }
      break;
    case "Java Object":
      newInstance = createFromValue(existingInstance.getValue());
      break;
    }

    return newInstance;
  }

  // Values
  private void setValue(Object value) {
    checkNotNull(value, "Cannot set null value to variable.");
    checkTypeForValueOnlyOperations();
    this.value = value;
  }

  public Object getValue() {
    checkState(value != null, "Value of variable is not set.");
    checkTypeForValueOnlyOperations();
    return value;
  }

  public String getStringValue() {
    checkTypeForValueOnlyOperations();
    if ("String".equals(type)) {
      return (String) getValue();
    } else if ("Number".equals(type)) {
      return ((BigDecimal) getValue()).toString();
    } else {
      throw new IllegalStateException("Cannot fetch value of an instance that is not a value");
    }
  }

  public BigDecimal getNumericalValue() {
    checkTypeForValueOnlyOperations();
    if ("String".equals(type)) {
      return new BigDecimal(String.class.cast(getValue()));
    } else if ("Number".equals(type)) {
      return BigDecimal.class.cast(getValue());
    } else {
      throw new IllegalStateException("Cannot fetch value of an instance that is not a value");
    }
  }

  public boolean isValue() {
    return value != null;
  }

  // Composite
  public void addFirstPart(OPPObjectInstance value) {
    checkTypeForCompositeOnlyOperations();
    checkNotNull(value, "Cannot append a null element to a collection.");
    Integer firstKey = 0;
    if (compositeValues.size() > 0) {
      firstKey = compositeValues.firstKey();
    }
    int newKey = firstKey - 1;
    compositeValues.put(newKey, value);
    compositeKeyToIndexMapping.put(value.getInternalId(), newKey);
  }

  public void addLastPart(OPPObjectInstance value) {
    checkTypeForCompositeOnlyOperations();
    checkNotNull(value, "Cannot append a null element to a collection.");
    Integer lastKey = 0;
    if (compositeValues.size() > 0) {
      lastKey = compositeValues.lastKey();
    }
    int newKey = lastKey + 1;
    compositeValues.put(newKey, value);
    compositeKeyToIndexMapping.put(value.getInternalId(), newKey);
  }

  public void addPart(String name, OPPObjectInstance value) {
    checkTypeForCompositeOnlyOperations();
    checkState((name != null) && !("".equals(name)), "Named location of element must not be null or empty.");
    checkNotNull(value, "Cannot put a null element to a collection.");
    if (compositeKeyToIndexMapping.containsKey(name)) {
      compositeValues.remove(compositeKeyToIndexMapping.get(name));
      compositeKeyToIndexMapping.remove(name);
    }
    int lastKey = 0;
    if (compositeValues.size() > 0) {
      lastKey = compositeValues.lastKey();
    }
    int newKey = lastKey + 1;
    compositeValues.put(newKey, value);
    compositeKeyToIndexMapping.put(name, newKey);
  }

  public boolean containsPart(String key) {
    return compositeKeyToIndexMapping.containsKey(key);
  }

  public OPPObjectInstance getPart(String key) {
    checkTypeForCompositeOnlyOperations();
    checkState((key != null) && (!"".equals(key)), "Key cannot be null or empty.");
    if (containsPart(key)) {
      return compositeValues.get(compositeKeyToIndexMapping.get(key));
    } else {
      return null;
    }
  }

  public OPPObjectInstance getFirstPart() {
    checkTypeForCompositeOnlyOperations();
    if (compositeValues.size() > 0) {
      return compositeValues.get(compositeValues.firstKey());
    } else {
      return null;
    }
  }

  public OPPObjectInstance getLastPart() {
    checkTypeForCompositeOnlyOperations();
    if (compositeValues.size() > 0) {
      return compositeValues.get(compositeValues.lastKey());
    } else {
      return null;
    }
  }

  public Collection<OPPObjectInstance> getAllParts() {
    checkTypeForCompositeOnlyOperations();
    return Collections.unmodifiableCollection(compositeValues.values());
  }

  public Set<String> getAllPartIndexes() {
    checkTypeForCompositeOnlyOperations();
    return Collections.unmodifiableSet(compositeKeyToIndexMapping.keySet());
  }

  public OPPObjectInstance removePart(OPPObjectInstance key) {
    checkTypeForCompositeOnlyOperations();
    checkState(key != null, "Key cannot be null.");
    OPPObjectInstance part = null;
    switch (key.type) {
    case "String":
    case "Number":
      part = removePart(key.getStringValue());
      break;
    case "Complex Object":
    case "List":
      part = removePart(key.getInternalId());
      break;
    case "Java Object":
      throw new OPPRuntimeException("Java object keys are not supported.");
    }
    return part;
  }

  public OPPObjectInstance removePart(String key) {
    checkTypeForCompositeOnlyOperations();
    checkState((key != null) && (!"".equals(key)), "Key cannot be null or empty.");
    Integer index = compositeKeyToIndexMapping.get(key);
    OPPObjectInstance part = compositeValues.remove(index);
    compositeKeyToIndexMapping.remove(key);
    return part;
  }

  public boolean removePartById(String id) {
    checkTypeForCompositeOnlyOperations();
    checkState((id != null) && (!"".equals(id)), "Key cannot be null or empty.");
    Integer foundKey = null;
    for (Integer key : compositeValues.keySet()) {
      OPPObjectInstance value = compositeValues.get(key);
      if (value.getId().equals(id)) {
        foundKey = key;
        break;
      }
    }
    if (foundKey != null) {
      compositeKeyToIndexMapping.inverse().remove(foundKey);
      compositeValues.remove(foundKey);
      return true;
    } else {
      return false;
    }

  }

  public OPPObjectInstance removeFirstPart() {
    checkTypeForCompositeOnlyOperations();
    Integer firstIndex = compositeValues.firstKey();
    OPPObjectInstance firstInstance = compositeValues.remove(firstIndex);
    compositeKeyToIndexMapping.inverse().remove(firstIndex);
    return firstInstance;
  }

  public OPPObjectInstance removeLastPart() {
    checkTypeForCompositeOnlyOperations();
    Integer lastIndex = compositeValues.lastKey();
    OPPObjectInstance lastInstance = compositeValues.remove(lastIndex);
    compositeKeyToIndexMapping.inverse().remove(lastIndex);
    return lastInstance;
  }

  // General
  @Override
  public String toString() {
    if ("String".equals(type) || "Number".equals(type)) {
      return value.toString();
    } else if ("List".equals(type)) {
      StringBuilder ret = new StringBuilder("[");
      for (Integer index : compositeValues.keySet()) {
        ret.append(compositeValues.get(index).toString() + ",");
      }
      if (ret.length() > 2)
        ret.replace(ret.length() - 1, ret.length(), "]");
      else
        ret.append("]");
      return ret.toString();
    } else if ("Complex Object".equals(type)) {
      StringBuilder ret = new StringBuilder("{");
      for (Integer index : compositeValues.keySet()) {
        ret.append("\"" + compositeKeyToIndexMapping.inverse().get(index).toString() + "\" :" + compositeValues.get(index).toString() + ",");
      }
      if (ret.length() > 2)
        ret.replace(ret.length() - 1, ret.length(), "}");
      else
        ret.append("}");
      return ret.toString();
    } else {
      return super.toString();
    }
  }

  private void checkTypeForValueOnlyOperations() {
    checkState(!"Complex Object".equals(type), "Instance is a collection but operation is only valid for value instances.");
  }

  private void checkTypeForCompositeOnlyOperations() {
    checkState("Complex Object".equals(type) || "List".equals(type), "Collection operations can only be applied to collection instances.");
  }

  public enum InstanceKind {
    NUMERICAL, STRING, JAVA_OBJECT, COMPOSITE;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof OPPObjectInstance))
      return false;

    OPPObjectInstance other = (OPPObjectInstance) obj;
    if (this.type != other.type) {
      return false;
    } else {
      if (this.type == "Number") {
        return (this.getNumericalValue().compareTo(other.getNumericalValue()) == 0);
      } else if (type == "String") {
        return this.getStringValue().equals(other.getStringValue());
      } else if (type == "Complex Object" || type == "List") {
        return this.internalId == other.internalId;
      }
    }
    return false;
  }

  @Override
  public int hashCode() {
    switch (type) {
    case "Complex ObBject":
    case "List":
      return internalId.hashCode();
    case "String":
    case "Number":
    case "Java Object":
      return value.hashCode();
    }

    return super.hashCode();
  }
}
