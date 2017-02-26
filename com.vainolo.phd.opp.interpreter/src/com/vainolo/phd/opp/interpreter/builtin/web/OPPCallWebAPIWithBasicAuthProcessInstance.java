/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin.web;

import java.util.List;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.google.common.collect.Lists;
import com.mashape.unirest.http.Unirest;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.json.OPPJsonReader;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPCallWebAPIWithBasicAuthProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPObjectInstance url = getArgument("url");
    OPPObjectInstance username = getArgument("username");
    OPPObjectInstance password = getArgument("password");
    String response = Unirest.get(url.getStringValue()).basicAuth(username.getStringValue(), password.getStringValue()).asJson().getBody().toString();
    JsonValue value = Json.parse(response);
    OPPJsonReader reader = new OPPJsonReader();
    OPPObjectInstance result = reader.read(value);
    setArgument("result", result);
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return createParameterList("url", "username", "password");
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
