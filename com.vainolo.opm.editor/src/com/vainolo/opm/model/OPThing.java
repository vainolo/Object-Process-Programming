package com.vainolo.opm.model;

import java.util.List;

public interface OPThing extends OPNode {

  List<OPNode> getChildElements();
  void addChildElement(OPNode element);
  void removeChildElement(OPNode element);
  
  boolean isInZoomed();
  boolean setZoomed(boolean zoomed);
  OPObjectProcessDiagram getInZoomedObjectProcessDiagram();
  
  boolean isUnfolded();
  void setUnfolded(boolean unfolded);
  OPObjectProcessDiagram getUnfoldedObjectProcessDiagram();

  
}
