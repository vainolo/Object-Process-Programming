package com.vainolo.phd.opp.interpreter;

public class OPPParameter {
  String name;
  boolean isCollection;

  public OPPParameter(String name, boolean isCollection) {
    this.name = name;
    this.isCollection = isCollection;
  }

  public String getName() {
    return name;
  }

  public boolean isCollection() {
    return isCollection;
  }

}