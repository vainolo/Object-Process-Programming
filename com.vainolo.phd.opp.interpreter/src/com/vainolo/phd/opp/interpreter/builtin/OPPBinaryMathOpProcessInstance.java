package com.vainolo.phd.opp.interpreter.builtin;

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
    BigDecimal c = null;
    switch(opType) {
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
  public boolean isReady() {
    return (getArgument("a") != null) && (getArgument("b") != null);
  }

  @Override
  public List<OPPParameter> getIncomingParameterNames() {
    return Lists.newArrayList(new OPPParameter("a", false), new OPPParameter("b", false));
  }

  @Override
  public List<OPPParameter> getOutgoingParameterNames() {
    return Lists.newArrayList(new OPPParameter("c", false));
  }
}
