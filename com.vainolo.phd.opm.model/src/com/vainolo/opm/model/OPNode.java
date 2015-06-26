package com.vainolo.opm.model;

import java.util.List;

public interface OPNode {
  List<OPLink> getLinks();

  void setContainer(OPContainer container);
  OPContainer getContainer();
  
  OPNodeView getViewModel();
  void setViewModel(OPNodeView view);
}
