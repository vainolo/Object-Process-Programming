/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import static com.google.common.base.Preconditions.*;

import java.util.Map;
import java.util.logging.Logger;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.utils.SimpleLoggerFactory;

public abstract class OPMAbstractProcessInstance implements OPMProcessInstance {
  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMAbstractProcessInstance.class.getName());

  private Map<String, OPMObjectInstance> variables = Maps.newHashMap();
  private boolean executing = false;
  private boolean finished = false;
  private boolean active = false;
  private final OPMProcess process;

  protected OPMAbstractProcessInstance(final OPMProcess process) {
    this.process = process;
    initProcessInstance();
  }

  /**
   * This function should do all process initialization, such as initializing parameters, loading definitions, etc.
   */
  protected abstract void initProcessInstance();

  @Override
  public OPMProcess getProcess() {
    return process;
  }

  @Override
  public String getName() {
    return getProcess().getName();
  }

  abstract protected void executing();

  @Override
  public void execute() {
    preExecution();
    executing();
    postExecution();
  }

  private void preExecution() {
    logger.info("Started executing process " + getName());
  }

  private void postExecution() {
    logger.info("Finished executing process " + getName());
  }

  protected OPMObjectInstance getVariable(String name) {
    return variables.get(name);
  }

  protected OPMObjectInstance createVariable(String name) {
    return variables.put(name, new OPMObjectInstance());
  }

  protected boolean variableExists(String name) {
    return variables.containsKey(name);
  }

  @Override
  public Object getArgumentValue(final String name) {
    Preconditions.checkArgument(name != null, "Argument name cannot be null.");
    Preconditions.checkState(variableExists(name), "Variable %s does not exist.", name);
    Preconditions.checkState(getVariable(name).isValueSet(), "Variable %s is not set.", name);
    return getVariable(name).getValue();
  }

  @Override
  public void setArgumentValue(String name, Object value) {
    checkArgument(name != null, "Argument name cannot be null.");
    checkArgument(value != null, "Argument %s value cannot be null.", name);
    checkState(variables.containsKey(name), "Process %s doesn't have a parameter named %s.", getName(), name);
    variables.get(name).setValue(value);
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

  protected void setExecuting(final boolean executing) {
    this.executing = executing;
  }

  protected void setFinished(final boolean finished) {
    this.finished = finished;
  }

  protected void setActive(final boolean active) {
    this.active = active;
  }

  @Override
  public void skip() {
    setFinished(true);
  }

  @Override
  public void stop() {
    // Do nothing
  }
}
