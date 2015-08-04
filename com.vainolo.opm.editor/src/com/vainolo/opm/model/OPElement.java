package com.vainolo.opm.model;

import java.util.List;

public interface OPElement {
  int getId();
  void setId(int i);

  void addObserver(OPModelObserver observer);
  void removeObserver(OPModelObserver observer);
  List<OPModelObserver> getObservers();
  void notifyObservers();
}
