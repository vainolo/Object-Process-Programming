/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.json;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.google.common.base.Preconditions;
import com.vainolo.phd.opp.interpreter.types.OPPComplexObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPListObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance.InstanceKind;

public class OPPJsonWriter {

  public JsonObject write(OPPObjectInstance oppObjectInstace) {
    if (oppObjectInstace.kind == InstanceKind.LIST) {
      return writeArray((OPPListObjectInstance) oppObjectInstace);
    } else if (oppObjectInstace.kind == InstanceKind.COMPOSITE) {
      return writeObject((OPPComplexObjectInstance) oppObjectInstace);
    } else {
      throw new IllegalStateException("Function supports lists and complex objects");
    }
  }

  private JsonObject writeArray(OPPListObjectInstance opmListObjectInstance) {
    JsonArray array = new JsonArray();
    for (int i = 1; i <= opmListObjectInstance.count(); i++) {
      array.add(getJSONValue(opmListObjectInstance.get(i)));
    }
    return null;
  }

  private JsonObject writeObject(OPPComplexObjectInstance obmComplexObjectInstance) {
    JsonObject jsonObject = new JsonObject();
    for (String partName : obmComplexObjectInstance.getPartNames()) {
      OPPObjectInstance partValue = obmComplexObjectInstance.getPart(partName);
      jsonObject.add(partName, getJSONValue(partValue));
      // addJSONElement(jsonObject, partName, partValue);
    }
    return jsonObject;
  }

  private JsonValue getJSONValue(OPPObjectInstance opmObject) {
    if (opmObject.kind == InstanceKind.STRING) {
      return Json.value(opmObject.getStringValue());
    } else if (opmObject.kind == InstanceKind.NUMERICAL) {
      return Json.value(opmObject.getNumericalValue().doubleValue());
    } else if (opmObject.kind == InstanceKind.COMPOSITE) {
      return write((OPPComplexObjectInstance) opmObject);
    } else if (opmObject.kind == InstanceKind.LIST) {
      return write((OPPListObjectInstance) opmObject);
    } else {
      throw new IllegalStateException();
    }
  }

}
