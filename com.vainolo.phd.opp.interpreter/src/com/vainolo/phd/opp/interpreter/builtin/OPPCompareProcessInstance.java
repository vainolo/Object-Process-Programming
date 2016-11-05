/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

/**
 * Process that compares two integer values.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public class OPPCompareProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {
  public enum ComparisonType {
    EQUAL, DIFFERENT, GREATER_THAN, GREATER_THAN_OR_EQUAL, LESS_THAN, LESS_THAN_OR_EQUAL
  }

  private ComparisonType comparisonType;

  public OPPCompareProcessInstance(ComparisonType compareType) {
    this.comparisonType = compareType;
  }

  @Override
  public void executing() {
    BigDecimal a = getArgument("a").getNumericalValue();
    BigDecimal b = getArgument("b").getNumericalValue();
    OPPObjectInstance c;

    boolean result = false;
    switch (comparisonType) {
    case EQUAL:
      result = (a.compareTo(b) == 0);
      break;
    case DIFFERENT:
      result = (a.compareTo(b) != 0);
    case GREATER_THAN:
      result = (a.compareTo(b) > 0);
      break;
    case GREATER_THAN_OR_EQUAL:
      result = (a.compareTo(b) > 0) || (a.compareTo(b) == 0);
      break;
    case LESS_THAN:
      result = (a.compareTo(b) < 0);
      break;
    case LESS_THAN_OR_EQUAL:
      result = (a.compareTo(b) < 0) || (a.compareTo(b) == 0);
      break;
    }

    if (result) {
      c = OPPObjectInstance.createFromValue("yes");
    } else {
      c = OPPObjectInstance.createFromValue("no");
    }
    setArgument("c", c);
  }

  @Override
  public String getName() {
    return "Compare";
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
