/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import javax.swing.JOptionPane;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.model.OPMProcess;

/**
 * Arguments:
 * <ul>
 * <li>text:String, instrument.</li>
 * </ul>
 * 
 * @author vainolo
 * 
 */
public class OPMOutputProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {

  public OPMOutputProcessInstance(final OPMProcess process) {
    super(process);
  }

  @Override
  protected void executing() {
    final String text = getVarManager().getVariable("text").getValue().toString();
    showMessageDialog(text);
  }

  public void showMessageDialog(final String text) {
    JOptionPane.showMessageDialog(null, text);
  }

  @Override
  protected void initProcessInstance() {
    getVarManager().createVariable("text");
  }
}
