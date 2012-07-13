/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;

import com.google.common.collect.Sets;
import com.vainolo.phd.opm.interpreter.model.Variable;
import com.vainolo.phd.opm.interpreter.utils.IsOPMConditionalParameter;
import com.vainolo.phd.opm.interpreter.utils.IsOPMIncomingParameter;
import com.vainolo.phd.opm.interpreter.utils.IsOPMOutgoingParameter;
import com.vainolo.phd.opm.interpreter.utils.IsOPMWaitIncomingParameter;
import com.vainolo.phd.opm.interpreter.utils.OPDAnalyzer;
import com.vainolo.phd.opm.interpreter.utils.OPDExecutionFollower;
import com.vainolo.phd.opm.interpreter.utils.Parameter;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.utils.SimpleLoggerFactory;

public class InstanceExecutor {
  private static Logger logger = SimpleLoggerFactory.createLogger(InstanceExecutor.class.getName());

  private final OPMProcessInstance instance;
  private final VariableManager varManager;
  private final OPDExecutionFollower follower;
  private final ExecutorService executorService;
  private final BlockingQueue<OPMProcessInstanceRunnable> runningProcessInstanceQueue;
  private final Set<Parameter> parameters;

  private ExecutionStatus executionStatus = ExecutionStatus.NOT_EXECUTED;

  public InstanceExecutor(OPMProcessInstance instance, VariableManager varManager, OPDExecutionFollower follower,
      ExecutorService executorService, BlockingQueue<OPMProcessInstanceRunnable> runningProcessInstanceQueue) {
    this.instance = instance;
    this.varManager = varManager;
    this.follower = follower;
    this.executorService = executorService;
    this.runningProcessInstanceQueue = runningProcessInstanceQueue;
    this.parameters = OPDAnalyzer.calculateAllParameters(getProcess());
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
      follower.addSkippedProcess(getProcess());
      executionStatus = ExecutionStatus.SKIPPED;
    } else if(!isReady()) {
      executionStatus = ExecutionStatus.NOT_EXECUTED;
    } else {
      // All OK, Execute!
      putIncomingArgumentsValues();
      OPMProcessInstanceRunnable runnable = new OPMProcessInstanceRunnable(instance, runningProcessInstanceQueue);
      executorService.execute(runnable);
      while(true) {
        try {
          runningProcessInstanceQueue.take();
          break;
        } catch(InterruptedException e) {}
      }
      fetchOutgoingArgumentsValues();

      follower.addExecutedProcess(getProcess());
      executionStatus = ExecutionStatus.EXECUTED;
    }
  }

  private void fetchOutgoingArgumentsValues() {
    for(Parameter parameter : Sets.filter(parameters, IsOPMOutgoingParameter.INSTANCE)) {
      Variable var = varManager.getVariable(parameter.getObject().getName());
      var.setValue(instance.getArgument(parameter.getName()));
    }
  }

  private void putIncomingArgumentsValues() {
    for(Parameter parameter : Sets.filter(parameters, IsOPMIncomingParameter.INSTANCE)) {
      Object argumentValue = varManager.getVariable(parameter.getObject().getName()).getValue();
      instance.addArgument(parameter.getName(), argumentValue);
    }

  }

  private boolean isReady() {
    for(Parameter parameter : Sets.filter(parameters, IsOPMWaitIncomingParameter.INSTANCE)) {
      Variable argument = varManager.getVariable(parameter.getObject().getName());
      if(!argument.isSetValue()) {
        logger.info("Instance " + getName() + " kept waiting.");
        return false;
      }
    }
    return true;
  }

  private boolean shouldSkipProcess() {
    for(Parameter parameter : Sets.filter(parameters, IsOPMConditionalParameter.INSTANCE)) {
      Variable argument = varManager.getVariable(parameter.getObject().getName());
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

  public enum ExecutionStatus {
    EXECUTED, SKIPPED, NOT_EXECUTED;
  }
}
