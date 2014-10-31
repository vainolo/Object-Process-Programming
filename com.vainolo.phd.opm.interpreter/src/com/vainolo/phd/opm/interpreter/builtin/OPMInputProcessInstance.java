/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import java.util.List;

import javax.swing.JOptionPane;

import com.google.common.collect.Lists;
import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMInterpreter;
import com.vainolo.phd.opm.interpreter.OPMObjectInstanceValueAnalyzer;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;

/**
 * Take input from the user.
 * 
 * @author Arieh "Vainolo" Bibliowicz"
 * 
 */
public class OPMInputProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {

  @Override
  protected void executing() {
    final String input = showInputDialog();
    OPMObjectInstanceValueAnalyzer va = OPMInterpreter.INSTANCE.injector
        .getInstance(OPMObjectInstanceValueAnalyzer.class);
    OPMObjectInstance instance = null;
    if(va.isNumericalValue(input)) {
      instance = OPMObjectInstance.createFromValue(va.parseNumericalValue(input));
    } else {
      instance = OPMObjectInstance.createFromValue(input);
    }
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
  public List<String> getOutgoingParameterNames() {
    return Lists.newArrayList("text");
  }

}
