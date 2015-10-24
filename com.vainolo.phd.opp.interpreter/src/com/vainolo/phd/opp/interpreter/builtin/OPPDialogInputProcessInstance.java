/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import java.util.List;

import javax.swing.JOptionPane;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstanceValueAnalyzer;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;

public class OPPDialogInputProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  private OPPObjectInstanceValueAnalyzer valueAnalyzer;

  public OPPDialogInputProcessInstance() {
    this.valueAnalyzer = new OPPObjectInstanceValueAnalyzer();
  }

  @Override
  protected void executing() {
    final String input = showInputDialog();
    OPPObjectInstance instance = valueAnalyzer.calculateOPMObjectValue(input);
    setArgument("text", instance);
  }

  /**
   * Method is public for testing purposes. Do not call directly.
   */
  public String showInputDialog() {
    OPPObjectInstance prompt = getArgument("prompt");
    if (prompt == null)
      prompt = OPPObjectInstance.createFromValue("Enter a value");
    return JOptionPane.showInputDialog(prompt.getStringValue());
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
    return Lists.newArrayList(new OPPParameter("text"));
  }
}
