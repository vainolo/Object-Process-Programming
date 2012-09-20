/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.action;

import org.eclipse.core.resources.IContainer;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;

import com.vainolo.phd.opm.gef.editor.OPMGraphicalEditor;
import com.vainolo.phd.opm.interpreter.Interpreter;

public class InterpretAction extends Action {

  public static final String INTERPRET_ID = "Interpret";

  public InterpretAction() {
    super();
    setId(INTERPRET_ID);
    setText("interpreter");
  }

  @Override
  public void run() {
    final IEditorPart activeEditor =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
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
