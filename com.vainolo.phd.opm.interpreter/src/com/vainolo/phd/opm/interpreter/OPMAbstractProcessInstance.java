/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.Map;
import java.util.logging.Logger;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.vainolo.utils.SimpleLoggerFactory;

public abstract class OPMAbstractProcessInstance implements OPMExecutableInstance {
  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMAbstractProcessInstance.class.getName());

  protected final Map<String, Object> arguments = Maps.newHashMap();
  protected final Map<String, Object> variables = Maps.newHashMap();

  /**
   * Actual instance execution, must be implemented by subclasses.
   */
  abstract protected void executing();

  /**
   * Execution of an OPD is done in three steps: pre-execution, execution, and
   * post-execution. All of these steps can be overriden by subclasses to
   * implement the execution functionality. All subclasses must implement at the
   * minimum the <code>executing</code> function.
   */
  @Override
  public final void execute() {
    preExecution();
    executing();
    postExecution();
  }

  /**
   * First step in the execution of an OPD (see {@link #execute()}). Default
   * implementation, prints to log.
   */
  protected void preExecution() {
    logger.info("Started executing process " + getName());
  }

  /**
   * Last step in the execution of an OPD (see {@link #execute()}). Default
   * implementation, prints to the log.
   */
  protected void postExecution() {
    logger.info("Finished executing process " + getName());
  }

  protected void createVariable(String name) {
    variables.put(name, null);
  }

  protected void createArgument(String name) {
    arguments.put(name, null);
  }

  @Override
  public void setArgument(String name, Object value) {
    Preconditions.checkArgument(arguments.containsKey(name), "%s is not an valid parameter of %s", name, getName());
    arguments.put(name, value);
  }

  @Override
  public Object getArgument(String name) {
    Preconditions.checkArgument(arguments.containsKey(name), "%s is not an valid parameter of %s", name, getName());
    return arguments.get(name);
  }

  protected void setVariable(String name, Object value) {
    Preconditions.checkArgument(variables.containsKey(name), "%s is not a valid variable of %s", name, getName());
    variables.put(name, value);
  }

  protected Object getVariable(String name) {
    Preconditions.checkArgument(variables.containsKey(name), "%s is not a valid variable of %s", name, getName());
    return variables.get(name);
  }
}
