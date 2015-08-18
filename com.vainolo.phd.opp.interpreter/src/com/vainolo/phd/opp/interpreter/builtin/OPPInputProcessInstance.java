/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import java.util.List;

import javax.swing.JOptionPane;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstanceValueAnalyzer;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;

/**
 * Take input from the user.
 * 
 * @author Arieh "Vainolo" Bibliowicz"
 * 
 */
public class OPPInputProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  private OPPObjectInstanceValueAnalyzer valueAnalyzer;

  @Inject
  public OPPInputProcessInstance(OPPObjectInstanceValueAnalyzer valueAnalyzer) {
    this.valueAnalyzer = valueAnalyzer;
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
    return JOptionPane.showInputDialog("Please enter your text here");
  }

  @Override
  public String getName() {
    return "Input";
  }

  @Override
  public boolean isReady() {
    return true;
  }

  @Override
  public List<OPPParameter> getOutgoingParameterNames() {
    return Lists.newArrayList(new OPPParameter("text", false));
  }
}
