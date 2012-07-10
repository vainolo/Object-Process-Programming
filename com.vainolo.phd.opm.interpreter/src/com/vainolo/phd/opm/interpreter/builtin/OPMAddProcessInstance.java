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
 * Process that adds two integer values.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public class OPMAddProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {
  public OPMAddProcessInstance(final OPMProcess process) {
    super(process);
  }

  @Override
  public void execute() {
    final int a = Integer.parseInt(getVarManager().getVariable("a").getValue().toString());
    final int b = Integer.parseInt(getVarManager().getVariable("b").getValue().toString());
    final int c = a + b;
    addArgument("c", c);
  }

  @Override
  public String getName() {
    return "Add";
  }
}
