package com.vainolo.phd.opm.interpreter;

import java.util.Map;

import com.google.common.collect.Maps;

public class OPMProcessInstanceHeap {

  protected final Map<String, OPMObjectInstance> arguments = Maps.newHashMap();

  public void addArgument(String name, OPMObjectInstance value) {
    if(value == null)
      return;
    arguments.put(name.toLowerCase(), OPMObjectInstance.createFromExistingInstance(value));
  }

  public OPMObjectInstance getArgument(String name) {
    return arguments.get(name.toLowerCase());
  }
}
