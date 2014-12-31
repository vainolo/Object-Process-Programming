/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import static com.google.common.base.Preconditions.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
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
  private List<OPMObjectInstance> collectionValues = Lists.newArrayList();
  private Map<String, Integer> collectionNameToIndexMapping = Maps.newHashMap();
  public final InstanceType type;

  private OPMObjectInstance(InstanceType type) {
    this.type = type;
  }

  // Creation
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
    switch(existingInstance.type) {
    case NUMERICAL:
      newInstance = createFromValue(existingInstance.getNumericalValue());
      break;
    case STRING:
      newInstance = createFromValue(existingInstance.getStringValue());
      break;
    case COMPOSITE:
      newInstance = createCompositeInstance();
      for(Entry<String, OPMObjectInstance> part : existingInstance.getCompositeParts()) {
        newInstance.addCompositePart(part.getKey(), createFromExistingInstance(part.getValue()));
      }
      break;
    case COLLECTION:
      newInstance = createCollectionInstace();
      for(String name : existingInstance.getCollectionAllIndexes()) {
        newInstance.insertCollectionElement(name, existingInstance.getCollectionElement(name));
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
  public void addCompositePart(String name, OPMObjectInstance part) {
    checkTypeForCompositeOnlyOperations();
    checkNotNull(name);
    checkNotNull(part);
    parts.put(name, part);
  }

  public OPMObjectInstance getCompositePart(String name) {
    checkTypeForCompositeOnlyOperations();
    checkNotNull(name, "Part name cannot be null");
    checkArgument(!"".equals(name), "Part name cannot be empty");
    return parts.get(name);
  }

  public Set<Entry<String, OPMObjectInstance>> getCompositeParts() {
    checkTypeForCompositeOnlyOperations();
    return Collections.unmodifiableSet(parts.entrySet());
  }

  // Collection
  public void appendCollectionElement(OPMObjectInstance element) {
    checkTypeForCollectionOnlyOperations();
    checkNotNull(element, "Cannot append a null element to a collection.");
    collectionValues.add(element);
    collectionNameToIndexMapping.put(UUID.randomUUID().toString(), collectionValues.size() - 1);
  }

  public void insertCollectionElement(String name, OPMObjectInstance element) {
    checkTypeForCollectionOnlyOperations();
    checkState((name != null) && !("".equals(name)), "Named location of element must not be null or empty.");
    checkNotNull(element, "Cannot insert a null element to a collection.");
    collectionValues.add(element);
    collectionNameToIndexMapping.put(name, collectionValues.size() - 1);
  }

  public OPMObjectInstance getCollectionElement(String name) {
    checkTypeForCollectionOnlyOperations();
    checkState((name != null) && !("".equals(name)), "Named location of element must not be null or empty.");
    checkState(collectionNameToIndexMapping.containsKey(name), "Collection does not an index %s.", name);
    return collectionValues.get(collectionNameToIndexMapping.get(name));
  }

  public OPMObjectInstance getCollectionElementAtIndex(int index) {
    checkTypeForCollectionOnlyOperations();
    return collectionValues.get(index - 1);
  }

  public OPMObjectInstance getFirstCollectionElement() {
    checkTypeForCollectionOnlyOperations();
    return collectionValues.get(0);
  }

  public OPMObjectInstance getLastCollectionElement() {
    checkTypeForCollectionOnlyOperations();
    return collectionValues.get(collectionValues.size() - 1);
  }

  public List<OPMObjectInstance> getCollectionAllElements() {
    checkTypeForCollectionOnlyOperations();
    return Collections.unmodifiableList(collectionValues);
  }

  public Set<String> getCollectionAllIndexes() {
    checkTypeForCollectionOnlyOperations();
    return Collections.unmodifiableSet(collectionNameToIndexMapping.keySet());
  }

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
      for(OPMObjectInstance element : collectionValues) {
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
