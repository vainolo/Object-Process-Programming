/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.model.OPMProcess;

/**
 * Process that assigns one variable's value to another variables.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public class OPMAssignProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {
  public OPMAssignProcessInstance(final OPMProcess process) {
    super(process);
  }

  @Override
  public void executing() {
    getVariable("b").setValue(getVariable("a"));
  }

  @Override
  protected void initProcessInstance() {
    createVariable("a");
    createVariable("b");
  }
}
