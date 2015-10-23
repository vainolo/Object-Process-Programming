/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
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
  private UUID id;

  private OPPObjectInstance(InstanceKind type) {
    this.kind = type;
    this.id = UUID.randomUUID();
  }

  public String getId() {
    return id.toString();
  }

  // Creation
  public static OPPObjectInstance createCompositeInstance() {
    return new OPPObjectInstance(InstanceKind.COMPOSITE);
  }

  public static OPPObjectInstance createFromValue(BigDecimal decimalValue) {
    Preconditions.checkNotNull(decimalValue, "Value cannot be null.");
    OPPObjectInstance instance = new OPPObjectInstance(InstanceKind.NUMERICAL);
    instance.setValue(decimalValue);
    return instance;
  }

  public static OPPObjectInstance createFromValue(String stringValue) {
    Preconditions.checkNotNull(stringValue, "Value cannot be null.");
    OPPObjectInstance instance = new OPPObjectInstance(InstanceKind.STRING);
    instance.setValue(stringValue);
    return instance;
  }

  public static OPPObjectInstance createFromValue(Object object) {
    Preconditions.checkNotNull(object);
    OPPObjectInstance instance = new OPPObjectInstance(InstanceKind.JAVA_OBJECT);
    instance.setValue(object);
    return instance;
  }

  public static OPPObjectInstance createFromExistingInstance(OPPObjectInstance existingInstance) {
    Preconditions.checkNotNull(existingInstance, "Existing instance cannot be null.");
    OPPObjectInstance newInstance = null;
    switch (existingInstance.kind) {
    case NUMERICAL:
      newInstance = createFromValue(existingInstance.getNumericalValue());
      break;
    case STRING:
      newInstance = createFromValue(existingInstance.getStringValue());
      break;
    case JAVA_OBJECT:
      newInstance = createFromValue(existingInstance.getValue());
      break;
    case COMPOSITE:
      newInstance = createCompositeInstance();
      for (Integer index : existingInstance.compositeValues.keySet()) {
        newInstance.compositeValues.put(index, existingInstance.compositeValues.get(index));
        newInstance.compositeKeyToIndexMapping.inverse().put(index, existingInstance.compositeKeyToIndexMapping.inverse().get(index));
      }
    default:
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
    if (InstanceKind.STRING.equals(kind)) {
      return (String) getValue();
    } else if (InstanceKind.NUMERICAL.equals(kind)) {
      return ((BigDecimal) getValue()).toString();
    } else {
      throw new IllegalStateException("Cannot fetch value of an instance that is not a value");
    }
  }

  public BigDecimal getNumericalValue() {
    checkTypeForValueOnlyOperations();
    if (InstanceKind.STRING.equals(kind)) {
      return new BigDecimal(String.class.cast(getValue()));
    } else if (InstanceKind.NUMERICAL.equals(kind)) {
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
    compositeKeyToIndexMapping.put(UUID.randomUUID().toString(), newKey);
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
    compositeKeyToIndexMapping.put(UUID.randomUUID().toString(), newKey);
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
    return compositeValues.get(compositeKeyToIndexMapping.get(key));
  }

  public OPPObjectInstance getFirstPart() {
    checkTypeForCompositeOnlyOperations();
    return compositeValues.get(compositeValues.firstKey());
  }

  public OPPObjectInstance getLastPart() {
    checkTypeForCompositeOnlyOperations();
    return compositeValues.get(compositeValues.lastKey());
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
    switch (key.kind) {
    case STRING:
    case NUMERICAL:
      part = removePart(key.getStringValue());
      break;
    case COMPOSITE:
      part = removePart(key.getId());
      break;
    case JAVA_OBJECT:
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
    if (InstanceKind.STRING.equals(kind) || InstanceKind.NUMERICAL.equals(kind)) {
      return value.toString();
    } else if (InstanceKind.COMPOSITE.equals(kind)) {
      StringBuilder ret = new StringBuilder("{");
      for (Integer index : compositeValues.keySet()) {
        ret.append(compositeKeyToIndexMapping.inverse().get(index).toString() + ":" + compositeValues.get(index).toString() + ",");
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
    checkState(!InstanceKind.COMPOSITE.equals(kind), "Instance is a collection but operation is only valid for value instances.");
  }

  private void checkTypeForCompositeOnlyOperations() {
    checkState(InstanceKind.COMPOSITE.equals(kind), "Collection operations can only be applied to collection instances.");
  }

  public enum InstanceKind {
    NUMERICAL, STRING, JAVA_OBJECT, COMPOSITE;
  }

}
