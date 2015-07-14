package com.vainolo.opm.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vainolo.opm.model.OPSystem;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.OPThing;

public class OPSystemImpl extends OPAbstractModelBase implements OPSystem {

  private String name = "";
  private List<OPThing> things = new ArrayList<OPThing>();
  private OPObjectProcessDiagram sd;
  private int nextId = 1; 

  public OPSystemImpl() {
    super(0);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }
  
  @Override
  synchronized public int getNextId() {
    nextId++;
    return nextId-1;
  }
  
  @Override
  public List<OPThing> getThings() {
    return Collections.unmodifiableList(things);
  }

  @Override
  public OPObjectProcessDiagram getSD() {
    return sd;
  }

  @Override
  public void addThing(OPThing thing) {
    things.add(thing);
    notifyObservers();
  }

  @Override
  public void removeThing(OPThing thing) {
    things.remove(thing);
    notifyObservers();
  }

}
