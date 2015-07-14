package com.vainolo.opm.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vainolo.opm.model.OPNode;
import com.vainolo.opm.model.OPModelObserver;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.OPThing;

public abstract class OPAbstractThing extends OPAbstractNode implements OPThing {

  public OPAbstractThing(int id) {
    super(id);
  }

  private List<OPNode> elements = new ArrayList<OPNode>();
  private boolean isInZoomed = false;
  private OPObjectProcessDiagram zoomedObjectProcessDiagram;
  private boolean isUnfolded = false;
  private OPObjectProcessDiagram unfoldedObjectProcessDiagram;

  @Override
  public List<OPNode> getChildElements() {
    return Collections.unmodifiableList(elements);
  }
  
  @Override
  public void addChildElement(OPNode element) {
    elements.add(element);
    for(OPModelObserver observer:getObservers()) {
      element.addObserver(observer);
    }
    notifyObservers();
  }
  
  @Override
  public void removeChildElement(OPNode element) {
    elements.remove(element);
    for(OPModelObserver observer:getObservers()) {
      element.removeObserver(observer);
    }
    notifyObservers();
  }

  @Override
  public boolean isInZoomed() {
    return isInZoomed;
  }
  
  @Override
  public boolean setZoomed(boolean zoomed) {
    return isInZoomed = zoomed;
  }
  
  @Override
  public OPObjectProcessDiagram getInZoomedObjectProcessDiagram() {
    return zoomedObjectProcessDiagram;
  }

  @Override
  public boolean isUnfolded() {
    return isUnfolded;
  }

  @Override
  public void setUnfolded(boolean unfolded) {
    this.isUnfolded = unfolded;
  }
  
  @Override
  public OPObjectProcessDiagram getUnfoldedObjectProcessDiagram() {
    return unfoldedObjectProcessDiagram;
  }

}
