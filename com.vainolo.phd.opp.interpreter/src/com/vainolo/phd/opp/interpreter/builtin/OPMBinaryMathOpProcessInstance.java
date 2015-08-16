package com.vainolo.phd.opp.interpreter.builtin;

import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPMObjectInstance;
import com.vainolo.phd.opp.interpreter.OPMParameter;

/**
 * Process instance that handles basic binary math operations
 */
public class OPMBinaryMathOpProcessInstance extends OPMAbstractProcessInstance {

  private BinaryMathOpType opType;

  public OPMBinaryMathOpProcessInstance(BinaryMathOpType opType) {
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
    OPMObjectInstance instance = OPMObjectInstance.createFromValue(c);
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
  public List<OPMParameter> getIncomingParameterNames() {
    return Lists.newArrayList(new OPMParameter("a", false), new OPMParameter("b", false));
  }

  @Override
  public List<OPMParameter> getOutgoingParameterNames() {
    return Lists.newArrayList(new OPMParameter("c", false));
  }
}
