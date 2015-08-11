package com.vainolo.phd.opm.interpreter.builtin;

/**
 * Basic binary math operations
 */
public enum BinaryMathOpType {
  ADD, SUBS, MULT, DIV, POW;

  public String getName() {
    switch(this) {
    case ADD:
      return "Add";
    case SUBS:
      return "Subtract";
    case MULT:
      return "Multiply";
    case DIV:
      return "Divide";
    case POW:
      return "Power";
    }
    throw new IllegalStateException("This should NEVER happen!");
  }
}
