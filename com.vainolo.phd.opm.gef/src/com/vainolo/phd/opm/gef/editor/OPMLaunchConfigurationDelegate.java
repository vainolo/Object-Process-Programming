/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.vainolo.phd.opm.interpreter.Interpreter;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;

public class OPMLaunchConfigurationDelegate extends LaunchConfigurationDelegate implements ILaunchConfigurationDelegate {

	private OPMObjectProcessDiagram opd;
	private IContainer container;

	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		workbench.getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				IEditorPart activeEditor = workbench.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				OPMGraphicalEditor editor = (OPMGraphicalEditor) activeEditor;
				opd = editor.getOPD();

				IFileEditorInput input = (IFileEditorInput) activeEditor.getEditorInput();
				IFile file = input.getFile();
				container = file.getParent();

			}
		});
		(new Thread(new Runnable() {
			@Override
			public void run() {
				Interpreter.INSTANCE.interpret(opd, container);
			}
		})).start();

	}
}
