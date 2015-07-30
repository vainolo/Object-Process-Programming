package com.vainolo.opm.model;

import java.util.List;

public interface OPThing extends OPNode {
  List<OPNode> getNodes();
  void addNode(OPNode node);
  void removeNode(OPNode node);
  
  boolean isInzoomed();
  boolean setInzoomed(boolean inzoomed);
  OPObjectProcessDiagram getInzoomedObjectProcessDiagram();
  
  boolean isUnfolded();
  void setUnfolded(boolean unfolded);
  OPObjectProcessDiagram getUnfoldedObjectProcessDiagram();
}
