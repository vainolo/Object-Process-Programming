/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.logging.Logger;

import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonObject.Member;
import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.utils.SimpleLoggerFactory;

public class OPMReadJSONObjectProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {
  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMAbstractProcessInstance.class.getName());

  @Override
  protected void executing() {
    OPMObjectInstance opmObjectInstance = OPMObjectInstance.createCompositeInstance();
    try {
      JsonObject jsonObject = JsonObject.readFrom(getArgument("json").getStringValue());
      populateOPMObjectInstanceFromJSONObject(opmObjectInstance, jsonObject);
      setArgument("object", opmObjectInstance);
    } catch(Exception e) {
      e.printStackTrace();
      logger.severe(e.getLocalizedMessage());
    }
  }

  private void populateOPMObjectInstanceFromJSONObject(OPMObjectInstance opmObjectInstance, JsonObject jsonObject) {
    Iterator<Member> it = jsonObject.iterator();
    while(it.hasNext()) {
      addPart(opmObjectInstance, it.next());
    }
  }

  private void addPart(OPMObjectInstance whole, Member member) {
    logger.info("Adding part " + member.getName() + " with value " + member.getValue().toString());
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

  private void addObjectPart(OPMObjectInstance whole, String name, JsonObject value) {
    OPMObjectInstance part = OPMObjectInstance.createCompositeInstance();
    populateOPMObjectInstanceFromJSONObject(part, value);
    whole.addPart(name, part);
  }

  private void addStringPart(OPMObjectInstance whole, String name, String value) {
    whole.addPart(name, OPMObjectInstance.createFromValue(value));
  }

  private void addNumberPart(OPMObjectInstance instance, String whole, double value) {
    instance.addPart(whole, OPMObjectInstance.createFromValue(new BigDecimal(value)));
  }

  private void addBooleanPart(OPMObjectInstance whole, String name, boolean value) {
    OPMObjectInstance bool = OPMObjectInstance.createFromState(Boolean.toString(value));
    whole.addPart(name, bool);
  }

  @Override
  public String getName() {
    return "Read JSON";
  }

  @Override
  public boolean isReady() {
    return getArgument("json") != null;
  }

}
