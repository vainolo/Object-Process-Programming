package com.vainolo.opm.model;

import java.util.List;

public interface Container {
  List<Node> getNodes();
  void addNode(Node node);
  void removeNode(Node node);
}
