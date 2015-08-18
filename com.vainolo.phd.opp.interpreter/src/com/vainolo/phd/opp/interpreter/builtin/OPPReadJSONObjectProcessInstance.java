/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonObject.Member;
import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;

public class OPPReadJSONObjectProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  @Override
  protected void executing() {
    OPPObjectInstance opmObjectInstance = OPPObjectInstance.createCompositeInstance();
    try {
      JsonObject jsonObject = JsonObject.readFrom(getArgument("json").getStringValue());
      populateOPMObjectInstanceFromJSONObject(opmObjectInstance, jsonObject);
      setArgument("object", opmObjectInstance);
    } catch(Exception e) {
      e.printStackTrace();
      logSevere(e.getLocalizedMessage());
    }
  }

  private void populateOPMObjectInstanceFromJSONObject(OPPObjectInstance opmObjectInstance, JsonObject jsonObject) {
    Iterator<Member> it = jsonObject.iterator();
    while(it.hasNext()) {
      addPart(opmObjectInstance, it.next());
    }
  }

  private void addPart(OPPObjectInstance whole, Member member) {
    logInfo("Adding part " + member.getName() + " with value " + member.getValue().toString());
    if(member.getValue().isArray()) {
      throw new UnsupportedOperationException();
    } else if(member.getValue().isString()) {
      addStringPart(whole, member.getName(), member.getValue().asString());
    } else if(member.getValue().isNumber()) {
      addNumberPart(whole, member.getName(), member.getValue().asDouble());
    } else if(member.getValue().isBoolean()) {
      addBooleanPart(whole, member.getName(), member.getValue().asBoolean());
    } else if(member.getValue().isObject()) {
      addObjectPart(whole, member.getName(), member.getValue().asObject());
    }
    // null JSON values are ignored.
  }

  private void addObjectPart(OPPObjectInstance whole, String name, JsonObject value) {
    OPPObjectInstance part = OPPObjectInstance.createCompositeInstance();
    populateOPMObjectInstanceFromJSONObject(part, value);
    whole.addCompositePart(name, part);
  }

  private void addStringPart(OPPObjectInstance whole, String name, String value) {
    whole.addCompositePart(name, OPPObjectInstance.createFromValue(value));
  }

  private void addNumberPart(OPPObjectInstance instance, String whole, double value) {
    instance.addCompositePart(whole, OPPObjectInstance.createFromValue(new BigDecimal(value)));
  }

  private void addBooleanPart(OPPObjectInstance whole, String name, boolean value) {
    OPPObjectInstance bool = OPPObjectInstance.createFromValue(Boolean.toString(value));
    whole.addCompositePart(name, bool);
  }

  @Override
  public String getName() {
    return "Read JSON";
  }

  @Override
  public boolean isReady() {
    return getArgument("json") != null;
  }

  @Override
  public List<OPPParameter> getIncomingParameterNames() {
    return Lists.newArrayList(new OPPParameter("json", false));
  }

  @Override
  public List<OPPParameter> getOutgoingParameterNames() {
    return Lists.newArrayList(new OPPParameter("object", false));
  }

}
