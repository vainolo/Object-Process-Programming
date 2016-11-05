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

/**
 * Process instance that handles basic unary math operations
 */
public class OPPUnaryMathOpProcessInstance extends OPPAbstractProcessInstance {

  private OPPUnaryMathOpType opType;

  public OPPUnaryMathOpProcessInstance(OPPUnaryMathOpType opType) {
    this.opType = opType;
  }

  @Override
  public void executing() {
    BigDecimal a = getArgument("a").getNumericalValue();
    BigDecimal b = BigDecimal.ZERO;
    switch (opType) {
    case LOG:
      double a_double = a.doubleValue();
      b = new BigDecimal(Math.log(a_double));
      break;
    case NEG:
      b = a.negate();
      break;
    case SQRT:
      a_double = a.doubleValue();
      b = new BigDecimal(Math.sqrt(a_double));
      break;
    }
    OPPObjectInstance instance = OPPObjectInstance.createFromValue(b);
    setArgument("b", instance);
  }

  @Override
  public String getName() {
    return opType.getName();
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("a"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("b"));
  }

  public static enum OPPUnaryMathOpType {
    LOG, NEG, SQRT;

    public String getName() {
      switch (this) {
      case LOG:
        return "log(a)";
      case NEG:
        return "-a";
      case SQRT:
        return "sqrt(a)";
      }
      return null;
    }
  }
}
