/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;

public class OPMAddPartToCompositeObjectProcessInstance extends OPMAbstractProcessInstance implements
    OPMProcessInstance {
  @Override
  public void executing() {
    OPMObjectInstance composite = getArgument("composite");
    OPMObjectInstance part = getArgument("part");
    String partName = getArgument("name").getStringValue();
    composite.setPart(partName, part);
  }

  @Override
  public String getName() {
    return "Add Part";
  }

  @Override
  public boolean isReady() {
    return true;
  }
}
