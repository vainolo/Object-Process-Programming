/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.types;

import static com.google.common.base.Preconditions.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.SortedMap;
import java.util.UUID;

import com.google.common.base.Preconditions;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import com.vainolo.phd.opp.interpreter.OPPRuntimeException;

/**
 * And instance of an OPM Object. An OPM object can have two primary constructs: it either has a value or is composite.
 * Values can be {@link String}, {@link BigDecimal}, or a state, which is treated pretty similarly to a string.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public abstract class OPPObjectInstance {

  private Object value = null;
  // private SortedMap<Integer, OPPObjectInstance> compositeValues = Maps.newTreeMap();
  // private BiMap<String, Integer> compositeKeyToIndexMapping = HashBiMap.create();
  public final InstanceKind kind;
  private UUID internalId;

  protected OPPObjectInstance(InstanceKind kind) {
    this.kind = kind;
    this.internalId = UUID.randomUUID();
  }

  private String getInternalId() {
    return internalId.toString();
  }

  public String getId() {
    switch (kind) {
    case NUMERICAL:
    case STRING:
      return getStringValue();
    case LIST:
    case COMPOSITE:
      return getInternalId();
    default:
      throw new IllegalStateException();
    }
  }

  // Creation
  public static OPPComplexObjectInstance createCompositeInstance() {
    return new OPPComplexObjectInstance(); // OPPObjectInstance(InstanceKind.COMPOSITE, "Complex Object");
  }

  public static OPPListObjectInstance createListInstance() {
    return new OPPListObjectInstance(); // OPPObjectInstance(InstanceKind.COMPOSITE, "List");
  }

  public static OPPNumberObjectInstance createFromValue(BigDecimal decimalValue) {
    Preconditions.checkNotNull(decimalValue, "Value cannot be null.");
    return new OPPNumberObjectInstance(decimalValue);
  }

  public static OPPObjectInstance createFromValue(String stringValue) {
    Preconditions.checkNotNull(stringValue, "Value cannot be null.");
    return new OPPStringObjectInstance(stringValue);
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
    case COMPOSITE:
      OPPComplexObjectInstance existingCompositeInstance = (OPPComplexObjectInstance) existingInstance;
      OPPComplexObjectInstance newComplexInstance = createCompositeInstance();
      for (String partName : existingCompositeInstance.getPartNames()) {
        newComplexInstance.setPart(partName, existingCompositeInstance.getPart(partName));
      }
      newInstance = newComplexInstance;
      break;
    case LIST:
      OPPListObjectInstance existingListInstance = (OPPListObjectInstance) existingInstance;
      OPPListObjectInstance newListInstance = createListInstance();
      for (int i = 1; i <= existingListInstance.count(); i++) {
        newListInstance.addLast(existingListInstance.get(i));
      }
      newInstance = newListInstance;
      break;
    case JAVA_OBJECT:
      // newInstance = createFromValue(existingInstance.getValue());
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

  public abstract Object getValue();
  // {
  // checkState(value != null, "Value of variable is not set.");
  // checkTypeForValueOnlyOperations();
  // return value;
  // }

  abstract public String getStringValue();
  // {
  // checkTypeForValueOnlyOperations();
  // if (kind == InstanceKind.STRING) {
  // return (String) getValue();
  // } else if (kind == InstanceKind.NUMERICAL) {
  // return ((BigDecimal) getValue()).toString();
  // } else {
  // throw new IllegalStateException("Cannot fetch value of an instance that is not a value");
  // }
  // }

  abstract public BigDecimal getNumericalValue();
  // {
  // checkTypeForValueOnlyOperations();
  // if (kind == InstanceKind.STRING) {
  // return new BigDecimal(String.class.cast(getValue()));
  // } else if (kind == InstanceKind.NUMERICAL) {
  // return BigDecimal.class.cast(getValue());
  // } else {
  // throw new IllegalStateException("Cannot fetch value of an instance that is not a value");
  // }
  // }

  // public boolean isValue() {
  // return value != null;
  // }

  // Composite
  // public void addFirstPart(OPPObjectInstance value) {
  // checkTypeForCompositeOnlyOperations();
  // checkNotNull(value, "Cannot append a null element to a collection.");
  // Integer firstKey = 0;
  // if (compositeValues.size() > 0) {
  // firstKey = compositeValues.firstKey();
  // }
  // int newKey = firstKey - 1;
  // compositeValues.put(newKey, value);
  // compositeKeyToIndexMapping.put(value.getInternalId(), newKey);
  // }

  // public void addLastPart(OPPObjectInstance value) {
  // checkTypeForCompositeOnlyOperations();
  // checkNotNull(value, "Cannot append a null element to a collection.");
  // Integer lastKey = 0;
  // if (compositeValues.size() > 0) {
  // lastKey = compositeValues.lastKey();
  // }
  // int newKey = lastKey + 1;
  // compositeValues.put(newKey, value);
  // compositeKeyToIndexMapping.put(value.getInternalId(), newKey);
  // }

  // public void addPart(String key, OPPObjectInstance value) {
  // checkTypeForCompositeOnlyOperations();
  // checkState((key != null) && !("".equals(key)), "Key of element must not be null or empty.");
  // checkNotNull(value, "Cannot put a null element to a collection.");
  // if (compositeKeyToIndexMapping.containsKey(key)) {
  // compositeValues.remove(compositeKeyToIndexMapping.get(key));
  // compositeKeyToIndexMapping.remove(key);
  // }
  // int lastKey = 0;
  // if (compositeValues.size() > 0) {
  // lastKey = compositeValues.lastKey();
  // }
  // int newKey = lastKey + 1;
  // compositeValues.put(newKey, value);
  // compositeKeyToIndexMapping.put(key, newKey);
  // }

  // public boolean containsPart(String key) {
  // return compositeKeyToIndexMapping.containsKey(key);
  // }

  // public OPPObjectInstance getPart(String key) {
  // checkTypeForCompositeOnlyOperations();
  // checkState((key != null) && (!"".equals(key)), "Key cannot be null or empty.");
  // if (containsPart(key)) {
  // return compositeValues.get(compositeKeyToIndexMapping.get(key));
  // } else {
  // return null;
  // }
  // }

  // public OPPObjectInstance getFirstPart() {
  // checkTypeForCompositeOnlyOperations();
  // if (compositeValues.size() > 0) {
  // return compositeValues.get(compositeValues.firstKey());
  // } else {
  // return null;
  // }
  // }
  //
  // public OPPObjectInstance getLastPart() {
  // checkTypeForCompositeOnlyOperations();
  // if (compositeValues.size() > 0) {
  // return compositeValues.get(compositeValues.lastKey());
  // } else {
  // return null;
  // }
  // }

  // public Collection<OPPObjectInstance> getAllParts() {
  // checkTypeForCompositeOnlyOperations();
  // return Collections.unmodifiableCollection(compositeValues.values());
  // }
  //
  // public Set<String> getAllPartIndexes() {
  // checkTypeForCompositeOnlyOperations();
  // return Collections.unmodifiableSet(compositeKeyToIndexMapping.keySet());
  // }
  //
  // public OPPObjectInstance removePart(OPPObjectInstance key) {
  // checkTypeForCompositeOnlyOperations();
  // checkState(key != null, "Key cannot be null.");
  // OPPObjectInstance part = null;
  // switch (key.type) {
  // case "String":
  // case "Number":
  // part = removePart(key.getStringValue());
  // break;
  // case "Complex Object":
  // case "List":
  // part = removePart(key.getInternalId());
  // break;
  // case "Java Object":
  // throw new OPPRuntimeException("Java object keys are not supported.");
  // }
  // return part;
  // }
  //
  // public OPPObjectInstance removePart(String key) {
  // checkTypeForCompositeOnlyOperations();
  // checkState((key != null) && (!"".equals(key)), "Key cannot be null or empty.");
  // Integer index = compositeKeyToIndexMapping.get(key);
  // OPPObjectInstance part = compositeValues.remove(index);
  // compositeKeyToIndexMapping.remove(key);
  // return part;
  // }

  // public boolean removePartById(String id) {
  // checkTypeForCompositeOnlyOperations();
  // checkState((id != null) && (!"".equals(id)), "Key cannot be null or empty.");
  // Integer foundKey = null;
  // for (Integer key : compositeValues.keySet()) {
  // OPPObjectInstance value = compositeValues.get(key);
  // if (value.getId().equals(id)) {
  // foundKey = key;
  // break;
  // }
  // }
  // if (foundKey != null) {
  // compositeKeyToIndexMapping.inverse().remove(foundKey);
  // compositeValues.remove(foundKey);
  // return true;
  // } else {
  // return false;
  // }
  //
  // }

  // public OPPObjectInstance removeFirstPart() {
  // checkTypeForCompositeOnlyOperations();
  // if (compositeValues.size() == 0)
  // return null;
  //
  // Integer firstIndex = compositeValues.firstKey();
  // OPPObjectInstance firstInstance = compositeValues.remove(firstIndex);
  // compositeKeyToIndexMapping.inverse().remove(firstIndex);
  // return firstInstance;
  // }
  //
  // public OPPObjectInstance removeLastPart() {
  // checkTypeForCompositeOnlyOperations();
  // Integer lastIndex = compositeValues.lastKey();
  // OPPObjectInstance lastInstance = compositeValues.remove(lastIndex);
  // compositeKeyToIndexMapping.inverse().remove(lastIndex);
  // return lastInstance;
  // }

  @Override
  abstract public String toString();

  // General
  // @Override
  // public String toString() {
  // String retVal = "(" + kind + ")";
  // if (kind == InstanceKind.STRING || kind == InstanceKind.NUMERICAL) {
  // return retVal + value.toString();
  // } else if (kind == InstanceKind.LIST) {
  // StringBuilder ret = new StringBuilder("[");
  // for (Integer index : compositeValues.keySet()) {
  // ret.append(compositeValues.get(index).toString() + ",");
  // }
  // if (ret.length() > 2)
  // ret.replace(ret.length() - 1, ret.length(), "]");
  // else
  // ret.append("]");
  // return retVal + ret.toString();
  // } else if (kind == InstanceKind.COMPOSITE) {
  // StringBuilder ret = new StringBuilder("{");
  // for (Integer index : compositeValues.keySet()) {
  // ret.append("\"" + compositeKeyToIndexMapping.inverse().get(index).toString() + "\" :" +
  // compositeValues.get(index).toString() + ",");
  // }
  // if (ret.length() > 2)
  // ret.replace(ret.length() - 1, ret.length(), "}");
  // else
  // ret.append("}");
  // return retVal + ret.toString();
  // } else {
  // return retVal + super.toString();
  // }
  // }

  private void checkTypeForValueOnlyOperations() {
    checkState(kind == InstanceKind.NUMERICAL || kind == InstanceKind.STRING, "Operation is only valid for value instances.");
  }

  public enum InstanceKind {
    NUMERICAL, STRING, JAVA_OBJECT, COMPOSITE, LIST;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof OPPObjectInstance))
      return false;

    OPPObjectInstance other = (OPPObjectInstance) obj;
    if (this.kind != other.kind) {
      return false;
    } else {
      if (this.kind == InstanceKind.NUMERICAL) {
        return (this.getNumericalValue().compareTo(other.getNumericalValue()) == 0);
      } else if (this.kind == InstanceKind.STRING) {
        return this.getStringValue().equals(other.getStringValue());
      } else if (this.kind == InstanceKind.COMPOSITE || this.kind == InstanceKind.LIST) {
        return this.internalId == other.internalId;
      }
    }
    return false;
  }

  @Override
  public int hashCode() {
    switch (kind) {
    case COMPOSITE:
    case LIST:
      return internalId.hashCode();
    case STRING:
    case NUMERICAL:
    case JAVA_OBJECT:
      return value.hashCode();
    }

    return super.hashCode();
  }
}
