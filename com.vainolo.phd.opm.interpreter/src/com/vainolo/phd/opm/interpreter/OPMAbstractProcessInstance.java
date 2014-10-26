/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.List;
import java.util.logging.Logger;

import com.google.common.collect.Lists;
import com.vainolo.utils.SimpleLoggerFactory;

/**
 * Default implementation of {@link OPMProcessInstance} interface to be used by
 * subclasses.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public abstract class OPMAbstractProcessInstance implements OPMProcessInstance {
  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMAbstractProcessInstance.class.getName());

  protected final OPMProcessInstanceHeap heap = new OPMProcessInstanceHeap();
  private String name;

  protected OPMProcessInstanceHeap getHeap() {
    return heap;
  }

  /**
   * Get the name of this instance;
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Set the name of this instance.
   */
  @Override
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
    if(name == null)
      name = "";
    getHeap().addArgument(name.toLowerCase(), value);
  }

  @Override
  public OPMObjectInstance getArgument(String name) {
    if(name == null)
      name = "";
    return getHeap().getArgument(name.toLowerCase());
  }

  @Override
  public List<String> getIncomingParameterNames() {
    return Lists.newArrayList();
  }

  @Override
  public List<String> getOutgoingParameterNames() {
    return Lists.newArrayList();
  }

  @Override
  public ProcessExecutionResult call() throws Exception {
    try {
      preExecution();
      executing();
      postExecution();
    } catch(Exception e) {
      throw new OPMRuntimeException(e);
    }
    return ProcessExecutionResult.FINISHED;
  }

}
