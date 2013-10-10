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
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.utils.SimpleLoggerFactory;

public abstract class OPMAbstractProcessInstance implements OPMExecutableInstance {
  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMAbstractProcessInstance.class.getName());

  protected final Map<String, OPMObject> arguments = Maps.newHashMap();
  protected final Map<OPMObject, Object> variables = Maps.newHashMap();

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

  protected void createVariable(OPMObject object) {
    variables.put(object, null);
  }

  @Override
  public void setArgument(String name, Object value) {
    Preconditions.checkArgument(arguments.containsKey(name), "%s is not an valid parameter of %s", name, getName());
    variables.put(arguments.get(name), value);
  }

  @Override
  public Object getArgument(String name) {
    Preconditions.checkArgument(arguments.containsKey(name), "%s is not an valid parameter of %s", name, getName());
    return variables.get(arguments.get(name));
  }

  protected void setVariable(OPMObject object, Object value) {
    Preconditions.checkArgument(variables.containsKey(object), "%s is not a valid variable of %s", object.getName(),
        getName());
    variables.put(object, value);
  }

  protected Object getVariable(OPMObject object) {
    Preconditions.checkArgument(variables.containsKey(object), "%s is not a valid variable of %s", object.getName(),
        getName());
    return variables.get(object);
  }
}
