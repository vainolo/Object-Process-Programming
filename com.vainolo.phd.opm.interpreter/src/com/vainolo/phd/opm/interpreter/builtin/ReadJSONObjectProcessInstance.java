/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.logging.Logger;

import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonObject.Member;
import com.eclipsesource.json.JsonValue;
import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.utils.SimpleLoggerFactory;

public class ReadJSONObjectProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {
  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMAbstractProcessInstance.class.getName());

  @Override
  protected void executing() {
    try {
      String filePath = getArgument("file").getStringValue();
      File f = new File(filePath);
      JsonObject object = JsonObject.readFrom(new FileReader(f));
      Iterator<Member> it = object.iterator();
      while(it.hasNext()) {
        Member m = it.next();
        String name = m.getName();
        JsonValue value = m.getValue();
        logger.info("Read member " + name + " with value " + value.toString());
      }

    } catch(Exception e) {
      logger.severe(e.getLocalizedMessage());
    }
  }

  @Override
  public String getName() {
    return "Input";
  }

  @Override
  public boolean isReady() {
    return getArgument("file") != null;
  }

}
