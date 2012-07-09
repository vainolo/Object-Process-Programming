/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.Set;

import com.vainolo.phd.opm.interpreter.model.Variable;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;

public abstract class OPMAbstractProcessInstance implements OPMProcessInstance {
  private VariableManager varManager = new VariableManager();
  private String name = "";
  private boolean executing = false;
  private boolean finished = false;
  private boolean active = false;

  public void setName(final String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void execute() {
    System.out.println("Executing process " + getName());
  }

  protected VariableManager getVarManager() {
    if(varManager == null) {
      varManager = new VariableManager();
    }
    return varManager;
  }

  @Override
  public void addParameter(final String name, final Variable variable, final OPMProceduralLinkKind kind) {
    getVarManager().addParameter(name, variable, kind);
  }

  @Override
  public boolean isReady() {
    Set<Variable> incomingParameters = getVarManager().getIncomingParameters();
    for(Variable var : incomingParameters) {
      if(!var.isSetValue()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean isExecuting() {
    return executing;
  }

  @Override
  public boolean isFinished() {
    return finished;
  }

  public boolean isActive() {
    return active;
  }

  private void setExecuting(final boolean executing) {
    this.executing = executing;
  }

  private void setFinished(final boolean finished) {
    this.finished = finished;
  }

  private void setActive(final boolean active) {
    this.active = active;
  }
}
