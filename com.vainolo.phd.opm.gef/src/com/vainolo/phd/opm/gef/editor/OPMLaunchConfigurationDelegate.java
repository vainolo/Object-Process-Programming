package com.vainolo.phd.opm.gef.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.vainolo.phd.opm.interpreter.Interpreter;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;

public class OPMLaunchConfigurationDelegate extends LaunchConfigurationDelegate implements ILaunchConfigurationDelegate {

	private OPMObjectProcessDiagram opd;

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
			}
		});

		Interpreter.INSTANCE.interpret(opd);

	}
}
