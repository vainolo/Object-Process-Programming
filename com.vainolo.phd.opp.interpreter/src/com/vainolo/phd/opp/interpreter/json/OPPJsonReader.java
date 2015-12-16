package com.vainolo.phd.opp.interpreter.json;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import java.math.BigDecimal;
import java.util.Iterator;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.eclipsesource.json.JsonObject.Member;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;

public class OPPJsonReader {

  public OPPObjectInstance read(JsonObject jsonObject) {
    OPPObjectInstance instance = OPPObjectInstance.createCompositeInstance();
    Iterator<Member> it = jsonObject.iterator();
    while (it.hasNext()) {
      Member member = it.next();
      addPart(instance, member.getName(), member.getValue());
    }
    return instance;
  }

  public OPPObjectInstance read(JsonArray jsonArray) {
    OPPObjectInstance instance = OPPObjectInstance.createCompositeInstance();
    for (int i = 0; i < jsonArray.size(); i++) {
      addPart(instance, String.valueOf(i), jsonArray.get(i));
    }
    return instance;
  }

  private void addPart(OPPObjectInstance whole, String name, JsonValue value) {
    logFinest("Adding part " + name + " with value " + value.toString());
    if (value.isArray()) {
      addArrayPart(whole, name, value.asArray());
    } else if (value.isString()) {
      addStringPart(whole, name, value.asString());
    } else if (value.isNumber()) {
      addNumberPart(whole, name, value.asDouble());
    } else if (value.isBoolean()) {
      addBooleanPart(whole, name, value.asBoolean());
    } else if (value.isObject()) {
      addObjectPart(whole, name, value.asObject());
    }
    // null JSON values are ignored.
  }

  private void addArrayPart(OPPObjectInstance whole, String name, JsonArray array) {
    OPPObjectInstance part = OPPObjectInstance.createCompositeInstance();
    for (int i = 0; i < array.size(); i++) {
      addPart(part, String.valueOf(i), array.get(i));
    }
    whole.addPart(name, part);
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
