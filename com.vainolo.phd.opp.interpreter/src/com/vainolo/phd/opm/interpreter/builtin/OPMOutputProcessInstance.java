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
import com.vainolo.phd.opm.interpreter.OPMParameter;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;

public class OPMOutputProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {

  @Override
  protected void executing() {
    Object text = getArgument("text");
    JOptionPane.showMessageDialog(null, text);
  }

  @Override
  public String getName() {
    return "Output";
  }

  @Override
  public boolean isReady() {
    return getArgument("text") != null;
  }

  @Override
  public List<OPMParameter> getIncomingParameterNames() {
    return Lists.newArrayList(new OPMParameter("text", false));
  }
}
