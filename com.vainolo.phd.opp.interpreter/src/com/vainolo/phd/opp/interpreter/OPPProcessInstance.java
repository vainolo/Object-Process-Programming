/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter;

import java.util.List;
import java.util.concurrent.Callable;

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
   *           if the argument has no value (only occurs for outgoing
   *           arguments).
   */
  OPPObjectInstance getArgument(String name);

  /**
   * Get a list of the names of all the incoming parameters of this
   * {@link OPPProcessInstance}.
   * 
   * @return a list of the incoming parameter names.
   */
  List<OPPParameter> getIncomingParameterNames();

  /**
   * Get a list of the names of all the outgoing parameters of this
   * {@link OPPProcessInstance}.
   * 
   * @return a list of the outgoing parameter names.
   */
  List<OPPParameter> getOutgoingParameterNames();

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

  /**
   * Check if the instance is ready for execution
   * 
   * @return <code>true</code> if all required parameters are available,
   *         <code>false</code> otherwise.
   */
  boolean isReady();
}
