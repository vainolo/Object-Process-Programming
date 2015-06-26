package com.vainolo.opm.model;

import java.util.List;

public interface OPModelElement {
  void setId(int id);
  int getId();
  void addObserver(OPModelObserver observer);
  void removeObserver(OPModelObserver observer);
  void clearObservers();
  List<OPModelObserver> getObservers();
  void notifyObservers();
}
