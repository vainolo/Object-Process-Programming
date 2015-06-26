package com.vainolo.opm.model;

public class OPConstraints {
  public final OPPoint point;
  public final int width;
  public final int height;
  
  public OPConstraints(OPPoint point, int width, int height) {
    this.point = point;
    this.width = width;
    this.height = height;
  }
}
