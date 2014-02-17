/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.Map;
import java.util.logging.Logger;

import com.google.common.collect.Maps;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.utils.SimpleLoggerFactory;

/**
 * Default implementation of {@link OPMExecutableInstance} interface to be used
 * by subclasses.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public abstract class OPMAbstractProcessInstance implements OPMExecutableInstance {
  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMAbstractProcessInstance.class.getName());

  protected final Map<String, OPMObjectInstance> arguments = Maps.newHashMap();
  protected final Map<OPMObject, OPMObjectInstance> variables = Maps.newHashMap();

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

  @Override
  public void setArgument(String name, OPMObjectInstance value) {
    arguments.put(name, value);
  }

  @Override
  public OPMObjectInstance getArgument(String name) {
    return arguments.get(name);
  }
}
