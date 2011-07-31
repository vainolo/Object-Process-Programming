package com.vainolo.phd.opm.gef.editor;

import java.io.IOException;
import java.util.EventObject;

import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMPackage;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.ToggleGridAction;
import org.eclipse.gef.ui.actions.ToggleSnapToGeometryAction;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;

import com.vainolo.phd.opm.gef.editor.part.OPMEditPartFactory;

public class OPMGraphicalEditor extends GraphicalEditorWithFlyoutPalette {
	
	public static final String ID = "com.vainolo.phd.opp.gef.editorID";
	
	private Resource opdResource;
	private OPMObjectProcessDiagram opd;

	public OPMGraphicalEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}

	@Override protected PaletteRoot getPaletteRoot() {
		return new OPMGraphicalEditorPalette();
	}

	@Override protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getGraphicalViewer().setContents(opd);
	}

	@Override protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		getGraphicalViewer().setEditPartFactory(new OPMEditPartFactory());
		getActionRegistry().registerAction(new ToggleGridAction(getGraphicalViewer()));	
		getActionRegistry().registerAction(new ToggleSnapToGeometryAction(getGraphicalViewer()));
	}

    @Override public void doSave(IProgressMonitor monitor) {
        if(opdResource == null) {
            return;
        }
        
        try {
            opdResource.save(null);
            getCommandStack().markSaveLocation();
        } catch(IOException e) {
            // TODO do something smarter.
            e.printStackTrace();
            opdResource = null;
        }
    }
	
	@Override public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		loadInput(input);
	}
	
	private void loadInput(IEditorInput input) {
		OPMPackage.eINSTANCE.eClass(); // This initializes the OPMPackage singleton implementation.
		ResourceSet resourceSet = new ResourceSetImpl();
		if(input instanceof IFileEditorInput) {
			IFileEditorInput fileInput = (IFileEditorInput) input;
			IFile file = fileInput.getFile();
			opdResource = resourceSet.createResource(URI.createURI(file.getLocationURI().toString()));
			try {
				opdResource.load(null);
				opd = (OPMObjectProcessDiagram) opdResource.getContents().get(0);
			} catch(IOException e) {
				// TODO do something smarter.
				e.printStackTrace();
				opdResource = null;
			}
		}
	}


	@Override public void commandStackChanged(EventObject event) {
        firePropertyChange(PROP_DIRTY);
        super.commandStackChanged(event);
    }

	
}
