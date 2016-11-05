package com.vainolo.phd.opp.interpreter.types;

import java.math.BigDecimal;

public class OPPNumberObjectInstance extends OPPObjectInstance {

  private BigDecimal value;

  protected OPPNumberObjectInstance(BigDecimal value) {
    super(InstanceKind.NUMERICAL);
    this.value = value;
  }

  @Override
  public BigDecimal getNumericalValue() {
    return value;
  }

  @Override
  public String getStringValue() {
    return value.toString();
  }

  @Override
  public Object getValue() {
    return getNumericalValue();
  }

  @Override
  public String toString() {
    return value.toString();
  }
}
