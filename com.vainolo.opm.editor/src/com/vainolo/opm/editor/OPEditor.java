package com.vainolo.opm.editor;

import java.io.ByteArrayInputStream;
import java.util.EventObject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.gef.ui.properties.UndoablePropertySheetEntry;
import org.eclipse.gef.ui.properties.UndoablePropertySheetPage;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheetPage;

import com.vainolo.opm.editor.part.OPEditPartFactory;
import com.vainolo.opm.model.OPModelFactory;
import com.vainolo.opm.model.OPObject;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.OPProcess;
import com.vainolo.opm.model.OPSystem;
import com.vainolo.opm.model.io.OPJsonWriter;
import com.vainolo.opm.model.view.OPNodeView;

public class OPEditor extends GraphicalEditorWithFlyoutPalette {
	
	private OPSystem system;
	private OPObjectProcessDiagram opd;
	private PropertySheetPage propertyPage;
	
	private OPModelFactory modelFactory = new OPModelFactory(); 
	
	public OPEditor() {
		setEditDomain(new DefaultEditDomain(this));
		system = getModelFactory().createSystem();
		getModelFactory().setSystem(system);
		opd = getModelFactory().createObjectProcessDiagram();
		system.setSD(opd);
		OPNodeView view = getModelFactory().createThingView();
		OPObject object = getModelFactory().createObject();
		view.setModel(object);
		object.setName("Hello");
		view.setViewElementContainer(opd);
		opd.addElementView(view);
		view.setViewElementContainer(opd);
		object.getView().setConstraints(100, 100, 200, 200);
		view = getModelFactory().createThingView();
		OPProcess process = getModelFactory().createProcess();
		view.setModel(process);
		process.setName("world");
		view.setViewElementContainer(opd);
		opd.addElementView(view);
		view.setViewElementContainer(opd);
		process.getView().setConstraints(400, 100, 200, 200);
	}
	
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getGraphicalViewer().setContents(opd);
	}
	
	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		getGraphicalViewer().setEditPartFactory(new OPEditPartFactory());
	}
	
	@Override
	protected PaletteRoot getPaletteRoot() {
		return new OPEditorPalette(getModelFactory());
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		FileEditorInput input = (FileEditorInput) getEditorInput();
		IFile file = input.getFile();
		try {
			OPJsonWriter writer = new OPJsonWriter();
			String systemJson = writer.writeOPSystem(system).toString(); 
			file.setContents(new ByteArrayInputStream(systemJson.getBytes()), IFile.FORCE, monitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}	
		getCommandStack().markSaveLocation();
	}

	@Override
	protected void setInput(IEditorInput input) {
		super.setInput(input);
	}
	
	  @Override
	  public void commandStackChanged(EventObject event) {
	    firePropertyChange(PROP_DIRTY);
	    super.commandStackChanged(event);
	  }

	
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class type) {
		if(type.equals(IPropertySheetPage.class)) {
			if(propertyPage == null) {
				propertyPage = (UndoablePropertySheetPage)super.getAdapter(type);
				IPropertySourceProvider provider = new IPropertySourceProvider() {
					@Override
					public IPropertySource getPropertySource(Object object) {
						return null;//OPPropertySourceFactory.getPropertySource(object);
					}
				};
				UndoablePropertySheetEntry root = new UndoablePropertySheetEntry(getCommandStack());
				root.setPropertySourceProvider(provider);
				propertyPage.setRootEntry(root);
			}
			return propertyPage;
		}
		return super.getAdapter(type);
	}

	public OPModelFactory getModelFactory() {
		return modelFactory;
	}
}
