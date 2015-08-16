package com.vainolo.phd.opp.interpreter;

import static com.vainolo.phd.opp.utilities.OPMLogger.*;

import java.util.Map;

import com.google.common.collect.Maps;

public class OPMProcessInstanceHeap {

  protected final Map<String, OPMObjectInstance> arguments = Maps.newHashMap();

  public OPMProcessInstanceHeap() {
  }

  public void addArgument(String name, OPMObjectInstance value) {
    logFinest("Setting argument {0} with value {1}.", name, value);
    if(value == null)
      return;
    arguments.put(name.toLowerCase(), OPMObjectInstance.createFromExistingInstance(value));
  }

  public OPMObjectInstance getArgument(String name) {
    logFinest("Fetching value of {0} which is {1}.", name, arguments.get(name.toLowerCase()));
    return arguments.get(name.toLowerCase());
  }

}
