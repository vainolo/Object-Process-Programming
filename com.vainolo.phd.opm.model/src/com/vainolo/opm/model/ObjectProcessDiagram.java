package com.vainolo.opm.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ObjectProcessDiagram extends AbstractModelElement implements ModelElement, Container {

  public ObjectProcessDiagram(int id) {
    super(id);
  }

  List<Node> nodes = new ArrayList<Node>();
  
  @Override
  public List<Node> getNodes() {
    return Collections.unmodifiableList(nodes);
  }

  @Override
  public void addNode(Node node) {
    nodes.add(node);
  }

  @Override
  public void removeNode(Node node) {
    nodes.remove(node);
  }

}
