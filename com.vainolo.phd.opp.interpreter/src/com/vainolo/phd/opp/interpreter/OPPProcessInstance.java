/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter;

import java.util.List;
import java.util.concurrent.Callable;

import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 2 Jul 2012
 * 
 */
public interface OPPProcessInstance extends Callable<OPPProcessExecutionResult> {

  /**
   * Set the value of an argument.
   * 
   * @param name
   *          of the argument.
   * @param value
   *          of the argument.
   */
  void setArgument(String name, OPPObjectInstance value);

  /**
   * Get the value of an argument.
   * 
   * @param name
   *          of the argument.
   * @return value of the argument.
   * @throws IllegalStateException
   *           if the argument has no value (only occurs for outgoing arguments).
   */
  OPPObjectInstance getArgument(String name);

  /**
   * Get a list of the names of all the incoming parameters of this {@link OPPProcessInstance}.
   * 
   * @return a list of the incoming parameter names.
   */
  List<OPPParameter> getIncomingParameters();

  /**
   * Get a list of the names of all the outgoing parameters of this {@link OPPProcessInstance}.
   * 
   * @return a list of the outgoing parameter names.
   */
  List<OPPParameter> getOutgoingParameters();

  /**
   * Get the name of the OPD/Process
   * 
   * @return the name of the OPD/Process
   */
  String getName();

  /**
   * Set the name of the Process.
   */
  void setName(String name);
}
