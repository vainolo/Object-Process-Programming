package com.vainolo.phd.opm.interpreter;

import java.util.Map;

import com.google.common.collect.Maps;
import com.vainolo.phd.opm.model.OPMObject;

public class OPMProcessInstanceHeap {

  protected final Map<String, OPMObjectInstance> arguments = Maps.newHashMap();
  protected final Map<OPMObject, OPMObjectInstance> variables = Maps.newHashMap();

  public void addArgument(String name, OPMObjectInstance value) {
    arguments.put(name.toLowerCase(), value);
  }

  public OPMObjectInstance getArgument(String name) {
    return arguments.get(name.toLowerCase());
  }

  public void setVariable(OPMObject object, OPMObjectInstance value) {
    variables.put(object, value);
  }

  public OPMObjectInstance getVariable(OPMObject object) {
    return variables.get(object);
  }

}
