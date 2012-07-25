/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import com.vainolo.phd.opm.model.OPMProcess;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 2 Jul 2012
 * 
 */
public interface OPMProcessInstance {

  /**
   * Get the name of the process.
   * 
   * @return the name of the process.
   */
  String getName();

  /**
   * Get the name of the process that created this process instance.
   * 
   * @return the process that created this process instance.
   */
  OPMProcess getProcess();

  /**
   * Execute the process.
   */
  void execute();

  /**
   * Set the value of an argument.
   * 
   * @param name
   *          of the argument.
   * @param value
   *          of the argument.
   */
  void setArgumentValue(String name, Object value);

  /**
   * Get the value of an argument.
   * 
   * @param name
   *          of the argument.
   * @return value of the argument.
   * @throws IllegalStateException
   *           if the argument has no value (only occurs for outgoing arguments).
   */
  Object getArgumentValue(String name);

  /**
   * Check if the process has finished.
   * 
   * @return <code>true</code> if the process has finished execution, <code>false</code> otherwise.
   */
  boolean isFinished();

  /**
   * Check if the process is currently executing.
   * 
   * @return <code>true</code> if the process is currently executing, <code>false</code> otherwise.
   */
  boolean isExecuting();

  /**
   * Skip process execution;
   */
  void skip();
}
