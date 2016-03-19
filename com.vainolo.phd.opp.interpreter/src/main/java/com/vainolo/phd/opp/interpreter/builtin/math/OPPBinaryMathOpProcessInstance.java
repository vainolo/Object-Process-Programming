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
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;

/**
 * Process instance that handles basic binary math operations
 */
public class OPPBinaryMathOpProcessInstance extends OPPAbstractProcessInstance {

  private OPPBinaryMathOpType opType;

  public OPPBinaryMathOpProcessInstance(OPPBinaryMathOpType opType) {
    this.opType = opType;
  }

  @Override
  public void executing() {
    BigDecimal a = getArgument("a").getNumericalValue();
    BigDecimal b = getArgument("b").getNumericalValue();
    BigDecimal c = new BigDecimal(0);
    switch (opType) {
    case ADD:
      c = a.add(b);
      break;
    case SUBS:
      c = a.subtract(b);
      break;
    case MULT:
      c = a.multiply(b);
      break;
    case DIV:
      c = a.divide(b);
      break;
    case POW:
      c = a.pow(b.intValueExact());
      break;
    }
    OPPObjectInstance instance = OPPObjectInstance.createFromValue(c);
    setArgument("c", instance);
  }

  @Override
  public String getName() {
    return opType.getName();
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("a"), new OPPParameter("b"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("c"));
  }

  public static enum OPPBinaryMathOpType {
    ADD, SUBS, MULT, DIV, POW;

    public String getName() {
      switch (this) {
      case ADD:
        return "a+b";
      case SUBS:
        return "a-b";
      case MULT:
        return "a*b";
      case DIV:
        return "a/b";
      case POW:
        return "a^b";
      }
      return null;
    }
  }
}
