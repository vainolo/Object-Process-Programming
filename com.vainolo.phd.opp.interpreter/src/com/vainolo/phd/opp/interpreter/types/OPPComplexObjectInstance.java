package com.vainolo.phd.opp.interpreter.types;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;

public class OPPComplexObjectInstance extends OPPObjectInstance implements OPPCollectionObjectInstance {

  Map<String, OPPObjectInstance> map = Maps.newHashMap();

  protected OPPComplexObjectInstance() {
    super(InstanceKind.COMPOSITE);
  }

  public OPPObjectInstance setPart(String key, OPPObjectInstance element) {
    return map.put(key, element);
  }

  public boolean containsPart(String key) {
    return map.containsKey(key);
  }

  public OPPObjectInstance getPart(String key) {
    return map.get(key);
  }

  public OPPObjectInstance removePart(String key) {
    return map.remove(key);
  }

  @Override
  public int count() {
    return map.size();
  }

  public Set<String> getPartNames() {
    return map.keySet();
  }

  public Collection<OPPObjectInstance> getAllParts() {
    return Collections.unmodifiableCollection(map.values());
  }

  @Override
  public BigDecimal getNumericalValue() {
    throw new UnsupportedOperationException("Cannot get numerical value for a complex object");
  }

  @Override
  public String getStringValue() {
    throw new UnsupportedOperationException("Cannot get string value for a complex object");
  }

  @Override
  public Object getValue() {
    throw new UnsupportedOperationException("Cannot get raw value for a complex object");
  }

  @Override
  public String toString() {
    StringBuilder ret = new StringBuilder(); // "(" + kind + ")");
    ret.append("{");
    for (String name : getPartNames()) {
      ret.append("\"").append(name).append("\":").append(getPart(name)).append(",");
    }
    if (count() > 0)
      ret.replace(ret.length() - 1, ret.length(), "}");
    else
      ret.append("}");

    return ret.toString();
  }

}
