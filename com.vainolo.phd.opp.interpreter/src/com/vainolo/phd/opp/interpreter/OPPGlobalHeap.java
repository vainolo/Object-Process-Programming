/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter;

import java.util.Map;

import com.google.common.collect.Maps;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

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
