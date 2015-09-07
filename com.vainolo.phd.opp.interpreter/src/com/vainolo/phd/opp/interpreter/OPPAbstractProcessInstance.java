/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPProcessExecutionResult.OPMProcessExecutionResultType;

/**
 * Default implementation of {@link OPPProcessInstance} interface to be used by
 * subclasses.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public abstract class OPPAbstractProcessInstance implements OPPProcessInstance {

  protected final OPPProcessInstanceHeap heap = new OPPProcessInstanceHeap();
  private String name;
  private OPPProcessExecutionResult result;

  protected OPPProcessInstanceHeap getHeap() {
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
  public void setArgument(String name, OPPObjectInstance value) {
    if(name == null)
      name = "";
    getHeap().addArgument(name.toLowerCase(), value);
  }

  @Override
  public OPPObjectInstance getArgument(String name) {
    if(name == null)
      name = "";
    return getHeap().getArgument(name.toLowerCase());
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList();
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList();
  }

  @Override
  public OPPProcessExecutionResult call() throws Exception {
    result = new OPPProcessExecutionResult(this, OPMProcessExecutionResultType.FINISHED);
    try {
      preExecution();
      executing();
      postExecution();
    } catch(Exception e) {
      throw new OPPRuntimeException(e);
    }
    return result;
  }

  @Override
  public String toString() {
    return getName() + "@" + Integer.toHexString(hashCode());
  }
}
