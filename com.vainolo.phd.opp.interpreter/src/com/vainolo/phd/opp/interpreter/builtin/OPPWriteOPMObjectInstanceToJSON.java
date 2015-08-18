/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import java.util.List;
import java.util.Map.Entry;

import com.eclipsesource.json.JsonObject;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance.InstanceType;

public class OPPWriteOPMObjectInstanceToJSON extends OPPAbstractProcessInstance implements OPPProcessInstance {

  @Override
  protected void executing() {
    OPPObjectInstance opmObjectInstance = getArgument("object");
    try {
      JsonObject jsonObject = populateJSONFromOPMObjectInstance(opmObjectInstance);
      setArgument("json", OPPObjectInstance.createFromValue(jsonObject.toString()));
    } catch(Exception e) {
      e.printStackTrace();
      logSevere(e.getLocalizedMessage());
    }
  }

  private JsonObject populateJSONFromOPMObjectInstance(OPPObjectInstance opmObjectInstance) {
    Preconditions.checkState(opmObjectInstance.type == InstanceType.COMPOSITE);
    JsonObject jsonObject = new JsonObject();
    for(Entry<String, OPPObjectInstance> part : opmObjectInstance.getCompositeParts()) {
      String name = part.getKey();
      OPPObjectInstance value = part.getValue();
      addJSONElement(jsonObject, name, value);
    }
    return jsonObject;
  }

  private void addJSONElement(JsonObject jsonObject, String name, OPPObjectInstance opmObject) {
    if(opmObject.type == InstanceType.STRING) {
      jsonObject.add(name, opmObject.getStringValue());
    } else if(opmObject.type == InstanceType.NUMERICAL) {
      jsonObject.add(name, opmObject.getNumericalValue().doubleValue());
    } else if(opmObject.type == InstanceType.COMPOSITE) {
      jsonObject.add(name, populateJSONFromOPMObjectInstance(opmObject));
    } else {
      throw new IllegalStateException();
    }
  }

  @Override
  public String getName() {
    return "Write JSON";
  }

  @Override
  public boolean isReady() {
    return getArgument("object") != null;
  }

  @Override
  public List<OPPParameter> getIncomingParameterNames() {
    return Lists.newArrayList(new OPPParameter("object", false));
  }

  @Override
  public List<OPPParameter> getOutgoingParameterNames() {
    return Lists.newArrayList(new OPPParameter("json", false));
  }

}
