/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import java.util.List;

import javax.swing.JOptionPane;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMObjectInstanceValueAnalyzer;
import com.vainolo.phd.opm.interpreter.OPMParameter;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;

/**
 * Take input from the user.
 * 
 * @author Arieh "Vainolo" Bibliowicz"
 * 
 */
public class OPMInputProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {

  private OPMObjectInstanceValueAnalyzer valueAnalyzer;

  @Inject
  public OPMInputProcessInstance(OPMObjectInstanceValueAnalyzer valueAnalyzer) {
    this.valueAnalyzer = valueAnalyzer;
  }

  @Override
  protected void executing() {
    final String input = showInputDialog();
    OPMObjectInstance instance = valueAnalyzer.calculateOPMObjectValue(input);
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
  public List<OPMParameter> getOutgoingParameterNames() {
    return Lists.newArrayList(new OPMParameter("text", false));
  }
}
