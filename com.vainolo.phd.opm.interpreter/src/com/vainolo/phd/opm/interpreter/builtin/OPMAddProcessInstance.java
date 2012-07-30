/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import java.math.BigDecimal;

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
  public void executing() {
    final BigDecimal a = new BigDecimal(getVarManager().getVariable("a").getValue().toString());
    final BigDecimal b = new BigDecimal(getVarManager().getVariable("b").getValue().toString());
    final BigDecimal c = a.add(b);
    getVarManager().getVariable("c").setValue(c);
  }

  @Override
  protected void initProcessInstance() {
    getVarManager().createVariable("a");
    getVarManager().createVariable("b");
    getVarManager().createVariable("c");
  }
}
