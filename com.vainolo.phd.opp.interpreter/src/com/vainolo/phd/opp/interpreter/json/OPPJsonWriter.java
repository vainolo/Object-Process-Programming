package com.vainolo.phd.opp.interpreter.json;

import com.eclipsesource.json.JsonObject;
import com.google.common.base.Preconditions;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance.InstanceKind;

public class OPPJsonWriter {

  public JsonObject write(OPPObjectInstance opmObjectInstance) {
    Preconditions.checkState(opmObjectInstance.kind == InstanceKind.COMPOSITE);
    JsonObject jsonObject = new JsonObject();
    for (String partName : opmObjectInstance.getAllPartIndexes()) {
      OPPObjectInstance partValue = opmObjectInstance.getPart(partName);
      addJSONElement(jsonObject, partName, partValue);
    }
    return jsonObject;
  }

  private void addJSONElement(JsonObject jsonObject, String name, OPPObjectInstance opmObject) {
    if (opmObject.kind == InstanceKind.STRING) {
      jsonObject.add(name, opmObject.getStringValue());
    } else if (opmObject.kind == InstanceKind.NUMERICAL) {
      jsonObject.add(name, opmObject.getNumericalValue().doubleValue());
    } else if (opmObject.kind == InstanceKind.COMPOSITE) {
      jsonObject.add(name, write(opmObject));
    } else {
      throw new IllegalStateException();
    }
  }

}
