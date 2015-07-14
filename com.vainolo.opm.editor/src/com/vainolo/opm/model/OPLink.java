package com.vainolo.opm.model;

public interface OPLink extends OPModelBase {
  OPNode getSource();
  void setSource(OPNode source);
  OPNode getTarget();
  void setTarget(OPNode target);
}
