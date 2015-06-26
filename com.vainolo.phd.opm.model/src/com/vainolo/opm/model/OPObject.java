package com.vainolo.opm.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OPObject extends OPAbstractModelElement implements OPModelElement, OPNamedElement, OPContainer, OPNode {

  private String name = "";
  private List<OPNode> nodes = new ArrayList<OPNode>();
  private OPNodeView view = new OPNodeView(this);
  private OPContainer container;

  @Override
  public void setName(String name) {
    this.name = name;
    notifyObservers();
  }

  @Override
  public String getName() {
    return name;
  }

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

  public List<OPLink> getLinks() {
    return null;
  }

  public void setContainer(OPContainer container) {
    this.container = container;
    this.container.addNode(this);
    notifyObservers();
  }

  public OPContainer getContainer() {
    return container;
  }
  
  public OPNodeView getViewModel() {
    return view;
  }
  
  public void setViewModel(OPNodeView view) {
    this.view = view;
    notifyObservers();
  }

}
