/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin.io;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstanceValueAnalyzer;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPConsoleReadingProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  private OPPObjectInstanceValueAnalyzer valueAnalyzer;

  public OPPConsoleReadingProcessInstance() {
    this.valueAnalyzer = new OPPObjectInstanceValueAnalyzer();
  }

  @Override
  protected void executing() {
    OPPObjectInstance prompt = getArgument("prompt");
    if (prompt != null)
      System.out.println(prompt);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = "";
    try {
      input = br.readLine();
      if (input != null) {

        if (!input.matches("(\\[.*)|(\\{.*)|([0-9].*)|(\".*)")) {
          input = "\"" + input + "\"";
        }

        OPPObjectInstance instance = valueAnalyzer.calculateOPMObjectValue(input);
        if (instance != null) {
          setArgument("input", instance);
          setArgument("parse error?", OPPObjectInstance.createFromValue("no"));
        } else {
          setArgument("parse error?", OPPObjectInstance.createFromValue("yes"));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getName() {
    return "Console Reading";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return createParameterList("prompt");
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return createParameterList("input", "parse error?");
  }
}
