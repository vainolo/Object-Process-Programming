package com.vainolo.opm.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class OPAbstractModelElement implements OPModelElement {
  private int id;
  private List<OPModelObserver> observers = new ArrayList<OPModelObserver>();
  
  public void setId(int id) {
    this.id = id;
  }
  
  @Override
  public int getId() {
    return id;
  }

  @Override
  public void addObserver(OPModelObserver observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(OPModelObserver observer) {
    observers.remove(observer);
  }

  @Override
  public void clearObservers() {
    observers.clear();
  }

  @Override
  public List<OPModelObserver> getObservers() {
    return Collections.unmodifiableList(observers);
  }
 
  @Override
  public void notifyObservers() {
    for(OPModelObserver observer: observers) {
      observer.notifyObserver(this);
    }
  }
}
