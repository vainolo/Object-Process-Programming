/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin;

import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPMObjectInstance;
import com.vainolo.phd.opp.interpreter.OPMParameter;
import com.vainolo.phd.opp.interpreter.OPMProcessInstance;

/**
 * Process that compares two integer values.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public class OPMCompareProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {
  public enum ComparisonType {
    EQUAL, DIFFERENT, GREATER_THAN, GREATER_THAN_OR_EQUAL, LESS_THAN, LESS_THAN_OR_EQUAL
  }

  private ComparisonType comparisonType;

  public OPMCompareProcessInstance(ComparisonType compareType) {
    this.comparisonType = compareType;
  }

  @Override
  public void executing() {
    BigDecimal a = getArgument("a").getNumericalValue();
    BigDecimal b = getArgument("b").getNumericalValue();
    OPMObjectInstance c;

    boolean result = false;
    switch(comparisonType) {
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

    if(result) {
      c = OPMObjectInstance.createFromValue("true");
    } else {
      c = OPMObjectInstance.createFromValue("false");
    }
    setArgument("c", c);
  }

  @Override
  public String getName() {
    return "Compare";
  }

  @Override
  public boolean isReady() {
    return (getArgument("a") != null) && (getArgument("b") != null);
  }

  @Override
  public List<OPMParameter> getIncomingParameterNames() {
    return Lists.newArrayList(new OPMParameter("a", false), new OPMParameter("b", false));
  }

  @Override
  public List<OPMParameter> getOutgoingParameterNames() {
    return Lists.newArrayList(new OPMParameter("c", false));
  }
}
