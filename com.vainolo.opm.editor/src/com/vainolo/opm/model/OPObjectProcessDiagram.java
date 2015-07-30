package com.vainolo.opm.model;

import com.vainolo.opm.model.view.OPElementViewContainer;
import com.vainolo.opm.model.view.OPThingView;

public interface OPObjectProcessDiagram extends OPElement, OPElementViewContainer {
  boolean isInzoomed();
  void setInzoomed(boolean inZoomed);
  OPThingView getInzoomedThing();
  void setInzoomedThing(OPThingView inzoomedThing);
  
  boolean isUnfolded();
  void setUnfolded(boolean unfolded);
  OPThingView getUnfoldedThing();
  void setUnfoldedThing(OPThingView unfoldedThing);
}
