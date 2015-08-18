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
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.UUID;

import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
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
public class OPPObjectInstance {

  private Object value = null;
  private Map<String, OPPObjectInstance> parts = Maps.newHashMap();
  // private List<OPMObjectInstance> collectionValues = Lists.newArrayList();
  private SortedMap<Integer, OPPObjectInstance> collectionValues = Maps.newTreeMap();
  private BiMap<String, Integer> collectionNameToIndexMapping = HashBiMap.create();
  public final InstanceType type;

  private OPPObjectInstance(InstanceType type) {
    this.type = type;
  }

  // Creation
  public static OPPObjectInstance createCompositeInstance() {
    return new OPPObjectInstance(InstanceType.COMPOSITE);
  }

  public static OPPObjectInstance createCollectionInstace() {
    return new OPPObjectInstance(InstanceType.COLLECTION);
  }

  public static OPPObjectInstance createFromValue(BigDecimal decimalValue) {
    Preconditions.checkNotNull(decimalValue, "Value cannot be null.");
    OPPObjectInstance instance = new OPPObjectInstance(InstanceType.NUMERICAL);
    instance.setValue(decimalValue);
    return instance;
  }

  public static OPPObjectInstance createFromValue(String stringValue) {
    Preconditions.checkNotNull(stringValue, "Value cannot be null.");
    OPPObjectInstance instance = new OPPObjectInstance(InstanceType.STRING);
    instance.setValue(stringValue);
    return instance;
  }

  public static OPPObjectInstance createFromExistingInstance(OPPObjectInstance existingInstance) {
    Preconditions.checkNotNull(existingInstance, "Existing instance cannot be null.");
    OPPObjectInstance newInstance = null;
    switch(existingInstance.type) {
    case NUMERICAL:
      newInstance = createFromValue(existingInstance.getNumericalValue());
      break;
    case STRING:
      newInstance = createFromValue(existingInstance.getStringValue());
      break;
    case COMPOSITE:
      newInstance = createCompositeInstance();
      for(Entry<String, OPPObjectInstance> part : existingInstance.getCompositeParts()) {
        newInstance.addCompositePart(part.getKey(), createFromExistingInstance(part.getValue()));
      }
      break;
    case COLLECTION:
      newInstance = createCollectionInstace();
      for(Integer index : existingInstance.collectionValues.keySet()) {
        newInstance.collectionValues.put(index, existingInstance.collectionValues.get(index));
        newInstance.collectionNameToIndexMapping.inverse().put(index,
            existingInstance.collectionNameToIndexMapping.inverse().get(index));
      }
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
    if(InstanceType.STRING.equals(type)) {
      return String.class.cast(getValue());
    } else if(InstanceType.NUMERICAL.equals(type)) {
      return BigDecimal.class.cast(getValue()).toString();
    } else {
      throw new IllegalStateException("Cannot fetch value of an instance that is not a value");
    }
  }

  public BigDecimal getNumericalValue() {
    checkTypeForValueOnlyOperations();
    if(InstanceType.STRING.equals(type)) {
      return new BigDecimal(String.class.cast(getValue()));
    } else if(InstanceType.NUMERICAL.equals(type)) {
      return BigDecimal.class.cast(getValue());
    } else {
      throw new IllegalStateException("Cannot fetch value of an instance that is not a value");
    }
  }

  public boolean isValue() {
    return value != null;
  }

  // Composite
  public void addCompositePart(String name, OPPObjectInstance part) {
    checkTypeForCompositeOnlyOperations();
    checkNotNull(name);
    checkNotNull(part);
    parts.put(name, part);
  }

  public OPPObjectInstance getCompositePart(String name) {
    checkTypeForCompositeOnlyOperations();
    checkNotNull(name, "Part name cannot be null");
    checkArgument(!"".equals(name), "Part name cannot be empty");
    return parts.get(name);
  }

  public Set<Entry<String, OPPObjectInstance>> getCompositeParts() {
    checkTypeForCompositeOnlyOperations();
    return Collections.unmodifiableSet(parts.entrySet());
  }

  // Collection
  public int appendCollectionElement(OPPObjectInstance value) {
    checkTypeForCollectionOnlyOperations();
    checkNotNull(value, "Cannot append a null element to a collection.");
    Integer lastKey = 0;
    if(collectionValues.size() > 0) {
      lastKey = collectionValues.lastKey();
    }
    int newKey = lastKey + 1;
    collectionValues.put(newKey, value);
    collectionNameToIndexMapping.put(UUID.randomUUID().toString(), newKey);
    return newKey;
  }

  public void putCollectionElement(String name, OPPObjectInstance value) {
    checkTypeForCollectionOnlyOperations();
    checkState((name != null) && !("".equals(name)), "Named location of element must not be null or empty.");
    checkNotNull(value, "Cannot put a null element to a collection.");
    if(collectionNameToIndexMapping.containsKey(name)) {
      collectionValues.remove(collectionNameToIndexMapping.get(name));
      collectionNameToIndexMapping.remove(name);
    }
    int index = appendCollectionElement(value);
    collectionNameToIndexMapping.inverse().remove(index);
    collectionNameToIndexMapping.put(name, index);
  }

  public void putCollectionElementAtIndex(int index, OPPObjectInstance value) {
    checkTypeForCollectionOnlyOperations();
    checkNotNull(value, "Cannot insert a null element to a collection.");
    if(collectionValues.containsKey(index)) {
      collectionValues.remove(index);
      collectionNameToIndexMapping.inverse().remove(index);
    }
    collectionValues.put(index, value);
    collectionNameToIndexMapping.put(UUID.randomUUID().toString(), index);

  }

  public OPPObjectInstance getCollectionElement(String name) {
    checkTypeForCollectionOnlyOperations();
    checkState((name != null) && !("".equals(name)), "Named location of element must not be null or empty.");
    checkState(collectionNameToIndexMapping.containsKey(name), "Collection does contain a value at index %s.", name);
    return collectionValues.get(collectionNameToIndexMapping.get(name));
  }

  public OPPObjectInstance getCollectionElementAtIndex(int index) {
    checkTypeForCollectionOnlyOperations();
    return collectionValues.get(index);
  }

  public OPPObjectInstance getCollectionFirstElement() {
    checkTypeForCollectionOnlyOperations();
    return collectionValues.get(collectionValues.firstKey());
  }

  public OPPObjectInstance getLastCollectionElement() {
    checkTypeForCollectionOnlyOperations();
    return collectionValues.get(collectionValues.lastKey());
  }

  public Collection<OPPObjectInstance> getCollectionAllElements() {
    checkTypeForCollectionOnlyOperations();
    return Collections.unmodifiableCollection(collectionValues.values());
  }

  public Set<String> getCollectionAllIndexes() {
    checkTypeForCollectionOnlyOperations();
    return Collections.unmodifiableSet(collectionNameToIndexMapping.keySet());
  }

  // General
  @Override
  public String toString() {
    if(InstanceType.STRING.equals(type) || InstanceType.NUMERICAL.equals(type))
      return value.toString();
    else if(InstanceType.COMPOSITE.equals(type)) {
      StringBuilder ret = new StringBuilder("{");
      for(String partName : parts.keySet()) {
        ret.append(partName + ":" + parts.get(partName) + ",");
      }
      ret.replace(ret.length() - 1, ret.length(), "}");
      return ret.toString();
    } else if(InstanceType.COLLECTION.equals(type)) {
      StringBuilder ret = new StringBuilder("[");
      for(OPPObjectInstance element : collectionValues.values()) {
        ret.append(element.toString() + ",");
      }
      if(ret.length() > 2)
        ret.replace(ret.length() - 1, ret.length(), "]");
      return ret.toString();
    } else {
      return super.toString();
    }
  }

  private void checkTypeForValueOnlyOperations() {
    checkState(!InstanceType.COLLECTION.equals(type),
        "Instance is a collection but operation is only valid for value instances.");
    checkState(!InstanceType.COMPOSITE.equals(type),
        "Instance is a collection but operation is only valid for value instances.");
  }

  private void checkTypeForCompositeOnlyOperations() {
    checkState(InstanceType.COMPOSITE.equals(type), "Composite operations can only be applied to composite instances.");
  }

  private void checkTypeForCollectionOnlyOperations() {
    checkState(InstanceType.COLLECTION.equals(type),
        "Collection operations can only be applied to collection instances.");
  }

  public enum InstanceType {
    NUMERICAL, STRING, COMPOSITE, COLLECTION;
  }

}
