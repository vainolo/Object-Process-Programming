package com.vainolo.opm.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class System implements ModelElement{
  List<ObjectProcessDiagram> OPDs;
  ObjectProcessDiagram sd;
  private int nextId;
  private List<ModelObserver> observers = new ArrayList<ModelObserver>();
  
  public System() {
    sd = new ObjectProcessDiagram(1);
    nextId = 2;
  }

  @Override
  public int getId() {
    return 0; // by defintion, the ID of the system model is 0.
  }

  @Override
  public void addObserver(ModelObserver observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(ModelObserver observer) {
    observers.remove(observer);
  }

  @Override
  public void clearObservers() {
    observers.clear();
  }

  @Override
  public List<ModelObserver> getObservers() {
    return Collections.unmodifiableList(observers);
  }

  @Override
  public void notifyObservers() {
    for(ModelObserver observer: observers) {
      observer.notifyObserver(this);
    }
  }
  
  
}
