/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMExecutableInstance;
import com.vainolo.phd.opm.model.OPMProcess;

/**
 * Process that assigns one variable's value to another variables.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public class OPMAssignProcessInstance extends OPMAbstractProcessInstance implements OPMExecutableInstance {
  private OPMProcess process;

  @Override
  public void executing() {
    setArgument("b", getArgument("a"));
  }

  @Override
  public String getName() {
    return "Assign";
  }

  @Override
  public boolean isReady() {
    return getArgument("a") != null;
  }
}
