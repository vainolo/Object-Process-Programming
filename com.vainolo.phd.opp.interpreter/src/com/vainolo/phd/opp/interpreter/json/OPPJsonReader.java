package com.vainolo.phd.opp.interpreter.json;

import static com.vainolo.phd.opp.utilities.OPPLogger.logInfo;

import java.math.BigDecimal;
import java.util.Iterator;

import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonObject.Member;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;

public class OPPJsonReader {
  public OPPObjectInstance read(JsonObject jsonObject) {
    OPPObjectInstance instance = OPPObjectInstance.createCompositeInstance();
    Iterator<Member> it = jsonObject.iterator();
    while (it.hasNext()) {
      addPart(instance, it.next());
    }
    return instance;
  }

  private void addPart(OPPObjectInstance whole, Member member) {
    logInfo("Adding part " + member.getName() + " with value " + member.getValue().toString());
    if (member.getValue().isArray()) {
      throw new UnsupportedOperationException();
    } else if (member.getValue().isString()) {
      addStringPart(whole, member.getName(), member.getValue().asString());
    } else if (member.getValue().isNumber()) {
      addNumberPart(whole, member.getName(), member.getValue().asDouble());
    } else if (member.getValue().isBoolean()) {
      addBooleanPart(whole, member.getName(), member.getValue().asBoolean());
    } else if (member.getValue().isObject()) {
      addObjectPart(whole, member.getName(), member.getValue().asObject());
    }
    // null JSON values are ignored.
  }

  private void addObjectPart(OPPObjectInstance whole, String name, JsonObject value) {
    OPPObjectInstance part = read(value);
    whole.addPart(name, part);
  }

  private void addStringPart(OPPObjectInstance whole, String name, String value) {
    whole.addPart(name, OPPObjectInstance.createFromValue(value));
  }

  private void addNumberPart(OPPObjectInstance instance, String whole, double value) {
    instance.addPart(whole, OPPObjectInstance.createFromValue(new BigDecimal(value)));
  }

  private void addBooleanPart(OPPObjectInstance whole, String name, boolean value) {
    OPPObjectInstance bool = OPPObjectInstance.createFromValue(Boolean.toString(value));
    whole.addPart(name, bool);
  }

}
