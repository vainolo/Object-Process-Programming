/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin.composite;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance.InstanceKind;

public class OPPRemovePartProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPObjectInstance object = getArgument("object");
    OPPObjectInstance key = getArgument("key");

    if (object.containsPart(key.getStringValue())) {
      OPPObjectInstance part = object.removePart(key);
      setArgument("part", part);
      setArgument("new object", object);
    } else {
    }
  }

  @Override
  public void setArgument(String name, OPPObjectInstance value) {
    // Modified since we need the original ID of the instance to be used as key, and this ID will be changed when a new
    // instance is created - so we transform the instance to a string that is used as the key.
    if ("key".equals(name)) {
      if (value.kind == InstanceKind.COMPOSITE) {
        value = OPPObjectInstance.createFromValue(value.getId());
      }
    }
    super.setArgument(name, value);
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("object"), new OPPParameter("key"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("part"), new OPPParameter("new object"));
  }

  @Override
  public String getName() {
    return "Remove Part";
  }
}
