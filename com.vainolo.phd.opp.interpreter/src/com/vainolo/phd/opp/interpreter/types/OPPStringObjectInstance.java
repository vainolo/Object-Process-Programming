package com.vainolo.phd.opp.interpreter.types;

import java.math.BigDecimal;

public class OPPStringObjectInstance extends OPPObjectInstance {

  private String value;

  protected OPPStringObjectInstance(String value) {
    super(InstanceKind.STRING);
    this.value = value;
  }

  @Override
  public BigDecimal getNumericalValue() {
    return new BigDecimal(getStringValue());
  }

  @Override
  public String getStringValue() {
    return value;
  }

  @Override
  public Object getValue() {
    return getStringValue();
  }

  @Override
  public String toString() {
    return "\"" + value + "\"";
  }
}
