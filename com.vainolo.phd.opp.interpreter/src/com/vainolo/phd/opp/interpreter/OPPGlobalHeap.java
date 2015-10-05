package com.vainolo.phd.opp.interpreter;

import java.util.Map;

import com.google.common.collect.Maps;

public class OPPGlobalHeap extends OPPProcessInstanceHeap {
  private Map<String, OPPObjectInstance> variables;

  public OPPGlobalHeap() {
    variables = Maps.newHashMap();
  }

  public void setVariable(String name, OPPObjectInstance value) {
    variables.put(name, value);
  }

  public OPPObjectInstance getVariable(String name) {
    return variables.get(name);
  }

  public void clearVariable(String name) {
    variables.remove(name);
  }

}
