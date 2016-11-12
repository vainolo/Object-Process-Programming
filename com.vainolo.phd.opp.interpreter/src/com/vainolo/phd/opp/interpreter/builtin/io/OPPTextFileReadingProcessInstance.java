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
import com.vainolo.phd.opp.interpreter.OPPObjectInstanceValueAnalyzer;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPTextFileReadingProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  @Override
  protected void executing() {
    OPPObjectInstanceValueAnalyzer analyzer = new OPPObjectInstanceValueAnalyzer();
    String filename = OPPInterpreter.container.getFile(new Path(getArgument("file name").getStringValue())).getRawLocation().toString();
    try {
      String contents = new String(Files.readAllBytes(Paths.get(filename)));
      OPPObjectInstance object = analyzer.calculateOPMObjectValue(contents);
      setArgument("input", object);
      setArgument("file error?", OPPObjectInstance.createFromValue("no"));
      setArgument("parse error?", OPPObjectInstance.createFromValue("no"));
    } catch (IOException e) {
      e.printStackTrace();
      setArgument("file error?", OPPObjectInstance.createFromValue("yes"));
      setArgument("parse error?", OPPObjectInstance.createFromValue("no"));
    }
  }

  @Override
  public String getName() {
    return "Text File Reading";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("file name"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return createParameterList("file error?", "parse error?", "input");
  }
}
