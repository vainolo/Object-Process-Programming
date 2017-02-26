/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.types.OPPComplexObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPGetDateProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  @Override
  protected void executing() {
    LocalDate date = LocalDate.now();
    OPPComplexObjectInstance oppDate = OPPObjectInstance.createCompositeInstance();
    oppDate.setPart("day", OPPObjectInstance.createFromValue(new BigDecimal(date.getDayOfMonth())));
    oppDate.setPart("month", OPPObjectInstance.createFromValue(new BigDecimal(date.getMonthValue())));
    oppDate.setPart("year", OPPObjectInstance.createFromValue(new BigDecimal(date.getYear())));
    setArgument("date", oppDate);
  }

  @Override
  public String getName() {
    return "Get Date";
  }

  @Override
  public java.util.List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("date"));
  }
}
