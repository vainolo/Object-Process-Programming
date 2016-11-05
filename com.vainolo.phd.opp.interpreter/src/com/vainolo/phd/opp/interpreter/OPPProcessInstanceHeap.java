/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import java.util.Map;

import com.google.common.collect.Maps;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

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
