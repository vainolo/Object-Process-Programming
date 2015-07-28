package com.vainolo.opm.model;

import java.util.List;

import com.vainolo.opm.model.view.OPNodeView;

public interface OPNode extends OPElement {
  String getName();
  void setName(String name);
  
  List<OPLink> getLinks();
  void addLink(OPLink link);
  void removeLink(OPLink link);
  
  OPNodeView getView();
  void setView(OPNodeView view);
  
  OPContainer getContainer();
  void setContainer(OPContainer container);
}
