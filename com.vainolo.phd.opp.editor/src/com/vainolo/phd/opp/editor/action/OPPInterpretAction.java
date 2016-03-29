/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.action;

import org.eclipse.core.resources.IContainer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;

import com.vainolo.phd.opp.editor.OPPGraphicalEditor;
import com.vainolo.phd.opp.editor.OPPEditorPlugin;
import com.vainolo.phd.opp.interpreter.OPPInterpreter;

public class OPPInterpretAction extends Action {
  public static final String INTERPRET_ID = "Interpret";

  public OPPInterpretAction() {
    setId(INTERPRET_ID);
    setText("Interpret");
    setToolTipText("Interpret the current model.");
    setImageDescriptor(ImageDescriptor.createFromFile(OPPEditorPlugin.class, "icons/opm_interpret.gif")); //$NON-NLS-1$
    setEnabled(true);
  }

  @Override
  public void run() {
    final IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .getActiveEditor();
    final String processName = ((OPPGraphicalEditor) activeEditor).getOPD().getName();
    final IContainer container = ((IFileEditorInput) activeEditor.getEditorInput()).getFile().getParent();

    (new Thread(() -> OPPInterpreter.INSTANCE.interpret(processName, container))).start();
  }
}
