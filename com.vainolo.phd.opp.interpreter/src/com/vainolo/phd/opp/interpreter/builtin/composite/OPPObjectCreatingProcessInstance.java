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
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPRuntimeException;

public class OPPObjectCreatingProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  @Override
  public void executing() {
    OPPObjectInstance type = getArgument("type");
    OPPObjectInstance newObject;
    if (type == null) {
      newObject = OPPObjectInstance.createCompositeInstance();
    } else {
      switch (type.getStringValue()) {
      case "List":
        newObject = OPPObjectInstance.createListInstance();
        break;
      case "Complex Object":
        newObject = OPPObjectInstance.createCompositeInstance();
        break;
      default:
        throw new OPPRuntimeException("Invalid type, only Complex Object or List are allowed here");
      }
    }
    setArgument("object", newObject);
  }

  @Override
  public String getName() {
    return "Object Creating";
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("object"));
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    // TODO Auto-generated method stub
    return Lists.newArrayList(new OPPParameter("type"));
  }
}
