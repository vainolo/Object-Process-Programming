/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.core.runtime.Path;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPInterpreter;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;

public class OPPReadTextFileProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  @Override
  protected void executing() {
    String filename = getArgument("filename").getStringValue();
    String path = OPPInterpreter.container.getFile(new Path(filename)).getLocation().toString(); // .getFullPath().toString();
    try {
      String contents = new String(Files.readAllBytes(Paths.get(path)));
      setArgument("file contents", OPPObjectInstance.createFromValue(contents));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getName() {
    return "Read Text File";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("filename"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("file contents"));
  }
}
