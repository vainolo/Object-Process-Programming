package com.vainolo.opm.model;

import java.util.List;

public interface OPObjectProcessDiagram extends OPModelBase, OPNodeViewContainer {
  boolean isInzoomed();
  void setInzoomed(boolean inZoomed);
  OPThingView getInzoomedThing();
  void setInzoomedThing(OPThingView inzoomedThing);
  
  boolean isUnfolded();
  void setUnfolded(boolean unfolded);
  OPThingView getUnfoldedThing();
  void setUnfoldedThing(OPThingView unfoldedThing);
  
  void addLinkView(OPLinkView link);
  void removeLinkView(OPLinkView link);
  List<OPLinkView> getLinks();
}
