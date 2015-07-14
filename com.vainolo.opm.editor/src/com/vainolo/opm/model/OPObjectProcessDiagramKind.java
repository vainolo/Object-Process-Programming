package com.vainolo.opm.model;

public enum OPObjectProcessDiagramKind {
  SYSTEM(1, "SYSTEM", "System"), INZOOMED(2, "INZOOMED", "In-Zoomed"), UNFOLDED(3, "UNFOLDED", "Un-Folded");

  private final int value;
  private final String name;
  private final String literal;

  private static OPObjectProcessDiagramKind[] kinds = {SYSTEM, INZOOMED, UNFOLDED};
  
  OPObjectProcessDiagramKind(int value, String name, String literal) {
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
  
  public static OPObjectProcessDiagramKind getByName(String name) {
    for(OPObjectProcessDiagramKind kind : kinds) {
      if(kind.name.equals(name))
          return kind;
    }
    throw new IllegalArgumentException();
  }
}
