/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.Set;
import java.util.logging.Logger;

import com.google.common.collect.Sets;
import com.vainolo.phd.opm.interpreter.model.Variable;
import com.vainolo.phd.opm.interpreter.utils.IsOPMConditionalParameter;
import com.vainolo.phd.opm.interpreter.utils.IsOPMIncomingParameter;
import com.vainolo.phd.opm.interpreter.utils.IsOPMOutgoingParameter;
import com.vainolo.phd.opm.interpreter.utils.IsOPMWaitIncomingParameter;
import com.vainolo.phd.opm.interpreter.utils.OPDAnalyzer;
import com.vainolo.phd.opm.interpreter.utils.Parameter;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.utils.SimpleLoggerFactory;

public class OPMInstanceExecutor {
  private static Logger logger = SimpleLoggerFactory.createLogger(OPMInstanceExecutor.class.getName());

  private final OPMProcessInstance instance;
  private final Set<Parameter> parameters;
  private final OPMCompoundProcessInstance parent;

  private ExecutionStatus executionStatus = ExecutionStatus.NOT_EXECUTED;

  public OPMInstanceExecutor(OPMProcessInstance instance, OPMCompoundProcessInstance parent) {
    this.instance = instance;
    this.parameters = OPDAnalyzer.calculateAllParameters(getProcess());
    this.parent = parent;
  }

  public OPMProcessInstance getInstance() {
    return instance;
  }

  public String getName() {
    return instance.getName();
  }

  public OPMProcess getProcess() {
    return instance.getProcess();
  }

  public void tryToExecuteInstance() {
    if(shouldSkipProcess()) {
      executionStatus = ExecutionStatus.SKIPPED;
    } else if(!isReady()) {
      executionStatus = ExecutionStatus.NOT_EXECUTED;
    } else {
      // All OK, Execute!
      putIncomingArgumentsValues();
      OPMInstanceRunnable runnable = new OPMInstanceRunnable(this, parent.getResultQueue());
      executionStatus = ExecutionStatus.EXECUTING;
      parent.getExecutorService().execute(runnable);
      while(true) {
        try {
          parent.getResultQueue().take();
          break;
        } catch(InterruptedException e) {}
      }
    }
  }

  public void afterExecutionHandling() {
    fetchOutgoingArgumentsValues();
    executionStatus = ExecutionStatus.EXECUTED;
  }

  private void fetchOutgoingArgumentsValues() {
    for(Parameter parameter : Sets.filter(parameters, IsOPMOutgoingParameter.INSTANCE)) {
      Variable var = parent.getVarManager().getVariable(parameter.getObject().getName());
      var.setValue(instance.getArgument(parameter.getName()));
    }
  }

  private void putIncomingArgumentsValues() {
    for(Parameter parameter : Sets.filter(parameters, IsOPMIncomingParameter.INSTANCE)) {
      Object argumentValue = parent.getVarManager().getVariable(parameter.getObject().getName()).getValue();
      instance.addArgument(parameter.getName(), argumentValue);
    }

  }

  private boolean isReady() {
    for(Parameter parameter : Sets.filter(parameters, IsOPMWaitIncomingParameter.INSTANCE)) {
      Variable argument = parent.getVarManager().getVariable(parameter.getObject().getName());
      if(!argument.isSetValue()) {
        logger.info("Instance " + getName() + " kept waiting.");
        return false;
      }
    }
    return true;
  }

  private boolean shouldSkipProcess() {
    for(Parameter parameter : Sets.filter(parameters, IsOPMConditionalParameter.INSTANCE)) {
      Variable argument = parent.getVarManager().getVariable(parameter.getObject().getName());
      if(!argument.isSetValue()) {
        logger.info("Skipping instance " + getName());
        return true;
      }
    }
    return false;
  }

  public ExecutionStatus getExecutionStatus() {
    return executionStatus;
  }

  public Set<Parameter> getParameters() {
    return parameters;
  }

  public Set<Parameter> getOutgoingParameters() {
    return Sets.filter(parameters, IsOPMOutgoingParameter.INSTANCE);
  }

  public boolean wasSkipped() {
    return getExecutionStatus().equals(ExecutionStatus.SKIPPED);
  }

  public boolean wasExecuted() {
    switch(getExecutionStatus()) {
      case EXECUTED:
      case EXECUTING:
        return true;
    }
    return false;
  }

  public enum ExecutionStatus {
    EXECUTING, EXECUTED, SKIPPED, NOT_EXECUTED;
  }
}
