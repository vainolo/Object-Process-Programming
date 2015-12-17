/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

import com.vainolo.phd.opp.editor.OPPEditorPlugin;
import com.vainolo.phd.opp.interpreter.OPPInterpreter;

public class OPPStopInterpreterAction extends Action {

  public static final String STOP_INTERPRETER_ID = "StopInterpreter";

  public OPPStopInterpreterAction() {
    super();
    setId(STOP_INTERPRETER_ID);
    setText("Stop Interpreter");
    setToolTipText("Stop the interpreter's execution.");
    setImageDescriptor(ImageDescriptor.createFromFile(OPPEditorPlugin.class, "icons/opm_stop_interpreter.gif")); //$NON-NLS-1$
    setEnabled(true);
  }

  @Override
  public void run() {
    OPPInterpreter.INSTANCE.stopExecution();
  }
}
