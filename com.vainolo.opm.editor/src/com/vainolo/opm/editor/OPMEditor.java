package com.vainolo.opm.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;

public class OPMEditor extends GraphicalEditorWithFlyoutPalette {

	public OPMEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}
	
	@Override
	protected PaletteRoot getPaletteRoot() {
		return null;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {

	}

}
