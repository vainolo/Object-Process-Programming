/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.action;

import org.eclipse.jface.action.Action;

import com.vainolo.phd.opm.interpreter.Interpreter;

public class StopInterpreterAction extends Action {

  public static final String STOP_INTERPRETER_ID = "StopInterpreter";

  public StopInterpreterAction() {
    super();
    setId(STOP_INTERPRETER_ID);
    setText("Stop Interpreter");
  }

  @Override
  public void run() {
    Interpreter.INSTANCE.stopExecution();
  }
}
