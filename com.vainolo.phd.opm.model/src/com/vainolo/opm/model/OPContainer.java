package com.vainolo.opm.model;

import java.util.List;

public interface OPContainer {
  List<OPNode> getNodes();
  void addNode(OPNode node);
  void removeNode(OPNode node);
}
