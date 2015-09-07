package com.vainolo.phd.opp.interpreter;

public class OPPParameter {
  String name;
  boolean isCollection;

  public OPPParameter(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}