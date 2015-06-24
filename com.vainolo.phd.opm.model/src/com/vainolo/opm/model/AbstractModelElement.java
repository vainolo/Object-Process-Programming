package com.vainolo.opm.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractModelElement implements ModelElement {
  private int id;
  private List<ModelObserver> observers = new ArrayList<ModelObserver>();
  
  public AbstractModelElement(int id) {
    this.id = id;
  }
  
  @Override
  public int getId() {
    return id;
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
