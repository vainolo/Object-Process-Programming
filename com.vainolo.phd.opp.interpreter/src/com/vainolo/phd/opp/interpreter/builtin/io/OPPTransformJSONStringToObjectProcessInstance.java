/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin.io;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import java.util.List;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.json.OPPJsonReader;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPTransformJSONStringToObjectProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  @Override
  protected void executing() {
    OPPJsonReader reader = new OPPJsonReader();
    try {
      String json = getArgument("json").getStringValue();
      JsonObject jsonObject = JsonObject.readFrom(json);
      OPPObjectInstance opmObjectInstance = reader.readJson(jsonObject);
    } catch (Exception e) {
      e.printStackTrace();
      logSevere(e.getLocalizedMessage());
    }
  }

  @Override
  public String getName() {
    return "Read JSON";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("json"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("object"));
  }

}
