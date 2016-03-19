/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import java.util.List;

import com.eclipsesource.json.JsonObject;
import com.google.common.collect.Lists;
import com.mashape.unirest.http.Unirest;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.json.OPPJsonReader;

public class OPPCallWebAPIProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    // Ugly implementation - Unirest uses a different JSON implementation than the one already used by the interpreter,
    // so to save time the JSON result is simply written to a string and then read by the existing JSON library.
    OPPObjectInstance url = getArgument("url");
    String response = Unirest.get(url.getStringValue()).asJson().getBody().toString();
    JsonObject json = JsonObject.readFrom(response);
    OPPJsonReader reader = new OPPJsonReader();
    OPPObjectInstance result = reader.read(json);
    setArgument("result", result);
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("url"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("result"));
  }

  @Override
  public String getName() {
    return "Call Web API";
  }

}
