/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Logger;

import com.eclipsesource.json.JsonObject;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.utils.SimpleLoggerFactory;

public class OPMWriteOPMObjectInstanceToJSON extends OPMAbstractProcessInstance implements OPMProcessInstance {
  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMAbstractProcessInstance.class.getName());

  @Override
  protected void executing() {
    OPMObjectInstance opmObjectInstance = getArgument("object");
    try {
      JsonObject jsonObject = populateJSONFromOPMObjectInstance(opmObjectInstance);
      setArgument("json", OPMObjectInstance.createFromValue(jsonObject.toString()));
    } catch(Exception e) {
      e.printStackTrace();
      logger.severe(e.getLocalizedMessage());
    }
  }

  private JsonObject populateJSONFromOPMObjectInstance(OPMObjectInstance opmObjectInstance) {
    Preconditions.checkState(opmObjectInstance.isComposite());
    JsonObject jsonObject = new JsonObject();
    for(Entry<String, OPMObjectInstance> part : opmObjectInstance.getParts()) {
      String name = part.getKey();
      OPMObjectInstance value = part.getValue();
      addJSONElement(jsonObject, name, value);
    }
    return jsonObject;
  }

  private void addJSONElement(JsonObject jsonObject, String name, OPMObjectInstance opmObject) {
    if(opmObject.isState()) {
      jsonObject.add(name, opmObject.getState());
    } else if(opmObject.isStringValue()) {
      jsonObject.add(name, opmObject.getStringValue());
    } else if(opmObject.isNumericalValue()) {
      jsonObject.add(name, opmObject.getNumericalValue().doubleValue());
    } else if(opmObject.isComposite()) {
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
  public List<String> getIncomingParameterNames() {
    return Lists.newArrayList("object");
  }

  @Override
  public List<String> getOutgoingParameterNames() {
    return Lists.newArrayList("json");
  }

}
