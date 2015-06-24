package com.vainolo.opm.model;

import java.util.List;

public interface ModelElement {
  int getId();
  void addObserver(ModelObserver observer);
  void removeObserver(ModelObserver observer);
  void clearObservers();
  List<ModelObserver> getObservers();
  void notifyObservers();
}
