package com.vainolo.phd.opp.interpreter.types;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class OPPListObjectInstance extends OPPObjectInstance implements OPPCollectionObjectInstance {

  ArrayList<OPPObjectInstance> list = Lists.newArrayList();

  protected OPPListObjectInstance() {
    super(InstanceKind.LIST);
  }

  public void addFirst(OPPObjectInstance element) {
    list.add(0, element);
  }

  public OPPObjectInstance getFirst() {
    if (list.size() == 0)
      return null;
    else
      return list.get(0);
  }

  public OPPObjectInstance removeFirst() {
    if (list.size() == 0)
      return null;
    else
      return list.remove(0);
  }

  public void addLast(OPPObjectInstance element) {
    list.add(element);
  }

  public OPPObjectInstance getLast() {
    if (list.size() == 0)
      return null;
    else
      return list.get(list.size() - 1);
  }

  public OPPObjectInstance removeLast() {
    if (list.size() == 0)
      return null;
    else
      return list.remove(list.size() - 1);
  }

  public boolean add(int index, OPPObjectInstance element) {
    if (index < 1 || index > list.size()) {
      return false;
    } else {
      list.add(index + 1, element);
      return true;
    }
  }

  public OPPObjectInstance get(int index) {
    if (index < 1 || index > list.size())
      return null;

    return list.get(index - 1);
  }

  public OPPObjectInstance remove(int index) {
    if (index < 1 || index > list.size()) {
      return null;
    } else {
      return list.remove(index - 1);
    }
  }

  @Override
  public int count() {
    return list.size();
  }

  @Override
  public BigDecimal getNumericalValue() {
    throw new UnsupportedOperationException("Cannot get numerical value for a list object");
  }

  @Override
  public String getStringValue() {
    throw new UnsupportedOperationException("Cannot get string value for a list object");
  }

  @Override
  public Object getValue() {
    throw new UnsupportedOperationException("Cannot get raw value for a list object");

  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    for (int i = 1; i <= count(); i++) {
      builder.append(get(i)).append(",");
    }
    if (count() > 0)
      builder.replace(builder.length() - 1, builder.length(), "]");
    else
      builder.append("]");
    return builder.toString();
  }
}
