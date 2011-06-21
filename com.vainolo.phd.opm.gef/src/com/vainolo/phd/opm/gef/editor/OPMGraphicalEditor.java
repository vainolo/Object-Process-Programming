package com.vainolo.phd.opm.gef.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import com.vainolo.phd.opm.gef.editor.part.OPMEditPartFactory;
import com.vainolo.phd.opm.gef.utils.OPMModelUtils;

public class OPMGraphicalEditor extends GraphicalEditorWithFlyoutPalette {

	public OPMGraphicalEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}
	
	@Override protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getGraphicalViewer().setContents(OPMModelUtils.INSTANCE.createModel());
	}	
	
	@Override protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		getGraphicalViewer().setEditPartFactory(new OPMEditPartFactory());
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
