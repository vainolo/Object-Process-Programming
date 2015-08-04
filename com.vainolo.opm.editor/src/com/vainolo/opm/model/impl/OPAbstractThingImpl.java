package com.vainolo.opm.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vainolo.opm.model.OPNode;
import com.vainolo.opm.model.OPModelObserver;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.OPThing;

public abstract class OPAbstractThingImpl extends OPAbstractNodeImpl implements OPThing {

	  private List<OPNode> nodes = new ArrayList<OPNode>();
	  private boolean isInzoomed = false;
	  private OPObjectProcessDiagram inzoomedObjectProcessDiagram;
	  private boolean isUnfolded = false;
	  private OPObjectProcessDiagram unfoldedObjectProcessDiagram;

	  
	  public OPAbstractThingImpl(int id) {
    super(id);
  }


  @Override
  public List<OPNode> getNodes() {
    return Collections.unmodifiableList(nodes);
  }
  
  @Override
  public void addNode(OPNode element) {
    nodes.add(element);
    notifyObservers();
  }
  
  @Override
  public void removeNode(OPNode element) {
    nodes.remove(element);
    notifyObservers();
  }

  @Override
  public boolean isInzoomed() {
    return isInzoomed;
  }
  
  @Override
  public boolean setInzoomed(boolean inzoomed) {
    return isInzoomed = inzoomed;
  }
  
  @Override
  public OPObjectProcessDiagram getInzoomedObjectProcessDiagram() {
    return inzoomedObjectProcessDiagram;
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
