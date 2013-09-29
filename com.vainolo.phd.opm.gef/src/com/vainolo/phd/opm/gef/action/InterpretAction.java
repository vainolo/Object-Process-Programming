/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.action;

import org.eclipse.core.resources.IContainer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;

import com.vainolo.phd.opm.gef.OPMGEFEditorPlugin;
import com.vainolo.phd.opm.gef.editor.OPMGraphicalEditor;
import com.vainolo.phd.opm.interpreter.Interpreter;

public class InterpretAction extends Action {
  public static final String INTERPRET_ID = "Interpret";

  public InterpretAction() {
    setId(INTERPRET_ID);
    setText("Interpret");
    setToolTipText("Interpret the current model.");
    setImageDescriptor(ImageDescriptor.createFromFile(OPMGEFEditorPlugin.class, "icons/opm_interpret.gif")); //$NON-NLS-1$
    setEnabled(true);
  }

  @Override
  public void run() {
    final IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .getActiveEditor();
    final String processName = ((OPMGraphicalEditor) activeEditor).getOPD().getName();
    final IContainer container = ((IFileEditorInput) activeEditor.getEditorInput()).getFile().getParent();

    (new Thread(new Runnable() {
      @Override
      public void run() {
        Interpreter.INSTANCE.interpret(processName, container);
      }
    })).start();
  }
}
