package com.vainolo.opm.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OPProcess extends OPAbstractModelElement implements OPModelElement, OPNamedElement, OPContainer {

  private String name;
  private List<OPNode> nodes = new ArrayList<OPNode>();

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public List<OPNode> getNodes() {
    return Collections.unmodifiableList(nodes );
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
