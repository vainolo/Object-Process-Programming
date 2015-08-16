package com.vainolo.phd.opp.interpreter;

public class OPMParameter {
  String name;
  boolean isCollection;

  public OPMParameter(String name, boolean isCollection) {
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