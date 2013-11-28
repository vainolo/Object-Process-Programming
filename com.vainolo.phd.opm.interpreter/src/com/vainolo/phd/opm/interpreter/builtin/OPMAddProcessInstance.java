/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import java.math.BigDecimal;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMExecutableInstance;

/**
 * Process that adds two integer values.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public class OPMAddProcessInstance extends OPMAbstractProcessInstance implements OPMExecutableInstance {
  @Override
  public void executing() {
    final double a = (double) getArgument("a");
    final double b = (double) getArgument("b");
    final double c = a + b;
    setArgument("c", c);
  }

  @Override
  public String getName() {
    return "Add";
  }

  @Override
  public boolean isReady() {
    return (getArgument("a") != null) && (getArgument("b") != null);
  }
}
