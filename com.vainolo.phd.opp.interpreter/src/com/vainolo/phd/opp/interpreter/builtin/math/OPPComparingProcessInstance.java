/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin.math;

import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPComparingProcessInstance extends OPPAbstractProcessInstance {

  public OPPComparingProcessInstance() {
  }

  @Override
  public void executing() {
    BigDecimal a = getArgument("a").getNumericalValue();
    BigDecimal b = getArgument("b").getNumericalValue();
    BigDecimal c = new BigDecimal(a.compareTo(b));
    setArgument("c", OPPObjectInstance.createFromValue(c));
  }

  @Override
  public String getName() {
    return "Comparing";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("a"), new OPPParameter("b"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("c"));
  }

}
