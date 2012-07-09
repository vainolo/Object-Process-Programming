package com.vainolo.phd.opm.interpreter.builtin;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;

public class OPMAddProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {
  @Override
  public void execute() {
    final int a = (Integer) getVarManager().getVariable("a").getValue();
    final int b = (Integer) getVarManager().getVariable("b").getValue();
    final int c = a + b;
    getVarManager().getVariable("c").setValue(c);
  }

  @Override
  public String getName() {
    return "Add";
  }
}
