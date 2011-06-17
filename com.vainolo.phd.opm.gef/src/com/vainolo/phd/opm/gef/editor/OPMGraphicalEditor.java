package com.vainolo.phd.opm.gef.editor;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;

public class OPMGraphicalEditor extends GraphicalEditorWithFlyoutPalette {

	public OPMGraphicalEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}
	
	@Override
	protected PaletteRoot getPaletteRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
	}
}
