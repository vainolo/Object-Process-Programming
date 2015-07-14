package com.vainolo.opm.model;

import java.util.List;

public interface OPObjectProcessDiagram extends OPModelBase, OPViewContainer {
  boolean isZoomed();
  OPNodeView getZoomedThing();
  
  boolean isUnfolded();
  OPNodeView getUnfoldedThing();
  List<OPNodeView> getNodes();
}
