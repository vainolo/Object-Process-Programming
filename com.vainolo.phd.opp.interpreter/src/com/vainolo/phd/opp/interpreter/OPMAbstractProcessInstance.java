/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter;

import static com.vainolo.phd.opp.utilities.OPMLogger.*;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPMProcessExecutionResult.OPMProcessExecutionResultType;

/**
 * Default implementation of {@link OPMProcessInstance} interface to be used by
 * subclasses.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public abstract class OPMAbstractProcessInstance implements OPMProcessInstance {

  protected final OPMProcessInstanceHeap heap = new OPMProcessInstanceHeap();
  private String name;
  private OPMProcessExecutionResult result;

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
   * 
   * @throws Exception
   */
  abstract protected void executing() throws Exception;

  /**
   * {@inheritDoc}
   */
  protected void preExecution() {
    logInfo("Started executing process " + getName());
  }

  /**
   * {@inheritDoc}
   */
  protected void postExecution() {
    logInfo("Finished executing process " + getName());
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
  public List<OPMParameter> getIncomingParameterNames() {
    return Lists.newArrayList();
  }

  @Override
  public List<OPMParameter> getOutgoingParameterNames() {
    return Lists.newArrayList();
  }

  @Override
  public OPMProcessExecutionResult call() throws Exception {
    result = new OPMProcessExecutionResult(this, OPMProcessExecutionResultType.FINISHED);
    try {
      preExecution();
      executing();
      postExecution();
    } catch(Exception e) {
      throw new OPMRuntimeException(e);
    }
    return result;
  }

  @Override
  public String toString() {
    return getName() + "@" + Integer.toHexString(hashCode());
  }
}
