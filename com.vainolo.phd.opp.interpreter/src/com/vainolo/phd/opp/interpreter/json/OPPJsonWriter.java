/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.json;

import com.eclipsesource.json.JsonObject;
import com.google.common.base.Preconditions;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance.InstanceKind;

public class OPPJsonWriter {

  public JsonObject write(OPPObjectInstance opmObjectInstance) {
    Preconditions.checkState(opmObjectInstance.type == "Complex Object");
    JsonObject jsonObject = new JsonObject();
    for (String partName : opmObjectInstance.getAllPartIndexes()) {
      OPPObjectInstance partValue = opmObjectInstance.getPart(partName);
      addJSONElement(jsonObject, partName, partValue);
    }
    return jsonObject;
  }

  private void addJSONElement(JsonObject jsonObject, String name, OPPObjectInstance opmObject) {
    if (opmObject.type == "String") {
      jsonObject.add(name, opmObject.getStringValue());
    } else if (opmObject.type == "Number") {
      jsonObject.add(name, opmObject.getNumericalValue().doubleValue());
    } else if (opmObject.type == "Complex Object") {
      jsonObject.add(name, write(opmObject));
    } else {
      throw new IllegalStateException();
    }
  }

}
