package com.vainolo.opm.model;

public interface OPLink extends OPElement {
  OPNode getSource();
  void setSource(OPNode source);
  OPNode getTarget();
  void setTarget(OPNode target);
}
