/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.json;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import java.math.BigDecimal;
import java.util.Iterator;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.eclipsesource.json.JsonObject.Member;
import com.vainolo.phd.opp.interpreter.types.OPPComplexObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPListObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPJsonReader {

  public OPPObjectInstance readJson(JsonObject jsonObject) {
    if (jsonObject.isArray()) {
      return read(jsonObject.asArray());
    } else if (jsonObject.isObject()) {
      return read(jsonObject.asObject());
    } else {
      throw new IllegalStateException("Parameter must be a JSON array or object");
    }

    // if(jsonObject.is)
    // OPPObjectInstance instance = OPPObjectInstance.createCompositeInstance();
    // Iterator<Member> it = jsonObject.iterator();
    // while (it.hasNext()) {
    // Member member = it.next();
    // addPart(instance, member.getName(), member.getValue());
    // }
    // return instance;
  }

  public OPPObjectInstance read(JsonValue value) {
    logFinest("Reading " + value.toString());
    if (value.isArray()) {
      return read(value.asArray());
    } else if (value.isString()) {
      return OPPObjectInstance.createFromValue(value.asString());
    } else if (value.isNumber()) {
      return OPPObjectInstance.createFromValue(new BigDecimal(value.asDouble()));
    } else if (value.isBoolean()) {
      return value.asBoolean() ? OPPObjectInstance.createFromValue("yes") : OPPObjectInstance.createFromValue("no");
    } else if (value.isObject()) {
      return read(value.asObject());
    } else {
      throw new IllegalStateException("Unsupported JSON value type.");
    }
  }

  private OPPComplexObjectInstance read(JsonObject jsonObject) {
    OPPComplexObjectInstance object = OPPObjectInstance.createCompositeInstance();
    Iterator<Member> it = jsonObject.iterator();
    while (it.hasNext()) {
      Member member = it.next();
      object.setPart(member.getName(), read(member.getValue()));
    }
    return object;
  }

  private OPPListObjectInstance read(JsonArray jsonArray) {
    OPPListObjectInstance list = OPPObjectInstance.createListInstance();
    for (int i = 0; i < jsonArray.size(); i++) {
      list.addLast(read(jsonArray.get(i)));
    }
    return list;
  }

  // public OPPObjectInstance read(JsonArray jsonArray) {
  // OPPObjectInstance instance = OPPObjectInstance.createCompositeInstance();
  // for (int i = 0; i < jsonArray.size(); i++) {
  // addPart(instance, String.valueOf(i), jsonArray.get(i));
  // }
  // return instance;
  // }
  //
  // private void addPart(OPPObjectInstance whole, String name, JsonValue value) {
  // logFinest("Adding part " + name + " with value " + value.toString());
  // if (value.isArray()) {
  // addArrayPart(whole, name, value.asArray());
  // } else if (value.isString()) {
  // addStringPart(whole, name, value.asString());
  // } else if (value.isNumber()) {
  // addNumberPart(whole, name, value.asDouble());
  // } else if (value.isBoolean()) {
  // addBooleanPart(whole, name, value.asBoolean());
  // } else if (value.isObject()) {
  // addObjectPart(whole, name, value.asObject());
  // }
  // // null JSON values are ignored.
  // }
  //
  // private void addArrayPart(OPPComplexObjectInstance whole, String name, JsonArray array) {
  // OPPListObjectInstance list = OPPObjectInstance.createListInstance();
  // for (int i = 0; i < array.size(); i++) {
  // addPart(part, String.valueOf(i), array.get(i));
  // }
  // whole.addPart(name, part);
  // }
  //
  // private void addObjectPart(OPPObjectInstance whole, String name, JsonObject value) {
  // OPPObjectInstance part = read(value);
  // whole.addPart(name, part);
  // }
  //
  // private void addStringPart(OPPObjectInstance whole, String name, String value) {
  // whole.addPart(name, OPPObjectInstance.createFromValue(value));
  // }
  //
  // private void addNumberPart(OPPObjectInstance instance, String whole, double value) {
  // instance.addPart(whole, OPPObjectInstance.createFromValue(new BigDecimal(value)));
  // }
  //
  // private void addBooleanPart(OPPObjectInstance whole, String name, boolean value) {
  // OPPObjectInstance bool = OPPObjectInstance.createFromValue(Boolean.toString(value));
  // whole.addPart(name, bool);
  // }

}
