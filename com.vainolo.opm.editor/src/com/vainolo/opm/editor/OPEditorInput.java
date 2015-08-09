package com.vainolo.opm.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;

import com.vainolo.opm.model.opm.OPObjectProcessDiagram;
import com.vainolo.opm.model.opm.OPSystem;

public class OPEditorInput extends FileEditorInput implements IEditorInput {

	private OPSystem system;

	public OPEditorInput(IFile file, OPSystem system) {
		super(file);
		this.system = system;
	}
	
	OPSystem getSystem() {
		return system;
	}

	OPObjectProcessDiagram getCurrentCurrentObjectProcessDiagram() {
		return system.getSystemDiagram();
	}
}
