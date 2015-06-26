package com.vainolo.opm.model;

public class OPNodeView extends OPAbstractViewModelElement {
  public OPNodeView(OPModelElement model) {
    super(model);
  }

  private OPConstraints constraints = new OPConstraints(new OPPoint(0, 0), 0, 0);
  
  public OPConstraints getConstraints() {
    return constraints;
  }

  public void setConstraints(OPConstraints constraints) {
    this.constraints = constraints;
    notifyObservers();
    getModel().notifyObservers();
  }
}
