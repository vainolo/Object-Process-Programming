/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin.io;

import java.util.List;

import com.eclipsesource.json.JsonObject;
import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.json.OPPJsonWriter;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPWriteOPMObjectInstanceToJSON extends OPPAbstractProcessInstance implements OPPProcessInstance {

  @Override
  protected void executing() {
    OPPJsonWriter writer = new OPPJsonWriter();
    OPPObjectInstance opmObjectInstance = getArgument("object");
    JsonObject jsonObject = writer.write(opmObjectInstance);
    setArgument("json", OPPObjectInstance.createFromValue(jsonObject.toString()));
  }

  @Override
  public String getName() {
    return "Write JSON";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("object"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("json"));
  }

}
