package com.vainolo.opm.model;

import java.util.List;

public interface OPSystem extends OPModelBase {
  String getName();
  void setName(String name);
  
  int getNextId();
  
  List<OPThing> getThings();
  void addThing(OPThing thing);
  void removeThing(OPThing thing);
  
  OPObjectProcessDiagram getSD();
}
