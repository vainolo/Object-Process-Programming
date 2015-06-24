package com.vainolo.opm.model;

public enum OPMOPDKind {
  SYSTEM(1, "SYSTEM", "System"), INZOOMED(2, "INZOOMED", "In-Zoomed"), UNFOLDED(3, "UNFOLDED", "Un-Folded");

  private int value;
  private String name;
  private String literal;

  private static OPMOPDKind[] values = {SYSTEM, INZOOMED, UNFOLDED};
  
  OPMOPDKind(int value, String name, String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }
  
  public String getLiteral() {
    return literal;
  }
  
  public static OPMOPDKind getByName(String name) {
    for(OPMOPDKind kind : values) {
      if(kind.name.equals(name))
          return kind;
    }
    throw new IllegalArgumentException();
  }
}
