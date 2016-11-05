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

public class OPPConsoleInputProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {
  private static final String PROCESS_NAME = "Console Input";
  private static final String PROMPT_PARAM_NAME = "prompt";
  private static final OPPParameter PROMPT_PARAM = new OPPParameter(PROMPT_PARAM_NAME);
  private static final String INPUT_PARAM_NAME = "input";
  private static final OPPParameter INPUT_PARAM = new OPPParameter(INPUT_PARAM_NAME);
  private static final List<OPPParameter> INCOMING_PARAMS = Lists.newArrayList(PROMPT_PARAM);
  private static final List<OPPParameter> OUTGOIN_PARAMS = Lists.newArrayList(INPUT_PARAM);

  private OPPObjectInstanceValueAnalyzer valueAnalyzer;

  public OPPConsoleInputProcessInstance() {
    this.valueAnalyzer = new OPPObjectInstanceValueAnalyzer();
  }

  @Override
  protected void executing() {
    OPPObjectInstance prompt = getArgument(PROMPT_PARAM_NAME);
    if (prompt != null)
      System.out.println(prompt);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = "";
    try {
      input = br.readLine();
      if (input != null) {
        OPPObjectInstance instance = valueAnalyzer.calculateOPMObjectValue(input);
        setArgument(INPUT_PARAM_NAME, instance);
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Override
  public String getName() {
    return PROCESS_NAME;
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return INCOMING_PARAMS;
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return OUTGOIN_PARAMS;
  }
}
