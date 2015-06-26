package com.vainolo.opm.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OPObjectProcessDiagram extends OPAbstractModelElement implements OPModelElement, OPContainer {

  List<OPNode> nodes = new ArrayList<OPNode>();
  
  @Override
  public List<OPNode> getNodes() {
    return Collections.unmodifiableList(nodes);
  }

  @Override
  public void addNode(OPNode node) {
    nodes.add(node);
    notifyObservers();
  }

  @Override
  public void removeNode(OPNode node) {
    nodes.remove(node);
    notifyObservers();
  }

}
