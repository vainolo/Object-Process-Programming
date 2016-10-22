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

public class OPPAddPartProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPObjectInstance object = getArgument("object");
    OPPObjectInstance key = getArgument("key");
    OPPObjectInstance part = getArgument("part");
    if (object == null)
      object = OPPObjectInstance.createCompositeInstance();
    object.addPart(key.getStringValue(), part);
    setArgument("new object", object);
  }

  @Override
  public void setArgument(String name, OPPObjectInstance value) {
    // Modified since we need the original ID of the instance to be used as key, and this ID will be changed when a new
    // instance is created - so we transform the instance to a string that is used as the key.
    if ("key".equals(name)) {
      if ("Complex Object".equals(value.type)) {
        value = OPPObjectInstance.createFromValue(value.getId());
      }
    }
    super.setArgument(name, value);
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("object"), new OPPParameter("key"), new OPPParameter("part"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("new object"));
  }

  @Override
  public String getName() {
    return "Add Part";
  }
}
