package com.vainolo.opm.model;

import java.util.List;

public interface OPModelBase {
  int getId();
  void notifyObservers();
  void addObserver(OPModelObserver observer);
  void removeObserver(OPModelObserver observer);
  List<OPModelObserver> getObservers();
}
