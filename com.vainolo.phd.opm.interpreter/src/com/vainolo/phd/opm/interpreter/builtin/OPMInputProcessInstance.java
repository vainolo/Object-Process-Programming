/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import javax.swing.JOptionPane;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMExecutableInstance;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;

/**
 * Arguments:
 * <ul>
 * <li>text:String, result</li>
 * </ul>
 * 
 * @author vainolo
 * 
 */
public class OPMInputProcessInstance extends OPMAbstractProcessInstance implements OPMExecutableInstance {

  @Override
  protected void executing() {
    final String retVal = showInputDialog();
    OPMObjectInstance instance = OPMObjectInstance.create(retVal);
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

}
