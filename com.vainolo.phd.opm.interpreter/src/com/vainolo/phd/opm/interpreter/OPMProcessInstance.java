/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import com.vainolo.phd.opm.interpreter.model.Variable;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 2 Jul 2012
 * 
 */
public interface OPMProcessInstance {

  String getName();

  void execute();

  void addParameter(String name, Variable variable, OPMProceduralLinkKind kind);

  /**
   * Check if all parameters are available.
   * 
   * @return
   */
  boolean isReady();

  boolean isFinished();

  boolean isExecuting();
}
