/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.lang.annotation.Inherited;
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
  private String name;

  /**
   * Get the name of this instance;
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name of this instance.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * {@inheritDoc}
   */
  abstract protected void executing();

  /**
   * {@inheritDoc}
   */
  @Override
  public final void execute() {
    preExecution();
    executing();
    postExecution();
  }

  /**
   * {@inheritDoc}
   */
  protected void preExecution() {
    logger.info("Started executing process " + getName());
  }

  /**
   * {@inheritDoc}
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
