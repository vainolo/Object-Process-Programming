package com.vainolo.opm.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vainolo.opm.model.OPNodeView;
import com.vainolo.opm.model.OPObjectProcessDiagram;

public class OPObjectProcessDiagramImpl extends OPAbstractModelBase implements OPObjectProcessDiagram {
  private List<OPNodeView> nodes = new ArrayList<OPNodeView>();
  private boolean isInZoomed = false;
  private OPNodeView zoomedThing;
  private boolean isUnfolded = false;
  private OPNodeView unfoldedThing;

  public OPObjectProcessDiagramImpl(int id) {
    super(id);
  }

  @Override
  public boolean isZoomed() {
    return isInZoomed;
  }

  @Override
  public OPNodeView getZoomedThing() {
    return zoomedThing;
  }

  @Override
  public boolean isUnfolded() {
    return isUnfolded;
  }

  @Override
  public OPNodeView getUnfoldedThing() {
    return unfoldedThing;
  }

@Override
public void removeNode(OPNodeView node) {
	nodes.remove(node);
	notifyObservers();
}

@Override
public void addNode(OPNodeView node) {
	nodes.add(node);
	notifyObservers();
}

@Override
public List<OPNodeView> getNodes() {
	return Collections.unmodifiableList(nodes);
}
}
