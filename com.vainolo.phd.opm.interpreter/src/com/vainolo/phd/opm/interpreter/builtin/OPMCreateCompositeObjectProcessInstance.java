/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMExecutableInstance;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;

public class OPMCreateCompositeObjectProcessInstance extends OPMAbstractProcessInstance implements OPMExecutableInstance {
  @Override
  public void executing() {
    setArgument("new", OPMObjectInstance.createCompositeInstance());
  }

  @Override
  public String getName() {
    return "Create";
  }

  @Override
  public boolean isReady() {
    return true;
  }
}
