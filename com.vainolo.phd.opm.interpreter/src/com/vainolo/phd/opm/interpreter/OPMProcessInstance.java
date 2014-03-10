/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 2 Jul 2012
 * 
 */
public interface OPMProcessInstance {

  /**
   * Set the value of an argument.
   * 
   * @param name
   *          of the argument.
   * @param value
   *          of the argument.
   */
  void setArgument(String name, OPMObjectInstance value);

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
  OPMObjectInstance getArgument(String name);

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
   * Execute this instance.
   */
  void execute();

  /**
   * Check if the instance is ready for execution
   * 
   * @return <code>true</code> if all required parameters are available,
   *         <code>false</code> otherwise.
   */
  boolean isReady();
}
