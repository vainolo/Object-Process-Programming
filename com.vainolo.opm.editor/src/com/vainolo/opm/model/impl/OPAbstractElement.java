package com.vainolo.opm.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vainolo.opm.model.OPElement;
import com.vainolo.opm.model.OPModelObserver;

public abstract class OPAbstractElement implements OPElement {

  private int id;
  private List<OPModelObserver> observers = new ArrayList<OPModelObserver>();

  public OPAbstractElement(int id) {
    this.id = id;
  }
  
  @Override
  public int getId() {
    return id;
  }
  
  @Override
  public void setId(int id) {
	  this.id = id;
  }

  @Override
  public void notifyObservers() {
    for(OPModelObserver observer: observers)
      observer.acceptNotification(this);
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
  public List<OPModelObserver> getObservers() {
    return Collections.unmodifiableList(observers);
  }
}
