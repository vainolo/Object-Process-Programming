/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPProcessExecutionResult.OPMProcessExecutionResultType;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

/**
 * Default implementation of {@link OPPProcessInstance} interface to be used by subclasses.
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
    StringBuffer arguments = new StringBuffer("Incoming arguments: ");
    boolean hasParameters = false;
    for (OPPParameter parameter : getIncomingParameters()) {
      arguments.append(parameter.getName() + ":" + getArgument(parameter.getName()) + ", ");
      hasParameters = true;
    }
    if (hasParameters) {
      logFine(arguments.substring(0, arguments.length() - 2));
    } else {
      logFine("No incoming arguments");
    }
  }

  /**
   * {@inheritDoc}
   */
  protected void postExecution() {
    logInfo("Finished executing process " + getName());
    StringBuffer arguments = new StringBuffer("Outgoing arguments: ");
    boolean hasParameters = false;
    for (OPPParameter parameter : getOutgoingParameters()) {
      arguments.append(parameter.getName() + ":" + getArgument(parameter.getName()) + ", ");
      hasParameters = true;
    }
    if (hasParameters) {
      logFine(arguments.substring(0, arguments.length() - 2));
    } else {
      logFine("No outgoing arguments");
    }
  }

  @Override
  public void setArgument(String name, OPPObjectInstance value) {
    if (name == null)
      name = "";
    else {
      if (!getAllParameterNames().contains(name)) {
        logSevere("Process {0} does not have a parameter named {1}.", getName(), name);
        throw new OPPRuntimeException("Process " + getName() + " does not have a parameter named " + name + ".");
      }
    }
    getHeap().setArgument(name.toLowerCase(), value);
  }

  @Override
  public OPPObjectInstance getArgument(String name) {
    if (name == null)
      name = "";
    else {
      if (!getAllParameterNames().contains(name)) {
        logSevere("Process {1} does not have a parameter named {2}.", getName(), name);
        throw new OPPRuntimeException("Process " + getName() + " does not have a parameter named " + name + ".");
      }
    }
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

  private List<String> getAllParameterNames() {
    return Stream.concat(getIncomingParameters().stream(), getOutgoingParameters().stream()).map(p -> p.getName()).collect(Collectors.toList());
  }

  @Override
  public OPPProcessExecutionResult call() throws Exception {
    result = new OPPProcessExecutionResult(this, OPMProcessExecutionResultType.FINISHED);
    try {
      preExecution();
      executing();
      postExecution();
    } catch (Exception e) {
      logSevere("Exception while executing process {0}.", getName());
      logSevere("Exception: {0}", e);
      e.printStackTrace();
      throw new OPPRuntimeException(e);
    }
    return result;
  }

  @Override
  public String toString() {
    return getName() + "@" + Integer.toHexString(hashCode());
  }

  protected List<OPPParameter> createParameterList(String... parameterNames) {
    List<OPPParameter> parametersList = Lists.newArrayList();
    for (String parameterName : parameterNames) {
      parametersList.add(new OPPParameter(parameterName));
    }
    return parametersList;
  }
}
