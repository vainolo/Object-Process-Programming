package com.vainolo.opm.model;

public class OPAbstractViewModelElement extends OPAbstractModelElement implements OPModelElement, OPViewModelElement {

  private OPModelElement model; 
  
  public OPAbstractViewModelElement(OPModelElement model) {
    this.model = model;
  }

  @Override
  public OPModelElement getModel() {
    return model;
  }
}
