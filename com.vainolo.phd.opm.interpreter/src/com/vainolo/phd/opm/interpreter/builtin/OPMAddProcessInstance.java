/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;

/**
 * Process that adds two integer values.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public class OPMAddProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {
  @Override
  public void executing() {
    BigDecimal a = getArgument("a").getNumericalValue();
    BigDecimal b = getArgument("b").getNumericalValue();
    BigDecimal c = a.add(b);
    OPMObjectInstance instance = OPMObjectInstance.createFromValue(c);
    setArgument("c", instance);
  }

  @Override
  public String getName() {
    return "Add";
  }

  @Override
  public boolean isReady() {
    return (getArgument("a") != null) && (getArgument("b") != null);
  }

  @Override
  public List<String> getIncomingParameterNames() {
    return Lists.newArrayList("a", "b");
  }

  @Override
  public List<String> getOutgoingParameterNames() {
    return Lists.newArrayList("c");
  }
}
