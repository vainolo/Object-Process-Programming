package com.vainolo.opm.model;

import java.util.ArrayList;
import java.util.List;

public class OPSystem extends OPAbstractModelElement implements OPModelElement{
  List<OPObjectProcessDiagram> OPDs;
  OPObjectProcessDiagram sd;
  private int nextId;
  private List<OPModelObserver> observers = new ArrayList<OPModelObserver>();
  
  public OPSystem() {
    sd = new OPObjectProcessDiagram();
    sd.setId(1);
    nextId = 2;
  }

  @Override
  public int getId() {
    return 0; // by defintion, the ID of the system model is 0.
  }
  
  public synchronized int getNexId() {
    nextId++;
    return nextId-1;
  }
}
