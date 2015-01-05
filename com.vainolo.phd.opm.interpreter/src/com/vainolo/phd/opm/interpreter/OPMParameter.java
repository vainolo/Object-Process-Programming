package com.vainolo.phd.opm.interpreter;

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