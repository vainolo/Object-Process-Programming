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
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;

public class OPPOutputProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

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
  public List<OPPParameter> getIncomingParameterNames() {
    return Lists.newArrayList(new OPPParameter("text", false));
  }
}
