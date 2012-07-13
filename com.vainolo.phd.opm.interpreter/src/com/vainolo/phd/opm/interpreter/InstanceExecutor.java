/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.Set;

import com.vainolo.phd.opm.interpreter.utils.OPDAnalyzer;
import com.vainolo.phd.opm.interpreter.utils.Parameter;
import com.vainolo.phd.opm.model.OPMProcess;

public class InstanceExecutor {

  public OPMProcessInstance instance;
  public Set<Parameter> parameters;

  public InstanceExecutor(OPMProcessInstance instance) {
    this.instance = instance;
  }

  public void setParameters(final Set<Parameter> parameters) {
    this.parameters = parameters;
  }

  public OPMProcessInstance getInstance() {
    return instance;
  }

  public Set<Parameter> getParameters() {
    return parameters;
  }

  public String getName() {
    return instance.getName();
  }

  public OPMProcess getProcess() {
    return instance.getProcess();
  }

  public void tryToExecuteInstance() {
    setParameters(OPDAnalyzer.calculateAllParameters(getProcess()));

  }

  public enum ExecutionStatus {
    EXECUTED, SKIPPED, NOT_EXECUTED;
  }
}
