package com.vainolo.phd.opp.interpreter;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import java.util.Map;

import com.google.common.collect.Maps;

public class OPPProcessInstanceHeap {

  protected final Map<String, OPPObjectInstance> arguments = Maps.newHashMap();

  public OPPProcessInstanceHeap() {
  }

  public void setArgument(String name, OPPObjectInstance value) {
    logFiner("Setting argument {0} with value {1}.", name, value);
    if (value == null)
      return;
    arguments.put(name.toLowerCase(), OPPObjectInstance.createFromExistingInstance(value));
  }

  public OPPObjectInstance getArgument(String name) {
    logFiner("Getting argument {0} which is {1}.", name, arguments.get(name.toLowerCase()));
    return arguments.get(name.toLowerCase());
  }

}
