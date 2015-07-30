package com.vainolo.opm.model;

import java.util.List;

public interface OPSystem extends OPElement {
  String getName();
  void setName(String name);
  
  int getNextId();
  void setNextId(int nextId);
  
  List<OPThing> getThings();
  void addThing(OPThing thing);
  void removeThing(OPThing thing);
  
  List<OPLink> getLinks();
  void addLink(OPLink link);
  void removeLink(OPLink link);
  
  OPObjectProcessDiagram getSD();
  void setSD(OPObjectProcessDiagram sd);

}
