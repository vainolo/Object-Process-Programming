/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin.io;

import java.awt.Font;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstanceValueAnalyzer;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPDialogInputProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  private OPPObjectInstanceValueAnalyzer valueAnalyzer;

  public OPPDialogInputProcessInstance() {
    this.valueAnalyzer = new OPPObjectInstanceValueAnalyzer();
  }

  @Override
  protected void executing() {
    OPPObjectInstance prompt = getArgument("prompt");
    if (prompt == null)
      prompt = OPPObjectInstance.createFromValue("Enter a value");

    javax.swing.UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 25));
    javax.swing.UIManager.put("TextField.font", new Font("Segoe UI", Font.PLAIN, 25));
    String input = JOptionPane.showInputDialog(prompt.getStringValue());

    OPPObjectInstance instance = valueAnalyzer.calculateOPMObjectValue(input);
    setArgument("input", instance);
  }

  @Override
  public String getName() {
    return "Dialog Input";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("prompt"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("input"));
  }
}
