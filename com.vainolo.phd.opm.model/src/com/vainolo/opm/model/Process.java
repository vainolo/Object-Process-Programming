package com.vainolo.opm.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Process extends AbstractModelElement implements ModelElement, NamedElement, Container {

  public Process(int id) {
    super(id);
  }

  private String name;
  private List<Node> nodes = new ArrayList<Node>();

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public List<Node> getNodes() {
    return Collections.unmodifiableList(nodes );
  }

  @Override
  public void addNode(Node node) {
    nodes.add(node);
    notifyObservers();
  }

  @Override
  public void removeNode(Node node) {
    nodes.remove(node);
    notifyObservers();
  }

}
