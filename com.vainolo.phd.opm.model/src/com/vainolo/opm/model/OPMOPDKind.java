package com.vainolo.opm.model;

public enum OPMOPDKind {
  SYSTEM(1, "SYSTEM", "System"), INZOOMED(2, "INZOOMED", "In-Zoomed"), UNFOLDED(3, "UNFOLDED", "Un-Folded");

  private final int value;
  private final String name;
  private final String literal;

  private static OPMOPDKind[] kinds = {SYSTEM, INZOOMED, UNFOLDED};
  
  OPMOPDKind(int value, String name, String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }
  
  public String getLiteral() {
    return literal;
  }
  
  public String getName() {
    return name;
  }
  
  public int getValue() {
    return value;
  }
  
  public static OPMOPDKind getByName(String name) {
    for(OPMOPDKind kind : kinds) {
      if(kind.name.equals(name))
          return kind;
    }
    throw new IllegalArgumentException();
  }
}
