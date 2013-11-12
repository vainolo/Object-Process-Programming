/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

import com.vainolo.phd.opm.gef.OPMGEFEditorPlugin;
import com.vainolo.phd.opm.interpreter.OPMInterpreter;

public class StopInterpreterAction extends Action {

  public static final String STOP_INTERPRETER_ID = "StopInterpreter";

  public StopInterpreterAction() {
    super();
    setId(STOP_INTERPRETER_ID);
    setText("Stop Interpreter");
    setToolTipText("Stop the interpreter's execution.");
    setImageDescriptor(ImageDescriptor.createFromFile(OPMGEFEditorPlugin.class, "icons/opm_stop_interpreter.gif")); //$NON-NLS-1$
    setEnabled(true);
  }

  @Override
  public void run() {
    OPMInterpreter.INSTANCE.stopExecution();
  }
}
