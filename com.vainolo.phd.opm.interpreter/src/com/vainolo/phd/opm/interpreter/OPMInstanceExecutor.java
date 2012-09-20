/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.Set;
import java.util.logging.Logger;

import com.google.common.collect.Sets;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMConditionalParameter;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMIncomingParameter;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMOutgoingParameter;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMWaitParameter;
import com.vainolo.phd.opm.interpreter.utils.OPDExecutionAnalysis;
import com.vainolo.phd.opm.interpreter.utils.Parameter;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMProcessKind;
import com.vainolo.phd.opm.utilities.analysis.OPMLiterals;
import com.vainolo.utils.SimpleLoggerFactory;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 15 Jul 2012
 * 
 */
public class OPMInstanceExecutor {
  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMInstanceExecutor.class.getName());

  private final OPMProcessInstance instance;
  private final Set<Parameter> parameters;
  private final OPMCompoundProcessInstance caller;

  private ExecutionStatus executionStatus = ExecutionStatus.NOT_EXECUTED;

  public OPMInstanceExecutor(OPMProcessInstance instance, OPMCompoundProcessInstance caller) {
    this.instance = instance;
    this.caller = caller;
    this.parameters = OPDExecutionAnalysis.calculateAllParameters(getProcess());
  }

  public void tryToExecuteInstance() {
    if(shouldSkipProcess()) {
      executionStatus = ExecutionStatus.SKIPPED;
    } else if(!isReady()) {
      executionStatus = ExecutionStatus.NOT_EXECUTED;
    } else {
      // All OK, Execute!
      executionStatus = ExecutionStatus.EXECUTING;
      assignIncomingParameterValues();
      final OPMInstanceRunnable runnable = new OPMInstanceRunnable(this, caller.getResultQueue());
      caller.getExecutorService().execute(runnable);
    }
  }

  public void finishExecution() {
    for(Parameter parameter : Sets.filter(parameters, IsOPMOutgoingParameter.INSTANCE)) {
      OPMObjectInstance var = caller.getVariable(parameter.getObject().getName());
      if(getProcess().getKind().equals(OPMProcessKind.CONCEPTUAL))
        var.setValue(new Object());
      else
        var.setValue(instance.getArgumentValue(parameter.getName()));

      if(parameter.isStateParameter())
        var.setState(parameter.getState().getName());
    }
    executionStatus = ExecutionStatus.EXECUTED;
  }

  private void assignIncomingParameterValues() {
    for(Parameter parameter : Sets.filter(parameters, IsOPMIncomingParameter.INSTANCE)) {
      Object argumentValue = caller.getVariable(parameter.getObject().getName()).getValue();
      instance.setArgumentValue(parameter.getName(), argumentValue);
    }
  }

  private boolean isReady() {
    for(Parameter parameter : Sets.filter(parameters, IsOPMWaitParameter.INSTANCE)) {
      if(!isArgumentReady(parameter)) {
        logger.info("Instance " + getName() + " kept waiting.");
        return false;
      }
    }
    return true;
  }

  private boolean shouldSkipProcess() {
    for(Parameter parameter : Sets.filter(parameters, IsOPMConditionalParameter.INSTANCE)) {
      if(!isArgumentReady(parameter)) {
        logger.info("Skipping instance " + getName());
        return true;
      }
    }
    return false;
  }

  private boolean isArgumentReady(Parameter parameter) {
    OPMObjectInstance argument = caller.getVariable(parameter.getObject().getName());
    if(!argument.isValueSet()) {
      logger.info("Object " + parameter.getObject().getName() + " not ready.");
      return false;
    }
    if(parameter.isStateParameter()) {
      if(Number.class.isInstance(argument.getValue())) {
        Number stateValue = OPMLiterals.parseOPMNumberLiteral(parameter.getState().getName());
        if(!argument.getValue().equals(stateValue))
          return false;
      } else if(!argument.getState().equals(parameter.getState().getName())) {
        logger.info("Object " + parameter.getObject().getName() + " not in state " + parameter.getState().getName() +
            ".");
        return false;
      }
    }
    return true;
  }

  public Set<Parameter> getOutgoingParameters() {
    return Sets.filter(parameters, IsOPMOutgoingParameter.INSTANCE);
  }

  public boolean wasNotExecuted() {
    return executionStatus.equals(ExecutionStatus.NOT_EXECUTED);
  }

  public boolean wasSkipped() {
    return executionStatus.equals(ExecutionStatus.SKIPPED);
  }

  public boolean wasExecuted() {
    switch(executionStatus) {
      case EXECUTED:
      case EXECUTING:
        return true;
      default:
        return false;
    }
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

  public enum ExecutionStatus {
    EXECUTING, EXECUTED, SKIPPED, NOT_EXECUTED;
  }
}
