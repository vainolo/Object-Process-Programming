/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.core.runtime.Path;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPInterpreter;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPTextFileWritingProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  @Override
  protected void executing() {
    String filename = getArgument("file name").getStringValue();
    String path = OPPInterpreter.container.getFile(new Path(filename)).getLocation().toString(); // .getFullPath().toString();
    OPPObjectInstance object = getArgument("object");
    try {
      PrintWriter writer = new PrintWriter(filename, "UTF-8");
      writer.print(object.toString());
      writer.close();
      setArgument("file error?", OPPObjectInstance.createFromValue("no"));
    } catch (IOException e) {
      e.printStackTrace();
      setArgument("file error?", OPPObjectInstance.createFromValue("yes"));
    }
  }

  @Override
  public String getName() {
    return "Text File Writing";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return createParameterList("file name", "object");
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return createParameterList("file error?");
  }

}
